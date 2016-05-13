package com.autentia;

import java.util.ArrayList;

public class CarritoBuilder {

    ArrayList<Long> precios = new ArrayList<Long>();

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
