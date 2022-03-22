

package com.example.myguitarclass;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class TuningView extends View {
    private int mSelectedIndex;
    private Tuning mTuning;
    private float mTuningItemWidth;
    private Paint mPaint = new Paint();
    private Rect mTempRect = new Rect();
    private int mNormalTextColor;
    private int mSelectedTextColor;
    private float mOffset = 0;
    private ValueAnimator mOffsetAnimator = null;


    public TuningView(Context context) {
        this(context, null);
    }

    public TuningView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.tuningViewStyle);
    }

    public TuningView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray array = context.obtainStyledAttributes(attrs,
                R.styleable.TuningView, defStyleAttr,
                R.style.LightTuningView);//переделать
        //mNormalTextColor = array.getColor(R.styleable.TuningView_normalTextColor, 0);
        //mSelectedTextColor = array.getColor(R.styleable.TuningView_selectedTextColor, 0);
        float textSize = array.getDimension(R.styleable.TuningView_textSize, 0);
        mPaint.setTextSize(textSize);
        mTuningItemWidth = array.getDimension(R.styleable.TuningView_itemWidth, 0);
        //array.recycle();
    }


    public void setSelectedIndex(int selectedIndex, boolean animate) {
        if (selectedIndex == mSelectedIndex)
            return;

        mSelectedIndex = selectedIndex;
        float newOffset = (getWidth() - mTuningItemWidth) / 2f - mSelectedIndex * mTuningItemWidth;
        stopAnimation();
        if (animate) {
            mOffsetAnimator = ValueAnimator.ofFloat(mOffset, newOffset);
            mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mOffset = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mOffsetAnimator.start();
        } else {
            mOffset = newOffset;
        }
    }


    public void setSelectedIndex(int selectedIndex) {
        setSelectedIndex(selectedIndex, false);
    }

    private void stopAnimation() {
        if (mOffsetAnimator != null) {
            mOffsetAnimator.cancel();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        stopAnimation();
        mOffset = (w - mTuningItemWidth) / 2f - mSelectedIndex * mTuningItemWidth;
    }

    public void setTuning(Tuning tuning) {
        mTuning = tuning;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mTuning == null)
            return;

        int height = getHeight();


        for (int i = 0; i < mTuning.pitches.length; i++) {
            mPaint.setColor(getResources().getColor(R.color.white));//верхние ноты
            String text = mTuning.pitches[i].name;
            float textWidth = mPaint.measureText(text);
            mPaint.getTextBounds(text, 0, text.length(), mTempRect);
            canvas.drawText(text, mOffset + i * mTuningItemWidth + (mTuningItemWidth - textWidth) / 2f, (height + mTempRect.height()) / 2f, mPaint);
        }


    }
}
