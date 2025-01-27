package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class FrameSequenceDrawable extends Drawable implements Animatable, Runnable {
    private static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;

    @Deprecated
    public static final int LOOP_ONCE = 1;
    private static final long MIN_DELAY_MS = 20;
    private static final int STATE_DECODING = 2;
    private static final int STATE_READY_TO_SWAP = 4;
    private static final int STATE_SCHEDULED = 1;
    private static final int STATE_WAITING_TO_SWAP = 3;
    private static final String TAG = "FrameSequenceDrawable";
    private static HandlerThread sDecodingThread;
    private static Handler sDecodingThreadHandler;
    private Bitmap mBackBitmap;
    private BitmapShader mBackBitmapShader;
    private final a mBitmapProvider;
    private boolean mCircleMaskEnabled;
    private int mCurrentLoop;
    private Runnable mDecodeRunnable;
    private boolean mDestroyed;
    private Runnable mFinishedCallbackRunnable;
    private final FrameSequence mFrameSequence;
    private final FrameSequence.State mFrameSequenceState;
    private Bitmap mFrontBitmap;
    private BitmapShader mFrontBitmapShader;
    private long mLastSwap;
    private final Object mLock;
    private int mLoopBehavior;
    private int mLoopCount;
    private int mNextFrameToDecode;
    private long mNextSwap;
    private b mOnFinishedListener;
    private final Paint mPaint;
    private final Rect mSrcRect;
    private int mState;
    private RectF mTempRectF;
    private static final Object sLock = new Object();
    private static a sAllocatingBitmapProvider = new a() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public final void a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }

        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public final Bitmap t(int i2, int i3) {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    };

    /* renamed from: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable$1 */
    static class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public final void a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }

        @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
        public final Bitmap t(int i2, int i3) {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    /* renamed from: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            synchronized (FrameSequenceDrawable.this.mLock) {
                if (FrameSequenceDrawable.this.mDestroyed) {
                    return;
                }
                int i2 = FrameSequenceDrawable.this.mNextFrameToDecode;
                if (i2 < 0) {
                    return;
                }
                Bitmap bitmap2 = FrameSequenceDrawable.this.mBackBitmap;
                FrameSequenceDrawable.this.mState = 2;
                long j2 = 0;
                boolean z2 = true;
                try {
                    j2 = FrameSequenceDrawable.this.mFrameSequenceState.getFrame(i2, bitmap2, i2 - 2);
                    z = false;
                } catch (Exception e2) {
                    Log.e(FrameSequenceDrawable.TAG, "exception during decode: " + e2);
                    z = true;
                }
                if (j2 < FrameSequenceDrawable.MIN_DELAY_MS) {
                    j2 = FrameSequenceDrawable.DEFAULT_DELAY_MS;
                }
                synchronized (FrameSequenceDrawable.this.mLock) {
                    bitmap = null;
                    if (FrameSequenceDrawable.this.mDestroyed) {
                        Bitmap bitmap3 = FrameSequenceDrawable.this.mBackBitmap;
                        FrameSequenceDrawable.this.mBackBitmap = null;
                        bitmap = bitmap3;
                    } else if (FrameSequenceDrawable.this.mNextFrameToDecode >= 0 && FrameSequenceDrawable.this.mState == 2) {
                        FrameSequenceDrawable frameSequenceDrawable = FrameSequenceDrawable.this;
                        frameSequenceDrawable.mNextSwap = z ? Long.MAX_VALUE : j2 + frameSequenceDrawable.mLastSwap;
                        FrameSequenceDrawable.this.mState = 3;
                    }
                    z2 = false;
                }
                if (z2) {
                    FrameSequenceDrawable frameSequenceDrawable2 = FrameSequenceDrawable.this;
                    frameSequenceDrawable2.scheduleSelf(frameSequenceDrawable2, frameSequenceDrawable2.mNextSwap);
                }
                if (bitmap != null) {
                    FrameSequenceDrawable.this.mBitmapProvider.a(bitmap);
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (FrameSequenceDrawable.this.mLock) {
                FrameSequenceDrawable.this.mNextFrameToDecode = -1;
                FrameSequenceDrawable.this.mState = 0;
            }
            if (FrameSequenceDrawable.this.mOnFinishedListener != null) {
                b unused = FrameSequenceDrawable.this.mOnFinishedListener;
            }
        }
    }

    public interface a {
        void a(Bitmap bitmap);

        Bitmap t(int i2, int i3);
    }

    public interface b {
    }

    public FrameSequenceDrawable(FrameSequence frameSequence) {
        this(frameSequence, sAllocatingBitmapProvider);
    }

    public FrameSequenceDrawable(FrameSequence frameSequence, a aVar) {
        this.mLock = new Object();
        this.mDestroyed = false;
        this.mLoopBehavior = 3;
        this.mLoopCount = 1;
        this.mTempRectF = new RectF();
        this.mDecodeRunnable = new Runnable() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                Bitmap bitmap;
                synchronized (FrameSequenceDrawable.this.mLock) {
                    if (FrameSequenceDrawable.this.mDestroyed) {
                        return;
                    }
                    int i2 = FrameSequenceDrawable.this.mNextFrameToDecode;
                    if (i2 < 0) {
                        return;
                    }
                    Bitmap bitmap2 = FrameSequenceDrawable.this.mBackBitmap;
                    FrameSequenceDrawable.this.mState = 2;
                    long j2 = 0;
                    boolean z2 = true;
                    try {
                        j2 = FrameSequenceDrawable.this.mFrameSequenceState.getFrame(i2, bitmap2, i2 - 2);
                        z = false;
                    } catch (Exception e2) {
                        Log.e(FrameSequenceDrawable.TAG, "exception during decode: " + e2);
                        z = true;
                    }
                    if (j2 < FrameSequenceDrawable.MIN_DELAY_MS) {
                        j2 = FrameSequenceDrawable.DEFAULT_DELAY_MS;
                    }
                    synchronized (FrameSequenceDrawable.this.mLock) {
                        bitmap = null;
                        if (FrameSequenceDrawable.this.mDestroyed) {
                            Bitmap bitmap3 = FrameSequenceDrawable.this.mBackBitmap;
                            FrameSequenceDrawable.this.mBackBitmap = null;
                            bitmap = bitmap3;
                        } else if (FrameSequenceDrawable.this.mNextFrameToDecode >= 0 && FrameSequenceDrawable.this.mState == 2) {
                            FrameSequenceDrawable frameSequenceDrawable = FrameSequenceDrawable.this;
                            frameSequenceDrawable.mNextSwap = z ? Long.MAX_VALUE : j2 + frameSequenceDrawable.mLastSwap;
                            FrameSequenceDrawable.this.mState = 3;
                        }
                        z2 = false;
                    }
                    if (z2) {
                        FrameSequenceDrawable frameSequenceDrawable2 = FrameSequenceDrawable.this;
                        frameSequenceDrawable2.scheduleSelf(frameSequenceDrawable2, frameSequenceDrawable2.mNextSwap);
                    }
                    if (bitmap != null) {
                        FrameSequenceDrawable.this.mBitmapProvider.a(bitmap);
                    }
                }
            }
        };
        this.mFinishedCallbackRunnable = new Runnable() { // from class: com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (FrameSequenceDrawable.this.mLock) {
                    FrameSequenceDrawable.this.mNextFrameToDecode = -1;
                    FrameSequenceDrawable.this.mState = 0;
                }
                if (FrameSequenceDrawable.this.mOnFinishedListener != null) {
                    b unused = FrameSequenceDrawable.this.mOnFinishedListener;
                }
            }
        };
        if (frameSequence == null || aVar == null) {
            throw new IllegalArgumentException();
        }
        this.mFrameSequence = frameSequence;
        FrameSequence.State createState = frameSequence.createState();
        this.mFrameSequenceState = createState;
        int width = frameSequence.getWidth();
        int height = frameSequence.getHeight();
        this.mBitmapProvider = aVar;
        this.mFrontBitmap = acquireAndValidateBitmap(aVar, width, height);
        this.mBackBitmap = acquireAndValidateBitmap(aVar, width, height);
        this.mSrcRect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(true);
        Bitmap bitmap = this.mFrontBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mFrontBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Bitmap bitmap2 = this.mBackBitmap;
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        this.mBackBitmapShader = new BitmapShader(bitmap2, tileMode2, tileMode2);
        this.mLastSwap = 0L;
        this.mNextFrameToDecode = -1;
        createState.getFrame(0, this.mFrontBitmap, -1);
        initializeDecodingThread();
    }

    public FrameSequenceDrawable(InputStream inputStream) {
        this(FrameSequence.decodeStream(inputStream));
    }

    private static Bitmap acquireAndValidateBitmap(a aVar, int i2, int i3) {
        Bitmap t = aVar.t(i2, i3);
        if (t.getWidth() < i2 || t.getHeight() < i3 || t.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Invalid bitmap provided");
        }
        return t;
    }

    private void checkDestroyedLocked() {
        if (this.mDestroyed) {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    private static void initializeDecodingThread() {
        synchronized (sLock) {
            if (sDecodingThread != null) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread("FrameSequence decoding thread", 10);
            sDecodingThread = handlerThread;
            handlerThread.start();
            sDecodingThreadHandler = new Handler(sDecodingThread.getLooper());
        }
    }

    private void scheduleDecodeLocked() {
        this.mState = 1;
        this.mNextFrameToDecode = (this.mNextFrameToDecode + 1) % this.mFrameSequence.getFrameCount();
        Handler handler = sDecodingThreadHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mDecodeRunnable);
            sDecodingThreadHandler.post(this.mDecodeRunnable);
        }
    }

    public void destroy() {
        if (this.mBitmapProvider == null) {
            throw new IllegalStateException("BitmapProvider must be non-null");
        }
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return;
            }
            Bitmap bitmap = this.mFrontBitmap;
            Bitmap bitmap2 = null;
            this.mFrontBitmap = null;
            if (this.mState != 2) {
                Bitmap bitmap3 = this.mBackBitmap;
                this.mBackBitmap = null;
                bitmap2 = bitmap3;
            }
            this.mDestroyed = true;
            this.mBitmapProvider.a(bitmap);
            if (bitmap2 != null) {
                this.mBitmapProvider.a(bitmap2);
            }
            this.mFrameSequenceState.destroy();
            this.mFrameSequence.destroy();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                return;
            }
            if (this.mState == 3 && this.mNextSwap - SystemClock.uptimeMillis() <= 0) {
                this.mState = 4;
            }
            if (isRunning() && this.mState == 4) {
                Bitmap bitmap = this.mBackBitmap;
                this.mBackBitmap = this.mFrontBitmap;
                this.mFrontBitmap = bitmap;
                BitmapShader bitmapShader = this.mBackBitmapShader;
                this.mBackBitmapShader = this.mFrontBitmapShader;
                this.mFrontBitmapShader = bitmapShader;
                this.mLastSwap = SystemClock.uptimeMillis();
                boolean z = true;
                if (this.mNextFrameToDecode == this.mFrameSequence.getFrameCount() - 1) {
                    int i2 = this.mCurrentLoop + 1;
                    this.mCurrentLoop = i2;
                    int i3 = this.mLoopBehavior;
                    if ((i3 == 1 && i2 == this.mLoopCount) || (i3 == 3 && i2 == this.mFrameSequence.getDefaultLoopCount())) {
                        z = false;
                    }
                }
                if (z) {
                    scheduleDecodeLocked();
                } else {
                    unscheduleSelf(this.mFinishedCallbackRunnable);
                    scheduleSelf(this.mFinishedCallbackRunnable, 0L);
                }
            }
            if (!this.mCircleMaskEnabled) {
                this.mPaint.setShader(null);
                canvas.drawBitmap(this.mFrontBitmap, this.mSrcRect, getBounds(), this.mPaint);
                return;
            }
            Rect bounds = getBounds();
            int intrinsicWidth = getIntrinsicWidth();
            float f2 = intrinsicWidth;
            float width = (bounds.width() * 1.0f) / f2;
            float intrinsicHeight = getIntrinsicHeight();
            float height = (bounds.height() * 1.0f) / intrinsicHeight;
            canvas.save();
            canvas.translate(bounds.left, bounds.top);
            canvas.scale(width, height);
            float min = Math.min(bounds.width(), bounds.height());
            float f3 = min / width;
            float f4 = min / height;
            this.mTempRectF.set((f2 - f3) / 2.0f, (intrinsicHeight - f4) / 2.0f, (f2 + f3) / 2.0f, (intrinsicHeight + f4) / 2.0f);
            this.mPaint.setShader(this.mFrontBitmapShader);
            canvas.drawOval(this.mTempRectF, this.mPaint);
            canvas.restore();
        }
    }

    public final boolean getCircleMaskEnabled() {
        return this.mCircleMaskEnabled;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mFrameSequence.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mFrameSequence.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mFrameSequence.isOpaque() ? -1 : -2;
    }

    public int getSize() {
        return this.mFrameSequence.getWidth() * this.mFrameSequence.getHeight() * 4;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mDestroyed;
        }
        return z;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mNextFrameToDecode >= 0 && !this.mDestroyed;
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mNextFrameToDecode < 0 || this.mState != 3) {
                z = false;
            } else {
                this.mState = 4;
                z = true;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mPaint.setAlpha(i2);
    }

    public final void setCircleMaskEnabled(boolean z) {
        if (this.mCircleMaskEnabled != z) {
            this.mCircleMaskEnabled = z;
            this.mPaint.setAntiAlias(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
    }

    public void setLoopCount(int i2) {
        this.mLoopCount = i2;
    }

    public void setOnFinishedListener(b bVar) {
        this.mOnFinishedListener = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning() || isDestroyed()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mState == 1) {
                return;
            }
            this.mCurrentLoop = 0;
            scheduleDecodeLocked();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            unscheduleSelf(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        synchronized (this.mLock) {
            this.mNextFrameToDecode = -1;
            this.mState = 0;
        }
        super.unscheduleSelf(runnable);
    }
}
