package br.renato.converter.transportlayers.impl;

import br.renato.converter.interactors.ConverterService;
import br.renato.converter.transportlayers.ConverterApi;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class implements the {@link ConverterApi} interface and provides a REST API for converting temperatures between different units of measurement.
 * The API uses the GET /converter/convert endpoint to allow clients to specify a temperature value and a unit of measurement,
 * and returns the converted temperature in the desired unit of measurement.
 */
@Api(tags = "Converter")
@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ConverterController implements ConverterApi {

    private final ConverterService converterService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<String> convert(Double temperature, String unitOfMeasurement) {
        return ResponseEntity.ok().body(converterService.convert(temperature, unitOfMeasurement));
    }
}
