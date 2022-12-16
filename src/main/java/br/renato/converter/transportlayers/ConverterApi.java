package br.renato.converter.transportlayers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "Converter", tags = "Allows you to convert temperature to another unit of measurement of your choosing.")
public interface ConverterApi {

    @ApiOperation("Converts based on the value and the unit of measurement choose.")
    @GetMapping(value = "/convert")
    ResponseEntity<String> convert(@ApiParam("Value of the temperature") @RequestParam Double temperature, @ApiParam("Unit of measurement") @RequestParam String unitOfMeasurement);
}
