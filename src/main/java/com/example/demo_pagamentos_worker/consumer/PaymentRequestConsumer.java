package com.example.demo_pagamentos_worker.consumer;



import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo_pagamentos_worker.producer.PagamentoErrorProducer;
import com.example.demo_pagamentos_worker.producer.PagamentoSucessProducer;


@Component
public class PaymentRequestConsumer {
	
	@Autowired private PagamentoErrorProducer paymentError;
	@Autowired private PagamentoSucessProducer paymentSucess;
	
	
	@RabbitListener(queues = {"pagamento-request-queue"})
	public void receiveMensseger (@Payload Message<String> message) {
		System.out.println(message);
		if(new Random().nextBoolean() == true) {
			paymentError.geraResposta("sucesso" + message.toString());
		}else {
			paymentSucess.geraResposta("error" + message.toString());
		}
		
	}
	

}
