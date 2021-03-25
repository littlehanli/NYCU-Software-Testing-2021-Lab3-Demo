import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters(){
        return Stream.of(
                arguments(new int[]{1, 3, 2, 4}, new int[]{1, 2, 3, 4}),
                arguments(new int[]{5, 11, 9, 20, 35}, new int[]{5, 9, 11, 20, 35}),
                arguments(new int[]{19, 2, 8, 28}, new int[]{2, 8, 19, 28}),
                arguments(new int[]{17, 3, 40, 22, 11}, new int[]{3, 11, 17, 22, 40}),
                arguments(new int[]{-3, 6, -7, 8, -1, 10}, new int[]{-7, -3, -1, 6, 8, 10})
        );
    }
    @ParameterizedTest
    @MethodSource("getParameters")
    public void parametersizedTest(int[] input, int[] expect){
        PriorityQueue pqInput = new PriorityQueue();
        for(int e : input){
            pqInput.offer(e);
        }
        for(int e : expect){
            assertEquals(e, pqInput.poll());
        }
    }

    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void offerTest(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}
