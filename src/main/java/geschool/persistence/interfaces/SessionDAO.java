/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Session;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface SessionDAO {
    void creerSession(Session s);
    void modifSession(Session s);
    Session chercherSession(String idSession);
    
}
