
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> adjectives = new ArrayList<>();
        ArrayList<String> nouns = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        Band band = new Band();
        ReadFromFile(adjectives, nouns, names);
        while (true) {
          int userInput = Menu();
            switch (userInput) {
                case 1:
                    band.setBandName(RandomAdj(adjectives) + " " + RandomNoun(nouns));
                    System.out.println("Your band name: " + band.getBandName() + "\n");
                    break;
                case 2:
                    band.setBandName(ChooseBandName(adjectives, nouns));
                    System.out.println("Your band name: " + band.getBandName() + "\n");
                    break;
                case 3:
                    System.out.println("1. Generate vocalist");
                    System.out.println("2. Generate drummer");
                    System.out.println("3. Generate bass guitarist");
                    System.out.println("4. Generate electric guitarist");
                    System.out.println("5. Generate all");
                    System.out.println("0. Return to main menu");
                    int userChoice;
                    Scanner input = new Scanner(System.in);
                    userChoice = input.nextInt();
                    MemberNamesGeneration(names, band, userChoice);
                    break;
                case 4:
                    System.out.println("Your band name: " + band.getBandName() + "\n");
                    if (band.getVocalist()!=null)
                        System.out.println("Your vocalist: " + band.getVocalist() + "\n");
                    if (band.getDrummer()!=null)
                        System.out.println("Your drummer: " + band.getDrummer() + "\n");
                    if (band.getBassGuitarist()!=null)
                        System.out.println("Your bass guitarist: " + band.getBassGuitarist() + "\n");
                    if (band.getElectricGuitarist()!=null)
                        System.out.println("Your electric guitarist: " + band.getElectricGuitarist() + "\n");
                    break;
                case 5:
                    System.out.printf("Number of adjectives: "+adjectives.size()+"\n");
                    break;
                case 6:
                    System.out.printf("Number of nouns: "+nouns.size()+"\n");
                    break;
                case 7:
                    AddAdjective(adjectives);
                    System.out.println("Your value has been added \n");
                    break;
                case 8:
                    AddNoun(nouns);
                    System.out.println("Your value has been added \n");
                    break;
                case 9:
                    System.out.println("1.New band name ");
                    System.out.println("2.New member name ");
                    Scanner in = new Scanner(System.in);
                    userChoice = in.nextInt();
                    if (userChoice==1)
                    {
                        System.out.println("1.Random name");
                        System.out.println("2.Choose own name");
                        System.out.println("0.Exit");
                        userChoice = in.nextInt();
                        switch (userChoice)
                        {
                            case 1:
                                band.setBandName(RandomAdj(adjectives) + " " + RandomNoun(nouns));
                                System.out.println("Your band name: " + band.getBandName() + "\n");
                                break;
                            case 2:
                                band.setBandName(ChooseBandName(adjectives, nouns));
                                System.out.println("Your band name: " + band.getBandName() + "\n");
                                break;
                            default:
                                break;
                        }
                    }
                    else if (userChoice == 2)
                    {
                        System.out.println("1. Generate vocalist");
                        System.out.println("2. Generate drummer");
                        System.out.println("3. Generate bass guitarist");
                        System.out.println("4. Generate electric guitarist");
                        System.out.println("5. Generate all");
                        System.out.println("0. Return to main menu");
                        userChoice = in.nextInt();
                        MemberNamesGeneration(names, band, userChoice);
                    }
                    break;
                case 10:
                    GenerateBandInfoToFile(band);
                    System.out.println("File has been created \n");
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("Wrong input value");
                    break;
            }
        }
    }

    private static void MemberNamesGeneration(ArrayList<String> names, Band band, int userChoice) {
        switch (userChoice) {
            case 1:
                band.setVocalist(RandomName(names));
                System.out.println("Your vocalist: " + band.getVocalist() + "\n");
                break;
            case 2:
                band.setDrummer(RandomName(names));
                System.out.println("Your drummer: " + band.getDrummer() + "\n");
                break;
            case 3:
                band.setBassGuitarist(RandomName(names));
                System.out.println("Your bass guitarist: " + band.getBassGuitarist() + "\n");
                break;
            case 4:
                band.setElectricGuitarist(RandomName(names));
                System.out.println("Your electric guitarist: " + band.getElectricGuitarist() + "\n");
                break;
            case 5:
                ReadFromFile(names);
                band.setVocalist(RandomName(names));
                band.setDrummer(RandomName(names));
                band.setBassGuitarist(RandomName(names));
                band.setElectricGuitarist(RandomName(names));
                System.out.println("Your vocalist: " + band.getVocalist() + "\n");
                System.out.println("Your drummer: " + band.getDrummer() + "\n");
                System.out.println("Your bass guitarist: " + band.getBassGuitarist() + "\n");
                System.out.println("Your electric guitarist: " + band.getElectricGuitarist() + "\n");
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong input value");
                break;
        }
    }

    public static void ReadFromFile(ArrayList<String> adj, ArrayList<String> noun, ArrayList<String> name)
{
    Scanner s = null;
    String line = "";
    try {
        s = new Scanner(new File("Adjectives.txt")).useDelimiter("\n");
        while (s.hasNext()) {
            line = s.nextLine();
            adj.add(line);
        }
        s = new Scanner(new File("Nouns.txt")).useDelimiter("\n");
        while (s.hasNext()) {
            line = s.nextLine();
            noun.add(line);
        }
        s = new Scanner(new File("Names.txt")).useDelimiter("\n");
        while (s.hasNext()) {
            line = s.nextLine();
            name.add(line);
        }
    }

    catch (Exception error)
    {
        System.out.println("error");
        error.printStackTrace();
    }
    finally {
        if (s != null) {
            s.close();
        }
    }
}
public static void ReadFromFile(ArrayList<String> name) {
    Scanner s = null;
    String line = "";
    try{
        s = new Scanner(new File("Names.txt")).useDelimiter("\n");
        while (s.hasNext()) {
            line = s.nextLine();
            name.add(line);
        }
    }
    catch (Exception error)
    {
        System.out.println("error");
        error.printStackTrace();
    }
    finally {
        if (s != null) {
            s.close();
        }
    }
}
    public static String RandomAdj(ArrayList<String> adj)
    {
        Collections.shuffle(adj);
        String rAdj = adj.get(0);
        return rAdj;
    }
    public static String RandomNoun(ArrayList<String> noun)
    {
        Collections.shuffle(noun);
        String rNoun = noun.get(0);
        return rNoun;
    }
    public static String RandomName(ArrayList<String> name)
    {
        Collections.shuffle(name);
        String rName = name.get(0);
        name.remove(0);
        return rName;
    }
    public static String ChooseBandName(ArrayList<String> adj, ArrayList<String> noun)
    {
        int userChoice;
        String bandName;
        Scanner input = new Scanner(System.in);
        if(adj.size()>noun.size()) {
            for(int i = 0; i<adj.size();i++)
            {
                System.out.println(i+"."+adj.get(i)+" "+i+"."+noun.get(i)+"\n");
            }
        }
        else for(int i = 0; i<noun.size();i++)
        {
            System.out.println(i+"."+adj.get(i)+" "+i+"."+noun.get(i)+"\n");
        }
        System.out.println("Choose an adjective: ");
        userChoice = input.nextInt();
        bandName = adj.get(userChoice);
        System.out.println("Choose a noun: ");
        userChoice = input.nextInt();
        bandName += " "+noun.get(userChoice);
        return bandName;
    }
    public static void AddAdjective(ArrayList<String> adj) throws IOException {
        Scanner input = new Scanner(System.in);
        String newValue;
        System.out.println("Enter a new adjective: ");
        newValue = input.next();
        adj.add(newValue);
        Writer output;
        output = new BufferedWriter(new FileWriter("Adjectives.txt",true));
        output.append("\n"+newValue);
        output.close();
    }
    public static void AddNoun(ArrayList<String> noun) throws IOException {
        Scanner input = new Scanner(System.in);
        String newValue;
        System.out.println("Enter a new noun: ");
        newValue = input.next();
        noun.add(newValue);
        Writer output;
        output = new BufferedWriter(new FileWriter("Nouns.txt",true));
        output.append("\n"+newValue);
        output.close();
    }
    public static void GenerateBandInfoToFile(Band band) throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter("BandInfo.txt"));
        output.append("Your band name: " + band.getBandName() + "\n");
        if (band.getVocalist()!=null)
        output.append("Your vocalist: " + band.getVocalist() + "\n");
        if (band.getDrummer()!=null)
        output.append("Your drummer: " + band.getDrummer() + "\n");
        if (band.getBassGuitarist()!=null)
        output.append("Your bass guitarist: " + band.getBassGuitarist() + "\n");
        if (band.getElectricGuitarist()!=null)
        output.append("Your electric guitarist: " + band.getElectricGuitarist() + "\n");
        output.close();
    }
    public static int Menu(){
        int userChoice;
        Scanner input = new Scanner(System.in);

        System.out.println("1. Generate band name");
        System.out.println("2. Choose a band name");
        System.out.println("3. Generate band member name");
        System.out.println("4. View created band");
        System.out.println("5. Number of adjectives");
        System.out.println("6. Number of nouns");
        System.out.println("7. Add an adjective to list");
        System.out.println("8. Add a noun to list ");
        System.out.println("9. Regenerate a value");
        System.out.println("10. Generate band info to .txt file");
        System.out.println("0. Exit");
        userChoice = input.nextInt();
        return userChoice;
    }
}
