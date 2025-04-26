/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BussinesLayer.UsuarioBO;
import JavaBean.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author DJE DAYIRO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {

    static final String PATH_FORM = "/View/Usuario/usuario-form.jsp";
    static final String PATH_RESULT = "/View/Usuario/usuario-result.jsp";
    static final String PATH_INDEX = "/View/Usuario/usuario-index.jsp";
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
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;

                case "showForm":
                    showForm(request, response);
                    break;
                case "buscarPorId":
                    buscarPorId(request, response);
                    break;

                case "guardar":
                    guardar(request, response);
                    break;
                case "delete":
                    eliminar(request, response);
                    break;

            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    private void index(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {

        String apeNom = request.getParameter("apellidosNombres");

        UsuarioBO alumnoBO = new UsuarioBO();
        ArrayList<Usuario> alumnos = alumnoBO.buscarPorAlumno(apeNom);
        request.setAttribute("alumnos", alumnos);

        getServletContext().getRequestDispatcher(PATH_INDEX)
                .forward(request, response);

    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_FORM);
        dispatcher.forward(request, response);
    }

    private void buscarPorId(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioBO alumnoBO = new UsuarioBO();
        Usuario alumno = alumnoBO.buscarPorId(id);

        if (alumno == null) {
            request.setAttribute("mensaje", "Alumno no encontrado");
            getServletContext().getRequestDispatcher(PATH_RESULT)
                    .forward(request, response);
        } else {
            request.setAttribute("alumno", alumno);
            getServletContext().getRequestDispatcher(PATH_FORM)
                    .forward(request, response);
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {

        Usuario usuario = new Usuario();

        usuario.setDni(request.getParameter("dni"));
        usuario.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        usuario.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        usuario.setNombres(request.getParameter("nombres"));

        try {
            usuario.setFechaNacimiento(LocalDate.parse(request.getParameter("fechaNacimiento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } catch (Exception e) {
            usuario.setFechaNacimiento(null);
        }

        Map<String, String> errores = usuario.getErrores();
        
        
        if (errores.isEmpty()) {
            try {
                usuario.setUsuarioId(Integer.parseInt(request.getParameter("id")));

            } catch (NumberFormatException e) {
                usuario.setUsuarioId(-1);
            }
            UsuarioBO alumnoBO = new UsuarioBO();
            alumnoBO.guardar(usuario);
        }else{
            request.setAttribute("alumno", usuario);
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher(PATH_FORM)
                    .forward(request, response);
        }

    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.eliminar(id);
        request.setAttribute("mensaje", "El registro fue eliminado");
            getServletContext().getRequestDispatcher(PATH_FORM)
                    .forward(request, response);
        
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
