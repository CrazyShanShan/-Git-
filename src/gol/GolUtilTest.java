package gol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GolUtilTest {

  
  // 用于测试的数据
  private static final boolean[][] initialBoard = new boolean[22][22];
  private static final boolean[][] nextBoard = new boolean[22][22];
  private static final boolean[][] tempBoard = new boolean[22][22];
  
  // 用于进行验证的数据
  private static final boolean[][] temp = new boolean[22][22];
  
  //用于验证的flag
  private  boolean flag = true;
  
  public  boolean isFlag() {
    return flag;
  }


  public void setFlag(final boolean flagA) {
    flag = flagA;
  }


  /** 
   * 构造函数.
  * <p>Title: </p> 
  * <p>Description: </p>  
  * @author CrazyS
  * @date 2018年9月23日 下午1:54:33 
  */
  public GolUtilTest() {
    // 初始化
    for (int i = 0; i < initialBoard.length; i++) {
      for (int j = 0; j < initialBoard[0].length; j++) {
        initialBoard[i][j] = false;
      }
    }
    // 赋值
    GolUtil.initialBoardTwo(initialBoard, tempBoard, nextBoard);
    
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp[0].length; j++) {
        temp[i][j] = false;
      }
    }
  }
  
 
  @Test // 边缘测试
  public void testChangeCellStatus() {
    GolUtil.changeCellStatus(nextBoard, tempBoard);
      
    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 22; j++) {
        if (nextBoard[i][j] != temp[i][j]) {
          setFlag(false);
          break;
        }
      }
    }

    assertEquals("failure - flag are not equal",true, flag);
  }

  @Test // 错误测试
  public void testChangeCellStatusTwo() {

    tempBoard[18][19] = true;
    tempBoard[18][18] = true;
    tempBoard[19][19] = true;
    tempBoard[19][18] = true;
    GolUtil.changeCellStatus(nextBoard, tempBoard);

    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 22; j++) {
        if (nextBoard[i][j] != temp[i][j]) {
          setFlag(false);
          break;
        }
      }
    }
    
    assertEquals("failure - flag are not equal",false, flag);
  }

  @Test // 一般测试
  public void testChangeCellStatusThree() {

    tempBoard[18][19] = true;
    tempBoard[18][18] = true;
    tempBoard[19][19] = true;
    tempBoard[19][18] = true;
    tempBoard[10][10] = true;
    tempBoard[10][11] = true;
    GolUtil.changeCellStatus(nextBoard, tempBoard);

   
    temp[18][19] = true;
    temp[18][18] = true;
    temp[19][19] = true;
    temp[19][18] = true;

    for (int i = 0; i < 22; i++) {
      for (int j = 0; j < 22; j++) {
        if (nextBoard[i][j] != temp[i][j]) {
          setFlag(false);
          break;
        }
      }
    }

    assertEquals("failure - flag are not equal",true, flag);
  }


  @Test // 一般测试
  public void testNeighborsCount() {
    tempBoard[0][2] = true;
    tempBoard[1][1] = true;
    tempBoard[2][0] = true;
    tempBoard[2][1] = true;
    final int result = GolUtil.neighborsCount(1, 1, tempBoard);
    assertEquals("failure - number are not equal",3, result);
  }

}
