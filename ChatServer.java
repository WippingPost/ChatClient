package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread {

	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(10011);
			Socket socket = serverSocket.accept();

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Writer output = new OutputStreamWriter(socket.getOutputStream());

			ChatUI theUI = new ChatUI("Server End", output);
			String line;
			while ((line = input.readLine()) != null) {
				theUI.appendText(line);
			}
			theUI.appendText("Connection lost");
			serverSocket.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
