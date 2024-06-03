package CEN4010.project.profile_management.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import CEN4010.project.profile_management.dao.ProfileDao;

public class ProfileDaoImpl implements ProfileDao {
    private final JdbcTemplate jdbcTemplate;
    
    public ProfileDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
