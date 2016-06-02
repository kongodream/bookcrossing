package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.ExchangeDAO;
import com.bookcrossing.dataLayer.entity.Exchange;
import com.bookcrossing.serviceLayer.service.interfaces.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private ExchangeDAO exchangeDAO;

    @Override
    public void saveExchange(Exchange exchange) {
        exchangeDAO.save(exchange);
    }
}
