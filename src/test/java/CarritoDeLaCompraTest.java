import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.Assert;
import org.junit.Test;

public class CarritoDeLaCompraTest {



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
