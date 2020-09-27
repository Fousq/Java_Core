package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.annotation.UseStackOnly;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractProcessor {
    @UseStackOnly
    protected List<String> toCook;

    public AbstractProcessor(List<String> toCook) {
        this.toCook = toCook;
    }

    public AbstractProcessor(String... toCook) {
        this.toCook = Arrays.asList(toCook);
    }
}
