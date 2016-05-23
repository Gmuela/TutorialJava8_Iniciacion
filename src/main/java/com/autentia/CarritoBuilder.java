package com.autentia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarritoBuilder {

    //Collection<Long> precios = new CopyOnWriteArrayList<>();
    List<Long> precios = new ArrayList<>();

    //List<Long> precios = new LinkedList<>();

    public CarritoBuilder(Long size){

        for(int i = 0; i < size; i++){
            Double random = Math.random()*100+1;
            precios.add(random.longValue());
        }
    }

    public CarritoBuilder(Long size, Long value){

        for(int i = 0; i < size; i++){
            precios.add(value);
        }
    }

    public CarritoDeLaCompra build(){

        return new CarritoDeLaCompra(this.precios);
    }

    public CarritoBuilder add(Long nuevoValor){
        precios.add(nuevoValor);
        return this;
    }

    public CarritoBuilder addMultiple(Long size, Long value){
        for(int i = 0; i < size; i++){
            precios.add(value);
        }

        return this;
    }
}
