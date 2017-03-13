package com.wipro.pos.bean;

public class CreditCardBean {
String creditCardNumber;
String validFrom;
String validTo;
Double balance;
String userId;
public String getCreditCardNumber() {
	return creditCardNumber;
}
public void setCreditCardNumber(String creditCardNumber) {
	this.creditCardNumber = creditCardNumber;
}
public String getValidFrom() {
	return validFrom;
}
public void setValidFrom(String validFrom) {
	this.validFrom = validFrom;
}
public String getValidTo() {
	return validTo;
}
public void setValidTo(String validTo) {
	this.validTo = validTo;
}
public Double getBalance() {
	return balance;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
}
