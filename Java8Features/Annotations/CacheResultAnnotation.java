
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}


class ExpensiveCalculator {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Fetching from cache...");
            return cache.get(n);
        }
        System.out.println("Computing...");
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}


public class CacheResultAnnotation {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calc = new ExpensiveCalculator();

        System.out.println(calc.computeSquare(5)); 
        System.out.println(calc.computeSquare(5)); 
    }
}
