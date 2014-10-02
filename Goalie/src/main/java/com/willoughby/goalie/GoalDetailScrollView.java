package com.willoughby.goalie;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;



/**
 * Created by dan on 10/1/14.
 */
public class GoalDetailScrollView extends ScrollView {

  private int     mScreenWidth;
  private int     mScreenHeight;
  private GoalDetailView mGoalDetailView;

  public GoalDetailScrollView(Context context) {
    super(context);
    init();
  }


  public GoalDetailScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }


  public GoalDetailScrollView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
  }

  private void init() {
  }

  @Override
  protected void onLayout (boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    if (changed) {
      this.removeView(mGoalDetailView);
      mGoalDetailView = new GoalDetailView(this.getContext(), mScreenWidth, mScreenHeight);
      this.addView(mGoalDetailView);
    }
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    mScreenHeight = View.MeasureSpec.getSize(heightMeasureSpec);
    mScreenWidth = View.MeasureSpec.getSize(widthMeasureSpec);
    setMeasuredDimension(mScreenWidth, mScreenHeight);
  }
}
