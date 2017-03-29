
/**
 * Write a description of class RemoveNumberGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class RemoveNumberGame
{
    // instance variables - replace the example below with your own
    private int startingNumber;
    private int currentNumber;
    private String Player1;
    private String Player2;
    private String loser;
    private int playerInt;
    private int input;
    /**
     * Constructor for objects of class RemoveNumberGame
     */
    public void startStrategy()
    {
        System.out.print('\f');
        boolean inRange = false;
        int number = (int)(Math.random()*10) + 21;
        startingNumber = number;
        currentNumber = number;
        Player1 = "You";
        Player2 = "Computer";
        Scanner s = new Scanner(System.in);
        System.out.println("Starting number: "+ startingNumber);
        while(currentNumber>0)
        {

            System.out.println("How many do you want to remove?");

            while(!inRange)//while input is not in range makes sure next input is int in range [1,3]
            {
                if(s.hasNextInt())
                {
                    input = s.nextInt();
                    if(input>0 && input <4)
                    {
                        inRange = true;
                    }
                    else
                    {
                        System.out.println("You must remove 1, 2 or 3. Try again.");

                    }
                }
                else
                {
                    System.out.println("You must remove 1, 2 or 3. Try again.");
                    s.next();
                }
            }
            playerInt = input;
            inRange = false;
            if(playerInt >= currentNumber)
            {
                System.out.println(Player1 + " removed " + currentNumber);
                decreaseNumber(playerInt);
                System.out.println(Player2 + " wins!");
                break;
            }
            else
            {
                decreaseNumber(playerInt);
                System.out.println("You removed " + playerInt);
                System.out.println(currentNumber + " left");
            }
            int computerInt = smartNumber(playerInt);

            if(computerInt >= currentNumber)
            {
                System.out.println(Player2 + " removes " + computerInt);
                decreaseNumber(computerInt);
                System.out.println(Player1+ " win!");
                break;
            }
            else
            {
                decreaseNumber(computerInt);
                System.out.println(Player2 + " removes " + computerInt);
                System.out.println(currentNumber +" left");
            }

        }

    }

    /**
     *method to decrease current number
     */
    private void decreaseNumber(int input)
    {
        if((currentNumber - input)>=0)
        {
            currentNumber = currentNumber - input;
        }
        else
        {
            currentNumber = 0;

        }
    }

    /**
     *method to choose a random number between 1 and 3
     */
    private int randomNumber()
    {
        Random random = new Random();
        return (int)(Math.random()*3)+1;
    }

    private int smartNumber(int playernumber)
    {
        if(currentNumber == 4 || currentNumber ==3 || currentNumber == 2)
        {
            return currentNumber -1;
        }
        else if(currentNumber == 6 || currentNumber == 7 || currentNumber == 8)
        {
            return currentNumber%5;
        }
        else if((currentNumber%3)==1)
        {
            return 3;
        }

        else if(currentNumber%3+2<=3)
        {
            return currentNumber%3 + 2;
        }
        else if(currentNumber%3 == 2)
        {
            return 1;
        }
        else if(currentNumber%3==1)
        {
            return 3;
        }
        else
        {
            return randomNumber();
        }
    }

}