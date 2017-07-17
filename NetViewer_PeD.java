public class Main {

	public static void  main(String[] args) {
    	hostsRede();

	/** Possíveis dados que o cliente enviará */
	Properties p = System.getProperties();
	System.out.println("Sistema Operacional: " + p.getProperty("os.name") + "\tArquitetura: " + p.getProperty("os.arch") + "\tVersão: " + p.getProperty("os.version"));
	System.out.println("Usuário: " + p.getProperty("user.name") + "\tPasta: " + p.getProperty("user.home"));
}
  
public static void hostsRede(){
	/** @author MiguelCabral */
	byte[] end = new byte[4];
	end[0] = (byte)192;
	end[1] = (byte)168;
	end[2] = (byte)0;
	for(short i=100; i<106; i++){
		end[3] = (byte)i;
		try{
			InetAddress host = InetAddress.getByAddress(end);
			if (host.isReachable(1000)) System.out.print("Ok");
			else System.out.print("TimeOut");
			System.out.println("\tNome: " + host.getHostName() + "\tIP: " + host.getHostAddress());
		}catch (Exception e){}
	}
}
