package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.sigmob.sdk.mraid2.c;

/* loaded from: classes4.dex */
public class o extends ScrollView implements l {

    /* renamed from: g */
    public static final String f19823g = "PageScrollView";

    /* renamed from: h */
    public static final float f19824h = 1000.0f;

    /* renamed from: i */
    public static final int f19825i = 1000;

    /* renamed from: a */
    public final int f19826a;

    /* renamed from: b */
    public final int f19827b;

    /* renamed from: c */
    public int f19828c;

    /* renamed from: d */
    public long f19829d;

    /* renamed from: e */
    public c.g f19830e;

    /* renamed from: f */
    public int f19831f;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f19832a;

        /* renamed from: b */
        public final /* synthetic */ int f19833b;

        public a(int i10, int i11) {
            this.f19832a = i10;
            this.f19833b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19832a <= 0) {
                if (o.this.f19831f > 0) {
                    o oVar = o.this;
                    oVar.scrollTo(0, oVar.f19831f - Math.abs(this.f19832a));
                    return;
                }
                return;
            }
            int i10 = o.this.f19831f;
            o oVar2 = o.this;
            if (i10 + oVar2.f19826a < this.f19833b) {
                oVar2.scrollTo(0, oVar2.f19831f + Math.abs(this.f19832a));
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f19835a;

        /* renamed from: b */
        public final /* synthetic */ int f19836b;

        /* renamed from: c */
        public final /* synthetic */ int f19837c;

        /* renamed from: d */
        public final /* synthetic */ g f19838d;

        public b(boolean z10, int i10, int i11, g gVar) {
            this.f19835a = z10;
            this.f19836b = i10;
            this.f19837c = i11;
            this.f19838d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            if (this.f19835a) {
                if (this.f19836b > 0) {
                    int i11 = o.this.f19831f;
                    o oVar = o.this;
                    if (i11 + oVar.f19826a < this.f19837c) {
                        oVar.f19831f += o.this.f19826a;
                    }
                    i10 = 1;
                } else {
                    if (o.this.f19831f > 0) {
                        o.this.f19831f -= o.this.f19826a;
                    }
                    i10 = 2;
                }
                if (o.this.f19830e != null) {
                    o.this.f19830e.a(this.f19838d, i10, o.this.f19831f / o.this.f19826a);
                }
            }
            o oVar2 = o.this;
            oVar2.smoothScrollTo(0, oVar2.f19831f);
        }
    }

    public o(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView
    public void fling(int i10) {
        super.fling(0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public ViewGroup getView() {
        return this;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void setPageChangedListener(c.g gVar) {
        this.f19830e = gVar;
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void b(int i10, int i11) {
        post(new a(this.f19828c - i11, getChildAt(0).getHeight()));
    }

    public o(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11 = getResources().getDisplayMetrics().heightPixels;
        this.f19826a = i11;
        this.f19827b = i11 / 2;
        this.f19831f = 0;
    }

    public final boolean a(int i10) {
        int i11 = this.f19826a;
        int i12 = i10 % i11;
        Log.d("PageScrollView", i12 + ":-----goPage------:" + (i10 / i11));
        float currentTimeMillis = (float) (((long) (i10 * 1000)) / (System.currentTimeMillis() - this.f19829d));
        return currentTimeMillis >= 1000.0f || currentTimeMillis <= -1000.0f || i12 >= this.f19827b;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(g gVar, int i10, int i11) {
        int i12 = this.f19828c - i11;
        Log.d("PageScrollView", this.f19831f + "-----------onTouchEnd--------:" + i12);
        post(new b(a(i12), i12, getChildAt(0).getHeight(), gVar));
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(int i10, int i11) {
        this.f19828c = i11;
        this.f19829d = System.currentTimeMillis();
        Log.d("PageScrollView", this.f19831f + "--------onTouchStart--------" + this.f19828c);
    }
}
