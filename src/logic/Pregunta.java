package logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Pregunta")
/**
 * Clase encargada de modelar el comportamiento de una pregunta ya sea de desarrollo o de respuesta corta.
 */
public class Pregunta {

    private String enunciado;

    private String comentario;

    private String respuesta;

    private String grado;

    private String tipo;

    private String tema;

    private String curso;

    public Pregunta(){
    }

    public Pregunta(String enunciado, String comentario, String respuesta, String grado, String tipo, String tema, String curso) {
        this.enunciado = enunciado;
        this.comentario = comentario;
        this.respuesta = respuesta;
        this.grado = grado;
        this.tipo = tipo;
        this.tema = tema;
        this.curso = curso;
    }

    public Pregunta(String enunciado, String comentario, String grado, String tipo, String tema, String curso) {
        this.enunciado = enunciado;
        this.comentario = comentario;
        this.grado = grado;
        this.tipo = tipo;
        this.tema = tema;
        this.curso = curso;
    }

    @XmlElement(name = "Enunciado")
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @XmlElement(name = "Comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlElement(name = "Respuesta")
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @XmlElement(name = "Grado")
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @XmlElement(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlElement(name = "Tema")
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @XmlElement(name = "Curso")
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
