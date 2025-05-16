# Kalkulator z zapisem do bazy danych

**Nazwa projektu:** Kalkulator z zapisem do bazy danych  
**Skrót:** CalcDB  
**Autorzy:** Łukasz Trzcionka, Marcel Smarczyk

---

- **Kalkulator** — aplikacja umożliwiająca wykonywanie podstawowych operacji matematycznych.  
- **Równanie** — wyrażenie matematyczne, np. `3 + 5`.  
- **Operator** — symbol matematyczny oznaczający działanie, np. `+`, `-`, `*`, `/`.  
- **Baza danych** — system przechowujący dane, w tym przypadku Oracle DB, w której zapisywane są wyniki kalkulacji.  

---

- **Cel:** Stworzenie prostego kalkulatora z graficznym interfejsem użytkownika, który umożliwia wykonywanie działań arytmetycznych oraz zapis wyników do bazy danych Oracle.  
- **Zakres:**  
  - Obsługa podstawowych operacji: dodawanie, odejmowanie, mnożenie, dzielenie  
  - Graficzny interfejs użytkownika (Java Swing)  
  - Zapis wykonywanych działań i wyników w bazie danych  
- **Odbiorca docelowy:** Studenci i osoby uczące się podstaw programowania w Javie i baz danych.  
- **Adres repozytorium:** [https://github.com/TwojLogin/CalcDB](https://github.com/TwojLogin/CalcDB)  
- **Link do działającej aplikacji:** (tu wstaw link do demo, jeśli jest dostępny)  

---

Projekt wykorzystuje wzorzec **MVC (Model-View-Controller)** w uproszczonej formie:  
- **Model:** Klasa `DatabaseManager` — obsługuje zapisywanie danych w bazie.  
- **View:** Klasa `Calculator` — interfejs użytkownika z przyciskami i polem wyświetlania.  
- **Controller:** Logika działania kalkulatora obsługująca zdarzenia kliknięć przycisków i zarządzająca komunikacją między modelem a widokiem.  

---

## e. Wymagania

### i. Wymagania funkcjonalne

- Umożliwienie wprowadzania liczb i podstawowych działań arytmetycznych  
- Wyświetlanie wyniku działania na ekranie  
- Możliwość czyszczenia aktualnego działania  
- Zapis każdej kalkulacji (równanie, operator, wynik) w bazie danych  

### ii. Wymagania niefunkcjonalne

- Aplikacja powinna działać na systemach z zainstalowaną Javą 8 lub nowszą  
- Interfejs użytkownika powinien być intuicyjny i responsywny  
- Zapisywanie danych do bazy powinno odbywać się asynchronicznie (w przyszłości)  

---

## f. Ograniczenia (sprzęt, oprogramowanie)

- Wymaga zainstalowanej bazy danych Oracle i dostępnego serwera lokalnego lub zdalnego  
- Potrzebna jest zainstalowana i skonfigurowana Java Runtime Environment (JRE) w wersji 8 lub wyższej  
- Aplikacja działa na desktopach z systemem Windows/Linux/macOS obsługującym Javę  
- Obecna implementacja nie obsługuje zaawansowanych operacji matematycznych ani walidacji błędów  
