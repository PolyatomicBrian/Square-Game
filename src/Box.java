import java.awt.*;

public class Box{
  private int x, y;
  private int width, height;
  private int dx, dy;
  private Color color;
  private static int minSpeed, maxSpeed;
  
  public Box(int xx, int yy, int wid, int h){
    color = new Color( (int)(256*Math.random()), (int)(256*Math.random()), (int)(256*Math.random()));
    x = xx;
    y = yy;
    width = wid;
    height = h;
    setRandomSpeed();
  }
  
  private void setRandomSpeed(){
    while (dx == 0 && dy == 0){
      dx = (int)((maxSpeed - minSpeed + 1)*Math.random()+minSpeed);
      dy = (int)((maxSpeed - minSpeed + 1)*Math.random()+minSpeed);
    }
  }
  
  public static void setSpeedLimits(int min, int max){
    minSpeed = min;
    maxSpeed = max;
  }
  
  public void move(int w, int h){
    x+=dx;
    y+=dy;
    if (x + width >= w)
      dx = -Math.abs(dx);
    else if (x <= 0)
      dx = Math.abs(dx);
    if (y + height >= h)
      dy = -Math.abs(dy);
    else if (y <= 0)
      dy = Math.abs(dy);
  }
  
  public boolean contains(int ptx, int pty){
    if ((ptx >= x && ptx <= x + width) && (pty >= y && pty <= y + height)){
      return true;
    }
    return false;
  }
  
  public void draw(Graphics g){
    g.setColor(color);
    g.fillRect(x,y,width,height);
    g.setColor(Color.BLACK);
    g.drawRect(x,y,width,height);
  }
}

