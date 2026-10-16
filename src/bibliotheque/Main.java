package bibliotheque;

public class Main {
    public static void main(String[] args) {
        Bibliotheque b = new Bibliotheque();
        b.ajouter(new Livre("Java"));
        b.ajouter(new Livre("Jakarta EE"));

        try {
            b.emprunter("Java");        // OK
            b.emprunter("Java");        // LivreIndisponibleException
        } catch (LivreIntrouvableException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (LivreIndisponibleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            b.emprunter("Python");      // LivreIntrouvableException
        } catch (LivreIntrouvableException | LivreIndisponibleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}