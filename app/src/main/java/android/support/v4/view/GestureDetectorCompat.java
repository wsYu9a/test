package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.a.C0521;
import com.tencent.a.utils.C0520;

/* loaded from: classes7.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT;
        private static final int LONGPRESS_TIMEOUT;
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT;

        /* renamed from: short */
        private static final short[] f29short;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {

            /* renamed from: short */
            private static final short[] f30short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(7902325)}[0]).intValue() ^ 7902309];
                sArr[0] = 1554;
                sArr[1] = 1577;
                sArr[2] = 1580;
                sArr[3] = 1577;
                sArr[4] = 1576;
                sArr[5] = 1584;
                sArr[6] = 1577;
                sArr[7] = 1639;
                sArr[8] = 1578;
                sArr[9] = 1570;
                sArr[10] = 1588;
                sArr[11] = 1588;
                sArr[12] = 1574;
                sArr[13] = 1568;
                sArr[14] = 1570;
                sArr[15] = 1639;
                f30short = sArr;
            }

            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.mDoubleTapListener != null) {
                            if (GestureDetectorCompatImplBase.this.mStillDown) {
                                GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                                return;
                            } else {
                                GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                                return;
                            }
                        }
                        return;
                    default:
                        throw new RuntimeException(C0520.m66(f30short, 1751656 ^ C0008.m27((Object) "ۤۤۨ"), 1747819 ^ C0008.m27((Object) "۠ۥ۠"), C0008.m27((Object) "ۤۢۢ") ^ 1752163) + message);
                }
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5972855)}[0]).intValue() ^ 5972813];
            sArr[0] = 3122;
            sArr[1] = 3091;
            sArr[2] = 3130;
            sArr[3] = 3096;
            sArr[4] = 3086;
            sArr[5] = 3081;
            sArr[6] = 3080;
            sArr[7] = 3087;
            sArr[8] = 3096;
            sArr[9] = 3121;
            sArr[10] = 3092;
            sArr[11] = 3086;
            sArr[12] = 3081;
            sArr[13] = 3096;
            sArr[14] = 3091;
            sArr[15] = 3096;
            sArr[16] = 3087;
            sArr[17] = 3165;
            sArr[18] = 3088;
            sArr[19] = 3080;
            sArr[20] = 3086;
            sArr[21] = 3081;
            sArr[22] = 3165;
            sArr[23] = 3091;
            sArr[24] = 3090;
            sArr[25] = 3081;
            sArr[26] = 3165;
            sArr[27] = 3103;
            sArr[28] = 3096;
            sArr[29] = 3165;
            sArr[30] = 3091;
            sArr[31] = 3080;
            sArr[32] = 3089;
            sArr[33] = 3089;
            sArr[34] = 2598;
            sArr[35] = 2570;
            sArr[36] = 2571;
            sArr[37] = 2577;
            sArr[38] = 2560;
            sArr[39] = 2589;
            sArr[40] = 2577;
            sArr[41] = 2629;
            sArr[42] = 2568;
            sArr[43] = 2576;
            sArr[44] = 2582;
            sArr[45] = 2577;
            sArr[46] = 2629;
            sArr[47] = 2571;
            sArr[48] = 2570;
            sArr[49] = 2577;
            sArr[50] = 2629;
            sArr[51] = 2567;
            sArr[52] = 2560;
            sArr[53] = 2629;
            sArr[54] = 2571;
            sArr[55] = 2576;
            sArr[56] = 2569;
            sArr[57] = 2569;
            f29short = sArr;
            LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
            TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            Object[] objArr = {new Integer(3555501), new Integer(993334), new Integer(2449384)};
            this.mHandler.removeMessages(((Integer) objArr[1]).intValue() ^ 993335);
            this.mHandler.removeMessages(((Integer) objArr[0]).intValue() ^ 3555503);
            this.mHandler.removeMessages(((Integer) objArr[2]).intValue() ^ 2449387);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            Object[] objArr = {new Integer(6659847), new Integer(1607111), new Integer(9221872)};
            this.mHandler.removeMessages(((Integer) objArr[2]).intValue() ^ 9221873);
            this.mHandler.removeMessages(((Integer) objArr[1]).intValue() ^ 1607109);
            this.mHandler.removeMessages(((Integer) objArr[0]).intValue() ^ 6659844);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException(C0521.m71(f29short, 1747691 ^ C0008.m27((Object) "۠۟ۨ"), 1749617 ^ C0008.m27((Object) "ۢ۠ۧ"), C0008.m27((Object) "ۥۥۤ") ^ 1750049));
            }
            if (this.mListener == null) {
                throw new IllegalArgumentException(C0008.m24(f29short, 1753694 ^ C0008.m27((Object) "ۦۨ۠"), 1755588 ^ C0008.m27((Object) "ۨۨۦ"), C0008.m27((Object) "ۥۨۡ") ^ 1749731));
            }
            this.mIsLongpressEnabled = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
            this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(((Integer) new Object[]{new Integer(2474629)}[0]).intValue() ^ 2474630);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            boolean z2;
            Object[] objArr = {new Integer(2898834), new Integer(1032437), new Integer(5960489), new Integer(3012817), new Integer(1356887), new Float(1.0f), new Integer(4267167), new Integer(1680679), new Integer(-4643643), new Integer(5714613), new Integer(1177048), new Integer(8641540), new Integer(4007715), new Integer(4296084), new Integer(9149182), new Integer(640123), new Integer(8350965)};
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            boolean z3 = ((((Integer) objArr[7]).intValue() ^ 1680856) & action) == 6;
            int actionIndex = z3 ? motionEvent.getActionIndex() : -1;
            float f2 = 0.0f;
            float f3 = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2 = (((Integer) objArr[1]).intValue() ^ 1032436) + i2) {
                if (actionIndex != i2) {
                    f2 += motionEvent.getX(i2);
                    f3 = motionEvent.getY(i2) + f3;
                }
            }
            int intValue = z3 ? (((Integer) objArr[8]).intValue() ^ 4643642) + pointerCount : pointerCount;
            float f4 = f2 / intValue;
            float f5 = f3 / intValue;
            int intValue2 = ((Integer) objArr[2]).intValue();
            int intValue3 = ((Integer) objArr[4]).intValue() ^ 1357759;
            switch (action & (intValue2 ^ 5960662)) {
                case 0:
                    if (this.mDoubleTapListener != null) {
                        Handler handler = this.mHandler;
                        int intValue4 = ((Integer) objArr[13]).intValue() ^ 4296087;
                        boolean hasMessages = handler.hasMessages(intValue4);
                        if (hasMessages) {
                            this.mHandler.removeMessages(intValue4);
                        }
                        MotionEvent motionEvent3 = this.mCurrentDownEvent;
                        if (motionEvent3 == null || (motionEvent2 = this.mPreviousUpEvent) == null || !hasMessages || !isConsideredDoubleTap(motionEvent3, motionEvent2, motionEvent)) {
                            this.mHandler.sendEmptyMessageDelayed(((Integer) objArr[14]).intValue() ^ 9149181, DOUBLE_TAP_TIMEOUT);
                            z = false;
                        } else {
                            this.mIsDoubleTapping = true;
                            z = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                        }
                    } else {
                        z = false;
                    }
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    MotionEvent motionEvent4 = this.mCurrentDownEvent;
                    if (motionEvent4 != null) {
                        motionEvent4.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                        Handler handler2 = this.mHandler;
                        int intValue5 = ((Integer) objArr[10]).intValue() ^ 1177050;
                        handler2.removeMessages(intValue5);
                        this.mHandler.sendEmptyMessageAtTime(intValue5, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                    }
                    this.mHandler.sendEmptyMessageAtTime(((Integer) objArr[15]).intValue() ^ 640122, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                    break;
                case 1:
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        onFling = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | false;
                    } else if (this.mInLongPress) {
                        this.mHandler.removeMessages(((Integer) objArr[6]).intValue() ^ 4267164);
                        this.mInLongPress = false;
                        onFling = false;
                    } else if (this.mAlwaysInTapRegion) {
                        boolean onSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                        if (!this.mDeferConfirmSingleTap || (onDoubleTapListener = this.mDoubleTapListener) == null) {
                            onFling = onSingleTapUp;
                        } else {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            onFling = onSingleTapUp;
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(intValue3, this.mMaximumFlingVelocity);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        onFling = (Math.abs(yVelocity) > ((float) this.mMinimumFlingVelocity) || Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity)) ? this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, yVelocity) : false;
                    }
                    MotionEvent motionEvent5 = this.mPreviousUpEvent;
                    if (motionEvent5 != null) {
                        motionEvent5.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(((Integer) objArr[16]).intValue() ^ 8350964);
                    this.mHandler.removeMessages(((Integer) objArr[12]).intValue() ^ 4007713);
                    break;
                case 2:
                    if (this.mInLongPress) {
                        break;
                    } else {
                        float f6 = this.mLastFocusX - f4;
                        float f7 = this.mLastFocusY - f5;
                        if (this.mIsDoubleTapping) {
                            break;
                        } else if (this.mAlwaysInTapRegion) {
                            int i3 = (int) (f4 - this.mDownFocusX);
                            int i4 = (int) (f5 - this.mDownFocusY);
                            int i5 = (i4 * i4) + (i3 * i3);
                            if (i5 > this.mTouchSlopSquare) {
                                boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                                this.mLastFocusX = f4;
                                this.mLastFocusY = f5;
                                this.mAlwaysInTapRegion = false;
                                this.mHandler.removeMessages(((Integer) objArr[0]).intValue() ^ 2898833);
                                this.mHandler.removeMessages(((Integer) objArr[3]).intValue() ^ 3012816);
                                this.mHandler.removeMessages(((Integer) objArr[11]).intValue() ^ 8641542);
                                z2 = onScroll;
                            } else {
                                z2 = false;
                            }
                            if (i5 > this.mTouchSlopSquare) {
                                this.mAlwaysInBiggerTapRegion = false;
                                break;
                            }
                        } else {
                            float abs = Math.abs(f6);
                            float floatValue = ((Float) objArr[5]).floatValue();
                            if (abs >= floatValue || Math.abs(f7) >= floatValue) {
                                boolean onScroll2 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                                this.mLastFocusX = f4;
                                this.mLastFocusY = f5;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    cancel();
                    break;
                case 5:
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    cancelTaps();
                    break;
                case 6:
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    this.mVelocityTracker.computeCurrentVelocity(intValue3, this.mMaximumFlingVelocity);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                    float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
                    int i6 = 0;
                    while (true) {
                        if (i6 < pointerCount) {
                            if (i6 != actionIndex2) {
                                int pointerId3 = motionEvent.getPointerId(i6);
                                if ((this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) + (this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) < 0.0f) {
                                    this.mVelocityTracker.clear();
                                }
                            }
                            i6 = (((Integer) objArr[9]).intValue() ^ 5714612) + i6;
                        }
                    }
                    break;
            }
            return false;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
