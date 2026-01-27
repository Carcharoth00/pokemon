package com.example.proyecto1.model;

import java.io.Serializable;
import java.util.Objects;

public class Pokemon implements Serializable {

    private String nombre;
    private int image;
    private String numero;

    public Pokemon(String nombre, int image, String numero) {
        this.nombre = nombre;
        this.image = image;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pokemon)) return false;
        Pokemon pokemon = (Pokemon) o;
        return image == pokemon.image && Objects.equals(nombre, pokemon.nombre) && Objects.equals(numero, pokemon.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, image, numero);
    }
}
