import java.util.Scanner;
import java.util.Random;
public class Calgenshin{

  
  public static void main(String[] args) {  

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of character that youre going to use from 1 to 4 ");
    int numberofcharacters =scan.nextInt(); // refers to number of characters
  
    

    String[] Characters = new String[numberofcharacters]; //Array of character names
    Double[] Levels = new Double[numberofcharacters]; //Array about levels that the user enter to the character
    Double[] Attack = new Double[numberofcharacters];//Array of Attack of the (n) character
    Double[] ME = new Double[numberofcharacters];
    Double[] PDC = new Double[numberofcharacters];
    Double[] DC = new Double[numberofcharacters];
    
    Double[] MTV ={0.25, 0.5, 0.6, 1.2, 1.5, 2.0, 2.0, 3.0};//MTV transformative multiplier Value
     
    

    for (int i = 0 ; i != numberofcharacters; i++) { //Start of the cicle
    
      System.out.println("\nEnter a name for the character " + (i+1));
        Characters[numberofcharacters - 1] = scan.next();
      System.out.println("Enter your character level " + (i + 1) );    
        Levels[numberofcharacters - 1] = scan.nextDouble();
      System.out.println("Enter attack of the character " + (i + 1) );    
        Attack[numberofcharacters - 1] = scan.nextDouble() ;
      System.out.println("Enter Elemental mastery of the character " + (i + 1) );    
        ME[numberofcharacters - 1] = scan.nextDouble() ;
      System.out.println("Enter critical dammage chance of the character" + (i + 1) );    
        PDC[numberofcharacters - 1] = scan.nextDouble() ;
      System.out.println("Enter Critical Dammage of the character " + (i + 1 ) );    
        DC[numberofcharacters - 1] = scan.nextDouble() ;
      System.out.println("Enter transformative multiplier of the character" + (i + 1 ) + "\n 0 for burning \n 1 for Superconduct \n 2 for Swirl \n 3 for Electro chaged \n 4 for Shattered \n 5 for Overload \n 6 for Bloom \n 7 for Burgeon and hyperbloom"  );
        MTV[numberofcharacters] = scan.nextDouble() ;
      
      
      if (MTV[numberofcharacters]==0){
        MTV[0] += 1;
      }else if (MTV[numberofcharacters]==1){
        MTV[1] += 1;
      }else if (MTV[numberofcharacters]==2){
        MTV[2] += 1;
      }else if (MTV[numberofcharacters]==3){
        MTV[3] += 1;
      }else if (MTV[numberofcharacters]==4){
        MTV[4] += 1;
      }else if (MTV[numberofcharacters]==5){
        MTV[5] += 1;
      }else if (MTV[numberofcharacters]==6){
        MTV[6] += 1;
      }else if (MTV[numberofcharacters]==7){
        MTV[7] += 1;
      }else {
        System.out.println("You have entered a wrong value for MTV transformative multiplier Value ");
      } System.out.println(MTV); 
    }
   

      
    scan.close();
  } //close main   

  public static double formulas(int n,String[] Characters, Double [] Levels, Double[] Attack,Double[] ME,Double[] PDC,Double[] DC,Double MTV[]) {

    Random rand = new Random();
        double min = 0.5;
        double max = 2;
        double MR = min + (max - min) * rand.nextDouble();//Resistant multiplier a multiplier that enemys have for dammage
        //random from range between 0.5 and 2

    for (int i = 0 ; i != n ; i++) { 
    Double Basedammage = Attack[i]  * ( 1 + PDC[i] + DC[i]);

    Double MEpercentagebonus = 16*ME[i]/(ME[i] + 2000);

    Double Transformative_dammage = MTV[i] * Levels[i] *(1 + PDC[i]) * MR ;





    
  }
    
       return 1;


  }

   
        
        

   
} 
    