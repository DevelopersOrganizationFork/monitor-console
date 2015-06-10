# monitor-console
Modu� odpowiedzialny za autoryzacje u�ytkownika, rejestracje nowego oraz wy�wietlanie informacji odebranych z monitora niczym w znanej wszystkim komendzie "top".

## Budowanie i uruchomienie projektu:
`mvn clean install exec:java -Dexec.mainClass="monitor.console.view.MainWindow"`

## Instalacja
ant version >= 1.8.2

* `install.properties` - plik konfiguracyjny, mo�na w nim ustawi�: 

`app_dir` - katalog, gdzie ma zosta� wypakowana aplikacja (domy�lnie: "/monitor-console")

`app_java_home` - �rodowisko jdk dla aplikacji (wymagana wersja jdk: **1.8**, domy�lnie: "C:/Program Files/Java/jdk1.8.0_45")

* po instalacji w katalogu `app_dir` pojawi si� skrypt do uruchomienia `start.bat`

## Mechanizm autoryzacji:
G��wne okno aplikacji zosta�o stworzone w j�zyku Java z wykorzystaniem biblioteki `SWING`. Z tego poziomu aplikacji u�ytkownik po podaniu zarejestrowanego wcze�niej w bazie danych has�a oraz loginu zostanie przeniesiony do systemu statystyk jaki zosta�� przypisany do jego profilu. 
Panel logowania zosta� zabezpieczony przed przypadkow� pr�b� logowania - pola login i has�o s� wymagane, poza tym has�o nie mo�e by� kr�ttsze ni� 8 znak�w. U�ytkownik zostanie poinformowany o nieudanej probie logowania za pomoca alert�w wskazujacych mu przyczyne b��du.
W przypadku uzupe�nienia wymaganych p�l i nacisciecia przycisku OK, aplikacja przesy�a dane poprzez format JSON i architektur� REST do monitora i oczekuje odpowiedzi. Istniej� 2 mo�liwe reakcje monitora `LOGIN_OK`,`LOGIN_FAILED`; w zale�no�ci od nich u�ytkownik przenoszony jest do statystyk lub zostaje poproszony o pr�b� ponownego logowania. 

Wyzwolenie przycisku New account powoduje otwarcie okna rejestracji nowego u�ytkownika aplikacji. 
Zasada tworzenia nowego u�ytkownika jest dok�adnie taka sama, jak podczas logowania. Po uzupe�nieniu p�l formularza odpowiednimi warto�ciami (login musi by� unikalny, has�o powinno mie� minimum 8 znak�w, pola zawieraj�ce has�a powinny by� identyczne oraz �adne z p�l nie mo�e by� puste) wysy�any jest JSON z tymi informacjami, kt�re zostaj� weryfikowane po stronie monitora. Ten odpowiada warto�ciami `REGISTATION_OK` lub `REGISTRATION_FAILED`. W celu realizacji tych funkcjonalno�ci zosta�y wykorzystane dok�adnie takie same jak wy�ej mechanizmy programistyczne. 

## Konsola
Poprawne zalogowanie pozwala przej�� do cz�ci w�a�ciwej aplikacji. Interfejs zosta� tu podzielony na sekcj� ustawie� i panel wy�wietlaj�cy wyniki. 

* Sekcja ustawie�

Sekcja ustawie� zawiera przyciski opcji, kt�re pozwalaj� na proste sterowanie aplikacj�. Pierwsza jej cz�� pozwala na wyb�r zasobu, kt�rego pomiary b�d� wy�wietlane. Do dyspozycji pozostaje aktualne u�ycie procesora, pami�ci operacyjnej RAM i obci��enie ��cza sieciowego: osobno kana�u wysy�ania i pobierania.
Druga cz�� to przyciski sortowania. U�ytkownik mo�e wybra� kierunek sortowania (rosn�co lub malej�co), a tak�e wybra� informacje, wzgl�dem kt�rych odbywa� si� b�dzie sortowanie. Aplikacja pozwala sortowa� wyniki pod wzgl�dem `nazwy hosta`, jego `adresu IP` oraz `zasobu` aktualnie wybranego do wy�wietlenia.

* Panel wynik�w

Panel wynik�w prezentuje posortowane informacje, pobrane uprzednio z monitora. Jest to lista dziesi�ciu najbardziej obci��onych host�w. Dane zosta�y podzielone na 3 kolumny: nazw� hosta, jego adres IP i warto�� pomiaru wybranego zasobu. Zastosowany zosta� tutaj mechanizm od�wie�ania informacji, dzi�ki czemu nie zachodzi konieczno�� przewijania danych.


