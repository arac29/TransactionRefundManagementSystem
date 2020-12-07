package TransactionRefundMS.main;
//import org.apache.log4j.Logger;
import io.javalin.Javalin;

public class ServerDriver {

	public static void main (String[]args) {
		
		
		Javalin app=Javalin.create().start(9094);
		
		app.get("index", ctx -> ctx.html("Welcome"));
	}
}
