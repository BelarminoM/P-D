import java.util.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class Aluno {
	
	/** Atributos */
	
	/** IP do hospedeiro */
	private String ip;
	/** Nome do hospedeiro */
	private String nomeHost;
	/** Endereço MAC do hospedeiro */
	private byte[] mac;
	/** Sistem Operacional do hospedeiro */
	private String sistemaOperacional;
	/** Arquitetura do hospedeiro */
	private String arquitetura;
	/** Versão do Sistem Operacional do hospedeiro */
	private String versaoSO;


	/** Método Construtor */
	
	/** Pode lançar exceção caso não consiga instanciar o hospedeiro */
	public Aluno() throws Exception {
		InetAddress host;
		try{
			host = InetAddress.getLocalHost();
			ip = host.getHostAddress();
			nomeHost = host.getHostName();
			mac = NetworkInterface.getByInetAddress(host).getHardwareAddress();
		} catch (Exception e){
			//System.err.println(e);
			throw new Exception (e);
		}
		Properties p = System.getProperties();
		sistemaOperacional = p.getProperty("os.name");
		arquitetura = p.getProperty("os.arch");
		versaoSO = p.getProperty("os.version");
	}


	/** Métodos Getters */
	
	public String getIp() {
		return ip;
	}

	public String getNomeHost() {
		return nomeHost;
	}

	public byte[] getMac() {
		return mac;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public String getVersaoSO() {
		return versaoSO;
	}

	
	/** Métodos Setters */
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setNomeHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}

	public void setMac(byte[] mac) {
		this.mac = mac;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public void setVersaoSO(String versaoSO) {
		this.versaoSO = versaoSO;
	}


	/** Método tostring */
	@Override
	public String toString() {
		return "Aluno: ip= " + ip + ", nomeHost= " + nomeHost + ", mac= " + Arrays.toString(mac) + ", sistemaOperacional= "
				+ sistemaOperacional + ", arquitetura= " + arquitetura + ", versaoSO= " + versaoSO;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquitetura == null) ? 0 : arquitetura.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + Arrays.hashCode(mac);
		result = prime * result + ((nomeHost == null) ? 0 : nomeHost.hashCode());
		result = prime * result + ((sistemaOperacional == null) ? 0 : sistemaOperacional.hashCode());
		result = prime * result + ((versaoSO == null) ? 0 : versaoSO.hashCode());
		return result;
	}


	/** Método equals */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (arquitetura == null) {
			if (other.arquitetura != null)
				return false;
		} else if (!arquitetura.equals(other.arquitetura))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (!Arrays.equals(mac, other.mac))
			return false;
		if (nomeHost == null) {
			if (other.nomeHost != null)
				return false;
		} else if (!nomeHost.equals(other.nomeHost))
			return false;
		if (sistemaOperacional == null) {
			if (other.sistemaOperacional != null)
				return false;
		} else if (!sistemaOperacional.equals(other.sistemaOperacional))
			return false;
		if (versaoSO == null) {
			if (other.versaoSO != null)
				return false;
		} else if (!versaoSO.equals(other.versaoSO))
			return false;
		return true;
	}

	
	/** Gera imagem atual da tela do hospedeiro */
	
	public File printScreen() throws Exception{
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		String caminho = new String("~/.ImagemDaTela");
		if (this.sistemaOperacional.toLowerCase().equals("windows"))
			caminho = "C:\\ImagemDaTela.log";
		
		try{
			BufferedImage tela = (new Robot()).createScreenCapture(new Rectangle(0, 0, d.width, d.height));
			File arquivo = new File (caminho);
		    ImageIO.write(tela, "png", arquivo);
		    return arquivo;
		} catch (Exception e){
			//System.err.println(e);
			throw new Exception (e);
		}
	}
	
}
