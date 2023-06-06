package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.bean.Category;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Category> {
    private String Sql=null;

    @Override
    public List<Category> listAllObj() throws SQLException {
        Sql="select c.category_id, c.category_name"+
        "from categories c";
        List<Category> category = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(Sql)){
            while (rs.next()){
                Category c = createObj(rs);
                category.add(c);
            }//while
        }//try
        return category;
    }//listAllObj

    @Override
    public Category byIdObj(Integer id) throws SQLException {
        Sql="select c.category_id, c.category_name"+
        "from categories c where c.category_name=?";
        Category category = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category = createObj(rs);
                }//if
            }//try 2
        }//try
        return category;
    }//byIdObj

    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected = 0;
        if (category.getCategory_id() !=null && category.getCategory_id()>0) {
            Sql = "update categories set category_name=?"+
            "where category_id=?";
        }/*if*/else{
            Sql = "insert into categories (category_name)"+
            "values(upper(?))";
        }//else
        try (Connection conn = ConnectionPool.getConnection();
        PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setString(1, category.getCategory_name());
            if (category.getCategory_id() !=null && category.getCategory_id() > 0) {
                ps.setInt(2, category.getCategory_id());
            }//if
            rowsAffected = ps.executeUpdate();
        }//try
        return rowsAffected;
    }//saveObj

    @Override
    public void deleteObj(Integer id) throws SQLException {
        Sql = "delete from category where category_id=?";
        try (Connection conn = ConnectionPool.getConnection();
        PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }//try
    }//deleteObj

    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name(rs.getString("category_name"));
        return category;
    }//createObj

}//Repository
