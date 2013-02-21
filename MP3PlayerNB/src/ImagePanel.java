/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ImagePanel extends JPanel
/*    */ {
/*    */   Image img;
/*    */ 
/*    */   public ImagePanel(Image img)
/*    */   {
/* 14 */     this.img = img;
/*    */   }
/*    */ 
/*    */   public void setImage(Image img)
/*    */   {
/* 19 */     this.img = img;
/*    */   }
/*    */ 
/*    */   public void paintComponent(Graphics g)
/*    */   {
/* 24 */     g.drawImage(this.img, 0, 0, null);
/*    */   }
/*    */ }

/* Location:           F:\w.jar
 * Qualified Name:     ImagePanel
 * JD-Core Version:    0.6.2
 */