
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 
*/
class Solution {
    public int[] plusOne(int[] digits)
    {
        int n=digits.length;
        for(int i=n-1;i>=0;i--)
        {
            if(digits[i]<9)
            {
                digits[i]+=1;
                return digits;
            }
                       
            digits[i]=0;
            
        }
       
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
/*Method Followed:
 Check if the last most element in array is greater than 9 or not . if not then increase the last element by 1 and return the digits(array).if it is greater than 9(i.e ==9)
 then change the last element to 0 , and then increase the previous number.In case if all digits are 9 then , automatically the digits array become equal to 0.
 Then increase the size of digits array by 1 and make the digits[0]=1 
 */