Feature: Validate double factor authentication
  As a Business Line Banking user
  I want to enter the double factor authentication codes
  To validate my credentials on the portal

  Background:
    Given the user is logged into the application
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |

  @SuccessfulValidation
  Scenario: Successful Validation
    When the User validates a correct file and enters the correct codes
      | originAccount | transaction | extension | fileName             | delimiter |
      | 0111708724    | Planilla    | CSV       | PlanillaCorrecto.csv | ,         |
    Then he sends to process a file correctly

  @InvalidCodeEntry
  Scenario: Invalid code entry
    When the User validates a correct file and enters the wrong codes
      | originAccount | transaction | extension | fileName             | delimiter |
      | 0111708724    | Planilla    | CSV       | PlanillaCorrecto.csv | ,         |
    Then he displays an error message

  @InvalidCodeEntryByAttempts
  Scenario: Invalid code entry by attempts
    When the User validates a correct file and enters the incorrect codes four times
      | originAccount | transaction | extension | fileName             | delimiter |
      | 0111708724    | Planilla    | CSV       | PlanillaCorrecto.csv | ,         |
    Then He sees 'Maximos Intentos Permitidos' message