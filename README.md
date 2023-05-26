# RoadBuddies
API java / spring boot de covoiturage

### Cloner le référentiel : 
Sur l'autre PC, clonez le référentiel Git contenant votre projet Spring Boot à l'aide de la commande git clone <URL du référentiel>. Assurez-vous d'avoir Git installé sur l'ordinateur.


### Installer Java et Maven : 
Assurez-vous que Java et Maven sont installés sur l'autre PC. Vous pouvez vérifier cela en exécutant les commandes java -version et mvn -version dans le terminal. Si Java ou Maven n'est pas installé, vous devrez les installer en fonction de votre système d'exploitation.

### Importer le projet dans votre IDE :
Ouvrez votre IDE préféré (comme Eclipse, IntelliJ IDEA ou VS Code) sur l'autre PC et importez le projet en tant que projet Maven existant. Dans IntelliJ IDEA, vous pouvez sélectionner "Import Project" depuis l'écran de démarrage et choisir le répertoire du projet. Dans Eclipse, vous pouvez sélectionner "Import" dans le menu "File" et choisir "Existing Maven Projects".

### Construire le projet : 
Une fois le projet importé dans votre IDE, exécutez la commande de construction Maven pour télécharger les dépendances et compiler le projet. Dans votre IDE, vous devriez avoir une option pour exécuter la commande Maven "clean install" ou "build". Cela construira votre projet et générera l'artifact (fichier JAR) dans le répertoire target/.

### Exécuter le projet : 
Une fois que la construction est terminée, vous pouvez exécuter votre application Spring Boot à partir de l'IDE. Recherchez la classe principale du projet (généralement avec une annotation @SpringBootApplication) et exécutez-la en tant qu'application Java. L'application sera lancée et accessible via l'URL spécifiée dans votre code.

### Créer la base de données : 
Mettre en place une base de données (Choisissez le nom que vous souhaitez). Assurez-vous que les fichiers de configuration nécessaires, tels que application.properties ou application.yml, sont présents dans le répertoire du projet. Mettez y les information : 


####Configuration de la base de données MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_la_base_de_donnees
spring.datasource.username=utilisateur
spring.datasource.password=mot_de_passe
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#### Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

Hibernate va s'occuper de mettre en place les tables et colonnes des entités par rapport aux models qui se trouveront dans l'application. 

