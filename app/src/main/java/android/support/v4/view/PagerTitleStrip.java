package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.C0003;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes7.dex */
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS;
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS;
    private static final int TEXT_SPACING = 16;

    /* renamed from: short */
    private static final short[] f37short;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;

        PageListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            float f2 = PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0f ? PagerTitleStrip.this.mLastKnownPositionOffset : 0.0f;
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f2, true);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.mScrollState = i2;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Object[] objArr = {new Float(0.5f), new Integer(4749493)};
            if (f2 > ((Float) objArr[0]).floatValue()) {
                i2 += ((Integer) objArr[1]).intValue() ^ 4749492;
            }
            PagerTitleStrip.this.updateTextPositions(i2, f2, false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                float f2 = PagerTitleStrip.this.mLastKnownPositionOffset >= 0.0f ? PagerTitleStrip.this.mLastKnownPositionOffset : 0.0f;
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f2, true);
            }
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
    }

    static {
        Object[] objArr = {new Integer(7250827), new Integer(8594714), new Integer(528124)};
        short[] sArr = new short[((Integer) objArr[2]).intValue() ^ 528042];
        sArr[0] = 1811;
        sArr[1] = 1826;
        sArr[2] = 1828;
        sArr[3] = 1830;
        sArr[4] = 1841;
        sArr[5] = 1815;
        sArr[6] = 1834;
        sArr[7] = 1847;
        sArr[8] = 1839;
        sArr[9] = 1830;
        sArr[10] = 1808;
        sArr[11] = 1847;
        sArr[12] = 1841;
        sArr[13] = 1834;
        sArr[14] = 1843;
        sArr[15] = 1891;
        sArr[16] = 1838;
        sArr[17] = 1846;
        sArr[18] = 1840;
        sArr[19] = 1847;
        sArr[20] = 1891;
        sArr[21] = 1825;
        sArr[22] = 1830;
        sArr[23] = 1891;
        sArr[24] = 1826;
        sArr[25] = 1891;
        sArr[26] = 1831;
        sArr[27] = 1834;
        sArr[28] = 1841;
        sArr[29] = 1830;
        sArr[30] = 1824;
        sArr[31] = 1847;
        sArr[32] = 1891;
        sArr[33] = 1824;
        sArr[34] = 1835;
        sArr[35] = 1834;
        sArr[36] = 1839;
        sArr[37] = 1831;
        sArr[38] = 1891;
        sArr[39] = 1836;
        sArr[40] = 1829;
        sArr[41] = 1891;
        sArr[42] = 1826;
        sArr[43] = 1891;
        sArr[44] = 1813;
        sArr[45] = 1834;
        sArr[46] = 1830;
        sArr[47] = 1844;
        sArr[48] = 1811;
        sArr[49] = 1826;
        sArr[50] = 1828;
        sArr[51] = 1830;
        sArr[52] = 1841;
        sArr[53] = 1901;
        sArr[54] = 289;
        sArr[55] = 281;
        sArr[56] = 287;
        sArr[57] = 280;
        sArr[58] = 332;
        sArr[59] = 257;
        sArr[60] = 265;
        sArr[61] = 269;
        sArr[62] = 287;
        sArr[63] = 281;
        sArr[64] = 286;
        sArr[65] = 265;
        sArr[66] = 332;
        sArr[67] = 283;
        sArr[68] = 261;
        sArr[69] = 280;
        sArr[70] = 260;
        sArr[71] = 332;
        sArr[72] = 269;
        sArr[73] = 258;
        sArr[74] = 332;
        sArr[75] = 265;
        sArr[76] = 276;
        sArr[77] = 269;
        sArr[78] = 271;
        sArr[79] = 280;
        sArr[80] = 332;
        sArr[81] = 283;
        sArr[82] = 261;
        sArr[83] = 264;
        sArr[84] = 280;
        sArr[85] = 260;
        f37short = sArr;
        int[] iArr = new int[((Integer) objArr[0]).intValue() ^ 7250831];
        iArr[0] = 16842804;
        iArr[1] = 16842901;
        iArr[2] = 16842904;
        iArr[3] = 16842927;
        ATTRS = iArr;
        int[] iArr2 = new int[((Integer) objArr[1]).intValue() ^ 8594715];
        iArr2[0] = 16843660;
        TEXT_ATTRS = iArr2;
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        Object[] objArr = {new Integer(3375562), new Float(16.0f), new Integer(9031838), new Float(SIDE_ALPHA), new Integer(1816079), new Integer(4300680)};
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(((Integer) objArr[2]).intValue() ^ 9031839, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        int intValue = ((Integer) objArr[0]).intValue() ^ 3375560;
        if (obtainStyledAttributes.hasValue(intValue)) {
            int color = obtainStyledAttributes.getColor(intValue, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(1816076 ^ ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue() ^ 4300760);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(((Float) objArr[3]).floatValue());
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        } else {
            z = false;
        }
        if (z) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (((Float) objArr[1]).floatValue() * context.getResources().getDisplayMetrics().density);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException(C0008.m24(f37short, C0008.m27((Object) "ۡ") ^ 1761, 1749773 ^ C0008.m27((Object) "ۢۧ۠"), C0008.m27((Object) "ۣۣۡ") ^ 1749442));
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.mPageListener);
        viewPager.addOnAdapterChangeListener(this.mPageListener);
        this.mPager = viewPager;
        WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
        updateAdapter(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), null);
            this.mPager.setInternalPageChangeListener(null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mPager != null) {
            float f2 = this.mLastKnownPositionOffset;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f2, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        Object[] objArr = {new Integer(2079715), new Integer(-1891970), new Float(0.2f)};
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(C0003.m11(f37short, 1750652 ^ C0008.m27((Object) "ۣۡۨ"), 1749819 ^ C0008.m27((Object) "ۢۦ۟"), C0008.m27((Object) "ۡۡۥ") ^ 1748905));
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int intValue = 1891968 ^ ((Integer) objArr[1]).intValue();
        int childMeasureSpec = getChildMeasureSpec(i3, paddingBottom, intValue);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = getChildMeasureSpec(i2, (int) (((Float) objArr[2]).floatValue() * size), intValue);
        this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
        this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
        this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
        setMeasuredDimension(size, View.resolveSizeAndState(View.MeasureSpec.getMode(i3) == 1073741824 ? View.MeasureSpec.getSize(i3) : Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingBottom), i3, this.mCurrText.getMeasuredState() << (((Integer) objArr[0]).intValue() ^ 2079731)));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mUpdatingText) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.mGravity = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        Object[] objArr = {new Integer(404399), new Float(255.0f), new Integer(4882816)};
        int floatValue = ((int) (((Float) objArr[1]).floatValue() * f2)) & (((Integer) objArr[2]).intValue() ^ 4882815);
        this.mNonPrimaryAlpha = floatValue;
        int intValue = (floatValue << (((Integer) objArr[0]).intValue() ^ 404407)) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(intValue);
        this.mNextText.setTextColor(intValue);
    }

    public void setTextColor(int i2) {
        Integer num = new Integer(6807631);
        this.mTextColor = i2;
        this.mCurrText.setTextColor(i2);
        int intValue = (this.mNonPrimaryAlpha << (((Integer) new Object[]{num}[0]).intValue() ^ 6807639)) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(intValue);
        this.mNextText.setTextColor(intValue);
    }

    public void setTextSize(int i2, float f2) {
        this.mPrevText.setTextSize(i2, f2);
        this.mCurrText.setTextSize(i2, f2);
        this.mNextText.setTextSize(i2, f2);
    }

    public void setTextSpacing(int i2) {
        this.mScaledTextSpacing = i2;
        requestLayout();
    }

    void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void updateText(int i2, PagerAdapter pagerAdapter) {
        CharSequence charSequence = null;
        Object[] objArr = {new Integer(-2139044666), new Integer(5141648), new Integer(-7661742), new Float(0.8f), new Integer(5004454)};
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.mUpdatingText = true;
        this.mPrevText.setText((i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle((((Integer) objArr[2]).intValue() ^ 7661741) + i2));
        this.mCurrText.setText((pagerAdapter == null || i2 >= count) ? null : pagerAdapter.getPageTitle(i2));
        if ((((Integer) objArr[4]).intValue() ^ 5004455) + i2 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle((((Integer) objArr[1]).intValue() ^ 5141649) + i2);
        }
        this.mNextText.setText(charSequence);
        int max = Math.max(0, (int) (((Float) objArr[3]).floatValue() * ((getWidth() - getPaddingLeft()) - getPaddingRight())));
        int intValue = ((Integer) objArr[0]).intValue() ^ 8438982;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, intValue);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), intValue);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i2;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i2, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    void updateTextPositions(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        Object[] objArr = {new Integer(47220), new Float(1.0f), new Integer(2832122), new Integer(1460509), new Float(0.5f)};
        if (i2 != this.mLastKnownCurrentPage) {
            updateText(i2, this.mPager.getAdapter());
        } else if (!z && f2 == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int intValue = measuredWidth2 / (((Integer) objArr[0]).intValue() ^ 47222);
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + intValue;
        float floatValue = ((Float) objArr[4]).floatValue() + f2;
        float floatValue2 = ((Float) objArr[1]).floatValue();
        int i7 = ((width - i6) - ((int) ((floatValue > floatValue2 ? floatValue - floatValue2 : floatValue) * ((width - (paddingLeft + intValue)) - i6)))) - intValue;
        int i8 = measuredWidth2 + i7;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i9 = max - baseline;
        int i10 = max - baseline2;
        int i11 = max - baseline3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i9, this.mCurrText.getMeasuredHeight() + i10), this.mNextText.getMeasuredHeight() + i11);
        switch ((((Integer) objArr[3]).intValue() ^ 1460589) & this.mGravity) {
            case 16:
                int intValue2 = (((height - paddingTop) - paddingBottom) - max2) / (((Integer) objArr[2]).intValue() ^ 2832120);
                i3 = i9 + intValue2;
                i4 = i10 + intValue2;
                i5 = intValue2 + i11;
                break;
            case 80:
                int i12 = (height - paddingBottom) - max2;
                i3 = i9 + i12;
                i4 = i10 + i12;
                i5 = i12 + i11;
                break;
            default:
                i3 = i9 + paddingTop;
                i4 = i10 + paddingTop;
                i5 = paddingTop + i11;
                break;
        }
        TextView textView = this.mCurrText;
        textView.layout(i7, i4, i8, textView.getMeasuredHeight() + i4);
        int min = Math.min(paddingLeft, (i7 - this.mScaledTextSpacing) - measuredWidth);
        TextView textView2 = this.mPrevText;
        textView2.layout(min, i3, measuredWidth + min, textView2.getMeasuredHeight() + i3);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, this.mScaledTextSpacing + i8);
        TextView textView3 = this.mNextText;
        textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
        this.mLastKnownPositionOffset = f2;
        this.mUpdatingPositions = false;
    }
}
