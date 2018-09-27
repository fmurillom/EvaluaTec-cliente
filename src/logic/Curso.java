package logic;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Cursos")
public class Curso {


    private String nombre;

    private String codigo;

    List<String> temas;

    @XmlElement(name = "Nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "Codigo")
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlElement(name = "Temas")
    public List<String> getTemas() {
        return temas;
    }
    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public Curso(String nombre, String codigo, List<String> temas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.temas = temas;
    }

    Curso(){};
}
