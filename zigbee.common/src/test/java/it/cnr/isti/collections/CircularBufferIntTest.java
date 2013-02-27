/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package it.cnr.isti.collections;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0 - Revision 62
 *
 */
public class CircularBufferIntTest {

    private static final Logger logger = LoggerFactory.getLogger( CircularBufferIntTest.class );

    
    /**
     * Test constructors
     * <ul>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#CircularBufferInt(int[], int, boolean)}</li>
     * </ul>
     */
    @Test
    public void testCircularBuffer() {
        int[] dataSetFull = new int[]{ 2, 4, 6, 8, 10, 1, 3, 5, 7, 9 };
        final int SIZE = 5; 
        CircularBufferInt bufferSmall = new CircularBufferInt( dataSetFull.length / 2, true );
        CircularBufferInt bufferBig = new CircularBufferInt( dataSetFull.length , true );
        for ( int i = 0; i < dataSetFull.length; i++ ) {
            bufferSmall.add( dataSetFull[i] );
            bufferBig.add( dataSetFull[i] );
        }
        try{
            CircularBufferInt wrong = new CircularBufferInt(bufferBig.toArray(), 1, false);
            fail("Expected IndexOutOfBoundsException exception");
        }catch(Exception ex){
            assertEquals( 
                "Expexceted exception", IndexOutOfBoundsException.class.getName(), ex.getClass().getName() 
            );
        }
        
        CircularBufferInt single;
        single = new CircularBufferInt(bufferBig.toArray(), 1, true);
        assertEquals( single.get( 0 ), bufferBig.get( bufferBig.size() - 1 ) );
        single = new CircularBufferInt(bufferSmall.toArray(), 1, true);
        assertEquals( single.get( 0 ), bufferSmall.get( bufferSmall.size() - 1 ) );
        
        for ( int j = 0; j < 3; j++ ) {
            bufferBig.remove();
            bufferSmall.remove();
        }
        
        int[] fourData = new int[]{ 7, 9 };
        int[] nineData = new int[]{ 8, 10, 1, 3, 5, 7, 9 };
        CircularBufferInt four = new CircularBufferInt(bufferSmall.toArray(), 5, false);
        for ( int i = 0; i < fourData.length; i++ ) {
            assertEquals( fourData[i], four.get( i ) );
        }
        CircularBufferInt nine = new CircularBufferInt(bufferBig.toArray(), 9, false);
        for ( int i = 0; i < nineData.length; i++ ) {
            assertEquals( nineData[i], nine.get( i ) );
        }
    }

    /**
     * Test methods 
     * <ul>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#isEmpty()}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#isFull()}</li>
     * </ul>
     */
    @Test
    public void testIsEmpty_IsFull() {
        CircularBufferInt buffer = new CircularBufferInt( 5, true );
        assertFalse( "new CircularBufferInt is not full", buffer.isFull() );
        assertTrue( "new CircularBufferInt is not empty", buffer.isEmpty() );
        buffer.add( 5 );
        buffer.add( 1 );
        buffer.add( 0 );
        buffer.add( 2 );
        buffer.add( 4 );
        assertTrue( "CircularBufferInt with 5 elements out of 5 is full", buffer.isFull() );
        assertTrue( "CircularBufferInt with 3 elements out of 32 is empty", !buffer.isEmpty() );
    }


    /**
     * Test for Exception of the methods 
     * <ul>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#add(int)}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#get(int)}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#remove()}</li>
     * </ul>
     */
    @Test
    public void testException() {
        CircularBufferInt buffer = new CircularBufferInt( 5, false );
        try{
            buffer.remove();
            fail("Expected IndexOutOfBoundsException exception");
        }catch(Exception ex){
            assertEquals( 
                "Expexceted exception", IndexOutOfBoundsException.class.getName(), ex.getClass().getName() 
            );
        }
        try{
            buffer.get(0);
            fail("Expected IndexOutOfBoundsException exception");
        }catch(Exception ex){
            assertEquals( 
                "Expexceted exception", IndexOutOfBoundsException.class.getName(), ex.getClass().getName() 
            );
        }
        try{
            buffer.get(-1);
            fail("Expected IndexOutOfBoundsException exception");
        }catch(Exception ex){
            assertEquals( 
                "Expexceted exception", IndexOutOfBoundsException.class.getName(), ex.getClass().getName() 
            );
        }
        try{
            for ( int i = 0; i < 10; i++ ) {
                buffer.add( i );
            }
            fail("Expected IndexOutOfBoundsException exception");
        }catch(Exception ex){
            assertEquals( 
                "Expexceted exception", IndexOutOfBoundsException.class.getName(), ex.getClass().getName() 
            );
        }
    }
    
    /**
     * Test method for
     * <ul>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#add(int)}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#get(int)}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#remove()}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#size()}</li>
     * <li>{@link it.cnr.isti.collections.CircularBufferInt#slots()}</li>
     * </ul>
     */
    @Test
    public void testAdd_Remove_Get_Size_Slots() {
        int[] dataSetFull = new int[]{ 5, 1, 0, 2, 4 };
        int[] dataSetBig = new int[]{ 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
        final int SIZE = 5; 
        CircularBufferInt bufferReadback = new CircularBufferInt( SIZE, true );
        CircularBufferInt bufferWriteRead = new CircularBufferInt( SIZE, true );
        for ( int i = 0; i < dataSetFull.length; i++ ) {
            bufferReadback.add( dataSetFull[i] );
            assertEquals( "Increasing size", i + 1, bufferReadback.size() );
            bufferWriteRead.add( dataSetFull[i] );
            assertEquals( "Getting data "+i, dataSetFull[i], bufferReadback.get( i ) );
            assertEquals( "Reading just added data", dataSetFull[i], bufferWriteRead.remove() );
            assertEquals( "Constant size", 0, bufferWriteRead.size() );
        }
        
        assertEquals( "Constant slots", 5, bufferWriteRead.slots() );
        assertEquals( "Constant slots", 5, bufferReadback.slots() );
        
        for ( int i = 0; i < dataSetFull.length; i++ ) {
            assertEquals( "Reading back data added data", dataSetFull[i], bufferReadback.remove() );
        }
        
        for ( int i = 0; i < dataSetBig.length; i++ ) {
            bufferReadback.add( dataSetBig[i] );
            bufferWriteRead.add( dataSetBig[i] );
            assertEquals( "Reading back data added data", dataSetBig[i], bufferWriteRead.remove() );
        }
        
        for ( int i = 0; i < SIZE; i++ ) {
            assertEquals( "Decreasing size", 5 - i, bufferReadback.size() );
            assertEquals( 
                "Reading back data added data", 
                dataSetBig[dataSetBig.length - SIZE + i], bufferReadback.remove() 
            );
        }
    }
}
