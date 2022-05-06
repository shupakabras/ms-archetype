#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app;

import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.jaxb.XmlJaxbAnnotationIntrospector;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"${package}.app", "${package}.services.impl"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     * Configurations above required to have swagger input validation in runtime with the same data structure in JSON as it is declared in XSD.
     */
    @Bean
    @Order(1)
    public Jackson2ObjectMapperBuilderCustomizer createCustomizer() {
        return (jackson2ObjectMapperBuilder -> jackson2ObjectMapperBuilder.annotationIntrospector(createAnnotationIntrospector()));
    }

    @Bean
    public JAXBElementProvider jaxbElementProvider() {
        JAXBElementProvider jaxbElementProvider = new JAXBElementProvider();
        jaxbElementProvider.setMarshallAsJaxbElement(true);
        return jaxbElementProvider;
    }

    @Bean
    public ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setAnnotationIntrospector(createAnnotationIntrospector());
        return objectMapper;
    }

    public static AnnotationIntrospector createAnnotationIntrospector() {
        return new AnnotationIntrospectorPair(new XmlJaxbAnnotationIntrospector((new XmlMapper()).getTypeFactory()), new JacksonAnnotationIntrospector());
    }
}
