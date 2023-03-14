package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + " «" + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert(force>=0);
		int forcedebut = force;
		force -= forceCoup;
		assert(force < forcedebut);
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	private void equipe(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.toString() + ".");
	}
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 0:{
				equipe(equipement);
				break;
			}
			case 1: {
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
				} else {
					equipe(equipement);
				}
				break;
			}
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}
	}
	public static void main(String[] args) {
		Gaulois obelix = new Gaulois("Obelix",42);
		Romain romain = new Romain("Romain",2);
		System.out.println(romain);
		romain.parler("Pouic !");
		System.out.println(romain.prendreParole());
		romain.recevoirCoup(1);
		romain.recevoirCoup(1);
		Romain minus = new Romain("Minus",3);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}
