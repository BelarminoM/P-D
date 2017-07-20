import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.*;
import javax.imageio.ImageIO;

import java.io.*;

public class Main {
	// NetViewer-Server
	public static void main(String[] args) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		try{
			ServerSocket servsock = new ServerSocket(5764);
			Robot robot = new Robot();
	
		    while (true) {
		    	Socket sock = servsock.accept();
		    	System.out.println("Conexão aceita: " + sock);
	
		    	BufferedImage tela = robot.createScreenCapture(new Rectangle(0, 0, d.width, d.height));
		    	File arquivo = new File ("D://testeDimensao.png");
		    	ImageIO.write(tela, "png", arquivo);// Salva a imagem
		    	
		    	BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(arquivo));
		    	byte [] binario  = new byte [(int)arquivo.length()];
		    	buffer.read(binario,0,binario.length);
		    	OutputStream stream = sock.getOutputStream();
		    	System.out.println("Enviando...");
		    	stream.write(binario,0,binario.length);
		    	stream.flush();
		    	// fechar socket, serversocket e stream de entrada
		    	sock.close(); servsock.close(); buffer.close();
		    	System.out.println("Concluído.");
		    }
		} catch (Exception e) { System.err.println(e); }
	}
}
