package gol;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 游戏面板.
* @ClassName MyPanel 
* @Description TODO(生成游戏的面板) 
* @author CrazyS
* @date 2018年9月23日 下午2:58:56 
*
 */
class MyPanel extends JPanel {
  private static final long serialVersionUID = 5640668174921441140L;

  private static Timer timer;
  // 刷新时间
  private static final int DELAY_TIME = 1200;

  // 画正方形的长和宽
  private static final int width = 22;
  private static final int height = 22;

  // 细胞的生和死
  private static final boolean CELL_ALIVE = true;
  private static final boolean CELL_DEAD = false;

  // 下一个细胞板，暂定的细胞版
  private static final boolean[][] initialBoard = new boolean[22][22];
  private static final boolean[][] nextBoard = new boolean[22][22];
  private static final boolean[][] tempBoard = new boolean[22][22];

  // 画细胞版
  public void paint(final Graphics gamePanel) {
    super.paint(gamePanel);
    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 22; j++) {
        if (nextBoard[i][j] == CELL_ALIVE) {
          gamePanel.fillRect(j * width, i * height, width, height);
        } else if (nextBoard[i][j] == CELL_DEAD) {
          gamePanel.drawRect(j * width, i * height, width, height);
        }
      }
    }
  }

  // 创建时调用
  private void startAnimation() {
    // 初始化
    GolUtil.initialBoard(initialBoard);

    // 赋值
    GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);

    // 创建计时器
    timer = new Timer(DELAY_TIME, new ActionListener() {
      public void actionPerformed(final ActionEvent event) {
        // 改变细胞的状态
        GolUtil.changeCellStatus(nextBoard, tempBoard);
        // 重绘
        repaint();
      }
    });
    // 开启计时器
    timer.start();
  }

  public MyPanel() {
    super();
    this.startAnimation();
  }
}
