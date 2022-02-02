package com.project.admin.controller.api;

import com.project.admin.controller.CrudController;
import com.project.admin.model.entity.OrderGroup;
import com.project.admin.model.network.request.OrderGroupApiRequest;
import com.project.admin.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
