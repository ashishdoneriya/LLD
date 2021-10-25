public class ATM {
	String atmId;
	Address address;
	TouchScreen touchScreen;
	Keypad keypad;
	CashDispenser cashDispenser;
	CardReader cardReader;
	CashDeposit cashDeposit;
	ChequeDeposit checkDeposit;
	BankService bankService;
}

public class Address {
	String country;
	String state;
	String city;
	String street;
	String pincode;
}

public class TouchScreen {
	String getInput();
	void displayMessage(String message);
}

public class Keypad {
	String getInput();
}

public class CashDispenser {
	
	Map<CashType, List<Cash>> cashAvailable;
	void dispenseCash(int amount);
}

public Enum CashType {
	HUNDRED, TWO_HUNDRED, FIVE_HUNDRED, TWO_THOUSAND
}

public class Cash {
	CashType cashType;
	String serialNumber;
}

public class CardReader {
	CardInfo readCardInfo();
}

public class CardInfo {
	CardType cardType;
	Bank bank;
	String cardNumber;
	String cvv;
	String withdrawLimit;
	Date expiryDate;
}

public enum CardType {
	CREDIT_CARD, DEBIT_CARD;
}

public class Bank {
	Address address;
	String bankId;
	String bankName;
	List<ATM> atmList;
}

public interface BankService {
	boolean isValidUser(String pin, CardInfo cardInfo);
	Customer getCustomerDetail(CardInfo cardInfo);
	TransactionDetail exectuteTransaction(Customer customer, Transaction transaction);
}

public class Customer {
	Account account;
	BankService bankServiceObj;
	Address address;
	String name;
	CardInfo caredInfo;
}

public class Account {
	String accountNumber;
	double availableBalance;
}

public class Bank1 implements BankService {}
public class Bank2 implements BankService {}

public class Transaction {
	int transactionid;
	String sourceAccountNumber;
	Date transactionDate;
}

public class Deposit extends Transaction {
	double amount;
}

public class CashDeposit extends Deposit {
	List<Cash> getCash();
}

public class ChequeDeposit extends Deposit {
	public Cheque getCheque();
}

public class .
..
...

.
