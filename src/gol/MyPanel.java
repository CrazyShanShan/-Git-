package gol;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ��Ϸ���.
* @ClassName MyPanel 
* @Description TODO(������Ϸ�����) 
* @author CrazyS
* @date 2018��9��23�� ����2:58:56 
*
 */
class MyPanel extends JPanel {
  private static final long serialVersionUID = 5640668174921441140L;

  private static Timer timer;
  // ˢ��ʱ��
  private static final int DELAY_TIME = 1200;

  // �������εĳ��Ϳ�
  private static final int width = 22;
  private static final int height = 22;

  // ϸ����������
  private static final boolean CELL_ALIVE = true;
  private static final boolean CELL_DEAD = false;

  // ��һ��ϸ���壬�ݶ���ϸ����
  private static final boolean[][] initialBoard = new boolean[22][22];
  private static final boolean[][] nextBoard = new boolean[22][22];
  private static final boolean[][] tempBoard = new boolean[22][22];

  // ��ϸ����
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

  // ����ʱ����
  private void startAnimation() {
    // ��ʼ��
    GolUtil.initialBoard(initialBoard);

    // ��ֵ
    GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);

    // ������ʱ��
    timer = new Timer(DELAY_TIME, new ActionListener() {
      public void actionPerformed(final ActionEvent event) {
        // �ı�ϸ����״̬
        GolUtil.changeCellStatus(nextBoard, tempBoard);
        // �ػ�
        repaint();
      }
    });
    // ������ʱ��
    timer.start();
  }

  public MyPanel() {
    super();
    this.startAnimation();
  }
}
