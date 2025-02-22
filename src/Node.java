import java.util.Random;

/**
 * Représente un noeud composé d'une clé, d'une priorité et d'éventuellement un enfant gauche et droite.
 */
public class Node {
    private String key;
    private int priority;
    private Node child_left, child_right;



    /**
     * Crée un nouveau noeud à partir d'une clé et d'une priorité données.
     * 
     * @param key La clé du noeud.
     * @param priority La priorité du noeud.
     */
    public Node(String key, int priority) {
        this.key = key;
        this.priority = priority;
        this.child_left = null;
        this.child_right = null;
    }


    /**
     * Crée un nouveau noeud à partir d'une clé, et lui attribue une priorité aléatoire parmi l'intervalle complet des valeurs possibles pour un int en java. 
     * On choisit cet intervalle pour éviter d'avoir plusieurs priorités égales entre les noeuds.
     * 
     * @param key La clé du noeud.
     */
    public Node(String key) {
        this.key = key;
        this.priority = new Random().nextInt();
        this.child_left = null;
        this.child_right = null;
    }


    /* =========================================================================== */


    /**
     * Renvoie la clé du noeud.
     * 
     * @return La clé du noeud.
     */
    public String getKey() { 
        return key; 
    }

    /**
     * Définit la clé du noeud.
     * 
     * @param key La nouvelle clé du noeud.
     */
    public void setKey(String key) {
        this.key = key;
    }


    /* =========================================================================== */


    /**
     * Renvoie la priorité du noeud.
     * 
     * @return La priorité du noeud.
     */
    public int getPriority() { 
        return priority; 
    }

    /**
     * Définit la priorité du noeud.
     * 
     * @param priority La nouvelle priorité du noeud.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /* =========================================================================== */


    /**
     * Renvoie le fils gauche du noeud.
     * 
     * @return Le fils gauche du noeud.
     */
    public Node getChildLeft() { 
        return child_left; 
    }

    /**
     * Définit le fils gauche du noeud.
     * 
     * @param child_left Le nouveau fils gauche du noeud.
     */
    public void setChildLeft(Node child_left) {
        this.child_left = child_left;
    }


    /* =========================================================================== */


    /**
     * Renvoie le fils droite du noeud.
     * 
     * @return Le fils droite du noeud.
     */
    public Node getChildRight() {
        return child_right;
    }

    /**
     * Définit le fils droite du noeud.
     * 
     * @param child_right Le nouveau fils droite du noeud.
     */
    public void setChildRight(Node child_right) {
        this.child_right = child_right;
    }


    /* =========================================================================== */


    /**
     * Vérifie si l'objet donné est le noeud actuel.
     * 
     * @param obj L'obj dont on veut vérifier l'égalité avec le noeud.
     * @return true si les noeuds sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }  

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Node n = (Node) obj;

        if (!this.key.equals(n.key)) {
            return false;
        }

        if (this.priority != n.priority) {
            return false;
        }

        if (this.child_left != null ? !this.child_left.equals(n.child_left) : n.child_left != null) {
            return false;
        }

        if (this.child_right != null ? !this.child_right.equals(n.child_right) : n.child_right != null) {
            return false;
        }
        
        return true;
    }


    /* =========================================================================== */


    /**
     * Affiche le noeud, avec sa clé, priorité, et enfants.
     * 
     * @return L'affichage du noeud.
     */
    @Override
    public String toString() {
        return printNode(0);
    }

    private String printNode(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(key);
        sb.append(" : ");
        sb.append(priority);
        sb.append(")\n");

        
        for (int i = 0; i < depth; i++)
            sb.append("\t");
        sb.append("-> ");
        if (child_left != null) 
            sb.append(child_left.printNode(depth + 1)); 
        else 
            sb.append("null\n");


        for (int i = 0; i < depth; i++)
            sb.append("\t");
        sb.append("-> ");

        if (child_right != null) 
            sb.append(child_right.printNode(depth + 1)); 
        else 
            sb.append("null\n");
        
        return sb.toString();
    }


    /* =========================================================================== */


    /**
     * Return le nombre de noeud disponible à partir du noeud courant.
     * 
     * @return Le nombre de noeud de l'arbre cartésien, de racine ce noeud courant.
     */
    public int nbNode() {
        int res = 1;

        if (child_left != null)
            res += child_left.nbNode();
        
        if (child_right != null)
            res += child_right.nbNode();

        return res;
    }

    /* =========================================================================== */


    /**
     * Retourne la somme des profondeurs des noeuds accessibles à partir de ce noeud courant de profondeur p.
     * 
     * @param p La profondeur du noeud courant.
     * @return La somme des profondeurs des noeuds de l'arbre cartésien de racine ce noeud courant.
     */
    public int sumHeight(int p) {
        int res = p;

        if (child_left != null)
            res += child_left.sumHeight(p + 1);
        
        if (child_right != null)
            res += child_right.sumHeight(p + 1);

        return res;
    }


    /* =========================================================================== */


    /**
     * Retourne la profondeur max des fils de du noeud courant.
     * 
     * @param p La profondeur du noeud courant.
     * @return La profondeur max des fils de du noeud courant.
     */
    public int maxHeight(int p) {
        int leftHeight = (child_left != null) ? child_left.maxHeight(p + 1) : p;
        int rightHeight = (child_right != null) ? child_right.maxHeight(p + 1) : p;
        
        return Math.max(leftHeight, rightHeight);
    }
}
