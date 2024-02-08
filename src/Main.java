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
        OptativeSubject deepLearning = new OptativeSubject("Deep Learning", false);
        licSistemas.addOptativeSubject(deepLearning);

        OptativeSubject inteligArtificial = new OptativeSubject("Inteligencia artificial I", false);
        licSistemas.addOptativeSubject(inteligArtificial);

        licSistemas.addOptativeSubject(new OptativeSubject("Inteligencia Artificial II", true));
        licSistemas.addOptativeSubject(new OptativeSubject("Ciencias de datos I", true));

        licSistemas.getPlanDeEstudio().setOptativeMinimun(2);

        alumnoUno.addMateriaAprobada(algebra, 9);
        alumnoUno.addMateriaAprobada(analisisMatematico, 8);
        alumnoUno.addMateriaAprobada(elementosLogicaMatematicaDiscreta, 9 );
        alumnoUno.addMateriaAprobada(estadistica, 5 );
        alumnoUno.addMateriaAprobada(algoritmicaProgramacionI ,10 );

        alumnoUno.setCursaCarrera(licSistemas);
        //alumnoUno.setCursaCarrera(LicEconomia);


        Student alumnoDos = new Student("Juan", "Pérez", "juan.perez@gmail.com", "123456".toCharArray());
        Student alumnoTres = new Student("María", "García", "maria.garcia@gmail.com", "abcdef".toCharArray());
        Student alumnoCuatro = new Student("Jesus", "Rodriguez", "jesus@gmail.com", "dios".toCharArray());

        alumnoDos.setCursaCarrera(licSistemas);

        alumnoTres.setCursaCarrera(licSistemas);
        for (Subject subject : licSistemas.getPlanDeEstudio().getAllSubjects()) {
            alumnoTres.addMateriaAprobada(subject, 10);
        }
        alumnoTres.addMateriaAprobada(deepLearning,9);
        alumnoTres.addMateriaAprobada(inteligArtificial, 10);

        Map<Integer, LinkedList<Subject>> map = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            map.put(i, new LinkedList<>());
        }
        //Lic en economia
        Career licEconomia = new Career("Lic en Economia", new StudyProgram(map));

        // Creamos algunas instancias de materia ficticias
        Subject matematicas1 = new Subject("Matemáticas I", true);
        Subject economia1 = new Subject("Economía I", true);
        Subject estadistica1 = new Subject("Estadística I", true);
        Subject contabilidad1 = new Subject("Contabilidad I", true);

// Agregamos las materias al primer cuatrimestre
        licEconomia.addSubject(1, matematicas1);
        licEconomia.addSubject(1, economia1);
        licEconomia.addSubject(1, estadistica1);
        licEconomia.addSubject(1, contabilidad1);

// Creamos más instancias de materia ficticias
        Subject matematicas2 = new Subject("Matemáticas II", true);
        Subject economia2 = new Subject("Economía II", true);
        Subject estadistica2 = new Subject("Estadística II", true);
        Subject contabilidad2 = new Subject("Contabilidad II", true);
        Subject historiaEconomica = new Subject("Historia Económica", true);

// Agregamos las materias al segundo cuatrimestre
        licEconomia.addSubject(2, matematicas2);
        licEconomia.addSubject(2, economia2);
        licEconomia.addSubject(2, estadistica2);
        licEconomia.addSubject(2, contabilidad2);
        licEconomia.addSubject(2, historiaEconomica);

// Creamos más instancias de materia ficticias
        Subject economia3 = new Subject("Economía III", true);
        Subject metodologiaInvestigacion = new Subject("Metodología de la Investigación", false);
        Subject econometria = new Subject("Econometría", false);
        Subject politicaEconomica = new Subject("Política Económica", false);
        Subject gestionPublica = new Subject("Gestión Pública", false);
// Agregamos las materias al tercer cuatrimestre
        licEconomia.addSubject(3, economia3);
        licEconomia.addSubject(3, metodologiaInvestigacion);
        licEconomia.addSubject(3, econometria);
        licEconomia.addSubject(3, politicaEconomica);
        licEconomia.addSubject(3, gestionPublica);

        economia2.setCorrelativas(economia1);
        economia3.setCorrelativas(economia2);

// Creamos más instancias de materia ficticias
        Subject economia4 = new Subject("Economía IV", true);
        economia4.setCorrelativas(economia3);
        Subject finanzasPublicas = new Subject("Finanzas Públicas", false);
        Subject derecho = new Subject("Derecho", false);
        Subject administracion = new Subject("Administración", false);
        Subject mercadoFinanciero = new Subject("Mercado Financiero", false);

// Agregamos las materias al cuarto cuatrimestre
        licEconomia.addSubject(4, economia4);
        licEconomia.addSubject(4, finanzasPublicas);
        licEconomia.addSubject(4, derecho);
        licEconomia.addSubject(4, administracion);
        licEconomia.addSubject(4, mercadoFinanciero);

        // Creamos más instancias de materia ficticias para el cuarto cuatrimestre
        Subject macroeconomia = new Subject("Macroeconomía", true);
        Subject metodosMatematicos = new Subject("Métodos Matemáticos", false);
        Subject teoriaMonetaria = new Subject("Teoría Monetaria", false);
        Subject comercioInternacional = new Subject("Comercio Internacional", false);
        Subject inversion = new Subject("Inversión", false);

// Agregamos las materias al cuarto cuatrimestre adicional
        licEconomia.addSubject(5, macroeconomia);
        licEconomia.addSubject(5, metodosMatematicos);
        licEconomia.addSubject(5, teoriaMonetaria);
        licEconomia.addSubject(5, comercioInternacional);
        licEconomia.addSubject(5, inversion);

// Creamos más instancias de materia ficticias para el quinto cuatrimestre
        Subject historiaDelPensamientoEconomico = new Subject("Historia del Pensamiento Económico", false, 'C');
        Subject administracionDeEmpresas = new Subject("Administración de Empresas", false, 'D');
        Subject mercadosDeCapitales = new Subject("Mercados de Capitales", false, 'E');
        Subject economiaDelTrabajo = new Subject("Economía del Trabajo", false, 'B');
        Subject analisisDeInversion = new Subject("Análisis de Inversión", false, 'C');

// Agregamos las materias al quinto cuatrimestre
        licEconomia.addSubject(6, historiaDelPensamientoEconomico);
        licEconomia.addSubject(6, administracionDeEmpresas);
        licEconomia.addSubject(6, mercadosDeCapitales);
        licEconomia.addSubject(6, economiaDelTrabajo);
        licEconomia.addSubject(6, analisisDeInversion);

// Creamos más instancias de materia ficticias para el sexto cuatrimestre
        Subject economiaUrbana = new Subject("Economía Urbana", false, 'D');
        Subject economiaDelMedioAmbiente = new Subject("Economía del Medio Ambiente", false, 'C');
        Subject finanzasPublicasAvanzadas = new Subject("Finanzas Públicas Avanzadas", false, 'E');
        Subject teoriaDeJuegos = new Subject("Teoría de Juegos", false, 'B');
        Subject economiaBancaria = new Subject("Economía Bancaria", false, 'C');

// Agregamos las materias al sexto cuatrimestre
        licEconomia.addSubject(7, economiaUrbana);
        licEconomia.addSubject(7, economiaDelMedioAmbiente);
        licEconomia.addSubject(7, finanzasPublicasAvanzadas);
        licEconomia.addSubject(7, teoriaDeJuegos);
        licEconomia.addSubject(7, economiaBancaria);

// Creamos más instancias de materia ficticias para el séptimo cuatrimestre
        Subject economiaDeLaSalud = new Subject("Economía de la Salud", false, 'C');
        Subject economiaDeLaEducacion = new Subject("Economía de la Educación", false, 'B');
        Subject politicasEconomicas = new Subject("Políticas Económicas", false, 'D');
        Subject economiaInternacionalAvanzada = new Subject("Economía Internacional Avanzada", false, 'E');
        Subject metodosEconometricosAvanzados = new Subject("Métodos Econométricos Avanzados", false, 'C');

// Agregamos las materias al séptimo cuatrimestre
        licEconomia.addSubject(8, economiaDeLaSalud);
        licEconomia.addSubject(8, economiaDeLaEducacion);
        licEconomia.addSubject(8, politicasEconomicas);
        licEconomia.addSubject(8, economiaInternacionalAvanzada);
        licEconomia.addSubject(8, metodosEconometricosAvanzados);

        licEconomia.getPlanDeEstudio().setOptativeMinimun(1);
        licEconomia.addOptativeSubject(new OptativeSubject("Inteligencia artificial basica", true));
        licEconomia.addOptativeSubject(new OptativeSubject("Python excel", true));


    }
    public static void main(String[] args) {
        inicializar();
        //toda la aplicacion
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}
