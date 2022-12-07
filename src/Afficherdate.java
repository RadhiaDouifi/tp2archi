
import java.text.SimpleDateFormat;
import java.util.Date;
public class Afficherdate implements IJournal{
	public Afficherdate() {
	}
	
	@Override
	public void outPut_Msg(String message) {
		 SimpleDateFormat s = new SimpleDateFormat("JJ/MM/AAAA HH:mm:ss");
		    Date date = new Date();
		    System.out.println(message);
		    System.out.println(s.format(date));

	}

}