package com.mrisa.command.service;

import com.mrisa.command.generic.MaplenuService;
import com.mrisa.command.model.Category;
import com.mrisa.command.model.Product;
import com.mrisa.command.model.Spokes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements MaplenuService<Product> {
    @Override
    public boolean create(Product obj) {
        try {
            PreparedStatement prepare = connection.prepareStatement("insert into product(_id, wording, " +
                    "unitPrice, quantity, limitQuantity, category_id, spokes_id) values (?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, obj.getCode());
            prepare.setString(2, obj.getWording());
            prepare.setDouble(3, obj.getUnitPrice());
            prepare.setInt(4, obj.getQuantity());
            prepare.setInt(5, obj.getLimit());
            prepare.setString(6, obj.getCategory().getCode());
            prepare.setString(7, obj.getSpokes().getCode());
            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product obj) {
        try {
            PreparedStatement prepare = connection.prepareStatement("UPDATE product" +
                    "SET wording = ?, unitPrice = ?, quantity = ?, limitQuantity = ?, category_id = ?, spokes_id = ?)" +
                    "WHERE _id = ?");
            prepare.setString(1, obj.getWording());
            prepare.setDouble(2, obj.getUnitPrice());
            prepare.setInt(3, obj.getQuantity());
            prepare.setInt(4, obj.getLimit());
            prepare.setString(5, obj.getCategory().getCode());
            prepare.setString(6, obj.getSpokes().getCode());
            prepare.setString(7, obj.getCode());
            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String objId) {
        try {
            PreparedStatement prepare = connection.prepareStatement("DELETE FROM product WHERE _id = ?");
            prepare.setString(1, objId);

            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> list() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery("SELECT * FROM product p " +
                    "INNER JOIN category c ON p.category_id = c._id " +
                    "INNER JOIN spokes s ON p.spokes_id = s._id");
            while (result.next()) {
                Category category = null;
                Spokes spokes = null;
                products.add(new Product(result.getString("_id"), result.getString("p.wording"),
                        result.getDouble("unitPrice"), result.getInt("quantity"), result.getInt("limitQuantity"), null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findOne(String objId) {
        Product product = null;
        try {
            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM product WHERE _id = ?");
            prepare.setString(1, objId);
            ResultSet result = prepare.getResultSet();
            result.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
