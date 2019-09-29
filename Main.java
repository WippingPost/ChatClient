package chat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatClient clientThread = new ChatClient();
		ChatServer serverThread = new ChatServer();

		serverThread.start();
		clientThread.start();
	}

}
