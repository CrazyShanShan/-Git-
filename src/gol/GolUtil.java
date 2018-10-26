package gol;

import java.util.Random;

/**
 * 工具类.
* @ClassName GolUtil 
* @Description TODO(为MyPanl提供函数调用) 
* @author CrazyS
* @date 2018年9月22日 下午12:25:34 
*
 */
public class GolUtil {
  
  private static final Random random = new Random();
  
  /**
   * 初始化传入的细胞版.
  * @author CrazyS
  * @date 2018年9月22日 下午12:26:23 
  * @Title initialBoard  
  * @param initialBoard 传入的细胞版二维数组      
   */
  public static void initialBoard(final boolean[][] initialBoard) {
    boolean rand;// 存储随机数
    for (int i = 0; i < initialBoard.length; i++) {
      for (int j = 0; j < initialBoard[0].length; j++) {
        rand = random.nextBoolean();
        initialBoard[i][j] = rand;
      }
    }
  }

  /**
   * 初始化细胞版tempBoard和nextBoard.
   * @author CrazyS
   * @date 2018年9月22日 下午12:14:17 
   * @Title: initialBoardTwo 
   * @Description: TODO(初始化细胞版) 
   * @param initialBoard 传入的细胞版
   * @param tempBoard 当前细胞版
   * @param nextBoard 下一个细胞版
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
   * 改变细胞版nextBoard和tempBoard的状态.
   * @author CrazyS
   * @date 2018年9月22日 下午12:11:08 
   * @Title changeCellStatus 
   * @Description TODO(改变细胞版的状态) 
   * @param nextBoard 下一个细胞版
   * @param tempBoard 当前细胞版
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
   * 将下一个细胞版nextBoard复制给当前细胞版tempBoard.
   * @author CrazyS
   * @date 2018年9月22日 下午12:11:57 
   * @Title: copyCellBoard 
   * @Description: TODO(细胞版的传递) 
   * @param tempBoard 当前细胞版
   * @param nextBoard 下一个细胞版
   */
  public static void copyCellBoard(final boolean[][] tempBoard,final boolean[][] nextBoard) {
    for (int row = 0; row < nextBoard.length; row++) {
      for (int col = 0; col < nextBoard[row].length; col++) {
        tempBoard[row][col] = nextBoard[row][col];
      }
    }
  }

  /**
   * 计算第row行第column列周围的8个细胞中活细胞的个数.
  * @author CrazyS
  * @date 2018年9月22日 下午12:30:09 
  * @Title neighborsCount  
  * @param row 行
  * @param col 列
  * @param tempBoard 当前细胞版    
  * @return integer 返回位置为(row,column)周围活细胞的个数
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
