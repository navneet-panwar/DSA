class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        // very easy

// we have to return maximum number of consecutive 1's 
// so i think i should maintain the count of 1's in a variable
// and whenever i see a value other than 1 ,  i will refresh that 1's count
// and will start count of 1 from 0 again        

/*
        int count = 0;
        for(int i = 0; i< nums.length; i++){

            if ( nums[i] == 1){
                count++;

            }

            if ( nums[i] != 1 ){
                count = 0;
            }

        }
        return count;
        
    }
}

*/

// but there was a problem with above code

// the problem was 

/*
 count stores only the CURRENT streak.

 Question asks for the MAXIMUM streak.

 Example:

 nums = [1,1,0,1,1,1]


 Dry Run:

 1 -> count = 1
 1 -> count = 2
 0 -> count = 0
 1 -> count = 1
 1 -> count = 2
 1 -> count = 3

// Here answer becomes 3,
// so luckily return count works.


// But consider:

 nums = [1,1,1,0]


 Dry Run:

 1 -> count = 1
 1 -> count = 2
 1 -> count = 3
 0 -> count = 0

// Loop finishes.

 return count
 returns 0

 But answer should be 3.

*/

/*

So a new question arises.

How will I remember the largest
sequence seen so far,

even after count becomes 0 in the end like in above eg:2 ?

Hence I need another variable.
"maxCount"

It should always stores the best answer
seen till now. so if at last i see 0 , the count resets to 0 but 
not the maximum streak 

*/


// count stores the current consecutive 1's

        int count = 0;


// maxCount stores the maximum consecutive 1's seen so far

        int maxCount = 0;


// now traverse every element of the array

        for(int i = 0; i < nums.length; i++) {


// if current element is 1,
// current sequence continues

            if(nums[i] == 1) {

                count++;     // current sequence has increased.


// now check whether it has become
// the largest sequence till now.

                if(count > maxCount) {   // if yes 

                    maxCount = count;    // then update max count to count 
                }

            }


            else { // means when num[i] != 1

                count = 0;   // reset the count 
            }
        }
// Hence,

// every time count increases,

// compare it with maximum count seen so far.

// if its current count is > maximum count  
            // then store it immediately

// if not then don't
// if current element  is != 1 , reset count

//  notice how i am storing the maximum streak before setting count = 0;



// so after traversing the whole array,

// maxCount contains the largest
// consecutive sequence of 1's. so return it 

        return maxCount;
    }
}

// --------------------------------------------------------------------------------------------


/*

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

/*

The logic remains exactly the same.

count stores the CURRENT streak.

maxCount stores the BEST streak seen so far.

Earlier we updated maxCount like this:

if(count > maxCount)
{
    maxCount = count;
}

Now a question arises.

This comparison is very common.

Does Java already provide a function
which returns the larger of two numbers?

Yes.

Math.max(a, b)

returns whichever value is greater.


Example:

Math.max(5, 2) = 5

Math.max(3, 9) = 9

Math.max(7, 7) = 7


So instead of writing:

if(count > maxCount)
{
    maxCount = count;
}

we can simply write:

maxCount = Math.max(maxCount, count);


Read it like this:

"Compare maxCount and count.

Whichever is larger,

store it back into maxCount."



        int count = 0;

        int maxCount = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 1) {

                count++;    // current streak increased


// compare current streak and best streak

// keep whichever one is larger

                maxCount = Math.max(maxCount, count);

            }

            else {

                count = 0;   // sequence breaks
            }
        }


// return the largest streak found

        return maxCount;
    }
}


*/












