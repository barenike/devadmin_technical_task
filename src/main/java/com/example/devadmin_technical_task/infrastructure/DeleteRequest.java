package com.example.devadmin_technical_task.infrastructure;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteRequest {

    @NotNull
    private String tableName;

    @NotNull
    private String condition;
}
