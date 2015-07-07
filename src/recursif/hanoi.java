package recursif;

public class hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi h=new hanoi();
		h.jeu_tour(3,'A','B','C');
	}

	public void jeu_tour(int nbre,char debut, char inter,char fin){
		if(nbre==1)System.out.println("Disque 1 de "+debut+" à "+fin);
		else{
			jeu_tour(nbre-1,debut,fin,inter);
			System.out.println("Disque "+nbre+" de "+debut+" à "+fin);
			jeu_tour(nbre-1,inter,debut,fin);
		}
	}
}
