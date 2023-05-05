package ra.academy.service;

import ra.academy.model.Customer;
import ra.academy.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService {
    List<Customer> customerList = new ArrayList<>();

    @Override
    public List<Customer> findAll() {
        customerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("select * from customer");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    // them
    @Override
    public void save(Customer customer) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement pr=connection.prepareStatement("insert into customer(`name`,email,address) values (?,?,?)");
            pr.setString(1, customer.getName());
            pr.setString(2, customer.getEmail());
            pr.setString(3, customer.getAddress());
            pr.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                customerList.remove(customer);
                return;
            }
        }
    }
}
