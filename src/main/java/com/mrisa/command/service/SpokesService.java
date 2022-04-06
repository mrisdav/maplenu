package com.mrisa.command.service;

import com.mrisa.command.generic.MaplenuService;
import com.mrisa.command.model.Spokes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpokesService implements MaplenuService<Spokes> {
    @Override
    public boolean create(Spokes obj) {
        try {
            // Preparation of request
            PreparedStatement prepare = connection.prepareStatement("INSERT INTO spokes(_id, wording) VALUES (?, ?)");

            prepare.setString(1, obj.getCode());
            prepare.setString(2, obj.getWording());

            return prepare.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Spokes obj) {
        try {
            PreparedStatement prepare = connection.prepareStatement("UPDATE spokes SET " +
                    "wording = ? WHERE _id = ?");

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
        try {
            PreparedStatement prepare = connection.prepareStatement("DELETE FROM spokes WHERE _id = ?");
            PreparedStatement prepareTwo = connection.prepareStatement("DELETE FROM product WHERE spokes_id = ?");
            prepare.setString(1, objId);
            prepareTwo.setString(1, objId);
            return (prepare.executeUpdate() > 0 || prepareTwo.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Spokes> list() {
        ArrayList<Spokes> spokesList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery("SELECT * FROM spokes");
            while (result.next()) {
                spokesList.add(new Spokes(result.getString("_id"), result.getString("wording")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spokesList;
    }

    @Override
    public Spokes findOne(String objId) {
        Spokes spokes = null;
        try {
            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM spokes WHERE _id = ?");
            prepare.setString(1, objId);
            ResultSet result = prepare.executeQuery();
            result.first();
            spokes = new Spokes(result.getString("_id"), result.getString("wording"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spokes;
    }
}
