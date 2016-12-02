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
            System.out.println("MAKE A NASTY BET");
            betSize = in.nextInt();
            in.nextLine();
            if(betSize>wallet)
            {
                System.out.println("YOUR BET IS TOO BIG");
            }
            else if(betSize == wallet)
            {
                System.out.println("YOUR BET WILL LEAVE YOU WITH NO MONEY, ARE YOU SURE? ");
                String l = in.nextLine();
                if("yes".startsWith(l.toLowerCase()))
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
