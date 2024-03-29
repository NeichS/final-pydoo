package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Subject  {

    public static LinkedList<Subject> listaMaterias = new LinkedList<>(); //lista de materias que existen
    private String nombre;
    private LinkedList<Subject> correlativas;

    private static Integer subjectIdSerial = 0;
    private Integer subjectId;
    private boolean promocion;

    private char tipoCorrelativa;
    public Subject(String nombre, Boolean promocion) {
        this.nombre = nombre;
        this.promocion = promocion;
        subjectIdSerial++;
        this.subjectId = subjectIdSerial;
        this.tipoCorrelativa = 'A';

        listaMaterias.add(this);
    }

    public Subject(String nombre, LinkedList<Subject> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
        this.promocion = false;
        subjectIdSerial++;
        this.subjectId = subjectIdSerial;
        this.tipoCorrelativa = 'A'; //por defecto el tipo correlativa es que por lo menos hayan aprobado las cursadas

        listaMaterias.add(this);
    }
    public Subject(String nombre, Boolean promocion, char tipoCorrelativa) {
        this.nombre = nombre;
        this.promocion = promocion;
        this.tipoCorrelativa = tipoCorrelativa;
        subjectIdSerial++;
        this.subjectId = subjectIdSerial;

        listaMaterias.add(this);
    }

    public static boolean existeId(Integer id) {
        for (Subject subject : listaMaterias) {
            if (Objects.equals(subject.subjectId, id)) {
                return true;
            }
        };
        return false;
    }
    public static Subject getSubjectById(Integer subjectId) {
        for (Subject subject : listaMaterias) {
            if (Objects.equals(subject.subjectId, subjectId)) {
                return subject;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return nombre;
    }

    public LinkedList<Subject> getCorrelativas() {
        return correlativas;
    }

    public Integer getSubjectId() {
        return  subjectId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subject other) {
            return this.nombre.equals(other.nombre);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public Boolean promociona(Student student) {
        RegistroNota registro = student.getRegistroMateria(this);
        if (registro != null) {
            return this.promocion && (registro.getNota() >= 7);
        } else {
            return false;
        }
    }

    public void setCorrelativas(Subject subject) {
        if (this.correlativas == null) {
            correlativas = new LinkedList<>();
            correlativas.add(subject);
        } else {
            correlativas.add(subject);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public static Subject getSubjectByStringName(String nombre) {
        for (Subject subject : listaMaterias) {
            if (subject.getNombre().equals(nombre)) {
                return subject;
            }
        }
        return null;
    }
    public Boolean getPromocion() {
        return promocion;
    }

    public char getTipoCorrelativa() {
        return tipoCorrelativa;
    }
}
