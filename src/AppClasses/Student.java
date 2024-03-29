package AppClasses;

import javax.security.auth.login.CredentialException;
import java.util.*;

public class Student {
    private static List<Student> listaEstudiantes = new ArrayList<Student>();
    private String nombre, apellido, mail;
    private char[] contrasenha;
    private LinkedList<RegistroNota> cursadasAprobadas = new LinkedList<>(); //con parcial aprobado
    private LinkedList<RegistroNota> materiasAprobadas = new LinkedList<>(); //con final aprobado o parcial promocionado

    private LinkedList<Subject> materiasAprobadasSinNota = new LinkedList<>(); //la materia aprobada sin mas
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

    public void addMateriaAprobada(Subject materia, Integer nota) {
        materiasAprobadas.add(new RegistroNota(materia, nota));
        materiasAprobadasSinNota.add(materia);
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
    public LinkedList<RegistroNota> getMateriasAprobadasUnicaCarrera(Career career) {
        LinkedList<RegistroNota> materiasAprobadasCarrera = new LinkedList<>();

        for (RegistroNota registroNota : materiasAprobadas) {
            if (career.getPlanDeEstudio().getAllSubjects().contains(registroNota.getSubject()) || career.getPlanDeEstudio().getAllOptativeSubjects().contains(registroNota.getSubject())){
                materiasAprobadasCarrera.add(registroNota);
            }
        }
        return materiasAprobadasCarrera;
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

    public LinkedList<Subject> getMateriasAprobadasSinNota() {
        return materiasAprobadasSinNota;
    }

    public LinkedList<Subject> getCursadasAprobadasSinNota() {
        return cursadasAprobadasSinNota;
    }
}

