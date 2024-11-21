package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.Shop.CreateShopRequest;
import com.tradeconnect.tradeconnectapi.dto.Shop.ShopResponse;
import com.tradeconnect.tradeconnectapi.dto.Shop.UpdateShopRequest;
import com.tradeconnect.tradeconnectapi.mapper.ShopMapper;
import com.tradeconnect.tradeconnectapi.model.Role;
import com.tradeconnect.tradeconnectapi.model.Shop;
import com.tradeconnect.tradeconnectapi.model.User;
import com.tradeconnect.tradeconnectapi.repository.ShopRepository;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    public ShopResponse getShopById(Long id) {
        return shopRepository.findById(id)
                .map(ShopMapper::toShopResponse)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public List<ShopResponse> getAllShops() {
        return ShopMapper.toShopResponseList(shopRepository.findAll());
    }

    public ShopResponse addShop(CreateShopRequest createShopRequest) {
        // cheack the user already exist
        Long userId = createShopRequest.userId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // if the user didn't verify the kyc, he/she can't create a shop
        if(user.getRole() != Role.ROLE_SELLER) {
            throw new RuntimeException("User is not a shop owner");
        }

        // check the user already have a shop
        if(shopRepository.existsByUserId(userId)) {
            throw new RuntimeException("User already have a shop");
        }

        // create a shop
        return ShopMapper.toShopResponse(shopRepository.save(ShopMapper.toShop(createShopRequest)));
    }

    public ShopResponse updateShop(UpdateShopRequest updateShopRequest) {
        // find the shop
        Shop shop = shopRepository.findById(updateShopRequest.id())
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        // update the shop
        return ShopMapper.toShopResponse(shopRepository.save(ShopMapper.UpdateShopRequesttoShop(updateShopRequest, shop)));
    }
}
