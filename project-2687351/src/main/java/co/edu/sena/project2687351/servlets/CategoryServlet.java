package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Category;
import co.edu.sena.project2687351.model.repository.CategoryRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //paso 1 collect all form data
        String category_name=request.getParameter("category_name");

        //paso 2 fill it up in a category bean
        Category category=new Category();
        category.setCategory_name(category_name);

        //paso 3 call repository layer and save the category object to DB
        Repository<Category> repository=new CategoryRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(category);
        }/*try*/ catch (SQLException e){
            e.printStackTrace();
        }//catch

        //paso 4 prepare an information message for user about success of failure of the operation
        //String infomessage=null;
        if (rows==0){
            //infomessage="Ocurrio un error";
            System.out.println("Ocurrió un error!");
        }/*if*/else{
            //infomessage="Registra exitoso!";
            System.out.println("Registro Exitoso!");
        }//else

        //todo paso 5 write the message back to the page in client browser

    }//dopost
}
