class Solution {
    public int mostWordsFound(String[] sentences) {

/*

Whenever you see: an array

and you need to inspect every character
immediately think:

for(int i = 0; i < arr.length; i++)    // notice arr.length , not arr.length(), because length is the property of arrays
                                       // and length() is the property of strings
{
    arr[i]       // This does nothing Why? Because you're accessing the element but not using it.

    System.out.println(arr[i]); // this will print each element of the array, coz you are accessing element as well as displaying it.


// you can even store each value into a variable
// the type of var depends on what the array stores

    int x = arr[i];   // if arr was storing Integers, so after extracting those we will store them inside "int" type var

    String s = arr[i]; /// if arr was storing Strings, so after extracting those we will store them inside "String" type var
}

because this loop gives elements one by one.




Whenever you see: a String

and you need to inspect every character
immediately think:

for(int i = 0; i < str.length(); i++)    // notice str.length()
{
    char ch = str.charAt(i);        // accessing characterAt i in str String through  ( str.charAt(i) )   
                                    // storing it inside variable of "char" type (coz each string is made of characters)
}                                   

because this loop gives characters one by one in "ch"





String[]  means the array that contains Strings.
eg: ["hii","bye","hey"]

but here they say String[] sentences means strings of the array but these strings are sentences in themselves containing spaces 
eg: ["hii this is me","bye pal","hey dude"]

So no worries those sentences are still strings let's access each sentence and store it for every ith value of the array


for(int i = 0; i < sentences.length; i++)
{
    String sentence = sentences[i];
}

gives one complete sentence at a time. at ith index 
Now what you do with each sentence depends on the problem.


Here the problem says:
Find the sentence having maximum number of words.

so you have to count words of each sentence at ith index
How to count words? "hii this is me" // have 4 words 
                                     // words are identifiable bcoz of spaces ( here 3 )
                                     // so for every sentence          words = spaces + 1

// hence i think we should find "spaces" first and then "count" through them
// if we find "count" of words first it will be a complicated task  
// and finding "spaces" is a easy task , 

//  since question says 1)words are separated by exactly one space
                        2)no leading spaces
                        3)no trailing spacesyou hust have to do 

so you just have to use this logic:
           if(ch == ' '){     // when any character == space
                spaces++;     // increase the space count, so that we can count words later easily
            }                                               

// but question is NOT asking us to return words of every sentence
// question asks:
// which sentence contains the maximum number of words ?

// therefore we need a variable that remembers the largest word count seen till now

int max = 0;

// after finding words of current sentence,
// compare it with the maximum found so far

if(words > max)      // if you found word count that is more than max value of the word count
{
    max = words;     // update the max count
}
return max           // and return max when all sentences are checked mean put return max outside the for loop
                     // therefore max keeps getting updated
                     // whenever we find a sentence having more words
                     // than all previous sentences





*/


        int max = 0;     // stores maximum words found till now

// template for traversing all strings inside String[]

        for(int i = 0; i < sentences.length; i++)    // traversing the sentences array
        {
            String sentence = sentences[i];   // extract one sentence

            int spaces = 0;                   // count spaces of current sentence but initialize it with = 0

// now treat the extracted sentence as a normal String
// and traverse character by character

            for(int j = 0; j < sentence.length(); j++){ // traversing the sentence string

                if(sentence.charAt(j) == ' ') // if any character inside string == space
                {
                    spaces++;                 // increase the spaces count of above variable
                }
                // can't write return spaces here coz we have already the updated value of the spaces ouside loop which can be used later on       easily since it was outside the loop
                // moreover writing return spaces here then the function immediately ends. & Java never gets a chance to execute BELOW CODE
                // spaces is not even the final answer that this function should return so NO don't write return spaces here  
            }

            int words = spaces + 1;           // the int space value would have been updated till now so find wordcount though it

            if(words > max)                   // if current sentence has more words
            {
                max = words;                  // update max 
            }
        }

        return max;    // is written outside array traversing loop coz obviously max should be returned after checking all the array strings
    }
}