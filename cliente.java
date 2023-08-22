/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Cliente;
import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author katay
 */
@WebServlet(name = "cliente", urlPatterns = {"/cliente"})
public class cliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nombre del cliente: " + request.getParameter("nombre") + "</h1>");
            out.println("<h2>apellido:" + request.getParameter("apellido") + "</h2>");
            out.println("<h3>Correo: " + request.getParameter("correo") + "</h1>");
            out.println("<h4>Telefono:" + request.getParameter("telefono") + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ClienteDAO clienteDAO;
    @Override
     public void init() throws ServletException {
        super.init();
        clienteDAO = new ClienteDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
         String Correo = request.getParameter("correo");
        String Telefono = request.getParameter("telefono");
        
        
        request.setAttribute("nombre", Nombre);
        request.setAttribute("apellido", apellido);
        request.setAttribute("correo", Correo);
        request.setAttribute("telefono", Telefono);
        
      //Crear el objeto Cliente con los datos recibidos
        /*Cliente cliente = new Cliente();
        cliente.setNombre(Nombre);
        cliente.setApellido(Apellido);
        cliente.setCorreo(Correo);
        cliente.setTelefono(Telefono);
        */
        
         // Invocar el método create() en el DAO para guardar el cliente en la base de datos
        /*
         clienteDAO2.create(cliente);

        // Realizar cambios adicionales en el cliente, por ejemplo, cambiar el nombre y actualizarlo
        cliente.setNombre("Nuevo Nombre");
        clienteDAO2.edit(cliente);

        // Eliminar el cliente
        clienteDAO2.destroy(cliente.getID_cliente());
         */
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
