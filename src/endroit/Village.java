package endroit;
import personnages.*;
public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois villageois) {
		this.villageois[nbVillageois] = villageois;
		nbVillageois++;
	}
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			System.out.println("- " + gaulois.getNom());
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//l'indice 30 mène en dehors de l'emplacement mémoire réservé pour le tableau, 
		//en effet les indices vont normalement de 0 à 29 (30 indices différents)
		Chef abraracourcix = new Chef("Abraracourcix",8,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//On obtient null car seul village.villageois[0] est défini, vu qu'on a ajouté seulement 1 villageois
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}