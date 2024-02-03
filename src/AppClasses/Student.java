package AppClasses;

import java.util.*;

public class Student {
    private static List<Student> listaEstudiantes = new ArrayList<Student>();
    private String nombre, apellido, mail;
    private char[] contrasenha;
    private LinkedList<RegistroNota> cursadasAprobadas = new LinkedList<>(); //con parcial aprobado
    private LinkedList<RegistroNota> materiasAprobadas = new LinkedList<>(); //con final aprobado o parcial promocionado

    private LinkedList<Subject> materiasArobadasSinNota = new LinkedList<>(); //la materia aprobada sin mas
    private LinkedList<Career> cursaCarrera = new LinkedList<>();
    private LinkedList<Subject> materiasInscripto = new LinkedList<>();

    private LinkedList<Subject> cursadasAprobadasSinNota = new LinkedList<>();

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

    //Hace falta implementar un strategy para analizar las correlativas dependiendo del tipo de plan
    /*public boolean correlativasCheck(Subject materia){
        for (Subject subject : materia.getCorrelativas())
            if (!materiasAprobadas.contains(subject)) {
                return false;
            }
        return true;
    }*/
    public void addMateriaAprobada(Subject materia, Integer nota) {
        materiasAprobadas.add(new RegistroNota(materia, nota));
        materiasArobadasSinNota.add(materia);
    }

    public void addCursadaAprobada(Subject materia, Integer nota) {

        if (materia.getPromocion() && nota >= 8) {
            addMateriaAprobada(materia, nota);
        } else {
            addCursadaAprobada(materia, nota);
            cursadasAprobadasSinNota.add(materia);
        }

        cursadasAprobadas.add(new RegistroNota(materia, nota));
    }
    public LinkedList<RegistroNota> getCursadasAprobadas() {
        return cursadasAprobadas;
    }

    public static Student getAlumnoByMail(String mail) {
        for (Student student : listaEstudiantes) {
            if (Objects.equals(student.mail, mail)) {
                return  student;
            }
        }
        return null;
    }
    public LinkedList<Career> getCursaCarrera() {
        return this.cursaCarrera;
    }

    public void setCursaCarrera(Career carrera) {
        cursaCarrera.add(carrera);
    }

    public LinkedList<RegistroNota> getMateriasAprobadas() {
        return materiasAprobadas;
    }
    public void addMateriasInscripto(Subject subject) {
        materiasInscripto.add(subject);
    }
    public LinkedList<Subject> getMateriasInscripto() {
        return materiasInscripto;
    }

    public RegistroNota getRegistroMateria(Subject subject) {
        for (RegistroNota registro : getCursadasAprobadas()) {
            if (registro.getSubject() == subject) {
                return registro;
            }
        }
        return null;
    }

    public Boolean isSubjectPassed(Subject subject) {
        for (RegistroNota registroNota : materiasAprobadas) {
            if (registroNota.getSubject().getNombre().equals(subject.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Subject> getMateriasArobadasSinNota() {
        return materiasArobadasSinNota;
    }

    public LinkedList<Subject> getCursadasAprobadasSinNota() {
        return cursadasAprobadasSinNota;
    }
}

