package br.renato.converter.service;

import br.renato.converter.interactors.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.renato.converter.utils.ConstantUtil.CELSIUS;
import static br.renato.converter.utils.ConstantUtil.FAHRENHEIT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class ConverterServiceTest {

    @InjectMocks
    private ConverterService converterService;

    @Test
    void testConvertFromCelsiusToFahrenheit() {
        Double temperature = 0.0;
        String expectedResult = "32,00 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    @Test
    void testConvertFromFahrenheitToCelsius() {
        Double temperature = 32.0;
        String expectedResult = "0,00 C°";
        String result = this.converterService.convert(temperature, FAHRENHEIT);
        assertEquals(expectedResult, result);
    }

    @Test
    void testConvertNegativeTemperatureFromCelsiusToFahrenheit() {
        Double temperature = -40.0;
        String expectedResult = "-40,00 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    @Test
    void testConvertInvalidTemperatureFromCelsiusToFahrenheit() {
        Double temperature = 1000000.0;
        String expectedResult = "Error converting temperature: Temperature must be between -100 and 100";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }

    @Test
    void testConvertTemperatureWithTwoDecimalPlacesFromCelsiusToFahrenheit() {
        Double temperature = 37.77;
        String expectedResult = "99,99 F°";
        String result = this.converterService.convert(temperature, CELSIUS);
        assertEquals(expectedResult, result);
    }
}
