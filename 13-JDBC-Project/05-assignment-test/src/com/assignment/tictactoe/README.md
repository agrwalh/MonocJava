# Tic Tac Toe Game (Java - Facade Design Pattern)

This is a console-based Tic Tac Toe game developed in Java using Object-Oriented Programming concepts and the Facade Design Pattern.

## Features
- Human vs Human
- Human vs Computer
- Input validation
- Custom exceptions for invalid moves
- Win and draw detection

## Design
The project uses the Facade Pattern where the Main class interacts only with GameFacade.

GameFacade manages:
- Game setup
- Player creation
- Game flow

Other classes:
- Game → handles game logic
- Board → maintains board state
- Player → abstract class
- HumanPlayer / ComputerPlayer → different player types
- Exceptions → handle invalid input and moves

## How to Run
1. Open project in Eclipse
2. Run Main.java

## Class Diagram
## Class Diagram
![Class Diagram](https://raw.githubusercontent.com/agrwalh/MonocJava/main/05-assignment-test/src/com/assignment/tictactoe/CD_TIC_TAC_TOE.png)

