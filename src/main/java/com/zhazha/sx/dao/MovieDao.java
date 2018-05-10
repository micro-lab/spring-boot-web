package com.zhazha.sx.dao;

import com.zhazha.sx.bean.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> getMovies() {
        return getMovies(1,20);
    }

    public List<Movie> getMovies(int pageNum, int rowNum) {
        String sql = "SELECT id,name,PerformerId,MainPerformerName,hasMosaic,releaseTime,torrent FROM movie limit ?,?";
        return jdbcTemplate.query(sql, new Object[]{pageNum,rowNum}, new BeanPropertyRowMapper<Movie>(Movie.class));

    }

    public List<Movie> selectMovies(int pageNum, int rowNum) {
        String sql = "SELECT id,name,PerformerId,MainPerformerName,hasMosaic,releaseTime,torrent FROM movie limit ?,?";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<Movie>(Movie.class));

    }



    /**
     return (List<TestBean>) jdbcTemplate.query(sql, new RowMapper<TestBean>(){
    @Override public TestBean mapRow(ResultSet rs,int pageNum,int rowNum) throws SQLException {
    TestBean stu = new TestBean();
    stu.setId(rs.getInt("ID"));
    stu.setName(rs.getString("NAME"));
    return stu;
    }

    }
     );
     */

}
