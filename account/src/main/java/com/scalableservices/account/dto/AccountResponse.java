package com.scalableservices.account.dto;

public class AccountResponse {

  private Long accountId;
  private Long accountNumber;
  private Long ProductId;
  private Long CustomerId;

  public Long getProductId() {
    return ProductId;
  }

  public void setProductId(Long productId) {
    ProductId = productId;
  }

  public Long getCustomerId() {
    return CustomerId;
  }

  public void setCustomerId(Long customerId) {
    CustomerId = customerId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

}
