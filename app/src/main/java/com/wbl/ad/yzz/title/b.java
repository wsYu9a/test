package com.wbl.ad.yzz.title;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.innerconfig.d.j;
import com.wbl.ad.yzz.network.b.b.j0;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.util.a;
import com.wbl.ad.yzz.util.h;
import com.wbl.ad.yzz.wigdet.AutoVerticalScrollTextView;
import com.wbl.ad.yzz.wigdet.rclay.RCRelativeLayout;

/* loaded from: classes5.dex */
public class b {
    public View A;
    public Handler E;
    public final j F;

    /* renamed from: a */
    public final Activity f33849a;

    /* renamed from: b */
    public final View f33850b;

    /* renamed from: c */
    public final View f33851c;

    /* renamed from: d */
    public final LinearLayout f33852d;

    /* renamed from: e */
    public final TextView f33853e;

    /* renamed from: f */
    public final TextView f33854f;

    /* renamed from: g */
    public final TextView f33855g;

    /* renamed from: h */
    public final RelativeLayout f33856h;

    /* renamed from: i */
    public RelativeLayout f33857i;

    /* renamed from: j */
    public RCRelativeLayout f33858j;
    public ImageView k;
    public AutoVerticalScrollTextView l;
    public RelativeLayout m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public ImageView r;
    public View s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public View w;
    public ImageView x;
    public RCRelativeLayout y;
    public View z;
    public int B = -1;
    public boolean C = false;
    public boolean D = false;
    public boolean G = false;
    public int H = 0;
    public boolean I = false;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ImageView f33859a;

        /* renamed from: b */
        public final /* synthetic */ long f33860b;

        /* renamed from: com.wbl.ad.yzz.title.b$a$a */
        public class RunnableC0779a implements Runnable {
            public RunnableC0779a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9746, this, null);
            }
        }

        public a(ImageView imageView, long j2) {
            this.f33859a = imageView;
            this.f33860b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9745, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.title.b$b */
    public class C0780b implements a.j {
        public C0780b(b bVar) {
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9748, this, null);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f33863a;

        /* renamed from: b */
        public final /* synthetic */ long f33864b;

        /* renamed from: c */
        public final /* synthetic */ long f33865c;

        /* renamed from: d */
        public final /* synthetic */ long f33866d;

        public class a implements a.j {

            /* renamed from: com.wbl.ad.yzz.title.b$c$a$a */
            public class C0781a implements a.j {

                /* renamed from: com.wbl.ad.yzz.title.b$c$a$a$a */
                public class C0782a implements a.j {
                    public C0782a() {
                    }

                    @Override // com.wbl.ad.yzz.util.a.j
                    public void a() {
                        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9747, this, null);
                    }
                }

                public C0781a() {
                }

                @Override // com.wbl.ad.yzz.util.a.j
                public void a() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9838, this, null);
                }
            }

            public a() {
            }

            @Override // com.wbl.ad.yzz.util.a.j
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9837, this, null);
            }
        }

        public c(long j2, long j3, long j4, long j5) {
            this.f33863a = j2;
            this.f33864b = j3;
            this.f33865c = j4;
            this.f33866d = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9840, this, null);
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ float f33871a;

        /* renamed from: b */
        public final /* synthetic */ float f33872b;

        /* renamed from: c */
        public final /* synthetic */ long f33873c;

        /* renamed from: d */
        public final /* synthetic */ a.j f33874d;

        public d(float f2, float f3, long j2, a.j jVar) {
            this.f33871a = f2;
            this.f33872b = f3;
            this.f33873c = j2;
            this.f33874d = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9839, this, null);
        }
    }

    public class e implements a.j {

        /* renamed from: a */
        public final /* synthetic */ a.j f33876a;

        public e(b bVar, a.j jVar) {
            this.f33876a = jVar;
        }

        @Override // com.wbl.ad.yzz.util.a.j
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9834, this, null);
        }
    }

    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ int f33877a;

        /* renamed from: b */
        public final /* synthetic */ int f33878b;

        /* renamed from: c */
        public final /* synthetic */ boolean f33879c;

        public class a implements a.j {
            public a(f fVar) {
            }

            @Override // com.wbl.ad.yzz.util.a.j
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9833, this, null);
            }
        }

        /* renamed from: com.wbl.ad.yzz.title.b$f$b */
        public class C0783b implements a.j {

            /* renamed from: a */
            public final /* synthetic */ int f33881a;

            /* renamed from: b */
            public final /* synthetic */ int f33882b;

            /* renamed from: c */
            public final /* synthetic */ float f33883c;

            /* renamed from: com.wbl.ad.yzz.title.b$f$b$a */
            public class a implements Runnable {

                /* renamed from: com.wbl.ad.yzz.title.b$f$b$a$a */
                public class C0784a implements a.j {

                    /* renamed from: com.wbl.ad.yzz.title.b$f$b$a$a$a */
                    public class C0785a implements a.j {
                        public C0785a(C0784a c0784a) {
                        }

                        @Override // com.wbl.ad.yzz.util.a.j
                        public void a() {
                            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9836, this, null);
                        }
                    }

                    public C0784a() {
                    }

                    @Override // com.wbl.ad.yzz.util.a.j
                    public void a() {
                        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9835, this, null);
                    }
                }

                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9830, this, null);
                }
            }

            public C0783b(int i2, int i3, float f2) {
                this.f33881a = i2;
                this.f33882b = i3;
                this.f33883c = f2;
            }

            @Override // com.wbl.ad.yzz.util.a.j
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9829, this, null);
            }
        }

        public f(int i2, int i3, boolean z) {
            this.f33877a = i2;
            this.f33878b = i3;
            this.f33879c = z;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9832, this, null);
        }
    }

    public b(Context context, View view, int i2, int i3, j jVar) {
        this.f33849a = (Activity) context;
        this.s = view.findViewById(R.id.title_container);
        this.f33851c = view.findViewById(R.id.cl_lin_type_2_container);
        this.f33857i = (RelativeLayout) view.findViewById(R.id.ry_lingqu_body_progress);
        this.k = (ImageView) view.findViewById(R.id.img_progess_inner);
        RCRelativeLayout rCRelativeLayout = (RCRelativeLayout) view.findViewById(R.id.ry_progress_out);
        this.f33858j = rCRelativeLayout;
        rCRelativeLayout.setRadius(50);
        this.m = (RelativeLayout) view.findViewById(R.id.rl_start);
        AutoVerticalScrollTextView autoVerticalScrollTextView = new AutoVerticalScrollTextView(context);
        this.l = autoVerticalScrollTextView;
        autoVerticalScrollTextView.a(jVar != null ? jVar.j() : null);
        this.l.a(20.0f, 0, 0, 0);
        this.m.removeAllViews();
        this.m.addView(this.l);
        this.o = (TextView) view.findViewById(R.id.tv_start_d);
        this.p = (TextView) view.findViewById(R.id.tv_end_d);
        this.n = (TextView) view.findViewById(R.id.tv_end);
        this.q = (ImageView) view.findViewById(R.id.img_start);
        this.r = (ImageView) view.findViewById(R.id.img_end);
        this.f33856h = (RelativeLayout) view.findViewById(R.id.rela_leave_ad);
        this.f33855g = (TextView) view.findViewById(R.id.tv_leave);
        this.f33850b = view.findViewById(R.id.cl_lin_type_1_container);
        this.f33852d = (LinearLayout) view.findViewById(R.id.lin_type_1);
        this.f33853e = (TextView) view.findViewById(R.id.tv_type1_msg);
        this.f33854f = (TextView) view.findViewById(R.id.tv_type1_number);
        this.t = (ImageView) view.findViewById(R.id.iv_icon_content);
        this.u = (ImageView) view.findViewById(R.id.iv_back);
        this.v = (ImageView) view.findViewById(R.id.iv_back_bottom);
        RCRelativeLayout rCRelativeLayout2 = (RCRelativeLayout) view.findViewById(R.id.rc_cut_down);
        this.y = rCRelativeLayout2;
        rCRelativeLayout2.setRadius(h.a(context, 50.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.width = h.a(context, 30.0f);
        layoutParams.height = h.a(context, 30.0f);
        this.z = view.findViewById(R.id.view_line);
        this.A = view.findViewById(R.id.ly_right);
        this.F = jVar;
        a(i2, i3, false);
    }

    public static /* synthetic */ Activity b(b bVar) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9828, null, bVar);
    }

    public static /* synthetic */ View c(b bVar) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9854, null, bVar);
    }

    public static /* synthetic */ Handler d(b bVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9853, null, bVar);
    }

    public static /* synthetic */ RCRelativeLayout e(b bVar) {
        return (RCRelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9856, null, bVar);
    }

    public static /* synthetic */ ImageView f(b bVar) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9855, null, bVar);
    }

    public final Handler a() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9850, this, null);
    }

    public final void a(float f2, float f3, long j2, a.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9849, this, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2), jVar);
    }

    public final void a(float f2, long j2, long j3, a.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9852, this, Float.valueOf(f2), Long.valueOf(j2), Long.valueOf(j3), jVar);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9851, this, Integer.valueOf(i2));
    }

    public void a(int i2, int i3, String str, String str2, String str3, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9846, this, Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z));
    }

    public final void a(int i2, int i3, String str, String str2, String str3, boolean z, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9845, this, Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void a(int i2, int i3, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9848, this, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
    }

    public void a(int i2, u uVar, Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9847, this, Integer.valueOf(i2), uVar, context);
    }

    public void a(int i2, u uVar, Context context, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9842, this, Integer.valueOf(i2), uVar, context, Boolean.valueOf(z));
    }

    public void a(int i2, String str, String str2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9841, this, Integer.valueOf(i2), str, str2, Boolean.valueOf(z));
    }

    public final void a(int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9844, this, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public final void a(long j2, long j3, a.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9843, this, Long.valueOf(j2), Long.valueOf(j3), jVar);
    }

    public void a(View.OnClickListener onClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9806, this, onClickListener);
    }

    public void a(View view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9805, this, view);
    }

    public final void a(TextView textView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9808, this, textView, str);
    }

    public void a(AdPageNeedData adPageNeedData, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9807, this, adPageNeedData, Boolean.valueOf(z));
    }

    public final void a(j0 j0Var, int i2, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9802, this, j0Var, Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public final void a(u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9801, this, uVar);
    }

    public void a(u uVar, boolean z, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9804, this, uVar, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9803, this, str);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9798, this, Boolean.valueOf(z));
    }

    public void a(boolean z, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9797, this, Boolean.valueOf(z), Long.valueOf(j2));
    }

    public final void a(boolean z, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9800, this, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public int b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9799, this, null);
    }

    public final void b(float f2, float f3, long j2, a.j jVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9794, this, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2), jVar);
    }

    public void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9793, this, Integer.valueOf(i2));
    }

    public void b(View.OnClickListener onClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9796, this, onClickListener);
    }

    public final void b(TextView textView, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9795, this, textView, str);
    }

    public void b(AdPageNeedData adPageNeedData, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9822, this, adPageNeedData, Boolean.valueOf(z));
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9821, this, str);
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9824, this, Integer.valueOf(i2));
    }

    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9823, this, str);
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9818, this, null);
    }

    public void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9817, this, null);
    }

    public boolean e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9820, this, null);
    }

    public final boolean f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9819, this, null);
    }

    public final boolean g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9814, this, null);
    }

    public void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9813, this, null);
    }

    public void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9816, this, null);
    }

    public void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9815, this, null);
    }
}
