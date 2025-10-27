package org.upcy.simbia.mapper;

import org.upcy.simbia.api.post.input.PostRequestDto;
import org.upcy.simbia.api.post.output.PostResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

import java.util.Date;

public class PostMapper extends AbstractMapper<Post, PostRequestDto, PostResponseDto> {

    @Override
    public Post toEntity(PostRequestDto requestDto) {
        return Post.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .image(requestDto.getImage())
                .quantity(requestDto.getQuantity())
                .price(requestDto.getPrice())
                .measureUnit(requestDto.getMeasureUnit())
                .classification(requestDto.getClassification())
                .publicationDate(new Date())
                .status("1")
                .active("1")
                .build();
    }

    @Override
    public PostResponseDto toResponse(Post entity) {
        return PostResponseDto.builder()
                .idPost(entity.getId())
                .productCategory(entity.getIdProductCategory())
                .industryName(entity.getIdIndustry().getIndustryName())
                .industryCnpj(entity.getIdIndustry().getCnpj())
                .industryImage(entity.getIdIndustry().getImage())
                .employeeName(entity.getIdEmployee().getEmployeeName())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .measureUnit(entity.getMeasureUnit())
                .classification(entity.getClassification())
                .image(entity.getImage())
                .publicationDate(entity.getPublicationDate())
                .status(entity.getStatus())
                .build();
    }
}
