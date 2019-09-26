package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class chatTestIt {

	public static void main(String[] args) throws IOException {

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		ChatUI theUI = new ChatUI("Chat Program", new OutputStreamWriter(System.out));
		String line;
		while ((line = keyboard.readLine()) != null) {
			theUI.appendText(line);
		}
		
	}

}
