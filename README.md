# Word-Problem
Welcome to the "Word Composition Problem Solver" repository! Here, you'll find a Java code solution designed to tackle the intriguing challenge of the Word Composition Problem.
Below, I provided a detailed breakdown of the steps involved in utilizing the provided Java code to solve the Problem.

**1.Imports:**
---> These imports are necessary for handling file input/output, reading data from files, managing collections (like lists and sets), and sorting.

**2.WordCompositionProblem Class:**
---> This class encapsulates the functionality required to solve the Word Composition Problem.

**3.readWordsFromFile Method:**
---> This method reads words from an input file specified by the inputFile parameter and returns them as a list of strings.
---> It trims each line to remove leading and trailing whitespace.

**4.findCompoundWords Method:**
---> This method takes a list of words (words) and a set of words (wordSet) as input.
---> It iterates through each word in the list and checks if it is a compound word by calling the isCompound method.

**5.isCompound Method:**
---> This method checks whether a given word is a compound word by recursively checking if its prefixes and suffixes are present in the provided word set.
---> If both the prefix and suffix are found in the word set, or if the suffix itself is a compound word, then the method returns true.

**6.main Method:**
---> The main method orchestrates the entire process.
---> It reads the words from the input file, finds compound words among them, sorts them by length in descending order, and prints the longest and second longest compound words. Finally, it outputs the time taken to process the input file.
