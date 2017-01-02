package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientIF> chatClients;
	
	
	protected ChatServer() throws RemoteException{
		chatClients = new ArrayList<ChatClientIF>();
		
	}
	
	@Override
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		//Speichern der Chatclients f�r Broadcast
		this.chatClients.add(chatClient);
	}

	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		//broadcast an alle ChatClients
		int i=0;
		while(i<chatClients.size()){
			chatClients.get(i++).retrieveMessage(message);
		}
	}

}
