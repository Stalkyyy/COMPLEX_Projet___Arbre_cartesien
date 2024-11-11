# Projet de COMPLEX : 2024 - 2025 (Gr3)

Notre projet 2024-2025 du module "Complexité, algorithmes randomisés et approchés" du master 1 de DAC à Sorbonne Université.

Les arbres cartésiens sont une structure de données qui combine les propriétés des arbres binaires de recherche et des tas. Ils ont été proposés par Jean Vuillemin en 1980. Voici un aperçu de leur structure et de leur fonctionnement :

**Structure**
- **Noeuds :** chaque noeud d'un arbre cartésien contient une clé (qui respecte l'ordre d'un arbre binaire de recherche) et une priorité (qui respecte l'ordre d'un tas).
- **Arbre binaire de recherche :** les noeuds sont organisés de manière à ce que, pour tout noeud, les clés de son sous-arbre gauche soient inférieures à sa clé, et celles de son sous-arbre droit soient supérieures.
- **Tas :** les noeuds sont également organisés delon la priorité, de sorte qu'un parent ait toujours une priorité inférieure à celle de ses enfants.

**Propriétés**
- **Equilibre probabiliste :** Les arbres cartésiens maintiennent une structure équilibrée de manière probabiliste. Cela signifie que les opérations d'insertion, de suppression et de recherche ont une complexité en temps moyenne de O(log n) même si dans le pire des cas, cela peut atteindre O(n) (où n désigne le nombre de noeuds de l'arbre cartésien).
- **Insertion et suppression :** Lors de l'insertion, un nouveau noeud est placé comme un noeud feuille dans l'arbre binaire de recherche. Puis, si sa priorité est inférieure à celle de son parent, il est "élevé" à travers des rotations jusqu'à ce que l'ordre du tas soit respecté.
- **Recherche :** La recherche d'une clé suit les règles d'un arbre binaire de recherche, ce qui la rend efficace.

Les arbres cartésiens sont utilisés dans diverses applications où une structure de données dynamique et équilibrée est nécessaire, comme la gestion de fichiers, les bases de données et les algorithmes de traitement d'événements. Le but de ce projet est d'implanter et d'analyser cette structure de données et d'effectuer des tests d'efficacités.

---

L'implémentation de l'arbre cartésien se trouve dans le répertoire `/src`.

Les tests de l'implémentation se trouve dans le répertoire `/test`.

La documentation se trouve dans le répertoire `/doc`.

---

PINHO FERNANDES Enzo
BEN SALAH Adel

Note : ???