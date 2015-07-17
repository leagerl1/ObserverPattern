CS442 Design Patterns
Spring 2015
PROJECT 3 README FILE

Due Date: Firday, April 3, 2015
Submission Date: Thursday, April 2, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: 2 Days
Author(s): Lucas Eager Leavitt
e-mail(s): leagerl1@binghamton.edu


PURPOSE:

[
 Implement basic Observer Pattern that simulates a dashboard tracking process, user, and memory management info.
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of the project.
]

PARTS THAT ARE NOT COMPLETE:

[
  N/A
]

BUGS:

[
  N/A
]

FILES:

[
  Included with this project are 15 files:

  MyLogger, the file which provides debugging functionality for the program
  Driver.java, calls the Client and displays its menu
  DisplayFile.java, interface for writing to file
  DashboardFilter.java, interface for filter class
  Observer.java, interface for implementing observers
  PerformanceTab.java, Observer class holding performance info
  ProcessesTab.java, Observer class holding process info
  UsersTab.java, Observer class holding user info
  UsersTabFilterImpl.java, filter implemenation for users
  ProcessesTabFilterImpl.java, filter implementation for processes
  PerformanceTabFilerImpl.java, filter implementation for performance
  FileProcessor.java, writes and reads from file
  DashBoardSubject.java, Subject implementation that registers and updates observers
  Subject.java, interface for implementing subject
  build.xml, file that tells ant how to compile and run the project
  README, the text file you are presently reading
]

SAMPLE OUTPUT:

[

  run:
     [java] Updating UsersTab
     [java] Updating PerformanceTab
     [java] Updating UsersTab
     [java] Updating ProcessesTab
     [java] Updating UsersTab
     [java] Updating ProcessesTab
     [java] Updating PerformanceTab
     [java] Updating ProcessesTab



TO COMPILE:

[
  Just extract the files and then do ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile build.xml run
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Lucas Eager Leavitt

[
   * http://stackoverflow.com/questions/2312756/in-java-how-to-read-from-a-file-a-specific-line-given-the-line-number]

ACKNOWLEDGEMENT:

[
  N/A

]
