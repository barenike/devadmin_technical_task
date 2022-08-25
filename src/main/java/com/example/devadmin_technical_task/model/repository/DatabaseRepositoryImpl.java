package com.example.devadmin_technical_task.model.repository;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class DatabaseRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public String query(String queryString) {
        Query query = entityManager.createNativeQuery(queryString);
        StringBuilder builder = new StringBuilder();
        if (queryString.startsWith("SELECT")) {
            for (Object object : query.getResultList()) {
                Object[] objects = (Object[]) object;
                for (Object o : objects) {
                    builder.append(o);
                    builder.append(", ");
                }
                builder.delete(builder.length() - 2, builder.length());
                builder.append("; ");
            }
        } else {
            query.executeUpdate();
        }
        return String.valueOf(builder);
    }
}
