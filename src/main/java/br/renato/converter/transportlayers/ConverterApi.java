package br.renato.converter.transportlayers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This interface defines the API for converting temperatures between different units of measurement.
 * The API uses the GET /convert endpoint to allow clients to specify a temperature value and a unit of measurement,
 * and returns the converted temperature in the desired unit of measurement.
 */
@Api(value = "Converter", tags = "Allows you to convert temperature to another unit of measurement of your choosing.")
public interface ConverterApi {

    /**
     * Converts the specified temperature value from one unit of measurement to another.
     *
     * @param temperature the temperature value to convert
     * @param unitOfMeasurement the unit of measurement of the temperature value
     * @return the converted temperature value in the desired unit of measurement
     */
    @ApiOperation("Converts based on the value and the unit of measurement choose.")
    @GetMapping(value = "/convert")
    ResponseEntity<String> convert(@ApiParam("Value of the temperature") @RequestParam Double temperature, @ApiParam("Unit of measurement") @RequestParam String unitOfMeasurement);
}
