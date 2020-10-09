package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Simluando los valores correctos
        String usuarioOk = "Jose";
        String passwordOk = "123";
            
        //Los valores que obtenemos del HTML que puse el usuario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password"); 
            
        PrintWriter salida = response.getWriter();
        
        
        //Se maneja un codigo de estado, en caso de no ser las credenciales correctas
        //Esto se puede usar en Bases de Datos por Ejemplo
        if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
            salida.print("<h1>Datos Correctos");
            salida.print("<br>Usuario: " +usuario);
            salida.print("<br>Password: " +password);
            salida.print("</h1>");
        }
        //Si las credenciales no son las correctas, osea las que estan ahi arriba
        //Se manda este codigo de estado en este caso inautorizado
        else{
            response.sendError(response.SC_UNAUTHORIZED,"Credenciales Incorrectas...");
        }
        salida.close();
    }
}