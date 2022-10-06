
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;
import edu.wit.scds.ds.bag.BagInterface ;
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.ArrayList ;
import java.util.List ;

/**
 * @author gagnonn2
 * 
 * @version 1.0.0 2022-09-26 Initial implementation
 */
public class SpellChecker
    {
    /*
     * Constants
     */
    
    
    
    /*
     * data fields
     */

    /**
     * 
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main( final String[] args ) throws FileNotFoundException
        {
        // Creates scanner for both text files

        // Added Cp1252 to file2 as scanner was not reading entire file, solution I
        // found online said to change character encoding
        Scanner file1 = new Scanner( new File( "./data/the-lancashire-cotton-famine.txt" ) ) ;
        Dictionary tlcfDICT = new Dictionary(file1) ;
        ArrayList<String> tlcfAL = tlcfDICT.getDictionary() ;
        MisspelledWords newTLCF = new MisspelledWords(tlcfAL) ;
        tlcfAL = newTLCF.removeSpecialCharacters() ;
        
        
        Scanner file2 = new Scanner( new File( "./data/wit-attendance-policy.txt" ), "Cp1252" ) ;
        Dictionary wapDICT = new Dictionary(file2) ;
        ArrayList<String> wapAL = wapDICT.getDictionary() ;
        MisspelledWords newWAP = new MisspelledWords(wapAL) ;
        wapAL = newWAP.removeSpecialCharacters() ;
        
        
        Scanner dictionaryTXT = new Scanner( new File( "./data/american-english-JL.txt" ), "Cp1252" ) ;
        Dictionary dictionary = new Dictionary(dictionaryTXT) ;
        ArrayList<String> dict = dictionary.getDictionary() ;
        String[] dictionaryArray = dict.toArray( new String[ 0 ] ) ;

        // Turning Arrays into bags
        // BagInterface<String> file1Bag = new ResizableArrayBag<>( file1Array ) ;
        // BagInterface<String> file2Bag = new ResizableArrayBag<>( file2Array ) ;
        BagInterface<String> dictionaryBag = new ResizableArrayBag<>( dictionaryArray ) ;
        BagInterface<String> correctWordsBagFile1 = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagFile1 = new ResizableArrayBag<>() ;
        BagInterface<String> correctWordsBagFile2 = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagFile2 = new ResizableArrayBag<>() ;

        // Checking if words appear in dictionary for file1
        for (String element : tlcfAL)
            {
            if (  dictionary.foundWord( element ) )
                {
                correctWordsBagFile1.add( element ) ;

                }

            if ( !dictionaryBag.contains( element ) &&
                 ( !dictionaryBag.contains( element.toLowerCase() ) &&
                   ( !incorrectWordsBagFile1.contains( element ) ) &&
                   ( !incorrectWordsBagFile1.contains( element.toLowerCase() ) ) ) )
                {
                incorrectWordsBagFile1.add( element ) ;

                }

            }

        // Checking if words appear in dictionary for file2
        for ( String element : wapAL )
            {
            if ( dictionary.foundWord( element ) )
                {
                correctWordsBagFile2.add( element ) ;
                }


            if ( !dictionaryBag.contains( element ) &&
                 ( !dictionaryBag.contains( element.toLowerCase() ) &&
                   ( !incorrectWordsBagFile2.contains( element ) ) &&
                   ( !incorrectWordsBagFile2.contains( element.toLowerCase() ) ) ) )
                {
                incorrectWordsBagFile2.add( element ) ;

                }

            }

        // Printing results
        System.out.println( "The total word count of the-lancashire-cotton-famine.txt is " +
                                        tlcfAL.size() + "." ) ;
        System.out.println( "The total number of correctly spelt words: " +
                            correctWordsBagFile1.getCurrentSize() ) ;
        System.out.println( "The list of correct words: " ) ;
        printBag( correctWordsBagFile1 ) ;
        System.out.println( "The total number of incorrectly spelt words: " +
                            incorrectWordsBagFile1.getCurrentSize() ) ;
        System.out.println( "The list of incorrect words: " ) ;
        printBag( incorrectWordsBagFile1 ) ;
        System.out.println() ;

        System.out.println( "The total word count of wit-attendance-policy.txt is " +
                                        wapAL.size() + "." ) ;
        System.out.println( "The total number of correctly spelt words: " +
                            correctWordsBagFile2.getCurrentSize() ) ;
        System.out.println( "The list of correct words: " ) ;
        printBag( correctWordsBagFile2 ) ;
        System.out.println( "The total number of incorrectly spelt words: " +
                            incorrectWordsBagFile2.getCurrentSize() ) ;
        System.out.println( "The list of incorrect words: " ) ;
        printBag( incorrectWordsBagFile2 ) ;

        }


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