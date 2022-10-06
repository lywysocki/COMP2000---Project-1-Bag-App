
package edu.wit.scds.ds.bag.app ;

import java.util.ArrayList ;

/**
 * return misspelled words, words correctly spelled both with and without punctuation
 * 
 * @author Laura Wysocki
 * 
 * @version 1.0.0 2022-09-30 Initial implementation
 */
public class MisspelledWords
    {

    /*
     * Data fields
     */
    private ArrayList<String> array = new ArrayList<>() ;

    /**
     * Creates an array of words that needs to be checked for spelling
     * 
     * @param oldArray
     *     the initial array
     */
    public MisspelledWords( ArrayList<String> oldArray )
        {
        this.array = oldArray ;

        }   // end 1-arg (ArrayList) constructor


    /**
     * removes special characters like . , ; from the array
     * 
     * @return an array without the characters . , ; throughout it
     */
    public ArrayList<String> removeSpecialCharacters()
        {
        ArrayList<String> newArray = new ArrayList<>() ;
        for ( String word : this.array )
            {
            if ( word.contains( "." ) )
                {
                word = word.replaceAll( ".", "" ) ;
                newArray.add( word ) ;

                }
            else if ( word.contains( "," ) )
                {
                word = word.replaceAll( ",", "" ) ;
                newArray.add( word ) ;

                }
            else if ( word.contains( ";" ) )
                {
                word = word.replaceAll( ";", "" ) ;
                newArray.add( word ) ;

                }
            else
                {
                newArray.add( word ) ;

                }

            }

        return newArray ;

        }   // end removeSpecialCharacters

    }   // end class MisspelledWords