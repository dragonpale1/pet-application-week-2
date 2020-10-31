//CSC 422
//11/1/2020
package petapplication;

import java.util.Scanner;
import java.util.ArrayList;

class Pet
{

    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String _name)
    {
        this.name = _name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int _age)
    {
        this.age = _age;
    }
}

public class PetApplication
{

    //data is global
    private static ArrayList<Pet> allPets;
    private static Scanner scanner;
    private static String clearDelimiter = null;

    public static void main(String[] args)
    {
        //misc initializations
        allPets = new ArrayList<Pet>();
        // scanner
        scanner = new Scanner(System.in);

        //sample items
        Pet first = new Pet();
        first.setAge(4);
        first.setName("Clunky");
        Pet second = new Pet();
        second.setAge(3);
        second.setName("Oppa");
        allPets.add(first);
        allPets.add(second);

        //start the UI
        // infinite program loop
        boolean programActive = true;
        System.out.print("Starting Pet Database program.\n");

        while (programActive)
        {
            //menu
            System.out.print("\nWhat would you like to do?"
                    + "\n\t1) View all pets."
                    + "\n\t2) Add more pets."
                    + "\n\t3) Update an existing pet."
                    + "\n\t4) Remove an existing pet."
                    + "\n\t5) Search pets by name."
                    + "\n\t6} Search pets by age."
                    + "\n\t7) Exit program."
                    + "\nYour choice: ");

            int userChoice = scanner.nextInt();

            switch (userChoice)
            {
                case 1:
                    ShowAll();
                    break;
                case 2:
                    AddPet();
                    break;
                case 3:
                    //UpdatePet();
                    break;
                case 4:
                    //RemovePet();
                    break;
                case 5:
                    //SearchPetByName();
                    break;
                case 6:
                    //SearchPetByAge();
                    break;
                case 7:
                    programActive = false;
                    System.out.println("Goodbye.\n");
                    break;
            }
        }

        scanner.close();
    }//end main method

    //functions
    public static void ShowAll()
    {
        int i;
        GenerateHeaderLine();
        for (i = 0; i < allPets.size(); i++)
        {
            Print(i, allPets.get(i));
        }
        GenerateCloseLine(i);
    }

    public static void Print(int index, Pet item)
    {
        System.out.printf("\n| %3d | %-10s | %4d |", index, item.getName(), item.getAge());
    }

    public static void GenerateHeaderLine()
    {
        System.out.printf("\n+-------------------------+\n");
        System.out.printf("| %3s | %-10s | %4s |", "ID", "Name", "Age");
        System.out.printf("\n+-------------------------+");
    }

    public static void GenerateCloseLine(int totalCount)
    {
        System.out.printf("\n+-------------------------+\n");
        System.out.printf("%-1d rows in set\n", totalCount);
    }

    public static void AddPet()
    {
        boolean loopIsActive = true;

        int petAge = 0;
        int petCount = 0;
        String userResponse;
        String petName;

        //initiate loop
        while (loopIsActive)
        {
            scanner = new Scanner(System.in);

            //clear last loop values
            petAge = 0;
            petName = "";
            //initiate request
            System.out.print("add pet using format: name <space> age:");

            //get user input
            userResponse = scanner.nextLine();

            //looks like the word "done" triggers the end of the loop
            if (userResponse.compareTo("done") != 0)
            {
                String[] data = userResponse.split(" ");

                petName = data[0];
                petAge = Integer.parseInt(data[1]);

                Pet newPet = new Pet();
                newPet.setName(petName);
                newPet.setAge((petAge));
                allPets.add(newPet);
            } else
            {
                loopIsActive = false;
            }
        }
    }

}
