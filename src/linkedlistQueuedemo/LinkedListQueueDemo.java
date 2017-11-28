/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistQueuedemo;

import java.util.Scanner;

/**
 *
 * @author Cristy
 */
public class LinkedListQueueDemo
{
    LinkedListQueue cat = new LinkedListQueue();
    LinkedListQueue dog = new LinkedListQueue();
    LinkedListQueue shelterPet = new LinkedListQueue();
    LinkedListQueue foundAnimal = new LinkedListQueue();
    LinkedListQueue holdShelter = new LinkedListQueue();
    LinkedListQueue holdCat = new LinkedListQueue();
    LinkedListQueue holdDog = new LinkedListQueue();
    
    Scanner in = new Scanner(System.in);
   public static void main(String[] args)
   {
       LinkedListQueueDemo func = new LinkedListQueueDemo();
       func.menu();
     
   }
   public void menu ()
   {
       System.out.println("Select a chocie from the main menu: ");
       int userChoice = 0;
       
       while(userChoice != 6)
       {
           System.out.println("1.Donate a cat");
           System.out.println("2.Donate a dog");
           System.out.println("3.Adopt a Cat");
           System.out.println("4.Adopt a dog");
           System.out.println("5.Adopt oldest Pet");
           System.out.println("6.Exit");
           userChoice = in.nextInt();
           
           switch (userChoice)
           {
               case 1:
               {
                   donateCat();
                   break;
               }
               case 2:
               {
                   donateDog();
                   break;
               }
               case 3:
               {
                   adoptCat();
                   break;
               }
               case 4:
                   adoptDog();
               {
                   break;
               }
               case 5:
               {
                   searchOldest();
                   break;
               }
               case 6:
               {
                   System.out.println("Eliminating program from mainframe matrix thingg..some crazy stuff!!!!");
                   break;
               }
               default:
               {
                   System.out.println("Note a Choice.......... ");
                   break;
               }
           
           }
       }
   }
   public void donateCat()
   {
       System.out.println("what is the name of the cat you would like to donate");
       String catName = in.next();
       Pet catObj = new Pet(catName,"cat");
       cat.enqueue(catObj);
       shelterPet.enqueue(catObj);
   }
   
   public void donateDog()
   {
       System.out.println("what is the name of the dog you would like to donate");
       String dogName = in.next();
       Pet dogObj = new Pet(dogName,"dog");
       dog.enqueue(dogObj);
       shelterPet.enqueue(dogObj);
   }
   public void adoptCat()
   {
       Object catHolder = cat.dequeue();
       System.out.println("you just adopted "+ catHolder+"!!!");
       searchShelter(catHolder.toString());
       for(LinkedListQueue.Node s:shelterPet)
       {
           System.out.println(s);
       }
       holdShelter = new LinkedListQueue();
   }
   public void adoptDog()
   {
       Object dogHolder = dog.dequeue();
       System.out.println("you just adopted "+ dogHolder+"!!!");
       searchShelter(dogHolder.toString());
       for(LinkedListQueue.Node s:shelterPet)
       {
           System.out.println(s);
       }
       holdShelter = new LinkedListQueue();
   }
   
   public void searchShelter(String adptCat)
   {                
       while (!shelterPet.empty()) 
       {
           Object searchShelter = shelterPet.dequeue();
           //  System.out.println(search.toString());
           if (!searchShelter.toString().equalsIgnoreCase(adptCat)) 
           {
               holdShelter.enqueue(searchShelter);
           }
           else 
           {
           //    System.out.println("We found him");
               foundAnimal.enqueue(searchShelter);
           }
       }
       shelterPet = holdShelter;
   }

   public void searchOldest()
   {
       System.out.println("Searching for the oldest animal in the linked list queue");
       
       Object last = shelterPet.dequeue();
       Pet o = (Pet)last;
       if(o.getSpecies().equalsIgnoreCase("cat"))
       {
           cat.dequeue();
       }
       else
       {
           dog.dequeue();
       }
       for(LinkedListQueue.Node s:shelterPet)
       {
           System.out.println(s);
       }
   }
   
}