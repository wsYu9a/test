package com.wbl.ad.yzz.manager;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a */
    public static boolean f32898a;

    /* renamed from: b */
    public static boolean f32899b;

    /* renamed from: c */
    public static boolean f32900c;

    /* renamed from: d */
    public static long f32901d;

    /* renamed from: e */
    public static com.wbl.ad.yzz.innerconfig.d.d f32902e;

    /* renamed from: f */
    public static boolean f32903f;

    /* renamed from: g */
    public static WeakReference<View> f32904g;

    /* renamed from: h */
    public static WeakReference<Activity> f32905h;

    /* renamed from: i */
    public static CountDownTimer f32906i;

    /* renamed from: j */
    public static CountDownTimer f32907j;
    public static WeakReference<Activity> k;
    public static Handler l;

    @f.b.a.d
    public static final g m = new g();

    public interface a {
        void a();
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WeakReference f32908a;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f32909b;

        /* renamed from: c */
        public final /* synthetic */ View f32910c;

        public b(WeakReference weakReference, ViewGroup viewGroup, View view) {
            this.f32908a = weakReference;
            this.f32909b = viewGroup;
            this.f32910c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12409, this, null);
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32911a;

        /* renamed from: b */
        public final /* synthetic */ boolean f32912b;

        public c(Activity activity, boolean z) {
            this.f32911a = activity;
            this.f32912b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12412, this, null);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a */
        public static final d f32913a = new d();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12411, this, view);
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32914a;

        /* renamed from: b */
        public final /* synthetic */ boolean f32915b;

        /* renamed from: c */
        public final /* synthetic */ a f32916c;

        public static final class a implements a {
            public a() {
            }

            @Override // com.wbl.ad.yzz.manager.g.a
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12406, this, null);
            }
        }

        public e(Activity activity, boolean z, a aVar) {
            this.f32914a = activity;
            this.f32915b = z;
            this.f32916c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12405, this, null);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ a f32918a;

        public f(a aVar) {
            this.f32918a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12408, this, view);
        }
    }

    /* renamed from: com.wbl.ad.yzz.manager.g$g */
    public static final class ViewOnClickListenerC0754g implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ FrameLayout f32919a;

        /* renamed from: b */
        public final /* synthetic */ View f32920b;

        public ViewOnClickListenerC0754g(FrameLayout frameLayout, View view) {
            this.f32919a = frameLayout;
            this.f32920b = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12407, this, view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: a */
        public static final h f32921a = new h();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12402, this, view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ a f32922a;

        public i(a aVar) {
            this.f32922a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12401, this, view);
        }
    }

    public static final class j extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ TextView f32923a;

        /* renamed from: b */
        public final /* synthetic */ Activity f32924b;

        /* renamed from: c */
        public final /* synthetic */ a f32925c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TextView textView, Activity activity, a aVar, long j2, long j3) {
            super(j2, j3);
            this.f32923a = textView;
            this.f32924b = activity;
            this.f32925c = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12404, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12403, this, Long.valueOf(j2));
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: a */
        public static final k f32926a = new k();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12366, this, view);
        }
    }

    public static final class l extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ TextView f32927a;

        /* renamed from: b */
        public final /* synthetic */ TextView f32928b;

        /* renamed from: c */
        public final /* synthetic */ boolean f32929c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(TextView textView, TextView textView2, boolean z, long j2, long j3) {
            super(j2, j3);
            this.f32927a = textView;
            this.f32928b = textView2;
            this.f32929c = z;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12365, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12368, this, Long.valueOf(j2));
        }
    }

    public static final class m implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Activity f32930a;

        public m(Activity activity) {
            this.f32930a = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12367, this, view);
        }
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d a(g gVar) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12362, null, gVar);
    }

    public final int a(List<com.wbl.ad.yzz.adapter.d.b> list, int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12359, this, list, Integer.valueOf(i2));
    }

    public final Integer a(List<com.wbl.ad.yzz.adapter.d.b> list) {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12354, this, list);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12353, this, null);
    }

    public final void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12356, this, activity);
    }

    public final void a(Activity activity, ViewGroup viewGroup, View view, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12355, this, activity, viewGroup, view, Long.valueOf(j2));
    }

    public final void a(Activity activity, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12382, this, activity, aVar);
    }

    public final void a(Activity activity, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12381, this, activity, Boolean.valueOf(z));
    }

    public final void a(Activity activity, boolean z, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12384, this, activity, Boolean.valueOf(z), aVar);
    }

    public final void a(TextView textView, TextView textView2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12383, this, textView, textView2, Boolean.valueOf(z));
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12378, this, str);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12377, this, Boolean.valueOf(z));
    }

    public final void a(boolean z, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12380, this, Boolean.valueOf(z), dVar);
    }

    public final boolean a(com.wbl.ad.yzz.adapter.d.b bVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12379, this, bVar);
    }

    public final boolean a(com.wbl.ad.yzz.adapter.d.b bVar, List<String> list) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12374, this, bVar, list);
    }

    public final int b(List<com.wbl.ad.yzz.adapter.d.b> list) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12373, this, list);
    }

    public final String b(com.wbl.ad.yzz.adapter.d.b bVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12376, this, bVar);
    }

    public final void b(Activity activity, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12375, this, activity, Boolean.valueOf(z));
    }

    public final void b(Activity activity, boolean z, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12370, this, activity, Boolean.valueOf(z), aVar);
    }

    public final void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12369, this, Boolean.valueOf(z));
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12372, this, null);
    }

    public final Integer c(List<com.wbl.ad.yzz.adapter.d.b> list) {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12371, this, list);
    }

    public final void c(Activity activity, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12462, this, activity, Boolean.valueOf(z));
    }

    public final void c(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12461, this, Boolean.valueOf(z));
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12464, this, null);
    }

    public final Integer d(List<com.wbl.ad.yzz.adapter.d.b> list) {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12463, this, list);
    }

    public final String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12458, this, null);
    }

    public final long e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-12457, this, null);
    }

    public final Integer e(List<com.wbl.ad.yzz.adapter.d.b> list) {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12460, this, list);
    }

    public final long f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-12459, this, null);
    }

    public final void f(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12454, this, list);
    }

    public final boolean g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12453, this, null);
    }

    public final String h() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12456, this, null);
    }

    public final Handler i() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12455, this, null);
    }

    public final long j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-12450, this, null);
    }

    public final boolean k() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12449, this, null);
    }

    public final boolean l() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12452, this, null);
    }

    public final boolean m() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12451, this, null);
    }

    public final boolean n() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12478, this, null);
    }

    public final boolean o() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12477, this, null);
    }

    public final boolean p() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12480, this, null);
    }

    public final void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12479, this, null);
    }

    public final void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12474, this, null);
    }
}
