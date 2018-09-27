package logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Pregunta")
public class MargueX extends Pregunta {

    List<String> respuestas;

    String correcta;

    public MargueX(){}

    public MargueX(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    public MargueX(String enunciado, String comentario, String grado, String tipo, String tema, String curso, List<String> respuestas, String correcta) {
        super(enunciado, comentario, grado, tipo, tema, curso);
        this.respuestas = respuestas;
        this.correcta = correcta;
    }

    @XmlElement(name = "Opciones")
    public String[] getRespuestas() {
        return this.toStringArray();
    }

    private String[] toStringArray(){
        String[] sAux = new String[this.respuestas.size()];
        for(int i = 0; i < this.respuestas.size(); i++){
            sAux[i] = this.respuestas.get(i);
        }
        return sAux;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    @XmlElement(name = "Correcta")
    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
}
