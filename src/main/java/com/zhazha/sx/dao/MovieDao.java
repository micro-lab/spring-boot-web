package com.zhazha.sx.dao;

import com.zhazha.sx.bean.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movies> getMovies(){
        String sql = "SELECT id,name,PerformerId,MainPerformerName,hasMosaic,releaseTime,torrent FROM movie";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<Movies>(Movies.class));

    }

    /**
             return (List<TestBean>) jdbcTemplate.query(sql, new RowMapper<TestBean>(){
                 @Override
                 public TestBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                     TestBean stu = new TestBean();
                     stu.setId(rs.getInt("ID"));
                     stu.setName(rs.getString("NAME"));
                     return stu;
                 }

             }
             );
     */

}
