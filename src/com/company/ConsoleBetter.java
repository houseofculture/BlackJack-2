package com.company;
import java.util.Scanner;
/**
 *
 * Created by student2 on 28.11.16.
 */
public class ConsoleBetter extends  Better {
    Scanner in = new Scanner(System.in);
    public int bet(int wallet)
    {
        int betSize;
        while(true)
        {
            betSize = in.nextInt();
            if(betSize>wallet)
            {
                System.out.println("YOUR BET IS TOO BIG");
            }
            else if(betSize == wallet)
            {
                System.out.println("YOUR BET WILL LEAVE YOU WITH NO MONEY, ARE YOU SURE? ");
                String s = in.nextLine();
                if("yes".startsWith(s.toLowerCase()))
                {
                    return betSize;
                }
            }
            else
            {
                return betSize;
            }
        }
    }
}
