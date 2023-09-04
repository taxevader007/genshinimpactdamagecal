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
    int[] MTVChoice = new int[numberofcharacters];
    int[] MRAChoice = new int[numberofcharacters];
    int[] MADChoice = new int[numberofcharacters];
    Double[] MTV ={0.25, 0.5, 0.6, 1.2, 1.5, 2.0, 2.0, 3.0};//MTV transformative multiplier Value
    Double[] MRA ={1.5, 2.0};//MRA amplification reaction multiplier Value
    Double[] MAD ={1.15, 1.25};//MAD additive multiplier Value
     

    for (int i = 0 ; i != numberofcharacters; i++) {

      System.out.println("\nEnter a name for the character " + (i+1));
      Characters[i] = scan.next();
      System.out.println("Enter your character level " + (i + 1) );
      Levels[i] = scan.nextDouble();
      System.out.println("Enter attack of the character " + (i + 1) );
      Attack[i] = scan.nextDouble() ;
      System.out.println("Enter Elemental mastery of the character " + (i + 1) );
      ME[i] = scan.nextDouble() ;
      System.out.println("Enter critical dammage chance of the character" + (i + 1) );
      PDC[i] = scan.nextDouble() ;
      System.out.println("Enter Critical Dammage of the character " + (i + 1 ) );
      DC[i] = scan.nextDouble() ;
      System.out.println("Enter transformative multiplier of the character" + (i + 1 ) + "\n 0 for burning \n 1 for Superconduct \n 2 for Swirl \n 3 for Electro chaged \n 4 for Shattered \n 5 for Overload \n 6 for Bloom \n 7 for Burgeon and hyperbloom" );
            while(true) {
              MTVChoice[i] = scan.nextInt();
              if(MTVChoice[i] >= 0 && MTVChoice[i] <=7) {
                  break;
              } else {
                  System.out.println("You have entered a wrong value for MTV transformative multiplier Value ");
              }
      
          }
          System.out.println("Enter amplification reaction multiplier of the character" + (i + 1 ) + "\n 0 for vaporization \n 1 for melt" );
            while(true) {
              MRAChoice[i] = scan.nextInt();
              if(MRAChoice[i] >= 0 && MRAChoice[i] <=1) {
                  break;
              } else {
                  System.out.println("You have entered a wrong value for MRA amplification reaction multiplier Value ");
              }
          }
          System.out.println("Enter additive multiplier of the character" + (i + 1 ) + "\n 0 for intensification \n 1 for propagation" );
            while(true) {
              MADChoice[i] = scan.nextInt();
              if(MADChoice[i] >= 0 && MADChoice[i] <=1) {
                  break;
              } else {
                  System.out.println("You have entered a wrong value for MAD additive multiplier Value ");
              }
          }
      }
      formulas(numberofcharacters, Characters, Levels, Attack, ME, PDC, DC, MTVChoice, MRAChoice, MADChoice, MTV, MRA, MAD);
      
    scan.close();
  } //close main   

  public static void formulas(int n,String[] Characters, Double [] Levels, Double[] Attack,Double[] ME,Double[] PDC,Double[] DC,int []MTVChoice ,int []MRAChoice ,int []MADChoice ,Double MTV[],Double MRA[],Double MAD[]) {
    Random rand = new Random();
    double min = 0.5;
    double max = 2;
    double MR = min + (max - min) * rand.nextDouble();//Resistant multiplier a multiplier that enemys have for dammage
        //random from range between 0.5 and 2

        for (int i = 0 ; i < n ; i++) {
          
          Double Basedammage = Attack[i] * (1 + PDC[i] + DC[i]);

          Double MEpercentagebonus = 16*ME[i]/(ME[i] + 2000);

          Double Transformative_dammage = MTV[MTVChoice[i]] * Levels[i] *(1 + MEpercentagebonus) * MR;
          
          Double AmplificationReactionMultiplier = MRA[MRAChoice[i]];
        // Enter the value of AmplificationReactionMultiplier based on the type of amplification reaction
        // For example:
        // AmplificationReactionMultiplier = 1.5; // for vaporization

          Double AmplificationBonusME = 2.78 * ME[i] / (ME[i] + 1400);
          Double AmplificationMultiplier = AmplificationReactionMultiplier * (1 + AmplificationBonusME);

            Double AmplifierDamage = Basedammage * AmplificationMultiplier;

            Double AdditiveDamageMultiplier = MAD[MADChoice[i]];

            Double AdditiveBonusME = 5 * ME[i] / (ME[i] + 1200);
            Double AdditiveDamage = AdditiveDamageMultiplier * Levels[i] * (1 + AdditiveBonusME) * MR;

            System.out.println("Character: " + Characters[i]);
            System.out.println("final dammage " + Basedammage + Transformative_dammage + AmplifierDamage + AdditiveDamage);


        }
    }
}
    