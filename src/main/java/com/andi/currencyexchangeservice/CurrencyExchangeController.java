package com.andi.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                                @PathVariable String to) {
        ExchangeValue exchangeValue = new ExchangeValue(
                1000L, from, to, BigDecimal.valueOf(0.6));

        exchangeValueRepository.findByFromAndTo(from, to);

        exchangeValue.setPortNumber(
                Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }

}
