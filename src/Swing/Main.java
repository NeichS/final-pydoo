package Swing;

import AppClasses.Career;
import AppClasses.Student;
import AppClasses.StudyProgram;
import AppClasses.Subject;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main {

    public static void inicializar() {
        char[] passAlumnoUno = {'a', 'l', 'p', 'e', 'd', 'o', '.', '1', '0'};
        Student alumnoUno = new Student("Ignacio", "Sanchez", "nachoagusss1@gmail.com",passAlumnoUno);

        //materias de lic en sistemas hasta el 6to cuatrimestre
        Subject algebra = new Subject("Algebra", new LinkedList<>());
        Subject analisisMatematico = new Subject("Análisis Matemático", new LinkedList<>());
        Subject elementosLogicaMatematicaDiscreta = new Subject("Elementos de Lógica y Matemática Discreta", new LinkedList<>());

        LinkedList<Subject> primerCuatrimestre = new LinkedList<>();
        primerCuatrimestre.add(algebra);
        primerCuatrimestre.add(analisisMatematico);
        primerCuatrimestre.add(elementosLogicaMatematicaDiscreta);

        Subject algoritmicaProgramacionI = new Subject("Algorítmica y Programación I", new LinkedList<>());
        LinkedList<Integer> correlativasArqui= new LinkedList<>();
        correlativasArqui.add(3);
        correlativasArqui.add(4);
        Subject arquitecturaComputadoras = new Subject("Arquitectura de Computadoras", correlativasArqui);


        LinkedList<Integer> correlativasEstadistica = new LinkedList<>();
        correlativasEstadistica.add(1);
        correlativasEstadistica.add(2);
        Subject estadistica = new Subject("Estadística", correlativasEstadistica);

        LinkedList<Subject> segundoCuatrimestre = new LinkedList<>();
        segundoCuatrimestre.add(algoritmicaProgramacionI);
        segundoCuatrimestre.add(arquitecturaComputadoras);
        segundoCuatrimestre.add(estadistica);

        Subject sistemasOrganizaciones = new Subject("Sistemas y Organizaciones", new LinkedList<>());


        LinkedList<Integer> correlativasBD = new LinkedList<>();
        correlativasBD.add(1);
        correlativasBD.add(4);
        Subject basesDatosI = new Subject("Bases de Datos I", correlativasBD);

        Subject ingenieriaSoftwareI = new Subject("Ingeniería de Software I", new LinkedList<>());

        LinkedList<Subject> tercerCuatrimestre = new LinkedList<>();
        tercerCuatrimestre.add(sistemasOrganizaciones);
        tercerCuatrimestre.add(basesDatosI);
        tercerCuatrimestre.add(ingenieriaSoftwareI);

        LinkedList<Integer> correlativasPydoo = new LinkedList<>();
        correlativasPydoo.add(4);
        Subject programacionDisenoOrientadoObjetos = new Subject("Programación y Diseño Orientado a Objetos", correlativasPydoo);
        LinkedList<Integer> correlativasFTI = new LinkedList<>();
        correlativasFTI.add(9);
        Subject fundamentosTeoricosInformatica = new Subject("Fundamentos Teóricos de Informática", correlativasFTI);

        LinkedList<Integer> correlativasIngII = new LinkedList<>();
        correlativasIngII.add(9);
        Subject ingenieriaSoftwareII = new Subject("Ingeniería de Software II", correlativasIngII);

        LinkedList<Subject> cuartoCuatrimestre = new LinkedList<>();
        cuartoCuatrimestre.add(programacionDisenoOrientadoObjetos);
        cuartoCuatrimestre.add(fundamentosTeoricosInformatica);
        cuartoCuatrimestre.add(ingenieriaSoftwareII);

        LinkedList<Integer> correlativasIntrConc = new LinkedList<>();
        correlativasIntrConc.add(4);
        correlativasIntrConc.add(10);
        Subject introduccionConcurrencia = new Subject("Introducción a la Concurrencia", correlativasIntrConc);

        LinkedList<Integer> correlativasLabProg = new LinkedList<>();
        correlativasLabProg.add(4);
        correlativasLabProg.add(10);
        Subject laboratorioProgramacionLenguajes = new Subject("Laboratorio de Programación y Lenguajes", correlativasLabProg);

        LinkedList<Integer> correlativasDBII = new LinkedList<>();
        correlativasDBII.add(8);
        Subject basesDatosII = new Subject("Bases de Datos II", correlativasDBII);

        LinkedList<Subject> quintoCuatrimestre = new LinkedList<>();
        quintoCuatrimestre.add(introduccionConcurrencia);
        quintoCuatrimestre.add(laboratorioProgramacionLenguajes);
        quintoCuatrimestre.add(basesDatosII);

        LinkedList<Integer> correlativaLabSOft = new LinkedList<>();
        correlativaLabSOft.add(14);
        Subject laboratorioSoftware = new Subject("Laboratorio de Software", correlativaLabSOft);
        Subject seminarioAspectosLegalesProfesionalesI = new Subject("Seminario de Aspectos Legales y Profesionales I", new LinkedList<>());

        LinkedList<Integer> correlativasSO = new LinkedList<>();
        correlativasSO.add(15);
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

        StudyProgram sistemasPrograma = new StudyProgram('A', programaSistemas);

        Career LicSistemas = new Career("Licenciatura en Sistemas", sistemasPrograma);

        alumnoUno.addMateriaAprobada(algebra);
        alumnoUno.addMateriaAprobada(analisisMatematico);
        alumnoUno.addMateriaAprobada(elementosLogicaMatematicaDiscreta);
        alumnoUno.addMateriaAprobada(estadistica);
        alumnoUno.addMateriaAprobada(algoritmicaProgramacionI);

        alumnoUno.setCursaCarrera(LicSistemas);
        alumnoUno.setCursaCarrera(new Career("Lic en Economia", new StudyProgram('A', new HashMap<>())));
    }
    public static void main(String[] args) {
        inicializar();
        //toda la aplicacion
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}
