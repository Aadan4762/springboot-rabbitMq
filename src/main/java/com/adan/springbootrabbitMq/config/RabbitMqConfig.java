package com.adan.springbootrabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.routingKey.name}")
    private String routingKey;

//create Queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }
//create exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    //bind exchange to queue
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }
    //Connection Factory
    //RabbitTemplate
    //RabbitAdmin
}
