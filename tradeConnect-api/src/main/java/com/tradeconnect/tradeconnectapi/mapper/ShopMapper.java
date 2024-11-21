package com.tradeconnect.tradeconnectapi.mapper;

import com.tradeconnect.tradeconnectapi.dto.Shop.CreateShopRequest;
import com.tradeconnect.tradeconnectapi.dto.Shop.ShopResponse;
import com.tradeconnect.tradeconnectapi.dto.Shop.UpdateShopRequest;
import com.tradeconnect.tradeconnectapi.model.Shop;

import java.util.List;

public class ShopMapper {
    public static ShopResponse toShopResponse(Shop shop) {
        return new ShopResponse(
                shop.getId(),
                shop.getName(),
                shop.getAddress(),
                shop.getPhone(),
                shop.getEmail(),
                shop.getWebsite(),
                shop.getDescription(),
                shop.getShopType(),
                shop.getLogo(),
                shop.getBanner()
        );
    }

    public static List<ShopResponse> toShopResponseList(List<Shop> all) {
        return all.stream()
                .map(ShopMapper::toShopResponse)
                .toList();
    }

    public static Shop toShop(CreateShopRequest createShopRequest) {
        return Shop.builder()
                .name(createShopRequest.name())
                .address(createShopRequest.address())
                .phone(createShopRequest.phone())
                .email(createShopRequest.email())
                .website(createShopRequest.website())
                .description(createShopRequest.description())
                .shopType(
                        createShopRequest.shopType() == null
                                ? "General"
                                : createShopRequest.shopType()
                )
                .logo(createShopRequest.logo())
                .banner(createShopRequest.banner())
                .build();
    }

    public static Shop UpdateShopRequesttoShop(UpdateShopRequest updateShopRequest, Shop shop) {
        return Shop.builder()
                .id(updateShopRequest.id())
                .name(updateShopRequest.name())
                .address(updateShopRequest.address())
                .phone(updateShopRequest.phone())
                .email(updateShopRequest.email())
                .website(updateShopRequest.website())
                .description(updateShopRequest.description())
                .shopType(
                        updateShopRequest.shopType() == null
                                ? "General"
                                : updateShopRequest.shopType()
                )
                .logo(updateShopRequest.logo())
                .banner(updateShopRequest.banner())
                .build();
    }
}
