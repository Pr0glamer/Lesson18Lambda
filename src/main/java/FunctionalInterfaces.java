import java.time.DayOfWeek;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Predicate<Integer> predicate = FunctionalInterfaces.CheckPrimePredicate();
        System.out.println(predicate.test(6));
        Consumer<Integer> consumer = FunctionalInterfaces.GeneratorConsumer();
        consumer.accept(10);
        Supplier<DayOfWeek> supplier = FunctionalInterfaces.DayOfWeekSupplier();
        System.out.println(supplier.get());
        var roundUpFunction = FunctionalInterfaces.RoundUpFunction();
        System.out.println(roundUpFunction.apply(15.2));
        var fibonacciUnaryOperator = FunctionalInterfaces.FibonacciUnaryOperator();
        System.out.println(fibonacciUnaryOperator.apply(10));


    }

    public static Predicate<Integer> CheckPrimePredicate() {
        return numberToCheck -> {
            int remainder;
            for (int i = 2; i <= numberToCheck / 2; i++) {
                remainder = numberToCheck % i;
                if (remainder == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public static Consumer<Integer> GeneratorConsumer() {
        return edge -> {
            for(int i = 0; i < edge; i++){
                System.out.print(i);
            }
        };
    }

    public static Supplier<DayOfWeek> DayOfWeekSupplier() {
        return () -> {
            Random random = new Random();
            int min = 0;
            int max = 6;
            int randomDay = random.nextInt((max - min) + 1) + min;
            return DayOfWeek.of(randomDay);
        };
    }
    public static Function<Double, Long> RoundUpFunction() {
        return Math::round;
    }

    public static UnaryOperator<Integer> FibonacciUnaryOperator() {
        return n -> {
            int a = 0, b = 1, c;
            if (n == 0)
                return a;
            for (int i = 2; i <= n; i++)
            {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        };
    }


}
