package com.thekleinbottle.truckerreviews.domain;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<PurchaseItem, Long> {

}
