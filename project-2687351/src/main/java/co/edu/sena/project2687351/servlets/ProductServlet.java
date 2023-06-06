package co.edu.sena.project2687351.servlets;


import co.edu.sena.project2687351.model.bean.Product;
import co.edu.sena.project2687351.model.repository.ProductRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet("/Product")

public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //paso 1 collect all form data
        String product_name=request.getParameter("product_name");
        Double product_value=Double.valueOf(request.getParameter("product_value"));
        Integer category_id=Integer.valueOf(request.getParameter("category_id"));

        //paso 2 fill it up in a product bean
        Product product=new Product();
        product.setProduct_name(product_name);
        product.setProduct_value(product_value);
        product.setCategory(category_id);

        //paso 3 call repository layer and save the product object to DB
        Repository<Product> repository=new ProductRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(product);
        }/*try*/catch (SQLException e){
            e.printStackTrace();
        }//catch

        //paso 4 prepare an information message for user about success or failure of the operation
        //String infomessage=null;
        if(rows==0){
            //infomessage="Ocurrió un error!";
            System.out.println("Ocurrió un error!");
        }else{
            //infomessage="Registra exitoso!";
            System.out.println("Registro Exitoso!");
        }

        // todo paso 5 write the message back to the page in client browser

    }//dopost
}
