package br.renato.converter.transportlayers.impl;

import br.renato.converter.interactors.ConverterService;
import br.renato.converter.transportlayers.ConverterApi;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Converter")
@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ConverterController implements ConverterApi {

    private final ConverterService converterService;

    @Override
    public ResponseEntity<String> convert(Double temperature, String unitOfMeasurement) {
        return ResponseEntity.ok().body(converterService.convert(temperature, unitOfMeasurement));
    }
}
