package org.example.ServerChat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerChat {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		Socket connessione;
		int porta = 12000;
		Scanner tastiera = new Scanner(System.in);
		int contaRichieste = 0;
		
		InputStream in;
		InputStreamReader input;
		BufferedReader sIn;
		
		OutputStream out;
		PrintWriter sOut;
		
		InetAddress IPserver = InetAddress.getLocalHost();
		System.out.println("Il mio ip �:" + IPserver);
		
		serverSocket = new ServerSocket(porta);
		System.out.println("Servizio avviato su porta: " + porta);
		
		while(true) {
			System.out.println("In attesa di connessione...");
			connessione = serverSocket.accept();
			contaRichieste++;
			System.out.println("Ricevuta richiesta n." + contaRichieste);
			
			
			//inizializzazione flusso output
	        out=connessione.getOutputStream();
	        sOut=new PrintWriter(out);
	        
	        //inizializzazione flusso input
	        in=connessione.getInputStream();
	        input=new InputStreamReader(in);
	        sIn=new BufferedReader(input);
	        
	        dialogoServer(sIn, sOut, tastiera, contaRichieste);
	        
	        sOut.close();
	        sIn.close();
		}
		
	}
	
	static void dialogoServer(BufferedReader sIn, PrintWriter sOut, Scanner tastiera, int contaRichieste) throws Exception {
		String msg;
		String risposta;
		boolean fineDialogo = true;
				
		msg = "buongiorno dal server! Sei il client n." + contaRichieste + ", possiamo scambiare messaggi fino a quando uno dei due non scrive 'stop'";
		
		//invio messaggio
		sOut.println(msg);
		sOut.flush();
		
		//ricevimento risposta
		risposta = sIn.readLine();
		while(fineDialogo) {
			System.out.println("Il client risponde: " + risposta);
			
			msg = tastiera.nextLine();
			
			sOut.println(msg);
			sOut.flush();
			
			risposta = sIn.readLine();
			
			if(risposta == null) {
				fineDialogo = false;
				System.out.println("La connessione con il client � chiusa.");
			} else if(risposta.equalsIgnoreCase("stop")) {
				fineDialogo = false;
				System.out.println("La connessione con il client � chiusa.");
			}
		}
 	}
}
