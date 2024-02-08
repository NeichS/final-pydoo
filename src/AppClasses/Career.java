package AppClasses;

import java.util.LinkedList;
import java.util.Map;

public class Career {

    private static LinkedList<Career> careers = new LinkedList<>();

    private StudyProgram planDeEstudio;
    private String name;

    public Career(String name, StudyProgram planDeEstudio) {
        this.name = name;
        this.planDeEstudio = planDeEstudio;
        careers.add(this);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public StudyProgram getPlanDeEstudio() {
        return this.planDeEstudio;
    }

    public static LinkedList<Career> getCareers() {
        return careers;
    }

    public String getName() {
        return this.name;
    }

    public Integer checkProgressCareer(Student student) {
        if (planDeEstudio.subjectQuantity() == 0) {
            return 0;
        }
        return  (student.getMateriasAprobadasUnicaCarrera(this).size() * 100) / planDeEstudio.subjectQuantity() ;
    }
    private Boolean cursadasAprobadas(Student student, Subject subject) {
        if (subject.getCorrelativas() == null || subject.getCorrelativas().isEmpty()) {
            return true;
        }
        for (Subject otherSubject : subject.getCorrelativas()) {
            if (!student.getCursadasAprobadasSinNota().contains(otherSubject)) {
                return false;
            }
        }
        return true;
    }
    private Boolean materiasAprobadas(Student student, Subject subject) {
        if (subject.getCorrelativas() == null || subject.getCorrelativas().isEmpty() ) { //contempla el caso de que no tenga correlativas
            return true;
        }
        for (Subject otherSubject : subject.getCorrelativas()) {
            if (!student.getMateriasAprobadasSinNota().contains(otherSubject)) {
                return false;
            }
        }
        return true;
    }

    private Boolean cuatrimestresAprobados(Integer num, Student student, Subject subject )  {
        Map<Integer, LinkedList<Subject>> programa = this.planDeEstudio.getPrograma();

        Integer cuatrimestreMateria = 0;
        int i = 1;
        //primero tengo que encontrar el cuatrimestre al que pertenece la materia
        while (cuatrimestreMateria != 0 || i <= programa.size()) {
            for (Subject otroSubject : programa.get(i)) {
                if (otroSubject == subject) {
                    cuatrimestreMateria = i;
                    break;
                }
            }
            i++;
        }

        int beginning = i - num; //empiezo a revisar los cuatrimestres
        if (beginning < 1) {
            beginning = 1;
        }
        for (int inicio = beginning; inicio < i; inicio++) {
            if (!student.getMateriasAprobadasSinNota().contains(programa.get(i))) {
                return false;
            }
        }
        return true;
    }
    public Boolean checkCorrelativas(Student student, Subject subject)  {
        switch (subject.getTipoCorrelativa()) {
            case 'A':
                return cursadasAprobadas(student, subject) || materiasAprobadas(student, subject);
            case 'B':
                return materiasAprobadas(student, subject);
            case 'C':
                return (cursadasAprobadas(student, subject) && cuatrimestresAprobados(5, student, subject));
            case 'D':
                return (cursadasAprobadas(student, subject) && cuatrimestresAprobados(3, student, subject));
            case 'E':
                return (materiasAprobadas(student, subject) && cuatrimestresAprobados(3, student, subject));
            default:
                return false;
            }
        }

}
