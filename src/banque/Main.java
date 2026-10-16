package banque;

public class Main {
    public static void main(String[] args) {
        Compte c = new Compte("C001", 500);

        try {
            c.deposer(200);
            c.retirer(100);
            c.retirer(1000);   // lève SoldeInsuffisantException
            c.deposer(-50);    // non atteint ici, testez-le séparément
        } catch (MontantInvalideException e) {
            System.out.println("Erreur montant : " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur solde : " + e.getMessage());
        } finally {
            System.out.println("Opération terminée. Solde actuel : " + c.getSolde());
        }
    }
}