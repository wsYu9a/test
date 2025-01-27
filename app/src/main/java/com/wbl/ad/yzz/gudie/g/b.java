package com.wbl.ad.yzz.gudie.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.gudie.c;
import com.wbl.ad.yzz.help.n.f;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.util.h;
import f.b.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public Context f32565a;

    /* renamed from: b */
    public com.wbl.ad.yzz.innerconfig.d.d f32566b;

    /* renamed from: d */
    public boolean f32568d;

    /* renamed from: c */
    public List<a> f32567c = new ArrayList();

    /* renamed from: e */
    public Handler f32569e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    public Runnable f32570f = new RunnableC0741b();

    public static final class a {

        /* renamed from: a */
        public View f32571a;

        /* renamed from: b */
        public FrameLayout f32572b;

        /* renamed from: c */
        public Context f32573c;

        /* renamed from: d */
        public View f32574d;

        /* renamed from: e */
        public ImageView f32575e;

        /* renamed from: f */
        public ImageView f32576f;

        /* renamed from: g */
        public View f32577g;

        /* renamed from: h */
        public TextView f32578h;

        /* renamed from: i */
        public TextView f32579i;

        /* renamed from: j */
        public int f32580j;
        public com.wbl.ad.yzz.bean.b k;
        public com.wbl.ad.yzz.innerconfig.d.d l;
        public boolean n;
        public boolean o;
        public Handler m = new Handler(Looper.getMainLooper());
        public Runnable p = new d();
        public Runnable q = new RunnableC0739a();
        public c r = new c();

        /* renamed from: com.wbl.ad.yzz.gudie.g.b$a$a */
        public static final class RunnableC0739a implements Runnable {
            public RunnableC0739a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13400, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.gudie.g.b$a$b */
        public static final class C0740b implements c.a {

            /* renamed from: b */
            public final /* synthetic */ Context f32583b;

            /* renamed from: c */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32584c;

            public C0740b(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
                this.f32583b = context;
                this.f32584c = dVar;
            }

            @Override // com.wbl.ad.yzz.gudie.c.a
            public void a(int i2, String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13399, this, Integer.valueOf(i2), str);
            }

            @Override // com.wbl.ad.yzz.gudie.c.a
            public void a(com.wbl.ad.yzz.adapter.d.b bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13394, this, bVar);
            }
        }

        public static final class c implements f {
            public c() {
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(float f2, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13393, this, Float.valueOf(f2), bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13396, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(String str, com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13395, this, str, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void a(boolean z, boolean z2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13486, this, Boolean.valueOf(z), Boolean.valueOf(z2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void b(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13485, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void c(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13488, this, bVar, Integer.valueOf(i2));
            }

            @Override // com.wbl.ad.yzz.help.n.f
            public void d(com.wbl.ad.yzz.bean.b bVar, int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13487, this, bVar, Integer.valueOf(i2));
            }
        }

        public static final class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13482, this, null);
            }
        }

        public a(@e View view, int i2) {
            this.f32580j = i2;
            this.f32571a = view;
            this.f32574d = view != null ? view.findViewById(R.id.ad_container) : null;
            this.f32572b = view != null ? (FrameLayout) view.findViewById(R.id.fl_ad_dynamic_container) : null;
            this.f32575e = view != null ? (ImageView) view.findViewById(R.id.ad_image_view) : null;
            this.f32577g = view != null ? view.findViewById(R.id.ll_text_container) : null;
            this.f32578h = view != null ? (TextView) view.findViewById(R.id.tv_title) : null;
            this.f32579i = view != null ? (TextView) view.findViewById(R.id.tv_des) : null;
            this.f32576f = view != null ? (ImageView) view.findViewById(R.id.iv_logo) : null;
        }

        public static final /* synthetic */ Map a(a aVar, com.wbl.ad.yzz.bean.b bVar, k kVar, int i2) {
            return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13481, null, aVar, bVar, kVar, Integer.valueOf(i2));
        }

        public static final /* synthetic */ Context c(a aVar) {
            return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13478, null, aVar);
        }

        public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d d(a aVar) {
            return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13477, null, aVar);
        }

        public final Map<String, String> a(com.wbl.ad.yzz.bean.b bVar, k kVar, int i2) {
            return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13474, this, bVar, kVar, Integer.valueOf(i2));
        }

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13473, this, null);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13476, this, context, dVar);
        }

        public final void a(com.wbl.ad.yzz.bean.b bVar, Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13475, this, bVar, context, dVar);
        }

        public final void a(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13502, this, Boolean.valueOf(z));
        }

        public final boolean a(com.wbl.ad.yzz.bean.b bVar) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13501, this, bVar);
        }

        public final void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13504, this, null);
        }

        public final void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13503, this, null);
        }

        public final long d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-13498, this, null);
        }

        public final void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13497, this, null);
        }

        public final void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13500, this, null);
        }

        public final void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13499, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gudie.g.b$b */
    public static final class RunnableC0741b implements Runnable {
        public RunnableC0741b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13494, this, null);
        }
    }

    public b(@e View view, @e Context context, @e com.wbl.ad.yzz.innerconfig.d.d dVar) {
        LinearLayout linearLayout;
        this.f32565a = context;
        this.f32566b = dVar;
        if (view != null) {
            try {
                linearLayout = (LinearLayout) view.findViewById(R.id.top_banner_container_old);
            } catch (Throwable th) {
                com.wbl.ad.yzz.network.f.f.a(th);
                return;
            }
        } else {
            linearLayout = null;
        }
        LinearLayout linearLayout2 = view != null ? (LinearLayout) view.findViewById(R.id.top_banner_container) : null;
        if (linearLayout2 != null) {
            if (context == null) {
                return;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.wbl_layout_information_bottom_ad2, (ViewGroup) null);
                if (inflate != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    if (i2 != 0) {
                        layoutParams.topMargin = h.a(context, 5.0f);
                    }
                    inflate.setLayoutParams(layoutParams);
                    inflate.setVisibility(8);
                    if (i2 != 3 || linearLayout == null) {
                        linearLayout2.addView(inflate);
                    } else {
                        linearLayout.addView(inflate);
                    }
                    this.f32567c.add(new a(inflate, i2));
                }
            }
        }
        e();
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13496, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13495, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13490, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13489, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13492, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13491, this, null);
    }
}
