package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
