/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class EstudianteCrud {

    private Conexion conexion = new Conexion();
    private Connection conectar = conexion.conectar();
    private String SQL_SELECT = "SELECT * FROM ESTUDIANTES";
    private String SQL_INSERT = "INSERT INTO estudiantes (est_cedula, est_nombre, est_apellido, est_direccion, est_telefono)"
            + "VALUES (?,?,?,?,?)";
    private String SQL_UPDATE = "UPDATE estudiantes SET est_nombre = ?, est_apellido = ?, est_direccion = ?, est_telefono = ? WHERE "
            + "est_cedula = ?";
    private String SQL_DELETE = "DELETE FROM estudiantes WHERE est_cedula = ?";

    public int ingresarEstudiante(Estudiante estudiante) {
        int n = 0;
        try {
            PreparedStatement statement = conectar.prepareStatement(SQL_INSERT);
            statement.setString(1, estudiante.getCedula());
            statement.setString(2, estudiante.getNombre());
            statement.setString(3, estudiante.getApellido());
            statement.setString(4, estudiante.getDireccion());
            statement.setString(5, estudiante.getTelefono());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return n;
    }

    public List<Estudiante> verEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        Statement statement;
        try {
            statement = conectar.createStatement();
            ResultSet result = statement.executeQuery(SQL_SELECT);
            while (result.next()) {
                String cedula = result.getString("est_cedula");
                String nombre = result.getString("est_nombre");
                String apellido = result.getString("est_apellido");
                String direccion = result.getString("est_direccion");
                String telefono = result.getString("est_telefono");
                estudiantes.add(new Estudiante(cedula, nombre, apellido, direccion, telefono));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return estudiantes;
    }

    public int editarEstudiante(Estudiante estudiante) {
        int n = 0;
        try {
            PreparedStatement statement = conectar.prepareStatement(SQL_UPDATE);
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());
            statement.setString(3, estudiante.getDireccion());
            statement.setString(4, estudiante.getTelefono());
            statement.setString(5, estudiante.getCedula());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return n;
    }

    public int eliminarEstudiante(Estudiante estudiante) {
        int n = 0;
        try {
            PreparedStatement statement = conectar.prepareStatement(SQL_DELETE);
            statement.setString(1, estudiante.getCedula());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return n;
    }
}
