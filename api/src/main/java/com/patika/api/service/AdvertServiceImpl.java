package com.patika.api.service;

import com.patika.api.domain.SaleAdvertisement;
import com.patika.api.domain.User;
import com.patika.api.repository.AdvertRepository;
import com.patika.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService{

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public AdvertServiceImpl(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @Override
    public SaleAdvertisement createAdvert(SaleAdvertisement saleAdvertisement, Long userId) {
        User user = userRepository.getById(Long.valueOf(userId));
        saleAdvertisement.setUser(user);
        return advertRepository.save(saleAdvertisement);
    }

    @Override
    public List<SaleAdvertisement> getAllByUser(Long userId) {
        User foundedUser = userRepository.getById(userId);
        return advertRepository.getAllByUser(foundedUser);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementsByTitleContainingIgnoreCase(String title) {
        return advertRepository.findSaleAdvertisementsByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementsByDetailsContainingIgnoreCase(String detail) {
        return advertRepository.findSaleAdvertisementsByDetailsContainingIgnoreCase(detail);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time) {
        return advertRepository.findSaleAdvertisementsByCreatedAtOrderByCreatedAtAsc(time);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time) {
        return advertRepository.findSaleAdvertisementsByCreatedAtOrderByCreatedAtDesc(time);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementsByPriceBetween(String price1, String price2) {
        return advertRepository.findSaleAdvertisementsByPriceBetween(price1,price2);
    }


}
