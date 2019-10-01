package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ChatClient extends Thread {

	@Override
	public void run() {
		try {
			Socket socket = new Socket("127.0.0.1", 10011);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Writer output = new OutputStreamWriter(socket.getOutputStream());
			ChatUI theUI = new ChatUI("Client End", output);
			String line;
			while ((line = input.readLine()) != null) {
				sleep(500);
				theUI.appendText(line);
			}
			theUI.appendText("Client Connection lost");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


