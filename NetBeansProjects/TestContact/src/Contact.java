/*================================================
				Classe : Contact
================================================*/

public class Contact implements Comparable<Contact>
{
	private Integer numero;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
	private Integer codeSecteur;

	/*--------------------------------------
				Constructeur
	--------------------------------------*/

	public Contact(Integer numero, String nom, String adresse, String codePostal, String ville, Integer codeSecteur)
	{
            this.numero = numero;
            this.nom = nom;
            this.adresse = adresse;
            this.codePostal = codePostal;
            this.ville = ville;
            this.codeSecteur = codeSecteur;		
	}

	public Integer getNumero()
	{
		return numero;
	}

	public String getNom()
	{
		return nom;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public String getCodePostal()
	{
		return codePostal;
	}

	public String ville()
	{
		return ville;
	}

	public Integer getCodeSecteur()
	{
		return codeSecteur;
	}

	/*-----------------------------------
		Affichage du contact
	-----------------------------------*/

        @Override
	public String toString()
	{
		return numero + ";" + nom + ";"
			+ adresse + ";" + codePostal + ";"
			+ ville + ";" + codeSecteur;
	}

	/*-----------------------------------
		Comparaison de 2 objets contact
	-----------------------------------*/

	@Override
	public int compareTo(Contact c)
	{
		return getNumero().compareTo(c.getNumero());
	}  
}