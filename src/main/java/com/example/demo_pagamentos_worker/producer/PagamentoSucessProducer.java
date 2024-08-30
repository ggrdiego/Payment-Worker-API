package com.example.demo_pagamentos_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoSucessProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void geraResposta(String message) {
                                  
        amqpTemplate.convertAndSend(
            "pagamento-response-sucesso-exchange",
            "pagamento-response-sucesso-rout-key",
            message);
    }


}
