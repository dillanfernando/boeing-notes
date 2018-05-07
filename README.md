# boeing-notes
Take home assignment for Boeing Research Labs

# Run Instrustions
There are two ways to run the project. 
1) The easiest way is to use the boeing-notes.war file in the /WAR_File folder. 
  - Just copy the war file to the webapps folder (Tested in Tomcat 8.5.31)
  - Start tomcat
  - Point your browser to  http://localhost:8080/boeing-notes/index.html

2) The other way to run the application is to run the app as spring-boot application
  - Checkout this branch into spring boot app container
  - All the angular file are compiled and placed in the proper location.
  - Just point the browser to  http://localhost:8080/boeing-notes/index.html
  
  # Test
  I've created unit tests for the Java Rest controller. No TypeScript unit tests are done
  
  # Angular Components.
  The angular project is locates the boeing-notes-angular repository
  
