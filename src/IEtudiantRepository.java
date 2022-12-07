
public interface IEtudiantRepository {
	public abstract void  add(Etudiant e);
	public abstract boolean Exists(int matricule);
	public  abstract boolean Exists(String email);
	boolean vérifier(int Matricule, String Email);
}
