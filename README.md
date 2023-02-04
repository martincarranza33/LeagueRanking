# LeagueRanking

League Ranking Project is a solution to the Problem as it follows

## The Problem

We want you to create a production ready, maintainable, testable command-line application that
will calculate the ranking table for a league.

## Input/output

The input and output will be text. Either using stdin/stdout or taking filenames on the command
line is fine.
The input contains results of games, one per line. See “Sample input” for details.
The output should be ordered from most to least points, following the format specified in
“Expected output”.

## The rules
In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A loss is worth 0 points.
If two or more teams have the same number of points, they should have the same rank and be
printed in alphabetical order (as in the tie for 3rd place in the sample data).

## Guidelines
If you use libraries installed by a common package manager (e.g pip), it is not necessary to
commit the installed packages.
We write automated tests and we would like you to do so as well.
If there are any complicated setup steps necessary to run your solution, please document them.

## Platform support
This will be run in a unix-ish environment (OS X). If you choose to use a compiled language,

please keep this in mind. Please use platform-agnostic constructs where possible (line-endings
and file-path-separators are two problematic areas).

## Sample input:

Lions 3, Snakes 3

Tarantulas 1, FC Awesome 0

Lions 1, FC Awesome 1

Tarantulas 3, Snakes 1

Lions 4, Grouches 0

## Expected output:
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts

## Installation

Use maven to clean test and install the app.

```
mcv clean test install
```
## Usage
You can execute the generated jar located in the target folder after the installation, you can execute it using the following command in a cmd

```
java -jar LeagueRanking-1.0-SNAPSHOT
```
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.