package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudyProgram {
    private Map<Integer, LinkedList<Subject>> programa;
    private LinkedList<Subject> allSubjects = new LinkedList<>();

    public StudyProgram(Map<Integer, LinkedList<Subject>> programa) {
        this.programa = programa;

        for (int i = 1; i <= programa.size(); i++ ) {
            for (Subject subject : programa.get(i)) {
                allSubjects.add(subject);
            }
        }
    }
    //i es el cuatrimestre
    public LinkedList<Subject> getCuatrimestreList(Integer i) {
        return programa.get(i);
    }

    public Map<Integer, LinkedList<Subject>> getPrograma() {
        return programa;
    }

    public int subjectQuantity() {
        int max = programa.size();
        int counter = 0;
        for (int i = 1 ; i <= max ; i++) {
            counter = counter + programa.get(i).size();
            }
        return counter;
    }
    public LinkedList<Subject> getAllSubjects() {
        return allSubjects;
    }

}
