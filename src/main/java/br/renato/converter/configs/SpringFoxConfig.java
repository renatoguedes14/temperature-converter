package br.renato.converter.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for SpringFox, a library for generating documentation
 * for Spring Boot REST APIs.
 */
@Configuration
public class SpringFoxConfig {

    /**
     * Creates a {@link Docket} bean, which represents the configuration for the
     * Swagger 2 API documentation.
     *
     * @return a {@link Docket} bean
     */
    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.renato.converter.transportlayers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Builds an {@link ApiInfo} object, which contains metadata about the API.
     *
     * @return an {@link ApiInfo} object
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Temperature Converter API")
                .description("This API converts temperature to another unit of measurement.")
                .version("1.1.1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
