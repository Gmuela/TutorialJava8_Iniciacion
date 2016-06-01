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
                + testWith(()-> carritoCompra.detectarErrorAnyMatchParallel()));
    }

    @Test
    public void testFindAny() {


        System.out.println("findAny = " +
            + testWith(() -> carritoCompra.detectarErrorFindAny()));
    }

    @Test
    public void testFindAnyParallel() {

        System.out.println("findAnyParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindAnyParallel()));
    }

    @Test
    public void testFindFirst() {

        System.out.println("findFirst = "
            + testWith(() -> carritoCompra.detectarErrorFindFirst()) );

    }

    @Test
    public void testFindFirstParallel() {

        System.out.println("findFirstParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindFirstParallel()));


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


    /*****************************************
     @Test
    public void testImperative(){

    carritoCompra.resetCounter();
    //        System.out.println("imperative = "
    testWith(() -> carritoCompra.detectarError());
    long counter = carritoCompra.getCounter();
    System.out.println("Iteraciones imperative = " + counter);
    }

     @Test
     public void testAnyMatch() {

     carritoCompra.resetCounter();
     //        System.out.println("anyMatch = "
     testWith(() -> carritoCompra.detectarErrorAnyMatch());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones anyMatch = " + counter);

     }

     @Test
     public void testAnyMatchParallel() {

     carritoCompra.resetCounter();
     //        System.out.println("anyMatchParallel = "
     testWith(()-> carritoCompra.detectarErrorAnyMatchParallel());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones anyMatchParallel = " + counter);

     }

     @Test
     public void testFindAny() {

     carritoCompra.resetCounter();

     //        System.out.println("findAny = " +
     testWith(() -> carritoCompra.detectarErrorFindAny());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones findAny = " + counter);
     }

     @Test
     public void testFindAnyParallel() {

     carritoCompra.resetCounter();

     //        System.out.println("findAnyParallel = "
     testWith(() -> carritoCompra.detectarErrorFindAnyParallel());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones findAnyParallel = " + counter);
     }

     @Test
     public void testFindFirst() {

     carritoCompra.resetCounter();
     //        System.out.println("findFirst = "
     testWith(() -> carritoCompra.detectarErrorFindFirst());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones findFirst = " + counter);

     }

     @Test
     public void testFindFirstParallel() {

     carritoCompra.resetCounter();
     //        System.out.println("findFirstParallel = "
     testWith(() -> carritoCompra.detectarErrorFindFirstParallel());

     long counter = carritoCompra.getCounter();
     System.out.println("Iteraciones findFirstParallel = " + counter);

     }

     private long testWith(Supplier<Boolean> method) {

     System.gc();
     //        System.out.println("Start----------------------");

     long start  = System.currentTimeMillis();

     method.get();

     long end = System.currentTimeMillis();
     //        System.out.println("End----------------------");
     return end - start;
     }
     */
}
