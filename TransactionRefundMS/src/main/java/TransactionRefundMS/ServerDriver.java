package TransactionRefundMS;
import TransactionRefundMS.controller.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ServerDriver {

	private static AuthController authController= new AuthController();
	private static ReimbursementController reimController=new ReimbursementController();
	private static EmployeeController employeeController = new EmployeeController();
	
	public static void main (String[]args) {
		
		
		Javalin app=Javalin.create( 
				config -> {config.addStaticFiles("/public"); }).start(9094);
		
		app.get("/", ctx -> ctx.redirect("index.html"));
		
		/**  AUTHORIZATION, AUTHENTICATION **/
		app.post("/signIn",  ctx -> authController.signIn(ctx));
		app.get("/auth", ctx -> authController.checkUser(ctx));
		app.post("/forward", ctx -> authController.validate(ctx));
		app.get("/logout" , ctx -> authController.logout(ctx));
		
		/*  --------------- Form ------------------ */
		app.post("/submitForm", ctx -> reimController.submitReimbursementForm(ctx));
		app.get("/newRequest", ctx -> ctx.redirect("form.html"));
		
		/*  --------------- Reimbursement ------------------ */
		
					/* ...........employee?...........*/
		//app.get("/readReimbursementStatus", ctx -> reimController.checkStatus(ctx));
		app.get("/readReimbursements", ctx -> reimController.getReimbursements(ctx));
		app.get("/readAllReimbursements", ctx -> reimController.getAllReimbursements(ctx));
		app.get("/reimbursementsReportsTo", ctx -> reimController.readAllReimbsByReportTo(ctx));
		app.get("/readReimbursementById/:reimbursementId", ctx -> reimController.getReimbursementById(ctx));
		//app.post("/readReimbursementById/:reimbursementId", ctx -> reimController.getReimbursementById(ctx));
		app.post("/updateCost/:reimbursementId", ctx -> reimController.updateCost(ctx)); 
		app.delete("/cancelReimbursement/:reimbursementId",  ctx -> reimController.cancelReimbursement(ctx)); 
					/* ...........dir sup?...........*/
		app.post("/updateNote/:reimbursementId", ctx -> reimController.updateNote(ctx)); 
		app.post("/updateStatus/:reimbursementId", ctx -> reimController.updateStatus(ctx)); 
		
		
		/*  --------------- EVENTS ------------------ */
		app.get("/readEvents", ctx -> reimController.getEvents(ctx));
		app.get("/readAllEvents", ctx -> reimController.getAllEvents(ctx));
		app.get("/eventsReportsTo", ctx -> reimController.eventsReportTo(ctx));
		app.get("/readEventById/:eventId", ctx -> reimController.getEventById(ctx));
		//apt.get("/updateEvent/:eventId", ctx -> reimController.updateEvent(ctx));
		app.post("employeeGrade/:eventId",ctx -> reimController.employeeGrade(ctx));
		app.post("superGrade/:eventId",ctx -> reimController.superGrade(ctx));
		
	}

}
