package com.pagos.linea.demo.date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagos.linea.demo.entitys.Pagos;

public interface PagosDateRepository extends JpaRepository<Pagos, Long>{

}
