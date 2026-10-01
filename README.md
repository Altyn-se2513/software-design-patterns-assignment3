Bridge Pattern — Quiz Input Channels

This project shows the Bridge pattern in Java. We have quizzes and we have input channels. Quizzes are multiple choice, open-ended, and true or false. Input channels are console, web form, and voice assistant. The quiz does not know where the answer comes from. It just asks for an answer. The input channel does not know what the quiz is. It just gives an answer. So we can mix any quiz with any channel, and change the channel while the program runs.

Pattern parts from Lecture 4. Quiz is the Abstraction. It keeps a link to InputChannel. MultipleChoiceQuiz, OpenEndedQuiz, TrueOrFalseQuiz are Refined Abstractions. InputChannel is the Implementor. ConsoleInputTerminal, WebFormInput, VoiceAssistantInput are Concrete Implementors. Main is the Client. It makes quizzes and changes channels.

Clean Code ideas I used. Separation of Concerns. Quiz does quiz stuff. InputChannel gets the answer. Quiz does not know about console, web, or voice. Good Names. Names are clear. ConsoleInputTerminal, WebFormInput, VoiceAssistantInput. Also MultipleChoiceQuiz, OpenEndedQuiz, TrueOrFalseQuiz. Small Classes. Each class does one small job. DRY. Shared quiz code is in Quiz. Each channel has its own receiveAnswer, so no copy-paste. Easy to Add New Things. To add a new channel, just make a new class that implements InputChannel. No need to touch Quiz.
