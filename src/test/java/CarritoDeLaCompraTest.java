import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.Assert;
import org.junit.Test;

public class CarritoDeLaCompraTest {

    //@Test
    public void shouldReturnTheCountOfAllItems() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(30L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(30, carritoDeLaCompra.contarNumeroProductos());
    }

    //@Test
    public void shouldCalculateTotalPrice() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L,5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotal());

    }

    //@Test
    public void shouldCalculateTotalPriceLambda() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L, 5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotalLambda());

    }

    //@Test
    public void shouldCalculateTotalPriceRefMethod() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L,5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotalRefMethod());

    }

    //@Test
    public void shouldCalculateTotalDiscount() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(20L,100L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(100L, carritoDeLaCompra.calcularDescuentoTotal(100));

    }

    //@Test
    public void shouldCalculateTotalDiscountLambda() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(20L,100L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(100, carritoDeLaCompra.calcularDescuentoTotalLambda(100));

    }

    //@Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNull(){

        CarritoBuilder builder = new CarritoBuilder(20L,100L);
        builder.add(null);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarError();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullAnyMatch(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorAnyMatch();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullFindAny(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        builder.addMultiple(20000000L,1000000L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorFindAny();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullFindFirst(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        builder.addMultiple(20000000L,1000000L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorFindFirst();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullAnyMatchParallel(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorAnyMatchParallel();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullFindAnyParallel(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        builder.addMultiple(20000000L,1000000L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorFindAnyParallel();

    }

    @Test(expected = RuntimeException.class)
    public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNullFindFirstParallel(){

        CarritoBuilder builder = new CarritoBuilder(20000000L,1000000L);
        builder.add(null);
        builder.addMultiple(20000000L,1000000L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.detectarErrorFindFirstParallel();

    }
}
