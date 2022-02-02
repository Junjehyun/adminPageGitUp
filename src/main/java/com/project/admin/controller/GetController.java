package com.project.admin.controller;

import com.project.admin.model.SearchParam;
import com.project.admin.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Localhost:8080/api

public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // Localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") // Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){

        String password = "bbbb";

        System.out.println("id :"+id);
        System.out.println("pwd :"+pwd);

        return id+pwd;
    }

    // Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.print(searchParam.getAccount());
        System.out.print(searchParam.getEmail());
        System.out.print(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        // {"resultCode: "OK", 'description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
