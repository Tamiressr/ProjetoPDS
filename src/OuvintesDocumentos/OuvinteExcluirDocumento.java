package OuvintesDocumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Facade.Facade;
import Model.Documentacao;
import View.JanelaDocumentacao;

public class OuvinteExcluirDocumento implements ActionListener{
	private JanelaDocumentacao janela;
	
	public OuvinteExcluirDocumento(JanelaDocumentacao janela) {
		this.janela=janela;
	}

	public void actionPerformed(ActionEvent e) {
		Documentacao documento=janela.linhaSelecionada();
		if (documento != null) {
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir sua Turma?");

			if (confirm == 0) {
				Facade.getFacade().excluirDocumento(documento.getId());
				janela.removerLinha();
				janela.getFrame().repaint();
			} else {

			}
		}else {
			JOptionPane.showMessageDialog(null,"Turma não selecionada");
		}
		
	}

}
