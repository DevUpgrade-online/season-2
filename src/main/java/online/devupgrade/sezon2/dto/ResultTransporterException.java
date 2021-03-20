package online.devupgrade.sezon2.dto;

import java.util.List;

public class ResultTransporterException extends RuntimeException {

    private Object data;

    public ResultTransporterException(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
