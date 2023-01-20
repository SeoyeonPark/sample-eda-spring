package com.sample.sampleedaspring.menu.application.out;

import com.sample.sampleedaspring.menu.application.in.dto.MenuResponseDto;
import com.sample.sampleedaspring.menu.domain.models.Menu;

import java.util.List;

public interface MenuPort {
    List<Menu> getAllMenuList();
}
