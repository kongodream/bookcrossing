package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.Exchange;
import com.bookcrossing.dataLayer.entity.dto.exchange.ExchangeDTO;
import com.bookcrossing.serviceLayer.service.interfaces.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(value = "/api/exchanges", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createExchange(@RequestBody ExchangeDTO exchange) {
        System.out.println(exchange);
//        exchangeService.saveExchange(exchange);
        return;
    }
}
