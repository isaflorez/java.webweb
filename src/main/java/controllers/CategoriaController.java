package controllers;

import clases.Categoria;
import daos.CategoriaDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoriaController extends HttpServlet {

    private final CategoriaDAO cdao = new CategoriaDAO();
    private final String viewSearch = "/views/categorias/search.jsp";
    private final String viewIndex = "/views/categorias/index.jsp";
    private final String viewCreate = "/views/categorias/create.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "search":
                search(request, response);
                break;
            case "index":
                index(request, response);
                break;
            case "store":
                store(request, response);
                break;
            case "create":
                create(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        int cod = Integer.parseInt(id);
        request.setAttribute("categoria", cdao.obtenerCategoriaPorId(cod));
        request.getRequestDispatcher(viewSearch).forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("categorias", cdao.obtenerCategorias());
        request.getRequestDispatcher(viewIndex).forward(request, response);
        
    }
     protected void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("nombre");
        System.out.println(nombre);
        Categoria cat = new Categoria (0, nombre);
        int respuesta = cdao.registrarCategoria(cat);
        System.out.println(respuesta);
        if(respuesta>0){
            
            
        }
        
    }
   
     protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(viewCreate).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

