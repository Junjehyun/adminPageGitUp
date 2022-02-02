package com.project.admin.controller.api;

import com.project.admin.controller.CrudController;
import com.project.admin.model.entity.Item;
import com.project.admin.model.network.response.ItemApiRequest;
import com.project.admin.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class itemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {


}
