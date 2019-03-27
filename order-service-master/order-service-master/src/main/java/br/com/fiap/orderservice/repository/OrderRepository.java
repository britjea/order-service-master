package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.model.Item;
import br.com.fiap.orderservice.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class OrderRepository {

    private static List<Order> orders = new ArrayList<>();

    private static Long id = 0L;

    public Order getById(Long id) {

        final Order savedOrder = orders.stream().filter(order -> order.getId() == id).findFirst().get();

        savedOrder.setTotalPrice(savedOrder.getItems()
                .stream()
                .map(Item::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP));

        return savedOrder;
    }

    public Order save(Order order) {
        this.id = this.id + 1;
        order.setId(this.id);
        order.setOrderDate(Calendar.getInstance().getTime());
        orders.add(order);

        return order;
    }

    public void delete(Order order) {

        orders.remove(order);
    }

    public void update(Long id, Order order) {

        Order savedOrder = getById(id);

        orders.remove(savedOrder);

        BeanUtils.copyProperties(order, savedOrder, "id");

        orders.add(savedOrder);
    }



}
