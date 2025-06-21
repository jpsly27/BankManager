// CheckingAccount.java
public class CheckingAccount extends BankAccount {
    // Attribut supplémentaire
    private double limit; // Limite de découvert ou de retrait

    // Constructeur
    public CheckingAccount(String accountNumber, double initialBalance, double limit) {
        super(accountNumber, initialBalance); // Appelle le constructeur de BankAccount
        this.limit = limit;
    }

    // Getter spécifique
    public double getLimit() {
        return limit;
    }

    // Setter spécifique
    public void setLimit(double limit) {
        this.limit = limit;
    }

    // On peut surcharger la méthode withdraw si la limite s'applique au retrait
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            // Permet le retrait si le solde + la limite est suffisant
            if (this.balance + this.limit >= amount) {
                this.balance -= amount;
                System.out.println("Retrait de " + amount + " du compte courant " + accountNumber + ". Nouveau solde : " + balance);
            } else {
                System.out.println("Limite de découvert dépassée pour le compte " + accountNumber + ". Solde actuel: " + balance + ", Limite: " + limit);
            }
        } else {
            System.out.println("Le montant du retrait doit être positif.");
        }
    }
}