package com.serviceLayer.service.interfaces;

import com.dataLayer.entity.dto.TransferDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface TransferService {
    void createTransfer(int bookId, Authentication authentication);

    void closeTransfer(int transferId);

    List<TransferDTO> getListBookTransfers(int bookId);

    List<TransferDTO> getCurrentBooks(Authentication authentication);

    List<TransferDTO> getHistoryBooks(Authentication authentication);
}
