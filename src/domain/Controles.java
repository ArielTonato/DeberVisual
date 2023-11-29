/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gabo
 */
public class Controles {

    public boolean validarCedula(String numeroCedula) {
        int suma = 0;
        if (numeroCedula.length() != 10 || Integer.parseInt(numeroCedula.substring(0, 2)) > 24 || Integer.parseInt(numeroCedula.substring(0, 2)) < 0 || Integer.parseInt(String.valueOf(numeroCedula.charAt(2))) > 6) {
            return false;
        } else {
            int[] a = new int[numeroCedula.length() / 2];
            int[] b = new int[(numeroCedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < numeroCedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(numeroCedula.charAt(c)));
                c = c + 2;
                if (i < (numeroCedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(numeroCedula.charAt(d)));
                    d = d + 2;
                }
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(numeroCedula.charAt(numeroCedula.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && numeroCedula.charAt(numeroCedula.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean controlVacios(String cedula, String nombre, String apellido, String direccion, String telefono) {
        //Verifica que los campos no esten vacios para las insercciones

        return (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty());
    }

    public boolean validarTelefono(String telefono) {
        String regex = "^09\\d{8}$"; // ^09 indica que debe empezar con "09", \d{8} indica exactamente 8 dígitos adicionales

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Verificar si el teléfono coincide con el patrón
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

}
