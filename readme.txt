#Conference Track Management
	- Developed by : Kunal Chaudhary (chaudhary.kc.kunal@gmail.com)


## About the problem :
You are planning a big programming conference and have received many proposals which have passed the initial screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! So you write a program to do it for you.
The conference has multiple tracks each of which has a morning and afternoon session.
Each session contains multiple talks.
Morning sessions begin at 9am and must finish by 12 noon, for lunch.
Afternoon sessions begin at 1pm and must finish in time for the networking event.
The networking event can start no earlier than 4:00 and no later than 5:00.
No talk title has numbers in it.
All talk lengths are either in minutes (not hours) or lightning (5 minutes).
Presenters will be very punctual; there needs to be no gap between sessions.


## Sample Input :
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min


## Sample Output :
Track 1:
09:00AM Writing Fast Tests Against Enterprise Rails 60min
10:00AM Communicating Over Distance 60min
11:00AM Rails Magic 60min
12:00PM Lunch
01:00PM Ruby Errors from Mismatched Gem Versions 45min
01:45PM Common Ruby Errors 45min
02:30PM Accounting-Driven Development 45min
03:15PM Pair Programming vs Noise 45min
04:00PM Clojure Ate Scala (on my project) 45min
05:00PM Networking Event

Track 2:
09:00AM Ruby on Rails: Why We Should Move On 60min
10:00AM Ruby on Rails Legacy App Maintenance 60min
11:00AM Overdoing it in Python 45min
11:45AM Rails for Python Developers lightning
12:00PM Lunch
01:00PM Lua for the Masses 30min
01:30PM Woah 30min
02:00PM Sit Down and Write 30min
02:30PM Programming in the Boondocks of Seattle 30min
03:00PM Ruby vs. Clojure for Back-End Development 30min
03:30PM A World Without HackerNews 30min
04:00PM User Interface CSS in Rails Apps 30min
05:00PM Networking Event


## Compiling and Running :
 - Compile(from root directory of project) 	: javac test/Test.java -d build
 - Run (from the root directory of project)	: java -cp ./build/ test.Test


## About the Scheduling Algorithm :
The given problem is a NP complete problem and have no exact solution in polynomial time.
The problem is dealt by Fitting the talk in greedy manner. The talks are fitted in a way to fill the gap as much as possible.
First the talks are sorted in descending order and then they are fitted accordingly.


## Structure of Project :
1. build/	- contains the java class file after compilation
2. input/	- contains the input txt file
3. output/	- contains the output txt file. File created after running the program.
4. tercept/	- contains the entity of conference and Scheduler
5. test/	- Program for testing and running the conference scheduler algorithm.