using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeWarsRepo
{
    class WhichAreIn
    {
        /* #6que
            Description: 
            Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order
            of the strings of a1 which are substrings of strings of a2.
            Example 1:
            a1 = ["arp", "live", "strong"]
            a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
            returns ["arp", "live", "strong"]
            Example 2:
            a1 = ["tarp", "mice", "bull"]
            a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
            returns []
            Notes:
            Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
            Beware: r must be without duplicates.
          */
        public static string[] inArray(string[] array1, string[] array2)
        {    //Created By BenFranklin
            //If string is empty return EMPTY String , NULL is INVALID output .                   
            if (array1.Length <= 0 || array2.Length <= 0)
            {
                return new string[] { };
            }
            //Creating a list and not array in array1.size because it is possible that existing some words in array1 that will not included in output array
            List<String> sortedArray = new List<String>();            
            for (int i = 0; i < array1.Length; i++)
            {
                foreach (string word in array2)
                {
                    //Using keyWord Contains to check is string from arr1[] is sunstring of another string.
                    if (word.Contains(array1[i]))
                    {
                        sortedArray.Add(array1[i]);
                        break;
                    }
                }                        
            }
            //There was a dillemma in this place to use List.SORT or Linq. List was shorter .  
            //var sort = from s in sortedArray.ToArray()
            //          orderby s
            //          select s;
            sortedArray.Sort();
            return sortedArray.ToArray();
        }
    }
}
