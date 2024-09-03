package the.avenger;

import java.util.*;

public class TheAvenger {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        
        String enemies[]={"Thanos","Ultron","Kang","Dr.Doom"};
        int maxEnemyHealth=75;
        int enemyAttackDamage=25;
        
        int health=100;
        int attckDamage=50;
        int energyDrinks=3;
        int healthHealAmount=30;
        int drinkDropChance=50;
        
        System.out.println("Wecome to the Marvel Universe");
                
        GAME:
        while(true){
            System.out.println("---------------------------------------------");
            
            String enemy=enemies[rand.nextInt(enemies.length)];
            int enemyHealth=rand.nextInt(maxEnemyHealth);
            System.out.println("\t#"+enemy+" has appeared! #\n");
            
            while(enemyHealth>0){
                
                System.out.println("\t Your HP:"+health);
                System.out.println("\t "+enemy+"'s HP:"+enemyHealth);
                
                System.out.println("\n\t What you want to do:");
                System.out.println("\t 1.Attack");
                System.out.println("\t 2.Take energy drink");
                System.out.println("\t 3.Run!!");
                System.out.println("Enter your action:");
                String action=sc.nextLine();
                
                if(action.equals("1")){
                    int damageGiven=rand.nextInt(attckDamage);
                    int damageTaken=rand.nextInt(enemyAttackDamage);
                    
                    health-=damageTaken;
                    enemyHealth-=damageGiven;
                    
                    System.out.println("\t> You strike "+enemy+" with "+damageGiven+" Damage.");
                    System.out.println("\t> You receive "+damageTaken+" Damage in reverse.");
                     
                    if(health<1){
                        System.out.println("\t> You have taken too much damage. You are very week to attck..!!");
                        break;
                    }
                }
                else if(action.equals("2")){
                    if(energyDrinks>0){
                        health+=healthHealAmount;
                        energyDrinks--;
                        System.out.println("\t> You have taken an energyDrink to heal yourself with "+healthHealAmount+" Hp.");
                        System.out.println("\t> You now have "+health+" HP.");
                        System.out.println("\t> You have "+energyDrinks+" energy drinks left.");
                    }
                    else{
                        System.out.println("\t> You have no health drinks left! Defeat enemies for a chance to get one.");
                    }
                }
                else if(action.equals("3")){
                    System.out.println("\t You run away from "+enemy+"!.");
                    continue GAME;
                }
                else{
                    System.out.println("\t Invalid Action..!!!");
                }
            }
            
            if(health<0){
                System.out.println("\t You are out of the Marvel Universe. Week from Battle..!");
                break;
            }
            System.out.println("---------------------------------------------");
            System.out.println("# "+enemy+" was defeated #");
            System.out.println(" # You have "+health+" HP health left #");
            if(rand.nextInt(100)<drinkDropChance){
                energyDrinks++;
                System.out.println("# The enemy "+enemy+" dropped the energy drink. #");
                System.out.println("# Now you have "+energyDrinks+" energy drinks. #");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now:");
            System.out.println("1. Continue Attacking");
            System.out.println("2. Exit Marvel");
            System.out.println("Enter your input:");
            String ip=sc.nextLine();
            
            while(!ip.equals("1") && !ip.equals("2")){
                System.out.println("Invalud input..!");
                ip=sc.nextLine();
            }
            
            if(ip.equals("1")){
                System.out.println("You continue on your adventure.");
            }
            else{
                System.out.println("You exit the Marvel, successful from your adventure..!!");
                break;
            }       
        }
        System.out.println("########################");
        System.out.println("# THAKS FOR PLAYING! #");
        System.out.println("########################");
    }
    
}
