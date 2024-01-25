package AppClasses;

public class RegistroNota {

    private Integer nota;
    private Subject subject;
    RegistroNota(Subject subject, Integer nota) {
        this.subject = subject;
        this.nota = nota;
    }

    public Integer getNota() {
        return nota;
    }

    public Subject getSubject() {
        return subject;
    }
}
