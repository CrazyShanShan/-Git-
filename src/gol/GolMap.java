package gol;

import javax.swing.JFrame;



/**
 * ????????????????????????.
* @ClassName GolMap 
* @Description TODO(???????????) 
* @author CrazyS
* @date 2018??9??22?? ????12:32:08 
*
 */
public class GolMap extends JFrame {
  private static final long serialVersionUID = 1L;
 
  /**
   * ???????????.
  * <p>Title: </p> 
  * <p>Description:???????????????? </p>  
  * @author CrazyS
  * @date 2018??9??22?? ????12:35:37
   */
  
  GolMap() {
    super();
    this.setTitle("???????");
    this.setSize(490, 510);
    this.add(new MyPanel());
    this.setResizable(false);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  /**
   * main????.
  * @author CrazyS
  * @date 2018??9??22?? ????2:15:37 
  * @Title main  
  * @param args ??       
   */
  
  public static void main(final String[] args) {
    new GolMap();
  }
}
