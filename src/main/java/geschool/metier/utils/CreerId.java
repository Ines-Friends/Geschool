/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

/**
 *
 * @author xavier_ng
 */
public final class CreerId {
    public static final String SESSION_ID = "SESS";
    
    public static String creerSessionId(int anneeDebut, int anneeFin) throws Exception{
        String sessionId = "";
        
        if(anneeDebut != 0 && anneeFin != 0){
            sessionId = "SESS"+anneeDebut+anneeFin+"";
        }else{
            throw new Exception("anneeDebut et anneeFin ont la valeur 0");
        }
        return sessionId;
    }
}
