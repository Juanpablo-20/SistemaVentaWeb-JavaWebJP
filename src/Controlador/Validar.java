
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {

    EmpleadoDAO eDao = new EmpleadoDAO();

    Empleado em = new Empleado();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Justo en el DoPost");
        
//        response.sendRedirect("Principal.jsp");
        
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("Ingresar")) {
            System.out.println("en el doPost");
            
            String user = request.getParameter("txtUser");

            String password = request.getParameter("txtPassword");

            em = eDao.Validar(user, password);

            if (em.getUser() !=null) {
                
                request.setAttribute("usuario", em);
                
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        processRequest(request, response);
//
//
//        String user = request.getParameter("txtUser");
//        
//        String password = request.getParameter("txtPassword");
//        
//        //boolean validacion = false;
//        
//        em = eDao.validar(user, password);
//        
//        //validacion = em.equals(validacion);
//        
//        if(em.equals(true)){
//            
//            HttpSession miSession = request.getSession(true);
//            
//            miSession.setAttribute("txtUser", user);
//            
//            response.sendRedirect("Principal.jsp");
//        }
//        else{
//            
//            response.sendRedirect("index.jsp");
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
