package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.sigmob.sdk.mraid2.c;

/* loaded from: classes4.dex */
public class j extends HorizontalScrollView implements l {

    /* renamed from: g */
    public static final String f19793g = "PageScrollView";

    /* renamed from: h */
    public static final float f19794h = 1000.0f;

    /* renamed from: i */
    public static final int f19795i = 1000;

    /* renamed from: a */
    public final int f19796a;

    /* renamed from: b */
    public final int f19797b;

    /* renamed from: c */
    public int f19798c;

    /* renamed from: d */
    public long f19799d;

    /* renamed from: e */
    public c.g f19800e;

    /* renamed from: f */
    public int f19801f;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f19802a;

        /* renamed from: b */
        public final /* synthetic */ int f19803b;

        public a(int i10, int i11) {
            this.f19802a = i10;
            this.f19803b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19802a <= 0) {
                if (j.this.f19801f > 0) {
                    j jVar = j.this;
                    jVar.scrollTo(jVar.f19801f - Math.abs(this.f19802a), 0);
                    return;
                }
                return;
            }
            int i10 = j.this.f19801f;
            j jVar2 = j.this;
            if (i10 + jVar2.f19796a < this.f19803b) {
                jVar2.scrollTo(jVar2.f19801f + Math.abs(this.f19802a), 0);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f19805a;

        /* renamed from: b */
        public final /* synthetic */ int f19806b;

        /* renamed from: c */
        public final /* synthetic */ int f19807c;

        /* renamed from: d */
        public final /* synthetic */ g f19808d;

        public b(boolean z10, int i10, int i11, g gVar) {
            this.f19805a = z10;
            this.f19806b = i10;
            this.f19807c = i11;
            this.f19808d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            if (this.f19805a) {
                if (this.f19806b > 0) {
                    int i11 = j.this.f19801f;
                    j jVar = j.this;
                    if (i11 + jVar.f19796a < this.f19807c) {
                        jVar.f19801f += j.this.f19796a;
                    }
                    i10 = 1;
                } else {
                    if (j.this.f19801f > 0) {
                        j.this.f19801f -= j.this.f19796a;
                    }
                    i10 = 2;
                }
                if (j.this.f19800e != null) {
                    j.this.f19800e.a(this.f19808d, i10, j.this.f19801f / j.this.f19796a);
                }
            }
            j jVar2 = j.this;
            jVar2.smoothScrollTo(jVar2.f19801f, 0);
        }
    }

    public j(Context context) {
        this(context, null);
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i10) {
        super.fling(0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public ViewGroup getView() {
        return this;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void setPageChangedListener(c.g gVar) {
        this.f19800e = gVar;
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void b(int i10, int i11) {
        post(new a(this.f19798c - i10, getChildAt(0).getWidth()));
    }

    public j(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11 = getResources().getDisplayMetrics().widthPixels;
        this.f19796a = i11;
        this.f19797b = i11 / 2;
        this.f19801f = 0;
    }

    public final boolean a(int i10) {
        int i11 = this.f19796a;
        int i12 = i10 % i11;
        Log.d("PageScrollView", i12 + ":-----goPage------:" + (i10 / i11));
        float currentTimeMillis = (float) (((long) (i10 * 1000)) / (System.currentTimeMillis() - this.f19799d));
        return currentTimeMillis >= 1000.0f || currentTimeMillis <= -1000.0f || i12 >= this.f19797b;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(g gVar, int i10, int i11) {
        int i12 = this.f19798c - i10;
        Log.d("PageScrollView", this.f19801f + "-----------onTouchEnd--------:" + i12);
        boolean a10 = a(i12);
        int width = getChildAt(0).getWidth();
        Log.d("PageScrollView", width + "------是否翻页----" + a10);
        post(new b(a10, i12, width, gVar));
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(int i10, int i11) {
        this.f19798c = i10;
        this.f19799d = System.currentTimeMillis();
        Log.d("PageScrollView", this.f19801f + "--------onTouchStart--------" + this.f19798c);
    }
}
