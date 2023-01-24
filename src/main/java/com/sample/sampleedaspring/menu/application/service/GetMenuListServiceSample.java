package com.sample.sampleedaspring.menu.application.service;

import com.sample.sampleedaspring.menu.application.in.GetMenuListQuery;
import com.sample.sampleedaspring.menu.application.in.dto.MenuMapper;
import com.sample.sampleedaspring.menu.application.in.dto.MenuResponseDto;
import com.sample.sampleedaspring.menu.domain.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetMenuListServiceSample implements GetMenuListQuery {

    private final MenuMapper mapper;

    @Override
    public List<MenuResponseDto> getAllMenuList() {
        List<Menu> temp = List.of(
                new Menu(
                        new Menu.MenuId(1L),
                        "아메리카노",
                    MenuType.COFFEE,
                    new SupportedOption(
                            Set.of(HotIced.HOT, HotIced.ICED)
                    ), 5000),
                new Menu(
                        new Menu.MenuId(2L),
                        "카페라떼",
                        MenuType.COFFEE,
                        new SupportedOption(
                                Set.of(HotIced.HOT, HotIced.ICED)
                        ), 5300),
                new Menu(
                        new Menu.MenuId(3L),
                        "카푸치노",
                        MenuType.COFFEE,
                        new SupportedOption(
                                Set.of(HotIced.HOT, HotIced.ICED)
                        ), 5500),
                new Menu(
                        new Menu.MenuId(4L),
                        "마끼야또",
                        MenuType.COFFEE,
                        new SupportedOption(
                                Set.of(HotIced.HOT, HotIced.ICED)
                        ), 5700)
        );

        return temp.stream()
                .map(menu -> mapper.mapToDto(menu))
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuResponseDto> getMenuList(MenuType menuType) {
        return null;
    }
}
