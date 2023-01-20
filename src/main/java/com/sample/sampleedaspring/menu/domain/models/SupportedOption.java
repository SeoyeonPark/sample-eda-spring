package com.sample.sampleedaspring.menu.domain.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Set;

@Value
@RequiredArgsConstructor
public class SupportedOption {

    @Getter
    @NonNull
    private Set<HotIced> hotIced;
}
