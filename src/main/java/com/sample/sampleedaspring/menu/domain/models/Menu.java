package com.sample.sampleedaspring.menu.domain.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
public class Menu {

    @Getter
    private final MenuId id;

    @Getter
    @NonNull
    private final String title;

    @Getter
    @NonNull
    private final MenuType menuType;

    @Getter
    @NonNull
    private final SupportedOption supportedOption;

    @Getter
    @NonNull
    private final Integer price;

    public Menu (
        @NonNull String title,
        @NonNull MenuType menuType,
        @NonNull SupportedOption supportedOption,
        @NonNull Integer price
        ) {
        this.id = null;
        this.title = title;
        this.menuType = menuType;
        this.supportedOption = supportedOption;
        this.price = price;
    }

    @Value
    public static class MenuId {
        private final Long value;
    }
}
