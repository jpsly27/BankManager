// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    // Attribut supplémentaire
    private double interestRate; // Taux d'intérêt annuel

    // Constructeur
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance); // Appelle le constructeur de BankAccount
        this.interestRate = interestRate;
    }

    // Getter spécifique
    public double getInterestRate() {
        return interestRate;
    }

    // Setter spécifique
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Méthode pour calculer les intérêts (exemple)
    public void applyInterest() {
        double interest = this.balance * (interestRate / 100);
        this.balance += interest;
        System.out.println("Intérêts appliqués au compte d'épargne " + accountNumber + " : " + interest + ". Nouveau solde : " + balance);
    }
}