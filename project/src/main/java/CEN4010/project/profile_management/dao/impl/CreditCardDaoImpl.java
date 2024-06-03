package CEN4010.project.profile_management.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import CEN4010.project.profile_management.dao.CreditCardDao;

public class CreditCardDaoImpl implements CreditCardDao{
    private final JdbcTemplate jdbcTemplate;
    
    public CreditCardDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
