package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.animation.C0005;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.google.gason.C0107;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG;
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;

    /* renamed from: short */
    private static final short[] f40short;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.view.ViewPager$1 */
    static final class AnonymousClass1 implements Comparator<ItemInfo> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$2 */
    static final class AnonymousClass2 implements Interpolator {
        AnonymousClass2() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float floatValue = ((Float) new Object[]{new Float(1.0f)}[0]).floatValue();
            float f3 = f2 - floatValue;
            return floatValue + (f3 * f3 * f3 * f3 * f3);
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$4 */
    class AnonymousClass4 implements OnApplyWindowInsetsListener {
        private final Rect mTempRect = new Rect();

        AnonymousClass4() {
        }

        @Override // android.support.v4.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Integer num = new Integer(5194899);
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.mTempRect;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5194898) + i2) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i2), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LayoutParams() {
            /*
                r3 = this;
                r2 = 0
                java.lang.Integer r0 = new java.lang.Integer
                r1 = -2495644(0xffffffffffd9eb64, float:NaN)
                r0.<init>(r1)
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r2] = r0
                r0 = r1[r2]
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                r1 = 2495643(0x26149b, float:3.497141E-39)
                r0 = r0 ^ r1
                r3.<init>(r0, r0)
                r0 = 0
                r3.widthFactor = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.LayoutParams.<init>():void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Integer num = new Integer(6750472);
            this.widthFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, ((Integer) new Object[]{num}[0]).intValue() ^ 6750520);
            obtainStyledAttributes.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            return ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.mAdapter == null) {
                return;
            }
            accessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Object[] objArr = {new Integer(571818), new Integer(9504979), new Integer(5354592), new Integer(-8308978)};
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(((Integer) objArr[0]).intValue() ^ 571819)) {
                accessibilityNodeInfoCompat.addAction(((Integer) objArr[2]).intValue() ^ 5350496);
            }
            if (ViewPager.this.canScrollHorizontally(((Integer) objArr[3]).intValue() ^ 8308977)) {
                accessibilityNodeInfoCompat.addAction(((Integer) objArr[1]).intValue() ^ 9513171);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            Object[] objArr = {new Integer(7263273), new Integer(-6207884)};
            boolean performAccessibilityAction = super.performAccessibilityAction(view, i2, bundle);
            boolean intValue = 7263272 ^ ((Integer) objArr[0]).intValue();
            if (performAccessibilityAction) {
                return intValue;
            }
            switch (i2) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(intValue ? 1 : 0)) {
                        return false;
                    }
                    ViewPager viewPager = ViewPager.this;
                    viewPager.setCurrentItem(viewPager.mCurItem + (intValue ? 1 : 0));
                    return intValue;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(((Integer) objArr[1]).intValue() ^ 6207883)) {
                        return false;
                    }
                    ViewPager viewPager2 = ViewPager.this;
                    viewPager2.setCurrentItem(viewPager2.mCurItem - (intValue ? 1 : 0));
                    return intValue;
                default:
                    return false;
            }
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageScrolled(int i2, float f2, int i3);

        void onPageSelected(int i2);
    }

    public interface PageTransformer {
        void transformPage(View view, float f2);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR;

        /* renamed from: short */
        private static final short[] f41short;
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        /* renamed from: android.support.v4.view.ViewPager$SavedState$1 */
        static final class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(4189655)}[0]).intValue() ^ 4189683];
            sArr[0] = 1071;
            sArr[1] = 1051;
            sArr[2] = 1032;
            sArr[3] = 1038;
            sArr[4] = 1028;
            sArr[5] = 1036;
            sArr[6] = 1031;
            sArr[7] = 1053;
            sArr[8] = 1081;
            sArr[9] = 1032;
            sArr[10] = 1038;
            sArr[11] = 1036;
            sArr[12] = 1051;
            sArr[13] = 1095;
            sArr[14] = 1082;
            sArr[15] = 1032;
            sArr[16] = 1055;
            sArr[17] = 1036;
            sArr[18] = 1037;
            sArr[19] = 1082;
            sArr[20] = 1053;
            sArr[21] = 1032;
            sArr[22] = 1053;
            sArr[23] = 1036;
            sArr[24] = 1042;
            sArr[25] = 694;
            sArr[26] = 742;
            sArr[27] = 761;
            sArr[28] = 741;
            sArr[29] = 767;
            sArr[30] = 738;
            sArr[31] = 767;
            sArr[32] = 761;
            sArr[33] = 760;
            sArr[34] = 683;
            sArr[35] = 828;
            f41short = sArr;
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            };
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return C0008.m24(f41short, 1753448 ^ C0008.m27((Object) "ۦ۠ۢ"), 1750588 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۣۨۡ") ^ 1756515) + Integer.toHexString(System.identityHashCode(this)) + C0105.m44(f41short, 1746883 ^ C0008.m27((Object) "۟ۦۡ"), 1750742 ^ C0008.m27((Object) "ۣۦ۟"), C0008.m27((Object) "ۣۤۥ") ^ 1750066) + this.position + C0001.m3(f41short, 1747776 ^ C0008.m27((Object) "۠ۤۧ"), 1747746 ^ C0008.m27((Object) "۠ۢۥ"), C0008.m27((Object) "ۧ۠ۡ") ^ 1754729);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i2);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            return layoutParams.isDecor != layoutParams2.isDecor ? layoutParams.isDecor ? 1 : -1 : layoutParams.position - layoutParams2.position;
        }
    }

    static {
        Object[] objArr = {new Integer(5814408), new Integer(2377318)};
        short[] sArr = new short[((Integer) objArr[1]).intValue() ^ 2376780];
        sArr[0] = 3043;
        sArr[1] = 3036;
        sArr[2] = 3024;
        sArr[3] = 3010;
        sArr[4] = 3045;
        sArr[5] = 3028;
        sArr[6] = 3026;
        sArr[7] = 3024;
        sArr[8] = 3015;
        sArr[9] = 951;
        sArr[10] = 950;
        sArr[11] = 904;
        sArr[12] = 953;
        sArr[13] = 959;
        sArr[14] = 957;
        sArr[15] = 907;
        sArr[16] = 955;
        sArr[17] = 938;
        sArr[18] = 951;
        sArr[19] = 948;
        sArr[20] = 948;
        sArr[21] = 957;
        sArr[22] = 956;
        sArr[23] = 1016;
        sArr[24] = 956;
        sArr[25] = 945;
        sArr[26] = 956;
        sArr[27] = 1016;
        sArr[28] = 950;
        sArr[29] = 951;
        sArr[30] = 940;
        sArr[31] = 1016;
        sArr[32] = 955;
        sArr[33] = 953;
        sArr[34] = 948;
        sArr[35] = 948;
        sArr[36] = 1016;
        sArr[37] = 939;
        sArr[38] = 941;
        sArr[39] = 936;
        sArr[40] = 957;
        sArr[41] = 938;
        sArr[42] = 955;
        sArr[43] = 948;
        sArr[44] = 953;
        sArr[45] = 939;
        sArr[46] = 939;
        sArr[47] = 1016;
        sArr[48] = 945;
        sArr[49] = 949;
        sArr[50] = 936;
        sArr[51] = 948;
        sArr[52] = 957;
        sArr[53] = 949;
        sArr[54] = 957;
        sArr[55] = 950;
        sArr[56] = 940;
        sArr[57] = 953;
        sArr[58] = 940;
        sArr[59] = 945;
        sArr[60] = 951;
        sArr[61] = 950;
        sArr[62] = 1571;
        sArr[63] = 1537;
        sArr[64] = 1550;
        sArr[65] = 1550;
        sArr[66] = 1551;
        sArr[67] = 1556;
        sArr[68] = 1600;
        sArr[69] = 1537;
        sArr[70] = 1540;
        sArr[71] = 1540;
        sArr[72] = 1600;
        sArr[73] = 1552;
        sArr[74] = 1537;
        sArr[75] = 1543;
        sArr[76] = 1541;
        sArr[77] = 1554;
        sArr[78] = 1600;
        sArr[79] = 1540;
        sArr[80] = 1541;
        sArr[81] = 1539;
        sArr[82] = 1551;
        sArr[83] = 1554;
        sArr[84] = 1600;
        sArr[85] = 1558;
        sArr[86] = 1545;
        sArr[87] = 1541;
        sArr[88] = 1559;
        sArr[89] = 1600;
        sArr[90] = 1540;
        sArr[91] = 1557;
        sArr[92] = 1554;
        sArr[93] = 1545;
        sArr[94] = 1550;
        sArr[95] = 1543;
        sArr[96] = 1600;
        sArr[97] = 1548;
        sArr[98] = 1537;
        sArr[99] = 1561;
        sArr[100] = 1551;
        sArr[101] = 1557;
        sArr[102] = 1556;
        sArr[103] = 1694;
        sArr[104] = 1667;
        sArr[105] = 1664;
        sArr[106] = 1694;
        sArr[107] = 784;
        sArr[108] = 771;
        sArr[109] = 771;
        sArr[110] = 798;
        sArr[111] = 774;
        sArr[112] = 802;
        sArr[113] = 786;
        sArr[114] = 771;
        sArr[115] = 798;
        sArr[116] = 797;
        sArr[117] = 797;
        sArr[118] = 849;
        sArr[119] = 773;
        sArr[120] = 771;
        sArr[121] = 792;
        sArr[122] = 788;
        sArr[123] = 789;
        sArr[124] = 849;
        sArr[125] = 773;
        sArr[126] = 798;
        sArr[127] = 849;
        sArr[128] = 791;
        sArr[129] = 792;
        sArr[130] = 799;
        sArr[131] = 789;
        sArr[132] = 849;
        sArr[133] = 791;
        sArr[134] = 798;
        sArr[135] = 786;
        sArr[136] = 772;
        sArr[137] = 770;
        sArr[138] = 849;
        sArr[139] = 787;
        sArr[140] = 784;
        sArr[141] = 770;
        sArr[142] = 788;
        sArr[143] = 789;
        sArr[144] = 849;
        sArr[145] = 798;
        sArr[146] = 799;
        sArr[147] = 849;
        sArr[148] = 799;
        sArr[149] = 798;
        sArr[150] = 799;
        sArr[151] = 860;
        sArr[152] = 786;
        sArr[153] = 793;
        sArr[154] = 792;
        sArr[155] = 797;
        sArr[156] = 789;
        sArr[157] = 849;
        sArr[158] = 786;
        sArr[159] = 772;
        sArr[160] = 771;
        sArr[161] = 771;
        sArr[162] = 788;
        sArr[163] = 799;
        sArr[164] = 773;
        sArr[165] = 849;
        sArr[166] = 791;
        sArr[167] = 798;
        sArr[168] = 786;
        sArr[169] = 772;
        sArr[170] = 770;
        sArr[171] = 788;
        sArr[172] = 789;
        sArr[173] = 849;
        sArr[174] = 775;
        sArr[175] = 792;
        sArr[176] = 788;
        sArr[177] = 774;
        sArr[178] = 849;
        sArr[179] = 1528;
        sArr[180] = 1479;
        sArr[181] = 1483;
        sArr[182] = 1497;
        sArr[183] = 1534;
        sArr[184] = 1487;
        sArr[185] = 1481;
        sArr[186] = 1483;
        sArr[187] = 1500;
        sArr[188] = 2243;
        sArr[189] = 2274;
        sArr[190] = 2221;
        sArr[191] = 2283;
        sArr[192] = 2284;
        sArr[193] = 2278;
        sArr[194] = 2280;
        sArr[195] = 2221;
        sArr[196] = 2281;
        sArr[197] = 2303;
        sArr[198] = 2284;
        sArr[199] = 2282;
        sArr[200] = 2221;
        sArr[201] = 2276;
        sArr[202] = 2275;
        sArr[203] = 2221;
        sArr[204] = 2301;
        sArr[205] = 2303;
        sArr[206] = 2274;
        sArr[207] = 2282;
        sArr[208] = 2303;
        sArr[209] = 2280;
        sArr[210] = 2302;
        sArr[211] = 2302;
        sArr[212] = 2211;
        sArr[213] = 2221;
        sArr[214] = 2254;
        sArr[215] = 2284;
        sArr[216] = 2273;
        sArr[217] = 2273;
        sArr[218] = 2221;
        sArr[219] = 2287;
        sArr[220] = 2280;
        sArr[221] = 2282;
        sArr[222] = 2276;
        sArr[223] = 2275;
        sArr[224] = 2251;
        sArr[225] = 2284;
        sArr[226] = 2278;
        sArr[227] = 2280;
        sArr[228] = 2249;
        sArr[229] = 2303;
        sArr[230] = 2284;
        sArr[231] = 2282;
        sArr[232] = 2221;
        sArr[233] = 2283;
        sArr[234] = 2276;
        sArr[235] = 2303;
        sArr[236] = 2302;
        sArr[237] = 2297;
        sArr[238] = 2211;
        sArr[239] = 1495;
        sArr[240] = 1526;
        sArr[241] = 1465;
        sArr[242] = 1535;
        sArr[243] = 1528;
        sArr[244] = 1522;
        sArr[245] = 1532;
        sArr[246] = 1465;
        sArr[247] = 1533;
        sArr[248] = 1515;
        sArr[249] = 1528;
        sArr[250] = 1534;
        sArr[251] = 1465;
        sArr[252] = 1520;
        sArr[253] = 1527;
        sArr[254] = 1465;
        sArr[255] = 1513;
        sArr[256] = 1515;
        sArr[257] = 1526;
        sArr[258] = 1534;
        sArr[259] = 1515;
        sArr[260] = 1532;
        sArr[261] = 1514;
        sArr[262] = 1514;
        sArr[263] = 1463;
        sArr[264] = 1465;
        sArr[265] = 1498;
        sArr[266] = 1528;
        sArr[267] = 1525;
        sArr[268] = 1525;
        sArr[269] = 1465;
        sArr[270] = 1531;
        sArr[271] = 1532;
        sArr[272] = 1534;
        sArr[273] = 1520;
        sArr[274] = 1527;
        sArr[275] = 1503;
        sArr[276] = 1528;
        sArr[277] = 1522;
        sArr[278] = 1532;
        sArr[279] = 1501;
        sArr[280] = 1515;
        sArr[281] = 1528;
        sArr[282] = 1534;
        sArr[283] = 1465;
        sArr[284] = 1535;
        sArr[285] = 1520;
        sArr[286] = 1515;
        sArr[287] = 1514;
        sArr[288] = 1517;
        sArr[289] = 1463;
        sArr[290] = 562;
        sArr[291] = 526;
        sArr[292] = 515;
        sArr[293] = 582;
        sArr[294] = 519;
        sArr[295] = 534;
        sArr[296] = 534;
        sArr[297] = 522;
        sArr[298] = 527;
        sArr[299] = 517;
        sArr[300] = 519;
        sArr[301] = 530;
        sArr[302] = 527;
        sArr[303] = 521;
        sArr[304] = 520;
        sArr[305] = 577;
        sArr[306] = 533;
        sArr[307] = 582;
        sArr[308] = 566;
        sArr[309] = 519;
        sArr[310] = 513;
        sArr[311] = 515;
        sArr[312] = 532;
        sArr[313] = 551;
        sArr[314] = 514;
        sArr[315] = 519;
        sArr[316] = 534;
        sArr[317] = 530;
        sArr[318] = 515;
        sArr[319] = 532;
        sArr[320] = 582;
        sArr[321] = 517;
        sArr[322] = 526;
        sArr[323] = 519;
        sArr[324] = 520;
        sArr[325] = 513;
        sArr[326] = 515;
        sArr[327] = 514;
        sArr[328] = 582;
        sArr[329] = 530;
        sArr[330] = 526;
        sArr[331] = 515;
        sArr[332] = 582;
        sArr[333] = 519;
        sArr[334] = 514;
        sArr[335] = 519;
        sArr[336] = 534;
        sArr[337] = 530;
        sArr[338] = 515;
        sArr[339] = 532;
        sArr[340] = 577;
        sArr[341] = 533;
        sArr[342] = 582;
        sArr[343] = 517;
        sArr[344] = 521;
        sArr[345] = 520;
        sArr[346] = 530;
        sArr[347] = 515;
        sArr[348] = 520;
        sArr[349] = 530;
        sArr[350] = 533;
        sArr[351] = 582;
        sArr[352] = 529;
        sArr[353] = 527;
        sArr[354] = 530;
        sArr[355] = 526;
        sArr[356] = 521;
        sArr[357] = 531;
        sArr[358] = 530;
        sArr[359] = 582;
        sArr[360] = 517;
        sArr[361] = 519;
        sArr[362] = 522;
        sArr[363] = 522;
        sArr[364] = 527;
        sArr[365] = 520;
        sArr[366] = 513;
        sArr[367] = 582;
        sArr[368] = 566;
        sArr[369] = 519;
        sArr[370] = 513;
        sArr[371] = 515;
        sArr[372] = 532;
        sArr[373] = 551;
        sArr[374] = 514;
        sArr[375] = 519;
        sArr[376] = 534;
        sArr[377] = 530;
        sArr[378] = 515;
        sArr[379] = 532;
        sArr[380] = 581;
        sArr[381] = 520;
        sArr[382] = 521;
        sArr[383] = 530;
        sArr[384] = 527;
        sArr[385] = 512;
        sArr[386] = 543;
        sArr[387] = 546;
        sArr[388] = 519;
        sArr[389] = 530;
        sArr[390] = 519;
        sArr[391] = 565;
        sArr[392] = 515;
        sArr[393] = 530;
        sArr[394] = 549;
        sArr[395] = 526;
        sArr[396] = 519;
        sArr[397] = 520;
        sArr[398] = 513;
        sArr[399] = 515;
        sArr[400] = 514;
        sArr[401] = 583;
        sArr[402] = 582;
        sArr[403] = 547;
        sArr[404] = 542;
        sArr[405] = 534;
        sArr[406] = 515;
        sArr[407] = 517;
        sArr[408] = 530;
        sArr[409] = 515;
        sArr[410] = 514;
        sArr[411] = 582;
        sArr[412] = 519;
        sArr[413] = 514;
        sArr[414] = 519;
        sArr[415] = 534;
        sArr[416] = 530;
        sArr[417] = 515;
        sArr[418] = 532;
        sArr[419] = 582;
        sArr[420] = 527;
        sArr[421] = 530;
        sArr[422] = 515;
        sArr[423] = 523;
        sArr[424] = 582;
        sArr[425] = 517;
        sArr[426] = 521;
        sArr[427] = 531;
        sArr[428] = 520;
        sArr[429] = 530;
        sArr[430] = 604;
        sArr[431] = 582;
        sArr[432] = 3301;
        sArr[433] = 3305;
        sArr[434] = 3247;
        sArr[435] = 3238;
        sArr[436] = 3260;
        sArr[437] = 3239;
        sArr[438] = 3245;
        sArr[439] = 3315;
        sArr[440] = 3305;
        sArr[441] = 953;
        sArr[442] = 969;
        sArr[443] = 1016;
        sArr[444] = 1022;
        sArr[445] = 1020;
        sArr[446] = 1003;
        sArr[447] = 953;
        sArr[448] = 1008;
        sArr[449] = 1021;
        sArr[450] = 931;
        sArr[451] = 953;
        sArr[452] = 3006;
        sArr[453] = 3022;
        sArr[454] = 3071;
        sArr[455] = 3065;
        sArr[456] = 3067;
        sArr[457] = 3052;
        sArr[458] = 3006;
        sArr[459] = 3069;
        sArr[460] = 3058;
        sArr[461] = 3071;
        sArr[462] = 3053;
        sArr[463] = 3053;
        sArr[464] = 2980;
        sArr[465] = 3006;
        sArr[466] = 2388;
        sArr[467] = 2340;
        sArr[468] = 2310;
        sArr[469] = 2331;
        sArr[470] = 2326;
        sArr[471] = 2328;
        sArr[472] = 2321;
        sArr[473] = 2329;
        sArr[474] = 2325;
        sArr[475] = 2304;
        sArr[476] = 2333;
        sArr[477] = 2327;
        sArr[478] = 2388;
        sArr[479] = 2325;
        sArr[480] = 2320;
        sArr[481] = 2325;
        sArr[482] = 2308;
        sArr[483] = 2304;
        sArr[484] = 2321;
        sArr[485] = 2310;
        sArr[486] = 2382;
        sArr[487] = 2388;
        sArr[488] = 3153;
        sArr[489] = 3174;
        sArr[490] = 3186;
        sArr[491] = 3190;
        sArr[492] = 3174;
        sArr[493] = 3184;
        sArr[494] = 3191;
        sArr[495] = 3174;
        sArr[496] = 3175;
        sArr[497] = 3107;
        sArr[498] = 3180;
        sArr[499] = 3173;
        sArr[500] = 3173;
        sArr[501] = 3184;
        sArr[502] = 3168;
        sArr[503] = 3185;
        sArr[504] = 3174;
        sArr[505] = 3174;
        sArr[506] = 3181;
        sArr[507] = 3107;
        sArr[508] = 3187;
        sArr[509] = 3170;
        sArr[510] = 3172;
        sArr[511] = 3174;
        sArr[512] = 3107;
        sArr[513] = 3183;
        sArr[514] = 3178;
        sArr[515] = 3182;
        sArr[516] = 3178;
        sArr[517] = 3191;
        sArr[518] = 3107;
        sArr[519] = 2139;
        sArr[520] = 2063;
        sArr[521] = 2068;
        sArr[522] = 2068;
        sArr[523] = 2139;
        sArr[524] = 2056;
        sArr[525] = 2070;
        sArr[526] = 2074;
        sArr[527] = 2071;
        sArr[528] = 2071;
        sArr[529] = 2112;
        sArr[530] = 2139;
        sArr[531] = 2079;
        sArr[532] = 2078;
        sArr[533] = 2077;
        sArr[534] = 2074;
        sArr[535] = 2062;
        sArr[536] = 2071;
        sArr[537] = 2063;
        sArr[538] = 2066;
        sArr[539] = 2069;
        sArr[540] = 2076;
        sArr[541] = 2139;
        sArr[542] = 2063;
        sArr[543] = 2068;
        sArr[544] = 2139;
        sArr[545] = 2606;
        sArr[546] = 2577;
        sArr[547] = 2589;
        sArr[548] = 2575;
        sArr[549] = 2600;
        sArr[550] = 2585;
        sArr[551] = 2591;
        sArr[552] = 2589;
        sArr[553] = 2570;
        f40short = sArr;
        TAG = C0105.m44(f40short, 1754473 ^ C0008.m27((Object) "ۧۢۤ"), 1754603 ^ C0008.m27((Object) "ۧۦۡ"), C0008.m27((Object) "۠ۤۥ") ^ 1745108);
        int[] iArr = new int[((Integer) objArr[0]).intValue() ^ 5814409];
        iArr[0] = 16842931;
        LAYOUT_ATTRS = iArr;
        COMPARATOR = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
            AnonymousClass1() {
            }

            @Override // java.util.Comparator
            public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
                return itemInfo.position - itemInfo2.position;
            }
        };
        sInterpolator = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
            AnonymousClass2() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float floatValue = ((Float) new Object[]{new Float(1.0f)}[0]).floatValue();
                float f3 = f2 - floatValue;
                return floatValue + (f3 * f3 * f3 * f3 * f3);
            }
        };
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i2, ItemInfo itemInfo2) {
        int i3;
        float f2;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        Object[] objArr = {new Integer(-1037421), new Integer(-7219685), new Integer(-8825379), new Integer(4918928), new Integer(-3095644), new Integer(-8496841), new Integer(-2707930), new Integer(1914454), new Integer(2307813), new Integer(-9538574), new Integer(6394545), new Integer(1747997), new Integer(5398911), new Integer(7798020), new Integer(-2115373), new Integer(-5538571), new Integer(-3539864), new Integer(7013226), new Integer(-1417234), new Integer(-7166210), new Integer(-4029933), new Integer(4692169), new Float(1.0f)};
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f3 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i4 = itemInfo2.position;
            if (i4 < itemInfo.position) {
                int i5 = 0;
                float f4 = itemInfo2.offset + itemInfo2.widthFactor + f3;
                int intValue = ((Integer) objArr[10]).intValue();
                int i6 = 6394544;
                while (true) {
                    i4 = (intValue ^ i6) + i4;
                    if (i4 > itemInfo.position || i5 >= this.mItems.size()) {
                        break;
                    }
                    ItemInfo itemInfo5 = this.mItems.get(i5);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i4 <= itemInfo4.position || i5 >= (((Integer) objArr[5]).intValue() ^ 8496840) + this.mItems.size()) {
                            break;
                        }
                        i5 += ((Integer) objArr[3]).intValue() ^ 4918929;
                        itemInfo5 = this.mItems.get(i5);
                    }
                    while (i4 < itemInfo4.position) {
                        f4 += this.mAdapter.getPageWidth(i4) + f3;
                        i4 += ((Integer) objArr[17]).intValue() ^ 7013227;
                    }
                    itemInfo4.offset = f4;
                    f4 += itemInfo4.widthFactor + f3;
                    intValue = ((Integer) objArr[12]).intValue();
                    i6 = 5398910;
                }
            } else if (i4 > itemInfo.position) {
                int size = this.mItems.size() + (((Integer) objArr[0]).intValue() ^ 1037420);
                float f5 = itemInfo2.offset;
                int intValue2 = ((Integer) objArr[19]).intValue();
                int i7 = 7166209;
                while (true) {
                    i4 = (intValue2 ^ i7) + i4;
                    if (i4 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i4 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size += ((Integer) objArr[18]).intValue() ^ 1417233;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i4 > itemInfo3.position) {
                        f5 -= this.mAdapter.getPageWidth(i4) + f3;
                        i4 += ((Integer) objArr[2]).intValue() ^ 8825378;
                    }
                    f5 -= itemInfo3.widthFactor + f3;
                    itemInfo3.offset = f5;
                    intValue2 = ((Integer) objArr[4]).intValue();
                    i7 = 3095643;
                }
            }
        }
        int size2 = this.mItems.size();
        float f6 = itemInfo.offset;
        int intValue3 = itemInfo.position + (((Integer) objArr[20]).intValue() ^ 4029932);
        this.mFirstOffset = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
        int i8 = itemInfo.position;
        int intValue4 = ((Integer) objArr[6]).intValue();
        float floatValue = ((Float) objArr[22]).floatValue();
        this.mLastOffset = i8 == (2707929 ^ intValue4) + count ? (itemInfo.offset + itemInfo.widthFactor) - floatValue : Float.MAX_VALUE;
        int intValue5 = (((Integer) objArr[14]).intValue() ^ 2115372) + i2;
        while (intValue5 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(intValue5);
            while (true) {
                i3 = intValue3;
                f2 = f6;
                if (i3 <= itemInfo7.position) {
                    break;
                }
                PagerAdapter pagerAdapter = this.mAdapter;
                int intValue6 = ((Integer) objArr[16]).intValue();
                f6 = f2 - (pagerAdapter.getPageWidth(i3) + f3);
                intValue3 = (3539863 ^ intValue6) + i3;
            }
            f6 = f2 - (itemInfo7.widthFactor + f3);
            itemInfo7.offset = f6;
            if (itemInfo7.position == 0) {
                this.mFirstOffset = f6;
            }
            intValue5 += ((Integer) objArr[1]).intValue() ^ 7219684;
            intValue3 = (((Integer) objArr[15]).intValue() ^ 5538570) + i3;
        }
        float f7 = itemInfo.offset + itemInfo.widthFactor + f3;
        int intValue7 = itemInfo.position + (((Integer) objArr[21]).intValue() ^ 4692168);
        int intValue8 = (((Integer) objArr[11]).intValue() ^ 1747996) + i2;
        while (intValue8 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(intValue8);
            while (intValue7 < itemInfo8.position) {
                PagerAdapter pagerAdapter2 = this.mAdapter;
                int intValue9 = ((Integer) objArr[13]).intValue();
                float pageWidth = pagerAdapter2.getPageWidth(intValue7) + f3 + f7;
                intValue7 = (7798021 ^ intValue9) + intValue7;
                f7 = pageWidth;
            }
            if (itemInfo8.position == (((Integer) objArr[9]).intValue() ^ 9538573) + count) {
                this.mLastOffset = (itemInfo8.widthFactor + f7) - floatValue;
            }
            itemInfo8.offset = f7;
            f7 += itemInfo8.widthFactor + f3;
            int intValue10 = intValue8 + (((Integer) objArr[8]).intValue() ^ 2307812);
            intValue7 += ((Integer) objArr[7]).intValue() ^ 1914455;
            intValue8 = intValue10;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        Object[] objArr = {new Integer(9572399), new Integer(-4402545)};
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 += (int) ((i2 >= this.mCurItem ? 0.4f : 0.6f) + f2);
        } else if (i3 <= 0) {
            i2 += ((Integer) objArr[0]).intValue() ^ 9572398;
        }
        if (this.mItems.size() <= 0) {
            return i2;
        }
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        return Math.max(itemInfo.position, Math.min(i2, arrayList.get((((Integer) objArr[1]).intValue() ^ 4402544) + arrayList.size()).position));
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        Integer num = new Integer(5811887);
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4 = (((Integer) new Object[]{num}[0]).intValue() ^ 5811886) + i4) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i4);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i2, f2, i3);
        }
    }

    private void dispatchOnPageSelected(int i2) {
        Integer num = new Integer(4170692);
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 4170693) + i3) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        Integer num = new Integer(9884186);
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 9884187) + i3) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i2);
        }
    }

    private void enableLayers(boolean z) {
        Integer num = new Integer(6483255);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 6483254) + i2) {
            getChildAt(i2).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        ItemInfo itemInfo;
        Object[] objArr = {new Integer(-6085896), new Integer(1993457), new Integer(2711959), new Integer(9555820), new Integer(-8906429)};
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        int i2 = -1;
        int i3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        ItemInfo itemInfo2 = null;
        boolean z = true;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo3 = this.mItems.get(i3);
            if (z || itemInfo3.position == (((Integer) objArr[3]).intValue() ^ 9555821) + i2) {
                itemInfo = itemInfo3;
            } else {
                itemInfo = this.mTempItem;
                itemInfo.offset = f4 + f3 + f2;
                itemInfo.position = (((Integer) objArr[2]).intValue() ^ 2711958) + i2;
                itemInfo.widthFactor = this.mAdapter.getPageWidth(itemInfo.position);
                i3 += ((Integer) objArr[4]).intValue() ^ 8906428;
            }
            float f5 = itemInfo.offset;
            float f6 = itemInfo.widthFactor;
            if (!z && scrollX < f5) {
                return itemInfo2;
            }
            if (scrollX < f6 + f5 + f2 || i3 == (((Integer) objArr[0]).intValue() ^ 6085895) + this.mItems.size()) {
                return itemInfo;
            }
            int i4 = itemInfo.position;
            float f7 = itemInfo.widthFactor;
            i2 = i4;
            i3 = (((Integer) objArr[1]).intValue() ^ 1993456) + i3;
            f4 = f5;
            f3 = f7;
            z = false;
            itemInfo2 = itemInfo;
        }
        return itemInfo2;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i2) {
        int size = this.mItems.size();
        String m40 = C0104.m40(f40short, 1751625 ^ C0008.m27((Object) "ۣۤ۟"), 1752662 ^ C0008.m27((Object) "ۥۦۤ"), C0008.m27((Object) "ۢۥۡ") ^ 1749286);
        if (size == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException(m40);
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i3 = this.mPageMargin;
        int i4 = infoForCurrentScrollPosition.position;
        float f2 = ((i2 / clientWidth) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (i3 / clientWidth));
        this.mCalledSuper = false;
        onPageScrolled(i4, f2, (int) ((clientWidth + i3) * f2));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException(m40);
    }

    private boolean performDrag(float f2) {
        float f3;
        boolean z;
        boolean z2;
        float f4;
        boolean z3 = true;
        Object[] objArr = {new Integer(-4956898), new Integer(-4283388)};
        float f5 = this.mLastMotionX;
        this.mLastMotionX = f2;
        float scrollX = getScrollX() + (f5 - f2);
        int clientWidth = getClientWidth();
        float f6 = clientWidth * this.mFirstOffset;
        float f7 = clientWidth * this.mLastOffset;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get((((Integer) objArr[1]).intValue() ^ 4283387) + arrayList.size());
        if (itemInfo.position != 0) {
            z = false;
            f3 = itemInfo.offset * clientWidth;
        } else {
            f3 = f6;
            z = true;
        }
        if (itemInfo2.position != (((Integer) objArr[0]).intValue() ^ 4956897) + this.mAdapter.getCount()) {
            f4 = itemInfo2.offset * clientWidth;
            z2 = false;
        } else {
            z2 = true;
            f4 = f7;
        }
        if (scrollX < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
            } else {
                z3 = false;
            }
        } else if (scrollX > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
            } else {
                z3 = false;
            }
            f3 = f4;
        } else {
            z3 = false;
            f3 = scrollX;
        }
        this.mLastMotionX += f3 - ((int) f3);
        scrollTo((int) f3, getScrollY());
        pageScrolled((int) f3);
        return z3;
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
            return;
        }
        int paddingLeft = getPaddingLeft();
        scrollTo((int) ((((i2 - paddingLeft) - getPaddingRight()) + i4) * (getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))), getScrollY());
    }

    private void removeNonDecorViews() {
        Object[] objArr = {new Integer(-9343366), new Integer(5760594)};
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                removeViewAt(i2);
                i2 += ((Integer) objArr[0]).intValue() ^ 9343365;
            }
            i2 = (((Integer) objArr[1]).intValue() ^ 5760595) + i2;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        int i4;
        ItemInfo infoForPosition = infoForPosition(i2);
        if (infoForPosition != null) {
            i4 = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * getClientWidth());
        } else {
            i4 = 0;
        }
        if (z) {
            smoothScrollTo(i4, 0, i3);
            if (z2) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(i4, 0);
        pageScrolled(i4);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        Integer num = new Integer(1000958);
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 1000959) + i2) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        ItemInfo infoForChild;
        Integer num = new Integer(2122555);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4 = (((Integer) new Object[]{num}[0]).intValue() ^ 2122554) + i4) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    ItemInfo addNewItem(int i2, int i3) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i2;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i3, itemInfo);
        }
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        Integer num = new Integer(537173);
        for (int i2 = 0; i2 < getChildCount(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 537172) + i2) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.isDecor |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i2, generateLayoutParams);
        } else {
            if (layoutParams2 != null && layoutParams2.isDecor) {
                throw new IllegalStateException(C0105.m44(f40short, 56374 ^ C0008.m27((Object) "۠ۨ"), 1751500 ^ C0008.m27((Object) "ۤ۠ۡ"), C0008.m27((Object) "ۢۢۢ") ^ 1750210));
            }
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i2, generateLayoutParams);
        }
    }

    public boolean arrowScroll(int i2) {
        View view;
        boolean z;
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    }
                    if (parent == this) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(C0000.m1(f40short, 1749505 ^ C0008.m27((Object) "ۢ۠ۤ"), 1755349 ^ C0008.m27((Object) "ۨ۟ۨ"), C0008.m27((Object) "ۡۦۧ") ^ 1747420)).append(parent2.getClass().getSimpleName());
                    }
                    Log.e(C0005.m17(f40short, 1755509 ^ C0008.m27((Object) "ۨۧۥ"), 1752485 ^ C0008.m27((Object) "ۥ۠ۧ"), C0008.m27((Object) "ۣۡۢ") ^ 1749994), C0003.m11(f40short, 1753654 ^ C0008.m27((Object) "ۦۨ۟"), 1748756 ^ C0008.m27((Object) "ۡۦۡ"), C0008.m27((Object) "ۧۧۨ") ^ 1754489) + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus == null || findNextFocus == view) {
            if (i2 == 17 || i2 == 1) {
                pageLeft = pageLeft();
            } else {
                if (i2 == 66 || i2 == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            }
        } else if (i2 == 17) {
            pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageLeft();
        } else {
            if (i2 == 66) {
                pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left > getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageRight();
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return pageLeft;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean beginFakeDrag() {
        Integer num = new Integer(3931101);
        if (this.mIsBeingDragged) {
            return false;
        }
        boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 3931100;
        this.mFakeDragging = intValue;
        setScrollState(intValue ? 1 : 0);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return intValue;
    }

    protected boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(-6460337), new Integer(-9991318)};
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int intValue = (((Integer) objArr[1]).intValue() ^ 9991317) + viewGroup.getChildCount(); intValue >= 0; intValue = (((Integer) objArr[0]).intValue() ^ 6460336) + intValue) {
                View childAt = viewGroup.getChildAt(intValue);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && canScroll(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.mFirstOffset));
        }
        if (i2 > 0) {
            return scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void dataSetChanged() {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        Object[] objArr = {new Integer(330620), new Integer(-4807148), new Integer(2190951), new Integer(-4707833), new Integer(1879014)};
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        int size = this.mItems.size();
        int i4 = this.mOffscreenPageLimit;
        int intValue = ((Integer) objArr[4]).intValue();
        boolean intValue2 = 330621 ^ ((Integer) objArr[0]).intValue();
        boolean z3 = (size >= ((1879012 ^ intValue) * i4) + (intValue2 ? 1 : 0) || this.mItems.size() >= count) ? false : intValue2 ? 1 : 0;
        int i5 = 0;
        int i6 = this.mCurItem;
        boolean z4 = false;
        boolean z5 = z3;
        while (i5 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i5);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition == -1) {
                i2 = i5;
                z = z4;
                int i7 = i6;
                z2 = z5;
                i3 = i7;
            } else if (itemPosition == -2) {
                this.mItems.remove(i5);
                int intValue3 = i5 + (((Integer) objArr[1]).intValue() ^ 4807147);
                boolean z6 = z4;
                if (!z4) {
                    this.mAdapter.startUpdate((ViewGroup) this);
                    z6 = true;
                }
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                if (this.mCurItem == itemInfo.position) {
                    i2 = intValue3;
                    i3 = Math.max(0, Math.min(this.mCurItem, (((Integer) objArr[3]).intValue() ^ 4707832) + count));
                    z = z6;
                    z2 = true;
                } else {
                    i2 = intValue3;
                    i3 = i6;
                    z = z6;
                    z2 = true;
                }
            } else if (itemInfo.position != itemPosition) {
                if (itemInfo.position == this.mCurItem) {
                    i6 = itemPosition;
                }
                itemInfo.position = itemPosition;
                i2 = i5;
                i3 = i6;
                z = z4;
                z2 = true;
            } else {
                i2 = i5;
                z = z4;
                int i8 = i6;
                z2 = z5;
                i3 = i8;
            }
            z4 = z;
            i5 = i2 + (intValue2 ? 1 : 0);
            int i9 = i3;
            z5 = z2;
            i6 = i9;
        }
        if (z4) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z5) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10 = (((Integer) objArr[2]).intValue() ^ 2190950) + i10) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i6, false, intValue2);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        Integer num = new Integer(5491437);
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5491436) + i2) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f2) {
        Object[] objArr = {new Float(0.47123894f), new Float(0.5f)};
        return (float) Math.sin(((Float) objArr[0]).floatValue() * (f2 - ((Float) objArr[1]).floatValue()));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        boolean z = false;
        Object[] objArr = {new Float(270.0f), new Float(90.0f), new Float(1.0f)};
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(((Float) objArr[0]).floatValue());
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z = this.mLeftEdge.draw(canvas) | false;
                canvas.restoreToCount(save);
            }
            boolean z2 = z;
            if (this.mRightEdge.isFinished()) {
                z = z2;
            } else {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                canvas.rotate(((Float) objArr[1]).floatValue());
                canvas.translate(-getPaddingTop(), (-(((Float) objArr[2]).floatValue() + this.mLastOffset)) * width2);
                this.mRightEdge.setSize((height2 - paddingTop) - paddingBottom, width2);
                z = this.mRightEdge.draw(canvas) | z2;
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        Integer num = new Integer(4003470);
        if (!this.mFakeDragging) {
            throw new IllegalStateException(C0008.m24(f40short, 1751382 ^ C0008.m27((Object) "ۤ۠ۦ"), 1747728 ^ C0008.m27((Object) "۠ۢۥ"), C0008.m27((Object) "ۣۣ۟") ^ 1748978));
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(((Integer) new Object[]{num}[0]).intValue() ^ 4003174, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        Object[] objArr = {new Integer(315901), new Integer(2873159), new Integer(1876844), new Integer(614107)};
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            int intValue = ((Integer) objArr[1]).intValue() ^ 2873157;
            switch (keyCode) {
                case 21:
                    return keyEvent.hasModifiers(intValue) ? pageLeft() : arrowScroll(((Integer) objArr[3]).intValue() ^ 614090);
                case 22:
                    return keyEvent.hasModifiers(intValue) ? pageRight() : arrowScroll(((Integer) objArr[2]).intValue() ^ 1876782);
                case 61:
                    if (keyEvent.hasNoModifiers()) {
                        return arrowScroll(intValue);
                    }
                    int intValue2 = ((Integer) objArr[0]).intValue() ^ 315900;
                    if (keyEvent.hasModifiers(intValue2)) {
                        return arrowScroll(intValue2);
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

    public void fakeDragBy(float f2) {
        Object[] objArr = {new Integer(9437801), new Integer(-9920473), new Integer(-2925217)};
        if (!this.mFakeDragging) {
            throw new IllegalStateException(C0107.m50(f40short, 1755559 ^ C0008.m27((Object) "ۣۣۨ"), 1748909 ^ C0008.m27((Object) "ۡۨۥ"), C0008.m27((Object) "ۦ۠ۦ") ^ 1754357));
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f2;
        float scrollX = getScrollX() - f2;
        int clientWidth = getClientWidth();
        float f3 = clientWidth * this.mFirstOffset;
        float f4 = clientWidth * this.mLastOffset;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get((((Integer) objArr[2]).intValue() ^ 2925216) + arrayList.size());
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * clientWidth;
        }
        float f5 = itemInfo2.position != (((Integer) objArr[1]).intValue() ^ 9920472) + this.mAdapter.getCount() ? itemInfo2.offset * clientWidth : f4;
        if (scrollX >= f3) {
            f3 = scrollX > f5 ? f5 : scrollX;
        }
        this.mLastMotionX += f3 - ((int) f3);
        scrollTo((int) f3, getScrollY());
        pageScrolled((int) f3);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), ((Integer) objArr[0]).intValue() ^ 9437803, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        Integer num = new Integer(-6336453);
        if (this.mDrawingOrder == 2) {
            i3 = ((((Integer) new Object[]{num}[0]).intValue() ^ 6336452) + i2) - i3;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return null;
    }

    ItemInfo infoForChild(View view) {
        Integer num = new Integer(5864474);
        for (int i2 = 0; i2 < this.mItems.size(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5864475) + i2) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i2) {
        Integer num = new Integer(5815218);
        for (int i3 = 0; i3 < this.mItems.size(); i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 5815219) + i3) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (itemInfo.position == i2) {
                return itemInfo;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void initViewPager() {
        Object[] objArr = {new Float(400.0f), new Float(2.0f), new Float(16.0f), new Integer(3562033), new Integer(978723), new Float(25.0f)};
        setWillNotDraw(false);
        setDescendantFocusability(((Integer) objArr[3]).intValue() ^ 3299889);
        boolean intValue = 978722 ^ ((Integer) objArr[4]).intValue();
        setFocusable(intValue);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (((Float) objArr[0]).floatValue() * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (((Float) objArr[5]).floatValue() * f2);
        this.mCloseEnough = (int) (((Float) objArr[1]).floatValue() * f2);
        this.mDefaultGutterSize = (int) (((Float) objArr[2]).floatValue() * f2);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, intValue ? 1 : 0);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewPager.4
            private final Rect mTempRect = new Rect();

            AnonymousClass4() {
            }

            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Integer num = new Integer(5194899);
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.isConsumed()) {
                    return onApplyWindowInsets;
                }
                Rect rect = this.mTempRect;
                rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5194898) + i2) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i2), onApplyWindowInsets);
                    rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        ItemInfo itemInfo;
        float f2;
        float f3;
        Object[] objArr = {new Integer(3698841), new Integer(1933065), new Integer(-9899386)};
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f4 = this.mPageMargin / width;
        ItemInfo itemInfo2 = this.mItems.get(0);
        float f5 = itemInfo2.offset;
        int size = this.mItems.size();
        int i3 = itemInfo2.position;
        int i4 = this.mItems.get((((Integer) objArr[2]).intValue() ^ 9899385) + size).position;
        float f6 = f5;
        int i5 = 0;
        int i6 = i3;
        while (i6 < i4) {
            while (true) {
                i2 = i5;
                itemInfo = itemInfo2;
                if (i6 <= itemInfo.position || i2 >= size) {
                    break;
                }
                ArrayList<ItemInfo> arrayList = this.mItems;
                i5 = i2 + (((Integer) objArr[1]).intValue() ^ 1933064);
                itemInfo2 = arrayList.get(i5);
            }
            if (i6 == itemInfo.position) {
                f3 = (itemInfo.offset + itemInfo.widthFactor) * width;
                f2 = itemInfo.offset + itemInfo.widthFactor + f4;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i6);
                f2 = pageWidth + f4 + f6;
                f3 = (pageWidth + f6) * width;
            }
            if (this.mPageMargin + f3 > scrollX) {
                this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(this.mPageMargin + f3), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            }
            if (f3 > scrollX + width) {
                return;
            }
            i6 = (((Integer) objArr[0]).intValue() ^ 3698840) + i6;
            f6 = f2;
            itemInfo2 = itemInfo;
            i5 = i2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object[] objArr = {new Float(0.5f), new Integer(8207755)};
        int intValue = (((Integer) objArr[1]).intValue() ^ 8207732) & motionEvent.getAction();
        if (intValue == 3 || intValue == 1) {
            resetTouch();
            return false;
        }
        if (intValue != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        switch (intValue) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    break;
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                    break;
                }
                break;
            case 2:
                int i2 = this.mActivePointerId;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.mLastMotionX;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.mInitialMotionY);
                    if (f2 != 0.0f && !isGutterDrag(this.mLastMotionX, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    int i3 = this.mTouchSlop;
                    if (abs > i3 && ((Float) objArr[0]).floatValue() * abs > abs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        this.mLastMotionX = f2 > 0.0f ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                        this.mLastMotionY = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > i3) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ItemInfo infoForChild;
        int i6;
        int i7;
        int i8;
        int i9;
        int max;
        int i10;
        int i11;
        Object[] objArr = {new Integer(8339804), new Integer(4893155), new Integer(977881), new Integer(9029653), new Integer(9980384), new Integer(3095989), new Integer(1074628807), new Integer(1454859)};
        int childCount = getChildCount();
        int i12 = i4 - i2;
        int i13 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i14 = 0;
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i16 = layoutParams.gravity;
                    int intValue = ((Integer) objArr[1]).intValue();
                    int i17 = layoutParams.gravity;
                    int intValue2 = ((Integer) objArr[7]).intValue();
                    switch ((4893156 ^ intValue) & i16) {
                        case 1:
                            max = Math.max((i12 - childAt.getMeasuredWidth()) / (((Integer) objArr[2]).intValue() ^ 977883), paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            max = paddingLeft;
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i12 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                    }
                    switch ((1454971 ^ intValue2) & i17) {
                        case 16:
                            i10 = paddingBottom;
                            i11 = paddingTop;
                            paddingTop = Math.max((i13 - childAt.getMeasuredHeight()) / (((Integer) objArr[5]).intValue() ^ 3095991), paddingTop);
                            break;
                        case 48:
                            i10 = paddingBottom;
                            i11 = childAt.getMeasuredHeight() + paddingTop;
                            break;
                        case 80:
                            int measuredHeight = (i13 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingBottom;
                            i11 = paddingTop;
                            paddingTop = measuredHeight;
                            i10 = measuredHeight2;
                            break;
                        default:
                            i10 = paddingBottom;
                            i11 = paddingTop;
                            break;
                    }
                    int i18 = max + scrollX;
                    childAt.layout(i18, paddingTop, childAt.getMeasuredWidth() + i18, childAt.getMeasuredHeight() + paddingTop);
                    int intValue3 = (((Integer) objArr[3]).intValue() ^ 9029652) + i14;
                    i8 = paddingRight;
                    i7 = i11;
                    paddingBottom = i10;
                    i9 = paddingLeft;
                    i6 = intValue3;
                } else {
                    i6 = i14;
                    i7 = paddingTop;
                    i8 = paddingRight;
                    i9 = paddingLeft;
                }
            } else {
                i6 = i14;
                i7 = paddingTop;
                i8 = paddingRight;
                i9 = paddingLeft;
            }
            i15 = (((Integer) objArr[0]).intValue() ^ 8339805) + i15;
            paddingLeft = i9;
            paddingRight = i8;
            paddingTop = i7;
            i14 = i6;
        }
        int i19 = (i12 - paddingLeft) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20 = (((Integer) objArr[4]).intValue() ^ 9980385) + i20) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    int i21 = ((int) (infoForChild.offset * i19)) + paddingLeft;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        int i22 = (int) (layoutParams2.widthFactor * i19);
                        int intValue4 = ((Integer) objArr[6]).intValue() ^ 886983;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec(i22, intValue4), View.MeasureSpec.makeMeasureSpec((i13 - paddingTop) - paddingBottom, intValue4));
                    }
                    childAt2.layout(i21, paddingTop, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i13 - paddingBottom;
        this.mDecorChildCount = i14;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i4;
        int i5;
        Object[] objArr = {new Integer(9672453), new Integer(2270326), new Integer(2044730), new Integer(5745919), new Integer(3676611), new Integer(1082308969)};
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / (((Integer) objArr[0]).intValue() ^ 9672463), this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6 = (((Integer) objArr[3]).intValue() ^ 5745918) + i6) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int intValue = layoutParams2.gravity & (((Integer) objArr[2]).intValue() ^ 2044733);
                int intValue2 = layoutParams2.gravity & (((Integer) objArr[1]).intValue() ^ 2270214);
                int i7 = Integer.MIN_VALUE;
                int i8 = Integer.MIN_VALUE;
                boolean z = intValue2 == 48 || intValue2 == 80;
                boolean z2 = intValue == 3 || intValue == 5;
                if (z) {
                    i7 = 1073741824;
                } else if (z2) {
                    i8 = 1073741824;
                }
                if (layoutParams2.width != -2) {
                    i7 = 1073741824;
                    i4 = layoutParams2.width != -1 ? layoutParams2.width : paddingLeft;
                } else {
                    i4 = paddingLeft;
                }
                if (layoutParams2.height == -2) {
                    i5 = measuredHeight;
                } else if (layoutParams2.height != -1) {
                    i5 = layoutParams2.height;
                    i8 = 1073741824;
                } else {
                    i8 = 1073741824;
                    i5 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i7), View.MeasureSpec.makeMeasureSpec(i5, i8));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
        }
        int intValue3 = ((Integer) objArr[5]).intValue() ^ 8567145;
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, intValue3);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, intValue3);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9 = (((Integer) objArr[4]).intValue() ^ 3676610) + i9) {
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (layoutParams.widthFactor * paddingLeft), intValue3), this.mChildHeightMeasureSpec);
            }
        }
    }

    protected void onPageScrolled(int i2, float f2, int i3) {
        int max;
        int i4;
        int i5;
        Object[] objArr = {new Integer(8826512), new Integer(9247681), new Integer(4646853), new Integer(7690377)};
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i6 = 0;
            while (i6 < childCount) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    switch ((((Integer) objArr[2]).intValue() ^ 4646850) & layoutParams.gravity) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / (((Integer) objArr[1]).intValue() ^ 9247683), paddingLeft);
                            int i7 = paddingRight;
                            i4 = paddingLeft;
                            i5 = i7;
                            break;
                        case 2:
                        case 4:
                        default:
                            max = paddingLeft;
                            int i8 = paddingRight;
                            i4 = paddingLeft;
                            i5 = i8;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i9 = paddingLeft;
                            i5 = paddingRight;
                            i4 = width2;
                            max = i9;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth = paddingRight + childAt.getMeasuredWidth();
                            i4 = paddingLeft;
                            i5 = measuredWidth;
                            break;
                    }
                    int left = (max + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i10 = paddingRight;
                    i4 = paddingLeft;
                    i5 = i10;
                }
                i6 = (((Integer) objArr[0]).intValue() ^ 8826513) + i6;
                int i11 = i5;
                paddingLeft = i4;
                paddingRight = i11;
            }
        }
        dispatchOnPageScrolled(i2, f2, i3);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i12 = 0; i12 < childCount2; i12 = (((Integer) objArr[3]).intValue() ^ 7690376) + i12) {
                View childAt2 = getChildAt(i12);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        ItemInfo infoForChild;
        Object[] objArr = {new Integer(3330865), new Integer(-4124482)};
        int childCount = getChildCount();
        if (((((Integer) objArr[0]).intValue() ^ 3330867) & i2) != 0) {
            i3 = 1;
            i4 = 0;
        } else {
            int intValue = (((Integer) objArr[1]).intValue() ^ 4124481) + childCount;
            childCount = -1;
            i3 = -1;
            i4 = intValue;
        }
        while (i4 != childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        Object[] objArr = {new Integer(8706112), new Integer(7999428)};
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch ((((Integer) objArr[1]).intValue() ^ 7999291) & motionEvent.getAction()) {
            case 0:
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(((Integer) objArr[0]).intValue() ^ 8706984, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    this.mPopulatePending = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (this.mPageMargin / clientWidth)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                    z = resetTouch();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z = resetTouch();
                        break;
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f2 = this.mInitialMotionX;
                            this.mLastMotionX = x2 - f2 > 0.0f ? f2 + this.mTouchSlop : f2 - this.mTouchSlop;
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId))) | false;
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, 0, false);
                    z = resetTouch();
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionX = motionEvent.getX(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean pageLeft() {
        Integer num = new Integer(322687);
        int i2 = this.mCurItem;
        if (i2 <= 0) {
            return false;
        }
        boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 322686;
        setCurrentItem(i2 - (intValue ? 1 : 0), intValue);
        return intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean pageRight() {
        Integer num = new Integer(781720);
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            int i2 = this.mCurItem;
            int count = pagerAdapter.getCount();
            boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 781721;
            if (i2 < count - (intValue ? 1 : 0)) {
                setCurrentItem(this.mCurItem + (intValue ? 1 : 0), intValue);
                return intValue;
            }
        }
        return false;
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0188, code lost:
    
        if (r2.position == r17.mCurItem) goto L206;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void populate(int r18) {
        /*
            Method dump skipped, instructions count: 1484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Object[] objArr = {new Integer(7962875), new Integer(2713802)};
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2 = (((Integer) objArr[1]).intValue() ^ 2713803) + i2) {
                ItemInfo itemInfo = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i3 = 0; i3 < size; i3 = (((Integer) objArr[0]).intValue() ^ 7962874) + i3) {
            this.mAdapterChangeListeners.get(i3).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i2, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        setCurrentItemInternal(i2, z, z2, 0);
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        Object[] objArr = {new Integer(-9385657), new Integer(3827765)};
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.mCurItem == i2 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.mAdapter.getCount()) {
            i2 = this.mAdapter.getCount() + (((Integer) objArr[0]).intValue() ^ 9385656);
        }
        int i4 = this.mOffscreenPageLimit;
        int i5 = this.mCurItem;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.mItems.size(); i6 = (((Integer) objArr[1]).intValue() ^ 3827764) + i6) {
                this.mItems.get(i6).scrolling = true;
            }
        }
        boolean z3 = this.mCurItem != i2;
        if (!this.mFirstLayout) {
            populate(i2);
            scrollToItem(i2, z, i3, z3);
        } else {
            this.mCurItem = i2;
            if (z3) {
                dispatchOnPageSelected(i2);
            }
            requestLayout();
        }
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i2) {
        int intValue = ((Integer) new Object[]{new Integer(2935997)}[0]).intValue() ^ 2935996;
        if (i2 < intValue) {
            Log.w(C0104.m40(f40short, 56866 ^ C0008.m27((Object) "ۣ۠"), C0008.m27((Object) "۟") ^ 1750, C0008.m27((Object) "ۡۦۨ") ^ 1746203), C0003.m11(f40short, 1754120 ^ C0008.m27((Object) "ۧۦ۟"), 1751707 ^ C0008.m27((Object) "ۤۥۥ"), C0008.m27((Object) "ۤۥۡ") ^ 1750659) + i2 + C0008.m24(f40short, 1747150 ^ C0008.m27((Object) "۠۟ۨ"), 1748664 ^ C0008.m27((Object) "ۡ۠ۡ"), C0008.m27((Object) "ۥ۟ۦ") ^ 1750519) + intValue);
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i2) {
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, ((Integer) new Object[]{new Integer(323839)}[0]).intValue() ^ 323837);
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i2) {
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.mDrawingOrder = z ? 2 : 1;
            this.mPageTransformerLayerType = i2;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    void setScrollState(int i2) {
        if (this.mScrollState == i2) {
            return;
        }
        this.mScrollState = i2;
        if (this.mPageTransformer != null) {
            enableLayers(i2 != 0);
        }
        dispatchOnScrollStateChanged(i2);
    }

    void smoothScrollTo(int i2, int i3) {
        smoothScrollTo(i2, i3, 0);
    }

    void smoothScrollTo(int i2, int i3, int i4) {
        int scrollX;
        Object[] objArr = {new Integer(1015170), new Integer(7182787), new Float(1.0f), new Float(100.0f), new Float(1000.0f), new Integer(3853711), new Integer(8554776)};
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            int currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(((Integer) objArr[1]).intValue() ^ 7182785);
        int clientWidth = getClientWidth();
        int intValue = clientWidth / (((Integer) objArr[6]).intValue() ^ 8554778);
        float abs = Math.abs(i5);
        float floatValue = ((Float) objArr[2]).floatValue();
        float f2 = intValue;
        float f3 = intValue;
        float distanceInfluenceForSnapDuration = distanceInfluenceForSnapDuration(Math.min(floatValue, (abs * floatValue) / clientWidth));
        int abs2 = Math.abs(i4);
        int min = Math.min(abs2 > 0 ? (((Integer) objArr[0]).intValue() ^ 1015174) * Math.round(((Float) objArr[4]).floatValue() * Math.abs(((f3 * distanceInfluenceForSnapDuration) + f2) / abs2)) : (int) (((Float) objArr[3]).floatValue() * ((Math.abs(i5) / ((clientWidth * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + floatValue)), ((Integer) objArr[5]).intValue() ^ 3854295);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(scrollX, scrollY, i5, i6, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }
}
