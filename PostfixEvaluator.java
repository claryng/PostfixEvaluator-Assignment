/**
 * This class contains main method for testing Evaluator
 * @author Clary Nguyen
 * @version 4/4/2022
 */
import java.io.*;
import java.util.Scanner;

public class PostfixEvaluator{
        //Main method
    public static void main(String[] args) throws FileNotFoundException {
        //file handling
        File infile = new File(args[0]);
        Scanner dataIn = new Scanner(infile);
        String expression;
        //print out the expressions and evaluate until the end of file
        while(dataIn.hasNext()){
            expression = dataIn.nextLine();
            System.out.println(expression);
            //create the Evaluator object
            Evaluator evaluator = new Evaluator(expression);
            //evaluate the expression
            evaluator.readExpression();
            System.out.println(evaluator.getStack());
        }
        //close the Scanner object
        dataIn.close();
    }
}