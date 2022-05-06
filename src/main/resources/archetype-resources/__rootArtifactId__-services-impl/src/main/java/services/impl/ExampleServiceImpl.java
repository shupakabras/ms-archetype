#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import ${package}.mapper.MCSVException;
import ${package}.mapper.MCSVExceptionType;
import ${package}.model.ArrayOfObject;
import ${package}.model.MicroserviceStatus;
import ${package}.services.ExampleService;

import io.swagger.annotations.Api;

@Component
@Api("exampleService")
public class ExampleServiceImpl implements ExampleService {
    private static final Logger LOG = Logger.getLogger(ExampleServiceImpl.class.getName());


    @Override
    public ArrayOfObject getAllData(String principal) {
        return null;
    }

}
