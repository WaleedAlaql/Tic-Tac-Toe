# Tic Tac Toe Game (Java CLI)

A robust, feature-rich command-line implementation of the classic Tic Tac Toe game developed in Java. This project showcases core procedural programming concepts, robust input validation, a computer AI opponent, and multi-round match support with early termination logic.

---

## Features

* **Game Modes:**
* **Single Round Mode:** Play a quick 1-round match.
* **Best of 3 Mode:** Play a full 3-round series with overall match score tracking.
* **Early Match Termination:** Automatically concludes multi-round series early if a player or the computer secures a 2-0 lead, saving time when a match is mathematically decided.
* **Error Handling:** Uses `try-catch` blocks and `InputMismatchException` to prevent application crashes and buffer loops when users input invalid characters or symbols.
* **Computer AI Opponent:** Implements random move generation with automatic empty-slot verification to ensure fair and valid gameplay.
* **Dynamic Board Mapping:** Translates user inputs (1-9) directly into 2D array coordinates (`row` and `col`) using clean arithmetic logic.

---

## Technical Stack & Concepts

* **Language:** Java 17+
* **Core Concepts:** 
  * 2D Arrays (`char[][]`)
  * Method Modularity & Procedural Design
  * Exception Handling (`try-catch`, `InputMismatchException`)
  * Control Flow (`for` loops, `while` loops, conditional branching)
* **Libraries Used:** 
  * `java.util.Scanner` (User input)
  * `java.util.Random` (Computer AI)
  * `java.util.InputMismatchException` (Robust validation)
