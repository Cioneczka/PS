# Kalkulator z zapisem do bazy danych

**Główny katalog:**  

- `.idea` – ustawienia projektu w IntelliJ IDEA  
- `out` – katalog z kompilowanymi plikami  
- `src` – folder z kodem źródłowym  
  - `Calculator` – moduł kalkulatora  
  - `DatabaseManager` – moduł zarządzania bazą danych  
- `Main.java` – główny plik aplikacji  
- `.gitignore` – plik ignorujący określone pliki w Git  
- `java.iml` – plik projektu IntelliJ IDEA  
- `External Libraries` – zewnętrzne biblioteki używane w projekcie  
- `Scratches and Consoles` – katalog na tymczasowe notatki i testy

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
- **Adres repozytorium:** (https://github.com/Cioneczka/PS/) 
- **Link do działającej aplikacji:** (tu wstaw link do demo, jeśli jest dostępny)  

---

Projekt wykorzystuje wzorzec **MVC (Model-View-Controller)** w uproszczonej formie:  
- **Model:** Klasa `DatabaseManager` — obsługuje zapisywanie danych w bazie.  
- **View:** Klasa `Calculator` — interfejs użytkownika z przyciskami i polem wyświetlania.  
- **Controller:** Logika działania kalkulatora obsługująca zdarzenia kliknięć przycisków i zarządzająca komunikacją między modelem a widokiem.  

---

##  Wymagania

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

###  Ograniczenia (sprzęt, oprogramowanie)

- Wymaga zainstalowanej bazy danych Oracle i dostępnego serwera lokalnego lub zdalnego  
- Potrzebna jest zainstalowana i skonfigurowana Java Runtime Environment (JRE) w wersji 8 lub wyższej
- Aplikacja działa na desktopach z systemem Windows/Linux/macOS obsługującym Javę  
- Obecna implementacja nie obsługuje zaawansowanych operacji matematycznych ani walidacji błędów  

### Diagram przypadków
![image](https://github.com/user-attachments/assets/b823cffb-1930-4ed8-8822-f97c647c1cb2)

---

### Scenariusze przypadków użycia

| **Atrybut**                 | **Opis**                                                                                                             |
| --------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| **Nazwa**                   | Oblicz wynik                                                                                                         |
| **Aktor**                   | Użytkownik                                                                                                           |
| **Cel**                     | Obliczenie wyniku działania matematycznego                                                                           |
| **Założenia**               | - Aplikacja działa poprawnie<br>- Wprowadzone dane są poprawne                                                       |
| **Scenariusz główny**       | 1. Użytkownik wpisuje liczby i operator<br>2. Klika `=`<br>3. Program liczy<br>4. Wynik pojawia się w polu tekstowym |
| **Scenariusz alternatywny** | Dzielnie przez zero → wyświetlany komunikat „Nie można dzielić przez zero”                                           |
| **Wynik końcowy**           | Wynik działania lub komunikat o błędzie                                                                              |

---

| **Atrybut**                 | **Opis**                                                                                                    |
| --------------------------- | ----------------------------------------------------------------------------------------------------------- |
| **Nazwa**                   | Zapisz wynik do bazy                                                                                        |
| **Aktor**                   | Aplikacja                                                                                                   |
| **Cel**                     | Zapisanie równania i wyniku do bazy danych                                                                  |
| **Założenia**               | - Połączenie z bazą działa<br>- Tabela `calculations` istnieje                                              |
| **Scenariusz główny**       | 1. Kliknięcie `=` oblicza wynik<br>2. Łączy się z bazą danych<br>3. Wysyła `INSERT`<br>4. Zamyka połączenie |
| **Scenariusz alternatywny** | Brak połączenia → komunikat „Nie można zapisać danych”                                                      |
| **Wynik końcowy**           | Wynik i działanie są zapisane do bazy lub pojawia się błąd                                                  |

### Baza danych 

![image](https://github.com/user-attachments/assets/3a18a1eb-ff84-410b-b8ed-d16c8d101d92)

### Diagram sekwencji - obliczanie i zapis wyniku

![image](https://github.com/user-attachments/assets/28389585-bc80-452b-8090-bf843114ad8b)

### Diagram aktywności

![image](https://github.com/user-attachments/assets/650de2dd-cbf3-4fe7-8b1f-3e6ad3fd4db1)

### Diagram stanóww

![image](https://github.com/user-attachments/assets/e86fd42d-3bd4-46e4-98c2-22612715faa6)

## Dokumentacja bezpieczeństwa

### - Bezpieczeństwo danych podczas składowania
Uwierzytelnianie użytkownika bazy danych
Dostęp do bazy danych Oracle możliwy jest wyłącznie po podaniu prawidłowej nazwy użytkownika oraz hasła. W środowisku produkcyjnym nie używa się konta SYS, tylko tworzy się dedykowanego użytkownika z ograniczonymi uprawnieniami (np. tylko INSERT i SELECT na jednej tabeli).

### - Ograniczenia uprawnień (principle of least privilege)
Użytkownik bazy danych posiada tylko minimalny zestaw uprawnień niezbędnych do zapisu danych do tabeli calculations. Nie ma możliwości wykonywania operacji administracyjnych, takich jak DROP, ALTER, czy DELETE poza kontekstem aplikacyjnym.

### -Szyfrowanie danych w bazie (Transparent Data Encryption - TDE)
Oracle Database wspiera Transparent Data Encryption (TDE), które może być użyte do automatycznego szyfrowania danych przechowywanych w tabelach bez konieczności zmian w kodzie aplikacji.

### -Bezpieczeństwo aplikacji
Obsługa wyjątków i walidacja danych wejściowych
Dane wprowadzane przez użytkownika są walidowane przed zapisem do bazy, co zapobiega np. wstrzyknięciom SQL (SQL Injection). Wszystkie zapytania są wykonywane z wykorzystaniem PreparedStatement, co neutralizuje możliwość wstrzyknięcia kodu.

### -Rejestrowanie operacji
Aplikacja może zostać rozszerzona o funkcjonalność logowania operacji wraz ze znacznikiem czasu, co pozwoli na późniejszą analizę bezpieczeństwa i wykrywanie nieprawidłowych działań.

### Zastosowane rozwiązania zwiększające dostępność (Deklaracja zgodności z WCAG)
Aplikacja Kalkulator została zaprojektowana z uwzględnieniem podstawowych zasad dostępności zgodnych z wytycznymi WCAG (Web Content Accessibility Guidelines) na poziomie AA, z naciskiem na wsparcie dla osób z niepełnosprawnościami wzroku, słuchu oraz ograniczeniami ruchowymi.

🔹 Zgodność z WCAG
Perceivable (Postrzegalność)

Zastosowano duże i czytelne przyciski o wysokim kontraście (np. czarny tekst na jasnym tle).

Pola tekstowe (np. wyświetlacz) mają odpowiednią wielkość czcionki oraz jasne oznaczenia.

Operable (Funkcjonalność)

Wszystkie funkcje aplikacji mogą być obsługiwane za pomocą klawiatury (np. wprowadzanie liczb i operacji).

Brak elementów migających lub dynamicznych, które mogłyby powodować problemy dla użytkowników z epilepsją.

Understandable (Zrozumiałość)

Interfejs jest prosty i intuicyjny — przyciski są jednoznacznie oznaczone (np. „+”, „=”, „C”).

Komunikaty (np. wynik działania, błędy) są zwięzłe i zrozumiałe.

Robust (Solidność)

Aplikacja napisana w Javie z wykorzystaniem Swinga działa stabilnie i przewidywalnie niezależnie od systemu operacyjnego.

🔹 Wsparcie dla osób z niepełnosprawnościami
Wzrok

W planach jest implementacja wsparcia dla screen readerów (czytników ekranu) poprzez dostosowanie AccessibleContext w komponentach Swing.

Możliwość powiększenia interfejsu (np. przez skalowanie GUI na podstawie ustawień systemowych).

Słuch

Aplikacja nie wymaga interakcji dźwiękowej ani nie emituje sygnałów dźwiękowych, więc brak słuchu nie wpływa na jej użytkowanie.

Koordynacja ruchowa

Duże przyciski i możliwość obsługi klawiaturą wspierają użytkowników z ograniczoną precyzją ruchów.











