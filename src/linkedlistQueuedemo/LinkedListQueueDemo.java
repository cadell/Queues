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
                   break;
               }
               case 6:
               {
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
       cat.enqueue(catName);
       shelterPet.enqueue(catName);
   }
   
   public void donateDog()
   {
       System.out.println("what is the name of the dog you would like to donate");
       String dogName = in.next();
       dog.enqueue(dogName);
       shelterPet.enqueue(dogName);
   }
   public void adoptCat()
   {
       System.out.println("What is the name of the cat you would like to adopt");
       String adptCat = in.next();
       System.out.println("we got here"+adptCat);
       System.out.println(cat.empty());
       searchCat(adptCat);
       System.out.println("we got here1");
       searchShelter(adptCat);
       System.out.println(cat.empty());
       System.out.println(shelterPet.empty());
       System.out.println("we got here2");
       for(LinkedListQueue.Node s:shelterPet)
       {
           System.out.println(s);
           System.out.println("Inside print");
       }
       holdCat = new LinkedListQueue();
       holdShelter = new LinkedListQueue();
       in.nextLine();
   }
   public void adoptDog()
   {
       System.out.println("What is the name of the cat you would like to adopt");
       String adptDog = in.next();
       System.out.println("we got here"+adptDog);
       System.out.println(cat.empty());
       searchDog(adptDog);
       System.out.println("we got here 1");
       searchShelter(adptDog);
       System.out.println("we got here 2");
       for(LinkedListQueue.Node s:shelterPet)
       {
           System.out.println(s);
       }
       holdShelter = shelterPet;
   }
   public void shelter()
   {
   
   }
   
   public void searchCat(String adptCat)
   {
       while (!cat.empty()) 
       {
           Object searchCat = cat.dequeue();
           //  System.out.println(search.toString());
           if (!searchCat.toString().equalsIgnoreCase(adptCat)) 
           {
               holdCat.enqueue(searchCat);
           }
           else 
           {
            //   System.out.println("We found him");
               foundAnimal.enqueue(searchCat);
           }
       }
       cat = holdCat;
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
   public void searchDog(String adptDog)
   {
          while (!dog.empty()) 
       {
           Object searchDog = dog.dequeue();
           //  System.out.println(search.toString());
           if (!searchDog.toString().equalsIgnoreCase(adptDog)) 
           {
               holdDog.enqueue(searchDog);
           }
           else 
           {
               System.out.println("We found him");
               foundAnimal.enqueue(searchDog);
           }
       }
       dog = holdDog;
   }
   
}
