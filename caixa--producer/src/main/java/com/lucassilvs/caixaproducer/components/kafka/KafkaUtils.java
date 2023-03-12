package com.lucassilvs.caixaproducer.components.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class KafkaUtils<T> {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Value("${spring.kafka.nome-topico}")
    private String nomeTopico;

    @Autowired
    public KafkaUtils(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void postarMensagem(T mensagem){
        logger.log(Level.INFO, "Postando mensagem no tópico:  {0}" , nomeTopico);
        kafkaTemplate.send(nomeTopico, mensagem);
        logger.info("mensagem enviada com sucesso");
    }
}
