package ru.vgtrofimov.rsv;

public class Quest {

    String caption;
    int uchenik_volonter;
    int technar_gumanitariy;
    int online_offline;

    public Quest(String caption, int uchenik_volonter, int technar_gumanitariy, int online_offline) {
        this.caption = caption;
        this.uchenik_volonter = uchenik_volonter;
        this.technar_gumanitariy = technar_gumanitariy;
        this.online_offline = online_offline;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getUchenik_volonter() {
        return uchenik_volonter;
    }

    public void setUchenik_volonter(int uchenik_volonter) {
        this.uchenik_volonter = uchenik_volonter;
    }

    public int getTechnar_gumanitariy() {
        return technar_gumanitariy;
    }

    public void setTechnar_gumanitariy(int technar_gumanitariy) {
        this.technar_gumanitariy = technar_gumanitariy;
    }

    public int getOnline_offline() {
        return online_offline;
    }

    public void setOnline_offline(int online_offline) {
        this.online_offline = online_offline;
    }
}
