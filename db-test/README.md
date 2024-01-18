## Problem z importem bazy
Znany jest problem z importem dumpa, który wynika z ustawień gita, dlatego aby wszystko wykonało się prawidłowo należy
przejść do pliku ./script/import-database.sh i upewnić się że Line Separator jest ustawiony na "LF" (prawy dolny róg okna intellij).

## Uruchomienie lokalnej bazy danych
1. Przejdź w konsoli do folderu w którym znajduje się tak instrukcja.
2. Uruchom polecenie "docker-compose up -d --build"
3. W przeglądarce możesz podejrzeć aktualne dane - udaj się pod adres http://localhost:8080/?server=db&username=mspwUser&db=mspwTest

## Dane do logowania w aplikacji adminer:
* serwer: db
* uzytkownik: mspwUser
* hasło: wcy19il1s0
* baza danych: mspwTest