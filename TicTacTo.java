/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tictacto;

/**
 *
 * @author lixar
 */
import java.util.Scanner;
//import java.util.Arrays;
public class TicTacTo {
    //public static count = 0;
    public static void main(String[] args) {
       // int turnCount = 1;
        Scanner input = new Scanner(System.in);
        String piece = "";
        System.out.println("Tic Tac Toe");
        String [][] board =
        {
            {"1", "|", "2", "|", "3"},
            {"-", "-", "-", "-", "-"},
            {"4", "|", "5", "|", "6"},
            {"-", "-", "-", "-", "-"},
            {"7", "|", "8", "|", "9"}
           
        };
        printArray(board);
        
        String choice;
        for(int turnCount = 1; turnCount <= 9; turnCount++)
        {
            if(turnCount % 2 != 0)
            {
                piece = "X";
            }
            if(turnCount % 2 == 0)
            {
                piece = "O";
            }
            System.out.println(piece + ", it is your turn, enter the number where you want to go");
            choice = input.nextLine();
            setPiece(board, piece, choice);
            printArray(board);
            if(win(board))
            {
                System.out.println("Player " + piece + " won!");
                System.exit(0);
            }
        }
        System.out.println("Tie!, please restart");
        
    }
    
    public static void printArray(String[][] board)
    {
        for(int row = 0; row < board.length ; row++) //printing board
        {
            for(int col = 0; col < board[row].length ; col++)
            {
                System.out.print(board[row][col]);
            }
            System.out.println("");
        }    
    }
    public static void setPiece(String[][] board, String playerPiece, String choice)
    {
        if(Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 9)
        {
            System.out.println("Invalid input, please restart");
            System.exit(0);
        }
        if(Integer.parseInt(choice) <= 3)
        {
            board[0][indexOf(board, choice)] = playerPiece;
        }
        else if(Integer.parseInt(choice) <= 6)
        {
            board[2][indexOf(board, choice)] = playerPiece;
        }
        else if(Integer.parseInt(choice) <= 9)
        {
            board[4][indexOf(board, choice)] = playerPiece;
        }
    }
    public static int indexOf(String[][] board, String choice)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j].equals(choice))
                {
                   return j;        
                }
            }
        }
        return 99;
    }
    public static boolean win(String[][]board)
    {
        //checking win

        
        for(int i = 0, j = 0; i < board.length; i += 2)
        {
            if(board[i][j].equals(board[i][j + 2]) && board[i][j].equals(board[i][j + 4]))
            {
                return true;
            }
        }
        
        for(int i = 0, j = 0; j < board[i].length; j += 2) //checking downs
        {
            if(board[i][j].equals(board[i + 2][j]) && board[i][j].equals(board[i + 4][j]))
            {
                return true;
            }
        }
        if(board[0][0].equals(board[2][2]) && board[0][0].equals(board[4][4]))
        {
            return true;
        }
        if(board[4][0].equals(board[2][2]) && board[4][0].equals(board[0][4]))
        {
            return true;
            
        }
        else
        {
            return false;
        }
    }
    
}
