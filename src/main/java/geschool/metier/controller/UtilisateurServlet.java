/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.metier.utils.ConnexionValidationForm;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xavier_ng
 */
public class UtilisateurServlet extends HttpServlet {
    @EJB
    private UtilisateurDAO uDAO;
    public static final String ATT_USER = "utilisateur";
    public static final String MESSAGE = "message";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("login")){
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_LOGIN ).forward( request, response );
        }else if(action.equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect( AllUrl.URL_PAGE_LOGIN );
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            ConnexionValidationForm form = new ConnexionValidationForm(uDAO);
            /* Traitement de la requête et récupération du bean en résultant */
            Utilisateur utilisateur = form.connecterUtilisateur(request);
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, utilisateur );
            /**
             * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
             * Utilisateur à la session, sinon suppression du bean de la
             * session.
             */
            if ( form.getErreurs().isEmpty() ) {
                /* Récupération de la session depuis la requête */
                HttpSession session = request.getSession();
                session.setAttribute( ATT_SESSION_USER, utilisateur );
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_ACCUEIL ).forward( request, response );
            } else {
                request.setAttribute(MESSAGE, "error");
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_LOGIN ).forward( request, response );
            }
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
