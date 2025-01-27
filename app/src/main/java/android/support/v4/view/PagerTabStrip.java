package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.a.utils.C0520;

/* loaded from: classes7.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f36short;
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    /* renamed from: android.support.v4.view.PagerTabStrip$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.mPager.setCurrentItem((((Integer) new Object[]{new Integer(-1719714)}[0]).intValue() ^ 1719713) + PagerTabStrip.this.mPager.getCurrentItem());
        }
    }

    /* renamed from: android.support.v4.view.PagerTabStrip$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.mPager.setCurrentItem((((Integer) new Object[]{new Integer(8306237)}[0]).intValue() ^ 8306236) + PagerTabStrip.this.mPager.getCurrentItem());
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8942957)}[0]).intValue() ^ 8942944];
        sArr[0] = 2506;
        sArr[1] = 2555;
        sArr[2] = 2557;
        sArr[3] = 2559;
        sArr[4] = 2536;
        sArr[5] = 2510;
        sArr[6] = 2555;
        sArr[7] = 2552;
        sArr[8] = 2505;
        sArr[9] = 2542;
        sArr[10] = 2536;
        sArr[11] = 2547;
        sArr[12] = 2538;
        f36short = sArr;
        TAG = C0520.m66(f36short, 56569 ^ C0008.m27((Object) "ۨۡ"), 1746930 ^ C0008.m27((Object) "۟ۧۧ"), C0008.m27((Object) "ۣۤ۟") ^ 1752836);
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Object[] objArr = {new Float(64.0f), new Float(0.5f), new Float(16.0f), new Float(6.0f), new Float(3.0f), new Float(1.0f), new Float(32.0f)};
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i2 = this.mTextColor;
        this.mIndicatorColor = i2;
        paint.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        float floatValue = ((Float) objArr[4]).floatValue();
        float floatValue2 = ((Float) objArr[1]).floatValue();
        this.mIndicatorHeight = (int) ((floatValue * f2) + floatValue2);
        this.mMinPaddingBottom = (int) ((((Float) objArr[3]).floatValue() * f2) + floatValue2);
        this.mMinTextSpacing = (int) (((Float) objArr[0]).floatValue() * f2);
        this.mTabPadding = (int) ((((Float) objArr[2]).floatValue() * f2) + floatValue2);
        this.mFullUnderlineHeight = (int) ((((Float) objArr[5]).floatValue() * f2) + floatValue2);
        this.mMinStripHeight = (int) ((((Float) objArr[6]).floatValue() * f2) + floatValue2);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() { // from class: android.support.v4.view.PagerTabStrip.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem((((Integer) new Object[]{new Integer(-1719714)}[0]).intValue() ^ 1719713) + PagerTabStrip.this.mPager.getCurrentItem());
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() { // from class: android.support.v4.view.PagerTabStrip.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem((((Integer) new Object[]{new Integer(8306237)}[0]).intValue() ^ 8306236) + PagerTabStrip.this.mPager.getCurrentItem());
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    @Override // android.support.v4.view.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Integer num = new Integer(1035299);
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft();
        int i2 = this.mTabPadding;
        int right = this.mCurrText.getRight();
        int i3 = this.mTabPadding;
        int i4 = this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << (((Integer) new Object[]{num}[0]).intValue() ^ 1035323)) | (this.mIndicatorColor & 16777215));
        canvas.drawRect(left - i2, height - i4, right + i3, height, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((-16777216) | (this.mIndicatorColor & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), height, this.mTabPaint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num = new Integer(6172681);
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 6172680;
        switch (action) {
            case 0:
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.mIgnoreTap = false;
                return intValue;
            case 1:
                if (x < this.mCurrText.getLeft() - this.mTabPadding) {
                    this.mPager.setCurrentItem(this.mPager.getCurrentItem() - (intValue ? 1 : 0));
                    return intValue;
                }
                if (x <= this.mCurrText.getRight() + this.mTabPadding) {
                    return intValue;
                }
                this.mPager.setCurrentItem(this.mPager.getCurrentItem() + (intValue ? 1 : 0));
                return intValue;
            case 2:
                if (Math.abs(x - this.mInitialMotionX) <= this.mTouchSlop && Math.abs(y - this.mInitialMotionY) <= this.mTouchSlop) {
                    return intValue;
                }
                this.mIgnoreTap = intValue;
                return intValue;
            default:
                return intValue;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (this.mDrawFullUnderlineSet) {
            return;
        }
        this.mDrawFullUnderline = ((-16777216) & i2) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mDrawFullUnderlineSet) {
            return;
        }
        this.mDrawFullUnderline = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.mDrawFullUnderlineSet) {
            return;
        }
        this.mDrawFullUnderline = i2 == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.mDrawFullUnderline = z;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        if (i5 < this.mMinPaddingBottom) {
            i5 = this.mMinPaddingBottom;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(int i2) {
        this.mIndicatorColor = i2;
        this.mTabPaint.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i2));
    }

    @Override // android.support.v4.view.PagerTitleStrip
    public void setTextSpacing(int i2) {
        if (i2 < this.mMinTextSpacing) {
            i2 = this.mMinTextSpacing;
        }
        super.setTextSpacing(i2);
    }

    @Override // android.support.v4.view.PagerTitleStrip
    void updateTextPositions(int i2, float f2, boolean z) {
        Object[] objArr = {new Float(2.0f), new Float(255.0f), new Float(0.5f)};
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft();
        int i3 = this.mTabPadding;
        int right = this.mCurrText.getRight();
        int i4 = this.mTabPadding;
        int i5 = height - this.mIndicatorHeight;
        rect.set(left - i3, i5, right + i4, height);
        super.updateTextPositions(i2, f2, z);
        this.mTabAlpha = (int) (((Float) objArr[1]).floatValue() * Math.abs(f2 - ((Float) objArr[2]).floatValue()) * ((Float) objArr[0]).floatValue());
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i5, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }
}
