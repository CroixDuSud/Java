package objetDistant;

import javax.ejb.Remote;
import metierMapping.Contact;


@Remote
public interface ContactDistantRemote
{
    public Contact lireContact(Integer numero);
}
