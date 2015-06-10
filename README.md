# monitor-console
Modul odpowiedzialny za autoryzacje uzytkonika, rejestracje nowego oraz wyswietlanie informacji odebranych z monitora niczym w znanej wszystkim komendzie "top"

instrukacja uruchomienia projektu:
mvn clean install 
mvn exec:java -Dexec.mainClass="monitor.console.view.MainWindow"


Opis mechanizmu autoryzacji:

Gowne okno aplikacji zostało stworzone w języku Java z wykorzystaniem biblioteki SWING. Z tego poziomu aplikacji użytkownik po podaniu zarejestrowanego wcześniej w bazie danych hasła oraz loginu zostanie przeniesiony do systemu statystyk jaki został przypisany do jego profilu. 
Panel logowania został zabezpieczony przed przypadkową próbą logowania - pola login i hasło są wymagane, poza tym hasło nie może być krótsze niż 8 znaków. Użytkownik zostanie poinformowany o nieudanej probie logowania za pomoca alertow wskazujacych mu przyczyne bledu.
W przypadku uzupełnienia wymaganych poł i nacisciecia przycisku OK, aplikacja przesyła dane poprzez format JSON i architekturę REST do monitora i oczekuje odpowiedzi. Istnieją 2 możliwe reakcje monitora LOGIN_OK,LOGIN_FAILED; w zależności od nich użytkownik przenoszony jest do statystyk lub zostaje poproszony o próbę ponownego logowania. 

Wyzwolenie przycisku New account powoduje otwarcie okna rejestracji nowego użytkownika aplikacji. 
Zasada tworzenia nowego użytkownika jest dokładnie taka sama, jak podczas logowania. Po uzupełnieniu pól formularza odpowiednimi wartościami (login musi być unikalny, hasło powinno mieć minimum 8 znaków, pola zawierające hasła powinny być identyczne oraz żadne z pól nie może być puste) wysyłany jest JSON z tymi informacjami, które zostają weryfikowane po stronie monitora. Ten odpowiada wartościami REGISTATION_OK lub REGISTRATION_FAILED. W celu realizacji tych funkcjonalności  zostały wykorzystane dokładnie takie same jak wyżej mechanizmy programistyczne. 


