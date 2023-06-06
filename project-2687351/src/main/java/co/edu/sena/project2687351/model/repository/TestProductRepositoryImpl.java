package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Product;

import java.sql.SQLException;

public class TestProductRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Product> repository=new ProductRepositoryImpl();
        System.out.println("==========saveObj Insert==========");//Insert
        Product productInsert=new Product();
        productInsert.setProduct_name("vivo y35");
        productInsert.setProduct_value("1.650.000");
        productInsert.setCategory(Integer.parseInt("1"));
        repository.saveObj(productInsert);
        System.out.println("==========ListAllObj==========");//Select
        repository.listAllObj().forEach(System.out::println);
        System.out.println();
        System.out.println("==========byIdObj==========");//No se
        System.out.println(repository.byIdObj(1));
        System.out.println();
        System.out.println("==========saveObj==========");//Update
        Product productUpdate = new Product();
        productUpdate.setProduct_id(2);
        productUpdate.setProduct_name("vivo y51");
        productUpdate.setProduct_value("850.000");
        productUpdate.setCategory(1);
        repository.saveObj(productInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();
        System.out.println("==========deleteObj==========");//Delete
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }//main
}//TestProductRepositoryImpl
