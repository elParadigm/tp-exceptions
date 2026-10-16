package connexion;

public class Utilisateur {
    private static final int MAX_TENTATIVES = 3;

    private String login;
    private String password;
    private int tentatives = 0;
    private boolean bloque = false;

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void connecter(String login, String password)
            throws IdentifiantsInvalidesException, CompteBloqueException {
        if (bloque) {
            throw new CompteBloqueException("Compte bloqué.");
        }
        if (this.login.equals(login) && this.password.equals(password)) {
            tentatives = 0;   // succès : on remet le compteur à zéro
            System.out.println("Connexion réussie.");
            return;
        }
        tentatives++;
        if (tentatives >= MAX_TENTATIVES) {
            bloque = true;
        }
        throw new IdentifiantsInvalidesException(
                "Erreur : identifiants incorrects. Tentative "
                        + tentatives + "/" + MAX_TENTATIVES);
    }
}