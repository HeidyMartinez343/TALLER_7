package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.bean.Product;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product> {
    private  String Sql=null;

    @Override//todo hacer la lista
    public List<Product> listAllObj() throws SQLException {
        Sql="select p.product_id, p.product_name, p.product_value, c.category_id"+
        "from produts p"+
        "INNER JOIN categories c ON p.category_id = c.category_id";
        List<Product> product = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(Sql)){
            while (rs.next()){
                Product p = createObj(rs);
                product.add(p);
            }//while
        }//try
        return product;
    }//listAllobj

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        Sql="select p.product_id, p.product_name, p.product_value, c.category_id"+
        "from products p where p.product_name=?";
        Product product = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    product = createObj(rs);
                }//if
            }//try 2
        }//try
        return product;
    }//byIdObj

    @Override
    public Integer saveObj(Product product) throws SQLException {
        int rowsAffected = 0;
        if (product.getProduct_id() !=null && product.getProduct_id()>0){
            Sql = "update products set product_name=?"+
            "where product_id=?";
        }/*if*/else{
            Sql = "insert into products (product_name)"+
            "values(upper(?))";
        }//else
        try (Connection conn = ConnectionPool.getConnection();
        PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setString(1, product.getProduct_name());
            ps.setDouble(2, product.getProduct_value());
            ps.setInt(3, product.getCategory().getCategory_id());
            if (product.getProduct_id() !=null && product.getProduct_id() > 0) {
                ps.setInt(4, product.getProduct_id());
            }//if
            rowsAffected = ps.executeUpdate();
        }//try
        return rowsAffected;
    }//saveObj

    @Override
    public void deleteObj(Integer id) throws SQLException {
        Sql = "delte from product where category_id=?";
        try (Connection conn = ConnectionPool.getConnection();
        PreparedStatement ps = conn.prepareStatement(Sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }//try
    }//deleteObj

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setProduct_value(rs.getDouble("product_value"));
        product.setCategory(rs.getInt("category_id"));
        return product;
    }//createObj

}//Repository