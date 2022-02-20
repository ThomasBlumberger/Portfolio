import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Boolean b;
		int port = Integer.parseInt(args[0]);
		ServerSocket ss = new ServerSocket(port);
		List<Object> list1 = new ArrayList<>();
		while (true) {
			Socket s = ss.accept();
			Socket so = ss.accept();
			Socket s2 = ss.accept();
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataOutputStream das = new DataOutputStream(s2.getOutputStream());
			
			dos.flush();
			
			if (list1.size() > 0) {
				ObjectOutputStream objectOutput = new ObjectOutputStream(so.getOutputStream());
				objectOutput.flush();
				objectOutput.writeObject(list1);
				objectOutput.flush();
				b = true;
				dos.writeBoolean(b);
				dos.flush();
			}
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			b = false;
			dos.writeBoolean(b);
			dos.flush();
			String data = null;
			
			try {
				String sender = null;
				byte[] signatureToCheck = null;
				String message = null;
				String dat = null;
				Boolean verify = null;
				String stringUpdate = null;
				String compare = "empty";

				while ((data = dis.readUTF()) != null) {
					//Check for signature from received data and convert to byte array
					if (!data.contains("Sender") && !data.contains("Message") && !data.contains("Timestamp")) {
						stringUpdate = data;
						signatureToCheck = stringUpdate.getBytes("ISO-8859-1");
					}

					if (data.contains("Sender")) {
						String[] strings = data.split(":" + " ");
						
						for (String str : strings) {
							
							if (str.contains("Sender")) {
							} 
							else {
								sender = str;
							}
						}
					}

					if (data.contains("Timestamp")) {
						String[] strings = data.split(":" + " ");
						
						for (String str : strings) {
							
							if (str.contains("Timestamp")) {

							} 
							else {
								dat = str;
							}
						}
					}

					if (data.contains("Message")) {
						String[] strings = data.split(":" + " ");
						
						for (String str : strings) {
							
							if (str.contains("Message")) {

							} 
							else {
								message = str;
							}
						}
					}
					
					if (message != null && dat != null && sender != null) {
						compare = sender + dat + message;
					}

					if (compare.equals(sender + dat + message)) {
						ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(sender + ".pub"));
						PublicKey publicKey = (PublicKey) keyIn.readObject();
						keyIn.close();
						
						Signature sig = Signature.getInstance("SHA1withRSA");
						sig.initVerify(publicKey);
						sig.update(compare.getBytes());
						verify = sig.verify(signatureToCheck);
						
						if (verify) {
							das.writeUTF("verified");
							dos.flush();
							list1.add("Sender: " + sender);
							list1.add("Timestamp: " + dat);
							list1.add("Message: " + message);
							System.out.println("Sender: " + sender);
							System.out.println("Timestamp: " + dat);
							System.out.println("Message: " + message);
							System.out.println("");
						} 
						else {
							das.writeUTF("unverified");
							dos.flush();
						}
						//null for new data reading
						sender = null;
						dat = null;
						message = null;
						stringUpdate = null;
						signatureToCheck = null;
						compare = "empty";
						verify = null;
					}
				}
			} 
			catch (IOException e) {
			}
		}
	}
}