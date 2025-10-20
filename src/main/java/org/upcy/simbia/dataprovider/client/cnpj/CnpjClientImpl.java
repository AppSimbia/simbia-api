package org.upcy.simbia.dataprovider.client.cnpj;

import org.upcy.simbia.dataprovider.client.cnpj.dto.WsData;
import org.springframework.stereotype.Component;
import org.upcy.simbia.dataprovider.client.RobustClient;

@Component
public class CnpjClientImpl extends RobustClient implements CnpjClient {

    private static final String CNPJ_CLIENT_NAME = "cnpj";
    private final CnpjClient cnpjClient;

    public CnpjClientImpl(CnpjClient cnpjClient) {
        super(CNPJ_CLIENT_NAME);
        this.cnpjClient = cnpjClient;
    }

    @Override
    public WsData getDomainByCnpj(String cnpj) {
        return super.robustCall(() -> cnpjClient.getDomainByCnpj(cnpj));
    }
}
