package com.sample.sampleedaspring.menu.application.in;

import com.sample.sampleedaspring.menu.application.in.dto.MenuResponseDto;
import com.sample.sampleedaspring.menu.domain.models.MenuType;

import java.util.List;

public interface GetMenuListQuery {
    List<MenuResponseDto> getAllMenuList();

    List<MenuResponseDto> getMenuList(MenuType menuType);
}
