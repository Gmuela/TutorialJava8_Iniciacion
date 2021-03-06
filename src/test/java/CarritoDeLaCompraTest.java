import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.Assert;
import org.junit.Test;

public class CarritoDeLaCompraTest {
    
    private final Long TOTAL_SIZE = 20_000_000L;
    private final Long NUMBER_ADD = 1000000L;
    

    @Test
    public void shouldReturnTheCountOfAllItems() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(30L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(30, carritoDeLaCompra.contarNumeroProductos());
    }

    @Test
    public void shouldCalculateTotalPrice() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L,5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotal());

    }

    @Test
    public void shouldCalculateTotalPriceLambda() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L, 5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotalLambda());

    }

    @Test
    public void shouldCalculateTotalPriceRefMethod() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(60L,5L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300L, carritoDeLaCompra.calcularPrecioTotalRefMethod());

    }

    @Test
    public void shouldCalculateTotalDiscount() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(20L,100L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(100L, carritoDeLaCompra.calcularDescuentoTotal(100));

    }

    @Test
    public void shouldCalculateTotalDiscountLambda() throws Exception {

        CarritoBuilder builder = new CarritoBuilder(20L,100L);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(100, carritoDeLaCompra.calcularDescuentoTotalLambda(100));

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumber(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarError());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberAnyMatch(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        carritoDeLaCompra.resetCounter();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorAnyMatch());
    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindAny(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindAny());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindFirst(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindFirst());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberAnyMatchParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorAnyMatchParallel());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindAnyParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindAnyParallel());

    }

    @Test
    public void shouldDetectErrorAndReturnTrueWhenAPriceIsNegativeNumberFindFirstParallel(){

        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE,NUMBER_ADD);
        builder.add(-1L);
        builder.addMultiple(TOTAL_SIZE,NUMBER_ADD);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertTrue(carritoDeLaCompra.detectarErrorFindFirstParallel());

    }
}
