/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface UtilisateurDAO {
    Utilisateur rechercheUtilisateur(String login, String password);
    Utilisateur rechercheUtilisateurParMotDePasse(String password);
    boolean rechercheUtilisateur(String login);
    void majEtatConnexion(Utilisateur u);
}
