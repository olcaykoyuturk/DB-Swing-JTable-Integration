package dao;

import entity.MyTable;
import util.DBConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyTableDAO {

    private DBConnection dbcon;

    public MyTableDAO() {
        dbcon = new DBConnection();
    }

    public DBConnection getDbCon() {
        return dbcon;
    }

    // DB veri ekleme işlemi
    public void insert(MyTable myTable) {
        try{
            Connection con = getDbCon().connect();
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO mytable (nameSurname, phone, age)" +
                    " VALUES ('" + myTable.getNameSurname() + "' , '" + myTable.getPhone() + "' , '" + myTable.getAge() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DB veri çekme, liste üzerinden
    public List<MyTable> list() {
        List<MyTable> myTableList = new ArrayList<>();
        try (Connection con = dbcon.connect();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable")) {

            while (resultSet.next()) {
                MyTable myTable = new MyTable(resultSet.getString("nameSurname"),
                        resultSet.getString("phone"),
                        resultSet.getString("age"));
                myTableList.add(myTable);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return myTableList;
    }
}
