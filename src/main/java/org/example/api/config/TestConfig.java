package org.example.api.config;

import org.example.api.entities.Products;
import org.example.api.entities.Category;
import org.example.api.entities.Order;
import org.example.api.entities.User;
import org.example.api.entities.enums.OrderStatus;
import org.example.api.repositories.CategoryRepository;
import org.example.api.repositories.OrderRepository;
import org.example.api.repositories.ProductRepository;
import org.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration // classe de config
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // instacia o user repository durante a execucao
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category categoryOne = new Category(null, "Electronics");
        Category categoryTwo = new Category(null, "Books");
        Category categoryTree = new Category(null, "Computers");

        Products productsOne = new Products(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Products productsTwo = new Products(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Products productsTree = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Products productsFour = new Products(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Products productsFive = new Products(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User userOne = new User(null, "Maria", "maria@gmail.com", "988888888", "456787");
        User userTwo = new User(null, "Guilherme", "gui@gmail.com", "788888888", "145225");

        Order orderOne = new Order(null, Instant.parse("2019-06-20T19:53:08Z"), OrderStatus.PAID, userOne);
        Order orderTwo = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, userTwo);
        Order orderTree = new Order(null, Instant.parse("2019-07-30T10:42:10Z"), OrderStatus.WAITING_PAYMENT, userOne);

        userRepository.saveAll(Arrays.asList(userOne,userTwo)); // instanciado no banco
        orderRepository.saveAll(Arrays.asList(orderOne,orderTwo,orderTree));
        categoryRepository.saveAll(Arrays.asList(categoryOne,categoryTwo,categoryTree));
        productRepository.saveAll(Arrays.asList(productsOne, productsTwo, productsTree, productsFour, productsFive));
    }
}
