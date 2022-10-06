
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.ArrayList ;

/**
 * @author Noah Gagnon
 * 
 * @version 1.0.0 2022-09-26 Initial implementation
 */
public class SpellChecker
    {

    /*
     * Constants
     */
    private static final String TLCF = "the-lancashire-cotton-famine.txt" ;
    private static final String WAP = "wit-attendance-policy.txt" ;

    /**
     * Program that uses a dictionary to spell check words within text files
     * 
     * @param args
     *     run String[] args for program
     * 
     * @throws FileNotFoundException
     *     if file does not exist, is corrupted, or cannot be found
     */
    public static void main( final String[] args ) throws FileNotFoundException
        {

        /*
         * Reading in files via Scanner, putting into ArrayLists, removing special
         * characters from files so it won't effect future comparisons
         */
        @SuppressWarnings( "resource" )
        Scanner file1 = new Scanner( new File( "./data/the-lancashire-cotton-famine.txt" ) ) ;
        Dictionary tlcfDICT = new Dictionary( file1 ) ;
        ArrayList<String> tlcfAL = tlcfDICT.getDictionary() ;
        MisspelledWords newTLCF = new MisspelledWords( tlcfAL ) ;
        tlcfAL = newTLCF.removeSpecialCharacters() ;

        @SuppressWarnings( "resource" )
        Scanner file2 = new Scanner( new File( "./data/wit-attendance-policy.txt" ), "Cp1252" ) ;
        Dictionary wapDICT = new Dictionary( file2 ) ;
        ArrayList<String> wapAL = wapDICT.getDictionary() ;
        MisspelledWords newWAP = new MisspelledWords( wapAL ) ;
        wapAL = newWAP.removeSpecialCharacters() ;

        @SuppressWarnings( "resource" )
        Scanner dictionaryTXT = new Scanner( new File( "./data/american-english-JL.txt" ),
                                             "Cp1252" ) ;
        Dictionary dictionary = new Dictionary( dictionaryTXT ) ;
        ArrayList<String> dict = dictionary.getDictionary() ;

        /*
         * Turning Arrays into bags
         */
        BagInterface<String> tlcfBag = new ResizableArrayBag<>( tlcfAL.toArray( new String[ 0 ] ) ) ;
        BagInterface<String> wapBag = new ResizableArrayBag<>( wapAL.toArray( new String[ 0 ] ) ) ;
        BagInterface<String> dictionaryBag =
                                        new ResizableArrayBag<>( dict.toArray( new String[ 0 ] ) ) ;
        BagInterface<String> correctWordsBagTLCF = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagTLCF = new ResizableArrayBag<>() ;
        BagInterface<String> correctWordsBagWAP = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagWAP = new ResizableArrayBag<>() ;

        inDictionary( tlcfAL, dictionary, correctWordsBagTLCF, incorrectWordsBagTLCF ) ;
        inDictionary( wapAL, dictionary, correctWordsBagWAP, incorrectWordsBagWAP ) ;

        toPrint( TLCF, tlcfBag, correctWordsBagTLCF, incorrectWordsBagTLCF ) ;
        toPrint( WAP, wapBag, correctWordsBagWAP, incorrectWordsBagWAP ) ;

        }   // end main()


    /**
     * Compares each word from a text file to the words in a dictionary, and sorts
     * the word into the correct bag--either the correct or incorrectly spelled bag
     * 
     * @param array
     *     Array of the text file
     * @param d
     *     dictionary of words
     * @param correct
     *     bag of correctly spelled words for text file
     * @param incorrect
     *     bag of incorrectly spelled words for text file
     */
    private static void inDictionary( ArrayList<String> array,
                                      Dictionary d,
                                      BagInterface<String> correct,
                                      BagInterface<String> incorrect )
        {
        for ( final String element : array )
            {
            if ( d.foundWord( element ) )
                {
                correct.add( element ) ;

                }

            if ( !d.foundWord( element ) && !incorrect.contains( element ) )
                {
                incorrect.add( element ) ;

                }

            }

        }   // end inDictionary()


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


    // Used to print contents of bag
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