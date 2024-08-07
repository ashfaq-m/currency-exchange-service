package com.demo.microservices.currencyexchangeservice.controller;

import com.demo.microservices.currencyexchangeservice.entity.CurrencyExchange;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final Environment environment;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange getExchangeService(
            @PathVariable String from,
            @PathVariable String to
    ){
        CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(83));
        String port = environment.getProperty("local.server.port");

        currencyExchange.setEnvironment(port);

        return currencyExchange;

    }
}
