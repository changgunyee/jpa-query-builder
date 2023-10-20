package persistence.common;

import persistence.annotations.Entity;
import persistence.annotations.Table;
import persistence.sql.ddl.NoEntityException;

import java.util.Optional;

public class EntityClazz {

    private String name;

    public EntityClazz(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            throw new NoEntityException(clazz.getName());
        }

        this.name = Optional.ofNullable(clazz.getAnnotation(Table.class))
                .map(Table::name)
                .orElse(clazz.getSimpleName());
    }

    public String getName() {
        return name;
    }
}
