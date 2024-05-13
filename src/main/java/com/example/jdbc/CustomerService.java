package com.example.jdbc;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerService {
    private  final JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // operations

    public  void AddCustomer(Customer customer) {
        String sql = "INSERT INTO customer values (?,?)";
        jdbcTemplate.update(sql, customer.getId(), customer.getName());
    }

    // GET ALL CUSTOMERS

    public List<Customer> getAllCustomer() {
        String sql = "SELECT * FROM customer";
        return  jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Customer.class));
    }
    // get customer by id

    public Customer getCustomerId(int id) {
        String sql = "SELECT * FROM customer where id = ?";
         return jdbcTemplate.queryForObject(sql,
                 new Object[]{id},
                 new BeanPropertyRowMapper<>(Customer.class)
                 );
    }

    // delete customer by id
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        jdbcTemplate.update(sql, parameters);
    }


    // update cutomer
    public void updateCustome(Customer customer){
        String sql = "UPDATE customer SET name = ? where id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getId());
    }
}
