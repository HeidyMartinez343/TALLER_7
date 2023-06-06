package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.User;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.RepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // paso 1 collect all form data
        String firstname=request.getParameter("firstname");
        String password=request.getParameter("password");

        // paso 2 fill it up in a user bean
        User user=new User();
        user.setUser_firstname(firstname);
        user.setUser_password(password);

        // paso 3 call repository layer and save the user object to DB
        Repository<User> repository=new RepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    }
}
