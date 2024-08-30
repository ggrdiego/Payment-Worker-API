package com.example.demo_pagamentos_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class PagamentoErrorProducer {
	
    @Autowired
    private AmqpTemplate amqpTemplate;


    public void geraResposta(String message) { 
                             
        amqpTemplate.convertAndSend(
            "pagamento-response-erro-exchange",
            "pagamento-response-erro-rout-key",
            message);
    }

}
