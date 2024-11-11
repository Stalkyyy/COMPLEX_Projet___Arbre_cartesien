/**
 * Représente un arbre cartésien.
 */
public class CartesianTree {
    private Node root;


    /**
     * Crée un nouvel arbre cartésien sans noeud.
     */
    public CartesianTree() {
        this.root = null;
    }


    /* =========================================================================== */


    /**
     * Renvoie la racine de l'arbre cartésien.
     * 
     * @return La racine de l'arbre cartésien.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Définit la racine de l'arbre cartésien.
     * 
     * @param root Le nouveau noeud racine de l'arbre cartésien.
     */
    public void setRoot(Node root) {
        this.root = root;
    }


    /* =========================================================================== */


    /**
     * Vérifie si l'arbre cartésien est vide.
     * 
     * @return true si l'arbre cartésien est vide, false sinon.
     */
    public boolean isEmpty() {
        return root == null; 
    }


    /* =========================================================================== */


    /**
     * Recherche un noeud dans l'arbre en fonction d'une clé.
     * 
     * @param key La clé à rechercher dans l'arbre.
     * @return Le noeud correspondant à la clé, ou null si la clé n'est pas trouvée.
     */
    public Node searchKey(String key) {
        return searchKey(root, key);
    }

    /**
     * Méthode récursive pour rechercher un noeud à partir d'un noeud et d'une clé donnés.
     * 
     * @param node Le noeud à partir duquel commencer.
     * @param key La clé à rechercher dans l'arbre.
     * @return Le noeud correspondant à la clé, ou null si la clé n'est pas trouvée.
     */
    private Node searchKey(Node node, String key) {
        if (node == null)
            return null;
        
        String keyNode = node.getKey();

        if (key.equals(keyNode))
            return node;

        else if (key.compareTo(keyNode) < 0)
            return searchKey(node.getChildLeft(), key);
        
        else
            return searchKey(node.getChildRight(), key);
    }


    /* =========================================================================== */

    /**
     * Insère un noeud donné dans l'arbre cartésien.
     * 
     * @param node Le noeud à ajouter dans l'arbre.
     */
    public void insert(Node node) {
        this.root = insertRec(node, root);
    }

    /**
     * Insère récursivement un noeud donné dans l'arbre cartésien à partir d'un noeud courant.
     * 
     * <p>Initialement, l'insertion va se faire comme dans un arbre binaire de recherche.
     * Ensuite, on fera des rotations d'arbre pour rétablir la priorité de tas.</p>
     * 
     * @param nodeToInsert Le noeud à insérer dans l'arbre.
     * @param currentNode Le noeud courant à partir duquel commencer l'insertion.
     * @return Le noeud courant après l'insertion et les éventuelles rotations.
     */
    private Node insertRec(Node nodeToInsert, Node currentNode) {

        if (currentNode == null)
            return nodeToInsert;

        String keyToInsert = nodeToInsert.getKey();
        String currentKey = currentNode.getKey();

        // Insertion type ABR - Si la clé est plus petite, on l'insère à gauche.
        if (keyToInsert.compareTo(currentKey) < 0) {
            currentNode.setChildLeft(insertRec(nodeToInsert, currentNode.getChildLeft()));

            // Insertion type tas - On fait une rotation droite si la condition des priorités n'est pas respectée. 
            if (currentNode.getChildLeft().getPriority() < currentNode.getPriority())
                currentNode = rotationRight(currentNode);
        } 

        // Insertion type ABR - Si la clé est plus grande, on l'insère à droite.
        else if (keyToInsert.compareTo(currentKey) > 0) {
            currentNode.setChildRight(insertRec(nodeToInsert, currentNode.getChildRight()));

             // Insertion type tas - On fait une rotation gauche si la condition des priorités n'est pas respectée.
            if (currentNode.getChildRight().getPriority() < currentNode.getPriority())
                currentNode = rotationLeft(currentNode);
        }

        return currentNode;
    }

    /**
     * Effectue une rotation à gauche sur le noeud donné.
     * 
     * <p>Explication de la rotation :</p>
     * <img src="../images/rotationExplication.png" alt="Explication des rotations" style="width:100%; max-width:600px; height:auto;">
     * 
     * @param x Le noeud sur lequel effectuer la rotation à gauche.
     * @return Le nouveau noeud racine après la rotation.
     */
    private Node rotationLeft(Node x) {
        Node a = x.getChildLeft();
        Node y = x.getChildRight();
        Node b = y.getChildLeft();
        Node c = y.getChildRight();

        y.setChildLeft(x);
        y.setChildRight(c);

        x.setChildLeft(a);
        x.setChildRight(b);

        return y;
    }

    /**
     * Effectue une rotation à gauche sur le noeud donné.
     * 
     * <p>Explication de la rotation :</p>
     * <img src="../images/rotationExplication.png" alt="Explication des rotations" style="width:100%; max-width:600px; height:auto;">
     * 
     * @param y Le noeud sur lequel effectuer la rotation à gauche.
     * @return Le nouveau noeud racine après la rotation.
     */
    private Node rotationRight(Node y) {
        Node x = y.getChildLeft();
        Node a = x.getChildLeft();
        Node b = x.getChildRight();
        Node c = y.getChildRight();

        y.setChildLeft(b);
        y.setChildRight(c);

        x.setChildLeft(a);
        x.setChildRight(y);

        return x;
    }


    /* =========================================================================== */


    /**
     * Supprime le noeud de l'arbre correspondant à la clé donnée.
     * 
     * @param key La clé du noeud dont on souhaite la suppression.
     */
    public void delete(String key) {
        root = deleteRec(root, key);
    }

    /**
     * Supprime récursivement le noeud représenté par la clé donné à partir du noeud courant.
     * 
     * @param currentNode Le noeud courant.
     * @param key La clé du noeud dont on souhaite la suppression.
     * @return Le noeud supprimé s'il est trouvé, null sinon.
     */
    private Node deleteRec(Node currentNode, String key) {
        // Le noeud n'a pas été trouvé, on return null.
        if (currentNode == null)
            return null;

        // La clé à trouver est plus petite que celle du noeud courant, on regarde à gauche.
        if (key.compareTo(currentNode.getKey()) < 0)
            currentNode.setChildLeft(deleteRec(currentNode.getChildLeft(), key));

        // La clé à trouver est plus grande que celle du noeud courant, on regarde à droite.
        else if (key.compareTo(currentNode.getKey()) > 0)
            currentNode.setChildRight(deleteRec(currentNode.getChildRight(), key));

        // On a trouvé le noeud correspondant à la clé, on le supprime.
        else {
            Node cl = currentNode.getChildLeft();
            Node cr = currentNode.getChildRight();

            // Cas où le noeud est une feuille, on le supprime.
            if (cl == null && cr == null)
                return null;

            // Cas où le noeud a un seul enfant à droite, on le supprime et le remplace par son enfant.
            else if (cl == null)
                return cr;

            else if (cr == null)
                return cl;

            // Cas où le noeud a deux enfants.
            else {
                // On fait une rotation droite si la priorité du fils gauche est plus faible que celui de droite.
                if (cl.getPriority() < cr.getPriority()) {
                    currentNode = rotationRight(currentNode);
                    currentNode.setChildRight(deleteRec(currentNode.getChildRight(), key));
                }

                // Sinon une rotation gauche.
                else {
                    currentNode = rotationLeft(currentNode);
                    currentNode.setChildLeft(deleteRec(currentNode.getChildLeft(), key));
                }
            }
        }

        return currentNode;
    }




    /* =========================================================================== */


    /**
     * Vérifie si l'objet donné est l'arbre cartésien actuel.
     * 
     * @param obj L'obj dont on veut vérifier l'égalité avec l'arbre.
     * @return true si les arbres sont égaux, false sinon.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CartesianTree abr = (CartesianTree) obj;

        return root != null ? root.equals(abr.getRoot()) : abr.getRoot() == null;
    }


    /* =========================================================================== */


    @Override
    public String toString() {
        return root.toString();
    }
}