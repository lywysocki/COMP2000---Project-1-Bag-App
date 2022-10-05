
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

    public static void main( final String[] args ) throws FileNotFoundException
        {
        // Creates scanner for both text files

        // Added Cp1252 to file2 as scanner was not reading entire file, solution I
        // found online said to change character encoding
        Scanner file1 = new Scanner( new File( "./data/the-lancashire-cotton-famine.txt" ) ) ;
        Scanner file2 = new Scanner( new File( "./data/wit-attendance-policy.txt" ), "Cp1252" ) ;
        Scanner dictionary = new Scanner( new File( "./data/american-english-JL.txt" ), "Cp1252" ) ;

        // Creating Arraylist of strings for both files
        List<String> file1List = new ArrayList<String>() ;
        List<String> file2List = new ArrayList<String>() ;
        List<String> dictionaryList = new ArrayList<String>() ;

        // Reading both files and adding contents to ArrayList
        while ( file1.hasNext() )
            {
            file1List.add( file1.next() ) ;

            }

        while ( file2.hasNext() )
            {
            file2List.add( file2.next() ) ;

            }

        while ( dictionary.hasNext() )
            {
            dictionaryList.add( dictionary.next() ) ;

            }

        // Turning arrayList into arrays
        String[] file1Array = file1List.toArray( new String[ 0 ] ) ;
        String[] file2Array = file2List.toArray( new String[ 0 ] ) ;
        String[] dictionaryArray = dictionaryList.toArray( new String[ 0 ] ) ;

        for ( int i = 0 ; i < file1Array.length ; i++ )
            {
            file1Array[ i ] = file1Array[ i ].replaceAll( "[.,;]", "" ) ;

            }
        
        for ( int i = 0 ; i < file2Array.length ; i++ )
            {
            file2Array[ i ] = file2Array[ i ].replaceAll( "[.,;]", "" ) ;

            }

        // Turning Arrays into bags
        // BagInterface<String> file1Bag = new ResizableArrayBag<>( file1Array ) ;
        // BagInterface<String> file2Bag = new ResizableArrayBag<>( file2Array ) ;
        BagInterface<String> dictionaryBag = new ResizableArrayBag<>( dictionaryArray ) ;
        BagInterface<String> correctWordsBagFile1 = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagFile1 = new ResizableArrayBag<>() ;
        BagInterface<String> correctWordsBagFile2 = new ResizableArrayBag<>() ;
        BagInterface<String> incorrectWordsBagFile2 = new ResizableArrayBag<>() ;

        // Checking if words appear in dictionary for file1
        for ( int i = 0 ; i < file1Array.length ; i++ )
            {
            if ( dictionaryBag.contains( file1Array[ i ] ) ||
                 ( dictionaryBag.contains( file1Array[ i ].toLowerCase() ) ) )
                {
                correctWordsBagFile1.add( file1Array[ i ] ) ;

                }

            if ( !dictionaryBag.contains( file1Array[ i ] ) &&
                 ( !dictionaryBag.contains( file1Array[ i ].toLowerCase() ) &&
                   ( !incorrectWordsBagFile1.contains( file1Array[ i ] ) ) &&
                   ( !incorrectWordsBagFile1.contains( file1Array[ i ].toLowerCase() ) ) ) )
                {
                incorrectWordsBagFile1.add( file1Array[ i ] ) ;

                }

            }
        
        // Checking if words appear in dictionary for file2
        for ( int i = 0 ; i < file2Array.length ; i++ )
            {
            if ( dictionaryBag.contains( file2Array[ i ] ) ||
                 ( dictionaryBag.contains( file2Array[ i ].toLowerCase() ) ) )
                {
                correctWordsBagFile2.add( file2Array[ i ] ) ;

                }

            if ( !dictionaryBag.contains( file2Array[ i ] ) &&
                 ( !dictionaryBag.contains( file2Array[ i ].toLowerCase() ) &&
                   ( !incorrectWordsBagFile2.contains( file2Array[ i ] ) ) &&
                   ( !incorrectWordsBagFile2.contains( file2Array[ i ].toLowerCase() ) ) ) )
                {
                incorrectWordsBagFile2.add( file2Array[ i ] ) ;

                }

            }

        System.out.println( "The total word count of the-lancashire-cotton-famine.txt is " +
                            file1Array.length + "." ) ;
        System.out.println( "The list of correct words: " ) ;
        printBag( correctWordsBagFile1 ) ;
        System.out.println( "The list of incorrect words: " ) ;
        printBag( incorrectWordsBagFile1 ) ;
        System.out.println() ;
        
        System.out.println( "The total word count of wit-attendance-policy.txt is " +
                            file2Array.length + "." ) ;
        System.out.println( "The list of correct words: " ) ;
        printBag( correctWordsBagFile2 ) ;
        System.out.println( "The list of incorrect words: " ) ;
        printBag( incorrectWordsBagFile2 ) ;

        }


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