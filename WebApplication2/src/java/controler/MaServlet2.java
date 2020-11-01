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

@WebServlet(name = "MaServlet2", urlPatterns = {"/MaServlet2"})
public class MaServlet2 extends HttpServlet {

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
        
        String NAME1 = request.getParameter("name1");
        String SURNAME1 = request.getParameter("surname1");
        String LOGIN1 = request.getParameter("login1");
        
        String NAME2 = request.getParameter("name2");
        String SURNAME2 = request.getParameter("surname2");
        String LOGIN2 = request.getParameter("login2");
        
        String NAME3 = request.getParameter("name3");
        String SURNAME3 = request.getParameter("surname3");
        String LOGIN3 = request.getParameter("login3");
        
        String NAME4 = request.getParameter("name4");
        String SURNAME4 = request.getParameter("surname4");
        String LOGIN4 = request.getParameter("login4");
    
        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

        statement = connexion.createStatement();

        String req = "INSERT INTO UTILISATEUR (NAME ,SURNAME, LOGIN) VALUES ('"+NAME1+"','"+SURNAME1+"','"+LOGIN1+"')";
        statement.executeUpdate(req );
        
        if(NAME2 != null && !NAME2.isEmpty()){
            String req2 = "INSERT INTO UTILISATEUR (NAME ,SURNAME, LOGIN) VALUES ('"+NAME2+"','"+SURNAME2+"','"+LOGIN2+"')";
            statement.executeUpdate(req2 );
        }
        
        if(NAME3 != null && !NAME3.isEmpty()){
            String req3 = "INSERT INTO UTILISATEUR (NAME ,SURNAME, LOGIN) VALUES ('"+NAME3+"','"+SURNAME3+"','"+LOGIN3+"')";
            statement.executeUpdate(req3 );
        }
        
        if(NAME4 != null && !NAME4.isEmpty()){
            String req4 = "INSERT INTO UTILISATEUR (NAME ,SURNAME, LOGIN) VALUES ('"+NAME4+"','"+SURNAME4+"','"+LOGIN4+"')";
            statement.executeUpdate(req4 );
        }
 
        resultat = statement.executeQuery( "SELECT id, name, surname, login FROM Utilisateur" );
       
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
       request.getRequestDispatcher("/bonus.jsp").forward(request, response);
        
        
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
