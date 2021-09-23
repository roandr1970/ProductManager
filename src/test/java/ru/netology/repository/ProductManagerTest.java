package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldSearchBy() {

        ProductManager manager = new ProductManager();

        Product book = new Book(1, "Windows 11", 500, "Bil");
        Product smartphone = new Smartphone(2, "samsung", 10000, "korea");

        manager.add(book);
        manager.add(smartphone);
        manager.searchBy("Windows 11");

        Product[] actual = manager.matches(book, "Windows 11");




    }
}