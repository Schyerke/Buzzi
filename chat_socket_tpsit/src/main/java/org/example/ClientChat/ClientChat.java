package org.example.ClientChat;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientChat {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket clientSocket;
		int porta = 12000;
		Scanner tastiera = new Scanner(System.in);
		String IPserver = "localhost";
		
		InputStream in;
		InputStreamReader input;
		BufferedReader sIn;
		
		OutputStream out;
		PrintWriter sOut;
		
		if(args.length > 0) {
			IPserver=args[0];
			if(args.length > 1) {
				porta = Integer.parseInt(args[1]);
			}
		}
		
		clientSocket = new Socket(IPserver, porta);
		System.out.println("Connessione avviata con server" + IPserver + "su porta " + porta);
		
		//inizializzazione flusso output
        out=clientSocket.getOutputStream();
        sOut=new PrintWriter(out);
        
        //inizializzazione flusso input
        in=clientSocket.getInputStream();
        input=new InputStreamReader(in);
        sIn=new BufferedReader(input);
        
        dialogoServer(sIn, sOut, tastiera);
        
        sIn.close();
        sOut.close();
        clientSocket.close();
        System.out.println("Connessione chiusa");
	}
	
	static void dialogoServer(BufferedReader sIn, PrintWriter sOut, Scanner tastiera) throws Exception {
		String msg;
		String risposta;
		boolean fineDialogo=true;
		
		risposta = sIn.readLine();
		
		
		while(fineDialogo) {
			System.out.println("Server:" + risposta);
			
			msg = tastiera.nextLine();
			sOut.println(msg);
			sOut.flush();
			
			risposta = sIn.readLine();
			
			if(risposta == null) {
				fineDialogo = false;
				System.out.println("La connessione con il server � chiusa.");
			} else if(risposta.equalsIgnoreCase("stop")) {
				fineDialogo = false;
				System.out.println("La connessione con il server � chiusa.");
			}
		}
	}

}
