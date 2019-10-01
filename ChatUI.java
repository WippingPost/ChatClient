package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatUI {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea chatText;
	private JTextField entryText;

	// Variables for window size and placement
	private int width = 300;
	private int height = 300;
	private int padding = 20;
	private static int counter = 0;

	public ChatUI(String title, Writer output) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new JFrame(title);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				chatText = new JTextArea();
				chatText.setEditable(false);
				scrollPane = new JScrollPane(chatText);
				frame.add(scrollPane, BorderLayout.CENTER);
				entryText = new JTextField();

				entryText.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {
						String line = entryText.getText();
						try {
							output.write(line + "\n");
							output.flush();
							chatText.append("Me: " + line + "\n");
							entryText.setText("");
						} catch (IOException e) {
							e.printStackTrace();
							chatText.append("Other party hung up :(");
						}
					}

				});

				frame.add(entryText, BorderLayout.SOUTH);

				frame.setBounds(padding + (width * counter), 20, width, height);
				frame.setVisible(true);
				counter ++;
			}
		});

	}

	public void appendText(String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				chatText.append("They: " + message +"\n");
			}

	});
	}
}
