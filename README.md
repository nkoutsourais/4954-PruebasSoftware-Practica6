## 4954-PruebasSoftware-Practica5
### Practica 5
* Fecha de entrega: 28/10/2019
* Integrantes:
  * Neo Koutsourais


## Diagrama MasterMind

<p align="center">
  <img alt="" src="diagrama1.svg">
</p>

### PlantUML
 
 ```PlantUML
@startuml

class Draughts {
+ play()
}
Draughts *-down-> Logic
Draughts *-down-> View

interface View {
+ interact(Controller)
}

class ConsoleView #orange {
+ interact(Controller)
+ visit(StartController startController):void 
+ visit(PlayController playController):void 
+ visit(ResumeController resumeController):void 
}

View ()-- ConsoleView
ConsoleView ..> StartController
ConsoleView ..> PlayController
ConsoleView ..> ResumeController

class StartView {
}

class PlayView {
}

class ResumeView {
}

ConsoleView *-down-> StartView
ConsoleView *-down-> PlayView
ConsoleView *-down-> ResumeView

StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView ..> SquareView
SquareView ..> PieceView

View ..> Controller
AcceptController <|-down- View

class Logic{
+ getController()
}

Logic *--> State
Logic *--> Game
Logic *-down-> AcceptController

abstract class Controller{
  + {abstract} accept(AcceptController):void 
}

interface AcceptController{
  + visit(StartController startController):void 
  + visit(PlayController playController):void 
  + visit(ResumeController resumeController):void 
}

Controller ..> AcceptController
Controller <|-down- StartController
Controller <|-down- PlayController
Controller <|-down- ResumeController
Controller o--> Game

class StartController{
 + start():void
}

class MoveController{
  + move(Coordinate... coordinates):Error 
}

class CancelController{
  + cancel():void
}

class ResumeController{
 + resume(boolean newGame):void
}

class PlayController{
  + move(Coordinate... coordinates):Error
  + getPiece(Coordinate origin):Piece
  + getTurn():Turn
  + cancel():void
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
  + move(Coordinate... coordinates):Error
  + getPiece(Coordinate origin):Piece
  + isFinished():boolean
  + isWinner():boolean
  + isTie():boolean
  + reset():void
}
Game *-down-> Board
Game *-down-> Turn
Game ..> Error

class Board{
  + move(Coordinate... coordinates):Error
  + getPiece(Coordinate origin):Piece
  + isMovementsAllowed():boolean
  + isMovementsAllowed(Color):boolean 
  + Contains(Color):boolean
}
Board *-down-> "8x8" Square
Board *-down-> "1..2x12" Piece
Board ..> Error

class Square{
  + getPiece():Piece
}
Square  --> "0..1" Piece

abstract class Piece{
  + getColor():Color 
}
Piece <|-down- Peon
Piece <|-down- Dama
Piece *--> Color 

class Peon{
}

class Dama{
}

enum Color{
    WHITE
    BLACK
}

class Turn{
  + next():void
  + getColor():Color 
}
Turn *--> Color

class State{
  + next():void
  + reset():void
  + getValueState():StateValue
}
State *--> StateValue

enum StateValue{
  INITIAL
  PLAY
  FINAL
  EXIT
}

enum Error{
  DISTANCE, 
	OCCUPED, 
	NO_PIECE, 
	COORDINATES, 
	BAD_MOVE, 
	CAPTURE_EXCED, 
	NO_TURN
}

@enduml

 ```