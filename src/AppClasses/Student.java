package AppClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {
    private static List<Student> listaEstudiantes = new ArrayList<Student>();
    private String nombre, apellido, mail;
    private char[] contrasenha;


    public Student(String nombre, String apellido, String mail, char[] contrasenha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.contrasenha = contrasenha;

        Student.agregarEstudiante(this);
    }

    public static void agregarEstudiante(Student student) {
        listaEstudiantes.add(student);
    }

    public List<Student> getSListaEstudiantes() {
        return listaEstudiantes;
    }

    public static boolean confirmarIngreso(String mail, char[] contrasenha) {
        for (Student student : listaEstudiantes) {
            if (student.mail.equals(mail) && Arrays.equals(student.contrasenha, contrasenha)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return  nombre;
    }

    public String getApellido() {
        return  apellido;
    }

    public String getMail() {
        return mail;
    }



    public static boolean mailInUse(String mail) {
        for (Student student : listaEstudiantes) {
            if (Objects.equals(student.mail, mail)) {
                return true;
            }
        }
        return false;
    }

}

