package com.pagos.linea.demo.date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagos.linea.demo.entitys.CustomerBill;

public interface CustomerBillDataRepository extends JpaRepository<CustomerBill, Long> {

}
