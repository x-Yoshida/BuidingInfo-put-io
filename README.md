![example workflow](https://github.com/x-Yoshida/BuildingInfo-put-io/actions/workflows/maven.yml/badge.svg)

# BuidingInfo-put-io
Aplikacja dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

## Struktura danych

* Lokacja to budynek, poziom lub pomieszczenie
* Budynek może składać się z poziomów a te z pomieszczeń
* Każda lokalizacja jest charakteryzowana przez:
  - id – unikalny identyfikator
  - name – opcjonalna nazwa lokalizacji
* Pomieszczenie dodatkowo jest charakteryzowane przez:
  - area = powierzchnia w m^2
  - cube = kubatura pomieszczenia w m^3
  - heating = poziom zużycia energii ogrzewania (float)
  - light – łączna moc oświetlenia

## Odnośnik do rejestru sprintu
[Rejestr sprintu #1](https://docs.google.com/spreadsheets/d/1vD5kCNpu1AaS7Yg6SuydPlxsmSxl1GRFZ1s5OZPF3UI/edit?usp=sharing)

## Odnośnik do rejestru produktu
[Rejestr produktu](https://trello.com/b/QdiDMirc/rejestr-produktu)

## Dokumentacja API

* [POST]/building/add

Przykładowy plik wejściowy w formacie json
```
{
  "type": "budynek",
  "id": 1,
  "nazwa": "Blok",
  "poziomy": [
    {
      "type": "poziom",
      "id": 10,
      "nazwa": "Parter",
      "pomieszczenia": [
        {
          "type": "pomieszczenie",
          "id": 101,
          "powierzchnia": 20,
          "kubatura": 60
        }
      ]
    },
    {
      "type": "poziom",
      "id": 11,
      "nazwa": "Drugie piętro",
      "pomieszczenia": [
        {
          "type": "pomieszczenie",
          "id": 111,
          "powierzchnia": 25,
          "kubatura": 70
        },
        {
          "type": "pomieszczenie",
          "id": 112,
          "powierzchnia": 30,
          "kubatura": 80
        }
      ]
    }
  ]
}

```
Przykładowe wywołanie funkcji zwracającą powierzchnie dla poziomu o id 11 w budynku o id 1

* [GET]/building/get_powierzchnia/1/11

Response:
```
{"powierzchnia":55}
```
  
