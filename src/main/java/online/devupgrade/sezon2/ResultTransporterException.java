package online.devupgrade.sezon2;

import java.util.List;

public class ResultTransporterException extends RuntimeException {

    private Object data;

    public ResultTransporterException(Object data) {
        this.data = data;
    }

    Object getData() {
        return data;
    }
}
