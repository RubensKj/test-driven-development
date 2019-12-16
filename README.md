# Learning Test Driven Development
This is basically for study, the idea was learn about tdd and start code that way. Then use in inside projects of HBSIS.

## Getting Started

At first, we need to write a test to return a httpstatus of 404. Then we start to create our controller.

![Image getting exception 404](https://image.prntscr.com/image/98ge7uYwSbu0qBrklDwZrw.png)

Here comes how to test the not found exception.

![Treating not found exception](https://image.prntscr.com/image/psll_WSOThK0fDKe1ZejDQ.png)

And thats basically the idea.
First make the test, and start to develop your application

<br>

Testing each line of code.

![CarService](https://image.prntscr.com/image/yffGa_jXTB6uwv7Qtb_3Vg.png)


## Some issues

The 'CarWebTestClientTest' is used to test the controller directly with spring security. If the application doesn't have spring security dependency, is not necessary to wrote this peace of test.

![CarWebTestClientTest](https://image.prntscr.com/image/8UWuPwiUSailBg-yxKomag.png)

### The final results

Coding like this way, make us test each line of code and make sure that is all tested and implemented.

![Project structure after doing tdd](https://image.prntscr.com/image/A8A4cTTkQiGzt1MhhB21vQ.png)

ps: That is a small project, but starting with the tests, in the future will help to maintain the code clean and tested.
