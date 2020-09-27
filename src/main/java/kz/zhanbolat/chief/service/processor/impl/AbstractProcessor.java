package kz.zhanbolat.chief.service.processor.impl;

import kz.zhanbolat.chief.util.ReflectionClassPrinter;
import kz.zhanbolat.chief.util.impl.ReflectionClassPrinterImpl;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractProcessor {
    protected static final ReflectionClassPrinter printer = new ReflectionClassPrinterImpl();
    protected List<String> toCook;

    public AbstractProcessor(List<String> toCook) {
        this.toCook = toCook;
        printer.print(this.getClass());
    }

    public AbstractProcessor(String... toCook) {
        this.toCook = Arrays.asList(toCook);
        printer.print(this.getClass());
    }
}
