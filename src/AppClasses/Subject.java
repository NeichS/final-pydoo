package AppClasses;

import java.util.LinkedList;
import java.util.List;

public class Subject {

    private static List<Subject> listaMaterias = new LinkedList<>(); //lista de materias que existen
    private String nombre;
    private List<Integer> correlativas = new LinkedList<>();

    private static Integer subjectId = 0;

    private boolean existeId(Integer id) {
        return false;
    }

    public Subject(String nombre, List<Integer> correlativas) {

        if (existeId(subjectId)) {
            this.nombre = nombre;
            this.correlativas = correlativas;
            this.subjectId = subjectId + 1;
            listaMaterias.add(this);
        } else {
            System.out.println("Id repetido");
        }

    }

    public Integer getSubjectId() {
        return subjectId;
    }



}
