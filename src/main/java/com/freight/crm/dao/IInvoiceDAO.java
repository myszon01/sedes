package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.Invoice;

public interface IInvoiceDAO {
	List<Invoice> getAllInvoices();
	Invoice getInvoiceById(int invoiceId);
    void addInvoice(Invoice invoice);
    void updateInvoice(Invoice invoice);
    void deleteInvoice(int invoiceId);
}
