package com.forepaw.clinic.methods;

import com.forepaw.clinic.controllers.dbcontrollers.IdController;

import java.sql.SQLException;
import java.text.NumberFormat;

public class VetClinicMethods {
    public static String getNewId(String prefix, String tableName) {
        String lastId = null;
        String newTxt="";
        try {
            lastId = IdController.getlastId(tableName);

            if (lastId == null) {
                lastId = "" + prefix + "000";
            }
            String[] id = lastId.split(prefix);
            int number = Integer.parseInt(id[1]);
            number++;
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumIntegerDigits(3);
            String value = numberFormat.format(number);
            newTxt = value.replaceAll("[\\D]", "");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prefix + newTxt;
    }
}
