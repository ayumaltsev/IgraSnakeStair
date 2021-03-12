# IgraSnakeStair
1) I have not used Lombok, although the code becomes more readable with it. Lombok was not listed in the requirements.

2) Run tests:
    (IntelliJIdea) highlight the project name -> right mouse button -> Run All Tests
   or
    (command line) mvn test -Dtest=com.epam.PlayerTest


3) For a visual representation of the game, a computer game with itself has been implemented
   (of course, there are no snakes and ladders). The log is written directly to the console.

    Set app.testFlag=false (application.properties). Run the MainApp class: mvn exec:java -Dexec.mainClass=com.epam.MainApp
