package easy;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ConvertTemperatureTest {

    public double[] convertTemperature(double celsius) {
        BigDecimal num = BigDecimal.valueOf(celsius);

        return new double[] { num.add(BigDecimal.valueOf(273.15)).doubleValue(), num.multiply(BigDecimal.valueOf(1.8)).add(BigDecimal.valueOf(32)).doubleValue() };
    }

    @Test
    public void test1() {
//        System.out.println(Arrays.toString(convertTemperature(36.50)));

        assertArrayEquals(convertTemperature(36.50d), new double[] { 309.65000, 97.70000 }, 2);
    }

    @Test
    public void test2() {
        assertArrayEquals(convertTemperature(122.11d), new double[] { 395.26000, 251.79800 }, 3);
    }

}
