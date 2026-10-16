package connexion;

public class Main {
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur("admin", "1234");

        // 4 essais : 3 erreurs, puis le compte est bloqué
        for (int i = 0; i < 4; i++) {
            try {
                utilisateur.connecter("admin", "abc");
            } catch (IdentifiantsInvalidesException e) {
                System.out.println(e.getMessage());
            } catch (CompteBloqueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}