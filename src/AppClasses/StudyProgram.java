package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudyProgram {
    private char tipoPlan;
    private Map<Integer, LinkedList<Subject>> programa;

    public StudyProgram(char tipoPlan, Map<Integer, LinkedList<Subject>> programa) {
        this.tipoPlan = tipoPlan;
        this.programa = programa;
    }

    //i es el cuatrimestre
    public LinkedList<Subject> getCuatrimestreList(Integer i) {
        return programa.get(i);
    }

    public Map<Integer, LinkedList<Subject>> getPrograma() {
        return programa;
    }
}