package com.willoughby.goalie;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;




/**
 * Created by dan on 10/1/14.
 */
public class GoalDetailView extends RelativeLayout {

  private Context mContext;
  private int     mWidth;
  private int     mScreenWidth;
  private int     mScreenHeight;
  private int     mHeight;
  private Bitmap  mBitmap;
  private Canvas  mCanvas;
  Paint mPaint;
  Paint mPaintPurple;
  Paint mPaintFont;


  public GoalDetailView(Context context) {
    super(context);
    init(context);
  }

  public GoalDetailView(Context context, int screenWidth, int screenHeight) {
    super(context);
    mScreenWidth = screenWidth;
    mScreenHeight = screenHeight;
    init(context);
  }


  public GoalDetailView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }


  public GoalDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }


  public void init(Context context) {
    setFocusable(true);
    mContext = context;
    //drawBoard();
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    int touchX = (int) event.getX();
    int touchY = (int) event.getY();
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
    }
    return true;
  }


  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec,heightMeasureSpec);

    mHeight = (int)((mScreenHeight - PADDING * (ROWS + 1)) / ROWS);
    mWidth =  (int)((mScreenWidth - PADDING * (COLS + 1))/ COLS);

    // calculate size of view to hold all rects
    int numberOfRows = (int)Math.ceil((COUNT/COLS));
    int containerViewHeight = (int)((mHeight + PADDING)* numberOfRows + PADDING /* For the bottom of the view */);
    //MUST CALL THIS
    setMeasuredDimension(mScreenWidth, containerViewHeight);
    drawBoard();
  }

  final static float ROWS = 3.2f; // displayed on screen
  final static float COLS = 2f;
  final static int PADDING = 10;
  final static int COUNT = 44; // number of rects

  private void drawBoard() {

    int height = mHeight;//(int)(mHeight / ROWS) - PADDING;
    int width = mWidth;//(int)(mWidth / COLS) - PADDING;
    float posX = PADDING;
    float posY = PADDING;
    int count = 0;
    //this.addView(new Rectangle(this.getContext(), width, height));
    //for (int row = 0; row < ROWS ; row++) {
    //for (int col = 0; col < COLS; col++) {
    //int x = col * width + ((col + 1) * PADDING);
    //int y = row * height + ((row + 1) * PADDING);
    for (int i = 0; i < COUNT; i++) {
      BoxView r = new BoxView(this.getContext(), width, height);
      r.setX(posX);
      r.setY(posY);
      posX += width + PADDING;
      if (posX > mScreenWidth- PADDING *2) {
        posX = PADDING;
        posY += height + PADDING;
      }
      this.addView(r);
    }
      //}
    //}


    //invalidate();
  }

  private int getColor(int alpha, int colorNum) {
    int color;
    if (alpha == 255) {
      switch (colorNum) {
        case -1:
          color = Color.BLACK;
        case 0:
          color = Color.BLACK;
          break;
        case 1:
          color = Color.GREEN;
          break;
        case 2:
          color = Color.BLUE;
          break;
        case 3:
          color = Color.RED;
          break;
        case 4:
          color = Color.CYAN;
          break;
        case 5:
          color = Color.MAGENTA;
          break;
        default:
          color = Color.BLACK;
          break;
      }
    }
    else {
      color = Color.BLACK;
    }
    return color;
  }



  // region Getter & Setters
  // endregion


  public interface BoardViewDelegate {
    String get(int row, int col);

    int getAlpha(int row, int col);

    int getColor(int row, int col);

    void choose(int row, int col);
  }
}
