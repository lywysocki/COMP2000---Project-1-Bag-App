
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.BagInterface ;
import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;

import java.util.Scanner ;

/**
 * dictionary with the ability to load itself, lookup its contents, and return its
 * contents
 *
 * @author Laura Wysocki
 *
 * @version 2.0.0 2022-09-30 Final implementation
 */
public class Dictionary
    {

    /*
     * data fields
     */
    private BagInterface<String> dictionaryList = new ResizableArrayBag<>() ;

    /*
     * constructor
     */

    /**
     * Creates a ResizableArrayBag of words from a given dictionary text file
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
     * Tests if dictionary contains a specific word regardless of case
     *
     * @param word
     *     The word to find
     *
     * @return true if the word is found in the dictionary, false if not
     */
    public boolean foundWord( String word )
        {
        return this.dictionaryList.contains( word ) ||
               this.dictionaryList.contains( word.toLowerCase() ) ;

        }   // end foundWord()

    }   // end class Dictionary
