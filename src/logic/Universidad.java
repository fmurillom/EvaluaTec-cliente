package logic;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;


/**
 * Clase encargada de modelar el comportamiento de una Universidad incluyendoo sus escuelas y areas academicas.
 */
public class Universidad {

    private String nombre;
    private List<String> escuelas;
    private List<String> cursos;
    private List<String>  areasA;

    public Universidad() {
        this.escuelas = new LinkedList<>();
        this.cursos = new LinkedList<>();
        this.areasA = new LinkedList<>();

    }

    public Universidad(String nombre, List<String> escuelas, List<String> cursos, List<String> areasA) {
        this.nombre = nombre;
        this.escuelas = escuelas;
        this.cursos = cursos;
        this.areasA = areasA;
    }

    @XmlElement(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "Escuela")
    public List<String> getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(List<String> escuelas) {
        this.escuelas = escuelas;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public List<String> getAreasA() {
        return areasA;
    }

    public void setAreasA(List<String> areasA) {
        this.areasA = areasA;
    }
}
