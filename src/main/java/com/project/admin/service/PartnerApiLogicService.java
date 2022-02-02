package com.project.admin.service;

import com.project.admin.model.entity.Partner;
import com.project.admin.model.network.Header;
import com.project.admin.model.network.request.PartnerApiRequest;
import com.project.admin.model.network.response.PartnerApiReponse;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiReponse, Partner> {

    @Override
    public Header<PartnerApiReponse> create(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiReponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<PartnerApiReponse> update(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<PartnerApiReponse> response(Partner partner){

        PartnerApiReponse body = PartnerApiReponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryID(partner.getCategory().getId())
                .build();

        return Header.OK(body);
    }
}
