package com.example.orderingSystem.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.orderingSystem.model.pojo.ItemDao;
import com.example.orderingSystem.services.ItemService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/item", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class itemController {
    private final ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<ItemDao> addItem(@RequestBody @Valid ItemDao itemDao) {
        return new ResponseEntity<>(itemService.addItem(itemDao).get(), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ItemDao>> getAllItemsByOrderId(@RequestParam("id") Long orderId) {
        return new ResponseEntity<>(itemService.getAllItemsByOrderId(orderId).get(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ItemDao> updateItem(@RequestBody @Valid ItemDao itemDao, @PathVariable("id") Long itemId) {
        return new ResponseEntity<>(itemService.updateItem(itemDao, itemId).get(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemDao> findItemById(@PathVariable("id") Long itemId) {
        return new ResponseEntity<>(itemService.getItemById(itemId).get(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeItem(@PathVariable("id") Long itemId) {
        itemService.removeItem(itemId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}

