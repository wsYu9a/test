package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class u extends ImageView {

    /* renamed from: m */
    public static final int f18913m = 1000;

    /* renamed from: a */
    public int f18914a;

    /* renamed from: b */
    public Movie f18915b;

    /* renamed from: c */
    public long f18916c;

    /* renamed from: d */
    public int f18917d;

    /* renamed from: e */
    public float f18918e;

    /* renamed from: f */
    public float f18919f;

    /* renamed from: g */
    public float f18920g;

    /* renamed from: h */
    public float f18921h;

    /* renamed from: i */
    public int f18922i;

    /* renamed from: j */
    public int f18923j;

    /* renamed from: k */
    public boolean f18924k;

    /* renamed from: l */
    public volatile boolean f18925l;

    public u(Context context) {
        this(context, null);
    }

    private byte[] getGiftBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream openRawResource = getResources().openRawResource(this.f18914a);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = openRawResource.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th2) {
                try {
                    SigmobLog.e(th2.getMessage());
                } finally {
                    if (openRawResource != null) {
                        try {
                            openRawResource.close();
                        } catch (Throwable th3) {
                            SigmobLog.e(th3.getMessage());
                        }
                    }
                }
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public final void a(Canvas canvas) {
        this.f18915b.setTime(this.f18917d);
        canvas.save();
        canvas.scale(this.f18920g, this.f18921h);
        this.f18915b.draw(canvas, this.f18918e / this.f18920g, this.f18919f / this.f18921h);
        canvas.restore();
    }

    public boolean b() {
        return this.f18925l;
    }

    public final void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f18916c == 0) {
            this.f18916c = uptimeMillis;
        }
        int duration = this.f18915b.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f18917d = (int) ((uptimeMillis - this.f18916c) % duration);
    }

    public Movie getMovie() {
        return this.f18915b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f18915b == null) {
            super.onDraw(canvas);
            return;
        }
        c();
        a(canvas);
        a();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f18918e = (getWidth() - this.f18922i) / 2.0f;
        this.f18919f = (getHeight() - this.f18923j) / 2.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        Movie movie = this.f18915b;
        if (movie == null) {
            super.onMeasure(i10, i11);
            return;
        }
        int width = movie.width();
        int height = this.f18915b.height();
        int size = View.MeasureSpec.getSize(i10);
        this.f18920g = 1.0f / (width / size);
        this.f18921h = 1.0f / (height / View.MeasureSpec.getSize(i11));
        this.f18922i = size;
        int size2 = View.MeasureSpec.getSize(i11);
        this.f18923j = size2;
        setMeasuredDimension(this.f18922i, size2);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i10) {
        super.onScreenStateChanged(i10);
        this.f18924k = i10 == 1;
        a();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.f18924k = i10 == 0;
        a();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f18924k = i10 == 0;
        a();
    }

    public void setMovie(Movie movie) {
        this.f18915b = movie;
        requestLayout();
    }

    public void setMovieResource(int i10) {
        this.f18914a = i10;
        byte[] giftBytes = getGiftBytes();
        this.f18915b = Movie.decodeByteArray(giftBytes, 0, giftBytes.length);
        requestLayout();
    }

    public void setMovieTime(int i10) {
        this.f18917d = i10;
        invalidate();
    }

    public void setPaused(boolean z10) {
        this.f18925l = z10;
        if (!z10) {
            this.f18916c = SystemClock.uptimeMillis() - this.f18917d;
        }
        invalidate();
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    public final void a() {
        if (this.f18924k) {
            postInvalidateOnAnimation();
        }
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18917d = 0;
        this.f18924k = true;
        this.f18925l = false;
        setLayerType(1, null);
    }
}
