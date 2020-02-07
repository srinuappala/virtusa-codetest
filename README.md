# virtusa-codetest
Virtusa Code Test


Explanation :
=============

Package com.virtusa.codetest contains class MerchantGuideToGalaxyApp that is main class containing the main method. 

      - This class is the point of entry into the application. This class takes the input file name as argument, parse the file and read all the valid lines into an ArrayList i.e input Arraylist.

Package com.guide.merchant.commandparser contains InputDataParser class, which takes the ArrayList of input lines and returns an ArrayList of Commands that need to be executed, after decoding string of each line using getCommandsFromFile() method.

Based on the input line type below different below commands will be prepared. Based on the regex patterns defined.

Package com.guide.merchant.command.impl contains 5 classes for each command type that can be generated from reading the input data which are implemented from ICommand interface. These classes are:

1. CommandAssignment:-- This class executes command statement like "pish is I", i.e. pish = I
2. CommandCreditAssign:-- This class executes command statement like "pish Iron is 10 Credits", i.e. Iron = 10
3. CommandHowMuch:-- This class executes command statement like "how much is pish ?"
4. CommandHowMany:-- This class executes command statement like "how many Credits is pish Iron ?"
5. CommandUnknown:-- This class executes command that is not a valid command statement with an error message


Conversion steps ;
                       words --> Romans --> Values;  Each command mentioned above has all these data saved as part of creation of particular command and will be used while execution.

- Package com.guide.merchant.databank contains  MetaData class, that stores the mapping of Roman numerals to their meant word and mapping of credit value of each item being sold.
- Package com.guide.merchant.roman contains RomanNumber class, that converts a given Roman number to it's corresponding Arabic value. ex X=10. The conversion related utility functions are placed here.					   

Example Calculation.
====================				   
Silver value calculation : glob glob(II)/34 = 17
Gold value calculation : glob prok (IV)/57800 = 14450
Iron value calculation : pish pish (XX)/3910 = 195.5



Execution Steps:
===============

1. Download the code and maven

  


      




