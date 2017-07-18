public class Main {

	public static final byte MIN=(byte)100, MAX=(byte)107;
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
	try{
		end = InetAddress.getLocalHost().getAddress();
		/**  (short) (valorDeByte & 0xff) tira o sinal do byte */
		System.out.println("Rede: " + (short)(end[0] & 0xff) + "." + (short)(end[1] & 0xff) + "." + (short)(end[2] & 0xff) + ".0");
	}catch (Exception e){}
		
	for(end[3]=MIN; end[3]<MAX; end[3]++){
		try{
			InetAddress host = InetAddress.getByAddress(end);
			/** Testa a conexão com o host que tem Ip end
			if (host.isReachable(1000)) System.out.print("Ok");
			else System.out.print("TimeOut");
			
			System.out.println("\tNome: " + host.getHostName() + "\tIP: " + host.getHostAddress());
		}catch (Exception e){}
	}
}
	

