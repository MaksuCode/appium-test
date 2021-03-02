package tr.com.getir.tests.operations;

import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tr.com.getir.BaseTest;

import java.util.Random;
import java.util.stream.Stream;

public class AdditionTest extends BaseTest {


    @ParameterizedTest
    @MethodSource("provideTwoNumbers")
    public void add_two_numbers(int[] numbers){
        int result = calculator.add(numbers);
        Assertions.assertEquals(countOfNumbers(numbers),result);
    }

    @ParameterizedTest
    @MethodSource("provideNumberArrayForTest")
    public void add_more_than_two_numbers(int[] numbers){
        int result =calculator.add(numbers);
        Assertions.assertEquals(result , countOfNumbers(numbers));
    }

    @ParameterizedTest
    @MethodSource("provideTwoDigitNumbers")
    public void add_two_digit_numbers(int[] numbers){
        int result =calculator.add(numbers);
        Assertions.assertEquals(result , countOfNumbers(numbers));
    }

    private static int countOfNumbers(int[] numbers){
        int sum = 0 ;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }



}

