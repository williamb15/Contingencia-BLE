package co.com.banistmo.certification.contingencia.models;

public class User {

  private String userName;
  private String password;
  private String authenticationPart_1;
  private String authenticationPart_2;
  private String transaction;
  private String extension;
  private String fileName;
  private String delimiter;
  private String originAccount;

  public String getDelimiter() {
    return delimiter;
  }

  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  public String getOriginAccount() {
    return originAccount;
  }

  public void setOriginAccount(String originAccount) {
    this.originAccount = originAccount;
  }

  public String getTransaction() {
    return transaction;
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAuthenticationPart_1() {
    return authenticationPart_1;
  }

  public void setAuthenticationPart_1(String authenticationPart_1) {
    this.authenticationPart_1 = authenticationPart_1;
  }

  public String getAuthenticationPart_2() {
    return authenticationPart_2;
  }

  public void setAuthenticationPart_2(String authenticationPart_2) {
    this.authenticationPart_2 = authenticationPart_2;
  }
}
