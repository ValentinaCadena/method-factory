package com.example.factorymethod.Services.Factory;

import com.example.factorymethod.Services.IPay;

public abstract class AbstractPayFactory {

    public abstract IPay payFactory(TipoPay canal);               //Clase padre, firma, no se puede instancear.
}
