package com.sales.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

import com.sales.model.*;
import com.sales.service.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("mysql");

        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        int choice = 0;

        while (choice != 10) {

            System.out.println("\nselect any option below");
            System.out.println("1 Register Customer");
            System.out.println("2 Add Address to Customer");
            System.out.println("3 Create Lead");
            System.out.println("4 Assign Lead to Employee");
            System.out.println("5 Convert Lead to Customer");
            System.out.println("6 Add Product");
            System.out.println("7 Place Order");
            System.out.println("8 Raise Ticket");
            System.out.println("9 Employee Performance Report");
            System.out.println("10 Exit");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    Customer c = new Customer();
                    System.out.print("Name: ");
                    c.setName(sc.next());
                    System.out.print("Email: ");
                    c.setEmail(sc.next());
                    System.out.print("Phone: ");
                    c.setPhone(sc.next());

                    customerService.register(c);
                    break;


                case 2:
                    System.out.print("Customer ID: ");
                    long cid = sc.nextLong();

                    Address a = new Address();
                    System.out.print("Street: ");
                    a.setStreet(sc.next());
                    System.out.print("City: ");
                    a.setCity(sc.next());
                    System.out.print("State: ");
                    a.setState(sc.next());
                    System.out.print("Zip: ");
                    a.setZipCode(sc.next());

                    customerService.addAddress(cid, a);
                    break;


                case 3:
                    Lead l = new Lead();
                    System.out.print("Lead Name: ");
                    l.setName(sc.next());
                    System.out.print("Source: ");
                    l.setSource(sc.next());
                    System.out.print("Contact: ");
                    l.setContactInfo(sc.next());

                    leadService.createLead(l);
                    break;


                case 4:
                    System.out.print("Lead ID: ");
                    int lid = sc.nextInt();
                    System.out.print("Employee ID: ");
                    int eid = sc.nextInt();

                    leadService.assignLead(lid, eid);
                    break;


                case 5:
                    System.out.print("Lead ID to convert: ");
                    int convertId = sc.nextInt();

                    leadService.convertLead(convertId);
                    break;


                case 6:
                    Product p = new Product();
                    System.out.print("Product Name: ");
                    p.setName(sc.next());
                    System.out.print("Price: ");
                    p.setPrice(sc.nextDouble());

                    productService.createProduct(p);
                    break;


                case 7:
                    Order o = new Order();

                    System.out.print("Customer ID: ");
                    Customer oc = em.find(Customer.class, sc.nextLong());
                    o.setCustomers(oc);

                    System.out.print("Product ID: ");
                    Product op = em.find(Product.class, sc.nextInt());
                    o.setProducts(List.of(op));

                    orderService.placeOrder(o);
                    break;


                case 8:
                    SupportTicket t = new SupportTicket();
                    System.out.print("Issue: ");
                    t.setIssueDescription(sc.next());

                    System.out.print("Order ID: ");
                    Order ord = em.find(Order.class, sc.nextInt());
                    t.setOrder(ord);

                    ticketService.createTicket(t);
                    break;


                case 9:
                    System.out.println(reportService.getOrdersAbove(1000));
                    break;


                case 10:
                    System.out.println("Exiting...");
                    break;
            }
        }

 
    }
}