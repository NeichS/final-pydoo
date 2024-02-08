import AppClasses.*;
import Swing.VentanaPrincipal;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main {

    public static void inicializar() {
        Student alumnoUno = new Student("Ignacio", "Sanchez", "nachoagusss1@gmail.com","12345".toCharArray());

        //materias de lic en sistemas hasta el 6to cuatrimestre
        Subject algebra = new Subject("Algebra", new LinkedList<>());
        Subject analisisMatematico = new Subject("Análisis Matemático", new LinkedList<>());
        Subject elementosLogicaMatematicaDiscreta = new Subject("Elementos de Lógica y Matemática Discreta", new LinkedList<>());

        LinkedList<Subject> primerCuatrimestre = new LinkedList<>();
        primerCuatrimestre.add(algebra);
        primerCuatrimestre.add(analisisMatematico);
        primerCuatrimestre.add(elementosLogicaMatematicaDiscreta);

        Subject algoritmicaProgramacionI = new Subject("Algorítmica y Programación I", new LinkedList<>());
        LinkedList<Subject> correlativasArqui = new LinkedList<>();
        correlativasArqui.add(algebra);
        correlativasArqui.add(analisisMatematico);
        Subject arquitecturaComputadoras = new Subject("Arquitectura de Computadoras", correlativasArqui);

        LinkedList<Subject> correlativasEstadistica = new LinkedList<>();
        correlativasEstadistica.add(algebra);
        correlativasEstadistica.add(analisisMatematico);
        Subject estadistica = new Subject("Estadística", correlativasEstadistica);

        LinkedList<Subject> segundoCuatrimestre = new LinkedList<>();
        segundoCuatrimestre.add(algoritmicaProgramacionI);
        segundoCuatrimestre.add(arquitecturaComputadoras);
        segundoCuatrimestre.add(estadistica);

        Subject sistemasOrganizaciones = new Subject("Sistemas y Organizaciones", new LinkedList<>());

        LinkedList<Subject> correlativasBD = new LinkedList<>();
        correlativasBD.add(algebra);
        correlativasBD.add(arquitecturaComputadoras);
        Subject basesDatosI = new Subject("Bases de Datos I", correlativasBD);

        Subject ingenieriaSoftwareI = new Subject("Ingeniería de Software I", new LinkedList<>());

        LinkedList<Subject> tercerCuatrimestre = new LinkedList<>();
        tercerCuatrimestre.add(sistemasOrganizaciones);
        tercerCuatrimestre.add(basesDatosI);
        tercerCuatrimestre.add(ingenieriaSoftwareI);

        LinkedList<Subject> correlativasPydoo = new LinkedList<>();
        correlativasPydoo.add(ingenieriaSoftwareI);
        Subject programacionDisenoOrientadoObjetos = new Subject("Programación y Diseño Orientado a Objetos", correlativasPydoo);

        LinkedList<Subject> correlativasFTI = new LinkedList<>();
        correlativasFTI.add(programacionDisenoOrientadoObjetos);
        Subject fundamentosTeoricosInformatica = new Subject("Fundamentos Teóricos de Informática", correlativasFTI);

        LinkedList<Subject> correlativasIngII = new LinkedList<>();
        correlativasIngII.add(programacionDisenoOrientadoObjetos);
        Subject ingenieriaSoftwareII = new Subject("Ingeniería de Software II", correlativasIngII);

        LinkedList<Subject> cuartoCuatrimestre = new LinkedList<>();
        cuartoCuatrimestre.add(programacionDisenoOrientadoObjetos);
        cuartoCuatrimestre.add(fundamentosTeoricosInformatica);
        cuartoCuatrimestre.add(ingenieriaSoftwareII);

        LinkedList<Subject> correlativasIntrConc = new LinkedList<>();
        correlativasIntrConc.add(programacionDisenoOrientadoObjetos);
        correlativasIntrConc.add(basesDatosI);
        Subject introduccionConcurrencia = new Subject("Introducción a la Concurrencia", correlativasIntrConc);

        LinkedList<Subject> correlativasLabProg = new LinkedList<>();
        correlativasLabProg.add(programacionDisenoOrientadoObjetos);
        correlativasLabProg.add(introduccionConcurrencia);

        LinkedList<Subject> correlativasDBII = new LinkedList<>();
        correlativasDBII.add(basesDatosI);
        Subject basesDatosII = new Subject("Bases de Datos II", correlativasDBII);

        LinkedList<Subject> quintoCuatrimestre = new LinkedList<>();
        quintoCuatrimestre.add(introduccionConcurrencia);
        quintoCuatrimestre.add(fundamentosTeoricosInformatica);
        quintoCuatrimestre.add(basesDatosII);

        LinkedList<Subject> correlativaLabSOft = new LinkedList<>();
        correlativaLabSOft.add(introduccionConcurrencia);
        Subject laboratorioSoftware = new Subject("Laboratorio de Software", correlativaLabSOft);
        Subject seminarioAspectosLegalesProfesionalesI = new Subject("Seminario de Aspectos Legales y Profesionales I", new LinkedList<>());

        LinkedList<Subject> correlativasSO = new LinkedList<>();
        correlativasSO.add(laboratorioSoftware);
        Subject sistemasOperativos = new Subject("Sistemas Operativos", correlativasSO);


        LinkedList<Subject> sextoCuatrimestre = new LinkedList<>();
        sextoCuatrimestre.add(laboratorioSoftware);
        sextoCuatrimestre.add(seminarioAspectosLegalesProfesionalesI);
        sextoCuatrimestre.add(sistemasOperativos);

        Map<Integer, LinkedList<Subject>> programaSistemas = new HashMap<>();
        programaSistemas.put(1, primerCuatrimestre);
        programaSistemas.put(2, segundoCuatrimestre);
        programaSistemas.put(3, tercerCuatrimestre);
        programaSistemas.put(4, cuartoCuatrimestre);
        programaSistemas.put(5, quintoCuatrimestre);
        programaSistemas.put(6, sextoCuatrimestre);

        StudyProgram sistemasPrograma = new StudyProgram(programaSistemas);



        Career licSistemas = new Career("Licenciatura en Sistemas", sistemasPrograma);
        OptativeSubject inteligArtificial = new OptativeSubject("Inteligencia artificial I", false);
        licSistemas.addOptativeSubject(inteligArtificial);
        licSistemas.getPlanDeEstudio().setOptativeMinimun(1);

        Career licEconomia = new Career("Lic en Economia", new StudyProgram(new HashMap<>()));

        alumnoUno.addMateriaAprobada(algebra, 9);
        alumnoUno.addMateriaAprobada(analisisMatematico, 8);
        alumnoUno.addMateriaAprobada(elementosLogicaMatematicaDiscreta, 9 );
        alumnoUno.addMateriaAprobada(estadistica, 5 );
        alumnoUno.addMateriaAprobada(algoritmicaProgramacionI ,10 );

        alumnoUno.setCursaCarrera(licSistemas);
        //alumnoUno.setCursaCarrera(LicEconomia);


        Student alumnoDos = new Student("Juan", "Pérez", "juan.perez@mail.com", "123456".toCharArray());
        Student alumnoTres = new Student("María", "García", "maria.garcia@mail.com", "abcdef".toCharArray());

        alumnoDos.setCursaCarrera(licSistemas);

        alumnoTres.setCursaCarrera(licSistemas);
        for (Subject subject : licSistemas.getPlanDeEstudio().getAllSubjects()) {
            alumnoTres.addMateriaAprobada(subject, 10);
        }

        alumnoTres.addMateriaAprobada(inteligArtificial, 10);

    }
    public static void main(String[] args) {
        inicializar();
        //toda la aplicacion
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}
