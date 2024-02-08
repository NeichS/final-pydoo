package AppClasses;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

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
        return  (student.getMateriasAprobadasUnicaCarrera(this).size() * 100) / (planDeEstudio.subjectQuantity() + planDeEstudio.getOptativeMinimun());
    }
    private Boolean cursadasAprobadas(Student student, Subject subject) {
        if (student.getCursadasAprobadas().isEmpty()) {
            return false;
        }
        if (!(subject.getCorrelativas() == null || subject.getCorrelativas().isEmpty())) {
            for (Subject otherSubject : subject.getCorrelativas()) {
                if (!student.getCursadasAprobadasSinNota().contains(otherSubject)) {
                    return false;
                }
            }
        }
        return true;
    }
    private Boolean materiasAprobadas(Student student, Subject subject) {
        if (subject.getCorrelativas() == null || subject.getCorrelativas().isEmpty()) { //contempla el caso de que no tenga correlativas
            return true;
        }
        if (student.getMateriasAprobadas().isEmpty() ) {
            return false;
        }
        for (Subject otherSubject : subject.getCorrelativas()) {
            if (!student.isSubjectPassed(otherSubject)) {
                return false;
            }
        }
        return true;
    }

    private Boolean cuatrimestresAprobados(Integer num, Student student, Subject subject )  {
        Map<Integer, LinkedList<Subject>> programa = this.planDeEstudio.getProgram();

        Integer cuatrimestreMateria = 0;
        int i = 0;
        //primero tengo que encontrar el cuatrimestre al que pertenece la materia
        while ((cuatrimestreMateria == 0) && (i <= programa.size())) {
            i++;
            for (Subject otroSubject : programa.get(i)) {
                if (Objects.equals(otroSubject.getNombre(), subject.getNombre())) {
                    cuatrimestreMateria = i;
                }
            }
        }
        int beginning = cuatrimestreMateria - num;//empiezo a revisar los cuatrimestres
        if (beginning < 1) {
            beginning = 1;
        }

        for (int inicio = beginning; inicio < cuatrimestreMateria; inicio++) {
            for (Subject subject1 : programa.get(inicio)) {
                if (!student.getMateriasAprobadasSinNota().contains(subject1)) {
                    return false;
                }
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
                return (cuatrimestresAprobados(5, student, subject) && cursadasAprobadas(student, subject));
            case 'D':
                return (cuatrimestresAprobados(3, student, subject) && cursadasAprobadas(student, subject));
            case 'E':
                return (cuatrimestresAprobados(3, student, subject) && materiasAprobadas(student, subject));
            default:
                return false;
            }
        }

        public void addOptativeSubject(OptativeSubject subject) {
            this.planDeEstudio.addOptativeSubject(subject);
        }

    public void addSubject(Integer num, Subject subject) {
        this.planDeEstudio.addSubject(num, subject);
    }

}
