# Bridge Pattern — Quiz Answer Channels

This project demonstrates the Bridge design pattern in Java. I have two independent dimensions of variation: Quizzes (Multiple Choice, Open-Ended, True or False) and Answer Channels (Console, Web Form, Voice Assistant). Without the Bridge pattern, combining 3 quiz types with 3 channel implementations would lead to a combinatorial explosion of 3 x 3 = 9 subclasses. The Bridge pattern decouples abstraction from implementation, allowing them to vary independently; the implementation can also be switched at runtime.

## Project Folder Structure

```text
src/
├── Main.java
├── quiz/
│   ├── Quiz.java
│   ├── MultipleChoiceQuiz.java
│   ├── OpenEndedQuiz.java
│   └── TrueOrFalseQuiz.java
└── channel/
    ├── AnswerChannel.java
    ├── ConsoleAnswerChannel.java
    ├── SimulatedAnswerChannel.java
    ├── WebFormAnswerChannel.java
    └── VoiceAnswerChannel.java
```
## Clean Code Principles Applied. 

### Clear Separation of Abstraction and Implementation: 
The abstraction side lives strictly in the quiz package, while the implementation side lives in channel. Quiz interacts with communication channels exclusively through the AnswerChannel interface via a private field, hiding implementation details even from subclasses. 
### Meaningful Names That Show the Role: 
Every implementor class ends with AnswerChannel, and every refined abstraction ends with Quiz, making the architectural side clear from the class name alone, while methods like display avoid naming collisions with built-in Java thread methods like Object.notify. 
### No Duplicated Logic Between Concrete Implementors: 
Shared behaviors, such as answer queue management and formatting logic for simulated interfaces, are encapsulated once in the abstract base class SimulatedAnswerChannel, and subclasses only supply their specific name and simulation label. 
### Backward-Compatible Design / Open-Closed Principle: 
Adding a new communication medium like an SMS channel requires just creating one new class implementing AnswerChannel with zero modifications to existing classes, and the same applies when introducing new quiz types. 
### Small, Focused Classes and Methods: 
Each refined abstraction implements three concise methods including getHeader, getPrompt, and evaluate, and Main is neatly split into distinct, readable scenario methods. 
### One Place for Shared Behaviour / DRY: 
startQuiz is marked final in Quiz to enforce a strict, consistent sequence of steps for all quizzes, and ask serves as the single centralized place where answers are normalised, handling nulls and trimming whitespace. 
### No Null as an Error Code / Fail Fast: 
TrueOrFalseQuiz uses an internal Answer enum with values TRUE, FALSE, and UNKNOWN instead of returning error codes or nulls, and Objects.requireNonNull immediately guards against missing channels in constructors and setter methods, failing fast rather than propagating errors downstream.

## Pattern Architecture

| Role | Class | Responsibility |
|------|-------|----------------|
| Abstraction | `quiz.Quiz` | Defines the high-level control logic and maintains a reference to the implementor. |
| Refined Abstraction | `quiz.MultipleChoiceQuiz`, `quiz.OpenEndedQuiz`, `quiz.TrueOrFalseQuiz` | Extend the abstraction with specific quiz rules and evaluation behavior. |
| Implementor | `channel.AnswerChannel` | Defines the interface for low-level communication primitives: receiving answers and showing messages. |
| Concrete Implementor | `channel.ConsoleAnswerChannel`, `channel.WebFormAnswerChannel`, `channel.VoiceAnswerChannel` | Implement the communication interface for specific mediums. `WebFormAnswerChannel` and `VoiceAnswerChannel` share queue logic via `channel.SimulatedAnswerChannel`. |
| Client | `Main` | Orchestrates execution scenarios and sets up initial configurations or runtime switching. |

## How to run
Open your terminal and navigate to the src directory. Compile all Java files and run the application using:
```text
cd src
javac -d out Main.java channel/*.java quiz/*.java
java -cp out Main
```
For the Console Quiz, type your answer directly into the terminal when prompted. For the Web Form and Voice Assistant, answers are fed and simulated automatically.
