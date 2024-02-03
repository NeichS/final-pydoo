package AppClasses;

public class CantidadCuatrimestreException extends Exception{
    public CantidadCuatrimestreException(Integer num){
        System.out.println("La materia es de tipo plan correlativa 'C' (aprobó las cursadas de las correlativas y los finales de todas las materias de 5\n" +
                "cuatrimestres previos al que se quiere anotar) pero la materia se encuentra en un cuatrimestre menor o igual a " + num + ". Se analizan todas las materias anteriores de todas formas ");
    }
}
