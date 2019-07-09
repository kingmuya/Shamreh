package com.example.fireness;

public class item {
    private String jina,arafa,siri,id;

    public item(String jina, String arafa, String siri, String id) {
        this.jina = jina;
        this.arafa = arafa;
        this.siri = siri;
        this.id = id;
    }

    public item() {
    }

    public String getJina() {
        return jina;
    }

    public void setJina(String jina) {
        this.jina = jina;
    }

    public String getArafa() {
        return arafa;
    }

    public void setArafa(String arafa) {
        this.arafa = arafa;
    }

    public String getSiri() {
        return siri;
    }

    public void setSiri(String siri) {
        this.siri = siri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
