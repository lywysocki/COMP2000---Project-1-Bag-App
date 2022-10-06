
package edu.wit.scds.ds.bag.app ;

import edu.wit.scds.ds.bag.BagInterface ;
import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;

/**
 * Sorts words from text files into bags based on if the word is correctly spelled
 * 
 * @author Laura Wysocki
 * 
 * @version 1.0.0 2022-10-06 Initial implementation
 */
public class TextBagger
    {

    /*
     * data fields
     */
    private BagInterface<String> correctWordsBag = new ResizableArrayBag<>() ;
    private BagInterface<String> incorrectWordsBag = new ResizableArrayBag<>() ;
    private BagInterface<String> textBag = new ResizableArrayBag<>() ;

    /**
     * Takes in a text file via Scanner, removes special characters (ex. . , ;), adds
     * words to specific bags based on if it matches a word from the dictionary, and
     * houses words in a bag
     * 
     * @param textFile
     *     text file that needs to be spell checked
     * 
     * @throws FileNotFoundException
     *     if file is corrupted, does not exist, or cannot be found
     */
    public TextBagger( Scanner textFile ) throws FileNotFoundException
        {
        @SuppressWarnings( "resource" )
        Dictionary dictionary = new Dictionary( new Scanner( new File( "./data/american-english-JL.txt" ),
                                                             "Cp1252" ) ) ;
        while ( textFile.hasNext() )
            {
            String word = textFile.next() ;

            if ( word.contains( "." ) )
                {
                word = word.replaceAll( ".", "" ) ;

                }   // end if()
            else if ( word.contains( "," ) )
                {
                word = word.replaceAll( ",", "" ) ;

                }   // end else if()
            else if ( word.contains( ";" ) )
                {
                word = word.replaceAll( ";", "" ) ;

                }   // end else if()

            if ( dictionary.foundWord( word ) )
                {
                this.correctWordsBag.add( word ) ;

                }   // end if()

            if ( !dictionary.foundWord( word ) && !this.incorrectWordsBag.contains( word ) )
                {
                this.incorrectWordsBag.add( word ) ;

                }   // end if()

            this.textBag.add( word ) ;

            }

        textFile.close() ;

        }   // end SpellChecker()


    /**
     * Gets the textBag bag
     * 
     * @return a bag whose elements consist of the words from the text file
     */
    public BagInterface<String> getTextBag()
        {
        return this.textBag ;

        }   // end getTextBag()


    /**
     * Gets the getCorrectWordsBag bag
     * 
     * @return a bag whose elements consists of correctly spelled words from the text
     *     file
     */
    public BagInterface<String> getCorrectWordsBag()
        {
        return this.correctWordsBag ;

        }   // end getCoorrectWordsBag()


    /**
     * Gets the getIncorrectWordsBag bag
     * 
     * @return a bag whose elements consists of incorrectly spelled words from the
     *     text file
     */
    public BagInterface<String> getIncorrectWordsBag()
        {
        return this.incorrectWordsBag ;

        }   // end getIncorrectWordsBag()

    }

// end class Printing