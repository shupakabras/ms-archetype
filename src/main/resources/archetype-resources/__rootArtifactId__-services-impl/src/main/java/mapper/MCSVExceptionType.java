#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.mapper;

import javax.ws.rs.core.Response;

import ${package}.model.MicroserviceStatus;

public enum MCSVExceptionType {

    UNEXPECTED_ERROR(Response.Status.BAD_REQUEST.getStatusCode(), "ERR-EXAMPLE-0000", "Unexpected error");

    private int httpCode;

    private String statusCode;

    private String statusMessage;

    public int getHttpCode() {
        return httpCode;
    }

    MCSVExceptionType(int httpCode, String statusCode, String statusMessage) {
        this.httpCode = httpCode;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public MicroserviceStatus toStatus() {
        MicroserviceStatus microserviceStatus = new MicroserviceStatus();
        microserviceStatus.setError(true);
        microserviceStatus.setStatusCode(statusCode);
        microserviceStatus.setStatusMessage(statusMessage);
        return microserviceStatus;
    }

    

}
