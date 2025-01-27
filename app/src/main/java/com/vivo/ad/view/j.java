package com.vivo.ad.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.x0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class j extends s {
    private com.vivo.ad.view.w.a A;
    private byte[] B;
    private File C;
    private volatile int D;
    private volatile int E;

    /* renamed from: j */
    private Movie f27036j;
    private long k;
    private int l;
    private volatile AnimatedImageDrawable m;
    private boolean n;
    private boolean o;
    private float p;
    private float q;
    private float r;
    private int s;
    private int t;
    private volatile boolean u;
    private boolean v;
    private Path w;
    private Paint x;
    private float[] y;
    private int z;

    class a implements ImageDecoder.OnHeaderDecodedListener {
        a() {
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (j.this.D <= 0 || j.this.E <= 0 || imageDecoder == null) {
                return;
            }
            imageDecoder.setTargetSize(j.this.D, j.this.E);
        }
    }

    class b implements Callable<Object> {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ AnimatedImageDrawable f27039a;

            a(AnimatedImageDrawable animatedImageDrawable) {
                this.f27039a = animatedImageDrawable;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (Build.VERSION.SDK_INT >= 28) {
                    j.this.setImageDrawable(this.f27039a);
                }
                if (this.f27039a != null && !j.this.u) {
                    this.f27039a.start();
                }
                j.this.setGif(true);
            }
        }

        b() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            try {
                j jVar = j.this;
                jVar.m = jVar.c(jVar.B, j.this.C);
                j.this.post(new a(j.this.m));
                return null;
            } catch (Exception e2) {
                x0.e("GifView", "call()-->" + e2.getMessage());
                return null;
            }
        }
    }

    public j(Context context, int i2) {
        super(context, i2);
        this.z = 0;
        this.D = 0;
        this.E = 0;
        if (i2 != 0) {
            float f2 = i2;
            this.y = new float[]{f2, f2, f2, f2, f2, f2, f2, f2};
        }
        a(context);
    }

    private void b(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (this.y == null) {
                super.draw(canvas);
                return;
            }
            if (getDrawable() == null && getBackground() == null && this.f27036j == null && this.n) {
                super.draw(canvas);
                return;
            }
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 18) {
                setLayerType(1, null);
            }
            this.A.a(canvas, this.y);
            super.draw(canvas);
            canvas.restore();
        } catch (Exception unused) {
        }
    }

    @Override // com.vivo.ad.view.s, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f27036j == null || this.n) {
            super.onDraw(canvas);
            b(canvas);
            return;
        }
        try {
            if (this.u) {
                a(canvas);
                b(canvas);
            } else {
                b();
                a(canvas);
                b(canvas);
                a();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int width = getWidth();
        int height = getHeight();
        if (this.f27036j != null && !this.n) {
            this.p = (width - this.s) / 2.0f;
            this.q = (height - this.t) / 2.0f;
        } else if (this.C != null && this.n && (this.D != width || this.E != height)) {
            this.D = width;
            this.E = height;
            if (this.m != null) {
                try {
                    this.m.stop();
                } catch (Exception e2) {
                    x0.e("GifView", "AnimatedImageDrawable.stop()-->" + e2.getMessage());
                }
            }
            a1.a(new b());
        }
        this.A.a(getWidth(), getHeight());
        this.v = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i2, i3);
        if (this.n || (movie = this.f27036j) == null) {
            return;
        }
        int width = movie.width();
        int height = this.f27036j.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i2) == 0 || width <= (size2 = View.MeasureSpec.getSize(i2))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i3) == 0 || height <= (size = View.MeasureSpec.getSize(i3))) ? 1.0f : height / size);
        this.r = max;
        int i4 = (int) (width * max);
        this.s = i4;
        int i5 = (int) (height * max);
        this.t = i5;
        setMeasuredDimension(i4, i5);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        if (this.f27036j != null) {
            this.v = i2 == 0;
            a();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.x.setColor(this.z);
        a(i2, i3);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (this.f27036j != null) {
            this.v = i2 == 0;
            a();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f27036j != null) {
            this.v = i2 == 0;
            a();
        }
    }

    public void setGifRoundWithOverlayColor(int i2) {
        this.z = i2;
    }

    @RequiresApi(api = 28)
    private ImageDecoder.Source b(byte[] bArr, File file) {
        try {
            return ImageDecoder.createSource(file);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(28)
    public AnimatedImageDrawable c(byte[] bArr, File file) {
        ImageDecoder.Source source = null;
        if (this.o) {
            try {
                source = (ImageDecoder.Source) ImageDecoder.class.getMethod("createSource", Resources.class, InputStream.class).invoke(null, getResources(), new ByteArrayInputStream(bArr));
            } catch (Throwable unused) {
            }
        }
        if (source == null) {
            source = b(bArr, file);
        }
        return a(source);
    }

    private void b() {
        if (this.f27036j != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.k == 0) {
                this.k = uptimeMillis;
            }
            int duration = this.f27036j.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.l = (int) ((uptimeMillis - this.k) % duration);
        }
    }

    void a(Context context) {
        Path path = new Path();
        this.w = path;
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        Paint paint = new Paint();
        this.x = paint;
        paint.setAntiAlias(true);
        boolean z = Build.VERSION.SDK_INT >= 28;
        this.n = z;
        this.o = false;
        this.v = true;
        if (!z) {
            setLayerType(1, null);
        }
        this.A = new com.vivo.ad.view.w.a(this, context);
    }

    public void a(byte[] bArr, File file) {
        this.B = bArr;
        this.C = file;
        if (bArr == null && file == null) {
            return;
        }
        if (!this.n) {
            this.f27036j = a(bArr);
            setGif(true);
            requestLayout();
            a();
            return;
        }
        requestLayout();
        a();
    }

    private Movie a(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    @RequiresApi(api = 28)
    private AnimatedImageDrawable a(ImageDecoder.Source source) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new a());
            if (decodeDrawable instanceof AnimatedImageDrawable) {
                return (AnimatedImageDrawable) decodeDrawable;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a() {
        if (this.f27036j == null || this.n || !this.v) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private void a(Canvas canvas) {
        Movie movie = this.f27036j;
        if (movie != null) {
            movie.setTime(this.l);
            float f2 = this.r;
            canvas.scale(f2, f2);
            Movie movie2 = this.f27036j;
            float f3 = this.p;
            float f4 = this.r;
            movie2.draw(canvas, f3 / f4, this.q / f4);
            canvas.restore();
        }
    }

    private void a(int i2, int i3) {
        this.w.reset();
        this.w.addRoundRect(new RectF(0.0f, 0.0f, i2, i3), this.y, Path.Direction.CCW);
    }
}
