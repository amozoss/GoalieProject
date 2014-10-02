package com.willoughby.goalie;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by dan on 10/1/14.
 */
  public class BoxView extends View {
    private int mWidth;
    private int mHeight;

    public BoxView(Context context, int width, int height) {
      super(context);
      mWidth = width;
      mHeight = height;
      init();
    }
    public BoxView(Context context) {
        super(context);
        init();
    }

    public BoxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BoxView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        //this.setBackgroundResource(R.drawable.rectangle);
      int color = this.getContext().getResources().getColor(R.color.goalie_blue);
      setBackgroundColor(color);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = mWidth;
        int height = mHeight;

        setMeasuredDimension(width, height);
    }

}
