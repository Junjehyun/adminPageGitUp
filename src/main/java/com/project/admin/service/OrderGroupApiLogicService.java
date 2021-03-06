package com.project.admin.service;

import com.project.admin.ifs.CrudInterface;
import com.project.admin.model.entity.OrderGroup;
import com.project.admin.model.network.Header;
import com.project.admin.model.network.request.OrderGroupApiRequest;
import com.project.admin.model.network.response.OrderGroupApiResponse;
import com.project.admin.repository.OrderGroupRepository;
import com.project.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {


    @Autowired
    private UserRepository userRepository;


    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {

        return Optional.ofNullable(request.getData())
                .map(body ->{
                    OrderGroup orderGroup = OrderGroup.builder()
                            .status(body.getStatus())
                            .orderType(body.getOrderType())
                            .revAddress(body.getRevAddress())
                            .revName(body.getRevName())
                            .paymentType(body.getPaymentType())
                            .totalPrice(body.getTotalPrice())
                            .totalQuantity(body.getTotalQuantity())
                            .orderAt(LocalDateTime.now())
                            .user(userRepository.getById(body.getUserId()))
                            .build();

                    return orderGroup;
                })
                .map(newOrderGroup -> baseRepository.save(newOrderGroup))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {

        OrderGroupApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(orderGroup -> {

                    orderGroup
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setRevAddress(body.getRevAddress())
                            .setRevName(body.getRevName())
                            .setPaymentType(body.getPaymentType())
                            .setTotalPrice(body.getTotalPrice())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setOrderAt(body.getOrderAt())
                            .setArrivalDate(body.getArriveDate())
                            .setUser(userRepository.getById(body.getUserId()))
                            ;

                    return orderGroup;
                })
                .map(changeOrderGroup -> baseRepository.save(changeOrderGroup))
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }


    public Header<OrderGroupApiResponse> response(OrderGroup orderGroup){

        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arriveDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();

        return Header.OK(body);

    }
}
