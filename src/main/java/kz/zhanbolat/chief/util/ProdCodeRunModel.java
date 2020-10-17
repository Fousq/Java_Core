package kz.zhanbolat.chief.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProdCodeRunModel {
    private Object instance;
    private List<Object> parameters;

    public ProdCodeRunModel(Object instance, List<Object> parameters) {
        this.instance = instance;
        this.parameters = parameters;
    }

    public ProdCodeRunModel(Object instance, Object... parameters) {
        this.instance = instance;
        this.parameters = Arrays.asList(parameters);
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public List<Object> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    public void add(Object param) {
        parameters.add(param);
    }

    public void remove(Object param) {
        parameters.remove(param);
    }
}
