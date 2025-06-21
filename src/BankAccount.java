// BankAccount.java
 public class BankAccount {
    // Attributs
    protected String accountNumber; // Protected pour permettre l'accès direct aux classes enfants
    protected double balance;       // Protected pour permettre l'accès direct aux classes enfants

    // Constructeur
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setters (si nécessaire, ou des méthodes de dépôt/retrait plus spécifiques)
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Méthodes pour simuler des opérations de base (non demandé, mais bonne pratique)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Dépôt de " + amount + " sur le compte " + accountNumber + ". Nouveau solde : " + balance);
        } else {
            System.out.println("Le montant du dépôt doit être positif.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Retrait de " + amount + " du compte " + accountNumber + ". Nouveau solde : " + balance);
        } else if (amount <= 0) {
            System.out.println("Le montant du retrait doit être positif.");
        } else {
            System.out.println("Fonds insuffisants sur le compte " + accountNumber + ".");
        }
    }
}