
public interface IEtudiant {
	public int getMatricule();

	public void setMatricule(int matricule);

	public String getNom();

	public void setNom(String nom);

	public String getPrenom();

	public void setPrenom(String prenom);

	public String getEmail();

	public void setEmail(String email);

	public int getNbLivreMensuel_Autorise();

	public	void setNbLivreMensuel_Autorise(int nbLivreMensuel_Autorise);

	public int getNbLivreEmprunte();

	public void setNbLivreEmprunte(int nbLivreEmprunte);

	public int getId_universite();

	public void setId_universite(int id_universite);

	public String getPwd();

	public void setPwd(String pwd);

}
