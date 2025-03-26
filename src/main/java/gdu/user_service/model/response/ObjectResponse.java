package gdu.user_service.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ObjectResponse<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int size;
    private int number;
}
