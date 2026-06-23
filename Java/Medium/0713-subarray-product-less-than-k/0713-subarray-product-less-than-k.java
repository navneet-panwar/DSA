class Solution {


public int numSubarrayProductLessThanK(int[] nums, int k) {

    // IMPORTANT EDGE CASE:

    // if k <= 1

    // no positive product
    // can ever become strictly less than k

    // WHY?

    // because array contains
    // only positive integers


    // example:

    // if k = 0

    // we need:
    // product < 0

    // but positive product
    // can NEVER become negative


    // similarly:

    // if k = 1

    // we need:
    // product < 1

    // but minimum positive product
    // itself is already 1


    // therefore:
    // no valid subarray can exist

    if(k <= 1){

        return 0;
    }



    // si:
    // starting index of current window

    // initially window is empty,
    // therefore starting index starts from 0

    int si = 0;



    // ei:
    // ending index of current window

    // initially ending index also starts from 0
    // because first window will start forming from index 0 itself

    int ei = 0;



    // p:
    // stores current window product

    // initially product is taken as 1 and NOT 0

    // WHY?

    // because:
    // product always starts with multiplicative identity

    // means:
    // any number * 1 remains same

    // example:

    // 5 * 1 = 5
    // 10 * 1 = 10

    // but if we took 0:

    // 5 * 0 = 0
    // 10 * 0 = 0

    // therefore entire product would always remain 0

    int p = 1;



    // ans:
    // stores count of valid subarrays

    // initially answer is 0 because
    // currently no valid subarray found yet

    int ans = 0;



    // window starts growing


    // WHY while(ei < nums.length) ?

    // because:
    // ei is ending index of current window

    // and we want every element
    // to become ending element once

    // therefore loop runs
    // until ei reaches last valid index

    while(ei < nums.length){

        // ------------------------------------------------
        // GROW WINDOW
        // ------------------------------------------------

        // include current ending element into product

        // WHY p *= nums[ei] ?

        // because current element now became
        // part of current window

        // therefore product must also include it


        // example:

        // suppose old product = 10

        // current element = 5

        // then new product becomes:

        // 10 * 5 = 50

        p *= nums[ei];



        // ------------------------------------------------
        // SHRINK WINDOW
        // ------------------------------------------------

        // if product becomes invalid,
        // keep shrinking until valid again

        // WHY while(p >= k) ?

        // because question says:
        // product must be STRICTLY LESS THAN k

        // therefore:
        // as long as product is >= k,
        // current window remains invalid

        // hence shrinking must continue

        while(p >= k){

            // WHY p /= nums[si] ?

            // because leftmost element
            // is leaving current window

            // therefore its contribution
            // must also be removed from product


            // example:

            // current window:
            // [2,5,4]

            // current product:
            // 40

            // now if 2 removed from window,
            // product should also remove contribution of 2

            // therefore:

            // 40 / 2 = 20

            p /= nums[si];



            // WHY si++ ?

            // because after removing leftmost element,
            // window no longer starts from old si

            // therefore si must move ahead


            // example:

            // suppose current window was:

            // [2,5,4]

            // si at index of 2

            // after removing 2,
            // new window becomes:

            // [5,4]

            // therefore si moves to next index

            si++;
        }



        // ------------------------------------------------
        // ANSWER UPDATE
        // ------------------------------------------------

        // current valid window starts from si
        // and ends at ei

        // therefore total elements inside window become:

        // (ei - si + 1)


        // WHY?

        // because:
        // subtraction gives distance between indexes

        // but both si and ei are INCLUDED in window

        // therefore +1 needed


        // example:

        // suppose:

        // si = 2
        // ei = 4

        // then window covers indexes:

        // 2 3 4

        // total elements = 3

        // and:

        // 4 - 2 + 1 = 3

        // therefore:
        // (ei - si + 1) gives exact window size



        // now WHY are we directly adding window size in ans?

        // because:
        // if complete current window is valid,
        // then all smaller ending subarrays inside it
        // are also automatically valid


        // example:

        // suppose current valid window is:

        // [5,2,6]

        // here ei is at 6

        // therefore possible subarrays ending at 6 are:

        // [6]
        // [2,6]
        // [5,2,6]

        // total valid subarrays = 3

        // and current window size is also 3

        // therefore:
        // number of valid ending subarrays
        // = current window size

        ans += (ei - si + 1);



        // move ending index ahead

        // WHY ei++ ?

        // because current ending element
        // has already been processed

        // now next element should enter window

        ei++;
    }



    // final answer returned

    return ans;
}

}
