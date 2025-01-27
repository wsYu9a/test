package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2188a = 500;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2189b = 500;

    /* renamed from: c, reason: collision with root package name */
    long f2190c;

    /* renamed from: d, reason: collision with root package name */
    boolean f2191d;

    /* renamed from: e, reason: collision with root package name */
    boolean f2192e;

    /* renamed from: f, reason: collision with root package name */
    boolean f2193f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f2194g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f2195h;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        removeCallbacks(this.f2194g);
        removeCallbacks(this.f2195h);
    }

    public synchronized void hide() {
        this.f2193f = true;
        removeCallbacks(this.f2195h);
        this.f2192e = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f2190c;
        long j3 = currentTimeMillis - j2;
        if (j3 < 500 && j2 != -1) {
            if (!this.f2191d) {
                postDelayed(this.f2194g, 500 - j3);
                this.f2191d = true;
            }
        }
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public synchronized void show() {
        this.f2190c = -1L;
        this.f2193f = false;
        removeCallbacks(this.f2194g);
        this.f2191d = false;
        if (!this.f2192e) {
            postDelayed(this.f2195h, 500L);
            this.f2192e = true;
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2190c = -1L;
        this.f2191d = false;
        this.f2192e = false;
        this.f2193f = false;
        this.f2194g = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f2191d = false;
                contentLoadingProgressBar.f2190c = -1L;
                contentLoadingProgressBar.setVisibility(8);
            }
        };
        this.f2195h = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.2
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.f2192e = false;
                if (contentLoadingProgressBar.f2193f) {
                    return;
                }
                contentLoadingProgressBar.f2190c = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        };
    }
}
