/*
Cette classe set à établir une connection avec une base de donnée
 */

package com.mrisa.command.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SdzConnect {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mariadb://172.17.0.2:3306/maplenu";
    private static Connection connection = null;

    /*
        La méthode getConnection vérifie si la viariable de connection vaut null s'il vaut null
        il créer la connection la connection en faisant appelle au DriverMAnager
     */
    public static Connection getConnection () {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
