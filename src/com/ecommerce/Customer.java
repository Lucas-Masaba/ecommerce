package com.ecommerce;

import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private int customerID;
  private String name;
  private List<Product> shoppingCart;

  public Customer(int customerID, String name) {
    this.customerID = customerID;
    this.name = name;
    this.shoppingCart = new ArrayList<>();
  }

  public int getCustomerID() {
    return customerID;
  }

  public String getName() {
    return name;
  }

  public List<Product> getShoppingCart() {
    return shoppingCart;
  }

  public void addProductToCart(Product product) {
    shoppingCart.add(product);
  }

  public void removeProductFromCart(Product product) {
    shoppingCart.remove(product);
  }

  public double calculateTotalCost() {
    double total = 0;
    for (Product product : shoppingCart) {
      total += product.getPrice();
    }
    return total;
  }

  public Order placeOrder() {
    Order order = new Order(customerID, this, new ArrayList<>(shoppingCart), calculateTotalCost());
    shoppingCart.clear();
    return order;
  }
}
