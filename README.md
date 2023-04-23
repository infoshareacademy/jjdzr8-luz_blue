# JJDZR8 Luz_Blue
Jeśli nie masz pliku JAR, możesz skompilować swoją aplikację, aby uzyskać plik JAR. Aby skompilować aplikację w Maven, należy wykonać następujące kroki:
1.	W terminalu przejdź do katalogu, w którym znajduje się plik pom.xml Twojego projektu.
2.	Uruchom polecenie mvn package, które skompiluje kod i utworzy plik JAR w katalogu target.
3.	Po zakończeniu procesu kompilacji powinieneś zobaczyć plik JAR w katalogu target.
4.	Zaktualizuj plik Dockerfile, aby skopiować plik JAR do katalogu roboczego w obrazie Dockerowym, korzystając z następującego polecenia:

Oto kroki, które należy wykonać, aby przygotować obraz Dockerowy i uruchomić kontener z aplikacją webową:
docker build -t myapp

docker run -p 8090:8081 myapp:latest

5.	Aplikacja powinna teraz być dostępna na porcie 8080 na lokalnym komputerze. Można otworzyć przeglądarkę i przejść do adresu http://localhost:8080, 