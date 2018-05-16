package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {
	private XStream xtream = new XStream(new DomDriver());
	private File arquivo = new File("Escola.xml");
	private static Persistencia persistencia = null;

	private Persistencia() {

	}

	public static Persistencia getPersistencia() {
		if (persistencia == null) {
			persistencia = new Persistencia();
		}
		return persistencia;
	}

	public void salvarCentral(CentralDeInformacoes central) {

		String xml = xtream.toXML(central);

		try {
			if (!arquivo.exists())
				arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CentralDeInformacoes recuperarCentral() {
		FileReader ler = null;

		try {
			if (arquivo.exists()) {
				ler = new FileReader(arquivo);
				return (CentralDeInformacoes) xtream.fromXML(ler);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return CentralDeInformacoes.getCentralDeInformacoes();
	}
}
