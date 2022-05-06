#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.mapper;

public class MCSVException extends RuntimeException {

    private MCSVExceptionType exceptionType;

    public MCSVException(MCSVExceptionType exceptionType, Exception cause) {
         super(cause);
         this.exceptionType = exceptionType;
    }

    public MCSVException(MCSVExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public MCSVExceptionType getExceptionType() {
        return exceptionType;
    }
}
