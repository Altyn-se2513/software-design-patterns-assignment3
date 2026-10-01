Bridge Pattern — Quiz Input Channels

This project shows the Bridge pattern in Java. We have quizzes and we have input channels. Quizzes are multiple choice, open-ended, and true or false. Input channels are console, web form, and voice assistant. The quiz does not know where the answer comes from. It just asks for an answer and shows a message. The input channel does not know what the quiz is. So we can mix any quiz with any channel, and change the channel while the program runs.

Pattern parts from Lecture 4. Quiz is the Abstraction. It keeps a link to InputChannel. MultipleChoiceQuiz, OpenEndedQuiz, TrueOrFalseQuiz are Refined Abstractions. InputChannel is the Implementor and it has two operations: receiveAnswer and showMessage. ConsoleInputChannel, WebFormInputChannel, VoiceInputChannel are Concrete Implementors. Main is the Client.

Clean Code principles I used. Separation of Concerns: Quiz only does quiz logic, InputChannel only handles user messages, and quiz never touches System.out directly. Meaningful Names: every class on the implementor side ends with InputChannel, every class on the abstraction side ends with Quiz, so the side of the bridge is visible from the name. Small Classes: each class does one small job, shared logic for simulated channels lives once in SimulatedInputChannel, so WebFormInputChannel and VoiceInputChannel have no duplicated code. DRY: common answer normalization and null handling are in Quiz.ask in one place. Easy to Extend: to add a new channel like SMS, just add a new class implementing InputChannel, no changes to Quiz or its subclasses.

How to run. Compile all java files. Run Main. For the console quiz, type your answer. For web form and voice assistant, answers are simulated automatically.
