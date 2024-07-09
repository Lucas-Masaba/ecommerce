package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

public class Order {
  private static int nextOrderID = 1;

  private int orderID;
  private int customerID;
  private Customer customer;
  private List<Product> products;
  private double orderTotal;

  public Order(int customerID, Customer customer, List<Product> products, double orderTotal) {
    this.orderID = nextOrderID++;
    this.customerID = customerID;
    this.customer = customer;
    this.products = products;
    this.orderTotal = orderTotal;
  }

  public int getOrderID() {
    return orderID;
  }

  public int getCustomerID() {
    return customerID;
  }

  public Customer getCustomer() {
    return customer;
  }

  public List<Product> getProducts() {
    return products;
  }

  public double getOrderTotal() {
    return orderTotal;
  }

  @Override
  public String toString() {
    // Using StringBuilder to construct the string representation of the order
    StringBuilder sb = new StringBuilder();
    sb.append("Order ID: ").append(orderID)
        .append("\nCustomer ID: ").append(customerID)
        .append("\nCustomer Name: ").append(customer.getName())
        .append("\nOrder Total: $").append(orderTotal)
        .append("\nProducts:\n");

    for (Product product : products) {
      sb.append(product).append("\n");
    }

    return sb.toString();
  }
}
