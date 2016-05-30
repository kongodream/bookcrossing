package com.bookcrossing.dataLayer.dao.interfaces;

import com.bookcrossing.dataLayer.entity.Transfer;

import java.util.List;

public interface TransferDAO {
    void save(Transfer transfer);

    void closeTransfer(Transfer transfer);

    Transfer getTransferById(int transferId);

    List<Transfer> getListOfBookByUser(int userId);

    List<Transfer> getListOfBookTransfer(int bookId);

}
