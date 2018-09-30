package com.andi.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends
        JpaRepository<ExchangeValue, Long> {

        // default method
        ExchangeValue findByFromAndTo(String from, String to);

}
