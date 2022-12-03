import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfacesTest {


    @Test
    public void shouldReturnValidCheckPrimePredicate(){
        Predicate<Integer> predicate = FunctionalInterfaces.CheckPrimePredicate();
        assertEquals(predicate.test(5), true);
    }

    @Test
    public void shouldReturnValidGeneratorConsumer(){
        Consumer<Integer> consumer = FunctionalInterfaces.GeneratorConsumer();
        consumer.accept(10);
    }

    @Test
    public void shouldReturnValidDayOfWeekSupplier(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        Consumer<Integer> consumer = FunctionalInterfaces.GeneratorConsumer();
        consumer.accept(10);
        assertEquals("0123456789", outContent.toString());

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }

    @Test
    public void shouldReturnValidRoundUpFunction(){
        var roundUpFunction = FunctionalInterfaces.RoundUpFunction();
        assertEquals(15, roundUpFunction.apply(15.2));
    }

    @Test
    public void shouldReturnValidFibonacciUnaryOperator(){
        var fibonacciUnaryOperator = FunctionalInterfaces.FibonacciUnaryOperator();
        assertEquals(55,  fibonacciUnaryOperator.apply(10));
    }


}
