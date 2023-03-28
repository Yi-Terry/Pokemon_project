package com.CSCI185;



import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Terry, Josh, John
 * @Version 1.0
 * @since 5-3-22
 */
//public class A implements C,D {.. .} valid
public class Pokemon implements fightable,Comparable
{
    //A. variables
    private String name;
    private int level;
    private int health;
    private int attack;
    private String type;
    private HashMap<String, Integer> Attacks = new HashMap<String,Integer>();

    //B. methods
    /**
     * Getters for all variables
     *
     */
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getType() {
        return type;
    }
    /**
     * Setters for all variables
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setType(String type) {
        this.type = type;
    }
    //constructors
    public Pokemon()
    {
        name = "no name";
        level = 0;
        health = 0;
        attack = 0;
        type = "no type";
    }
    /**
     *Sets all of the variables for the pokemon
     * @param newName
     * @param newLevel
     * @param newHealth
     * @param newAttack
     * @param newType
     */
    public Pokemon(String newName, int newLevel, int newHealth,
                   int newAttack, String newType)
    {
        name = newName;
        level = newLevel;
        health = newHealth;
        attack = newAttack;
        type = newType;
    }
    // setter that sets all pokemon variables
    public void setPokemon(String name, int level, int health,
                           int attack, String type){
        this.name = name;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.type = type;
    }
    /**
     * Adds attack to attacks array
     * @param givenAttack - String that defines the name of the attack
     * @param damageModifier- Int that defines the damage to be done by the given attack
     */
    public void addAttack(String givenAttack, int damageModifier)
    {
        Attacks.put(givenAttack,damageModifier);

    }

    //C. additional methods
    /**
     *
     * @return string with all variables from the class
     */
    public String toString()
    {
        return this.getName() +", " + this.getLevel() + ", " + this.getHealth() + ", " +
                this.getAttack() + ", " + this.getType();
    }

    /**
     * compares 2 object type Pokemons to see if they're equal
     * @param O
     * @return boolean
     */
    public boolean equals(Pokemon O)
    {
        return this.level == O.level &&
                this.attack == O.attack &&
                this.health == O.health &&
                this.name.equalsIgnoreCase(O.name) &&
                this.type.equalsIgnoreCase(O.type);
    }
    /**
     * reads input given
     */
    public void readInput()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of Pokemon: ");
        name = keyboard.next();
        System.out.println("Enter the level of Pokemon: ");
        level = keyboard.nextInt();
        System.out.println("Enter the health of Pokemon: ");
        health = keyboard.nextInt();
        System.out.println("Enter the attack of Pokemon: ");
        attack = keyboard.nextInt();
        System.out.println("Enter the type of Pokemon: ");
        type = keyboard.next();
    }
    /**
     * displays output
     */
    public void writeOutput()
    {
        System.out.println("Type: "+type);
        System.out.println("Name: "+name);
        System.out.println("Level: "+level);
        System.out.println("Health: "+health);
        System.out.println("Attack: "+attack);
    }
    //D. compareTo method
    /**
     * compares two pokemon
     * @param o
     * @return -1 if other pokemon is not a pokemon
     *          1 means
     */
    public int compareTo(Object o)
    {
        if ((o != null) && (o instanceof Pokemon))
        {
            Pokemon otherPokemon = (Pokemon) o;
            return (name.compareTo(otherPokemon.name));
        }
        return -1;
    }
    // E. dealDamage method

    private int inflictDamage()
    {
        return (int)(Math.random()*6)+3+attack;
    }

    public void dealDamage(int damage, Pokemon fightable)
    {
        damage = this.inflictDamage();
        System.out.println(this.name + " attacked " + fightable.name +
                " for " + damage + " damage");
        fightable.health -= damage;
        System.out.println(fightable.name + "'s health is at " + fightable.getHealth());
    }

    /**
     * Allows the Pokemon object calling the method to attack the paramater Pokemon object passed through
     * @param findAttack-String key that fetches the damage modifier associated with it in the Attacks hashMap
     * @param fightable-Object of the Pokemon class that recieves the damage
     */
    public void useAttack(String findAttack, Pokemon fightable) {
        //Damage needs to be calculated through our own means
        int valueOfAttack = Attacks.get(findAttack);

        if (fightable.getHealth() > 0) {
            if (this.getAttack() < valueOfAttack) {
                System.out.println("Pokemon " + this.getName() + " does not have attack value to do damage" );
            }else{
                System.out.println(this.name + " uses " + findAttack + " on " + fightable.name);
                int damageNumber = this.getAttack()- valueOfAttack;
                this.setAttack(damageNumber);
                //
                dealDamage(damageNumber, fightable);
                System.out.println("p1 "+ this.getAttack());
            }

        }
    }

}