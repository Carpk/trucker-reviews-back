package com.thekleinbottle.truckerreviews.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

  @Query("select po from PurchaseOrder po where po.invoice like %?1")
  List<PurchaseOrder> findByInvoiceWith(String invoice);

}
