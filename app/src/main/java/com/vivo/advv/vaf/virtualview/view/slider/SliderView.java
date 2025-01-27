package com.vivo.advv.vaf.virtualview.view.slider;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.vivo.advv.vaf.virtualview.core.Adapter;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class SliderView extends ViewGroup {
    protected static final int MAX_ITEM_COUNT = 5;
    private static final String TAG = "SliderView_TMTEST";
    protected Adapter mAdapter;
    private ObjectAnimator mAutoScrollAni;
    protected boolean mDataChanged;
    private int mDataCount;
    private int mDeleteThreshold;
    protected int mDownPos;
    protected SparseArray<List<Adapter.ViewHolder>> mItemCache;
    private int mItemWidth;
    private int mLTDataIndex;
    private int mLTPos;
    private int mLastX;
    private int mLastY;
    protected Listener mListener;
    private int mMaxVelocity;
    private int mNewThreshold;
    private int mOrientation;
    private int mPointerId;
    private int mPreAutoScrollPos;
    private int mPrePos;
    private int mRBDataIndex;
    private int mRBPos;
    private int mScrollDis;
    private int mScrollPos;
    private int mSpan;
    private int mTotalLen;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    public interface Listener {
        void onScroll(int i2, int i3);
    }

    public SliderView(Context context) {
        super(context);
        this.mItemCache = new SparseArray<>();
        this.mOrientation = 1;
        this.mDataChanged = true;
        this.mMaxVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void initData() {
        int itemCount;
        Adapter adapter = this.mAdapter;
        if (adapter == null || (itemCount = adapter.getItemCount()) <= 0) {
            return;
        }
        int i2 = 0;
        this.mLTPos = 0;
        this.mLTDataIndex = 0;
        this.mScrollPos = 0;
        int i3 = this.mWidth + this.mItemWidth + this.mSpan;
        int i4 = itemCount - 1;
        this.mRBDataIndex = i4;
        int i5 = 0;
        while (true) {
            if (i2 >= itemCount) {
                break;
            }
            add(i2);
            i5 += this.mItemWidth;
            if (i2 < i4) {
                i5 += this.mSpan;
            }
            if (i5 >= i3) {
                this.mRBDataIndex = i2;
                break;
            }
            i2++;
        }
        this.mRBPos = i5 - this.mWidth;
    }

    private void moveH(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mPrePos = x;
            ObjectAnimator objectAnimator = this.mAutoScrollAni;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                return;
            }
            return;
        }
        if (action != 1) {
            if (action == 2) {
                int i2 = x - this.mPrePos;
                this.mScrollDis = i2;
                scrollDeal(i2);
                return;
            } else if (action != 3) {
                return;
            }
        }
        this.mVelocityTracker.computeCurrentVelocity(1, this.mMaxVelocity);
        float xVelocity = this.mVelocityTracker.getXVelocity(this.mPointerId);
        this.mVelocityTracker.getYVelocity(this.mPointerId);
        int i3 = this.mScrollDis;
        int i4 = ((int) xVelocity) * i3;
        if (i3 > 0) {
            i4 = -i4;
        }
        this.mPreAutoScrollPos = i4;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "autoScrollX", i4, 0);
        this.mAutoScrollAni = ofInt;
        ofInt.setInterpolator(new DecelerateInterpolator());
        this.mAutoScrollAni.setDuration(300L).start();
        releaseVelocityTracker();
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void remove(int i2) {
        removeData(i2);
        removeViewAt(i2);
    }

    private void removeData(int i2) {
        Adapter.ViewHolder viewHolder = (Adapter.ViewHolder) getChildAt(i2).getTag();
        ((IContainer) viewHolder.mItemView).getVirtualView().reset();
        List<Adapter.ViewHolder> list = this.mItemCache.get(viewHolder.mType);
        if (list == null) {
            list = new ArrayList<>();
            this.mItemCache.put(viewHolder.mType, list);
        }
        if (list.size() >= 5) {
            list.remove(0);
        }
        list.add(viewHolder);
    }

    private void scrollDeal(int i2) {
        int i3;
        int i4;
        if (i2 < 0) {
            int i5 = this.mRBPos;
            if (i5 + i2 < 0) {
                i2 = -i5;
            }
        } else {
            if (i2 <= 0) {
                return;
            }
            int i6 = this.mLTPos;
            if (i6 - i2 < 0) {
                i2 = i6;
            }
        }
        if (i2 != 0) {
            int i7 = -i2;
            this.mScrollPos += i7;
            this.mPrePos += i2;
            scrollBy(i7, 0);
            this.mLTPos -= i2;
            this.mRBPos += i2;
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onScroll(this.mScrollPos, this.mTotalLen);
            }
        }
        int i8 = this.mLTPos;
        if (i8 >= this.mDeleteThreshold) {
            if (this.mLTDataIndex < getChildCount() - 1) {
                remove(0);
                this.mLTDataIndex++;
                int i9 = this.mLTPos;
                int i10 = this.mItemWidth;
                int i11 = this.mSpan;
                this.mLTPos = i9 - (i10 + i11);
                scrollBy((-i10) - i11, 0);
            }
        } else if (i8 <= this.mNewThreshold && (i3 = this.mLTDataIndex) > 0) {
            int i12 = i3 - 1;
            this.mLTDataIndex = i12;
            add(i12, 0);
            scrollBy(this.mItemWidth + this.mSpan, 0);
            this.mLTPos += this.mItemWidth + this.mSpan;
        }
        int i13 = this.mRBPos;
        if (i13 >= this.mDeleteThreshold) {
            if (this.mRBDataIndex > 0) {
                remove(getChildCount() - 1);
                this.mRBDataIndex--;
                this.mRBPos -= this.mItemWidth + this.mSpan;
                return;
            }
            return;
        }
        if (i13 > this.mNewThreshold || (i4 = this.mRBDataIndex) >= this.mDataCount - 1) {
            return;
        }
        int i14 = i4 + 1;
        this.mRBDataIndex = i14;
        add(i14);
        this.mRBPos += this.mItemWidth + this.mSpan;
    }

    protected void add(int i2) {
        add(i2, -1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return false;
            }
            int i2 = x - this.mLastX;
            int i3 = y - this.mLastY;
            if (1 == this.mOrientation) {
                if (Math.abs(i2) <= Math.abs(i3)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if (Math.abs(i3) <= Math.abs(i2)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (1 == this.mOrientation) {
            this.mDownPos = x;
        } else {
            this.mDownPos = y;
        }
        this.mLastX = x;
        this.mLastY = y;
        this.mPointerId = motionEvent.getPointerId(0);
        this.mPrePos = x;
        ObjectAnimator objectAnimator = this.mAutoScrollAni;
        if (objectAnimator == null) {
            return false;
        }
        objectAnimator.cancel();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingBottom = ((i5 - i3) - paddingTop) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).layout(paddingLeft, paddingTop, this.mItemWidth + paddingLeft, paddingBottom);
            paddingLeft += this.mItemWidth + this.mSpan;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.mWidth = View.MeasureSpec.getSize(i2);
        int size = View.MeasureSpec.getSize(i3);
        refresh();
        measureChildren(View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        setMeasuredDimension(this.mWidth, size);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        acquireVelocityTracker(motionEvent);
        moveH(motionEvent);
        return true;
    }

    public void refresh() {
        if (this.mDataChanged) {
            removeAll();
            this.mDataChanged = false;
            int itemCount = this.mAdapter.getItemCount();
            this.mDataCount = itemCount;
            this.mTotalLen = ((this.mItemWidth * itemCount) + ((itemCount - 1) * this.mSpan)) - this.mWidth;
            initData();
        }
    }

    protected void removeAll() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            removeData(i2);
        }
        removeAllViews();
    }

    public void setAutoScrollX(int i2) {
        scrollDeal(i2 - this.mPreAutoScrollPos);
        if (this.mScrollDis < 0) {
            if (this.mRBPos == 0) {
                this.mAutoScrollAni.cancel();
            }
        } else if (this.mLTPos == 0) {
            this.mAutoScrollAni.cancel();
        }
        this.mPreAutoScrollPos = i2;
    }

    public void setItemWidth(int i2) {
        this.mItemWidth = i2;
        this.mNewThreshold = i2 >> 1;
        this.mDeleteThreshold = i2 << 1;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }

    public void setSpan(int i2) {
        this.mSpan = i2;
    }

    protected void add(int i2, int i3) {
        Adapter.ViewHolder viewHolder;
        int type = this.mAdapter.getType(i2);
        List<Adapter.ViewHolder> list = this.mItemCache.get(type);
        if (list == null || list.size() <= 0) {
            Adapter.ViewHolder onCreateViewHolder = this.mAdapter.onCreateViewHolder(type);
            onCreateViewHolder.mType = type;
            onCreateViewHolder.mPos = i2;
            viewHolder = onCreateViewHolder;
        } else {
            viewHolder = list.remove(0);
            viewHolder.mPos = i2;
        }
        this.mAdapter.onBindViewHolder(viewHolder, i2);
        if (i3 < 0) {
            addView(viewHolder.mItemView);
        } else {
            addView(viewHolder.mItemView, i3);
        }
    }
}
