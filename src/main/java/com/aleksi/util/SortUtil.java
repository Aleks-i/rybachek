package com.aleksi.util;

import org.springframework.data.domain.Sort;

public class SortUtil {
    public static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");
    public static final Sort SORT_PRICE_ASC = Sort.by(Sort.Direction.ASC, "price");
    public static final Sort SORT_PRICE_DESC = Sort.by(Sort.Direction.DESC, "price");

    private SortUtil() {
    }
}