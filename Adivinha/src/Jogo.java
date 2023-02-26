import javax.swing.JOptionPane;
public class Jogo {
	public static void main(String[] args) {
		Controle c = new Controle();
		String aux="", inicia="";	
		
		inicia = c.iniciaJogo();
		JOptionPane.showMessageDialog(null,inicia);

		
		aux = c.finalJogo(c.numeroInicial(), c.numeroFinal(), c.qtdJogadores(), c.qtdPalpite());
		JOptionPane.showMessageDialog(null,aux);
	}
}
	