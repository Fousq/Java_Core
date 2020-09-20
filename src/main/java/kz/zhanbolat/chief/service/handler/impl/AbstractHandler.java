package kz.zhanbolat.chief.service.handler.impl;

import kz.zhanbolat.chief.service.handler.CookHandler;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractHandler {
    protected CookHandler cookHandler;
    protected List<String> toCook;

    public AbstractHandler(List<String> toCook) {
        this.toCook = toCook;
    }

    public AbstractHandler(String... toCook) {
        this.toCook = Arrays.asList(toCook);
    }
}
