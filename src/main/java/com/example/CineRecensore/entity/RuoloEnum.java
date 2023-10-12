package com.example.CineRecensore.entity;

public enum RuoloEnum {
    ADMIN("Utente amministratore"),
    USER("Utente registrato"),
    GUEST("Utente non registrato");
    private String info;
    RuoloEnum(String info){
        this.info = info;
    }
    public String getInfoUtente(){
        return info;
    }
}
