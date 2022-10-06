
package edu.wit.scds.ds.bag.app ;

import java.util.ArrayList ;
import java.util.Scanner ;

/**
 * dictionary with the ability to load itself, lookup its number of contents, and
 * contents
 * 
 * @author wysockil
 * 
 * @version 1.0.0 2022-09-30 Initial implementation
 */
public class Dictionary
    {

    /*
     * data fields
     */
    private ArrayList<String> dictionaryList = new ArrayList<>() ;

    /*
     * constructor
     */

    /**
     * Creates an ArrayList of words from a given text file
     * 
     * @param dictionary
     *     the dictionary text file
     */
    public Dictionary( Scanner dictionary )
        {
        while ( dictionary.hasNext() )
            {
            this.dictionaryList.add( dictionary.next() ) ;

            }

        dictionary.close() ;

        }   // end 1-arg (scanner) constructor
    
    /**
     * 
     * 
     * @return
     */
    public ArrayList<String> getDictionary()
    {
    return this.dictionaryList ;
    }


    /**
     * Tests if dictionary contains a specific word regardless of case
     * 
     * @param word
     *     The word to find
     * 
     * @return true if the word is found in the dictionary, false if not
     */
    public boolean foundWord( String word )
        {
        for ( String wrd : this.dictionaryList )
            {
            if ( word.equalsIgnoreCase( wrd ) )
                {
                return true ;

                }   // end if

            }   // end for

        return false ;

        }   // end foundWord


    /**
     * Finds size of the dictionary ArrayList
     * 
     * @return the size of the dictionary; the number of entries
     */
    public int getSize()
        {
        return this.dictionaryList.size() ;

        }

    }   // end class Dictionary
