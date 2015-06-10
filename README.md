# monitor-console
Modu³ odpowiedzialny za autoryzacje u¿ytkownika, rejestracje nowego oraz wyœwietlanie informacji odebranych z monitora niczym w znanej wszystkim komendzie "top".

## Budowanie i uruchomienie projektu:
`mvn clean install exec:java -Dexec.mainClass="monitor.console.view.MainWindow"`

## Instalacja
ant version >= 1.8.2

* `install.properties` - plik konfiguracyjny, mo¿na w nim ustawiæ: 

`app_dir` - katalog, gdzie ma zostaæ wypakowana aplikacja (domyœlnie: "/monitor-console")

`app_java_home` - œrodowisko jdk dla aplikacji (wymagana wersja jdk: **1.8**, domyœlnie: "C:/Program Files/Java/jdk1.8.0_45")

* po instalacji w katalogu `app_dir` pojawi siê skrypt do uruchomienia `start.bat`

## Mechanizm autoryzacji:
G³ówne okno aplikacji zosta³o stworzone w jêzyku Java z wykorzystaniem biblioteki `SWING`. Z tego poziomu aplikacji u¿ytkownik po podaniu zarejestrowanego wczeœniej w bazie danych has³a oraz loginu zostanie przeniesiony do systemu statystyk jaki zosta³‚ przypisany do jego profilu. 
Panel logowania zosta³ zabezpieczony przed przypadkow¹ prób¹ logowania - pola login i has³o s¹ wymagane, poza tym has³o nie mo¿e byæ króttsze ni¿ 8 znaków. U¿ytkownik zostanie poinformowany o nieudanej probie logowania za pomoca alertów wskazujacych mu przyczyne b³êdu.
W przypadku uzupe³nienia wymaganych pól i nacisciecia przycisku OK, aplikacja przesy³a dane poprzez format JSON i architekturê REST do monitora i oczekuje odpowiedzi. Istniej¹ 2 mo¿liwe reakcje monitora `LOGIN_OK`,`LOGIN_FAILED`; w zale¿noœci od nich u¿ytkownik przenoszony jest do statystyk lub zostaje poproszony o próbê ponownego logowania. 

Wyzwolenie przycisku New account powoduje otwarcie okna rejestracji nowego u¿ytkownika aplikacji. 
Zasada tworzenia nowego u¿ytkownika jest dok³adnie taka sama, jak podczas logowania. Po uzupe³nieniu pól formularza odpowiednimi wartoœciami (login musi byæ unikalny, has³o powinno mieæ minimum 8 znaków, pola zawieraj¹ce has³a powinny byæ identyczne oraz ¿adne z pól nie mo¿e byæ puste) wysy³any jest JSON z tymi informacjami, które zostaj¹ weryfikowane po stronie monitora. Ten odpowiada wartoœciami `REGISTATION_OK` lub `REGISTRATION_FAILED`. W celu realizacji tych funkcjonalnoœci zosta³y wykorzystane dok³adnie takie same jak wy¿ej mechanizmy programistyczne. 

## Konsola
Poprawne zalogowanie pozwala przejœæ do czêœci w³aœciwej aplikacji. Interfejs zosta³ tu podzielony na sekcjê ustawieñ i panel wyœwietlaj¹cy wyniki. 

* Sekcja ustawieñ

Sekcja ustawieñ zawiera przyciski opcji, które pozwalaj¹ na proste sterowanie aplikacj¹. Pierwsza jej czêœæ pozwala na wybór zasobu, którego pomiary bêd¹ wyœwietlane. Do dyspozycji pozostaje aktualne u¿ycie procesora, pamiêci operacyjnej RAM i obci¹¿enie ³¹cza sieciowego: osobno kana³u wysy³ania i pobierania.
Druga czêœæ to przyciski sortowania. U¿ytkownik mo¿e wybraæ kierunek sortowania (rosn¹co lub malej¹co), a tak¿e wybraæ informacje, wzglêdem których odbywaæ siê bêdzie sortowanie. Aplikacja pozwala sortowaæ wyniki pod wzglêdem `nazwy hosta`, jego `adresu IP` oraz `zasobu` aktualnie wybranego do wyœwietlenia.

* Panel wyników

Panel wyników prezentuje posortowane informacje, pobrane uprzednio z monitora. Jest to lista dziesiêciu najbardziej obci¹¿onych hostów. Dane zosta³y podzielone na 3 kolumny: nazwê hosta, jego adres IP i wartoœæ pomiaru wybranego zasobu. Zastosowany zosta³ tutaj mechanizm odœwie¿ania informacji, dziêki czemu nie zachodzi koniecznoœæ przewijania danych.


