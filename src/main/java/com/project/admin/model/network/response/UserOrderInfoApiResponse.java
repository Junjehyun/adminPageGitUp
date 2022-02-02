package com.project.admin.model.network.response;

import com.project.admin.model.entity.OrderGroup;
import com.project.admin.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//사용자의 주문 정보를 조회하는 API Response
public class UserOrderInfoApiResponse {

    private UserApiResponse userApiResponse;

}
