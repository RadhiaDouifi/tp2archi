
public interface IUniversiteRepository {
	public abstract  Universite GetById(int id);
	public abstract int NbrLivreAutorise(int id_univ);

}
