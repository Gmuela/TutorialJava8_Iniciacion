import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Supplier;

public class ShoppingCartTest {

    public static final int UP_TO = 10_000;
    public static final long CHARGE_LEVELX2 = 1_000L;
    private static CarritoDeLaCompra carritoCompra;

    @BeforeClass
    public static void setUp() {
        CarritoBuilder builder = new CarritoBuilder(CHARGE_LEVELX2,1000000L);
        builder.add(-1L);
        builder.addMultiple(CHARGE_LEVELX2,1000000L);
        carritoCompra = builder.build();
    }


    //@Test
    public void testAnyMatch() {

        System.out.println("anyMatch = "
                + testWith(() -> carritoCompra.detectarErrorAnyMatch()));
//
//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    @Test
    public void testAnyMatchParallel() {

        System.out.println("anyMatchParallel = "
                + testWith(()-> carritoCompra.detectarErrorAnyMatchParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    //@Test
    public void testFindAny() {

        System.out.println("findAny = " +
            + testWith(() -> carritoCompra.detectarErrorFindAny()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    @Test
    public void testFindAnyParallel() {

        System.out.println("findAnyParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindAnyParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    //@Test
    public void testFindFirst() {

        System.out.println("findFirst = "
            + testWith(() -> carritoCompra.detectarErrorFindFirst()) );

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    //@Test
    public void testFindFirstParallel() {

        System.out.println("findFirstParallel = "
            + testWith(() -> carritoCompra.detectarErrorFindFirstParallel()));

//        long counter = carritoCompra.getCounter();
//        System.out.print("Iteraciones anyMatch = " + counter);
//
//        carritoCompra.resetCounter();
    }

    private long testWith(Supplier<Boolean> method) {

        Boolean []errors = new Boolean[UP_TO];
        System.gc();
        System.out.println("Start----------------------");

        long start  = System.currentTimeMillis();

        for (int i = 0; i < UP_TO; i++) {
            try {
                errors[i] = method.get();
            }
            catch (Exception e) {
                //void
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("End----------------------");
        return end - start;
    }
}
