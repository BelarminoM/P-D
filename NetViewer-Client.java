import java.net.*;
import java.io.*;

public class Main {
// NetViewer-Client
	public static void main(String[] args) {
		try{
			int tamArq=6022386, bytesLidos, atual = 0;
			long tempoIni = System.currentTimeMillis();
			Socket sock = new Socket("10.0.2.168",5764);
			System.out.println("Conectado...");
			// recebendo o arquivo
			byte [] binario  = new byte [tamArq];
			InputStream inStream = sock.getInputStream();

			BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream("D:\\telaEdson.jpg"));
			bytesLidos = inStream.read(binario,0,binario.length);
			atual = bytesLidos;
			do {
				bytesLidos = inStream.read(binario, atual, (binario.length - atual));
			    if(bytesLidos >= 0) atual += bytesLidos;
			} while(bytesLidos > -1);
			
			outStream.write(binario, 0 , atual);
			long tempoFin = System.currentTimeMillis();
			System.out.println((tempoFin - tempoIni) + " ms\nConcluído.");
			outStream.close(); sock.close();
		} catch (Exception e){ System.err.println(e);}
	}
}
