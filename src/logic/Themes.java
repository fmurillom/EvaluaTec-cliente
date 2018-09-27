package logic;

import java.util.Objects;

public class Themes {

    private String name;

    private Integer mxQuest;

    private Integer respCor;

    private Integer dess;

    public Themes(){
        this.name = new String();

        this.dess = new Integer(0);

        this.mxQuest = new Integer(0);

        this.respCor = new Integer(0);
    };

    public Themes(String name, Integer mxQuest, Integer respCor, Integer dess) {
        this.name = name;
        this.mxQuest = mxQuest;
        this.respCor = respCor;
        this.dess = dess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMxQuest() {
        return mxQuest;
    }

    public void setMxQuest(Integer mxQuest) {
        this.mxQuest = mxQuest;
    }

    public Integer getRespCor() {
        return respCor;
    }

    public void setRespCor(Integer respCor) {
        this.respCor = respCor;
    }

    public Integer getDess() {
        return dess;
    }

    public void setDess(Integer dess) {
        this.dess = dess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Themes themes = (Themes) o;
        return Objects.equals(name, themes.name) &&
                Objects.equals(mxQuest, themes.mxQuest) &&
                Objects.equals(respCor, themes.respCor) &&
                Objects.equals(dess, themes.dess);
    }
}
