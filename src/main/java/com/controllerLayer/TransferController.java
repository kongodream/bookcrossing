package com.controllerLayer;

import com.dataLayer.entity.dto.TransferDTO;
import com.serviceLayer.service.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TransferController {
    @Autowired
    TransferService transferService;

    @RequestMapping(value = "/api/books/{bookId}/transfer", method = RequestMethod.POST)
    public void newTransfer(@PathVariable("bookId") int bookId, Authentication authentication) {
        transferService.createTransfer(bookId, authentication);
    }

    @RequestMapping(value = "/api/transfers/current/{transferId}", method = RequestMethod.POST)
    public
    @ResponseBody
    int closeTransfer(@PathVariable("transferId") int transferId) {
        transferService.closeTransfer(transferId);
        return transferId;
    }

    @RequestMapping(value = "/api/books/{bookId}/transfers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TransferDTO> getBookTransferList(@PathVariable("bookId") int bookId) {
        return transferService.getListBookTransfers(bookId);
    }

    @RequestMapping(value = "/api/transfers/current", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TransferDTO> getCurrentBooks(Authentication authentication) {
        return transferService.getCurrentBooks(authentication);
    }

    @RequestMapping(value = "/api/transfers/all", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TransferDTO> getHistoryBooks(Authentication authentication) {
        return transferService.getHistoryBooks(authentication);
    }
}

