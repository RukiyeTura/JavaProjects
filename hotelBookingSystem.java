/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ASUS
 */

//A simple hotel booking system that calculates the price one need to pay considering how many days they plan to stay,
//how many people they are staying with, if they have children and if they have VIP membership.
import java.util.Scanner;
public class HotelBookingS210316049 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int price = 0;      //total price
        int discount =0;    //the amount of discount
        int price2 = 200;   //price of a 2-person room
        int price3 = 170;   //price of a 3-person room
        int price4 = 150;   //price of a 4-person room
        int children =0;     //number of children
	int guests =0;     //number of people in total
        int noc = 0;        //number of children 
        int vip = 0;        //whether they are vip or not
        int duration = 0;       //number of days they plan to stay
        int time = 0;       //whether they plan on staying weekdays or weekend
        int decision = 0;   //whether they confirm the reservation or not
        
	System.out.println("Welcome! For how many people you will be booking?");
        Scanner inputone = new Scanner(System.in);
        int nop = inputone.nextInt();
        guests += nop;      //nop stands for number of people
        
        
        if(guests > 1){
            System.out.println("Are you 1-Family or 2-Friends? Please select and type 1 or 2.");
            Scanner inputtwo = new Scanner(System.in);
            int rship = inputtwo.nextInt();     //rship stands for relationship
            
            if(rship == 2) {
                if(nop % 4 == 0) {      //if nop is 4 or multiple of 4 they get 4-person rooms
                    price += nop * price4;
                    }else if(nop % 4 == 3){
                    price += (nop / 4) * 4 * price4 + 3 * price3;    //if there are 4k+3 people they get a 3-person room aside of 4-person rooms (unless k=0)
                    }else if(nop % 4 == 2) {
                    price += (nop / 4) * 4 * price4 + 2 * price2;   //if there are 4k+2 people they get a 2-person room aside of 4-person rooms (unless k=0)
                    }else if (nop % 4 == 1) {
		    price += (nop / 4) * 4 * price4 + price2 + 80;}  //if there are 4k+1 people they got a 2-person room for one of them, but that person pays 80 more TLs
            System.out.println(" price is " +price);}
            
            
            
            else if(rship == 1) {
            System.out.println("Will there be children staying with you ? Please answer as 1-yes or 2-no."); }
             Scanner inputthree = new Scanner(System.in);
                     int wthc = inputthree.nextInt();   //wthc stands for whether they have children
                     
                     if(wthc == 2) {
                         
                         if(nop % 4 == 0) {     
                            price += nop * price4; 
                         } else if(nop % 4 == 3){
                            price += (nop / 4) * 4 * price4 + 3 * price3;
                         } else if(nop % 4 == 2) {
                            price += (nop / 4) * 4 * price4 + 2 * price2; 
                         } else if (nop % 4 == 1) {
                            price += (nop / 4) * 4 * price4 + price2 + 80; }
                     
                     System.out.println("price is " +price);}
                     
    if(wthc == 1) {
        System.out.println("How many children will be staying with you ?");
        Scanner inputfour = new Scanner(System.in);
                     noc = inputfour.nextInt();     //noc stands for number of children
                     children += noc; }
    
    if(noc == 1) {
        if(nop % 4 == 0) {      //4k adults + 3 adults + 1 child
            price += (nop - 4) * price4 + 3 * price4 + price4 * 1/2;
        } else if(nop % 4 == 1) {     //4k adults + 1 child
            price += (nop - 1) * price4 + price2 * 1/2; 
        } else if(nop % 4 == 2) {     //4k adults + 1 adult + 1 child
            price += (nop - 2) * price4 + price2 + price2 * 1/2; 
        } else if(nop % 4 == 3) {     //4k adults + 2 adults + 1 child
            price += (nop - 3) * price4 + 2 * price3 + price3 * 1/2; 
        }
        
    } //closes if noc=1

    if (noc > 1) {
        if (nop % 4 == 0) { 
            price += nop * price4 + noc * price4*3/4;
        } else if(nop % 4 == 1) {
            price += (nop - noc)/4 * 4 * price4 + noc/4 * 4 * price4*3/4 + ((nop-noc) % 4)* price2 + (noc % 4) * price2*3/4 + 160;
        } else if(nop % 4 == 2) {
            price += ((nop-noc) / 4) * 4 * price4 + (noc / 4) * 4 * price4*3/4 + ((nop-noc) % 4) * price2 + (noc % 4) * price2*3/4;
        } else if(nop % 4 == 3) {
            price += ((nop-noc) / 4) * 4 * price4 + (noc / 4) * 4 * price4*3/4 + ((nop-noc) % 4) * price3 + (noc % 4) * price3*3/4;
        }

    } //closes noc > 1
    
   System.out.println("Are you a VIP member of ours? Please select and type 1-yes or 2-no.");
   Scanner inputfive = new Scanner(System.in);
   vip = inputfive.nextInt();
   
   if(vip == 1) {
       discount += 5;
   }
   
   System.out.println("For how many days are you booking ?");
   Scanner inputsix = new Scanner(System.in);
   duration = inputsix.nextInt();
   
   if(duration <= 2) {
            System.out.println("Are you booking for 1-Weekdays or 2-Weekend ?");
            Scanner inputseven = new Scanner(System.in);
            time = inputseven.nextInt();
            
            if(time == 1) {
                discount += 3;
            } // closes time = 1
                
        } //closes duration <=2
   
   if(4 <= duration && duration <= 7) {
       discount += 4;
   } //closes 4 <= dur <= 7
   
   if(duration > 7) {
       discount += 6;
   } //closes dur>7
   
   price = price * (100 - discount) / 100;
   
   
   
   System.out.println("Do you confirm your reservation? Please select and type 1-yes or 2-no.");
   Scanner inputeight = new Scanner(System.in);
   decision = inputeight.nextInt();
   
   if(decision == 1){
       System.out.println("Your total price would be " +price);
   }

   
    } //closes if guests > 1 
}
}
    
        



