package AppClasses;

import java.util.*;

public class Student {
    private static List<Student> listaEstudiantes = new ArrayList<Student>();
    private String nombre, apellido, mail;
    private char[] contrasenha;
    private LinkedList<Subject> materiasAprobadas = new LinkedList<>();
    private LinkedList<Subject> cursadasAprobadas = new LinkedList<>();



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

    public boolean correlativasCheck(Subject materia){
        for (Integer subjectId : materia.getCorrelativas())
            if (!materiasAprobadas.contains(Subject.getSubjectById(subjectId))) {
                return false;
            }
        return true;
    }
    public void addMateriaAprobada(Subject materia) {
        if (correlativasCheck(materia)) {
            materiasAprobadas.add(materia);
        } else {
            System.out.println("No cumple con las correlativas para aprobar la materia " + materia);
        }
    }

    public void addCursadaAprobada(Subject materia) {
        cursadasAprobadas.add(materia);
    }

}

