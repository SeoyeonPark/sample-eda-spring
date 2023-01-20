package com.sample.sampleedaspring.menu.application.in.dto;

import com.sample.sampleedaspring.menu.domain.models.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {
    public MenuResponseDto mapToDto(Menu menu) {
        return MenuResponseDto.builder()
                .menuId(menu.getId() == null ? "" : menu.getId().getValue().toString())
                .menuName(menu.getTitle())
                .menuType(menu.getMenuType().name())
                .supportedOption(menu.getSupportedOption())
                .orderCount(1)
                .price(menu.getPrice())
                .build();
    }
}
