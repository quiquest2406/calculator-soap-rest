package com.example.calculator.client;




import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

@Component
public class CalculatorSoapClient {

    private final CalculatorSoap port;

    public CalculatorSoapClient(
            @Value("${soap.calculator.endpoint}") String endpoint) {

        try {
            URL wsdlUrl = getClass()
                    .getClassLoader()
                    .getResource("wsdl/Calculator.wsdl");

            if (wsdlUrl == null) {
                throw new IllegalStateException(
                    "No se encuentra wsdl/Calculator.wsdl");
            }

            // Crear el servicio usando el WSDL local.
            Calculator service = new Calculator(wsdlUrl);

            // Obtener el cliente que expone las operaciones SOAP.
            this.port = service.getCalculatorSoap();

            // Configurar dónde se ejecutará la operación.
            BindingProvider bindingProvider =
                    (BindingProvider) this.port;

            bindingProvider.getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    endpoint);

        } catch (Exception e) {
            throw new IllegalStateException(
                    "No se pudo inicializar el cliente SOAP", e);
        }
    }

    public int add(int a, int b) {
        return port.add(a, b);
    }

    public int subtract(int a, int b) {
        return port.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return port.multiply(a, b);
    }

    public int divide(int a, int b) {
        return port.divide(a, b);
    }
}
