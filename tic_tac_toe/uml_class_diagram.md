# Tic Tac Toe - UML Class Diagram

```mermaid
classDiagram
    %% Interfaces
    class Player {
        <<interface>>
        +proposeMove(Board) Move
        +getPlayerName() String
        +getPlayerSymbol() Character
    }

    class MoveStratergy {
        <<interface>>
        +proposeNextMove(Board) Move
    }

    class WinStratergy {
        <<interface>>
        +isWinning(Board, Character) boolean
    }

    %% Classes
    class Game {
        -Board gameBoard
        -Player player1
        -Player player2
        -Deque~Player~ turn
        -boolean gameEnded
        -WinStratergy winStratergy
        +startNewGame(int, Player, Player, WinStratergy) void
        +play() void
        -createNewBoard(int, WinStratergy) void
        -initlizePlayers(Player, Player) void
        -initlizePlayerTurn() void
    }

    class Board {
        -int size
        -Character[][] board
        -int freeSpaces
        +Board(int)
        +isValidMove(Move) boolean
        +isMoveOnBoard(Move) boolean
        -isSpaceEmpty(Move) boolean
        +placeSymbolAt(Move, char) void
        +isBoardFull() boolean
        +getSize() int
        +getCell(int, int) Character
    }

    class Move {
        -int r
        -int c
        +Move(int, int)
        +getR() int
        +getC() int
    }

    class HumanPlayer {
        -String playerName
        -Character symbol
        -MoveStratergy moveStratergy
        +HumanPlayer(String, char, MoveStratergy)
        +proposeMove(Board) Move
        +getPlayerName() String
        +getPlayerSymbol() Character
    }

    class HumanMoveStratergy {
        -Scanner sc$
        +proposeNextMove(Board) Move
    }

    class BotMoveStratergy {
        +proposeNextMove(Board) Move
    }

    class StandardWinStratergy {
        +isWinning(Board, Character) boolean
    }

    %% Relationships
    Player <|.. HumanPlayer : implements
    MoveStratergy <|.. HumanMoveStratergy : implements
    MoveStratergy <|.. BotMoveStratergy : implements
    WinStratergy <|.. StandardWinStratergy : implements

    Game *-- Board : contains
    Game o-- Player : uses
    Game o-- WinStratergy : uses
    HumanPlayer o-- MoveStratergy : uses

    Player ..> Board : uses
    Player ..> Move : uses
    MoveStratergy ..> Board : uses
    MoveStratergy ..> Move : returns
    WinStratergy ..> Board : uses
    Board ..> Move : uses
```

## Design Patterns Used

1. **Strategy Pattern**
   - `MoveStratergy`: Encapsulates different move algorithms (Human, Bot)
   - `WinStratergy`: Encapsulates win condition checking logic

2. **Interface Segregation**
   - `Player`: Common interface for all player types
   - Allows flexibility to add different player types (Human, Bot, AI, etc.)

## Key Design Decisions

- **Composition over Inheritance**: `HumanPlayer` uses `MoveStratergy` rather than inheriting from different player types
- **Single Responsibility**: Each class has a focused purpose
- **Open/Closed Principle**: Easy to add new strategies without modifying existing code
- **Dependency Injection**: Strategies are injected into players and game

## Class Responsibilities

| Class | Responsibility |
|-------|---------------|
| `Game` | Orchestrates game flow, manages turns, checks win/draw conditions |
| `Board` | Maintains game state, validates moves, tracks available spaces |
| `Move` | Encapsulates move coordinates |
| `HumanPlayer` | Represents a human player with name, symbol, and move strategy |
| `HumanMoveStratergy` | Gets move input from console |
| `BotMoveStratergy` | Generates automated moves (first available space) |
| `StandardWinStratergy` | Checks rows, columns, and diagonals for win condition |
