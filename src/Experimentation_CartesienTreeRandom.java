public class Experimentation_CartesienTreeRandom {
    /**
     * Analyse le temps en nanosecondes d'insertion, de suppression et de recherche d'un arbre cartésien aléatoire à n noeuds.
     * De plus, affiche le nombre moyen et max de profondeur de l'arbre.
     * 
     * @param args Un entier supérieure ou égale à 1, correspondant au nombre de noeuds de l'arbre.
     */
    public static void main(String[] args) {

        // Vérification de l'argument n.
        if (args.length == 0) {
            System.out.println("Il faut donner un argument entier >= 1, étant le nombre de noeuds à insérer.");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
            if (n < 1) {
                System.out.println("L'argument doit être un entier supérieur ou égal à 1.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("L'argument fourni n'est pas un entier valide.");
            return;
        }


        /* =========================================================================== */

        // Création d'un tableau de n clés différentes.
        String[] keys = new String[n];
        for (int i = 0; i < n; i++)
            keys[i] = generateKey(i);

        System.out.println("Clés générées !");


        // Création de l'arbre cartésien aléatoire vide.
        CartesianTree tree = new CartesianTree();


        // Insertion de n noeud à priorités aléatoires et calcul de temps moyen.
        long startTime = System.nanoTime();
        for (String key : keys)
            tree.insert(new Node(key));
        long endTime = System.nanoTime();

        long meanDuration = (endTime - startTime);
        System.out.println("Temps d'insertion de " + n + " noeuds : " + meanDuration + " nanosecondes");


        /* =========================================================================== */
        // Vérification de la profondeur moyenne et max de l'arbre cartésien.

        int meanHeight = tree.sumHeight() / n;
        int maxHeight = tree.maxHeight();

        System.out.println("Profondeur moyenne : " + meanHeight);
        System.out.println("Profondeur max : " + maxHeight);


        /* =========================================================================== */
        // Recherche de tous les noeuds individuellement dans l'arbre + calcul du temps moyen.

        startTime = System.nanoTime();
        for (String key : keys)
            tree.searchKey(key);
        endTime = System.nanoTime();

        meanDuration = (endTime - startTime);
        System.out.println("Temps de recherche de " + n + " noeuds : " + meanDuration + " nanosecondes");


        /* =========================================================================== */
        // Suppression de tous les noeuds individuellement dans l'arbre + calcul du temps moyen.

        startTime = System.nanoTime();
        for (String key : keys)
            tree.delete(key);
        endTime = System.nanoTime();

        meanDuration = (endTime - startTime);
        System.out.println("Temps de suppression moyen de " + n + " noeuds : " + meanDuration + " nanosecondes");
    }


    private static String generateKey(int index) {
        StringBuilder key = new StringBuilder();
        while (index >= 0) {
            key.insert(0, (char) ('a' + index % 26));
            index = index / 26 - 1;
        }

        return key.toString();
    }
}
