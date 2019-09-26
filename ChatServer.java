package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10011);
		Socket s = ss.accept();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Writer output = new OutputStreamWriter(s.getOutputStream());
		
		ChatUI theUI = new ChatUI("Server End", output);
		
		String line;
		while ((line = input.readLine()) != null) {
			theUI.appendText(line);
		}
		theUI.appendText("Connection lost");
		ss.close();
	}
}
