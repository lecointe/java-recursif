package recursif;
import java.io.File;
import java.util.Scanner; 
import java.awt.Color;
public class repertoire {


	private String path="";
	private boolean recursivepath=false;
	public int nbrefichier=0;
	public int nbredossier=0;
	public int erreur=0;
	/**
	 * Constructeur
	 * @param pathaexplorer chemin du répertoire
	 * @param sous_dossier analyse des sous dossiers
	 */
public  repertoire(String pathaexplorer,boolean sous_dossier){

	super();
	this.path=pathaexplorer;
	this.recursivepath=sous_dossier;
}

public void list(){
	this.listRepertoire(this.path);
	
}

private void listRepertoire(String adress){
	try{
		File file=new File(adress);
	
		if (file.exists()==true){
			
	File[] listfile=file.listFiles();
	for(int i=0;i<listfile.length;i++){
		if (listfile[i].isDirectory()==false){
		System.out.println("Fichier:"+ listfile[i].getAbsolutePath());
		this.nbrefichier++;
		}
		else {
			System.out.println("Repertoire:"+ listfile[i].getAbsolutePath());
			this.nbredossier++;
			if(recursivepath==true)listRepertoire(listfile[i].getAbsolutePath());
		}
	}
	}else System.out.println("le chemin n'exist pas");
}
	catch(java.lang.NullPointerException e )
	{
		System.out.println(Color.RED+e.getMessage());
		erreur++;
	}
	
}

public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("url :");
	String nom = sc.nextLine();
	 Long start = System.currentTimeMillis();
	repertoire rep=new repertoire(nom,true);
	rep.list();
	  System.out.println("----------");
	  System.out.println("Analyse de " + nom + " en " + (System.currentTimeMillis() - start) + " mses");
	  System.out.println(rep.nbredossier + " dossiers");
	  System.out.println(rep.nbrefichier + " fichiers");
	  System.out.println(rep.erreur + " Erreur");
	
}
}
