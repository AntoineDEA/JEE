/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MaServlet3", urlPatterns = {"/MaServlet3"})
public class MaServlet3 extends HttpServlet {

    private List<String> messages = new ArrayList<String>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       ArrayList<model.User> Users = new ArrayList<model.User>();
       
       
       try {
        Class.forName( "org.apache.derby.jdbc.ClientDriver" );  //« "org.apache.derby.jdbc.ClientDriver«  for derby
    } catch ( ClassNotFoundException e ) {
        messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                + e.getMessage() );
    }
    /* Connexion à la base de données */
    String url = "jdbc:derby://localhost:1527/Task4";
    String utilisateur = "root";
    String motDePasse = "root";
    Connection connexion = null;
    Statement statement = null;
    ResultSet resultat2 = null;
    ResultSet resultat = null;
    int count = 0;
    
    try {
        
        String NAME = request.getParameter("value");
    
        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

        statement = connexion.createStatement();
 
        resultat = statement.executeQuery( "SELECT id, name, surname, login FROM Utilisateur WHERE name = '"+NAME+"'");
       
        while ( resultat.next() ) {
            model.User temp = new model.User();
            temp.id = resultat.getInt( "id" );
            temp.name = resultat.getString( "name" );
            temp.surname = resultat.getString( "surname" );
            temp.login = resultat.getString( "login" );
            Users.add(temp);
            count = count + 1;
        }
 
        
    } 
    
    catch ( SQLException e ) {
        messages.add( "Erreur lors de la connexion : <br/>"
                + e.getMessage() );
    } finally {
        messages.add( "Fermeture de l'objet ResultSet." );
        if ( resultat != null ) {
            try {
                resultat.close();
            } catch ( SQLException ignore ) {
            }        }
        messages.add( "Fermeture de l'objet Statement." );
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            }
        }
        messages.add( "Fermeture de l'objet Connection." );
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {
            }
        }
       request.setAttribute("Users", Users);
       request.setAttribute("count", count);
       request.getRequestDispatcher("/end.jsp").forward(request, response);
        
        
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
