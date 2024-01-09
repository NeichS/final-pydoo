package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudyProgram {
    private char tipoPlan;
    private List<Subject> primerCuatrimestre;
    private List<Subject> segundoCuatrimestre;
    private List<Subject> tercerCuatrimestre;
    private List<Subject> cuartoCuatrimestre;
    private List<Subject> quintoCuatrimestre;
    private List<Subject> sextoCuatrimestre;
    Map<Integer, LinkedList> programa; //guarda entero (cuatri al que pertenece la materia) y las materias

    public StudyProgram(char tipoPlan, Map<Integer, LinkedList<Subject>> programa) {
        this.tipoPlan = tipoPlan;

        for (Integer i = 1 ; i <= 6 ; i++) {
            switch (i) {
                case 1: primerCuatrimestre = programa.get(i);
                case 2: segundoCuatrimestre = programa.get(i);
                case 3: tercerCuatrimestre = programa.get(i);
                case 4: cuartoCuatrimestre = programa.get(i);
                case 5: quintoCuatrimestre = programa.get(i);
                case 6: sextoCuatrimestre = programa.get(i);
            }
        }
    }

}
