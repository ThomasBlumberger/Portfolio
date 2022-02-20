import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		String host = args[0];
		int port = Integer.parseInt(args[1]);
		String userid = args[2];
		Socket s = new Socket(host, port);
		Socket so = new Socket(host, port);
		Socket s2 = new Socket(host, port);
		//On connect Arraylist
		ArrayList<String> connectList = new ArrayList<String>();
		//Once connected Arraylist
		ArrayList<String> posts = new ArrayList<String>();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataInputStream dis1 = new DataInputStream(s2.getInputStream());
		Boolean b = dis.readBoolean();
		
		if (s.isConnected() && b) {
			ObjectInputStream objectInput = new ObjectInputStream(so.getInputStream());
			Object object = objectInput.readObject();
			connectList = (ArrayList<String>) object;
		}
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while (s.isClosed() == false) {
				if (connectList.size() > 0) {
					if (connectList.size() > 0 && posts.isEmpty()) {
						for (int i = 0; i < connectList.size(); i++) {
							posts.add(connectList.get(i));
						}
					}
					if (posts.size() > 0) {
						try {
							ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(userid + ".prv"));
							PrivateKey key1 = (PrivateKey) in1.readObject();
							in1.close();
							
							System.out.println("There are " + posts.size() / 3 + " posts.");
							System.out.println("");
							
							for (int i = 0; i < posts.size(); i++) {
								//Splits strings in posts list to single out the message to attempt to decrypt on connect
								if (posts.get(i).contains("Message")) {
									String colon = posts.get(i).toString();
									String[] strings = colon.split(":" + " ");
									
									for (String str : strings) {
										
										if (str.contains("Message")) {
										} 
										else {
											Cipher cipher1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
											cipher1.init(Cipher.DECRYPT_MODE, key1);
											
											try {
												byte[] decode = Base64.getDecoder().decode(str.getBytes("UTF8"));
												
												try {
													byte[] stringBytes = cipher1.doFinal(decode);
													String result = new String(stringBytes, "UTF8");
													posts.remove(posts.get(i));
													posts.add(i, "Message: " + result);
												} 
												catch (BadPaddingException e) {
													break;
												}
											} 
											catch (IllegalArgumentException e) {
												break;
											}
										}
									}
								}
							}
						} 
						catch (FileNotFoundException e) {
							System.err.println("User " + userid + " doesn't exist.");
							System.exit(0);
						}

					}
					for (int i = 0; i < posts.size(); i++) {
						System.out.println(posts.get(i));
						if (posts.get(i).contains("Message")) {
							System.out.println("");
						}
					}
				} 
				else {
					System.out.println("There are " + posts.size() / 3 + " posts.");
					System.out.println("");
					if (posts.size() > 0) {
						
						for (int i = 0; i < posts.size(); i++) {
							System.out.println(posts.get(i));
							
							if (posts.get(i).contains("Message")) {
								System.out.println("");
							}
						}
					}
				}
				System.out.println("Do you want to add a post? [y/n]");
				String post = br.readLine();
				System.out.println("");
				
				if (post.strip().equals("y")) {
					System.out.println("Enter reciptent (or all):");
					String recipitent = br.readLine();
					System.out.println("");
					
					if (recipitent.equals("all")) {
						System.out.println("Enter your message:");
						String all = br.readLine();
						System.out.println("");
						
						Date d = new Date();
						String pattern = "EEE MMM dd HH:mm:ss z yyyy";
						DateFormat df = new SimpleDateFormat(pattern);

						ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(userid + ".prv"));
						PrivateKey privateKey = (PrivateKey) keyIn.readObject();
						keyIn.close();
						
						String signatureToSend = userid + df.format(d) + all;
						Signature sig = Signature.getInstance("SHA1withRSA");
						sig.initSign(privateKey);
						sig.update(signatureToSend.getBytes());
						byte[] signature = sig.sign();
						
						dos.writeUTF(new String(signature, "ISO-8859-1"));
						dos.flush();
						
						dos.writeUTF("Sender: " + userid);
						dos.flush();
						
						dos.writeUTF("Timestamp: " + df.format(d));
						dos.flush();
						
						dos.writeUTF("Message: " + all);
						dos.flush();

						String sign = dis1.readUTF();
						
						if (sign.equals("verified")) {
							System.out.println("Signature accepted");
							posts.add("Sender: " + userid);
							posts.add("Timestamp: " + df.format(d));
							posts.add("Message: " + all);
						} 
						else if (sign.equals("unverified")) {
							System.out.println("Signature rejected");
							System.out.println("Sender: " + userid);
							System.out.println("Timestamp: " + df.format(d));
							System.out.println("Message: " + all);
						}
					} 
					else {
						System.out.println("Enter your message:");
						String specific = br.readLine();
						System.out.println("");
						
						try {
							ObjectInputStream in = new ObjectInputStream(new FileInputStream(recipitent + ".pub"));
							PublicKey key = (PublicKey) in.readObject();
							in.close();
							
							Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
							cipher.init(Cipher.ENCRYPT_MODE, key);
							byte[] raw = cipher.doFinal(specific.getBytes("UTF8"));
							byte[] rawE = Base64.getEncoder().encode(raw);

							Date d = new Date();
							String pattern = "EEE MMM dd HH:mm:ss z yyyy";
							DateFormat df = new SimpleDateFormat(pattern);

							ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(userid + ".prv"));
							PrivateKey privateKey = (PrivateKey) keyIn.readObject();
							keyIn.close();

							String signatureToSend = userid + df.format(d) + new String(rawE);
							Signature sig = Signature.getInstance("SHA1withRSA");
							sig.initSign(privateKey);
							sig.update(signatureToSend.getBytes());
							byte[] signature = sig.sign();
							
							dos.writeUTF(new String(signature, "ISO-8859-1"));
							dos.flush();

							dos.writeUTF("Sender: " + userid);
							dos.flush();
							
							dos.writeUTF("Timestamp: " + df.format(d));
							dos.flush();
							
							dos.writeUTF("Message: " + new String(rawE));
							dos.flush();

							String sign = dis1.readUTF();
							
							if (sign.equals("verified")) {
								System.out.println("Signature accepted");
								posts.add("Sender: " + userid);
								posts.add("Timestamp: " + df.format(d));
								posts.add("Message: " + new String(rawE));
							} 
							else if (sign.equals("unverified")) {
								System.out.println("Signature rejected");
								System.out.println("Sender: " + userid);
								System.out.println("Timestamp: " + df.format(d));
								System.out.println("Message: " + specific);
							}
						} 
						catch (Exception e) {
							System.err.println("Recipitent " + recipitent + " doesn't exist");
							s.close();
						}
					}

				} 
				else if (post.strip().equals("n")) {
					s.close();
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();

		}
	}
}