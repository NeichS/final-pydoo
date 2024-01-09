package AppClasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Career {
    private String nombre;

    private static LinkedList<Career> careers = new LinkedList<>();

    private StudyProgram planDeEstudio;
    private String name;

    public Career(String name, StudyProgram planDeEstudio) {
        this.name = name;
        this.planDeEstudio = planDeEstudio;
        careers.add(this);
    }

}
