package iplanalyzer;

public class IplAnalyzerException extends RuntimeException {

    public enum ExceptionType {
        NO_SUCH_FILE, NO_DATA_FOUND;
    }

    ExceptionType type;

    public IplAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
