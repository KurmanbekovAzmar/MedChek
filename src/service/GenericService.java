package service;

import models.Doctor;

public interface GenericService <T> {
    String add(Long  hospitalId, T t);

    void removeById(Long id);

    String updateById(Long id);
}
