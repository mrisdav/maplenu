package com.mrisa.command.service;

import com.mrisa.command.config.SdzConnect;
import com.mrisa.command.generic.MaplenuService;
import com.mrisa.command.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements MaplenuService<Category> {

    @Override
    public boolean create(Category obj) {
        try {
            PreparedStatement prepare = connection.prepareStatement("INSERT INTO category(_id, wording) VALUES (?, ?)");
            prepare.setString(1, obj.getCode());
            prepare.setString(2, obj.getWording());
            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category obj) {
        try {
            PreparedStatement prepare = connection.prepareStatement("UPDATE category SET wording = ? " +
                    "WHERE _id = ?");
            prepare.setString(1, obj.getWording());
            prepare.setString(2, obj.getCode());
            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String objId) {
        Connection connection = SdzConnect.getConnection();
        try {
            PreparedStatement prepare = connection.prepareStatement("DELETE FROM category WHERE _id = ?");
            prepare.setString(1, objId);

            //Requete pour supprimé tous les produits de cette catégorie
            PreparedStatement prepareTwo = connection.prepareStatement("DELETE FROM product WHERE category_id = ?");
            prepareTwo.setString(1, objId);

            return (prepare.executeUpdate() > 0 || prepareTwo.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Category> list() {
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery("SELECT * FROM category");
            while (result.next()) {
                categoryList.add(new Category(result.getString("_id"), result.getString("wording")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findOne(String objId) {
        Category category = null;
        try {
            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM category WHERE _id = ?");
            prepare.setString(1, objId);
            ResultSet result = prepare.executeQuery();
            result.first();
            category = new Category(result.getString("_id"), result.getString("wording"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
