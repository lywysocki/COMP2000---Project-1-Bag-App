
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.BagInterface ;
import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;

/**
 * Program that uses a dictionary bag to spell check text files
 * 
 * @author Noah Gagnon
 *
 * @version 2.0.0 2022-09-26 Final implementation
 */
public class SpellChecker
    {

    /*
     * Constants
     */
    private static final String TLCF = "the-lancashire-cotton-famine.txt" ;
    private static final String WAP = "wit-attendance-policy.txt" ;

    /**
     * Program that uses a dictionary to spell check words within specific text files
     *
     * @param args
     *     run String[] args for program
     *
     * @throws FileNotFoundException
     *     if file is corrupted, does not exist, or cannot be found
     */
    @SuppressWarnings( "resource" )
    public static void main( String[] args ) throws FileNotFoundException
        {
        TextBagger theLancashireCottonFamine =
                                        new TextBagger( new Scanner( new File( "./data/the-lancashire-cotton-famine.txt" ) ) ) ;
        TextBagger witAttendancePolicy = new TextBagger( new Scanner( new File( "./data/wit-attendance-policy.txt" ),
                                                                      "Cp1252" ) ) ;

        toPrint( TLCF,
                 theLancashireCottonFamine.getTextBag(),
                 theLancashireCottonFamine.getCorrectWordsBag(),
                 theLancashireCottonFamine.getIncorrectWordsBag() ) ;

        toPrint( WAP,
                 witAttendancePolicy.getTextBag(),
                 witAttendancePolicy.getCorrectWordsBag(),
                 witAttendancePolicy.getIncorrectWordsBag() ) ;

        }   // end main()


    /**
     * Used for formatting and printing the results of the spell check
     *
     * @param name
     *     name of text file
     * @param text
     *     bag version of text file
     * @param correct
     *     bag of correctly spelled words for text file
     * @param incorrect
     *     bag of incorrectly spelled words for text file
     */
    private static void toPrint( String name,
                                 BagInterface<String> text,
                                 BagInterface<String> correct,
                                 BagInterface<String> incorrect )
        {
        System.out.printf( "The total word count of " + name + " is: " + text.getCurrentSize() +
                           ".%n" ) ;
        System.out.printf( "The total number of correctly spelt words: " +
                           correct.getCurrentSize() + "%n" ) ;
        System.out.printf( "The list of correct words: %n" ) ;
        printBag( correct ) ;
        System.out.printf( "The total number of incorrectly spelt words: " +
                           incorrect.getCurrentSize() + "%n" ) ;
        System.out.printf( "The list of incorrect words: %n" ) ;
        printBag( incorrect ) ;
        System.out.printf( "%n%n" ) ;

        }   // end toPrint()


    /**
     * Used to print contents of a bag
     * 
     * @param aBag
     *     the bag that's contents needs to be printed
     */
    private static void printBag( final BagInterface<String> aBag )
        {
        final Object[] bagArray = aBag.toArray() ;
        for ( final Object element : bagArray )
            {
            System.out.print( element + " " ) ;

            } // end for

        System.out.println() ;

        }  // end printBag()

    }   // end class SpellChecker