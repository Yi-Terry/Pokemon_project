package com.CSCI185;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    //A. Variables
    private String trainer;
    private String gym;
    private ArrayList<Pokemon> members = new ArrayList<Pokemon>();
    static String saveFile = "teamData.record";
    static File myfile = new File(saveFile);

    //B. Methods

    /**
     * Accessor and Mutator methods for all variables
     *
     * @return type
     */
    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public ArrayList<Pokemon> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Pokemon> members) {
        this.members = members;
    }

    public String getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(String saveFile) {
        this.saveFile = saveFile;
    }

    //constructors
    //default and Parameterized

    public Team() {
        trainer = "No trainer yet";
        gym = "No gym yet";
    }

    public Team(String newTrainer, String newGym) {
        trainer = newTrainer;
        gym = newGym;
    }

    //adds the Pokemon made from user input and adds to the members array list
    public void addMember()
    {
        Pokemon p1 = new Pokemon();
        members.add(new Pokemon());
        p1.readInput();
    }


    //saveData will save the data given by the user into the file.
    public void saveData() {
        try {

            ObjectOutputStream binaryFileWriter = new ObjectOutputStream(new FileOutputStream(saveFile));
            binaryFileWriter.writeUTF(getGym());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    //loadData will load the data that is in the file
    public void loadData() {


        setMembers(members);
    }


    public static void main(String[] args)
    {
        if (myfile.exists())
        {
            Team t1 = new Team();
            t1.loadData();
        }
        else
        {
            Team t1 = new Team();
            t1.addMember();
        }

        Scanner kB = new Scanner(System.in);
        System.out.println("Would you like to add a member to you team? (Y/N)");

        String userInput = kB.nextLine();

        if(userInput.equalsIgnoreCase("Y"))
        {
            System.out.println("How many members would you like to add?");
            String ans = kB.nextLine();

        }
        else
        {
            Team t1 = new Team();
            t1.loadData();
        }

    }
}