import com.autentia.CarritoBuilder;
import com.autentia.CarritoDeLaCompra;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by dgomezg on 17/05/16.
 */
public class ShoppingCartTest {

    public static final int UP_TO = 10_000;
    private static CarritoDeLaCompra shoppingCart;

    @BeforeClass
    public static void setUp() {
        CarritoBuilder builder = new CarritoBuilder(1_000_000L,1000000L);
        builder.add(null);
        builder.addMultiple(200_000L,1000000L);
        shoppingCart = builder.build();
    }


    @Test
    public void testAnyMatch() {
        long time = testWith(() -> shoppingCart.detectarErrorAnyMatch());
        System.out.println("anyMatch = " + time);
    }

    @Test
    public void testAnyMatchParallel() {
        System.out.println("anyMatchParallel = "
                + testWith(()->shoppingCart.detectarErrorAnyMatchParallel()));
    }

    @Test
    public void testFindAny() {
        System.out.println("findAny = " +
            + testWith(() -> shoppingCart.detectarErrorFindAny()));
    }

    @Test
    public void testFindAnyParallel() {
        System.out.println("findAnyParallel = "
            + testWith(() -> shoppingCart.detectarErrorFindAnyParallel()));
    }

    @Test
    public void testFindFirst() {
        System.out.println("findFirst = "
            + testWith(() -> shoppingCart.detectarErrorFindFirst()) );
    }

    @Test
    public void testFindFirstParallel() {
        System.out.println("findFirstParallel = "
            + testWith(() -> shoppingCart.detectarErrorFindFirstParallel()));
    }

    private long testWith(Supplier<Boolean> method) {
        Boolean []errors = new Boolean[UP_TO];
        System.gc();
        System.out.println("Start----------------------");
        long start  = System.currentTimeMillis();
        for (int i = 0; i < UP_TO; i++) {
            try {
                errors[i] = method.get();
            } catch (Exception e) {}//won't happen
        }
        long end = System.currentTimeMillis();
        System.out.println("End----------------------");
        System.out.println(errors);
        return end - start;
    }
}
