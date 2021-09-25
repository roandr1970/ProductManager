package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Windows 11", 500, "Bill");
    Product second = new Smartphone(2, "samsung", 20000, "Korea");
    Product third = new Smartphone(3, "samsung", 15000, "Korea");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldTwoProducts() {

        Product[] actual = manager.searchBy("samsung");
        Product[] expected = new Product[] { second, third };
        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldOneProduct() {

        Product[] actual = manager.searchBy("Bill");
        Product[] expected = new Product[] { first };
        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldNoProduct() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[] {};
        assertArrayEquals (expected, actual);
    }

}