package AppClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Subject {

    public static List<Subject> listaMaterias = new LinkedList<>(); //lista de materias que existen
    private String nombre;
    private LinkedList<Integer> correlativas;

    private static Integer subjectIdSerial = 0;
    private Integer subjectId;

    public static boolean existeId(Integer id) {
        for (Subject subject : listaMaterias) {
            if (Objects.equals(subject.subjectId, id)) {
                return true;
            }
        };
        return false;
    }

    public Subject(String nombre, LinkedList<Integer> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
        this.subjectId = subjectIdSerial + 1;
        subjectIdSerial++;
        listaMaterias.add(this);
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
        return this.nombre;
    }

    public LinkedList<Integer> getCorrelativas() {
        return correlativas;
    }

    public Integer getSubjectId() {
        return  subjectId;
    }
}
