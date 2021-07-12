Feature: Validate a Batch
  As a Business Line Banking user
  I want to validate a batch
  To verify its structure

  Background:
    Given the user is logged into the application
      | userName       | password  |
      | USUARIOPRUEBA1 | Cert123## |

  @UploadSuccessfulFile
  Scenario Outline: Upload successful file
    When the User uploads the correct file
      | originAccount   | transaction   | extension   | fileName   | delimiter   |
      | <originAccount> | <transaction> | <extension> | <fileName> | <delimiter> |
    Then will verify that the status of the batch is Validado

    Examples:
      | originAccount | transaction             | extension | fileName                  | delimiter    |
      | 0111708724    | Planilla                | CSV       | PlanillaCorrecto.csv      | ,            |
      | 0111708724    | Planilla                | TXT       | PlanillaCorrecto.txt      | Punto y Coma |
      | 0111708724    | Internacionales         | CSV       | InternacionalCorrecto.csv | ,            |
      | 0111708724    | Internacionales         | TXT       | InternacionalCorrecto.txt | Pipe o Barra |
      | 0111708724    | Terceros Banistmo y ACH | CSV       | ACHCorrecto.csv           | ,            |
      | 0111708724    | Terceros Banistmo y ACH | TXT       | ACHCorrecto.txt           | Punto y Coma |

  @UploadIncorrectFile
  Scenario Outline: Upload incorrect file
    When the User uploads the incorect file
      | originAccount   | transaction   | extension   | fileName   | delimiter   |
      | <originAccount> | <transaction> | <extension> | <fileName> | <delimiter> |

    Then will verify that the status of the batch is Rechazado por Validación

    Examples:
      | originAccount | transaction             | extension | fileName                    | delimiter    |
      | 0111708724    | Planilla                | CSV       | PlanillaIncorrecto.csv      | ,            |
      | 0111708724    | Planilla                | TXT       | PlanillaIncorrecto.txt      | Punto y Coma |
      | 0111708724    | Internacionales         | CSV       | InternacionalIncorrecto.csv | ,            |
      | 0111708724    | Internacionales         | TXT       | InternacionalIncorrecto.txt | Pipe o Barra |
      | 0111708724    | Terceros Banistmo y ACH | CSV       | ACHIncorrecto.csv           | ,            |
      | 0111708724    | Terceros Banistmo y ACH | TXT       | ACHIncorrecto.txt           | Punto y Coma |
