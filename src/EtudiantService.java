import java.util.ArrayList;
public class EtudiantService implements IEtudiantService {

	private IEtudiantRepository StudRep;
	private IUniversiteRepository UnivRep;
	private IJournal journal;
	
	
	public EtudiantService(IEtudiantRepository EtudRep ,IUniversiteRepository UnivRep,IJournal journal) {
		super();
		this.StudRep = EtudRep;
		this.UnivRep = UnivRep;
		this.journal=journal;
  }
	
	boolean inscription (Etudiant stud,int id_universite)
	{
		IUniversite univ=UnivRep.GetById(id_universite);

		journal.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec le matricule "+stud.getMatricule());
	    
		if(StudRep.vérifier(stud.getMatricule(), stud.getEmail())){
  			return false;
  		}
		
		
		 int nbrlivreAutorisé = UnivRep.NbrLivreAutorise(id_universite);
		 stud.setNbLivreMensuel_Autorise(nbrlivreAutorisé);
		 
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+stud.getMatricule());
		 return true;
	}

	
	public  void ajouterbonus(Etudiant E) {
		IUniversite univ=UnivRep.GetById(E.getId_universite());
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
			 Package pack = new Standard(null);
			 E.bonus(pack.getNbrLivreBonus());
		        }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 Package pack = new Premium(null);
	    	  E.bonus(pack.getNbrLivreBonus())	 ;   
	    	 }                           
	 }
@Override
public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

@Override
public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);

}

@Override
public boolean inscription(InterfaceEtudiant etud) {
	// TODO Auto-generated method stub
	return false;
}





}