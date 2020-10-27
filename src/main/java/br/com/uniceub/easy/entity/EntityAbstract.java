package br.com.uniceub.easy.entity;

import java.io.Serializable;

public abstract class EntityAbstract<T> implements Serializable {

    private T id;

    public T getId(){
        return id;
    }

    public EntityAbstract(){}
}