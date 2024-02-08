package AppClasses;

import java.util.LinkedList;
import java.util.Map;

public class StudyProgram {
    private Map<Integer, LinkedList<Subject>> program;
    private LinkedList<Subject> allSubjects = new LinkedList<>(); //todas las materias obligatorias de la carrera
    private LinkedList<OptativeSubject> allOptativeSubjects = new LinkedList<>(); //todas las materias optativas de la carrera
    private Integer optativeMinimun = 0; //cantidad minima de optativas aprobadas para recibirse

    public StudyProgram(Map<Integer, LinkedList<Subject>> programa) {
        this.program = programa;

        for (int i = 1; i <= programa.size(); i++ ) {
            for (Subject subject : programa.get(i)) {
                allSubjects.add(subject);
            }
        }
    }
    //i es el cuatrimestre
    public LinkedList<Subject> getCuatrimestreList(Integer i) {
        return program.get(i);
    }

    public Map<Integer, LinkedList<Subject>> getProgram() {
        return program;
    }

    public int subjectQuantity() {
        int max = program.size();
        int counter = 0;
        for (int i = 1 ; i <= max ; i++) {
            counter = counter + program.get(i).size();
            }
        return counter;
    }
    public LinkedList<Subject> getAllSubjects() {
        return allSubjects;
    }

    public LinkedList<OptativeSubject> getAllOptativeSubjects() {
        return allOptativeSubjects;
    }

    public void addSubject(Integer num , Subject subject) {
        program.get(num).add(subject);
        allSubjects.add(subject);

    }
    public void addOptativeSubject(OptativeSubject subject) {
        allOptativeSubjects.add(subject);
    }

    public Integer getOptativeMinimun() {
        return optativeMinimun;
    }

    public void setOptativeMinimun(int i) {
        optativeMinimun = i;
    }
}
