package logic;

import java.util.*;

public final class Globals {

    private static List<Themes> themesEv;

    private static List<Curso> cursos;

    private static String selectedCourse;

    private static Pregunta preguntaGen;

    private static String warning;

    public Globals(){
        themesEv = new LinkedList<>();
        cursos = new LinkedList<>();

        selectedCourse = "";

        warning = "";

    }

    static final private Globals global = new Globals();

    static public List<Themes> getThemesEv() {
        return themesEv;
    }

    public static List<Curso> getCursos() {
        return cursos;
    }

    public static String getSelectedCourse() {
        return selectedCourse;
    }

    public static void setSelectedCourse(String selectedCourse2) {
        selectedCourse = selectedCourse2;
    }

    public static Pregunta getPreguntaGen(){
        return preguntaGen;
    }

    public static void setPreguntaGen(Pregunta preg){
        preguntaGen = preg;
    }
}
