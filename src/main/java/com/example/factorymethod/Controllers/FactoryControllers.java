package com.example.factorymethod.Controllers;

import com.example.factorymethod.Services.Factory.PayFactory;
import com.example.factorymethod.Services.Factory.TipoPay;
import com.example.factorymethod.Services.IPay;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/pay")
@RestController

public class FactoryControllers {

    private IPay paymentService;
    private PayFactory factory;

    @RequestMapping("/{canal}")
    public ResponseEntity<HttpStatus> Pagar(@PathVariable("canal") String canal) {

        switch (canal){

            case "BotonBancolombia": paymentService = factory.payFactory(TipoPay.BOTON_BANCOLOMBIA);

            /* Utilizamos el Factory para realizar una nueva instancia, para que los new los haga él
            y no nosotros, es mejor tener la lógica de la creación separada
            (principio de la responsabilidad unica)*/

            case "pse": paymentService = factory.payFactory(TipoPay.PSE);

            case "Wompi": paymentService = factory.payFactory(TipoPay.WOMPI);

            case "Otros": paymentService = factory.payFactory(TipoPay.OTRO);

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
