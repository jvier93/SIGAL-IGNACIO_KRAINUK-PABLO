package com.company.modelos;

public class Odontologo {

    private int id;
    private int numMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(int id, int numMatricula, String nombre, String apellido) {
        this.id = id;
        this.numMatricula = numMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }



    public int getNumMatricula() {
        return numMatricula;
    }

    public Odontologo(int numMatricula, String nombre, String apellido) {
        this.numMatricula = numMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", numMatricula=" + numMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
