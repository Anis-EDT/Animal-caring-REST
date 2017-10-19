package resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/file")
public class UploadResource {

	private final String UPLOADED_FILE_PATH = "C:\\Users\\Omar\\Desktop\\vets\\";

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {

	   
		String fileName = "";

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		//System.out.println("les input parts "+input.getParts());
		//System.out.println("the upload form"+uploadForm);
		List<InputPart> inputParts = uploadForm.get("uploadedFile");
		//List<InputPart> mailto = uploadForm.get("mailTo");
		//String mt1=mailto.get(0).getBodyAsString();
		//for (InputPart m : mailto) {
		//MultivaluedMap<String, String> mailheader = m.getHeaders();
		//System.out.println("le mail"+mailheader);
		//}
		

		for (InputPart inputPart : inputParts) {

		 try {

			MultivaluedMap<String, String> header = inputPart.getHeaders();
			System.out.println(header);
			fileName = getFileName(header);
			System.out.println(fileName);

			//convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);

			//constructs upload file path
			
			String filepath = UPLOADED_FILE_PATH + fileName;

			writeFile(bytes,filepath);

			System.out.println("pdf uploaded!!!");
			//get the mailto
			String mailto = input.getFormDataPart("mailTo", String.class, null);
			System.out.println("le mail "+mailto);
			//call the sendmail function
			sendmail(mailto,fileName,filepath);

		  } catch (IOException e) {
			e.printStackTrace();
		  }

		}
		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();

	}

	
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	//save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}
	private void sendmail(String mailto,String filename,String filepath){

		final String username = "ragroug11@gmail.com";
		final String password = "assassinomar";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		sendAttachmentEmail(session, mailto, "Credentials validation", filename,filepath);
		
	}
	public void sendAttachmentEmail(Session session, String mailto, String subject, String filename,String filepath){
		try{
	         MimeMessage msg = new MimeMessage(session);
	         msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		     msg.addHeader("format", "flowed");
		     msg.addHeader("Content-Transfer-Encoding", "8bit");
		      
		     msg.setFrom(new InternetAddress("ragroug11@gmail.com"));

		     //msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));

		     msg.setSubject(subject, "UTF-8");

		     msg.setSentDate(new Date());

		     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailto, false));
		      
	         // Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         String message = "<i>Greetings!</i><br>";
	         message += "<b>THIS IS A TEST!</b><br>";
	         message += "<font color=red>ANIMAL CARING</font>";
	         messageBodyPart.setContent(message, "text/html");
	         
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Second part is attachment
	         messageBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource(filepath);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         msg.setContent(multipart);

	         // Send message
	         Transport.send(msg);
	         System.out.println("EMail Sent Successfully with attachment!!");
	      }catch (MessagingException e) {
	         e.printStackTrace();
	      } 
	}
}
