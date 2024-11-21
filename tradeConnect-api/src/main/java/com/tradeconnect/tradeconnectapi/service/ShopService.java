package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
}
