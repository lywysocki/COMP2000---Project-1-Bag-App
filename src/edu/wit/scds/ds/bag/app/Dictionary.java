
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Scanner ;

import java.io.File ;

import java.io.FileNotFoundException ;

/**
 * dictuion ary = loading itself & word lopokup
 */

/**
 * dictionary with the ability to both load itself and lookup its cotnents
 * 
 * @author wysockil
 * 
 * @version 1.0.0 2022-09-30 Initial implementation
 */
public class Dictionary
    {
    /*
     * constants
     */
    Scanner dictionary = new Scanner( new File( "./data/american-english-JL.txt" ), "Cp1252" ) ;

    /*
     * data fields
     */
    private List<String> dictionaryList = new ArrayList<String>() ;

    /**
     * adds word to dictionary
     * 
     * @param word
     *     the word needed to be added to dictionary
     */
    public void addWord( String word )
        {
        this.dictionaryList.add( word ) ;

        }   // end addWord()


    public boolean findWord( String word )
        {
        

        }   // end findWord

    }   // end class Dictionary
