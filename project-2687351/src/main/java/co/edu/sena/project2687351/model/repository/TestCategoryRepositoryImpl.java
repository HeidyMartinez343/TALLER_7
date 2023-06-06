package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Category;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Category> repository=new CategoryRepositoryImpl();
        System.out.println("==========saveObj Insert==========");//Insert
        Category categoryInsert=new Category();
        categoryInsert.setCategory_name("Articulos del Hogar");
        repository.saveObj(categoryInsert);
        System.out.println("==========ListAllObj==========");//Select
        repository.listAllObj().forEach(System.out::println);
        System.out.println();
        System.out.println("==========byIdObj==========");//No se
        System.out.println(repository.byIdObj(1));
        System.out.println();
        System.out.println("==========saveObj==========");//Update
        Category categoryUpdate = new Category();
        categoryUpdate.setCategory_id(2);
        categoryUpdate.setCategory_name("muebles");
        repository.saveObj(categoryInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();
        System.out.println("==========deleteObj==========");//Delete
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }//metodo main
}//TestCategoryRepositoryImpl
