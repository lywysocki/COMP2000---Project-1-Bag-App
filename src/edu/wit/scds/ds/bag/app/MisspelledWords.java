
package edu.wit.scds.ds.bag.app ;

/**
 * return misspelled words, words correctly spelled both with and without punctuation
 *
 * @author Laura Wysocki
 *
 * @version 1.0.0 2022-09-30 Initial implementation
 */
public class MisspelledWords
    {

    
    /**
     * removes special characters like . , ; from the array
     * @param word 
     *
     * @return an array without the characters . , ; throughout it
     */
    public static String removeSpecialCharacters(String word)
        {
            if ( word.contains( "." ) )
                {
                word = word.replaceAll( ".", "" ) ;

                }
            else if ( word.contains( "," ) )
                {
                word = word.replaceAll( ",", "" ) ;

                }
            else if ( word.contains( ";" ) )
                {
                word = word.replaceAll( ";", "" ) ;

                }

        return word ;

        }   // end removeSpecialCharacters

    }   // end class MisspelledWords