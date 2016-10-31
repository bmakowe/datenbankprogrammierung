![![Hochschule Ravensburg-Weingarten]()](https://github.com/bmakowe/images/blob/master/hs-weingarten.gif)
# **Datenbankprogrammierung SS16** 

***

Dieses Repository dient dem Version Control für das vorlesungsbegleitende Projekt Datenbankprogrammierung an der HS-Weingarten.

##ÜBUNGSAUFGABE
Zu dieser Aufgabe finden Sie im Doz-Stud-Verzeichnis einige Dateien.
Erstellen Sie mit den downloadbaren SQL-Sktipten die entsprechenden Tabellen, wenn Sie Ihr
Projekt unter Oracle realisieren wollen, verwenden Sie die Datei „…_ora.sql“, wenn Sie mit
MySQL arbeiten wollen, verwenden Sie die entsprechend benannte Datei.
Jede der Teilaufgaben ist dem Dozenten vorzuführen und abnehmen zu lassen, bitte
bearbeiten Sie erst danach die jeweils nächste Teilaufgabe.

###1. Aufgabe: Suche passendes Automodell
Erstellen Sie ein Java-Programm für die Angestellten einer Autoverleihfirma, mit dem die
Mitarbeiter der Autoverleihfirma ein passendes Automodell suchen können.
Dazu kann der Benutzer einschränkende Angaben machen, z. B. die Art des Automodells
(LKW, Kombi, ...) im Klartext, die Zahl der Sitzplätze, die maximale Zuladung, den Preis pro
Tag usw. Der Benutzer kann dabei keine, einige oder alle Eigenschaften der gesuchten
Automodelle spezifizieren.
Das Programm soll dann tabellarisch die den Suchkriterien entsprechenden Automodelle
ausgeben.
Sie können hierfür auf ein von mir vorbereitetes Eclipse-Projekt „Autoleihe" zurückgreifen,
dürfen aber auch gerne ein völlig eigenständiges Programm erstellen.
Um die Tabellenstruktur besser erfassen zu können sollten Sie sich zuerst ein ER-Diagramm
mit dem Tool Ihrer Wahl erstellen (Visio, Bleistift, …) – dies ist ebenfalls Bestandteil der
Übung und wird ebenso bewertet.

###2. Aufgabe: DAO
Im Beispielprogramm ist der datenbankspezifische - und der SQL-Code auf viele Klassen
verteilt, es handelt sich hierbei um eine sehr unübersichtliche und unschöne Architektur.
Modellieren Sie die Klassen Auto, Automodell, etc. (nur die benötigten) in einem
Klassendiagramm.
Bauen Sie das Programm anschliessend so um, dass nicht mehr direkt mit ResultSets
gearbeitet wird, sondern mit Objekten der neu modellierten Klassen.
Ausserdem sollte statt direkten Zugriffen mit JDBC Hibernate verwendet werden.
Überlegen Sie sich vor dem Umbau, wie die neue Klassenstruktur aussehen soll, modellieren
Sie diese bevor Sie mit dem Programmieren beginnen, verwenden Sie hierzu Together oder
ein anderes UML-Tool (Omondo, etc.).
Lassen Sie sich Ihr Klassendiagramm vom Dozenten abnehmen, bevor Sie mit der
programmatischen Umsetzung beginnen und setzen anschließend das Modell um.

###3. Aufgabe: Eintragen einer Reservierung für ein Automodell
Erweitern Sie Ihr Programm so, dass es möglich ist, in der Datenbank der Autoverleih-Firma
eine Reservierung eintragen kann.
Dazu muss der Benutzer (Mitarbeiter der Verleihfirma) durch Angabe der Kunden-Nummer
erst den Kunden authentifizieren, d.h. nur für einen registrierten Kunden kann eine
Reservierung vorgenommen werden.
Danach markiert der Mitarbeiter ein Automodell in der tabellarischen Übersicht und gibt
einen Zeitraum an. Wenn in dem Wunschzeitraum wenigstens ein Auto des angegebenen
Automodells frei ist, soll die Reservierung in die entsprechende Tabelle eingetragen werden.
Achten Sie auf eine Programmierung, bei der sich auch zwei gleichzeitig stattfindende
Reservierungen verschiedener Kunden nicht stören (beispielsweise, weil 2 Mitarbeiter
gleichzeitig am System arbeiten). Eventuell müssen Sie dazu die Datenbankstruktur ändern
oder ganze Tabellen sperren.

####Hinweise
* Der Download beinhaltet ein vollständiges Eclipse 3.2 Projekt inklusiver der JDBCTreiber
für MySQL (Die für Oracle sind bereits vorinstalliert). Aktuell ist das Programm
auf den Zugriff auf eine MySQL-Db angepasst, das müssen Sie auf Oracle mit Ihrem
entsprechenden Benutzer abändern.
* Damit die Überprüfung der Kunden funktioniert, müssen Sie wenigstens zwei Kunden in
die Datenbank eintragen.
* Ändern Sie in meiner Programm-Vorgabe (wenn Sie diese benutzen) auf alle Fälle Ihren
Benutzernamen und das Passwort.
* Den Code für die Reservierung tragen Sie dann in der Klasse „Reservator“ ein.
* Die Modell-ID des ausgewählten Automodells, das reserviert werden soll, wird in meiner
actionPerformed Methode nur ausgegeben, Sie nutzen diese ID zur Reservierung.
* Für Autoart ist bereits eine exemplarische DTO und DAO Klasse implementiert, hier
können Sie sich ggf. etwas für die von Ihnen zu implementierenden Klassen abschauen
* Sie können die Benutzerschnittstelle auch textbasiert umsetzen. Alle geforderten
Funktionen sind dann sinngemäß umzusetzen. Fragen Sie im Zweifel nach.

### Version
1.0.0
