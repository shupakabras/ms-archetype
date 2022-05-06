#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MCSVExceptionMapper implements ExceptionMapper<MCSVException> {

    @Override
    public Response toResponse(MCSVException e) {
        MCSVExceptionType exceptionType = e.getExceptionType();
        return Response.status(exceptionType.getHttpCode()).entity(exceptionType.toStatus()).build();
    }
}
