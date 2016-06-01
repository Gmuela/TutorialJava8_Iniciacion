import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Supplier;

public class ShoppingCartTest {

    public static final Long LOAD_LEVELX2 = 100_000L;
    private static CarritoDeLaCompra carritoCompra;

    //----------------------------------------------------------------//
    //-------NO OLVIDES LOS COMANDOS EN RUN/DEBUG CONFIGURATION-------//
    //--------------------(-Xms4092m -XX:+PrintGC)--------------------//
    //----------------------------------------------------------------//

    @BeforeClass
    public static void setUp() {
        CarritoBuilder builder = new CarritoBuilder(LOAD_LEVELX2, 1000000L);
        builder.add(-1L);
        builder.addMultiple(LOAD_LEVELX2, 1000000L);
        carritoCompra = builder.build();
    }

    @Test
    public void testImperative() {

        System.out.println("imperative = "
                + testWith(() -> carritoCompra.detectarError()));
    }

    @Test
    public void testAnyMatch() {

        System.out.println("anyMatch = "
                + testWith(() -> carritoCompra.detectarErrorAnyMatch()));

    }

    @Test
    public void testAnyMatchParallel() {

        System.out.println("anyMatchParallel = "
                + testWith(() -> carritoCompra.detectarErrorAnyMatchParallel()));
    }

    @Test
    public void testFindAny() {


        System.out.println("findAny = " +
                +testWith(() -> carritoCompra.detectarErrorFindAny()));
    }

    @Test
    public void testFindAnyParallel() {

        System.out.println("findAnyParallel = "
                + testWith(() -> carritoCompra.detectarErrorFindAnyParallel()));
    }

    @Test
    public void testFindFirst() {

        System.out.println("findFirst = "
                + testWith(() -> carritoCompra.detectarErrorFindFirst()));

    }

    @Test
    public void testFindFirstParallel() {

        System.out.println("findFirstParallel = "
                + testWith(() -> carritoCompra.detectarErrorFindFirstParallel()));


    }

    private long testWith(Supplier<Boolean> method) {

        System.gc();
        System.out.println("Start----------------------");

        long start = System.currentTimeMillis();

        method.get();

        long end = System.currentTimeMillis();
        System.out.println("End----------------------");
        return end - start;
    }

    //---------------------------------------------------------//
    //---------------------ITERACIONES-------------------------//
    //---------------------------------------------------------//

    @Test
    public void testImperativeIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarError());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones imperative = " + counter);
    }

    @Test
    public void testAnyMatchIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorAnyMatch());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones anyMatch = " + counter);

    }

    @Test
    public void testAnyMatchParallelIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorAnyMatchParallel());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones anyMatchParallel = " + counter);
    }

    @Test
    public void testFindAnyIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorFindAny());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones findAny = " + counter);
    }

    @Test
    public void testFindAnyParallelIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorFindAnyParallel());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones findAnyParallel = " + counter);
    }

    @Test
    public void testFindFirstIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorFindFirst());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones findFirst = " + counter);
    }

    @Test
    public void testFindFirstParallelIterations() {

        carritoCompra.resetCounter();
        testWithIterations(() -> carritoCompra.detectarErrorFindFirstParallel());
        long counter = carritoCompra.getCounter();
        System.out.println("Iteraciones findFirstParallel = " + counter);
    }

    private void testWithIterations(Supplier<Boolean> method) {
        method.get();
    }
}
