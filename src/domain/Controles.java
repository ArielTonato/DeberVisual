/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gabo
 */
public class Controles {
    
    public boolean controlVacios(String cedula, String nombre, String apellido, String direccion, String telefono){
        //Verifica que los campos no esten vacios para las insercciones
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public boolean validarLetras(String nombre, String apellido, String direccion){
    // Verificar que nombre, apellido y dirección contengan solo letras
    if (!nombre.matches("[a-zA-Z]+") || !apellido.matches("[a-zA-Z]+") || !direccion.matches("[a-zA-Z]+")) {
        return false; // Al menos uno de los campos nombre, apellido o dirección contiene caracteres no permitidos
    }
    return true;
    }
    
     public boolean validarNumeros(String cedula, String telefono){
    // Verificar que cédula y teléfono contengan solo números
    if (!cedula.matches("[0-9]{10}") || !telefono.matches("[0-9]{10}")) {
        return false; // Al menos uno de los campos cédula o teléfono contiene caracteres no permitidos
    }
    return true; // Todos los campos cumplen con los criterios de validación
}

    
}
