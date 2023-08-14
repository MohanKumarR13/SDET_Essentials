package com.abcbank;

import com.bank.FundTransfer;

public class NetBankingOperations {

	public static void main(String[] args) {
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.fundTransfer("David", "John", 100);

	}

}
