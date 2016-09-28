/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetDistant;

import java.sql.SQLException;
import java.util.Vector;
import javax.ejb.Remote;
import metierMapping.Contact;

/**
 *
 * @author afpa1800
 */
@Remote
public interface MappingRemote
{
    
    // Chercher un contact (lire)
    public Contact lireContact(Integer numero) throws SQLException;
    // Liste de tous les contacts
    public Vector<Vector> lireListeContacts() throws SQLException;
    // Modification d'un contact
    public int modifierContact(Contact contact) throws SQLException;
    // Liste de tous les secteurs
    public Vector<Vector> lireListeSecteurs() throws SQLException;
}
