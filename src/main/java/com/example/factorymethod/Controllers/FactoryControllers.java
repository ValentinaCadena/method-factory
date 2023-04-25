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
    private PayFactory factory = new PayFactory();

    @RequestMapping("/{canal}")
    public ResponseEntity<String> Pagar(@PathVariable("canal") String canal) {

        switch (canal){

            case "bancolombia":
                paymentService = factory.payFactory(TipoPay.BOTON_BANCOLOMBIA);
                break;

            /* Utilizamos el Factory para realizar una nueva instancia, para que los new los haga él
            y no nosotros, es mejor tener la lógica de la creación separada
            (principio de la responsabilidad unica)*/

            case "pse":
                paymentService = factory.payFactory(TipoPay.PSE);
                break;

            case "wompi":
                paymentService = factory.payFactory(TipoPay.WOMPI);
                break;

            case "otros":
                paymentService = factory.payFactory(TipoPay.OTRO);
                break;

            default:
                return new ResponseEntity<>("Metodo de pago no valido!", HttpStatus.BAD_REQUEST);
        }
        System.out.println(paymentService);
        String pago = paymentService.Pay();
        System.out.println(pago);
        return new ResponseEntity<>(pago, HttpStatus.OK);
    }

}
