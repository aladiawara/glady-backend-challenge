package com.glady.deposit;

public enum Type {
    GIFT("Gift"),
    MEAL("Meal");
    private final String libelle;

    Type(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
