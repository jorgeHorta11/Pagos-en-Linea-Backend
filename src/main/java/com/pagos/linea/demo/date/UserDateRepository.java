package com.pagos.linea.demo.date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagos.linea.demo.entitys.User;

@Repository
public interface UserDateRepository extends JpaRepository<User, Long>{

}
