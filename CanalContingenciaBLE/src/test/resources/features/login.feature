Feature: Enter the BLE contingency channel
  As a user of Business Line Banking
  I want to log into the application
  To make use of the contingency channel

  @SuccessfulLogin
  Scenario: Successful login
    When the User enters with the correct credentials
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |
    Then he will verify that he successfully enters the channel

  @IncorrectLogin
  Scenario: Incorrect Login
    When the User enters with the incorrect credentials
      | userName      | password  |
      | USUARIOPRUEBA | Cert123## |
    Then he will verify that he no enters the channel


  @SuccessfulLoginByAttempst
  Scenario: Successful login
    When the User enters with the credentials and exceeds double factor attempts
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |
    Then he will verify that he  he no enters the channel by attempts
