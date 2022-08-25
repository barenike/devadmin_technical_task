package com.example.devadmin_technical_task.model.service;

import com.example.devadmin_technical_task.infrastructure.DeleteRequest;
import com.example.devadmin_technical_task.infrastructure.InsertRequest;
import com.example.devadmin_technical_task.infrastructure.SelectOrCreateRequest;
import com.example.devadmin_technical_task.model.repository.DatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private final DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    private static void removeTwoLastChars(StringBuilder builder) {
        builder.delete(builder.length() - 2, builder.length());
    }

    public String selectQuery(SelectOrCreateRequest selectOrCreateRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        for (String column : selectOrCreateRequest.getColumns()) {
            builder.append(column).append(", ");
        }
        removeTwoLastChars(builder);
        builder.append(" FROM ").append(selectOrCreateRequest.getTableName()).append(";");
        return databaseRepository.query(String.valueOf(builder));
    }

    public void createQuery(SelectOrCreateRequest selectOrCreateRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ").append(selectOrCreateRequest.getTableName()).append(" (");
        for (String column : selectOrCreateRequest.getColumns()) {
            builder.append(column).append(", ");
        }
        removeTwoLastChars(builder);
        builder.append(");");
        databaseRepository.query(String.valueOf(builder));
    }

    public void deleteQuery(DeleteRequest deleteRequest) {
        databaseRepository.query("DELETE FROM " + deleteRequest.getTableName() + " WHERE " + deleteRequest.getCondition() + ";");
    }

    public void insertQuery(InsertRequest insertRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(insertRequest.getTableName()).append(" (");
        for (String column : insertRequest.getColumns()) {
            builder.append(column).append(", ");
        }
        removeTwoLastChars(builder);
        builder.append(") VALUES (");
        for (String value : insertRequest.getValues()) {
            builder.append("'").append(value).append("', ");
        }
        removeTwoLastChars(builder);
        builder.append(");");
        databaseRepository.query(String.valueOf(builder));
    }
}
