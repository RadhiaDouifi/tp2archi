public class MainApp {

	public static void main(String[] args)  {	
		
		IDBConnection conn = DBConnection.getinstance();
		Affichercomposit CompositeJ = new Affichercomposit();
		
		Etudiant etudiant1 =new Etudiant(1, "Guendouziiiii", "wassila", "guennf@gmail.com","xxxx",1);
		Etudiant etudiant2 =new Etudiant(2, "Douifi", "Radhia", "douifirad@gmail.com","xxxx",2);
		//ViewInscription v = new ViewInscription();
		IJournal journal1 = new Afficherecran();
		IJournal journal2 = new Afficherdate();

		CompositeJ.add(journal1);
		CompositeJ.add(journal2);

		IEtudiantRepository etudRep = new EtudiantRepository(conn,CompositeJ);
		
		IUniversiteRepository univRep = new UniversiteRepository(conn,CompositeJ);
		
		EtudiantService serv = new EtudiantService(etudRep ,univRep,CompositeJ);

		try {
			serv.inscription(etudiant1, 1);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}