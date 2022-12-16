package br.renato.converter.interactors;

import br.renato.converter.entities.enums.EnumUnitOfMeasurement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

import static br.renato.converter.utils.ConstantUtil.CELSIUS_TO_FAHRENHEIT_FACTOR;
import static br.renato.converter.utils.ConstantUtil.FAHRENHEIT_TO_CELSIUS_FACTOR;
import static br.renato.converter.utils.ConstantUtil.FAHRENHEIT_TO_CELSIUS_OFFSET;

@Service
@RequiredArgsConstructor
public class ConverterService {

    /**
     * Converts a temperature from one unit of measurement to another.
     *
     * @param temperature       the temperature to convert
     * @param unitOfMeasurement the unit of measurement of the temperature (e.g., "CELSIUS" or "FAHRENHEIT")
     * @return the converted temperature, formatted as a string with two decimal places (e.g., "32.00 F°")
     * @throws IllegalArgumentException if the temperature or unit of measurement is invalid
     */
    public String convert(Double temperature, String unitOfMeasurement) {
        try {
            if (temperature == null || temperature < -100 || temperature > 100) {
                throw new IllegalArgumentException("Temperature must be between -100 and 100");
            }
            EnumUnitOfMeasurement enumUnitOfMeasurement = EnumUnitOfMeasurement.valueOf(unitOfMeasurement);
            if (enumUnitOfMeasurement.equals(EnumUnitOfMeasurement.CELSIUS)) {
                return convertFromCelsiusToFahrenheit(temperature);
            }
            return convertFromFahrenheitToCelsius(temperature);
        } catch (IllegalArgumentException e) {
            return "Error converting temperature: " + e.getMessage();
        } catch (Exception e) {
            return "Error converting temperature: An unexpected error occurred";
        }
    }

    /**
     * Converts a temperature from Celsius to Fahrenheit.
     *
     * @param temperature the temperature in Celsius
     * @return the temperature in Fahrenheit, formatted as a string with two decimal places (e.g., "32.00 F°")
     */
    private String convertFromCelsiusToFahrenheit(Double temperature) {
        double fahrenheit = temperature * CELSIUS_TO_FAHRENHEIT_FACTOR + FAHRENHEIT_TO_CELSIUS_OFFSET;
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(fahrenheit) + " F°";
    }

    /**
     * Converts a temperature from Fahrenheit to Celsius.
     *
     * @param temperature the temperature in Fahrenheit
     * @return the temperature in Celsius, formatted as a string with two decimal places (e.g., "0.00 C°")
     */
    private String convertFromFahrenheitToCelsius(Double temperature) {
        double celsius = (temperature - FAHRENHEIT_TO_CELSIUS_OFFSET) * FAHRENHEIT_TO_CELSIUS_FACTOR;
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(celsius) + " C°";
    }
}
