import java.util.ArrayList;

public interface IEtudiantService {
	
		ArrayList<Etudiant> GetEtudiantParUniversitye();

		ArrayList<Etudiant> GetEtudiatparLivreEmprunte();
	    public boolean inscription (IEtudiant etud);

}
