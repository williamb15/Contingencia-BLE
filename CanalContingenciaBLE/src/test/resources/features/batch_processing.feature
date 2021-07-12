Feature: Process a File
  As a Business Line Banking user
  Process send to a Batch
  To execute my transaction

  Background:
    Given the user is logged into the application
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |

  @SuccessfulProcessing
  Scenario Outline: Successful Processing
    When the User validates and sends a file to be processed
      | originAccount   | transaction   | extension   | fileName   | delimiter   |
      | <originAccount> | <transaction> | <extension> | <fileName> | <delimiter> |

    Then he can display the correct delivery message with the execution number

    Examples:
      | originAccount | transaction             | extension | fileName                  | delimiter    |
      | 0111708724    | Planilla                | CSV       | PlanillaCorrecto.csv      | ,            |
      | 0111708724    | Planilla                | TXT       | PlanillaCorrecto.txt      | Punto y Coma |
      | 0111708724    | Internacionales         | CSV       | InternacionalCorrecto.csv | ,            |
      | 0111708724    | Internacionales         | TXT       | InternacionalCorrecto.txt | Pipe o Barra |
      | 0111708724    | Terceros Banistmo y ACH | CSV       | ACHCorrecto.csv           | ,            |
      | 0111708724    | Terceros Banistmo y ACH | TXT       | ACHCorrecto.txt           | Punto y Coma |
