package com.sample.sampleedaspring.menu.adapter.in.rest;

import com.sample.sampleedaspring.menu.application.in.GetMenuListQuery;
import com.sample.sampleedaspring.menu.application.in.dto.MenuResponseDto;
import com.sample.sampleedaspring.menu.application.service.GetMenuListServiceSample;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GetMenuController {

    private final GetMenuListQuery getMenuListQuery;

    public GetMenuController (final GetMenuListServiceSample getMenuListServiceSample) {
        this.getMenuListQuery = getMenuListServiceSample;

    }

    @GetMapping(path = "/list")
    List<MenuResponseDto> getMenu() {
        return getMenuListQuery.getAllMenuList();
    }
}
