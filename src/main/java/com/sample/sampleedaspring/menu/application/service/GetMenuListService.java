package com.sample.sampleedaspring.menu.application.service;

import com.sample.sampleedaspring.menu.application.in.GetMenuListQuery;
import com.sample.sampleedaspring.menu.application.in.dto.MenuResponseDto;
import com.sample.sampleedaspring.menu.application.out.MenuPort;
import com.sample.sampleedaspring.menu.domain.models.Menu;
import com.sample.sampleedaspring.menu.domain.models.MenuType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetMenuListService implements GetMenuListQuery {

//    private final MenuPort menuPort;

    @Override
    public List<MenuResponseDto> getAllMenuList() {
//        List<Menu> menuList = menuPort.getAllMenuList();
        return null;
    }

    @Override
    public List<MenuResponseDto> getMenuList(MenuType menuType) {
        return null;
    }
}
