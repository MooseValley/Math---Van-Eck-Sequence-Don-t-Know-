/*
When you see a new number the next term is zero.
When you see a number that has already appeared in the sequence,
the next term is the number of steps back it was most recently seen ?


*** SAMPLE OUTPUT:

--------------------------------------------------------------------------------
 Van Eck Sequence                                             by Moose O'Malley
 v0.001 - Mon, 30-Jan-2023
--------------------------------------------------------------------------------

The first 30 terms:

0, 0, 1, 0, 2, 0, 2, 2, 1, 6, 0, 5, 0, 2, 6, 5, 4, 0, 5, 3, 0, 3, 2, 9, 0, 4, 9, 3, 6, 14,

*** All 30 terms verified against Van Eck sequence on OEIS: https://oeis.org/A181391

*/

import java.util.ArrayList;

public class VanEckSequence
{
   private static int     MAX                   = 30;
   private static boolean SHOW_DEGUG_TEST_INFO  = false;
   private static String  SEQUENCE_NAME_AND_URL = "Van Eck sequence on OEIS: https://oeis.org/A181391";

   // Correct results from Van Eck sequence on OEIS: https://oeis.org/A181391
   private static int[] crossCheck = {0, 0, 1, 0, 2, 0, 2, 2, 1, 6, 0, 5, 0, 2, 6, 5, 4, 0, 5, 3, 0, 3, 2, 9, 0, 4, 9, 3, 6, 14, 0, 6, 3, 5, 15, 0, 5, 3, 5, 2, 17, 0, 6, 11, 0, 3, 8, 0, 3, 3, 1, 42, 0, 5, 15, 20, 0, 4, 32, 0, 3, 11, 18, 0, 4, 7, 0, 3, 7, 3, 2, 31, 0, 6, 31, 3, 6, 3, 2, 8, 33, 0, 9, 56, 0, 3, 8, 7, 19, 0, 5, 37, 0, 3, 8, 8, 1};


   //private static int[] sequence = new int [MAX];
   private static ArrayList<Integer> sequence = new ArrayList<>();

   private static void addNextNumberToSequence ()
   {
      int stepsBack = 0;

      if (sequence.size() == 0)
      {
         if (SHOW_DEGUG_TEST_INFO == true)
            System.out.println ("Sequence is empty - add a new number : 0");
         sequence.add (0);
      }
      else
      {
         int searchVal  = sequence.get(sequence.size() - 1);
         int foundIndex = -1;

         for (int k = sequence.size() - 2; k >= 0; k--)
         {
            stepsBack++;

            if (searchVal == sequence.get(k))
            {
               foundIndex = k;
               k = -1; // Exit Loop !
            }
         }

         if (foundIndex < 0)
         {
            if (SHOW_DEGUG_TEST_INFO == true)
               System.out.println (searchVal + " not found - add a 0.");
            sequence.add (0);
         }
         else
         {
            if (SHOW_DEGUG_TEST_INFO == true)
               System.out.println (searchVal + " found at : " + stepsBack + " steps back.");
            sequence.add (stepsBack);
         }
      }

      if (SHOW_DEGUG_TEST_INFO == true)
         displaySequence ();
   }

   public static void displaySequence ()
   {
      for (int k = 0; k < sequence.size(); k++)
      {
         System.out.print (sequence.get(k) + ", ");
      }
      System.out.println();
   }

   public static void main (String[] args)
   {
      int currentNum = 0;
      int currIndex  = 0;

      System.out.println("--------------------------------------------------------------------------------");
      System.out.println(" Van Eck Sequence                                             by Moose O'Malley");
      System.out.println(" v0.001 - Mon, 30-Jan-2023");
      System.out.println("--------------------------------------------------------------------------------");
      System.out.println();

      System.out.println("The first " + MAX + " terms:");
      System.out.println();


      for (int k = 0; k < MAX; k++)
      {
         addNextNumberToSequence ();
      }

      if (SHOW_DEGUG_TEST_INFO == false)
         displaySequence ();

      System.out.println();


      // Cross Check / Error Check / Verify:

      int errorCount = 0;
      for (int k = 0; k < sequence.size(); k++)
      {
         if (sequence.get(k) != crossCheck[k])
         {
            System.out.println();
            errorCount++;
         }
      }

      if (errorCount == 0)
         System.out.println("*** All " + sequence.size() + " terms verified against " + SEQUENCE_NAME_AND_URL);
      else
         System.out.println("*** ERROR: " + errorCount + " errors found in first " + sequence.size() + " terms.");

      System.out.println();
   }
}
