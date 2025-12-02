package controller;
import java.util.*;
import java.sql.*;
import create.OPP;

public class libman23
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
               System.out.println("---------LIBRARY MANAGEMENT SYSTEM---------");
        System.out.println("1.Create account \n2.Delete account \n3.book entry \n4.book deletion \n 5. List of accounts \n ");
       System.out.println("Enter your choice:");
       int num = sc.nextInt();;

       switch(num){
              case 1:
               try{
             OPP.create();
       }
       catch(Exception e){
         System.out.println("kindly try");
       }
                break;
              case 2:
              try{ OPP.delete();}
              catch(Exception e){
                System.out.println("kindly try");
              }
                break;
                case 3:     
              try{OPP.bookEntry();}catch(Exception e){
                System.out.println("kindly try");}
                break;
                case 4: 
                try{    
                  OPP.bookdel();
                } catch(Exception e){
                  System.out.println("kindly try");
                } 
                break;
                case 5:
                  try{
                  OPP.List();
            } catch (Exception e){
              System.out.println("kindly try");
                  }
                  break;
              default:
                System.out.println("Invalid option");
       }
    }
}