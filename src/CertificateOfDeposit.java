// CertificateOfDeposit.java
import java.time.LocalDate; // Pour gérer les dates

public class CertificateOfDeposit extends BankAccount {
    // Attributs supplémentaires
    private LocalDate maturityDate; // Date à laquelle le COD arrive à échéance
    private double penaltyRate;     // Taux de pénalité pour retrait anticipé

    // Constructeur
    public CertificateOfDeposit(String accountNumber, double initialBalance, LocalDate maturityDate, double penaltyRate) {
        super(accountNumber, initialBalance); // Appelle le constructeur de BankAccount
        this.maturityDate = maturityDate;
        this.penaltyRate = penaltyRate;
    }

    // Getters spécifiques
    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public double getPenaltyRate() {
        return penaltyRate;
    }

    // Setters spécifiques
    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setPenaltyRate(double penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    // Surcharge de la méthode withdraw pour inclure la pénalité si retrait anticipé
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (LocalDate.now().isBefore(maturityDate)) {
                // Retrait anticipé, appliquer une pénalité
                double penaltyAmount = amount * (penaltyRate / 100);
                double actualWithdrawal = amount + penaltyAmount; // La pénalité est "en plus" du montant retiré

                if (this.balance >= actualWithdrawal) {
                    this.balance -= actualWithdrawal;
                    System.out.println("Retrait anticipé de " + amount + " du COD " + accountNumber + ".");
                    System.out.println("Pénalité appliquée : " + penaltyAmount + ". Coût total : " + actualWithdrawal);
                    System.out.println("Nouveau solde : " + balance);
                } else {
                    System.out.println("Fonds insuffisants pour le retrait anticipé (avec pénalité) sur le COD " + accountNumber + ".");
                }
            } else {
                // Après la date d'échéance, retrait normal
                super.withdraw(amount); // Appelle la méthode withdraw de BankAccount
            }
        } else {
            System.out.println("Le montant du retrait doit être positif.");
        }
    }
}