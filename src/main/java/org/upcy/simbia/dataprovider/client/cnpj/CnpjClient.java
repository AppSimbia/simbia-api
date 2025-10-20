package org.upcy.simbia.dataprovider.client.cnpj;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.upcy.simbia.dataprovider.client.cnpj.dto.WsData;

@FeignClient(name = "cnpj-client", url = "${api.integration.url}")
public interface CnpjClient {

    @GetMapping("cnpj/{cnpj}")
    WsData getDomainByCnpj(@PathVariable("cnpj") String cnpj);
}
