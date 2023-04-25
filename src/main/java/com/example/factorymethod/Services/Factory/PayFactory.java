package com.example.factorymethod.Services.Factory;

import com.example.factorymethod.Services.*;

public class PayFactory extends AbstractPayFactory{
    @Override
    public IPay payFactory(TipoPay canal) {
        switch (canal){

            case BOTON_BANCOLOMBIA -> {                            // No tiene sentido un break si le dijimos return, no lo va a aejecutar
                return new BotonBancolombia();                      // ConcreteFactory
            }
            case PSE -> {
                return new Pse();
            }
            case WOMPI -> {
                return new Wompi();
            }
            case OTRO -> {
                return new Otro();
            }

        } return null;
    }
}

