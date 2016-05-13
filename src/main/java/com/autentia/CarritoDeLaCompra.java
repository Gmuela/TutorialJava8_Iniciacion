package com.autentia;

import java.util.Collection;

public class CarritoDeLaCompra<T extends Long> {

    private Collection<T> precios;

    public CarritoDeLaCompra(Collection<T> precios) {

        this.precios = precios;
    }

    public int calcularPrecioTotal() {

        int precioTotal = 0;

        for (Long precio : precios) {

            precioTotal += precio;

        }
        return precioTotal;
    }

    public int contarNumeroProductos() {

        return precios.size();
    }

    public int calcularPrecioTotalLambda() {

        int precioTotal = this.precios.stream().mapToInt(precio -> precio.intValue()).sum();


        return precioTotal;
    }

    public int calcularPrecioTotalRefMethod() {

        int precioTotal = this.precios.stream().mapToInt(Long::intValue).sum();


        return precioTotal;
    }

    public long calcularDescuentoTotal(int cantidadConDescuento) {

        long descuentoTotal = 0;

        for (Long precio : precios) {

            if (precio >= cantidadConDescuento) {

                descuentoTotal += (cantidadConDescuento * 5) / 100;
            }
        }

        return descuentoTotal;
    }

    public long calcularDescuentoTotalLambda(int cantidadConDescuento) {

        long descuentoTotal = 0;

        Long numeroDeDescuentos = this.precios.stream().filter(precio -> precio.intValue() >= cantidadConDescuento).count();

        descuentoTotal = (cantidadConDescuento * 5 / 100) * numeroDeDescuentos;

        return descuentoTotal;
    }

    public void detectarError() {

        for (Long precio : precios) {

            if (precio == null) {

                throw new RuntimeException("Precio erróneo detectado");
            }
        }
    }

    public void detectarErrorAnyMatch() {

        if (this.precios.stream().anyMatch(precio -> precio == null)) {

            throw new RuntimeException("Precio erróneo detectado");
        }
    }

    public void detectarErrorFindAny() {

        this.precios.stream().filter(precio -> precio == null).findAny().ifPresent(nulo -> {
            throw new RuntimeException("Precio erróneo detectado");
        });
    }

    public void detectarErrorFindFirst() {

        this.precios.stream().filter(precio -> precio == null).findFirst().ifPresent(nulo -> {
            throw new RuntimeException("Precio erróneo detectado");
        });
    }

    public void detectarErrorAnyMatchParallel() {

        if (this.precios.parallelStream().anyMatch(precio -> precio == null)) {

            throw new RuntimeException("Precio erróneo detectado");
        }
    }

    public void detectarErrorFindAnyParallel() {

        this.precios.parallelStream().filter(precio -> precio == null).findAny().ifPresent(nulo -> {
            throw new RuntimeException("Precio erróneo detectado");
        });
    }

    public void detectarErrorFindFirstParallel() {

        this.precios.parallelStream().filter(precio -> precio == null).findFirst().ifPresent(nulo -> {
            throw new RuntimeException("Precio erróneo detectado");
        });
    }

}
