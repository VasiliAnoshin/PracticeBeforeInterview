using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeWarsRepo
{
    class Program
    {
        //This place as engie for all project exercise
        static void Main(string[] args)
        {
            //#1 StocjList
            string[] art = new string[] { "ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600" };
            String[] cd = new String[] { "A", "B" };
            StockList.stockSummary(art,cd);

            //#2 WhichAreIn: two examples 
            string[] a1 = { "arp", "live", "strong" };
            string[] a2 = { "lively", "alive", "harp", "sharp", "armstrong" };
            //The second example
            string[] a3 = { "1295", "code", "1346", "1028", "ar" };
            string[] a4 = { "12951295", "ode", "46", "10281066", "par" };
            string[] a5 = WhichAreIn.inArray(a3, a4);

            //#3 Next bigger number with the same digits
            long numb = NextBiggerNumber.ComputeNextBiggerNumber(144);

        }
    }
}
