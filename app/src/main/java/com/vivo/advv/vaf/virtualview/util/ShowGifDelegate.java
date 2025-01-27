package com.vivo.advv.vaf.virtualview.util;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class ShowGifDelegate {
    public static final String TAG = "ShowGifHelper";
    private boolean mAboveP;
    private volatile AnimatedImageDrawable mAnimatedImageDrawable;
    private int mCurrentAnimationTime;
    private byte[] mGifData;
    private File mGifFile;
    private float mLeft;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private Movie mMovie;
    private long mMovieStart;
    private float mScaleFactor;
    private ShowGifListener mShowGifListener;
    private float mTop;
    private boolean mVisible;
    private volatile boolean mPause = false;
    private volatile int mLastWidth = 0;
    private volatile int mLastHeight = 0;

    /* renamed from: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate$1 */
    class AnonymousClass1 implements Callable<Object> {
        final /* synthetic */ View val$view;

        /* renamed from: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate$1$1 */
        class RunnableC05631 implements Runnable {
            final /* synthetic */ AnimatedImageDrawable val$animatedImageDrawable;

            RunnableC05631(AnimatedImageDrawable animatedImageDrawable) {
                animatedImageDrawable = animatedImageDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 28 && ShowGifDelegate.this.mShowGifListener != null) {
                        ShowGifDelegate.this.mShowGifListener.onLoad(animatedImageDrawable);
                    }
                    if (animatedImageDrawable == null || ShowGifDelegate.this.mPause) {
                        return;
                    }
                    animatedImageDrawable.start();
                } catch (Exception unused) {
                }
            }
        }

        AnonymousClass1(View view) {
            view = view;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            try {
                ShowGifDelegate showGifDelegate = ShowGifDelegate.this;
                showGifDelegate.mAnimatedImageDrawable = showGifDelegate.decodeDrawable(showGifDelegate.mGifData, ShowGifDelegate.this.mGifFile);
                view.post(new Runnable() { // from class: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.1.1
                    final /* synthetic */ AnimatedImageDrawable val$animatedImageDrawable;

                    RunnableC05631(AnimatedImageDrawable animatedImageDrawable) {
                        animatedImageDrawable = animatedImageDrawable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (Build.VERSION.SDK_INT >= 28 && ShowGifDelegate.this.mShowGifListener != null) {
                                ShowGifDelegate.this.mShowGifListener.onLoad(animatedImageDrawable);
                            }
                            if (animatedImageDrawable == null || ShowGifDelegate.this.mPause) {
                                return;
                            }
                            animatedImageDrawable.start();
                        } catch (Exception unused) {
                        }
                    }
                });
                return null;
            } catch (Exception e2) {
                VVLog.w(ShowGifDelegate.TAG, "call()-->" + e2.getMessage());
                return null;
            }
        }
    }

    /* renamed from: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate$2 */
    class AnonymousClass2 implements ImageDecoder.OnHeaderDecodedListener {
        AnonymousClass2() {
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (ShowGifDelegate.this.mLastWidth <= 0 || ShowGifDelegate.this.mLastHeight <= 0 || imageDecoder == null) {
                return;
            }
            imageDecoder.setTargetSize(ShowGifDelegate.this.mLastWidth, ShowGifDelegate.this.mLastHeight);
        }
    }

    public interface ShowGifListener {
        void onLoad(Drawable drawable);

        void onMeasureResult(int i2, int i3);
    }

    public ShowGifDelegate(View view) {
        boolean z = Build.VERSION.SDK_INT >= 28;
        this.mAboveP = z;
        this.mVisible = true;
        if (z) {
            return;
        }
        view.setLayerType(1, null);
    }

    @RequiresApi(api = 28)
    private ImageDecoder.Source createSource(byte[] bArr, File file) {
        try {
            return ImageDecoder.createSource(file);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie decodeByteArray(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(28)
    public AnimatedImageDrawable decodeDrawable(byte[] bArr, File file) {
        return decodeDrawable(createSource(bArr, file));
    }

    private void drawMovieFrame(Canvas canvas) {
        Movie movie = this.mMovie;
        if (movie != null) {
            movie.setTime(this.mCurrentAnimationTime);
            float f2 = this.mScaleFactor;
            canvas.scale(f2, f2);
            Movie movie2 = this.mMovie;
            float f3 = this.mLeft;
            float f4 = this.mScaleFactor;
            movie2.draw(canvas, f3 / f4, this.mTop / f4);
            canvas.restore();
        }
    }

    private void invalidateMovie(View view) {
        if (this.mMovie == null || this.mAboveP || !this.mVisible) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.invalidate();
        }
    }

    private void updateAnimationTime() {
        if (this.mMovie != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mMovieStart == 0) {
                this.mMovieStart = uptimeMillis;
            }
            int duration = this.mMovie.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.mCurrentAnimationTime = (int) ((uptimeMillis - this.mMovieStart) % duration);
        }
    }

    public void decode(View view, byte[] bArr, File file) {
        this.mGifData = bArr;
        this.mGifFile = file;
        if (bArr == null && file == null) {
            return;
        }
        if (this.mAboveP) {
            view.requestLayout();
            invalidateMovie(view);
        } else {
            this.mMovie = decodeByteArray(bArr);
            view.requestLayout();
            invalidateMovie(view);
        }
    }

    public boolean isDecodeMovie() {
        return (this.mMovie == null || this.mAboveP) ? false : true;
    }

    public void setShowGifListener(ShowGifListener showGifListener) {
        this.mShowGifListener = showGifListener;
    }

    public void viewDraw(View view, Canvas canvas) {
    }

    public boolean viewOnDraw(View view, Canvas canvas) {
        if (this.mMovie == null || this.mAboveP) {
            return false;
        }
        try {
            if (this.mPause) {
                drawMovieFrame(canvas);
            } else {
                updateAnimationTime();
                drawMovieFrame(canvas);
                invalidateMovie(view);
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public void viewOnLayout(View view, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.mMovie != null && !this.mAboveP) {
            this.mLeft = (i6 - this.mMeasuredWidth) / 2.0f;
            this.mTop = (i7 - this.mMeasuredHeight) / 2.0f;
        } else if (this.mGifFile != null && this.mAboveP && (this.mLastWidth != i6 || this.mLastHeight != i7)) {
            this.mLastWidth = i6;
            this.mLastHeight = i7;
            if (this.mAnimatedImageDrawable != null) {
                try {
                    this.mAnimatedImageDrawable.stop();
                } catch (Exception e2) {
                    VVLog.w(TAG, "AnimatedImageDrawable.stop()-->" + e2.getMessage());
                }
            }
            VVWorkerThread.submitOnExecutor(new Callable<Object>() { // from class: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.1
                final /* synthetic */ View val$view;

                /* renamed from: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate$1$1 */
                class RunnableC05631 implements Runnable {
                    final /* synthetic */ AnimatedImageDrawable val$animatedImageDrawable;

                    RunnableC05631(AnimatedImageDrawable animatedImageDrawable) {
                        animatedImageDrawable = animatedImageDrawable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (Build.VERSION.SDK_INT >= 28 && ShowGifDelegate.this.mShowGifListener != null) {
                                ShowGifDelegate.this.mShowGifListener.onLoad(animatedImageDrawable);
                            }
                            if (animatedImageDrawable == null || ShowGifDelegate.this.mPause) {
                                return;
                            }
                            animatedImageDrawable.start();
                        } catch (Exception unused) {
                        }
                    }
                }

                AnonymousClass1(View view2) {
                    view = view2;
                }

                @Override // java.util.concurrent.Callable
                public Object call() throws Exception {
                    try {
                        ShowGifDelegate showGifDelegate = ShowGifDelegate.this;
                        showGifDelegate.mAnimatedImageDrawable = showGifDelegate.decodeDrawable(showGifDelegate.mGifData, ShowGifDelegate.this.mGifFile);
                        view.post(new Runnable() { // from class: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.1.1
                            final /* synthetic */ AnimatedImageDrawable val$animatedImageDrawable;

                            RunnableC05631(AnimatedImageDrawable animatedImageDrawable) {
                                animatedImageDrawable = animatedImageDrawable;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (Build.VERSION.SDK_INT >= 28 && ShowGifDelegate.this.mShowGifListener != null) {
                                        ShowGifDelegate.this.mShowGifListener.onLoad(animatedImageDrawable);
                                    }
                                    if (animatedImageDrawable == null || ShowGifDelegate.this.mPause) {
                                        return;
                                    }
                                    animatedImageDrawable.start();
                                } catch (Exception unused) {
                                }
                            }
                        });
                        return null;
                    } catch (Exception e22) {
                        VVLog.w(ShowGifDelegate.TAG, "call()-->" + e22.getMessage());
                        return null;
                    }
                }
            });
        }
        this.mVisible = view2.getVisibility() == 0;
    }

    public void viewOnMeasure(View view, int i2, int i3) {
        Movie movie;
        int size;
        int size2;
        if (this.mAboveP || (movie = this.mMovie) == null) {
            return;
        }
        int width = movie.width();
        int height = this.mMovie.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i2) == 0 || width <= (size2 = View.MeasureSpec.getSize(i2))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i3) == 0 || height <= (size = View.MeasureSpec.getSize(i3))) ? 1.0f : height / size);
        this.mScaleFactor = max;
        int i4 = (int) (width * max);
        this.mMeasuredWidth = i4;
        this.mMeasuredHeight = (int) (height * max);
        ShowGifListener showGifListener = this.mShowGifListener;
        if (showGifListener != null) {
            showGifListener.onMeasureResult(i4, i4);
        }
    }

    public void viewOnScreenStateChanged(View view, int i2) {
        if (this.mMovie != null) {
            this.mVisible = i2 == 0;
            invalidateMovie(view);
        }
    }

    public void viewOnVisibilityChanged(View view, int i2) {
        if (this.mMovie != null) {
            this.mVisible = i2 == 0;
            invalidateMovie(view);
        }
    }

    public void viewOnWindowVisibilityChanged(View view, int i2) {
        if (this.mMovie != null) {
            this.mVisible = i2 == 0;
            invalidateMovie(view);
        }
    }

    @RequiresApi(api = 28)
    private AnimatedImageDrawable decodeDrawable(ImageDecoder.Source source) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.2
                AnonymousClass2() {
                }

                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                    if (ShowGifDelegate.this.mLastWidth <= 0 || ShowGifDelegate.this.mLastHeight <= 0 || imageDecoder == null) {
                        return;
                    }
                    imageDecoder.setTargetSize(ShowGifDelegate.this.mLastWidth, ShowGifDelegate.this.mLastHeight);
                }
            });
            if (decodeDrawable instanceof AnimatedImageDrawable) {
                return (AnimatedImageDrawable) decodeDrawable;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
