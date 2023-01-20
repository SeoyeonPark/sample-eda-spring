package com.sample.sampleedaspring.menu.application.in.dto;

import com.sample.sampleedaspring.menu.domain.models.SupportedOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class MenuResponseDto {
    @Getter
    private String menuId;

    @Getter
    private String menuName;

    @Getter
    private String menuType;

    @Getter
    private SupportedOption supportedOption;

    @Getter
    private Integer orderCount;

    @Getter
    private Integer price;

}
