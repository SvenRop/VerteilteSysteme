package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChatServerIF chatServer;
	private String name = null;

	protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.chatServer = chatServer;
		// register Client
		chatServer.registerChatClient(this);

	}

	@Override
	public synchronized void retrieveMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		// print out message
		System.out.println(message);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// reading commandline
		Scanner scanner = new Scanner(System.in);
		String message;
		// reading commandline and broadcast the message with the name
		while (true) {
			message = scanner.nextLine();
			try {
				chatServer.broadcastMessage(name + ": " + message);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
