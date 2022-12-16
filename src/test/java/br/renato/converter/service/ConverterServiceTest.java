package br.renato.converter.service;

import br.renato.converter.interactors.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.renato.converter.utils.ConstantUtil.CELSIUS;
import static br.renato.converter.utils.ConstantUtil.FAHRENHEIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link ConverterService} service class.
 */
@ExtendWith(SpringExtension.class)
class ConverterServiceTest {

    @InjectMocks
    private ConverterService converterService;

    /**
     * Tests the {@link ConverterService#convert(Double, String)} method for converting temperatures from Celsius to Fahrenheit.
     * The test should verify that the conversion is correct for a temperature of 0 degrees Celsius.
     */
    @Test
    void testConvertFromCelsiusToFahrenheit() {
        Double temperature = 0.0;
        String expectedResult = "32,00 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    /**
     * Tests the {@link ConverterService#convert(Double, String)} method for converting temperatures from Fahrenheit to Celsius.
     * The test should verify that the conversion is correct for a temperature of 32 degrees Fahrenheit.
     */
    @Test
    void testConvertFromFahrenheitToCelsius() {
        Double temperature = 32.0;
        String expectedResult = "0,00 C°";
        String result = this.converterService.convert(temperature, FAHRENHEIT);
        assertEquals(expectedResult, result);
    }

    /**
     * Tests the {@link ConverterService#convert(Double, String)} method for converting negative temperatures from Celsius to Fahrenheit.
     * The test should verify that the conversion is correct for a temperature of -40 degrees Celsius.
     */
    @Test
    void testConvertNegativeTemperatureFromCelsiusToFahrenheit() {
        Double temperature = -40.0;
        String expectedResult = "-40,00 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    /**
     * Tests the {@link ConverterService#convert(Double, String)} method for converting invalid temperatures from Celsius to Fahrenheit.
     * The test should verify that the conversion returns an error message for a temperature that is outside the valid range of -100 to 100 degrees Celsius.
     */
    @Test
    void testConvertInvalidTemperatureFromCelsiusToFahrenheit() {
        Double temperature = 1000000.0;
        String expectedResult = "Error converting temperature: Temperature must be between -100 and 100";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    /**
     * Tests the {@link ConverterService#convert(Double, String)} method for converting temperatures with two decimal places from Celsius to Fahrenheit.
     * The test should verify that the conversion is correct for a temperature of 37.77 degrees Celsius.
     */
    @Test
    void testConvertTemperatureWithTwoDecimalPlacesFromCelsiusToFahrenheit() {
        Double temperature = 37.77;
        String expectedResult = "99,99 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }
}
