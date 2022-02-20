To use this software you must compile both classes (javac Server.java & javac Client.java)
A Server can then be started by the command line: java Server port
The "port" is for the client to connect to the server e.g. 1234
The Client can connect with the command line java Client host port userid
This is where the host can be localhost, port has to match that of the Server and the userid is the one who can join. e.g. java Client localhost 1234 alice
The userid has to match that of the public and private key pair.
The program is designed so that a user can follow simple inputs to add a post to the server and have it read back to them. Simplicity means only one Client can connect at once.
Once a post is added it will print on both the Server and client. 
On connection if there are no posts nothing will happen, if there are posts it will attempt to decrypt the post with the userids key.
If they aren't the relevant recipient, the server will print out the encryption in a form of a String, otherwise it will decrypt and display the message.
Due to this, the Client will never know if the message is decrypted for them or public.
