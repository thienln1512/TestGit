package com.example.libbook.controller.webStart;

import com.example.libbook.entity.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Test {
    JdbcTemplate jdbcTemplate;

    private static final RowMapper<Role> ROLE_ROW_MAPPER = (rs, rowNum) -> new Role(
            rs.getInt("RoleId"),
            rs.getString("RoleName")
    );

    public Test(JdbcTemplate jdbcTemplateParameter) {
        if (jdbcTemplateParameter == null) {
            throw new IllegalArgumentException("JdbcTemplate cannot be null.");
        }
        this.jdbcTemplate = jdbcTemplateParameter; // <<-- THIS IS THE CRUCIAL FIX
    }

    public List<Role> inra() {
        String selectSql = "SELECT * FROM [role]";
        return jdbcTemplate.query(selectSql, ROLE_ROW_MAPPER);
    }


    public static void main(String[] args) {
        // 1. Manually configure DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // --- !!! REPLACE WITH YOUR ACTUAL DATABASE DETAILS !!! ---
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Example for SQL Server
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=LibBook;encrypt=true;trustServerCertificate=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("1234");
        // --- END OF DATABASE DETAILS ---

        // 2. Manually create JdbcTemplate
        JdbcTemplate localJdbcTemplate = new JdbcTemplate(dataSource);

        // 3. Create an instance of Test, passing the initialized JdbcTemplate
        Test myTestInstance = new Test(localJdbcTemplate);

        // 4. Now call inra()
        System.out.println("Fetching roles...");
        List<Role> roles = myTestInstance.inra();

        if (roles.isEmpty()) {
            System.out.println("No roles found.");
        } else {
            System.out.println("Found roles:");
            for (Role role : roles) {
                System.out.println(" - ID: " + role.getRoleId() + ", Name: " + role.getRoleName());
            }
        }
    }

}