# 🧪 Automated Tests for Saucedemo (Playwright + Java)

Projekt zawiera automatyczne testy E2E dla platformy **Saucedemo** (Swag Labs). Został stworzony przy użyciu nowoczesnego narzędzia **Microsoft Playwright** w języku Java, z pełną integracją z frameworkiem raportującym **Allure Report**.

## 🚀 Technologie i narzędzia
* **Java 24+** (z JDK)
* **Microsoft Playwright** (Java API)
* **JUnit 5** – framework testowy
* **Maven** – zarządzanie projektem i zależnościami
* **Allure Report** – generowanie interaktywnych raportów graficznych

## 📋 Wymagania wstępne
Przed uruchomieniem testów upewnij się, że masz zainstalowane:
1. **Java Development Kit (JDK)** – wersja minimum 24 lub nowsza.
2. **Apache Maven** – dodany do zmiennych środowiskowych systemowych.

## 🛠️ Jak uruchomić projekt lokalnie?

1. **Sklonuj repozytorium:**
   ```bash
   git clone <LINK_DO_TWOJEGO_REPOZYTORIUM>
   cd saucedemo-Test-Playright
   ```

2. **Uruchom testy:**
   Uruchomienie tej komendy pobierze potrzebne przeglądarki Playwright, wykona testy JUnit i przygotuje dane pod raport:
   ```bash
   mvn clean test
   ```

3. **Wygeneruj i wyświetl raport Allure:**
   Po zakończeniu testów wpisz poniższe polecenie, aby uruchomić lokalny serwer i automatycznie otworzyć raport w przeglądarce:
   ```bash
   mvn allure:serve
   ```

## 📊 Raportowanie (Allure)
Dzięki wtyczce `allure-maven` oraz agentowi `AspectJ Weaver`, raporty zawierają szczegółowe drzewo kroków testowych (`@Step`), statystyki pokrycia oraz czytelne metadane wykonania testów.
