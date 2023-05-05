package ra.academy.controller;

import ra.academy.model.Customer;
import ra.academy.service.CustomerServiceIMPL;
import ra.academy.service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "show":
                    showListCustomer(request, response);
                    break;
                case "detail":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Customer customer = customerService.findById(id);
                    request.setAttribute("customer", customer);
                    try {
                        request.getRequestDispatcher("views/detail.jsp").forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "ADD":
                    try {
                        request.getRequestDispatcher("views/createStudent.jsp").forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    customerService.deleteById(idDelete);
                    showListCustomer(request, response);
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Customer customer2 = customerService.findById(idEdit);
                    request.setAttribute("customerEdit", customer2);
                    try {
                        request.getRequestDispatcher("views/edit.jsp").forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                    showListCustomer(request, response);
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "CREATE":
                    int id = customerService.findAll().get(customerService.findAll().size() - 1).getId() + 1;
                    String name = req.getParameter("name");
                    String email = req.getParameter("email");
                    String address = req.getParameter("address");
                    Customer customer = new Customer(id, name, email, address);
                    customerService.save(customer);
                     showListCustomer(req, resp);
                    break;
                case "update":
                    int idUp = Integer.parseInt(req.getParameter("id"));
                    String nameUp = req.getParameter("name");
                    String emailUp = req.getParameter("email");
                    String addressUp = req.getParameter("address");
                    Customer customer1 = new Customer(idUp, nameUp, emailUp, addressUp);
                    customerService.save(customer1);
                    showListCustomer(req, resp);
                    break;
            }
        }

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        System.out.println(customerList);
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        try {
            // gui lai file jsp
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}