
import java.util.ArrayList;

public class Affichercomposit implements IJournal{

private ArrayList<IJournal> journal = new ArrayList<IJournal>();
	

	@Override
  public void outPut_Msg(String message) {
		for(IJournal j : journal){
			j.outPut_Msg(message);
		}
	}

  public void add(IJournal journals){
	  journal.add(journals);
	}
  
  public void remove(IJournal journals){
	  journal.remove(journals);
	}

}