package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class ChatClientGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientGUI frame = new ChatClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClientGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTextArea sendMail = new JTextArea();
		contentPane.add(sendMail, BorderLayout.SOUTH);

		JTextArea chat = new JTextArea();
		chat.setEditable(false);
		chat.setEnabled(false);
		contentPane.add(chat, BorderLayout.CENTER);

		JButton send = new JButton("Senden");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = sendMail.getText().trim();
				sendMail.setText(null);
				
				chat.setText(chat.getText()+message+"\n");
			}
		});
		contentPane.add(send, BorderLayout.EAST);

	}

}
