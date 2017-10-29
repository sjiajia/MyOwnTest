package LifeGame;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class LifeGameTest {
	lifegame lg = new lifegame();
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInit(){
		lg.init();
    	int rowMid=(lg.cell.length-2)/2;
    	int rowLeftMid=(lg.cell.length-2)/4;
    	int colMid=(lg.cell[0].length-2)/2;
    	int colLeftMid=(lg.cell[0].length-2)/4;
        for (int i = rowMid-rowLeftMid; i < rowMid+rowLeftMid; i++) {
            for (int j = colMid-colLeftMid; j < colMid+colLeftMid; j++) {
            	assertEquals(true,lg.cell[i][j]);
            }
        }
        
	}
	
	@Test
	public void testUpdate()
	{    // 更新显示
		lg.update();
        for (int i = 1; i < lg.cell.length - 1; i++) {
            for (int j = 1; j < lg.cell[i].length - 1; j++) {
            	if (lg.cell[i][j])
            		assertEquals(Color.BLUE,lg.print[i][j].getBackground());
            	else
            		assertEquals(Color.WHITE,lg.print[i][j].getBackground());
            }
        }
	}
	
	@Test
	public void testNextGeneration() {
/*
            // 取得下一代
            lg.nextgeneration();
            for (int i = 1; i < lg.cell.length - 1; i++) 
            {
                for (int j = 1; j < lg.cell[i].length - 1; j++)
            	{
            	    if(lg.counter[i][j]<=1)
            		    assertEquals(false,lg.cell[i][j]);
            	    else
            	    	if(lg.counter[i][j]>3)
            	    		assertEquals(false,lg.cell[i][j]);
            	    	else
            	    		if(lg.counter[i][j]==3)
            	    			assertEquals(true,lg.cell[i][j]);
                }
            }
            
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 更新显示
            lg.update();
            
*/      
	}
	
	@After
	public void tearDown() throws Exception {
        while (true) {
            // 取得下一代
            lg.nextgeneration();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 更新显示
            lg.update();
        }
	}
	
}
