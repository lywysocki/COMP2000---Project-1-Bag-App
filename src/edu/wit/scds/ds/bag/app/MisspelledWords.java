
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;

import java.util.ArrayList ;

/**
 * return misspelled words, words correctly spelled both with and without punctuation
 * 
 * @author wysockil
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
     * Creates an array of words that needs to be checked
     * 
     * @param oldArray
     *     the initial array
     */
    public MisspelledWords( ArrayList<String> oldArray )
        {
        this.array = oldArray ;

        }


    public ArrayList<String> removeSpecialCharacters()
        {
        for (String word : this.array)
            {
            word = word.replaceAll(  "[.,;]", "") ;
            }

        }

    }   // end class MisspelledWords