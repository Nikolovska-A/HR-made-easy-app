package com.Nikolovska.spring.HRManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Nikolovska.spring.HRManagement.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{

}
