import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.Assert;
import org.junit.Test;

public class CarritoDeLaCompraTest {
    
    private final Long TOTAL_SIZE = 20000000L;
    private final Long NUMBER_ADD = 1000000L;
    

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

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNull(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarError());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullAnyMatch(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorAnyMatch());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullFindAny(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindAny());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullFindFirst(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindFirst());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullAnyMatchParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorAnyMatchParallel());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullFindAnyParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindAnyParallel());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNullFindFirstParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(null);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindFirstParallel());

    }
}
