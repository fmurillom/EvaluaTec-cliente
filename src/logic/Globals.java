package logic;

import Server.Server;

import java.util.*;

public final class Globals {

    private static List<Themes> themesEv;

    private static List<Curso> cursos;

    private static String selectedCourse;

    private static Pregunta preguntaGen;

    private static String warning;

    private static Stack<String> messages;

    public Globals(){
        themesEv = new LinkedList<>();
        cursos = new LinkedList<>();

        selectedCourse = "";

        warning = "";

        messages = new Stack<>();

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

    public static void pushQ(String add){messages.push(add);}

    public static String popQ(){return messages.pop();}

    public static boolean qEmpty(){return messages.empty();}
}
