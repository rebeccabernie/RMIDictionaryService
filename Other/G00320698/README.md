## ReadMe - Distributed Systems Project: An Asynchronous RMI Dictionary Service  

> Student: Rebecca Kane, G00320698  
> Module: Distributed Systems
> Lecturer: Patrick Mannion

This application allows the user to enter a word, the definition of which is then displayed back to the user. The project uses Tomcat 7.  

Contents:  
dictionary-service.jar - This file sets up the server. Run using 
java –cp ./dictionary-service.jar ie.gmit.sw.ServiceSetup in the command line.  
job-server.war - A Web Application Archive Containing the the "WebContent" files.  
README - Brief description of what the project is and how to run it.  

GitHub Repository Clone Link: https://github.com/rebeccabernie/RMIDictionaryService.git

### Running the Application  

1. To run the application, import the project as a Dynamic Web Project into Eclipse JEE.  
2. Run the **DictionaryServiceSetup.java** file as a Java Application.  
3. When "Server connected." appears in the Eclipse console, select the **homepage.jsp** file.  
4. Run this file on the server, a browser window should open in Eclipse after a few seconds.  
5. In the opened page, type a word from the dictionary.txt file into the input box and press "Go!".  
6. The definition of the word will be displayed back to you. If the word is not contained in the dictionary, "Word not found! Try another." will be shown instead of a definition.  
7. To check another definition, simply repeat the process. There is no need to re-run or refresh the page.  
