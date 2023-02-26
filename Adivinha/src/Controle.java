import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Controle {
	
	static String a="", pri="", nomejog="", nomef="", numfinal="", resumof="", quebrinha="", quebrinha2="";
	static int conf=0, jogadores=0, palpites=0, inicialval=0, ultimoval=0, palpitetentativa=0, rand=0, numeroCerto=0, palpite=0;
	ArrayList<Jogador> lista =  new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public String iniciaJogo() {	
		try {
			a = JOptionPane.showInputDialog(null,"Digite 1 para iniciar", 1);		
			conf = Integer.parseInt(a);			
			if(conf == 1) {
				pri = "Jogo inciado com sucesso!" + "\n";
			}else{	
				
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.");
		}	
		return pri;
	}
	
	public int qtdPalpite() {
		do {
			try {
				a = JOptionPane.showInputDialog(null,"Digite a quantidade de palpites", 1);	
				palpites = Integer.parseInt(a);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.");
				sc = new Scanner(System.in);
			}
			
			if(palpites < 1 || palpites > 4) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.");
				sc = new Scanner(System.in);
			}
			
		}while(palpites < 1 || palpites > 4);

		return palpites;
	}
	
	public int qtdJogadores() {
		
		do {
			try {
			a = JOptionPane.showInputDialog(null,"Digite a quantidade de jogadores", 1);	
			jogadores = Integer.parseInt(a);
			
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
				sc = new Scanner(System.in);
	
			}
			
			if(jogadores < 3) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
				sc = new Scanner(System.in);
			}
			
		}while(jogadores < 3);

			return jogadores;
	}
	
	public int numeroInicial() {
		
		do {
			try {	
			a = JOptionPane.showInputDialog(null,"Digite o primeiro numero do intervalo", 1);
			inicialval = Integer.parseInt(a);
			
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
			}
			
			if(inicialval < 0) {
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
				sc = new Scanner(System.in);
			}
			
		}while(inicialval < 0);
		
		return inicialval;
	}
	
	public int numeroFinal() {
		
		do {
			
			try {
				
				a = JOptionPane.showInputDialog(null,"Digite o ultimo numero do intervalo", 1);
				
				ultimoval = Integer.parseInt(a);
				
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
				
				sc = new Scanner(System.in);
			}
			
			if((ultimoval < inicialval + 50)) {
				
				JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
				
				sc = new Scanner(System.in);
			}
			
		}while(ultimoval < inicialval + 50);
		
		return inicialval;
	}
	
	public String nome() {
		
		try {
			
			nomejog = JOptionPane.showInputDialog(null,"Digite o nome dos jogadores", 1);

		}catch(Exception e1) {
			
			JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
			
			sc = new Scanner(System.in);
		}
		
		return nomejog;
	}
	
	public int tentaPalpite() {
			do {
				try {
					
					a = JOptionPane.showInputDialog(null,"Digite o seu palpite", 1);
					
					palpitetentativa = Integer.parseInt(a);
					
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
					
					sc = new Scanner(System.in);
				}
				if(palpitetentativa < 0) {
					JOptionPane.showMessageDialog(null,"Valor invalido! Digite novamente.", a ,0);
					
					sc = new Scanner(System.in);
				}
			}while(palpitetentativa < 0);
		
		return palpitetentativa;
	}
	
	public int geraNum(int a, int b) {
		Random r = new Random();
		rand = r.nextInt(b)+a;
		return rand;
	}

			public String finalJogo(int inicialv, int finalv, int qtdjogs, int palps) {
				
				numeroCerto = geraNum(inicialval, ultimoval);
					
				for(int i=0; i<jogadores; i++) {
					Jogador jog = new Jogador();
					
					nomef = nome();
					jog.setNome(nomef);
					
					for(int j=0; j<palpites; j++) {
						
						palpite = tentaPalpite();
						
						if(palpite == numeroCerto) {
							numfinal = quebrinha + palpite + " esta certo!" + "\n";

						}else {
							numfinal += palpite + " esta errado!" + "\n";

						}
						
						jog.setNumero(numfinal);
					}
					
					lista.add(jog);
					
					numfinal="";
				}
				
				for(int i=0; i<lista.size(); i++) {
					Jogador jog = new Jogador();
					jog = lista.get(i);
					resumof = resumof + jog.getNome() + " \n " + jog.getNumero();
				}
				
				resumof = resumof + "\n Numero certo : " + numeroCerto;
				
				return resumof;
			}
}