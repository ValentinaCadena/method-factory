package com.example.factorymethod.Services;

public class BotonBancolombia implements IPay{

    @Override
    public String Pay() {
        return "Pagando...";
    }
}
