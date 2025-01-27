package com.wbl.ad.yzz.manager;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.newsweb.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a */
    public static boolean f32931a;

    /* renamed from: b */
    public static WeakReference<Activity> f32932b;

    /* renamed from: c */
    public static x f32933c;

    /* renamed from: d */
    public static Handler f32934d;

    /* renamed from: e */
    public static int f32935e;

    /* renamed from: f */
    public static ArrayList<p> f32936f;

    /* renamed from: g */
    public static final v f32937g;

    /* renamed from: h */
    public static com.wbl.ad.yzz.innerconfig.d.d f32938h;

    /* renamed from: i */
    public static boolean f32939i;

    /* renamed from: j */
    public static a f32940j;
    public static Object k;
    public static int l;
    public static j m;
    public static Runnable n;
    public static WeakReference<View> o;
    public static Runnable p;

    @f.b.a.d
    public static final h q;

    public static final class a {
        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12473, this, null);
        }

        public final void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12476, this, null);
        }

        public final void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12475, this, null);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12470, this, null);
        }

        public final void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12469, this, null);
        }

        public final void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12472, this, null);
        }

        public final void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12471, this, null);
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32941a;

        public static final class a implements View.OnClickListener {

            /* renamed from: a */
            public static final a f32942a = new a();

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12466, this, view);
            }
        }

        public b(Activity activity) {
            this.f32941a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12465, this, null);
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32943a;

        public c(Activity activity) {
            this.f32943a = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12468, this, null);
        }
    }

    public static final class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32944a;

        public d(Activity activity) {
            this.f32944a = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12467, this, null);
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32945a;

        public e(Activity activity) {
            this.f32945a = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12430, this, null);
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32946a;

        /* renamed from: b */
        public final /* synthetic */ String f32947b;

        public f(Activity activity, String str) {
            this.f32946a = activity;
            this.f32947b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12429, this, null);
        }
    }

    public static final class g<T> implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ x f32948a;

        public g(x xVar) {
            this.f32948a = xVar;
        }

        public final void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12432, this, str);
        }

        @Override // android.webkit.ValueCallback
        public /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12431, this, str);
        }
    }

    /* renamed from: com.wbl.ad.yzz.manager.h$h */
    public static final class RunnableC0755h implements Runnable {

        /* renamed from: a */
        public static final RunnableC0755h f32949a = new RunnableC0755h();

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12426, this, null);
        }
    }

    public static final class i implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12425, this, null);
        }
    }

    public static final class j implements Runnable {

        public static final class a<T> implements ValueCallback<String> {

            /* renamed from: a */
            public final /* synthetic */ x f32950a;

            /* renamed from: com.wbl.ad.yzz.manager.h$j$a$a */
            public static final class RunnableC0756a implements Runnable {

                /* renamed from: b */
                public final /* synthetic */ String f32952b;

                public RunnableC0756a(String str) {
                    this.f32952b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12428, this, null);
                }
            }

            public a(x xVar) {
                this.f32950a = xVar;
            }

            public final void a(String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12427, this, str);
            }

            @Override // android.webkit.ValueCallback
            public /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12422, this, str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12421, this, null);
        }
    }

    public static final class k implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ x f32953a;

        public static final class a<T> implements ValueCallback<String> {

            /* renamed from: a */
            public static final a f32954a = new a();

            public final void a(String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12424, this, str);
            }

            @Override // android.webkit.ValueCallback
            public /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12423, this, str);
            }
        }

        public k(x xVar) {
            this.f32953a = xVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12418, this, null);
        }
    }

    public static final class l implements a.InterfaceC0775a {
        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12417, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12420, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12419, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12446, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12445, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12448, this, null);
        }

        @Override // com.wbl.ad.yzz.newsweb.a.InterfaceC0775a
        public void g() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12447, this, null);
        }
    }

    public static final class m implements Runnable {

        /* renamed from: a */
        public static final m f32955a = new m();

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12442, this, null);
        }
    }

    public static final class n implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32956a;

        /* renamed from: b */
        public final /* synthetic */ View f32957b;

        /* renamed from: c */
        public final /* synthetic */ boolean f32958c;

        public n(Activity activity, View view, boolean z) {
            this.f32956a = activity;
            this.f32957b = view;
            this.f32958c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12441, this, null);
        }
    }

    public static final class o implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32959a;

        /* renamed from: b */
        public final /* synthetic */ View f32960b;

        /* renamed from: c */
        public final /* synthetic */ boolean f32961c;

        public o(Activity activity, View view, boolean z) {
            this.f32959a = activity;
            this.f32960b = view;
            this.f32961c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12444, this, null);
        }
    }

    static {
        h hVar = new h();
        q = hVar;
        f32934d = new Handler(Looper.getMainLooper());
        ArrayList<p> arrayList = new ArrayList<>(10);
        f32936f = arrayList;
        f32937g = new v();
        try {
            arrayList.add(new com.wbl.ad.yzz.manager.n(hVar));
            f32936f.add(new com.wbl.ad.yzz.manager.b(hVar));
            f32936f.add(new t(hVar));
            f32936f.add(new com.wbl.ad.yzz.manager.k(hVar));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        f32940j = new a();
        m = new j();
        n = RunnableC0755h.f32949a;
        p = new i();
    }

    public static final /* synthetic */ x a(h hVar, ViewGroup viewGroup) {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12443, null, hVar, viewGroup);
    }

    public static final /* synthetic */ ArrayList c(h hVar) {
        return (ArrayList) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12524, null, hVar);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d d(h hVar) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12523, null, hVar);
    }

    public static final /* synthetic */ WeakReference e(h hVar) {
        return (WeakReference) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12518, null, hVar);
    }

    public static final /* synthetic */ WeakReference f(h hVar) {
        return (WeakReference) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12517, null, hVar);
    }

    public static final /* synthetic */ Handler g(h hVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12520, null, hVar);
    }

    public static final /* synthetic */ a h(h hVar) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12519, null, hVar);
    }

    public static final /* synthetic */ x i(h hVar) {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12514, null, hVar);
    }

    public final x a(ViewGroup viewGroup) {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12539, this, viewGroup);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12534, this, null);
    }

    public final void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12533, this, activity);
    }

    public final void a(View view, Activity activity, long j2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12536, this, view, activity, Long.valueOf(j2), Boolean.valueOf(z));
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12535, this, dVar);
    }

    public final void a(x xVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12530, this, xVar);
    }

    public final void a(String str, x xVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12529, this, str, xVar);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12532, this, Boolean.valueOf(z));
    }

    public final boolean a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12531, this, str);
    }

    public final WebView b(ViewGroup viewGroup) {
        return (WebView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12494, this, viewGroup);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12493, this, null);
    }

    public final void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12496, this, activity);
    }

    public final boolean b(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12495, this, str);
    }

    public final x c(ViewGroup viewGroup) {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12490, this, viewGroup);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12489, this, null);
    }

    public final boolean c(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12492, this, str);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12491, this, null);
    }

    public final void d(ViewGroup viewGroup) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12486, this, viewGroup);
    }

    public final boolean d(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12485, this, str);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12488, this, null);
    }

    public final boolean e(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12487, this, str);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12482, this, null);
    }

    public final void f(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12481, this, str);
    }

    public final List<q> g() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12484, this, null);
    }

    public final void g(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12483, this, str);
    }

    public final com.wbl.ad.yzz.innerconfig.d.d h() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12510, this, null);
    }

    public final boolean i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12509, this, null);
    }

    public final boolean j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12512, this, null);
    }

    public final boolean k() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12511, this, null);
    }

    public final boolean l() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12506, this, null);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12505, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12508, this, null);
    }

    public final void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12507, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12502, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12501, this, null);
    }

    public final void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12504, this, null);
    }

    public final void s() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12503, this, null);
    }

    public final void t() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12498, this, null);
    }

    public final void u() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12497, this, null);
    }

    public final void v() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12500, this, null);
    }

    public final boolean w() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12499, this, null);
    }
}
