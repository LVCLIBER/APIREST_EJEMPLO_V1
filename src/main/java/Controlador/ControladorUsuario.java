/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Daousuario;
import Modelo.Musuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PROGRAM_MICHAEL
 */
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

    private Daousuario dao = new Daousuario();
    private RequestDispatcher dispacher = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String index = "index.jsp";
        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            request.setAttribute("listauser", dao.getlistausuario());
            dispacher = request.getRequestDispatcher(index);
        } else if (accion.equals("registrar")) {
            int dni = Integer.parseInt(request.getParameter("ttdni"));
            String nombre = request.getParameter("ttnombre");
            int edad = Integer.parseInt(request.getParameter("ttedad"));
            Musuario m = new Musuario(dni, edad, nombre);
            dao.RegistrarUsuario(m);
            request.setAttribute("listauser", dao.getlistausuario());
            dispacher = request.getRequestDispatcher(index);
        } else if (accion.equals("eliminar")) {
            int dni = Integer.parseInt(request.getParameter("dni"));
            dao.Eliminar(dni);
            request.setAttribute("listauser", dao.getlistausuario());
            dispacher = request.getRequestDispatcher(index);
        } else if (accion.equals("guardar")) {
            int dni = Integer.parseInt(request.getParameter("ttdniE"));
            String nombre = request.getParameter("ttnombreE");
            int edad = Integer.parseInt(request.getParameter("ttedadE"));
            Musuario m = new Musuario(dni, edad, nombre);
            dao.Editarusuario(m);
            request.setAttribute("listauser", dao.getlistausuario());
            dispacher = request.getRequestDispatcher(index);
        }
        dispacher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
