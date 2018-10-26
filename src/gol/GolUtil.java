package gol;

import java.util.Random;

/**
 * ������.
* @ClassName GolUtil 
* @Description TODO(ΪMyPanl�ṩ��������) 
* @author CrazyS
* @date 2018��9��22�� ����12:25:34 
*
 */
public class GolUtil {
  
  private static final Random random = new Random();
  
  /**
   * ��ʼ�������ϸ����.
  * @author CrazyS
  * @date 2018��9��22�� ����12:26:23 
  * @Title initialBoard  
  * @param initialBoard �����ϸ�����ά����      
   */
  public static void initialBoard(final boolean[][] initialBoard) {
    boolean rand;// �洢�����
    for (int i = 0; i < initialBoard.length; i++) {
      for (int j = 0; j < initialBoard[0].length; j++) {
        rand = random.nextBoolean();
        initialBoard[i][j] = rand;
      }
    }
  }

  /**
   * ��ʼ��ϸ����tempBoard��nextBoard.
   * @author CrazyS
   * @date 2018��9��22�� ����12:14:17 
   * @Title: initialBoardTwo 
   * @Description: TODO(��ʼ��ϸ����) 
   * @param initialBoard �����ϸ����
   * @param tempBoard ��ǰϸ����
   * @param nextBoard ��һ��ϸ����
   */
  public static void initialBoardTwo(final boolean[][] initialBoard, final boolean[][] tempBoard,
      boolean[][] nextBoard) {
    for (int i = 0; i < initialBoard.length; i++) {
      for (int j = 0; j < initialBoard[0].length; j++) {
        nextBoard[i][j] = initialBoard[i][j];
        tempBoard[i][j] = initialBoard[i][j];
      }
    }
  }

  /**
   * �ı�ϸ����nextBoard��tempBoard��״̬.
   * @author CrazyS
   * @date 2018��9��22�� ����12:11:08 
   * @Title changeCellStatus 
   * @Description TODO(�ı�ϸ�����״̬) 
   * @param nextBoard ��һ��ϸ����
   * @param tempBoard ��ǰϸ����
   */
  public static void changeCellStatus(final boolean[][] nextBoard,final boolean[][] tempBoard) {
    for (int i = 0; i < nextBoard.length; i++) {
      for (int j = 0; j < nextBoard[0].length; j++) {
        switch (neighborsCount(i, j, tempBoard)) {
          case 0:
          case 1:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
            nextBoard[i][j] = false;
            break;
          case 2:
            nextBoard[i][j] = tempBoard[i][j];
            break;
          case 3:
            nextBoard[i][j] = true;
            break;
          default:
            break;
        }
      }
    }
    copyCellBoard(tempBoard, nextBoard);
  }

  /**
   * ����һ��ϸ����nextBoard���Ƹ���ǰϸ����tempBoard.
   * @author CrazyS
   * @date 2018��9��22�� ����12:11:57 
   * @Title: copyCellBoard 
   * @Description: TODO(ϸ����Ĵ���) 
   * @param tempBoard ��ǰϸ����
   * @param nextBoard ��һ��ϸ����
   */
  public static void copyCellBoard(final boolean[][] tempBoard,final boolean[][] nextBoard) {
    for (int row = 0; row < nextBoard.length; row++) {
      for (int col = 0; col < nextBoard[row].length; col++) {
        tempBoard[row][col] = nextBoard[row][col];
      }
    }
  }

  /**
   * �����row�е�column����Χ��8��ϸ���л�ϸ���ĸ���.
  * @author CrazyS
  * @date 2018��9��22�� ����12:30:09 
  * @Title neighborsCount  
  * @param row ��
  * @param col ��
  * @param tempBoard ��ǰϸ����    
  * @return integer ����λ��Ϊ(row,column)��Χ��ϸ���ĸ���
   */
  public static int neighborsCount(final int row, final int col,final boolean[][] tempBoard) {
    int count = 0;
    for (int r = row - 1; r <= row + 1; r++) {
      for (int c = col - 1; c <= col + 1; c++) {
        if (r < 0 || r >= tempBoard.length || c < 0 || c >= tempBoard[0].length) {
          continue;
        }
        if (tempBoard[r][c]) {
          count++;
        }
      }
    }
    if (tempBoard[row][col]) {
      count--;
    }
    return count;
  }
}
