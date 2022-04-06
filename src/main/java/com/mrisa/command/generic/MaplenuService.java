package com.mrisa.command.generic;
import com.mrisa.command.config.SdzConnect;

import java.sql.Connection;
import java.util.List;

public interface MaplenuService<T> {

    Connection connection = SdzConnect.getConnection();

    boolean create(T obj);

    boolean update(T obj);

    boolean delete(String objId);

    List<T> list();

    T findOne(String objId);
}
