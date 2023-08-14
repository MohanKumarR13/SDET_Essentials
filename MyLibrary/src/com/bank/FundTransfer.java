package com.bank;

public class FundTransfer {
	public void fundTransfer(String sender, String receiver, double amount) {
		System.out.println("Money Transfered to " + receiver + " of " + amount + " USD");
	}

	public static void main(String[] args) {
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.fundTransfer("David", "John", 100);

	}

}
