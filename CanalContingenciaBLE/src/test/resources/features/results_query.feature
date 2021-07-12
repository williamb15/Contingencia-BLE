Feature: Check the status of a process
  As a Business Line Banking user
  Process send to a Batch
  To execute my transaction

  Background:
    Given the user is logged into the application
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |

  @QueryByNumber
  Scenario: Query By Number
    When the User validates and sends a file to be processed and query by process number
      | originAccount | transaction | extension | fileName             | delimiter |
      | 0111708724    | Planilla    | CSV       | PlanillaCorrecto.csv | ,         |
    Then he can see the information of the processed file

  @QueryByTransactionType
  Scenario: Query By Transaction Type
    When the User enter the query module and search by type of transaction
    Then he can see the information of the processed file