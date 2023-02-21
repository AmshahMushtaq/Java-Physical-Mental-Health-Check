//Amshah Mushtaq and Emily Burda
//COVID-19 Physical and Mental Health Checkup

import java.io.*;

public class PhysicalAndMentalHealthCheckUp {
    public static final int HEART_SIZE = 10; //constant value

    public static void main(String[] args) throws FileNotFoundException{
        programIntroduction();
        physicalHealthCheck();
        mentalHealthCheck();
        heartGraphic();
    }

    public static void programIntroduction(){
        System.out.println("Hello! Welcome to the COVID-19 Physical and Mental Health Checkup by Amshah Mushtaq and Emily Burda. " +
                "As the COVID-19 pandemic continues to affect all facets of the world, we hope this short checkup allows you to gain " +
                "a better understanding of your physical and mental health, along with the variety of resources available to you.");
        System.out.println("\nAs a part of our physical checkup, we will start with a COVID-19 test and inform you about the " +
                "steps you should take if you are experiencing a multitude of COVID-19 related symptoms. This will be followed by a body" +
                " mass index (BMI) test to check where your physical health stands based on your height and weight. Following this, " +
                "we will conduct a mental heath checkup to test how you are doing during these difficult times and provide appropriate resources.\n\n");
    }


    public static void physicalHealthCheck() throws FileNotFoundException{
        //Amshah Mushtaq
        //This method contains all of the physical health related methods.
        covidTest();
        bodyMassIndexTest();
    }

    /*
        covidTest by Amshah Mushtaq
        The covidTest method will test the user by asking about temperature readings and COVID-19 related symptoms.
        The goal of this method is to both determine whether the user may have COVID-19 and should get tested along with  providing resources based on that result.
    */

    public static void covidTest() throws FileNotFoundException {
        System.out.println("This is a COVID-19 screening to determine whether you have symptoms and should seek medical attention.");
        System.out.println("We will begin with some basic personal information. \n");

        Scanner170 console = new Scanner170();

        System.out.print("Please enter your first name: ");
        String firstName = console.nextWord();
        firstName = firstName.toUpperCase();
        System.out.print("Please enter your last name: ");
        String lastName = console.nextWord();
        System.out.print("Please enter your date of birth (Ex. 04/08/1997): ");
        String birthDate = console.next();

        System.out.println("\nThe following questions ask about symptoms relating to COVID-19. Please answer all of the questions to the best of your ability.\n");
        System.out.print("In the past week, have you experienced a fever (Yes/No)? ");
        String fever = console.nextWord();

        int symptomCount = 0;
        double temperatureReading = 00.0;

        if (fever.equals("Yes")) {
            System.out.print("What was the last temperature reading you took? (ex: 99.8) ");
            temperatureReading = console.nextDouble();

            if (temperatureReading >= 98.6) {
                symptomCount++;

                if (temperatureReading >= 100.0) {
                    symptomCount++;
                }
            } else {
                System.out.println("\nA temperature reading below 98.6 is not considered a fever.");
                System.out.println("However, it is possible to experience fever like symptoms or headaches during this time.");
                fever = "No";
            }
            System.out.println();
        }

        System.out.print("In the past week, have you experienced any headaches (Yes/No)? ");
        String headache = console.nextWord();
        if (headache.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced coughing with or without shortness of breath (Yes/No)? ");
        String coughing = console.nextWord();
        if (coughing.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced chest congestion symptoms (Yes/No)? ");
        String chestCongestion = console.nextWord();
        if (chestCongestion.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced nasal congestion symptoms, such as a runny nose (Yes/No)? ");
        String nasalCongestion = console.nextWord();
        if (nasalCongestion.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced sore throat symptoms (Yes/No)? ");
        String soreThroat = console.nextWord();
        if (soreThroat.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced muscle aches (Yes/No)? ");
        String muscleAches = console.nextWord();
        if (muscleAches.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced difficulty breathing (Yes/No)? ");
        String difficultyBreathing = console.nextWord();
        if (difficultyBreathing.equals("Yes")) {
            symptomCount++;
        }

        System.out.print("\nIn the past week, have you experienced a decrease in taste and/or smell (Yes/No)? ");
        String lostSenses = console.nextWord();
        if (lostSenses.equals("Yes")) {
            symptomCount++;
        }

        System.out.println("\n\n" + lastName.toUpperCase() + ", " + (firstName.charAt(0)) + "\t\t\t" + birthDate + "\n");

        if ((symptomCount == 10) || ((symptomCount >= 8 && temperatureReading >= 100.0))) {
            System.out.println("High Risk\n");

            File highRisk = new File("C:\\COMP170\\IntelliJ Java Programs\\highRisk.txt");
            Scanner170 input = new Scanner170(highRisk);

            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }

        }else if((symptomCount >= 3 && (temperatureReading >= 98.6)) ||(symptomCount >= 4)){
            System.out.println("Medium Risk\n");

            File mediumRisk = new File("C:\\COMP170\\IntelliJ Java Programs\\mediumRisk.txt");
            Scanner170 input = new Scanner170(mediumRisk);

            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }

        }else{
            System.out.println("Low Risk\n");

            File lowRisk = new File("C:\\COMP170\\IntelliJ Java Programs\\lowRisk.txt");
            Scanner170 input = new Scanner170(lowRisk);

            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
        }
        System.out.println("\nSymptom Report for " + firstName + " " + lastName.toUpperCase() + "\n");
        System.out.println("Fever:                " + fever.toUpperCase());
        System.out.println("Headache:             " + headache.toUpperCase());
        System.out.println("Cough:                " + coughing.toUpperCase());
        System.out.println("Chest Congestion:     " + chestCongestion.toUpperCase());
        System.out.println("Nasal Congestion:     " + nasalCongestion.toUpperCase());
        System.out.println("Sore Throat:          " + soreThroat.toUpperCase());
        System.out.println("Muscle Ache:          " + muscleAches.toUpperCase());
        System.out.println("Difficulty Breathing: " + difficultyBreathing.toUpperCase());
        System.out.println("Loss of Taste/Smell:  " + lostSenses.toUpperCase());
        System.out.println();
    }

     /*
        bodyMassIndexTest by Amshah Mushtaq
        The bodyMassIndexTest method will calculate the user's body mass index (BMI) in order to check the user's health. Based on the results, the program will
        advise the user to reach out to medical professionals in order to improve health.
     */

    public static void bodyMassIndexTest(){
        System.out.println("The next series of questions will identify your body mass index (BMI)."
                + " BMI is generally used to indicate whether a person has a healthy weight based on their height.");
        System.out.println("\n***Please be aware that this is a general indicator and official testing or diagnosing should be " +
                "made by a licensed health professional, such as your primary physician.***");
        System.out.println("\nPlease answer the following questions to the best of your ability.\n");

        //BMI is kg/m^2
        Scanner170 console = new Scanner170();

        System.out.print("How many pounds do you weigh? ");
        double poundsWeight = console.nextDouble();

        double kilogramsWeight = poundsWeight / 2.205;

        System.out.println("\nPlease enter your height. First enter how many feet tall you are and then enter the remaining inches.");
        System.out.print("Feet: ");
        double feetHeight = console.nextDouble();
        System.out.print("Inches: ");
        double remainingHeightInches = console.nextDouble();

        double userHeightInches = (feetHeight * 12) + remainingHeightInches;
        double userHeightMeters = userHeightInches / 39.37;
        double bodyMassIndex = (kilogramsWeight) / (userHeightMeters * userHeightMeters);

        System.out.printf("\nYour BMI is %.2f.\n", bodyMassIndex);

        System.out.print("According to your BMI, ");

        if (bodyMassIndex > 30){
            System.out.println("you are considered obese.");
        }else if (bodyMassIndex > 25 && bodyMassIndex <= 30){
            System.out.println("you are considered overweight.");
        }else if (bodyMassIndex > 18.5 && bodyMassIndex <= 25){
            System.out.println("your body weight is considered normal.");
        }else if (bodyMassIndex > 16 && bodyMassIndex <= 18.5){
            System.out.println("you are considered underweight.");
        }else{
            System.out.println("you are considered severely underweight.");
        }
        System.out.println();
        System.out.println("This categorization is based on BMI recommendations by the World Health Organization (WHO) " +
                "for people of all genders age 18 and older. It is important to note that this measurement is solely an indicator and " +
                "further discussion with a healthcare provider is highly encouraged.\n");

        if(bodyMassIndex > 25){
            System.out.println("There are many risks associated with being overweight or obese. According to the " +
                    "Centers for Disease Control and Prevention, some risk are high blood pressure, high cholesterol, " +
                    "type two diabetes, stroke, and certain cancers. Generally, it is recommended to maintain a BMI of less than 25. " +
                    "Ideally, you should speak with your healthcare provider to determine whether you should make any changes to improve your health.");
        }
        if(bodyMassIndex <= 18.5){
            System.out.println("There are many risks associated with being underweight. According to the " +
                    "Centers for Disease Control and Prevention, some risks are malnutrition, vitamin deficiencies, anemia, development " +
                    "issues, and hormonal imbalances. Generally, it is recommended to maintain a BMI of greater than 18.5. " +
                    "Ideally, you should speak with your healthcare provider to determine whether you should make any changes to improve your health.");
        }
        System.out.println();
    }

    /*mentalHealthCheck by Emily Burda
        this method asks the user 10 questions relating to mental health
        the executed if statements add up the user's answers to create their mental health score
        the program then prints out a specific file depending on that score
        if the score is low, this indicates a good mental health
        if the score is high, this indicates a potential mental health illness
        one file either provides a motivational message and access to resources (for the high score)
        the other file provides ways to help others who struggle with mental health and access to resources (for the low score)
     */

    public static void mentalHealthCheck() throws FileNotFoundException {
        Scanner170 console = new Scanner170(System.in);
        int input = 0;                                        //sets input sum to 0
        System.out.println("Now we will go through a Mental Health Check-Up!\n Please answer on a scale of 1-5\n" +        //introductory statement for the mental health checkup
                "1 = strongly disagree\n2 = disagree\n3 = neither agree nor disagree\n4 = agree\n5 = strongly agree\n");
        System.out.println("I have irregular bed times and getting up times, and I have not been getting quality sleep.");    //question 1
        int output = console.nextInt();                                                                                    //the user input is names as the variable output
        if (!(output == 0)) {                                                                                            //if statement that executes if the user output is not equal to 0
            input += output;                                                                                            //add user output to input sum
            System.out.println("I have been isolating myself from family or coworkers.");                                //repeat the above 4 lines
            int output2 = console.nextInt();
            if (!(output2 == 0)) {
                input += output2;
                System.out.println("I have more worries or anxieties than usual.");
                int output3 = console.nextInt();
                if (!(output3 == 0)) {
                    input += output3;
                    System.out.println("I have lost interest in activities that usually hold my attention.");
                    int output4 = console.nextInt();
                    if (!(output4 == 0)) {
                        input += output4;
                        System.out.println("I do not feel at ease with myself and my surroundings.");
                        int output5 = console.nextInt();
                        if (!(output5 == 0)) {
                            input += output5;
                            System.out.println("I feel more sad than happy lately.");
                            int output6 = console.nextInt();
                            if (!(output6 == 0)) {
                                input += output6;
                                System.out.println("My life does not feel balanced between work, fun, friends, \nfamily, self-care, exercise, and other meaningful pursuits.");
                                int output7 = console.nextInt();
                                if (!(output7 == 0)) {
                                    input += output7;
                                    System.out.println("I have trouble concentrating.");
                                    int output8 = console.nextInt();
                                    if (!(output8 == 0)) {
                                        input += output8;
                                        System.out.println("I have significant mood swings, crying, and depressive thoughts.");
                                        int output9 = console.nextInt();
                                        if (!(output9 == 0)) {
                                            input += output9;
                                            System.out.println("My appetite and eating habits have changed drastically recently."); //last question
                                            int output10 = console.nextInt();
                                            if (!(output10 == 0)) {
                                                input += output10;
                                                int mentalHealthScore = input;                                                        //renames total input as mentalHealthScore
                                                if (mentalHealthScore > 30 && mentalHealthScore <= 50) {                            //prints out specific statement if score is high
                                                    File highScore = new File("C:\\COMP170\\IntelliJ Java Programs\\highScore.txt");
                                                    Scanner170 file = new Scanner170(highScore);                                    //file provides information about resources
                                                    while (file.hasNextLine()) {
                                                        System.out.println(file.nextLine());
                                                    }

                                                } else if (mentalHealthScore <= 30 && mentalHealthScore > 0) {                        //prints out specific statement if score is low
                                                    File lowScore = new File("C:\\COMP170\\IntelliJ Java Programs\\lowScore.txt");
                                                    Scanner170 file = new Scanner170(lowScore); //file provides some info about resources but also how to help friends with mental illnesses
                                                    while (file.hasNextLine()) {
                                                        System.out.println(file.nextLine());
                                                    }

                                                } else {
                                                    throw new IllegalArgumentException("Score is too high or too low.");
                                                }            //throw exception if score is below 0 or above 50
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void heartGraphic(){
        //this method prints a graphic with the words "Thank You!" inside of a heart made of asterisks and spaces
        System.out.println("\n\nThank you for participating in the COVID-19 Physical and Mental Health Check Up!\n\n");

        String message = " Thank You! ";								//this message is printed inside the heart
        for (int line = 0; line < HEART_SIZE - 2; line++) {				//for loop that prints top of the heart
            for (int j = 0; j <= 4 * HEART_SIZE; j++) {
                double d1 = Math.sqrt(Math.pow(line - HEART_SIZE, 2) + Math.pow(j - HEART_SIZE, 2));	//equation for left top side of the heart; first part controls height, second part control width
                double d2 = Math.sqrt(Math.pow(line - HEART_SIZE, 2) + Math.pow(j - 3 * HEART_SIZE, 2));//equation for right top side of the heart; first part controls height, second part controls width

                if (d1 < HEART_SIZE + 1.0 || d2 < HEART_SIZE + 1.0) {	//prints out asterisks and spaces for the top half of the heart
                    System.out.print("*");
                } else {
                    System.out.print(" ");								//prints spaces between the two top sides of the heart
                }
            }
            System.out.print(System.lineSeparator());					//prints the top rows of asterisks on new lines
        }

        for (int i = 1; i < 4 * HEART_SIZE; i++) {
            for (int j = 0; j < i; j++) {								//adds an increasing amount of spaces the the left side of the heart before each row of asterisks
                System.out.print(" ");									//centers heart by adding spaces to the left side
            }

            for (int j = 1; j < 4 * HEART_SIZE + 1 - 2 * i; j++) {		//makes the bottom half of the heart even
                if (i >= 2 && i <= 4) {									//has to be greater or equal to 2 and less or equal to 4
                    int idx = j - (4 * HEART_SIZE - 2 * i - message.length()) / 2;	//centers the message in the middle of the heart using message length and constant
                    if (idx < message.length() && idx >= 0) {			//has to be less than message length and greater or equal to 0
                        if (i == 3) {
                            System.out.print(message.charAt(idx));		//prints message in the middle of the heart on the middle line of the spaces
                        } else {
                            System.out.print(" ");						//prints correctly aligned spaces above and below the message
                        }
                    } else {
                        System.out.print("*");							//prints asterisks around the message
                    }
                } else {
                    System.out.print("*");								//prints bottom of heart below the message as the for loop and if statements execute
                }
            }
            System.out.print(System.lineSeparator());					//prints lines of asterisks of bottom of heart on new lines
        }
    }
}



