package br.renato.converter.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantUtil {

    public static final double FAHRENHEIT_TO_CELSIUS_FACTOR = 5.0 / 9.0;
    public static final double CELSIUS_TO_FAHRENHEIT_FACTOR = 9.0 / 5.0;
    public static final double FAHRENHEIT_TO_CELSIUS_OFFSET = 32;
    public static final String CELSIUS = "CELSIUS";
    public static final String FAHRENHEIT = "FAHRENHEIT";
}
