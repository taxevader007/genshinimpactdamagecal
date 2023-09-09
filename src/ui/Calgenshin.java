import java.util.Scanner;
import java.util.Random;

public class Calgenshin {
  static String[] characters;
  static Double[] levels;
  static Double[] attack;
  static Double[] ME;
  static Double[] PDC;
  static Double[] DC;
  static int[] MTVChoice;
  static int[] MRAChoice;
  static int[] MADChoice;
  static Double[] totalDamage;
  static Double[] MTV = { 0.25, 0.5, 0.6, 1.2, 1.5, 2.0, 2.0, 3.0 };// MTV transformative multiplier Value
  static Double[] MRA = { 1.5, 2.0 };// MRA amplification reaction multiplier Value
  static Double[] MAD = { 1.15, 1.25 };// MAD additive multiplier Value
  static Scanner scan = new Scanner(System.in);
  static double majorDamage = 0.0;
  static double[] damageTop = new double[10];

  public static void main(String[] args) {
    menu();
  }

  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static void menu() {
    while (true) {
      System.out.println("Welcome to the Genshin Impact Damage Calculator");
      System.out.println("1. Calculate damage \n 2. See the major damage \n 3. See the last 10 damage \n 4. Exit");
      System.out.println("Enter your option");
      int option = scan.nextInt();
      switch (option) {
        case 1:
          datosPersonaje();
          break;
        case 2:
          System.out.println("the best damage is " + majorDamage);
          break;
        case 3:
          System.out.println("The last 10 damage are " + seeDamageTop());
          break;
        case 4:
          System.out.println("Thanks for using the Genshin Impact Damage Calculator");
          System.exit(0);
          break;
        default:
          System.out.println("You have entered a wrong value for option");
          break;
      }
    }
  }


  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static String seeDamageTop() {
    String top = "";
    for (int i = 0; i < damageTop.length; i++) {
      if (damageTop[i] == 0.0) {
        break;
      }
      top += damageTop[i] + ", ";
    }
    return top;
  }

  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static void datosPersonaje() {
    int numberofcharacters = 0;
    boolean firstquestion = false;
    boolean exit = false;

    if (firstquestion == false) {

      System.out.println("Enter the number of character that youre going to use  1 or 4 ");
      numberofcharacters = scan.nextInt(); // refers to number of characters

    }

    while (exit == false) {

      while (numberofcharacters != 1 && numberofcharacters != 4) {
        System.out.println("You have entered a wrong value for number of characters ");
        System.out.println("Enter the number of character that youre going to use from 1 or 4 ");
        numberofcharacters = scan.nextInt(); // refers to number of characters

      }

      characters = new String[numberofcharacters];
      levels = new Double[numberofcharacters];
      attack = new Double[numberofcharacters];
      ME = new Double[numberofcharacters];
      PDC = new Double[numberofcharacters];
      DC = new Double[numberofcharacters];
      MTVChoice = new int[numberofcharacters];
      MRAChoice = new int[numberofcharacters];
      MADChoice = new int[numberofcharacters];
      totalDamage = new Double[numberofcharacters];
      for (int i = 0; i != numberofcharacters; i++) {
        System.out.println("\nEnter a name for the character " + (i + 1));
        characters[i] = scan.next();
        System.out.println("Enter your character level " + (i + 1));
        levels[i] = scan.nextDouble();
        System.out.println("Enter attack of the character " + (i + 1));
        attack[i] = scan.nextDouble();
        System.out.println("Enter Elemental mastery of the character " + (i + 1));
        ME[i] = scan.nextDouble();
        System.out.println("Enter critical dammage chance of the character" + (i + 1));
        PDC[i] = scan.nextDouble();
        System.out.println("Enter Critical Dammage of the character " + (i + 1));
        DC[i] = scan.nextDouble();
        System.out.println("Enter transformative multiplier of the character" + (i + 1)
            + "\n 0 for burning \n 1 for Superconduct \n 2 for Swirl \n 3 for Electro chaged \n 4 for Shattered \n 5 for Overload \n 6 for Bloom \n 7 for Burgeon and hyperbloom");
        while (true) {
          MTVChoice[i] = scan.nextInt();
          if (MTVChoice[i] >= 0 && MTVChoice[i] <= 7) {
            break;
          } else {
            System.out.println("You have entered a wrong value for MTV transformative multiplier Value ");
          }

        }
        System.out.println("Enter amplification reaction multiplier of the character" + (i + 1)
            + "\n 0 for vaporization \n 1 for melt");
        while (true) {
          MRAChoice[i] = scan.nextInt();
          if (MRAChoice[i] >= 0 && MRAChoice[i] <= 1) {
            break;
          } else {
            System.out.println("You have entered a wrong value for MRA amplification reaction multiplier Value ");
          }
        }
        System.out.println(
            "Enter additive multiplier of the character" + (i + 1) + "\n 0 for intensification \n 1 for propagation");
        while (true) {
          MADChoice[i] = scan.nextInt();
          if (MADChoice[i] >= 0 && MADChoice[i] <= 1) {
            break;
          } else {
            System.out.println("You have entered a wrong value for MAD additive multiplier Value ");
          }
        }
      }
      formulas(characters);
      exit = true;
    }
  }


  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static void formulas(String[] characters) {
    Random rand = new Random();
    double min = 0.5;
    double max = 2;
    double MR = min + (max - min) * rand.nextDouble();
    for (int i = 0; i < characters.length; i++) {
      double basedammage = attack[i] * (1 + PDC[i] + DC[i]);
      double percentagebonusME = 16 * ME[i] / (ME[i] + 2000);
      double transformative_dammage = MTV[MTVChoice[i]] * levels[i] * (1 + percentagebonusME) * MR;
      double amplificationReactionMultiplier = MRA[MRAChoice[i]];
      double amplificationBonusME = 2.78 * ME[i] / (ME[i] + 1400);
      double amplificationMultiplier = amplificationReactionMultiplier * (1 + amplificationBonusME);
      double amplifierDamage = basedammage * amplificationMultiplier;
      double additiveDamageMultiplier = MAD[MADChoice[i]];
      double additiveBonusME = 5 * ME[i] / (ME[i] + 1200);
      double additiveDamage = additiveDamageMultiplier * levels[i] * (1 + additiveBonusME) * MR;
      totalDamage[i] = basedammage + transformative_dammage + amplifierDamage + additiveDamage;
      addDamageTop(totalDamage[i]);
      if (totalDamage[i] > majorDamage) { 
        majorDamage = totalDamage[i];
      }
    }
    if (characters.length == 1) {
      System.out.println("The total dammage of the" + characters[0] + " is " + totalDamage[0]);
    } else {
      System.out.println("The total dammage of the team is " + sumTotalDamage());
    }
  }


  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static double sumTotalDamage() {
    int total = 0;
    for (int i = 0; i < characters.length; i++) {
      System.out.println("The total dammage of the " + characters[i] + " is " + totalDamage[i]);
      total += totalDamage[i];
    }
    return total;
  }

  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static void addDamageTop(double damage) {
    boolean added = false;
    for (int i = 0; (i < damageTop.length) && !added; i++) {
      if ((damageTop.length - 1 == i) && (damageTop[i] != 0.0)) {
        orderDamageTop(damage);
        break;
      }
      if (damageTop[i] == 0.0) {
        damageTop[i] = damage;
        added = true;
        break;
      }

    }
  }

  /**
   * Descripción: ¿Qué hace mi método? (concisa, un par de líneas) † pre: ¿Cuáles
   * son las condiciones sobre las variables globales?
   * pos: ¿Cuáles fueron los cambios sobre las variables globales?
   * 
   * @param <nombre_par>   <tipo> <condiciones sobre el parámetro>
   * @param <nombre_par_n> ‹tipo> ‹condiciones sobre el parámetro n>
   * @return <nombre_var> <tipo> <información sobre variable de retorno>
   */
  public static void orderDamageTop(double damage) {
    for (int i = 0; i < damageTop.length; i++) {
      damageTop[i - 1] = damageTop[i];
    }
    damageTop[damageTop.length - 1] = damage;
  }

}
