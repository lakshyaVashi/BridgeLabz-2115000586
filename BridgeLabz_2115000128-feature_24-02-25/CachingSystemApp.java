import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveComputationManager {
    private final Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long computeFactorial(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing factorial for: " + number);
        long result = factorial(number);
        cache.put(number, result);
        return result;
    }

    private long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

public class CachingSystemApp {
    public static void main(String[] args) throws Exception {
        ExpensiveComputationManager manager = new ExpensiveComputationManager();

        Method computeMethod = ExpensiveComputationManager.class.getDeclaredMethod("computeFactorial", int.class);
        if (computeMethod.isAnnotationPresent(CacheResult.class)) {
            System.out.println("Result: " + manager.computeFactorial(10));
            System.out.println("Result: " + manager.computeFactorial(5));
            System.out.println("Result: " + manager.computeFactorial(10)); 
        }
    }
}
