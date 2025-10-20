package org.upcy.simbia.dataprovider.client.cnpj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WsData{

    private List<Email> emails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Email {
        private String domain;
        private String ownership;
        private String address;
    }

}
