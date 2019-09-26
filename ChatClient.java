package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ChatClient {
	
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1", 10011);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Writer output = new OutputStreamWriter(s.getOutputStream());
		
		ChatUI theUI = new ChatUI("Client End", output);
		
		String line;
		while ((line = input.readLine()) != null) {
			theUI.appendText(line);
		}
		theUI.appendText("Connection lost");
	}
}


