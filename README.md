# BMS-Chaber
 BMS-Chaber: ang. BMS - Battlefield Management System - Chaber. Jest innowacyjnym systemem wsparcia dowodzenia, działań wojsk i łączności. 
 

Struktura Projektu wygląda następująco:
![ProjectStructure.jpg](docs%2FProjectStructure.jpg)

Opis poszczególnych katalogów:
+ mspw_backend
  + model     - klasy reprezentujące modele danych w bazie
  + service   - logika biznesowa i serwisy (metody obsługujące dany komponent)
  + utils     - klasy narzędziowe i pomocnicze
+ mspw_frontend
  + controller-  klasy kontrolerów JavaFX
  + model     - klasy reprezentujące modele danych na froncie (co przyjmujemy z backendu oraz co chcemy przesłać)
  + service   - logika obsługi pól/walidacja i serwisy (wszelkie metody do tworzenia, mapowania i przetwarzania obiektów)
  + util      - klasy narzędziowe i pomocnicze
  + view      - pliki graficzne FXML (jeśli potrzebne)
  + Main      - plik uruchomieniowy