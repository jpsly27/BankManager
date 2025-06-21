// BankManager.java
import java.time.LocalDate; // Importation nécessaire pour LocalDate

public class BankManager {

    public static void main(String[] args) {
        System.out.println("--- Gestionnaire Bancaire ---");

        // 1. Créer une instance de CheckingAccount
        System.out.println("\nCréation d'un Compte Courant (CheckingAccount)...");
        CheckingAccount checkingAcc = new CheckingAccount("CHK12345", 1500.00, 200.00); // Solde 1500, limite 200
        System.out.println("Compte Courant créé : Numéro = " + checkingAcc.getAccountNumber() +
                ", Solde = " + checkingAcc.getBalance() +
                ", Limite = " + checkingAcc.getLimit());

        // Accéder et modifier les attributs hérités (accountNumber et balance)
        // Via les getters
        System.out.println("Solde du compte courant (via getter) : " + checkingAcc.getBalance());
        // Via les méthodes de la classe de base (héritées)
        checkingAcc.deposit(500); // Déposer sur le compte courant
        checkingAcc.withdraw(1800); // Retirer plus que le solde mais dans la limite
        checkingAcc.withdraw(500); // Essayer de retirer au-delà de la limite

        // 2. Créer une instance de SavingsAccount
        System.out.println("\nCréation d'un Compte d'Épargne (SavingsAccount)...");
        SavingsAccount savingsAcc = new SavingsAccount("SAV67890", 5000.00, 1.5); // Solde 5000, taux 1.5%
        System.out.println("Compte d'Épargne créé : Numéro = " + savingsAcc.getAccountNumber() +
                ", Solde = " + savingsAcc.getBalance() +
                ", Taux d'intérêt = " + savingsAcc.getInterestRate() + "%");

        // Accéder et modifier les attributs hérités (accountNumber et balance)
        System.out.println("Solde du compte d'épargne (via getter) : " + savingsAcc.getBalance());
        savingsAcc.deposit(1000); // Déposer
        savingsAcc.applyInterest(); // Appliquer les intérêts

        // 3. Créer une instance de CertificateOfDeposit (COD)
        System.out.println("\nCréation d'un Certificat de Dépôt (COD)...");
        // Date d'échéance : 6 mois à partir d'aujourd'hui pour un test (ajustez si besoin)
        LocalDate maturity = LocalDate.now().plusMonths(6);
        CertificateOfDeposit codAcc = new CertificateOfDeposit("COD00112", 10000.00, maturity, 5.0); // Solde 10000, pénalité 5%
        System.out.println("COD créé : Numéro = " + codAcc.getAccountNumber() +
                ", Solde = " + codAcc.getBalance() +
                ", Date d'échéance = " + codAcc.getMaturityDate() +
                ", Taux de pénalité = " + codAcc.getPenaltyRate() + "%");

        // Accéder et modifier les attributs hérités (accountNumber et balance)
        System.out.println("Solde du COD (via getter) : " + codAcc.getBalance());
        codAcc.deposit(500); // Déposer sur le COD

        // Test de retrait anticipé (si la date n'est pas dépassée)
        System.out.println("\nTentative de retrait anticipé du COD...");
        codAcc.withdraw(1000); // Retrait anticipé

        // Vous pouvez ajuster la date d'échéance pour tester un retrait après échéance
        // codAcc.setMaturityDate(LocalDate.now().minusDays(1)); // Pour simuler une date passée
        // codAcc.withdraw(500); // Retrait après échéance (normal)

        System.out.println("\n--- Fin de la démonstration ---");
    }
}