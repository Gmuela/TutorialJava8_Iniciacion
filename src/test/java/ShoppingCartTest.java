import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Supplier;

public class ShoppingCartTest {

    public static final int UP_TO = 1;
    public static final Long LOAD_LEVELX2 = 100_000L;
    private static CarritoDeLaCompra carritoCompra;

    @BeforeClass
    public static void setUp() {
        CarritoBuilder builder = new CarritoBuilder(LOAD_LEVELX2,1000000L);
        builder.add(-1L);
        builder.addMultiple(LOAD_LEVELX2,1000000L);
        carritoCompra = builder.build();
    }

    @Test
    public void testImperative(){

//        carritoCompra.resetCounter();
        System.out.println("imperative = "
                + testWith(() -> carritoCompra.detectarError()));
//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones imperative = " + counter);
    }

    @Test
    public void testAnyMatch() {

//        carritoCompra.resetCounter();
        System.out.println("anyMatch = "
                + testWith(() -> carritoCompra.detectarErrorAnyMatch()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);

    }

    @Test
    public void testAnyMatchParallel() {

//        carritoCompra.resetCounter();
        System.out.println("anyMatchParallel = "
                + testWith(()-> carritoCompra.detectarErrorAnyMatchParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatchParallel = " + counter);

    }

    @Test
    public void testFindAny() {

//        carritoCompra.resetCounter();

        System.out.println("findAny = " +
            + testWith(() -> carritoCompra.detectarErrorFindAny()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones findAny = " + counter);
    }

    @Test
    public void testFindAnyParallel() {

//        carritoCompra.resetCounter();

        System.out.println("findAnyParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindAnyParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones findAnyParallel = " + counter);
    }

    @Test
    public void testFindFirst() {

//        carritoCompra.resetCounter();
        System.out.println("findFirst = "
            + testWith(() -> carritoCompra.detectarErrorFindFirst()) );

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones findFirst = " + counter);

    }

    @Test
    public void testFindFirstParallel() {

//        carritoCompra.resetCounter();
        System.out.println("findFirstParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindFirstParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones findFirstParallel = " + counter);

    }

    private long testWith(Supplier<Boolean> method) {

        System.gc();
        System.out.println("Start----------------------");

        long start  = System.currentTimeMillis();

        method.get();

        long end = System.currentTimeMillis();
        System.out.println("End----------------------");
        return end - start;
    }
}
