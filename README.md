# BankManager

Ce projet est une application Java qui simule un système bancaire simple en utilisant les principes de la programmation orientée objet (POO), notamment l'héritage. Il modélise différents types de comptes bancaires avec des fonctionnalités spécifiques à chacun.

---

## Structure des Classes

Le projet est organisé autour d'une hiérarchie de quatre classes Java :

1.  ### `BankAccount.java`
    C'est la classe de base qui représente un compte bancaire générique. Elle définit les attributs et comportements communs à tous les types de comptes.

    -   **Attributs** :
        -   `accountNumber` (String) : Le numéro unique du compte.
        -   `balance` (double) : Le solde actuel du compte.
    -   **Méthodes principales** :
        -   Constructeur pour initialiser un compte avec un numéro et un solde initial.
        -   `getAccountNumber()` : Retourne le numéro de compte.
        -   `getBalance()` : Retourne le solde du compte.
        -   `setBalance()` : Permet de modifier le solde (utilisé en interne ou pour des ajustements).
        -   `deposit(double amount)` : Ajoute un montant au solde du compte.
        -   `withdraw(double amount)` : Retire un montant du solde du compte, avec vérification des fonds suffisants.

2.  ### `CheckingAccount.java`
    Cette classe **hérite** de `BankAccount` et représente un compte courant. Elle ajoute une fonctionnalité spécifique liée à une limite de découvert.

    -   **Attribut supplémentaire** :
        -   `limit` (double) : La limite de découvert autorisée pour ce compte.
    -   **Méthodes spécifiques** :
        -   Constructeur qui appelle le constructeur de `BankAccount` et initialise la limite.
        -   `getLimit()` et `setLimit()` : Pour gérer la limite de découvert.
        -   **Surcharge de `withdraw()`** : La méthode de retrait est modifiée pour tenir compte de la `limit` lors d'un retrait, permettant de passer en négatif jusqu'à cette limite.

3.  ### `SavingsAccount.java`
    Cette classe **hérite** de `BankAccount` et représente un compte d'épargne. Elle inclut un taux d'intérêt.

    -   **Attribut supplémentaire** :
        -   `interestRate` (double) : Le taux d'intérêt annuel applicable au compte.
    -   **Méthodes spécifiques** :
        -   Constructeur qui appelle le constructeur de `BankAccount` et initialise le taux d'intérêt.
        -   `getInterestRate()` et `setInterestRate()` : Pour gérer le taux d'intérêt.
        -   `applyInterest()` : Calcule et ajoute les intérêts au solde du compte.

4.  ### `CertificateOfDeposit.java` (COD)
    Cette classe **hérite** de `BankAccount` et représente un certificat de dépôt (placement à terme). Elle inclut une date d'échéance et une pénalité pour les retraits anticipés.

    -   **Attributs supplémentaires** :
        -   `maturityDate` (LocalDate) : La date à laquelle le certificat arrive à échéance.
        -   `penaltyRate` (double) : Le taux de pénalité appliqué en cas de retrait avant la date d'échéance.
    -   **Méthodes spécifiques** :
        -   Constructeur qui appelle le constructeur de `BankAccount` et initialise la date d'échéance et le taux de pénalité.
        -   `getMaturityDate()`, `setMaturityDate()`, `getPenaltyRate()`, `setPenaltyRate()` : Pour gérer les attributs spécifiques.
        -   **Surcharge de `withdraw()`** : La méthode de retrait est modifiée pour vérifier la `maturityDate`. Si le retrait est anticipé, une pénalité est calculée et appliquée au montant retiré.

---

## `BankManager.java` (Méthode `main`)

La classe `BankManager` contient la méthode `main()`, le point d'entrée de l'application. Elle sert à démontrer l'utilisation des classes de compte :

-   Elle crée une instance de chacune des trois classes enfants (`CheckingAccount`, `SavingsAccount`, `CertificateOfDeposit`).
-   Elle illustre l'accès aux attributs `accountNumber` et `balance` (hérités de `BankAccount`) pour chaque type de compte, en les définissant lors de l'initialisation et en les lisant via leurs méthodes `getter`.
-   Elle effectue des opérations de base (dépôt, retrait, application d'intérêt, retrait avec pénalité) pour montrer le comportement spécifique de chaque type de compte.

---

## Comment Accéder aux Attributs `accountNumber` et `balance`

Dans les classes enfants (`CheckingAccount`, `SavingsAccount`, `CertificateOfDeposit`), les attributs `accountNumber` et `balance` de la classe `BankAccount` sont accessibles grâce au mécanisme d'héritage :

-   **Via le constructeur de la classe parente (`super()`)** : Au moment de la création d'une instance de classe enfant, les valeurs de `accountNumber` et `balance` sont passées au constructeur de `BankAccount` à l'aide de `super()`.
-   **Via les méthodes `getter` héritées** : Les méthodes publiques `getAccountNumber()` et `getBalance()` définies dans `BankAccount` sont disponibles pour toutes les classes enfants, permettant de lire ces valeurs.
-   **Accès direct dans les sous-classes** : Étant donné que `accountNumber` et `balance` sont déclarés comme `protected` dans `BankAccount`, ils sont directement accessibles dans le code des classes enfants (par exemple, `this.balance`).

---

## Prérequis

-   **Java Development Kit (JDK) 8 ou plus récent** : Nécessaire pour compiler et exécuter le code Java.

---

## Installation et Exécution du Projet

Pour importer et exécuter ce projet dans un environnement de développement intégré (IDE) tel qu'IntelliJ IDEA, Eclipse ou VS Code :

1.  **Cloner le dépôt GitHub :**
    -   Ouvrez votre IDE.
    -   Recherchez l'option pour **"Get from VCS"** (ou "New Project from Version Control..." si vous avez déjà un projet ouvert).
    -   Sélectionnez Git et collez l'URL HTTPS de ce dépôt :
        `https://github.com/VotreNomUtilisateur/BankManager.git` (remplacez `VotreNomUtilisateur` par votre nom d'utilisateur GitHub).
    -   Choisissez un répertoire local pour le projet et cliquez sur **"Clone"**.

2.  **Ouvrir le projet :**
    -   Votre IDE devrait automatiquement détecter la nature du projet Java. Si une invite apparaît, confirmez l'ouverture en tant que projet.

3.  **Exécuter l'application `BankManager` :**
    -   Dans l'explorateur de projet de votre IDE, naviguez jusqu'à `src/BankManager.java`.
    -   Faites un clic droit sur le fichier `BankManager.java`.
    -   Sélectionnez l'option **"Run 'BankManager.main()'"** (ou une option similaire).

    Le programme s'exécutera dans la console de votre IDE, affichant les étapes de création de chaque compte et les résultats des opérations bancaires simulées.

---

## Structure du Projet
