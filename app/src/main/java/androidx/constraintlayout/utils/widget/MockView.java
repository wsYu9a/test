package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* loaded from: classes.dex */
public class MockView extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    protected String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context context) {
        super(context);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MockView_mock_label) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.mDrawDiagonals = obtainStyledAttributes.getBoolean(index, this.mDrawDiagonals);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.mDiagonalsColor = obtainStyledAttributes.getColor(index, this.mDiagonalsColor);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.mTextBackgroundColor = obtainStyledAttributes.getColor(index, this.mTextBackgroundColor);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.mTextColor = obtainStyledAttributes.getColor(index, this.mTextColor);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.mDrawLabel = obtainStyledAttributes.getBoolean(index, this.mDrawLabel);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mDrawDiagonals) {
            width--;
            height--;
            float f10 = width;
            float f11 = height;
            canvas.drawLine(0.0f, 0.0f, f10, f11, this.mPaintDiagonals);
            canvas.drawLine(0.0f, f11, f10, 0.0f, this.mPaintDiagonals);
            canvas.drawLine(0.0f, 0.0f, f10, 0.0f, this.mPaintDiagonals);
            canvas.drawLine(f10, 0.0f, f10, f11, this.mPaintDiagonals);
            canvas.drawLine(f10, f11, 0.0f, f11, this.mPaintDiagonals);
            canvas.drawLine(0.0f, f11, 0.0f, 0.0f, this.mPaintDiagonals);
        }
        String str = this.mText;
        if (str == null || !this.mDrawLabel) {
            return;
        }
        this.mPaintText.getTextBounds(str, 0, str.length(), this.mTextBounds);
        float width2 = (width - this.mTextBounds.width()) / 2.0f;
        float height2 = ((height - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) width2, (int) height2);
        Rect rect = this.mTextBounds;
        int i10 = rect.left;
        int i11 = this.mMargin;
        rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
        canvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
        canvas.drawText(this.mText, width2, height2, this.mPaintText);
    }

    public MockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attrs);
    }

    public MockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(context, attrs);
    }
}
