Feature: 001 Buscador Haceb

  Scenario Outline:<Escenario>
    Given que me encuentro en la pagina de Haceb con la url <URL>
    When busco el producto en el buscador
    Then podre ver el producto deseado

    Examples:
      | Escenario                                       | URL                    |
      | Buscar producto en el buscador de Haceb exitoso | https://www.haceb.com/ |
