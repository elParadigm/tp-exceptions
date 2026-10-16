package bibliotheque;

import java.util.ArrayList;

public class Bibliotheque {
    private ArrayList<Livre> livres = new ArrayList<>();

    public void ajouter(Livre livre) {
        livres.add(livre);
    }

    private Livre chercher(String titre) throws LivreIntrouvableException {
        for (Livre l : livres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                return l;
            }
        }
        throw new LivreIntrouvableException("Livre introuvable : " + titre);
    }

    public void emprunter(String titre)
            throws LivreIntrouvableException, LivreIndisponibleException {
        Livre l = chercher(titre);
        if (!l.isDisponible()) {
            throw new LivreIndisponibleException("Livre déjà emprunté : " + titre);
        }
        l.setDisponible(false);
        System.out.println("Emprunt effectué : " + titre);
    }

    public void retourner(String titre) throws LivreIntrouvableException {
        Livre l = chercher(titre);
        l.setDisponible(true);
        System.out.println("Livre retourné : " + titre);
    }
}