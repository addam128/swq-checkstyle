# swq-checkstyle

To build chekstyle rule `.jar`:

`javac -cp checkstyle-8.42-all.jar NegativeIncrementCheck.java`  
`jar -cf NegativeIncrement.jar NegativeIncrementCheck.class`  

To run checkstyle with test:

`java -classpath  checkstyle-8.42-all.jar:NegativeIncrement.jar  com.puppycrawl.tools.checkstyle.Main -c neginccheck.xml -o output.txt SelfRuleTest.java`

Note: all the commands presume you have the checkstyle `.jar` in the current directory.

Output: 
``` 
Starting audit...
[WARN] /home/adam/Desktop/FI_MUNI/mgr/2.semester/SWQ/checkstyle-tasks/swq-checkstyle/SelfRuleTest.java:5:34: Negative increment:--[5x33] [NegativeIncrement]
[WARN] /home/adam/Desktop/FI_MUNI/mgr/2.semester/SWQ/checkstyle-tasks/swq-checkstyle/SelfRuleTest.java:9:33: Negative increment:--[9x32] [NegativeIncrement]
[WARN] /home/adam/Desktop/FI_MUNI/mgr/2.semester/SWQ/checkstyle-tasks/swq-checkstyle/SelfRuleTest.java:13:35: Negative increment:-=[13x34] [NegativeIncrement]
[WARN] /home/adam/Desktop/FI_MUNI/mgr/2.semester/SWQ/checkstyle-tasks/swq-checkstyle/SelfRuleTest.java:17:35: Negative increment:-=[17x34] [NegativeIncrement]
Audit done.


```
