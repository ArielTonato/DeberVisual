/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class Conexion {
    Connection conexion = null;
    public Connection conectar(){
        String url = "jdbc:mysql://localhost:3306/universidad";
        String user = "root";
        String password = "admin";
        try {
            conexion = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return conexion;
    }
}
