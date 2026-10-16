package banque;

public class Compte {
    private String numero;
    private double solde;

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public double getSolde() { return solde; }

    public void deposer(double montant) throws MontantInvalideException {
        if (montant <= 0) {
            throw new MontantInvalideException("Montant invalide : " + montant);
        }
        solde += montant;
    }

    public void retirer(double montant)
            throws MontantInvalideException, SoldeInsuffisantException {
        if (montant <= 0) {
            throw new MontantInvalideException("Montant invalide : " + montant);
        }
        if (montant > solde) {
            throw new SoldeInsuffisantException(
                    "Solde insuffisant : solde = " + solde + ", demandé = " + montant);
        }
        solde -= montant;
    }
}