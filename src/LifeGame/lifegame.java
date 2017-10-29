package LifeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lifegame {

    JFrame jf;
    public final int SIZE =82;//二维游戏世界的大小，共SIZE*SIZE个单元个格
    public boolean[][] cell=new boolean[SIZE][SIZE];
    public int counter;  //表示邻居的个数

    JPanel[][] print=new JPanel[SIZE][SIZE];//存放，显示细胞状态

    public lifegame() {

        jf = new JFrame("Life Game");//初始化
        jf.setLayout(new GridLayout(SIZE, SIZE, 2, 2));//设置格局
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
            	print[i][j]=new JPanel();
                print[i][j].setBackground(Color.WHITE);
                jf.add(print[i][j]);
            }
        }
        jf.setSize(800, 800);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }           //响应
        });
        init();
        update();
        jf.setVisible(true);
    }


    public void nextgeneration() {    	
        for (int i = 1; i < cell.length - 1; i++) {
            for (int j = 1; j < cell[i].length - 1; j++) {
            	counter=0;
                if (print[i - 1][j - 1].getBackground() == Color.BLUE) {
                    counter++;
                }
                if (print[i - 1][j].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i - 1][j + 1].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i][j - 1].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i][j + 1].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i + 1][j - 1].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i + 1][j].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i + 1][j + 1].getBackground() == Color.BLUE) {
                	counter++;
                }
                if (print[i][j].getBackground() == Color.BLUE) {
                    if (counter <= 1) {
                        cell[i][j] = false;      
                    } else if (counter > 3) {
                        cell[i][j] = false;    
                    }
                } else {
                    if (counter == 3) {
                        cell[i][j] = true; //设置下次更新状态的函数
                    }
                }
            }
        }
    }

    public void init() {
    	int rowMid=(cell.length-2)/2;
    	int rowLeftMid=(cell.length-2)/4;
    	int colMid=(cell[0].length-2)/2;
    	int colLeftMid=(cell[0].length-2)/4;
        for (int i = rowMid-rowLeftMid; i < rowMid+rowLeftMid; i++) {
            for (int j = colMid-colLeftMid; j < colMid+colLeftMid; j++) {
            	cell[i][j] = true;
            }
        }

    }      


    public void update() {
        for (int i = 1; i < cell.length - 1; i++) {
            for (int j = 1; j < cell[i].length - 1; j++) {
                if (cell[i][j]) {
                    print[i][j].setBackground(Color.BLUE);
                } else {
                    print[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    public static void main(String[] args) {

        lifegame lg = new lifegame();
        // 进行初始化界面
        lg.init();
        // 更新显示
        lg.update();
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
