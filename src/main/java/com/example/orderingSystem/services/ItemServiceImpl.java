package com.example.orderingSystem.services;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.orderingSystem.mapper.ItemMapper;
import com.example.orderingSystem.model.entity.ItemEntity;
import com.example.orderingSystem.model.pojo.ItemDao;
import com.example.orderingSystem.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper mapper;
    private final ItemRepository itemRepository;

    @Override
    public Optional<ItemDao> addItem(ItemDao item) {
        ItemEntity itemEntity = mapper.itemDaoMapToItemEntity(item);
        itemRepository.save(itemEntity);
        return Optional.ofNullable(mapper.itemEntityMapToItemDao(itemEntity));

    }

    @Override
    public Optional<ItemDao> updateItem(ItemDao item, Long itemId) {
        ItemEntity itemEntity = new ItemEntity();
        if (itemRepository.existsById(itemId)) {
            itemRepository.findById(itemId).get();
            itemEntity = mapper.itemDaoMapToItemEntity(item);
            itemEntity.setId(Math.toIntExact(itemId));
            itemRepository.save(itemEntity);
            return Optional.ofNullable(mapper.itemEntityMapToItemDao(itemEntity));
        }
        mapper.itemDaoMapToItemEntity(item);
        itemRepository.save(itemEntity);
        return Optional.ofNullable(mapper.itemEntityMapToItemDao(itemEntity));

    }

    @Override
    public Optional<List<ItemDao>> getAllItemsByOrderId(Long orderId) {
        List<ItemEntity> list = itemRepository.findItemEntitiesByorder_Id(orderId);
        return Optional.of(list.stream().map(item -> mapper.itemEntityMapToItemDao(item)).collect(Collectors.toList()));
    }

    @Override
    public Optional<ItemDao> getItemById(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).get();
        return Optional.ofNullable(mapper.itemEntityMapToItemDao(itemEntity));
    }

    @Override
    public void removeItem(Long itemId) {
        if (itemRepository.existsById(itemId))
            itemRepository.deleteById(itemId);
    }

}
