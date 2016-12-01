using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeWarsRepo
{
    class NextBiggerNumber
    {
        //Description:
        //You have to create a function that takes a positive integer 
        //number and returns the next bigger number formed by the same digits:
        //Kata.NextBiggerNumber(12)==21
        //Kata.NextBiggerNumber(513)==531
        //Kata.NextBiggerNumber(2017)==2071

        //If no bigger number can be composed using those digits, return -1:
        //Kata.NextBiggerNumber(9)==-1
        //Kata.NextBiggerNumber(111)==-1
        //Kata.NextBiggerNumber(531)==-1
        public static long ComputeNextBiggerNumber(long n)
        {
            //Add long to array of long digits and reverse at the end 
            List<long> dividedNumber = new List<long>();
            while (n > 0)
            {
                dividedNumber.Add(n%10);
                n /= 10;
            }
            int iterCounter = 0;
            dividedNumber.Reverse();
            //create two parts of array LeftSide and the RightSide .
            long[] leftSide;
            long[] rightSide;
            for (int i = dividedNumber.Count-1; i > 0; i--)
            {
                if (dividedNumber[i] > dividedNumber[i - 1])
                {
                    int firstArrayLength = dividedNumber.Count - 1 - iterCounter;
                    leftSide = new long[firstArrayLength];
                    rightSide = new long[dividedNumber.Count-i];
                    Array.Copy(dividedNumber.ToArray(), 0, leftSide, 0, firstArrayLength);
                    Array.Copy(dividedNumber.ToArray(), firstArrayLength, rightSide, 0, rightSide.Length);
                    long temp = 0;
                    long theNextBigNumberIndex = 0;
                    for (int j = 1; j < rightSide.Length; j++)
                    {
                        if (leftSide[leftSide.Length-1] < rightSide[j])
                        {
                            if (!(rightSide[j] > rightSide[theNextBigNumberIndex]))
                            {
                                theNextBigNumberIndex = j;
                            }
                        }
                    }
                    temp = leftSide[leftSide.Length - 1];
                    leftSide[leftSide.Length - 1] = rightSide[theNextBigNumberIndex];
                    rightSide[theNextBigNumberIndex] = temp;
                    Array.Sort(rightSide);
                    dividedNumber.Clear();
                    dividedNumber.AddRange(leftSide);
                    dividedNumber.AddRange(rightSide);
                    break;
                }                
                else
                {
                    iterCounter++;
                }
            }
            if (iterCounter == dividedNumber.Count - 1)
            {
                return -1;
            }
            return getResultLong(dividedNumber);
        }
 
        public static long getResultLong(List<long> number)
        {
            long computeNewNumb = number[0];
            for (int i = 0; i < number.Count - 1; i++)
            {
                computeNewNumb = computeNewNumb*10 + number[i + 1];
            }
            return computeNewNumb;
        }

   }
}
