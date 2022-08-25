package com.example.devadmin_technical_task.infrastructure;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class InsertRequest {

    @NotNull
    private String tableName;

    @NotNull
    @NotEmpty
    private List<String> columns;

    @NotNull
    @NotEmpty
    private List<String> values;
}
