package com.example.factorymethod.Services;

public class Otro implements IPay{
    @Override
    public String Pay() {
        return "Pagando con Otros...";
    }
}
