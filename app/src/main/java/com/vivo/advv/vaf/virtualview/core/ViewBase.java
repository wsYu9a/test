package com.vivo.advv.vaf.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Trace;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.vivo.advv.Utils;
import com.vivo.advv.expr.common.ExprCode;
import com.vivo.advv.vaf.expr.engine.ExprEngine;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.ViewManager;
import com.vivo.advv.vaf.virtualview.Helper.ImageLoader;
import com.vivo.advv.vaf.virtualview.Helper.RtlHelper;
import com.vivo.advv.vaf.virtualview.Helper.VirtualViewUtils;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayout;
import com.vivo.advv.vaf.virtualview.view.nlayout.INativeLayoutImpl;
import com.vivo.advv.virtualview.common.StringBase;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class ViewBase implements IView {
    public static final Pattern EL_PATTERN = Pattern.compile("\\$\\{.*\\}");
    private static final String TAG = "ViewBase_TMTEST";
    public static final String TYPE = "type";
    private boolean disableRtl;
    private boolean isPaddingBottomSet;
    private boolean isPaddingLeftSet;
    private boolean isPaddingRightSet;
    private boolean isPaddingTopSet;
    protected String mAction;
    protected String mActionParam;
    protected ExprCode mAfterLoadDataCode;
    protected String mBackgroundImagePath;
    protected IBean mBean;
    protected ExprCode mBeforeLoadDataCode;
    protected String[] mCheckList;
    protected String mClass;
    protected ExprCode mClickCode;
    protected Rect mContentRect;
    protected VafContext mContext;
    protected String mData;
    protected String mDataParam;
    protected String mDataTag;
    protected String mDataUrl;
    protected View mDisplayViewContainer;
    protected int mDrawLeft;
    protected int mDrawTop;
    protected boolean mIsDrawed;
    protected Object mJSONData;
    private ConcurrentHashMap<String, Object> mKeyedTags;
    protected int mMeasuredHeight;
    protected int mMeasuredWidth;
    private int mPadding;
    protected Paint mPaint;
    protected Layout.Params mParams;
    protected Layout mParent;
    protected ExprCode mSetDataCode;
    protected Object mTag;
    protected SparseArray<UserVarItem> mUserVarItems;
    protected ViewCache mViewCache;
    protected boolean mLoadedBackgroundImagePath = false;
    protected Bitmap mBackgroundImage = null;
    protected Matrix mMatrixBG = null;
    protected int mBorderWidth = 0;
    protected int mBorderColor = -16777216;
    protected int mBorderRadius = 0;
    protected int mBorderTopLeftRadius = 0;
    protected int mBorderTopRightRadius = 0;
    protected int mBorderBottomLeftRadius = 0;
    protected int mBorderBottomRightRadius = 0;
    protected float mAlpha = Float.NaN;
    protected int mVisibility = 1;
    protected int mDataMode = 1;
    protected int mAutoDimDirection = 0;
    protected float mAutoDimX = 1.0f;
    protected float mAutoDimY = 1.0f;
    private boolean mCheckListSet = false;
    protected boolean mParseValueFinished = false;
    protected int mDynamicMaterialType = -1;
    protected SparseArray<String> mFailGetValueFromEls = new SparseArray<>();
    protected float mScaleFactor = 1.0f;
    protected int mBackground = 0;
    protected int mGravity = 9;
    protected int mFlag = 0;
    protected int mPaddingLeft = 0;
    protected int mPaddingTop = 0;
    protected int mPaddingRight = 0;
    protected int mPaddingBottom = 0;
    protected int mMinWidth = 0;
    protected int mMinHeight = 0;
    protected int mId = -1;
    protected String mName = "";
    protected String mViewType = "";
    protected int mVersion = 0;
    protected int mUuid = 0;

    /* renamed from: com.vivo.advv.vaf.virtualview.core.ViewBase$1 */
    class AnonymousClass1 implements ImageLoader.Listener {
        AnonymousClass1() {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadFailed() {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Drawable drawable) {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(byte[] bArr, File file) {
            ViewBase.this.setBackgroundImage(bArr, file);
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Bitmap bitmap) {
            ViewBase.this.setBackgroundImage(bitmap);
        }
    }

    public interface IBuilder {
        ViewBase build(VafContext vafContext, ViewCache viewCache);
    }

    static class UserVarItem {
        int mType;
        Object mValue;

        public UserVarItem(int i2, Object obj) {
            this.mType = i2;
            this.mValue = obj;
        }
    }

    protected class VirtualViewImp implements IView {
        protected boolean mContentChanged;
        protected ViewBase mViewBase;
        protected int mPreWidthMeasureSpec = 0;
        protected int mPreHeightMeasureSpec = 0;

        public VirtualViewImp() {
            Paint paint = new Paint();
            ViewBase.this.mPaint = paint;
            paint.setAntiAlias(true);
            reset();
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public void comLayout(int i2, int i3, int i4, int i5) {
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public int getComMeasuredHeight() {
            return 0;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public int getComMeasuredWidth() {
            return 0;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public void measureComponent(int i2, int i3) {
            if (i2 == this.mPreWidthMeasureSpec && i3 == this.mPreHeightMeasureSpec && !this.mContentChanged) {
                return;
            }
            onComMeasure(i2, i3);
            this.mPreWidthMeasureSpec = i2;
            this.mPreHeightMeasureSpec = i3;
            this.mContentChanged = false;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // com.vivo.advv.vaf.virtualview.core.IView
        public void onComMeasure(int i2, int i3) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            ViewBase viewBase = ViewBase.this;
            if (viewBase.mContentRect == null) {
                viewBase.makeContentRect();
            }
            ViewBase viewBase2 = this.mViewBase;
            int i4 = viewBase2.mAutoDimDirection;
            float f2 = viewBase2.mAutoDimX;
            float f3 = viewBase2.mAutoDimY;
            if (i4 > 0) {
                if (i4 == 1) {
                    if (1073741824 == View.MeasureSpec.getMode(i2)) {
                        ViewBase.this.mMeasuredWidth = View.MeasureSpec.getSize(i2);
                        ViewBase.this.mMeasuredHeight = (int) ((r10.mMeasuredWidth * f3) / f2);
                        return;
                    }
                    return;
                }
                if (i4 == 2) {
                    if (1073741824 == View.MeasureSpec.getMode(i3)) {
                        ViewBase.this.mMeasuredHeight = View.MeasureSpec.getSize(i3);
                        ViewBase.this.mMeasuredWidth = (int) ((r10.mMeasuredHeight * f2) / f3);
                        return;
                    }
                    return;
                }
            }
            ViewBase viewBase3 = ViewBase.this;
            int i5 = viewBase3.mParams.mLayoutWidth;
            if (-2 == i5) {
                Rect rect = viewBase3.mContentRect;
                if (rect != null) {
                    float width = rect.width();
                    ViewBase viewBase4 = ViewBase.this;
                    float f4 = viewBase4.mPaddingLeft;
                    float f5 = viewBase4.mScaleFactor;
                    viewBase3.mMeasuredWidth = (int) (width + (f4 * f5) + (viewBase4.mPaddingRight * f5));
                } else {
                    viewBase3.mMeasuredWidth = (int) (viewBase3.mMinWidth * viewBase3.mScaleFactor);
                }
            } else if (-1 == i5) {
                if (1073741824 == mode) {
                    viewBase3.mMeasuredWidth = size;
                } else {
                    viewBase3.mMeasuredWidth = 0;
                }
            } else if (1073741824 == mode) {
                viewBase3.mMeasuredWidth = size;
            } else {
                viewBase3.mMeasuredWidth = i5;
            }
            ViewBase viewBase5 = ViewBase.this;
            int i6 = viewBase5.mParams.mLayoutHeight;
            if (-2 == i6) {
                Rect rect2 = viewBase5.mContentRect;
                if (rect2 == null) {
                    viewBase5.mMeasuredHeight = (int) (viewBase5.mMinHeight * viewBase5.mScaleFactor);
                    return;
                }
                float height = rect2.height();
                ViewBase viewBase6 = ViewBase.this;
                float f6 = viewBase6.mPaddingTop;
                float f7 = viewBase6.mScaleFactor;
                viewBase5.mMeasuredHeight = (int) (height + (f6 * f7) + (viewBase6.mPaddingBottom * f7));
                return;
            }
            if (-1 == i6) {
                if (1073741824 == mode2) {
                    viewBase5.mMeasuredHeight = size2;
                    return;
                } else {
                    viewBase5.mMeasuredHeight = 0;
                    return;
                }
            }
            if (1073741824 == mode2) {
                viewBase5.mMeasuredHeight = size2;
            } else {
                viewBase5.mMeasuredHeight = i6;
            }
        }

        public void reset() {
            this.mPreWidthMeasureSpec = 0;
            this.mPreHeightMeasureSpec = 0;
            this.mContentChanged = false;
            ViewBase viewBase = ViewBase.this;
            viewBase.mBackgroundImage = null;
            viewBase.mBackgroundImagePath = null;
        }

        public void setAntiAlias(boolean z) {
            ViewBase.this.mPaint.setAntiAlias(z);
        }

        public void setViewBase(ViewBase viewBase) {
            this.mViewBase = viewBase;
        }
    }

    public ViewBase(VafContext vafContext, ViewCache viewCache) {
        this.mContext = vafContext;
        this.mViewCache = viewCache;
    }

    private void parseBean() {
        try {
            Class<? extends IBean> beanFor = this.mContext.getBeanManager().getBeanFor(this.mClass);
            if (beanFor != null && this.mBean == null) {
                IBean newInstance = beanFor.newInstance();
                if (newInstance instanceof IBean) {
                    IBean iBean = newInstance;
                    this.mBean = iBean;
                    iBean.init(this.mContext.forViewConstruction(), this);
                } else {
                    VVLog.e(TAG, this.mClass + " is not bean");
                }
            }
        } catch (IllegalAccessException e2) {
            VVLog.e(TAG, "error:" + e2);
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            VVLog.e(TAG, "error:" + e3);
            e3.printStackTrace();
        }
    }

    public void addUserVar(int i2, int i3, int i4) {
        if (this.mUserVarItems == null) {
            this.mUserVarItems = new SparseArray<>();
        }
        Object obj = null;
        if (i2 == 1) {
            obj = Integer.valueOf(i4);
        } else if (i2 == 2) {
            obj = Float.valueOf(Float.intBitsToFloat(i4));
        } else if (i2 == 3) {
            obj = this.mContext.getStringLoader().getString(i4);
        }
        this.mUserVarItems.put(i3, new UserVarItem(i2, obj));
    }

    public void appendData(Object obj) {
        IBean iBean = this.mBean;
        if (iBean != null) {
            iBean.appendData(obj);
        }
    }

    @Deprecated
    public final boolean canHandleEvent() {
        return (this.mFlag & 2) != 0;
    }

    protected boolean changeVisibility() {
        int decideFinalVisibility = decideFinalVisibility();
        View nativeView = getNativeView();
        if (nativeView != null) {
            if (decideFinalVisibility == 0) {
                nativeView.setVisibility(4);
                return true;
            }
            if (decideFinalVisibility == 1) {
                nativeView.setVisibility(0);
                return true;
            }
            if (decideFinalVisibility != 2) {
                return true;
            }
            nativeView.setVisibility(8);
            return true;
        }
        if (!isContainer()) {
            return false;
        }
        if (decideFinalVisibility == 0) {
            this.mViewCache.getHolderView().setVisibility(4);
            return true;
        }
        if (decideFinalVisibility == 1) {
            this.mViewCache.getHolderView().setVisibility(0);
            return true;
        }
        if (decideFinalVisibility != 2) {
            return true;
        }
        this.mViewCache.getHolderView().setVisibility(8);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void check() {
        /*
            r10 = this;
            java.lang.String[] r0 = r10.mCheckList
            if (r0 == 0) goto L70
            int r0 = r0.length
            if (r0 <= 0) goto L70
            android.util.SparseArray<java.lang.String> r0 = r10.mFailGetValueFromEls
            int r0 = r0.size()
            if (r0 <= 0) goto L70
            r0 = 0
            r1 = 0
        L11:
            android.util.SparseArray<java.lang.String> r2 = r10.mFailGetValueFromEls
            int r2 = r2.size()
            if (r1 >= r2) goto L70
            android.util.SparseArray<java.lang.String> r2 = r10.mFailGetValueFromEls
            int r2 = r2.keyAt(r1)
            r3 = 0
        L20:
            java.lang.String[] r4 = r10.mCheckList
            int r5 = r4.length
            if (r3 >= r5) goto L6d
            r5 = r4[r3]
            if (r5 == 0) goto L6a
            r4 = r4[r3]
            int r4 = r4.hashCode()
            if (r4 != r2) goto L6a
            android.util.SparseArray<java.lang.String> r4 = r10.mFailGetValueFromEls
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            android.os.Looper r5 = android.os.Looper.getMainLooper()
            java.lang.Thread r5 = r5.getThread()
            long r5 = r5.getId()
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            long r7 = r7.getId()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L52
            goto L6a
        L52:
            com.vivo.advv.vaf.virtualview.core.ELIllegalArgumentException r0 = new com.vivo.advv.vaf.virtualview.core.ELIllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r0.<init>(r2, r1)
            throw r0
        L6a:
            int r3 = r3 + 1
            goto L20
        L6d:
            int r1 = r1 + 1
            goto L11
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.core.ViewBase.check():void");
    }

    public void clear(int i2) {
        this.mFlag = (i2 ^ (-1)) & this.mFlag;
    }

    public boolean click(int i2, int i3, boolean z, IContainer iContainer, IActionListener iActionListener) {
        return clickRoute(i2, i3, this.mId, z, iContainer, iActionListener);
    }

    protected boolean clickRoute(int i2, int i3, int i4, boolean z, IContainer iContainer, IActionListener iActionListener) {
        return z ? onLongClick(i2, i3, i4, iContainer, iActionListener) : onClick(i2, i3, i4, iContainer, iActionListener);
    }

    public void comDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mDrawLeft, this.mDrawTop);
        onComDraw(canvas);
        canvas.restore();
        this.mIsDrawed = true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        this.mDrawLeft = i2;
        this.mDrawTop = i3;
        onComLayout(true, i2, i3, i4, i5);
    }

    public int decideFinalVisibility() {
        Layout layout = this.mParent;
        if (layout == null) {
            return this.mVisibility;
        }
        int decideFinalVisibility = layout.decideFinalVisibility();
        return decideFinalVisibility == 1 ? this.mVisibility : decideFinalVisibility == 0 ? 0 : 2;
    }

    public void destroy() {
        this.mContext = null;
        this.mBean = null;
        this.mUserVarItems = null;
    }

    public void drawBorder(Canvas canvas) {
        int i2 = this.mBorderColor;
        int i3 = this.mMeasuredWidth;
        int i4 = this.mMeasuredHeight;
        float f2 = this.mBorderWidth;
        float f3 = this.mScaleFactor;
        VirtualViewUtils.drawBorder(canvas, i2, i3, i4, (int) (f2 * f3), (int) (this.mBorderTopLeftRadius * f3), (int) (this.mBorderTopRightRadius * f3), (int) (this.mBorderBottomLeftRadius * f3), (int) (this.mBorderBottomRightRadius * f3));
    }

    public ViewBase findViewBaseById(int i2) {
        if (this.mId == i2) {
            return this;
        }
        return null;
    }

    public ViewBase findViewBaseByName(String str) {
        if (TextUtils.equals(this.mName, str)) {
            return this;
        }
        return null;
    }

    public final int getAbsoluteDrawLeft() {
        int i2 = this.mDrawLeft;
        for (Layout layout = this.mParent; layout != null; layout = layout.mParent) {
            if (layout instanceof INativeLayout) {
                i2 += layout.getDrawLeft();
            }
        }
        return i2;
    }

    public final int getAbsoluteDrawTop() {
        int i2 = this.mDrawTop;
        for (Layout layout = this.mParent; layout != null; layout = layout.mParent) {
            if (layout instanceof INativeLayout) {
                i2 += layout.getDrawTop();
            }
        }
        return i2;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getActionParam() {
        return this.mActionParam;
    }

    public int getAlign() {
        return this.mGravity;
    }

    public int getBackground() {
        return this.mBackground;
    }

    public IBean getBean() {
        return this.mBean;
    }

    public int getBorderBottomLeftRadius() {
        return this.mBorderBottomLeftRadius;
    }

    public int getBorderBottomRightRadius() {
        return this.mBorderBottomRightRadius;
    }

    public int getBorderRadius() {
        return this.mBorderRadius;
    }

    public int getBorderTopLeftRadius() {
        return this.mBorderTopLeftRadius;
    }

    public int getBorderTopRightRadius() {
        return this.mBorderTopRightRadius;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public ViewBase getChild(int i2) {
        return null;
    }

    public final int getComBaseline() {
        return 0;
    }

    public Layout.Params getComLayoutParams() {
        return this.mParams;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public final int getComMeasuredHeightWithMargin() {
        float comMeasuredHeight = getComMeasuredHeight();
        float f2 = this.mParams.mLayoutMarginTop;
        float f3 = this.mScaleFactor;
        return (int) (comMeasuredHeight + (f2 * f3) + (r1.mLayoutMarginBottom * f3));
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public final int getComMeasuredWidthWithMargin() {
        float comMeasuredWidth = getComMeasuredWidth();
        float f2 = this.mParams.mLayoutMarginLeft;
        float f3 = this.mScaleFactor;
        return (int) (comMeasuredWidth + (f2 * f3) + (r1.mLayoutMarginRight * f3));
    }

    public final int getComPaddingBottom() {
        return this.mPaddingBottom;
    }

    public final int getComPaddingLeft() {
        return this.mPaddingLeft;
    }

    public final int getComPaddingRight() {
        return this.mPaddingRight;
    }

    public final int getComPaddingTop() {
        return this.mPaddingTop;
    }

    public int getDataMode() {
        return this.mDataMode;
    }

    public String getDataParam() {
        return this.mDataParam;
    }

    public String getDataTag() {
        return this.mDataTag;
    }

    public String getDataUrl() {
        return this.mDataUrl;
    }

    public View getDisplayViewContainer() {
        return this.mDisplayViewContainer;
    }

    public final int getDrawLeft() {
        return this.mDrawLeft;
    }

    public final int getDrawTop() {
        return this.mDrawTop;
    }

    public int getDynamicMaterialType() {
        return this.mDynamicMaterialType;
    }

    public int getHeight() {
        return this.mMeasuredHeight;
    }

    public int getId() {
        return this.mId;
    }

    public Object getJSONData() {
        return this.mJSONData;
    }

    public String getName() {
        return this.mName;
    }

    public View getNativeView() {
        return null;
    }

    public ViewBase getParent() {
        Layout layout = this.mParent;
        return layout == null ? ((IContainer) this.mViewCache.getHolderView().getParent()).getVirtualView() : layout;
    }

    public Object getTag() {
        return this.mTag;
    }

    public Object getUserVar(int i2) {
        UserVarItem userVarItem;
        SparseArray<UserVarItem> sparseArray = this.mUserVarItems;
        if (sparseArray == null || (userVarItem = sparseArray.get(i2)) == null) {
            return null;
        }
        return userVarItem.mValue;
    }

    public int getUuid() {
        return this.mUuid;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public ViewCache getViewCache() {
        return this.mViewCache;
    }

    public String getViewType() {
        return this.mViewType;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        return this.mMeasuredWidth;
    }

    public boolean handleEvent(int i2, int i3) {
        return handleRoute(this.mId);
    }

    protected boolean handleRoute(int i2) {
        return onCheckHandle(i2);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final boolean isClickable() {
        return (this.mFlag & 32) != 0;
    }

    public boolean isContainer() {
        return false;
    }

    public boolean isGone() {
        return this.mVisibility == 2;
    }

    public final boolean isLongClickable() {
        return (this.mFlag & 64) != 0;
    }

    public final boolean isRealVisible() {
        return decideFinalVisibility() == 1;
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRtl() {
        return RtlHelper.isRtl() && !this.disableRtl;
    }

    public final boolean isTouchable() {
        return (this.mFlag & 128) != 0;
    }

    public final boolean isVisible() {
        return this.mVisibility == 1;
    }

    @Deprecated
    public void loadData() {
    }

    protected void makeContentRect() {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        int i4 = this.mAutoDimDirection;
        if (i4 > 0) {
            if (i4 != 1) {
                if (i4 == 2 && 1073741824 == View.MeasureSpec.getMode(scaleHeightMeasureSpec)) {
                    scaleWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleHeightMeasureSpec) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(scaleWidthMeasureSpec)) {
                scaleHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleWidthMeasureSpec) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        onComMeasure(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needCheck(int i2) {
        String[] strArr = this.mCheckList;
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.mCheckList;
            if (i3 >= strArr2.length) {
                return false;
            }
            if (strArr2[i3] != null && strArr2[i3].hashCode() == i2) {
                return true;
            }
            i3++;
        }
    }

    public void onAfterLoadData(boolean z) {
        if (this.mAfterLoadDataCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine == null || !exprEngine.execute(this, this.mAfterLoadDataCode)) {
                VVLog.e(TAG, "BeforeLoadDataCode execute failed");
            }
        }
    }

    public void onBeforeLoadData() {
        if (this.mBeforeLoadDataCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine == null || !exprEngine.execute(this, this.mBeforeLoadDataCode)) {
                VVLog.e(TAG, "mBeforeLoadDataCode execute failed");
            }
        }
    }

    protected boolean onCheckHandle(int i2) {
        return isClickable() || isLongClickable() || isTouchable();
    }

    protected boolean onClick(int i2, int i3, int i4, IContainer iContainer, IActionListener iActionListener) {
        View nativeView;
        IBean iBean = this.mBean;
        if (iBean != null) {
            iBean.click(i4, false);
        }
        View holderView = iContainer.getHolderView();
        if (holderView != null && this.mClickCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine != null) {
                exprEngine.getEngineContext().getDataManager().replaceData(getViewCache().getComponentData());
            }
            if (exprEngine == null || !exprEngine.execute(this, this.mClickCode)) {
                VVLog.e(TAG, "onClick execute failed");
            }
        }
        if (!isClickable() || !isRealVisible() || (nativeView = getNativeView()) == null) {
            return false;
        }
        int[] iArr = new int[2];
        holderView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        nativeView.getLocationOnScreen(iArr2);
        int i5 = i2 + iArr[0];
        int i6 = i3 + iArr[1];
        int i7 = i5 - iArr2[0];
        int i8 = i6 - iArr2[1];
        if (iActionListener != null) {
            return iActionListener.onClickAction(getAction(), iContainer, EventData.obtainData(this.mContext, this), i7, i8, i5, i6);
        }
        EventData obtainData = EventData.obtainData(this.mContext, this);
        obtainData.mContainer = iContainer;
        obtainData.x = i7;
        obtainData.y = i8;
        obtainData.rawX = i5;
        obtainData.rawY = i6;
        return this.mContext.getEventManager().emitEvent(0, obtainData);
    }

    protected void onComDraw(Canvas canvas) {
        if (getNativeView() == null) {
            int i2 = this.mBackground;
            if (i2 != 0) {
                int i3 = this.mMeasuredWidth;
                int i4 = this.mMeasuredHeight;
                float f2 = this.mBorderWidth;
                float f3 = this.mScaleFactor;
                VirtualViewUtils.drawBackground(canvas, i2, i3, i4, (int) (f2 * f3), (int) (this.mBorderTopLeftRadius * f3), (int) (this.mBorderTopRightRadius * f3), (int) (this.mBorderBottomLeftRadius * f3), (int) (this.mBorderBottomRightRadius * f3));
                return;
            }
            if (this.mBackgroundImage != null) {
                this.mMatrixBG.setScale(this.mMeasuredWidth / r0.getWidth(), this.mMeasuredHeight / this.mBackgroundImage.getHeight());
                canvas.drawBitmap(this.mBackgroundImage, this.mMatrixBG, null);
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (TextUtils.isEmpty(this.mBackgroundImagePath)) {
            return;
        }
        setBackgroundImage(this.mBackgroundImagePath);
    }

    public void onFailGetValueFromEl(int i2, String str) {
        this.mFailGetValueFromEls.put(i2, str);
    }

    protected boolean onLongClick(int i2, int i3, int i4, IContainer iContainer, IActionListener iActionListener) {
        View nativeView;
        IBean iBean = this.mBean;
        if (iBean != null) {
            iBean.click(i4, true);
        }
        View holderView = iContainer.getHolderView();
        if (holderView == null || !isLongClickable() || !isRealVisible() || (nativeView = getNativeView()) == null) {
            return false;
        }
        int[] iArr = new int[2];
        holderView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        nativeView.getLocationOnScreen(iArr2);
        int i5 = i2 + iArr[0];
        int i6 = i3 + iArr[1];
        int i7 = i5 - iArr2[0];
        int i8 = i6 - iArr2[1];
        if (iActionListener != null) {
            return iActionListener.onLongClickAction(getAction(), iContainer, EventData.obtainData(this.mContext, this), i7, i8, i5, i6);
        }
        EventData obtainData = EventData.obtainData(this.mContext, this);
        obtainData.mContainer = iContainer;
        obtainData.x = i7;
        obtainData.y = i8;
        obtainData.rawX = i5;
        obtainData.rawY = i6;
        return this.mContext.getEventManager().emitEvent(4, obtainData);
    }

    public void onParseValueFinished(float f2) {
        this.mParseValueFinished = true;
        this.mScaleFactor = f2;
        resolveRtlPropertiesIfNeeded();
        View nativeView = getNativeView();
        if (nativeView != null) {
            float f3 = this.mPaddingLeft;
            float f4 = this.mScaleFactor;
            nativeView.setPadding((int) (f3 * f4), (int) (this.mPaddingTop * f4), (int) (this.mPaddingRight * f4), (int) (this.mPaddingBottom * f4));
            if (!Float.isNaN(this.mAlpha)) {
                float f5 = this.mAlpha;
                if (f5 > 1.0f) {
                    this.mAlpha = 1.0f;
                } else if (f5 < 0.0f) {
                    this.mAlpha = 0.0f;
                }
                nativeView.setAlpha(this.mAlpha);
            }
        }
        if (TextUtils.isEmpty(this.mClass)) {
            return;
        }
        parseBean();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (isTouchable()) {
            return this.mContext.getEventManager().emitEvent(5, EventData.obtainData(this.mContext, this, view, motionEvent));
        }
        return false;
    }

    public void ready() {
        loadData();
    }

    public void refresh() {
        int i2 = this.mDrawLeft;
        int i3 = this.mDrawTop;
        refresh(i2, i3, this.mMeasuredWidth + i2, this.mMeasuredHeight + i3);
    }

    public void reset() {
        this.mContentRect = null;
        this.mIsDrawed = false;
        this.mLoadedBackgroundImagePath = false;
        this.mBackgroundImagePath = "";
    }

    public void resolveRtlPropertiesIfNeeded() {
        if (isRtl()) {
            int i2 = this.mPaddingLeft;
            this.mPaddingLeft = this.mPaddingRight;
            this.mPaddingRight = i2;
        }
    }

    public int rp2px(double d2) {
        ViewManager viewManager = this.mContext.getViewManager();
        return viewManager != null ? viewManager.rp2px(d2) : (int) d2;
    }

    protected boolean setAttribute(int i2, ExprCode exprCode) {
        if (i2 == -1351902487) {
            this.mClickCode = exprCode;
        } else if (i2 == -974184371) {
            this.mSetDataCode = exprCode;
        } else if (i2 == -251005427) {
            this.mAfterLoadDataCode = exprCode;
        } else {
            if (i2 != 361078798) {
                return false;
            }
            this.mBeforeLoadDataCode = exprCode;
        }
        return true;
    }

    protected boolean setAttribute(int i2, Object obj) {
        return false;
    }

    public void setAutoDimDirection(int i2) {
        this.mAutoDimDirection = i2;
    }

    public void setAutoDimX(float f2) {
        this.mAutoDimX = f2;
    }

    public void setAutoDimY(float f2) {
        this.mAutoDimY = f2;
    }

    public void setBackground(int i2) {
        this.mBackground = i2;
        refresh();
    }

    protected void setBackgroundColor(int i2) {
        this.mBackground = i2;
        View nativeView = getNativeView();
        if (nativeView == null || (nativeView instanceof INativeLayoutImpl)) {
            return;
        }
        nativeView.setBackgroundColor(i2);
    }

    protected void setBackgroundImage(Bitmap bitmap) {
        this.mBackgroundImage = bitmap;
        refresh();
    }

    protected void setBackgroundImage(byte[] bArr, File file) {
    }

    public void setBorderColor(int i2) {
        this.mBorderColor = i2;
        refresh();
    }

    public void setBorderWidth(int i2) {
        this.mBorderWidth = i2;
        refresh();
    }

    public final void setComLayoutParams(Layout.Params params) {
        this.mParams = params;
    }

    protected final void setComMeasuredDimension(int i2, int i3) {
        this.mMeasuredWidth = i2;
        this.mMeasuredHeight = i3;
    }

    public void setData(Object obj) {
        this.mJSONData = obj;
        IBean iBean = this.mBean;
        if (iBean != null) {
            iBean.setData(obj);
        }
        if (this.mSetDataCode != null) {
            ExprEngine exprEngine = this.mContext.getExprEngine();
            if (exprEngine == null || !exprEngine.execute(this, this.mSetDataCode)) {
                VVLog.e(TAG, "setData execute failed");
            }
        }
    }

    public void setDisplayViewContainer(View view) {
        this.mDisplayViewContainer = view;
    }

    public void setFlag(int i2, int i3) {
        this.mFlag = (i2 & i3) | (this.mFlag & (i3 ^ (-1)));
    }

    public final void setHoldView(View view) {
        this.mViewCache.setHoldView(view);
        if (softwareRender()) {
            view.setLayerType(1, null);
        }
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }

    protected boolean setPXAttribute(int i2, int i3) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                Layout.Params params = this.mParams;
                params.mLayoutMarginTop = i3;
                params.isLayoutMarginTopSet = true;
                break;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mPaddingLeft = i3;
                this.isPaddingLeftSet = true;
                break;
            case StringBase.STR_ID_minWidth /* -1375815020 */:
                this.mMinWidth = i3;
                break;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mBorderTopLeftRadius = i3;
                break;
            case StringBase.STR_ID_padding /* -806339567 */:
                this.mPadding = i3;
                if (!this.isPaddingLeftSet) {
                    this.mPaddingLeft = i3;
                }
                if (!this.isPaddingRightSet) {
                    this.mPaddingRight = i3;
                }
                if (!this.isPaddingTopSet) {
                    this.mPaddingTop = i3;
                }
                if (!this.isPaddingBottomSet) {
                    this.mPaddingBottom = i3;
                    break;
                }
                break;
            case StringBase.STR_ID_minHeight /* -133587431 */:
                this.mMinHeight = i3;
                break;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                Layout.Params params2 = this.mParams;
                params2.mLayoutMarginRight = i3;
                params2.isLayoutMarginRightSet = true;
                break;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mPaddingTop = i3;
                this.isPaddingTopSet = true;
                break;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mPaddingBottom = i3;
                this.isPaddingBottomSet = true;
                break;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mBorderTopRightRadius = i3;
                break;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mBorderBottomLeftRadius = i3;
                break;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mBorderBottomRightRadius = i3;
                break;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mPaddingRight = i3;
                this.isPaddingRightSet = true;
                break;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mBorderWidth = i3;
                break;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                Layout.Params params3 = this.mParams;
                params3.mLayoutMarginLeft = i3;
                params3.isLayoutMarginLeftSet = true;
                break;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                this.mBorderRadius = i3;
                if (this.mBorderTopLeftRadius <= 0) {
                    this.mBorderTopLeftRadius = i3;
                }
                if (this.mBorderTopRightRadius <= 0) {
                    this.mBorderTopRightRadius = i3;
                }
                if (this.mBorderBottomLeftRadius <= 0) {
                    this.mBorderBottomLeftRadius = i3;
                }
                if (this.mBorderBottomRightRadius <= 0) {
                    this.mBorderBottomRightRadius = i3;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                Layout.Params params4 = this.mParams;
                params4.mLayoutMarginBottom = i3;
                params4.isLayoutMarginBottomSet = true;
                break;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                this.mParams.mLayoutHeight = i3;
                break;
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                Layout.Params params5 = this.mParams;
                params5.mLayoutMargin = i3;
                if (!params5.isLayoutMarginLeftSet) {
                    params5.mLayoutMarginLeft = i3;
                }
                if (!params5.isLayoutMarginRightSet) {
                    params5.mLayoutMarginRight = i3;
                }
                if (!params5.isLayoutMarginTopSet) {
                    params5.mLayoutMarginTop = i3;
                }
                if (!params5.isLayoutMarginBottomSet) {
                    params5.mLayoutMarginBottom = i3;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                this.mParams.mLayoutWidth = i3;
                break;
        }
        return true;
    }

    public final boolean setPXValue(int i2, int i3) {
        Layout.Params params;
        boolean pXAttribute = setPXAttribute(i2, i3);
        return (pXAttribute || (params = this.mParams) == null) ? pXAttribute : params.setPXAttribute(i2, i3);
    }

    protected boolean setRPAttribute(int i2, float f2) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                this.mParams.mLayoutMarginTop = rp2px(f2);
                this.mParams.isLayoutMarginTopSet = true;
                break;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mPaddingLeft = rp2px(f2);
                this.isPaddingLeftSet = true;
                break;
            case StringBase.STR_ID_minWidth /* -1375815020 */:
                this.mMinWidth = rp2px(f2);
                break;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mBorderTopLeftRadius = rp2px(f2);
                break;
            case StringBase.STR_ID_padding /* -806339567 */:
                int rp2px = rp2px(f2);
                this.mPadding = rp2px;
                if (!this.isPaddingLeftSet) {
                    this.mPaddingLeft = rp2px;
                }
                if (!this.isPaddingRightSet) {
                    this.mPaddingRight = rp2px;
                }
                if (!this.isPaddingTopSet) {
                    this.mPaddingTop = rp2px;
                }
                if (!this.isPaddingBottomSet) {
                    this.mPaddingBottom = rp2px;
                    break;
                }
                break;
            case StringBase.STR_ID_minHeight /* -133587431 */:
                this.mMinHeight = rp2px(f2);
                break;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                this.mParams.mLayoutMarginRight = rp2px(f2);
                this.mParams.isLayoutMarginRightSet = true;
                break;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mPaddingTop = rp2px(f2);
                this.isPaddingTopSet = true;
                break;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mPaddingBottom = rp2px(f2);
                this.isPaddingBottomSet = true;
                break;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mBorderTopRightRadius = rp2px(f2);
                break;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mBorderBottomLeftRadius = rp2px(f2);
                break;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mBorderBottomRightRadius = rp2px(f2);
                break;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mPaddingRight = rp2px(f2);
                this.isPaddingRightSet = true;
                break;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mBorderWidth = rp2px(f2);
                break;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                this.mParams.mLayoutMarginLeft = rp2px(f2);
                this.mParams.isLayoutMarginLeftSet = true;
                break;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                int rp2px2 = rp2px(f2);
                this.mBorderRadius = rp2px2;
                if (this.mBorderTopLeftRadius <= 0) {
                    this.mBorderTopLeftRadius = rp2px2;
                }
                if (this.mBorderTopRightRadius <= 0) {
                    this.mBorderTopRightRadius = rp2px2;
                }
                if (this.mBorderBottomLeftRadius <= 0) {
                    this.mBorderBottomLeftRadius = rp2px2;
                }
                if (this.mBorderBottomRightRadius <= 0) {
                    this.mBorderBottomRightRadius = rp2px2;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                this.mParams.mLayoutMarginBottom = rp2px(f2);
                this.mParams.isLayoutMarginBottomSet = true;
                break;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                if (f2 <= -1.0f) {
                    this.mParams.mLayoutHeight = (int) f2;
                    break;
                } else {
                    this.mParams.mLayoutHeight = rp2px(f2);
                    break;
                }
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                this.mParams.mLayoutMargin = rp2px(f2);
                Layout.Params params = this.mParams;
                if (!params.isLayoutMarginLeftSet) {
                    params.mLayoutMarginLeft = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginRightSet) {
                    params.mLayoutMarginRight = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginTopSet) {
                    params.mLayoutMarginTop = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginBottomSet) {
                    params.mLayoutMarginBottom = params.mLayoutMargin;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                if (f2 <= -1.0f) {
                    this.mParams.mLayoutWidth = (int) f2;
                    break;
                } else {
                    this.mParams.mLayoutWidth = rp2px(f2);
                    break;
                }
        }
        return true;
    }

    public final boolean setRPValue(int i2, float f2) {
        Layout.Params params;
        boolean rPAttribute = setRPAttribute(i2, f2);
        return (rPAttribute || (params = this.mParams) == null) ? rPAttribute : params.setRPAttribute(i2, f2);
    }

    protected boolean setStrAttribute(int i2, int i3) {
        return setAttribute(i2, this.mContext.getStringLoader().getString(i3));
    }

    public final boolean setStrValue(int i2, int i3) {
        Layout.Params params;
        boolean strAttribute = setStrAttribute(i2, i3);
        return (strAttribute || (params = this.mParams) == null) ? strAttribute : params.setStrAttribute(i2, i3);
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public boolean setUserVar(int i2, Object obj) {
        UserVarItem userVarItem;
        SparseArray<UserVarItem> sparseArray = this.mUserVarItems;
        if (sparseArray != null && (userVarItem = sparseArray.get(i2)) != null) {
            int i3 = userVarItem.mType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (obj instanceof String) {
                            userVarItem.mValue = obj;
                            return true;
                        }
                        VVLog.e(TAG, "setUserVar set string failed");
                    }
                } else {
                    if (obj instanceof Float) {
                        userVarItem.mValue = obj;
                        return true;
                    }
                    VVLog.e(TAG, "setUserVar set float failed");
                }
            } else {
                if (obj instanceof Integer) {
                    userVarItem.mValue = obj;
                    return true;
                }
                VVLog.e(TAG, "setUserVar set int failed");
            }
        }
        return false;
    }

    public final void setVData(Object obj) {
        setVData(obj, false);
    }

    public final boolean setValue(int i2, ExprCode exprCode) {
        Layout.Params params;
        boolean attribute = setAttribute(i2, exprCode);
        return (attribute || (params = this.mParams) == null) ? attribute : params.setAttribute(i2, exprCode);
    }

    public void setVersion(int i2) {
        this.mVersion = i2;
    }

    public void setViewType(String str) {
        this.mViewType = str;
    }

    public void setVisibility(int i2) {
        if (this.mVisibility != i2) {
            this.mVisibility = i2;
            if (changeVisibility()) {
                return;
            }
            refresh();
        }
    }

    public boolean shouldDraw() {
        return this.mVisibility == 1;
    }

    public boolean softwareRender() {
        return (this.mFlag & 8) != 0;
    }

    public final boolean supportDynamic() {
        return (this.mFlag & 4) != 0;
    }

    public final boolean supportExposure() {
        return (this.mFlag & 16) != 0 && isVisible();
    }

    public Object getTag(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mKeyedTags;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public void refresh(int i2, int i3, int i4, int i5) {
        View view = this.mDisplayViewContainer;
        if (view != null) {
            view.invalidate(i2, i3, i4, i5);
        }
    }

    public void setTag(String str, Object obj) {
        if (this.mKeyedTags == null) {
            this.mKeyedTags = new ConcurrentHashMap<>();
        }
        this.mKeyedTags.put(str, obj);
    }

    public final void setVData(Object obj, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection("ViewBase.setVData");
        }
        this.mViewCache.setComponentData(obj);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            boolean optBoolean = jSONObject.optBoolean(ViewCache.Item.FLAG_INVALIDATE);
            List<ViewBase> cacheView = this.mViewCache.getCacheView();
            if (cacheView != null) {
                int size = cacheView.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ViewBase viewBase = cacheView.get(i2);
                    List<ViewCache.Item> cacheItem = this.mViewCache.getCacheItem(viewBase);
                    if (cacheItem != null) {
                        int size2 = cacheItem.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ViewCache.Item item = cacheItem.get(i3);
                            if (optBoolean) {
                                item.invalidate(obj.hashCode());
                            }
                            item.bind(obj, z);
                        }
                        viewBase.onParseValueFinished(this.mScaleFactor);
                        viewBase.check();
                        if (!viewBase.isRoot() && viewBase.supportExposure()) {
                            this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, viewBase));
                        }
                    }
                }
            }
            jSONObject.remove(ViewCache.Item.FLAG_INVALIDATE);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public void setBackgroundImage(String str) {
        if (!(TextUtils.equals(this.mBackgroundImagePath, str) && this.mLoadedBackgroundImagePath) && this.mParseValueFinished) {
            this.mBackgroundImagePath = str;
            this.mBackgroundImage = null;
            if (this.mMatrixBG == null) {
                this.mMatrixBG = new Matrix();
            }
            this.mLoadedBackgroundImagePath = true;
            if (TextUtils.isEmpty(this.mBackgroundImagePath)) {
                setBackgroundImage((Bitmap) null);
            }
            this.mContext.getImageLoader().getBitmap(needCheck(StringBase.STR_ID_backgroundImage), str, this, this.mMeasuredWidth, this.mMeasuredHeight, new ImageLoader.Listener() { // from class: com.vivo.advv.vaf.virtualview.core.ViewBase.1
                AnonymousClass1() {
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadFailed() {
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Drawable drawable) {
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(byte[] bArr, File file) {
                    ViewBase.this.setBackgroundImage(bArr, file);
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Bitmap bitmap) {
                    ViewBase.this.setBackgroundImage(bitmap);
                }
            });
        }
    }

    public final boolean setRPValue(int i2, int i3) {
        Layout.Params params;
        boolean rPAttribute = setRPAttribute(i2, i3);
        return (rPAttribute || (params = this.mParams) == null) ? rPAttribute : params.setRPAttribute(i2, i3);
    }

    public final boolean setValue(int i2, float f2) {
        Layout.Params params;
        boolean attribute = setAttribute(i2, f2);
        return (attribute || (params = this.mParams) == null) ? attribute : params.setAttribute(i2, f2);
    }

    protected boolean setAttribute(int i2, float f2) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                this.mParams.mLayoutMarginTop = Utils.dp2px(f2);
                this.mParams.isLayoutMarginTopSet = true;
                break;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mPaddingLeft = Utils.dp2px(f2);
                this.isPaddingLeftSet = true;
                break;
            case StringBase.STR_ID_minWidth /* -1375815020 */:
                this.mMinWidth = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mBorderTopLeftRadius = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_padding /* -806339567 */:
                int dp2px = Utils.dp2px(f2);
                this.mPadding = dp2px;
                if (!this.isPaddingLeftSet) {
                    this.mPaddingLeft = dp2px;
                }
                if (!this.isPaddingRightSet) {
                    this.mPaddingRight = dp2px;
                }
                if (!this.isPaddingTopSet) {
                    this.mPaddingTop = dp2px;
                }
                if (!this.isPaddingBottomSet) {
                    this.mPaddingBottom = dp2px;
                    break;
                }
                break;
            case StringBase.STR_ID_minHeight /* -133587431 */:
                this.mMinHeight = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                this.mParams.mLayoutMarginRight = Utils.dp2px(f2);
                this.mParams.isLayoutMarginRightSet = true;
                break;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mPaddingTop = Utils.dp2px(f2);
                this.isPaddingTopSet = true;
                break;
            case StringBase.STR_ID_alpha /* 92909918 */:
                this.mAlpha = f2;
                break;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mPaddingBottom = Utils.dp2px(f2);
                this.isPaddingBottomSet = true;
                break;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mBorderTopRightRadius = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mBorderBottomLeftRadius = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mBorderBottomRightRadius = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mPaddingRight = Utils.dp2px(f2);
                this.isPaddingRightSet = true;
                break;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mBorderWidth = Utils.dp2px(f2);
                break;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                this.mParams.mLayoutMarginLeft = Utils.dp2px(f2);
                this.mParams.isLayoutMarginLeftSet = true;
                break;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                int dp2px2 = Utils.dp2px(f2);
                this.mBorderRadius = dp2px2;
                if (this.mBorderTopLeftRadius <= 0) {
                    this.mBorderTopLeftRadius = dp2px2;
                }
                if (this.mBorderTopRightRadius <= 0) {
                    this.mBorderTopRightRadius = dp2px2;
                }
                if (this.mBorderBottomLeftRadius <= 0) {
                    this.mBorderBottomLeftRadius = dp2px2;
                }
                if (this.mBorderBottomRightRadius <= 0) {
                    this.mBorderBottomRightRadius = dp2px2;
                    break;
                }
                break;
            case StringBase.STR_ID_autoDimX /* 1438248735 */:
                this.mAutoDimX = f2;
                break;
            case StringBase.STR_ID_autoDimY /* 1438248736 */:
                this.mAutoDimY = f2;
                break;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                this.mParams.mLayoutMarginBottom = Utils.dp2px(f2);
                this.mParams.isLayoutMarginBottomSet = true;
                break;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                if (f2 > -1.0f) {
                    this.mParams.mLayoutHeight = Utils.dp2px(f2);
                    break;
                } else {
                    this.mParams.mLayoutHeight = (int) f2;
                    break;
                }
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                this.mParams.mLayoutMargin = Utils.dp2px(f2);
                Layout.Params params = this.mParams;
                if (!params.isLayoutMarginLeftSet) {
                    params.mLayoutMarginLeft = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginRightSet) {
                    params.mLayoutMarginRight = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginTopSet) {
                    params.mLayoutMarginTop = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginBottomSet) {
                    params.mLayoutMarginBottom = params.mLayoutMargin;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                if (f2 > -1.0f) {
                    this.mParams.mLayoutWidth = Utils.dp2px(f2);
                    break;
                } else {
                    this.mParams.mLayoutWidth = (int) f2;
                    break;
                }
        }
        return true;
    }

    public final boolean setValue(int i2, int i3) {
        Layout.Params params;
        boolean attribute = setAttribute(i2, i3);
        return (attribute || (params = this.mParams) == null) ? attribute : params.setAttribute(i2, i3);
    }

    protected boolean setRPAttribute(int i2, int i3) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                this.mParams.mLayoutMarginTop = rp2px(i3);
                this.mParams.isLayoutMarginTopSet = true;
                break;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mPaddingLeft = rp2px(i3);
                this.isPaddingLeftSet = true;
                break;
            case StringBase.STR_ID_minWidth /* -1375815020 */:
                this.mMinWidth = rp2px(i3);
                break;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mBorderTopLeftRadius = rp2px(i3);
                break;
            case StringBase.STR_ID_padding /* -806339567 */:
                int rp2px = rp2px(i3);
                this.mPadding = rp2px;
                if (!this.isPaddingLeftSet) {
                    this.mPaddingLeft = rp2px;
                }
                if (!this.isPaddingRightSet) {
                    this.mPaddingRight = rp2px;
                }
                if (!this.isPaddingTopSet) {
                    this.mPaddingTop = rp2px;
                }
                if (!this.isPaddingBottomSet) {
                    this.mPaddingBottom = rp2px;
                    break;
                }
                break;
            case StringBase.STR_ID_minHeight /* -133587431 */:
                this.mMinHeight = rp2px(i3);
                break;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                this.mParams.mLayoutMarginRight = rp2px(i3);
                this.mParams.isLayoutMarginRightSet = true;
                break;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mPaddingTop = rp2px(i3);
                this.isPaddingTopSet = true;
                break;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mPaddingBottom = rp2px(i3);
                this.isPaddingBottomSet = true;
                break;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mBorderTopRightRadius = rp2px(i3);
                break;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mBorderBottomLeftRadius = rp2px(i3);
                break;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mBorderBottomRightRadius = rp2px(i3);
                break;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mPaddingRight = rp2px(i3);
                this.isPaddingRightSet = true;
                break;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mBorderWidth = rp2px(i3);
                break;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                this.mParams.mLayoutMarginLeft = rp2px(i3);
                this.mParams.isLayoutMarginLeftSet = true;
                break;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                int rp2px2 = rp2px(i3);
                this.mBorderRadius = rp2px2;
                if (this.mBorderTopLeftRadius <= 0) {
                    this.mBorderTopLeftRadius = rp2px2;
                }
                if (this.mBorderTopRightRadius <= 0) {
                    this.mBorderTopRightRadius = rp2px2;
                }
                if (this.mBorderBottomLeftRadius <= 0) {
                    this.mBorderBottomLeftRadius = rp2px2;
                }
                if (this.mBorderBottomRightRadius <= 0) {
                    this.mBorderBottomRightRadius = rp2px2;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                this.mParams.mLayoutMarginBottom = rp2px(i3);
                this.mParams.isLayoutMarginBottomSet = true;
                break;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                if (i3 > -1) {
                    this.mParams.mLayoutHeight = rp2px(i3);
                    break;
                } else {
                    this.mParams.mLayoutHeight = i3;
                    break;
                }
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                this.mParams.mLayoutMargin = rp2px(i3);
                Layout.Params params = this.mParams;
                if (!params.isLayoutMarginLeftSet) {
                    params.mLayoutMarginLeft = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginRightSet) {
                    params.mLayoutMarginRight = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginTopSet) {
                    params.mLayoutMarginTop = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginBottomSet) {
                    params.mLayoutMarginBottom = params.mLayoutMargin;
                    break;
                }
                break;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                if (i3 > -1) {
                    this.mParams.mLayoutWidth = rp2px(i3);
                    break;
                } else {
                    this.mParams.mLayoutWidth = i3;
                    break;
                }
        }
        return true;
    }

    protected boolean setAttribute(int i2, String str) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutMarginTop, str, 1);
                return true;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mViewCache.put(this, StringBase.STR_ID_paddingLeft, str, 1);
                return true;
            case StringBase.STR_ID_action /* -1422950858 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_action, str, 2);
                } else {
                    this.mAction = str;
                }
                return true;
            case StringBase.STR_ID_autoDimDirection /* -1422893274 */:
                this.mViewCache.put(this, StringBase.STR_ID_autoDimDirection, str, 0);
                return true;
            case StringBase.STR_ID_background /* -1332194002 */:
                this.mViewCache.put(this, StringBase.STR_ID_background, str, 3);
                return true;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderTopLeftRadius, str, 1);
                return true;
            case StringBase.STR_ID_padding /* -806339567 */:
                this.mViewCache.put(this, StringBase.STR_ID_padding, str, 1);
                return true;
            case StringBase.STR_ID_dataParam /* -377785597 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_dataParam, str, 2);
                } else {
                    this.mDataParam = str;
                }
                return true;
            case StringBase.STR_ID_tag /* 114586 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_tag, str, 2);
                } else if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            setTag(next, jSONObject.getString(next));
                        }
                    } catch (JSONException unused) {
                        this.mTag = str;
                    }
                }
                return true;
            case StringBase.STR_ID_data /* 3076010 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_data, str, 2);
                } else {
                    this.mData = str;
                }
                return true;
            case StringBase.STR_ID_name /* 3373707 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_name, str, 2);
                } else {
                    this.mName = str;
                }
                return true;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutMarginRight, str, 1);
                return true;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mViewCache.put(this, StringBase.STR_ID_paddingTop, str, 1);
                return true;
            case StringBase.STR_ID_alpha /* 92909918 */:
                this.mViewCache.put(this, StringBase.STR_ID_alpha, str, 1);
                return true;
            case StringBase.STR_ID_class /* 94742904 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_class, str, 2);
                } else {
                    this.mClass = str;
                }
                return true;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mViewCache.put(this, StringBase.STR_ID_paddingBottom, str, 1);
                return true;
            case StringBase.STR_ID_dynamicMaterialType /* 260426464 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_dynamicMaterialType, str, 0);
                }
                return true;
            case StringBase.STR_ID_gravity /* 280523342 */:
                this.mViewCache.put(this, StringBase.STR_ID_gravity, str, 6);
                return true;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderTopRightRadius, str, 1);
                return true;
            case StringBase.STR_ID_checkList /* 398345670 */:
                if (str != null) {
                    String trim = str.trim();
                    if (trim.startsWith("[") && trim.endsWith("]")) {
                        this.mCheckList = trim.substring(1, trim.length() - 1).split(",");
                    } else {
                        VVLog.e(TAG, "no match []");
                    }
                }
                this.mCheckListSet = true;
                return true;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderBottomLeftRadius, str, 1);
                return true;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderBottomRightRadius, str, 1);
                return true;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mViewCache.put(this, StringBase.STR_ID_paddingRight, str, 1);
                return true;
            case StringBase.STR_ID_borderColor /* 722830999 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderColor, str, 3);
                return true;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderWidth, str, 1);
                return true;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutMarginLeft, str, 1);
                return true;
            case StringBase.STR_ID_backgroundImage /* 1292595405 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_backgroundImage, str, 2);
                } else {
                    this.mBackgroundImagePath = str;
                    this.mBackgroundImage = null;
                }
                return true;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                this.mViewCache.put(this, StringBase.STR_ID_borderRadius, str, 1);
                return true;
            case StringBase.STR_ID_autoDimX /* 1438248735 */:
                this.mViewCache.put(this, StringBase.STR_ID_autoDimX, str, 1);
                return true;
            case StringBase.STR_ID_autoDimY /* 1438248736 */:
                this.mViewCache.put(this, StringBase.STR_ID_autoDimY, str, 1);
                return true;
            case StringBase.STR_ID_dataTag /* 1443184528 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_dataTag, str, 7);
                } else {
                    this.mDataTag = str;
                }
                return true;
            case StringBase.STR_ID_dataUrl /* 1443186021 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_dataUrl, str, 2);
                } else {
                    this.mDataUrl = str;
                }
                return true;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutMarginBottom, str, 1);
                return true;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutHeight, str, 1);
                this.mParams.mLayoutHeight = -2;
                return true;
            case StringBase.STR_ID_actionParam /* 1569332215 */:
                if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_actionParam, str, 2);
                } else {
                    this.mActionParam = str;
                }
                return true;
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutMargin, str, 1);
                return true;
            case StringBase.STR_ID_visibility /* 1941332754 */:
                this.mViewCache.put(this, StringBase.STR_ID_visibility, str, 5);
                return true;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                this.mViewCache.put(this, StringBase.STR_ID_layoutWidth, str, 1);
                this.mParams.mLayoutWidth = -2;
                return true;
            default:
                return false;
        }
    }

    protected boolean setAttribute(int i2, int i3) {
        switch (i2) {
            case StringBase.STR_ID_layoutMarginTop /* -2037919555 */:
                this.mParams.mLayoutMarginTop = Utils.dp2px(i3);
                this.mParams.isLayoutMarginTopSet = true;
                break;
            case StringBase.STR_ID_paddingLeft /* -1501175880 */:
                this.mPaddingLeft = Utils.dp2px(i3);
                this.isPaddingLeftSet = true;
                break;
            case StringBase.STR_ID_autoDimDirection /* -1422893274 */:
                this.mAutoDimDirection = i3;
                break;
            case StringBase.STR_ID_minWidth /* -1375815020 */:
                this.mMinWidth = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_background /* -1332194002 */:
                setBackgroundColor(i3);
                break;
            case StringBase.STR_ID_borderTopLeftRadius /* -1228066334 */:
                this.mBorderTopLeftRadius = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_padding /* -806339567 */:
                int dp2px = Utils.dp2px(i3);
                this.mPadding = dp2px;
                if (!this.isPaddingLeftSet) {
                    this.mPaddingLeft = dp2px;
                }
                if (!this.isPaddingRightSet) {
                    this.mPaddingRight = dp2px;
                }
                if (!this.isPaddingTopSet) {
                    this.mPaddingTop = dp2px;
                }
                if (!this.isPaddingBottomSet) {
                    this.mPaddingBottom = dp2px;
                    break;
                }
                break;
            case StringBase.STR_ID_minHeight /* -133587431 */:
                this.mMinHeight = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_id /* 3355 */:
                this.mId = i3;
                break;
            case StringBase.STR_ID_flag /* 3145580 */:
                this.mFlag = i3;
                break;
            case StringBase.STR_ID_uuid /* 3601339 */:
                this.mUuid = i3;
                break;
            case StringBase.STR_ID_layoutMarginRight /* 62363524 */:
                this.mParams.mLayoutMarginRight = Utils.dp2px(i3);
                this.mParams.isLayoutMarginRightSet = true;
                break;
            case StringBase.STR_ID_paddingTop /* 90130308 */:
                this.mPaddingTop = Utils.dp2px(i3);
                this.isPaddingTopSet = true;
                break;
            case StringBase.STR_ID_paddingBottom /* 202355100 */:
                this.mPaddingBottom = Utils.dp2px(i3);
                this.isPaddingBottomSet = true;
                break;
            case StringBase.STR_ID_dynamicMaterialType /* 260426464 */:
                this.mDynamicMaterialType = i3;
                break;
            case StringBase.STR_ID_gravity /* 280523342 */:
                this.mGravity = i3;
                break;
            case StringBase.STR_ID_borderTopRightRadius /* 333432965 */:
                this.mBorderTopRightRadius = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_borderBottomLeftRadius /* 581268560 */:
                this.mBorderBottomLeftRadius = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_borderBottomRightRadius /* 588239831 */:
                this.mBorderBottomRightRadius = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_paddingRight /* 713848971 */:
                this.mPaddingRight = Utils.dp2px(i3);
                this.isPaddingRightSet = true;
                break;
            case StringBase.STR_ID_borderColor /* 722830999 */:
                this.mBorderColor = i3;
                break;
            case StringBase.STR_ID_borderWidth /* 741115130 */:
                this.mBorderWidth = Utils.dp2px(i3);
                break;
            case StringBase.STR_ID_layoutMarginLeft /* 1248755103 */:
                this.mParams.mLayoutMarginLeft = Utils.dp2px(i3);
                this.mParams.isLayoutMarginLeftSet = true;
                break;
            case StringBase.STR_ID_borderRadius /* 1349188574 */:
                int dp2px2 = Utils.dp2px(i3);
                this.mBorderRadius = dp2px2;
                if (this.mBorderTopLeftRadius <= 0) {
                    this.mBorderTopLeftRadius = dp2px2;
                }
                if (this.mBorderTopRightRadius <= 0) {
                    this.mBorderTopRightRadius = dp2px2;
                }
                if (this.mBorderBottomLeftRadius <= 0) {
                    this.mBorderBottomLeftRadius = dp2px2;
                }
                if (this.mBorderBottomRightRadius <= 0) {
                    this.mBorderBottomRightRadius = dp2px2;
                    break;
                }
                break;
            case StringBase.STR_ID_autoDimX /* 1438248735 */:
                this.mAutoDimX = i3;
                break;
            case StringBase.STR_ID_autoDimY /* 1438248736 */:
                this.mAutoDimY = i3;
                break;
            case StringBase.STR_ID_layoutMarginBottom /* 1481142723 */:
                this.mParams.mLayoutMarginBottom = Utils.dp2px(i3);
                this.mParams.isLayoutMarginBottomSet = true;
                break;
            case StringBase.STR_ID_layoutHeight /* 1557524721 */:
                if (i3 > -1) {
                    this.mParams.mLayoutHeight = Utils.dp2px(i3);
                    break;
                } else {
                    this.mParams.mLayoutHeight = i3;
                    break;
                }
            case StringBase.STR_ID_layoutMargin /* 1697244536 */:
                this.mParams.mLayoutMargin = Utils.dp2px(i3);
                Layout.Params params = this.mParams;
                if (!params.isLayoutMarginLeftSet) {
                    params.mLayoutMarginLeft = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginRightSet) {
                    params.mLayoutMarginRight = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginTopSet) {
                    params.mLayoutMarginTop = params.mLayoutMargin;
                }
                if (!params.isLayoutMarginBottomSet) {
                    params.mLayoutMarginBottom = params.mLayoutMargin;
                    break;
                }
                break;
            case StringBase.STR_ID_dataMode /* 1788852333 */:
                this.mDataMode = i3;
                break;
            case StringBase.STR_ID_visibility /* 1941332754 */:
                this.mVisibility = i3;
                changeVisibility();
                break;
            case StringBase.STR_ID_layoutWidth /* 2003872956 */:
                if (i3 > -1) {
                    this.mParams.mLayoutWidth = Utils.dp2px(i3);
                    break;
                } else {
                    this.mParams.mLayoutWidth = i3;
                    break;
                }
        }
        return true;
    }
}
