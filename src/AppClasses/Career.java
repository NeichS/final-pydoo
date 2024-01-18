package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

}
