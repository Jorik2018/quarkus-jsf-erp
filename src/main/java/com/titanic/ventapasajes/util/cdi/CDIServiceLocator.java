package com.titanic.ventapasajes.util.cdi;

import jakarta.enterprise.inject.Instance;
import io.quarkus.arc.Arc;

public class CDIServiceLocator {

    public static <T> T getBean(Class<T> clazz) {
        Instance<T> instance = Arc.container().select(clazz);
        if (instance.isUnsatisfied()) {
            return null;
        }
        return instance.get();
    }

}
