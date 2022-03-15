<h1 align="center"> Seat Code - Mower Kata </h1> <br>

### Instructions for the challenge

SEAT:CODE has been asked for a really important project. We need to develop an application that helps in controlling brand new mowers 
from the SEAT Martorell Factory.

SEAT Martorell factory has a lot of green spaces but for the MVP, we will consider only one single green grass plateau to simply the problem.

A green grass plateau, which is curiously rectangular, must be navigated by the mowers.

A mower’s position and location are represented by a combination of X and Y coordinates and a letter representing one of the four cardinal compass 
points (N, E, S, W). The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the mower is in 
the bottom left corner and facing North.

In order to control a mower, SEAT Maintenance Office sends a simple string of letters. The possible letters are “L”, “R” and ”M”. “L” and “R” make the
mower spin 90 degrees left or right respectively, without moving from its current spot. “M” means to move forward one grid point and maintain the same Heading.
Assume that the square directly North from (X, Y) is (X, Y + 1).

### Input
- The first line of input is the upper-right coordinates of the plateau, the bottom-left coordinates are assumed to be 0, 0.
The upper-right coordinates by default are 100,100.

- The rest of the input is information pertaining to the mowers that have been deployed. Each mower has two lines of input. 
The first line gives the mower’s position, and the second line is a series of instructions telling the mower how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the X and Y coordinates and the mower’s orientation.


## How to build and run the project

In order to compile the code and run the test, execute:

```./gradlew clean build```

To run the application, execute:

```./gradlew --console plain run```

<br>

Once the app is up and running, you will see in the console that you are asked for the inputs as shown in the example:

**Please, enter the upper limits of your plateau, and your mowers (with the initial position and their instructions):**

5 5</br>
1 2 N </br>
LMLMLMLMM </br>
3 3 E </br>
MMRMMRMRRM