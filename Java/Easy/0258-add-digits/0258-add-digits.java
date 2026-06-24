class Solution {
    public int addDigits(int num) {
// a single digit is allowed in the output
// means 0-9 values are allowed
// so i must use adding the digits of a number logic 
// but till num remains > 9, for single values 0-9 i have to return it simply.


        while (num >= 10) {     // keep running until single digit remains or till num> 9 

            int sum = 0;

            while (num > 0) {
                int rem = num % 10; // fetch last digit
                sum = sum + rem; // add it to the sum which has initial value  =  0
                num = num / 10; // remove the last digit coz it just got added so its work is over
            }

            num = sum;          // use the new sum
        }

        return num;
    }
}
/*
num = 65

Initially:

num = 65

--------------------------------------------------

OUTER LOOP

while(num >= 10)

65 >= 10

true

So we enter the outer loop because the number still has more than 1 digit.

--------------------------------------------------

sum = 0

INNER LOOP

while(num > 0)

65 > 0

true

Take the last digit.

rem = 65 % 10 = 5

Add it to sum.

sum = 0 + 5 = 5

Remove the last digit.

num = 65 / 10 = 6

Current State:

num = 6
sum = 5

--------------------------------------------------

The inner loop reaches its end.

It now goes back and checks its condition again.

while(num > 0)

6 > 0

true

Another iteration will run.

rem = 6 % 10 = 6

sum = 5 + 6 = 11

num = 6 / 10 = 0

Current State:

num = 0
sum = 11

--------------------------------------------------

The inner loop again reaches its end.

It goes back and checks the condition.

while(num > 0)

0 > 0

false

So the inner loop terminates.

--------------------------------------------------

Important Observation:

The sum of digits has been calculated.

65 → 6 + 5 → 11

But currently:

num = 0
sum = 11

The answer 11 is stored inside sum.

num became 0 because we kept dividing it by 10.

If we do not copy sum back into num,
the outer loop will have nothing useful to work on.

Therefore:

num = sum

num = 11

Now the program has successfully converted:

65 → 11

--------------------------------------------------

The outer loop reaches its end.

It now checks its condition again.

while(num >= 10)

11 >= 10

true

Since 11 still has more than one digit,
another round of digit addition is required.

==================================================

sum = 0

while(num > 0)

11 > 0

true

rem = 11 % 10 = 1

sum = 0 + 1 = 1

num = 11 / 10 = 1

Current State:

num = 1
sum = 1

--------------------------------------------------

The inner loop reaches its end.

Condition is checked again.

while(num > 0)

1 > 0

true

Another iteration runs.

rem = 1 % 10 = 1

sum = 1 + 1 = 2

num = 1 / 10 = 0

Current State:

num = 0
sum = 2

--------------------------------------------------

The inner loop reaches its end.

Condition is checked again.

while(num > 0)

0 > 0

false

Inner loop terminates.

--------------------------------------------------

Again notice:

11 → 1 + 1 → 2

Currently:

num = 0
sum = 2

The required answer is inside sum.

So we again do:

num = sum

num = 2

Now the program has successfully converted:

11 → 2

==================================================

The outer loop reaches its end.

Condition is checked again.

while(num >= 10)

2 >= 10

false

Outer loop terminates.

Why?

Because 2 is already a single digit.

No more digit additions are needed.

==================================================

Final State:

num = 2

return num

return 2

==================================================

Complete Transformation:

65
↓
6 + 5 = 11
↓
1 + 1 = 2
↓
return 2

*/