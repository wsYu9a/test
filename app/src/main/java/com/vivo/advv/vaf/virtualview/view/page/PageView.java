package com.vivo.advv.vaf.virtualview.view.page;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.vivo.advv.vaf.virtualview.core.Adapter;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PageView extends ViewGroup {
    protected static final int DEFAULT_ANIMATOR_TIME_INTERVAL = 100;
    protected static final int DEFAULT_AUTO_SWITCH_TIME_INTERVAL = 500;
    protected static final int DEFAULT_STAY_TIME = 2500;
    protected static final int MAX_ITEM_COUNT = 5;
    protected static final int MSG_AUTO_SWITCH = 1;
    private static final String TAG = "PageView_TMTEST";
    protected static final int VEL_THRESHOLD = 2000;
    private ObjectAnimator ani;
    protected Adapter mAdapter;
    protected MyAnimatorListener mAniListener;
    protected int mAnimationStyle;
    protected int mAnimatorTimeInterval;
    protected boolean mAutoSwitch;
    protected long mAutoSwitchDelay;
    protected Handler mAutoSwitchHandler;
    protected int mAutoSwitchTimeInterval;
    protected boolean mCanSlide;
    protected boolean mCanSwitch;
    protected int mCurPos;
    protected boolean mDataChanged;
    protected int mDownPos;
    protected boolean mIsHorizontal;
    protected boolean mIsNext;
    protected SparseArray<List<Adapter.ViewHolder>> mItemCache;
    private int mLastX;
    private int mLastY;
    protected boolean mLayoutNormal;
    protected Listener mListener;
    private int mMaxVelocity;
    private int mPointerId;
    protected int mStayTime;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.vivo.advv.vaf.virtualview.view.page.PageView$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                PageView.this.autoSwitch();
            }
        }
    }

    public static class DecelerateInterpolator implements TimeInterpolator {
        private static final float FACTOR = 5.0f;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) (1.0d - Math.pow(1.0f - f2, 10.0d));
        }
    }

    public interface Listener {
        void onPageFlip(int i2, int i3);
    }

    class MyAnimatorListener implements Animator.AnimatorListener {
        MyAnimatorListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            PageView.this.resetChildren();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PageView.this.changeChildren();
            PageView pageView = PageView.this;
            Listener listener = pageView.mListener;
            if (listener != null) {
                listener.onPageFlip(pageView.mCurPos + 1, pageView.mAdapter.getItemCount());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class SpringInterpolator implements TimeInterpolator {
        private static final float FACTOR = 4.0f;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            double pow = Math.pow(2.0d, (-10.0f) * f2);
            double d2 = f2 - 1.0f;
            Double.isNaN(d2);
            return (float) ((pow * Math.sin((d2 * 6.283185307179586d) / 4.0d)) + 1.0d);
        }
    }

    public PageView(Context context) {
        super(context);
        this.mItemCache = new SparseArray<>();
        this.mStayTime = 2500;
        this.mAnimatorTimeInterval = 100;
        this.mAutoSwitchTimeInterval = 500;
        this.mAutoSwitch = false;
        this.mIsHorizontal = true;
        this.mLayoutNormal = true;
        this.mAnimationStyle = 0;
        this.mCanSlide = true;
        this.mAutoSwitchDelay = 0L;
        this.mDataChanged = true;
        this.mAniListener = new MyAnimatorListener();
        this.mCanSwitch = true;
        this.mCurPos = 0;
        this.mAutoSwitchHandler = new Handler() { // from class: com.vivo.advv.vaf.virtualview.view.page.PageView.1
            AnonymousClass1() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 == message.what) {
                    PageView.this.autoSwitch();
                }
            }
        };
        this.mMaxVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    public void changeChildren() {
        int itemCount;
        Adapter adapter = this.mAdapter;
        if (adapter != null && (itemCount = adapter.getItemCount()) > 0 && getChildCount() > 0) {
            if (this.mIsNext) {
                if (this.mLayoutNormal) {
                    remove(0);
                } else {
                    remove(getChildCount() - 1);
                }
                int i2 = (this.mCurPos + 1) % itemCount;
                this.mCurPos = i2;
                int i3 = (i2 + 1) % itemCount;
                if (this.mLayoutNormal) {
                    add(i3);
                } else {
                    add(i3, 0);
                }
            } else {
                if (this.mLayoutNormal) {
                    remove(getChildCount() - 1);
                } else {
                    remove(0);
                }
                int i4 = this.mCurPos - 1;
                this.mCurPos = i4;
                if (i4 < 0) {
                    this.mCurPos = i4 + itemCount;
                }
                int i5 = this.mCurPos - 1;
                if (i5 < 0) {
                    i5 += itemCount;
                }
                if (this.mLayoutNormal) {
                    add(i5, 0);
                } else {
                    add(i5);
                }
            }
            requestLayout();
            if (this.mIsHorizontal) {
                setScrollX(0);
            } else {
                setScrollY(0);
            }
            if (this.mAutoSwitch) {
                this.mAutoSwitchHandler.removeMessages(1);
                if (this.mCanSwitch) {
                    this.mAutoSwitchHandler.sendEmptyMessageDelayed(1, this.mStayTime);
                }
            }
        }
    }

    private TimeInterpolator getTimeInterpolater() {
        int i2 = this.mAnimationStyle;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new LinearInterpolator() : new SpringInterpolator() : new AccelerateDecelerateInterpolator() : new AccelerateInterpolator() : new DecelerateInterpolator() : new LinearInterpolator();
    }

    private void initData() {
        Listener listener;
        int i2 = 0;
        this.mCurPos = 0;
        int itemCount = this.mAdapter.getItemCount();
        if (1 == itemCount) {
            if (getChildCount() == 0) {
                add(this.mCurPos);
            } else {
                replace(this.mCurPos);
            }
            this.mCanSlide = false;
        } else if (itemCount > 1) {
            int i3 = this.mCurPos;
            int i4 = i3 - 1;
            if (i4 < 0) {
                i4 += itemCount;
            }
            int i5 = (i3 + 1) % itemCount;
            if (this.mLayoutNormal) {
                if (getChildCount() == 0) {
                    if (this.mCanSlide) {
                        add(i4);
                    }
                    add(this.mCurPos);
                    add(i5);
                } else {
                    if (this.mCanSlide) {
                        replace(i4, 0);
                        i2 = 1;
                    }
                    replace(this.mCurPos, i2);
                    replace(i5, i2 + 1);
                }
            } else if (getChildCount() == 0) {
                add(i5);
                add(this.mCurPos);
                if (this.mCanSlide) {
                    add(i4);
                }
            } else {
                replace(i5, 0);
                replace(this.mCurPos, 1);
                if (this.mCanSlide) {
                    replace(i4, 2);
                }
            }
        }
        if (itemCount <= 0 || (listener = this.mListener) == null) {
            return;
        }
        listener.onPageFlip(1, itemCount);
    }

    private void moveH(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownPos = x;
            return;
        }
        if (action != 1) {
            if (action == 2) {
                setScrollX(-(x - this.mDownPos));
                return;
            } else if (action != 3) {
                return;
            }
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        float xVelocity = this.mVelocityTracker.getXVelocity(this.mPointerId);
        this.mVelocityTracker.getYVelocity(this.mPointerId);
        int scrollX = getScrollX();
        int measuredWidth = getMeasuredWidth();
        if (Math.abs(scrollX) > measuredWidth / 2 || Math.abs(xVelocity) > 2000.0f) {
            if (scrollX < 0) {
                this.mIsNext = false;
                this.ani = ObjectAnimator.ofInt(this, "scrollX", scrollX, -measuredWidth);
            } else {
                this.mIsNext = true;
                this.ani = ObjectAnimator.ofInt(this, "scrollX", scrollX, measuredWidth);
            }
            this.ani.setDuration(this.mAnimatorTimeInterval).addListener(this.mAniListener);
            this.ani.setInterpolator(getTimeInterpolater());
            this.ani.start();
        } else {
            ObjectAnimator.ofInt(this, "scrollX", scrollX, 0).setDuration(this.mAnimatorTimeInterval).start();
        }
        releaseVelocityTracker();
    }

    private void moveV(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownPos = y;
            return;
        }
        if (action != 1) {
            if (action == 2) {
                setScrollY(-(y - this.mDownPos));
                return;
            } else if (action != 3) {
                return;
            }
        }
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        float yVelocity = this.mVelocityTracker.getYVelocity(this.mPointerId);
        int scrollY = getScrollY();
        int measuredHeight = getMeasuredHeight();
        if (Math.abs(scrollY) > measuredHeight / 2 || Math.abs(yVelocity) > 2000.0f) {
            if (scrollY < 0) {
                this.mIsNext = false;
                this.ani = ObjectAnimator.ofInt(this, "scrollY", scrollY, -measuredHeight);
            } else {
                this.mIsNext = true;
                this.ani = ObjectAnimator.ofInt(this, "scrollY", scrollY, measuredHeight);
            }
            this.ani.setDuration(this.mAnimatorTimeInterval).addListener(this.mAniListener);
            this.ani.setInterpolator(getTimeInterpolater());
            this.ani.start();
        } else {
            ObjectAnimator.ofInt(this, "scrollY", scrollY, 0).setDuration(this.mAnimatorTimeInterval).start();
        }
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

    private void replace(int i2) {
        replace(i2, -1);
    }

    public void resetChildren() {
        if (this.mIsHorizontal) {
            setScrollX(0);
        } else {
            setScrollY(0);
        }
    }

    protected void add(int i2) {
        add(i2, -1);
    }

    public void autoSwitch() {
        this.mIsNext = true;
        if (this.mIsHorizontal) {
            if (this.mLayoutNormal) {
                this.ani = ObjectAnimator.ofInt(this, "scrollX", 0, getMeasuredWidth());
            } else {
                this.ani = ObjectAnimator.ofInt(this, "scrollX", 0, -getMeasuredWidth());
            }
        } else if (this.mLayoutNormal) {
            this.ani = ObjectAnimator.ofInt(this, "scrollY", 0, getMeasuredHeight());
        } else {
            this.ani = ObjectAnimator.ofInt(this, "scrollY", 0, -getMeasuredHeight());
        }
        this.ani.setDuration(this.mAutoSwitchTimeInterval).addListener(this.mAniListener);
        this.ani.setInterpolator(getTimeInterpolater());
        this.ani.setStartDelay(this.mAutoSwitchDelay);
        this.ani.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refresh();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCanSwitch = false;
        this.mAutoSwitchHandler.removeMessages(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.mIsHorizontal) {
                this.mDownPos = x;
            } else {
                this.mDownPos = y;
            }
            this.mLastX = x;
            this.mLastY = y;
            this.mPointerId = motionEvent.getPointerId(0);
            return false;
        }
        if (action != 2) {
            return false;
        }
        int i2 = x - this.mLastX;
        int i3 = y - this.mLastY;
        if (this.mIsHorizontal) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (!this.mIsHorizontal) {
            int i8 = (childCount <= 1 || (!((z2 = this.mLayoutNormal) && this.mCanSlide) && z2)) ? 0 : -i7;
            int i9 = 0;
            while (i9 < childCount) {
                int i10 = i8 + i7;
                getChildAt(i9).layout(0, i8, i6, i10);
                i9++;
                i8 = i10;
            }
            return;
        }
        boolean z3 = this.mLayoutNormal;
        int i11 = (!(z3 && this.mCanSlide) && z3) ? 0 : -i6;
        int i12 = 0;
        while (i12 < childCount) {
            int i13 = i11 + i6;
            getChildAt(i12).layout(i11, 0, i13, i7);
            i12++;
            i11 = i13;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        measureChildren(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        acquireVelocityTracker(motionEvent);
        if (this.mIsHorizontal) {
            moveH(motionEvent);
            return true;
        }
        moveV(motionEvent);
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            this.mCanSwitch = false;
            this.mAutoSwitchHandler.removeMessages(1);
            return;
        }
        this.mCanSwitch = true;
        if (!this.mAutoSwitch || this.mAdapter.getItemCount() <= 1) {
            return;
        }
        this.mAutoSwitchHandler.removeMessages(1);
        this.mAutoSwitchHandler.sendEmptyMessageDelayed(1, this.mStayTime);
    }

    public void refresh() {
        this.mCanSwitch = true;
        if (this.mDataChanged) {
            ObjectAnimator objectAnimator = this.ani;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            removeAll();
            this.mDataChanged = false;
            initData();
        }
        if (!this.mAutoSwitch || this.mAdapter.getItemCount() <= 1) {
            return;
        }
        this.mAutoSwitchHandler.removeMessages(1);
        this.mAutoSwitchHandler.sendEmptyMessageDelayed(1, this.mStayTime);
    }

    protected void removeAll() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            removeData(i2);
        }
        removeAllViews();
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setAnimationStyle(int i2) {
        this.mAnimationStyle = i2;
    }

    public void setAnimatorTimeInterval(int i2) {
        this.mAnimatorTimeInterval = i2;
    }

    public void setAutoSwitch(boolean z) {
        this.mAutoSwitch = z;
    }

    public void setAutoSwitchDelay(long j2) {
        this.mAutoSwitchDelay = j2;
    }

    public void setAutoSwitchTimeInterval(int i2) {
        this.mAutoSwitchTimeInterval = i2;
    }

    public void setLayoutOrientation(boolean z) {
        this.mLayoutNormal = z;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setOrientation(boolean z) {
        this.mIsHorizontal = z;
    }

    public void setSlide(boolean z) {
        this.mCanSlide = z;
    }

    public void setStayTime(int i2) {
        this.mStayTime = i2;
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

    protected void replace(int i2, int i3) {
        int childCount = getChildCount();
        if (childCount == 0 || i3 >= childCount) {
            VVLog.d(TAG, "childCount == 0 or index >= childCount should not happen here");
            return;
        }
        Adapter.ViewHolder viewHolder = (Adapter.ViewHolder) (i3 == -1 ? getChildAt(childCount - 1) : getChildAt(i3)).getTag();
        if (viewHolder == null) {
            VVLog.d(TAG, "view holder == null, should not happen ");
        } else {
            this.mAdapter.onBindViewHolder(viewHolder, i2);
        }
    }
}
