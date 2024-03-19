package com.example.berdugomail;

public class ListaElementos {
    private String color, name, ciudad, estado, emailContent;

    public ListaElementos(String color, String name, String ciudad, String estado, String emailContent) {
        this.color = color;
        this.name = name;
        this.ciudad = ciudad;
        this.estado = estado;
        this.emailContent = emailContent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
}
