package mainPackage;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;


public class UpdateDB {
	
	public UpdateDB() {}
	
	String uri = "mongodb+srv://Alex:3415FD@cluster0.fomem.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
	MongoClient client = MongoClients.create(uri);
	MongoDatabase db = client.getDatabase("AutomationDB");
	MongoCollection<?> col_FacebookRegistration = db.getCollection("FacebookRegistration");
	MongoCollection<?> col_SendEmails = db.getCollection("SendEmails");
	public void setError(String error, int index) {
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("error", error));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", index);
		col_FacebookRegistration.updateOne(searchQuery, newDocument);
	}
	public void setEmail(String email, int index){
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("email", email));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", index);
		col_FacebookRegistration.updateOne(searchQuery, newDocument);
	}
	public void setStatus(String status, int index) {
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("status", status));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", index);
		col_SendEmails.updateOne(searchQuery, newDocument);
	}
	public void setPassword(String password, int index){
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("password", password));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", index);
		col_FacebookRegistration.updateOne(searchQuery, newDocument);
	}
	public void setMessage(String message, int index) {
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("message", message));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", index);
		col_SendEmails.updateOne(searchQuery, newDocument);
	}
}
