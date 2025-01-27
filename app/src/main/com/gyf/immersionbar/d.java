package com.gyf.immersionbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.c;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.HashMap;
import java.util.Map;
import w6.j;
import w6.l;
import w6.p;
import w6.q;
import w6.r;
import w6.s;

@TargetApi(19)
/* loaded from: classes2.dex */
public final class d implements j {
    public int A;

    /* renamed from: b */
    public final Activity f10663b;

    /* renamed from: c */
    public Fragment f10664c;

    /* renamed from: d */
    public android.app.Fragment f10665d;

    /* renamed from: e */
    public Dialog f10666e;

    /* renamed from: f */
    public Window f10667f;

    /* renamed from: g */
    public ViewGroup f10668g;

    /* renamed from: h */
    public ViewGroup f10669h;

    /* renamed from: i */
    public d f10670i;

    /* renamed from: j */
    public boolean f10671j;

    /* renamed from: k */
    public boolean f10672k;

    /* renamed from: l */
    public boolean f10673l;

    /* renamed from: m */
    public w6.a f10674m;

    /* renamed from: n */
    public com.gyf.immersionbar.a f10675n;

    /* renamed from: o */
    public int f10676o;

    /* renamed from: p */
    public int f10677p;

    /* renamed from: q */
    public int f10678q;

    /* renamed from: r */
    public w6.e f10679r;

    /* renamed from: s */
    public final Map<String, w6.a> f10680s;

    /* renamed from: t */
    public int f10681t;

    /* renamed from: u */
    public boolean f10682u;

    /* renamed from: v */
    public boolean f10683v;

    /* renamed from: w */
    public boolean f10684w;

    /* renamed from: x */
    public int f10685x;

    /* renamed from: y */
    public int f10686y;

    /* renamed from: z */
    public int f10687z;

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ ViewGroup.LayoutParams f10688b;

        /* renamed from: c */
        public final /* synthetic */ View f10689c;

        /* renamed from: d */
        public final /* synthetic */ int f10690d;

        /* renamed from: e */
        public final /* synthetic */ Integer f10691e;

        public a(ViewGroup.LayoutParams layoutParams, View view, int i10, Integer num) {
            this.f10688b = layoutParams;
            this.f10689c = view;
            this.f10690d = i10;
            this.f10691e = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10688b.height = (this.f10689c.getHeight() + this.f10690d) - this.f10691e.intValue();
            View view = this.f10689c;
            view.setPadding(view.getPaddingLeft(), (this.f10689c.getPaddingTop() + this.f10690d) - this.f10691e.intValue(), this.f10689c.getPaddingRight(), this.f10689c.getPaddingBottom());
            this.f10689c.setLayoutParams(this.f10688b);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10692a;

        static {
            int[] iArr = new int[BarHide.values().length];
            f10692a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10692a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10692a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10692a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(Activity activity) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10663b = activity;
        d1(activity.getWindow());
    }

    public static void A0(@NonNull android.app.Fragment fragment, l lVar) {
        if (fragment.getActivity() == null) {
            return;
        }
        z0(fragment.getActivity(), lVar);
    }

    public static void A2(Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        w2(fragment.getActivity(), i10, viewArr);
    }

    public static d A3(@NonNull Fragment fragment) {
        return G0().h(fragment, false);
    }

    public static void B0(@NonNull Fragment fragment, l lVar) {
        if (fragment.getActivity() == null) {
            return;
        }
        z0(fragment.getActivity(), lVar);
    }

    public static void B2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        x2(fragment.getActivity(), viewArr);
    }

    public static d B3(@NonNull Fragment fragment, boolean z10) {
        return G0().h(fragment, z10);
    }

    public static void E2(@NonNull Window window) {
        window.clearFlags(1024);
    }

    public static boolean G(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (((childAt instanceof DrawerLayout) && G(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static s G0() {
        return s.k();
    }

    @TargetApi(14)
    public static int H0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).k();
    }

    public static void I(@NonNull Activity activity, @NonNull Dialog dialog) {
        G0().b(activity, dialog, false);
    }

    @TargetApi(14)
    public static int I0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return H0(fragment.getActivity());
    }

    public static void J(@NonNull Activity activity, @NonNull Dialog dialog, boolean z10) {
        G0().b(activity, dialog, z10);
    }

    @TargetApi(14)
    public static int J0(@NonNull Context context) {
        return com.gyf.immersionbar.a.c(context, com.gyf.immersionbar.b.f10638c);
    }

    public static void K(@NonNull android.app.Fragment fragment) {
        G0().c(fragment, false);
    }

    @TargetApi(14)
    public static int K0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return H0(fragment.getActivity());
    }

    public static void L(@NonNull android.app.Fragment fragment, boolean z10) {
        G0().c(fragment, z10);
    }

    public static void M(@NonNull Fragment fragment) {
        G0().d(fragment, false);
    }

    public static void N(@NonNull Fragment fragment, boolean z10) {
        G0().d(fragment, z10);
    }

    @TargetApi(14)
    public static boolean O0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).m();
    }

    @TargetApi(14)
    public static boolean P0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return O0(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean Q0(@NonNull Context context) {
        return q0(context) > 0;
    }

    @TargetApi(14)
    public static boolean R0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return O0(fragment.getActivity());
    }

    public static boolean S0(@NonNull Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean T0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return S0(fragment.getActivity());
    }

    public static boolean U0(@NonNull View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void U1(Activity activity) {
        V1(activity, true);
    }

    public static boolean V0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return S0(fragment.getActivity());
    }

    public static void V1(Activity activity, boolean z10) {
        if (activity == null) {
            return;
        }
        Y1(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0), z10);
    }

    public static void W1(android.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        U1(fragment.getActivity());
    }

    public static void X1(android.app.Fragment fragment, boolean z10) {
        if (fragment == null) {
            return;
        }
        V1(fragment.getActivity(), z10);
    }

    public static void Y1(View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view.setFitsSystemWindows(z10);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup instanceof DrawerLayout) {
            Y1(viewGroup.getChildAt(0), z10);
        } else {
            viewGroup.setFitsSystemWindows(z10);
            viewGroup.setClipToPadding(true);
        }
    }

    public static void Z0(@NonNull Window window) {
        window.setFlags(1024, 1024);
    }

    public static void Z1(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        U1(fragment.getActivity());
    }

    public static void a2(Fragment fragment, boolean z10) {
        if (fragment == null) {
            return;
        }
        V1(fragment.getActivity(), z10);
    }

    public static boolean g1(String str) {
        return str == null || str.trim().length() == 0;
    }

    @TargetApi(14)
    public static int i0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).a();
    }

    public static boolean i1(android.app.Fragment fragment) {
        Context context = Build.VERSION.SDK_INT >= 23 ? fragment.getContext() : null;
        if (context == null) {
            return false;
        }
        return j1(context);
    }

    @TargetApi(14)
    public static int j0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return i0(fragment.getActivity());
    }

    public static boolean j1(Context context) {
        return c.a(context).f10660a;
    }

    @TargetApi(14)
    public static int k0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return i0(fragment.getActivity());
    }

    public static boolean k1(Fragment fragment) {
        Context context = fragment.getContext();
        if (context == null) {
            return false;
        }
        return j1(context);
    }

    public static void k2(Activity activity, int i10, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i10) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i10));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i10;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @TargetApi(14)
    public static boolean l1(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).n();
    }

    public static void l2(Activity activity, View... viewArr) {
        k2(activity, H0(activity), viewArr);
    }

    @TargetApi(14)
    public static boolean m1(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return l1(fragment.getActivity());
    }

    public static void m2(android.app.Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        k2(fragment.getActivity(), i10, viewArr);
    }

    @TargetApi(14)
    public static boolean n1(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return l1(fragment.getActivity());
    }

    public static void n2(android.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        l2(fragment.getActivity(), viewArr);
    }

    @TargetApi(14)
    public static int o0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).d();
    }

    public static boolean o1() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static void o2(Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        k2(fragment.getActivity(), i10, viewArr);
    }

    @TargetApi(14)
    public static int p0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return o0(fragment.getActivity());
    }

    public static boolean p1() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    public static void p2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        l2(fragment.getActivity(), viewArr);
    }

    @TargetApi(14)
    public static int q0(@NonNull Context context) {
        c.a a10 = c.a(context);
        if (!a10.f10660a || a10.f10661b) {
            return com.gyf.immersionbar.a.f(context);
        }
        return 0;
    }

    public static void q2(Activity activity, int i10, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i10) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i10));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i11 = layoutParams.height;
                    if (i11 == -2 || i11 == -1) {
                        view.post(new a(layoutParams, view, i10, num));
                    } else {
                        layoutParams.height = i11 + (i10 - num.intValue());
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i10) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static d q3(@NonNull Activity activity) {
        return G0().f(activity, false);
    }

    @TargetApi(14)
    public static int r0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return o0(fragment.getActivity());
    }

    public static void r2(Activity activity, View... viewArr) {
        q2(activity, H0(activity), viewArr);
    }

    public static d r3(@NonNull Activity activity, @NonNull Dialog dialog) {
        return G0().e(activity, dialog, false);
    }

    @TargetApi(14)
    public static int s0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).g();
    }

    public static void s2(android.app.Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        q2(fragment.getActivity(), i10, viewArr);
    }

    public static d s3(@NonNull Activity activity, @NonNull Dialog dialog, boolean z10) {
        return G0().e(activity, dialog, z10);
    }

    @TargetApi(14)
    public static int t0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return s0(fragment.getActivity());
    }

    public static void t2(android.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        r2(fragment.getActivity(), viewArr);
    }

    public static d t3(@NonNull Activity activity, boolean z10) {
        return G0().f(activity, z10);
    }

    @TargetApi(14)
    public static int u0(@NonNull Context context) {
        c.a a10 = c.a(context);
        if (!a10.f10660a || a10.f10661b) {
            return com.gyf.immersionbar.a.i(context);
        }
        return 0;
    }

    public static void u2(Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        q2(fragment.getActivity(), i10, viewArr);
    }

    public static d u3(@NonNull DialogFragment dialogFragment) {
        return G0().g(dialogFragment, false);
    }

    @TargetApi(14)
    public static int v0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return s0(fragment.getActivity());
    }

    public static void v2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        r2(fragment.getActivity(), viewArr);
    }

    public static d v3(@NonNull DialogFragment dialogFragment, boolean z10) {
        return G0().g(dialogFragment, z10);
    }

    public static int w0(@NonNull Activity activity) {
        return NotchUtils.getNotchHeight(activity);
    }

    public static void w2(Activity activity, int i10, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i10) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i10));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i10) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public static d w3(@NonNull android.app.Fragment fragment) {
        return G0().g(fragment, false);
    }

    public static int x0(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return w0(fragment.getActivity());
    }

    public static void x2(Activity activity, View... viewArr) {
        w2(activity, H0(activity), viewArr);
    }

    public static d x3(@NonNull android.app.Fragment fragment, boolean z10) {
        return G0().g(fragment, z10);
    }

    public static int y0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return w0(fragment.getActivity());
    }

    public static void y2(android.app.Fragment fragment, int i10, View... viewArr) {
        if (fragment == null) {
            return;
        }
        w2(fragment.getActivity(), i10, viewArr);
    }

    public static d y3(@NonNull androidx.fragment.app.DialogFragment dialogFragment) {
        return G0().h(dialogFragment, false);
    }

    public static void z0(@NonNull Activity activity, l lVar) {
        NotchUtils.getNotchHeight(activity, lVar);
    }

    public static void z2(android.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        x2(fragment.getActivity(), viewArr);
    }

    public static d z3(@NonNull androidx.fragment.app.DialogFragment dialogFragment, boolean z10) {
        return G0().h(dialogFragment, z10);
    }

    public d A(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31601b = i10;
        aVar.f31602c = i10;
        aVar.f31618s = i11;
        aVar.f31619t = i11;
        aVar.f31604e = f10;
        aVar.f31606g = f10;
        return this;
    }

    public d A1(@ColorInt int i10) {
        this.f10674m.f31602c = i10;
        return this;
    }

    public d B(@ColorRes int i10) {
        return D(ContextCompat.getColor(this.f10663b, i10));
    }

    public d B1(@ColorInt int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31602c = i10;
        aVar.f31606g = f10;
        return this;
    }

    public d C(String str) {
        return D(Color.parseColor(str));
    }

    public int C0() {
        return this.A;
    }

    public d C1(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31602c = i10;
        aVar.f31619t = i11;
        aVar.f31606g = f10;
        return this;
    }

    public final void C2() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f10668g;
        int i10 = com.gyf.immersionbar.b.f10637b;
        View findViewById = viewGroup.findViewById(i10);
        if (findViewById == null) {
            findViewById = new View(this.f10663b);
            findViewById.setId(i10);
            this.f10668g.addView(findViewById);
        }
        if (this.f10675n.n()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f10675n.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f10675n.g(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        w6.a aVar = this.f10674m;
        findViewById.setBackgroundColor(ColorUtils.blendARGB(aVar.f31602c, aVar.f31619t, aVar.f31606g));
        w6.a aVar2 = this.f10674m;
        if (aVar2.I && aVar2.J && !aVar2.f31609j) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public d D(@ColorInt int i10) {
        w6.a aVar = this.f10674m;
        aVar.f31618s = i10;
        aVar.f31619t = i10;
        return this;
    }

    public int D0() {
        return this.f10685x;
    }

    public d D1(@ColorRes int i10) {
        return F1(ContextCompat.getColor(this.f10663b, i10));
    }

    public final void D2() {
        ViewGroup viewGroup = this.f10668g;
        int i10 = com.gyf.immersionbar.b.f10636a;
        View findViewById = viewGroup.findViewById(i10);
        if (findViewById == null) {
            findViewById = new View(this.f10663b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f10675n.k());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i10);
            this.f10668g.addView(findViewById);
        }
        w6.a aVar = this.f10674m;
        if (aVar.f31617r) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(aVar.f31601b, aVar.f31618s, aVar.f31604e));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(aVar.f31601b, 0, aVar.f31604e));
        }
    }

    public d E(boolean z10) {
        this.f10674m.L = z10;
        return this;
    }

    public int E0() {
        return this.f10687z;
    }

    public d E1(String str) {
        return F1(Color.parseColor(str));
    }

    public final void F() {
        if (this.f10663b != null) {
            w6.e eVar = this.f10679r;
            if (eVar != null) {
                eVar.a();
                this.f10679r = null;
            }
            w6.d.b().d(this);
            e.b().d(this.f10674m.N);
        }
    }

    public int F0() {
        return this.f10686y;
    }

    public d F1(@ColorInt int i10) {
        this.f10674m.f31619t = i10;
        return this;
    }

    public d F2(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31604e = f10;
        aVar.f31605f = f10;
        return this;
    }

    public d G1(boolean z10) {
        return H1(z10, 0.2f);
    }

    public d G2(@ColorRes int i10) {
        return M2(ContextCompat.getColor(this.f10663b, i10));
    }

    public final void H() {
        if (this.f10670i == null) {
            this.f10670i = q3(this.f10663b);
        }
        d dVar = this.f10670i;
        if (dVar == null || dVar.f10682u) {
            return;
        }
        dVar.a1();
    }

    public d H1(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f10674m.f31612m = z10;
        if (!z10 || o1()) {
            w6.a aVar = this.f10674m;
            aVar.f31606g = aVar.f31607h;
        } else {
            this.f10674m.f31606g = f10;
        }
        return this;
    }

    public d H2(@ColorRes int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return N2(ContextCompat.getColor(this.f10663b, i10), f10);
    }

    public d I1(boolean z10) {
        this.f10674m.I = z10;
        return this;
    }

    public d I2(@ColorRes int i10, @ColorRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return O2(ContextCompat.getColor(this.f10663b, i10), ContextCompat.getColor(this.f10663b, i11), f10);
    }

    public d J1(boolean z10) {
        if (OSUtils.isEMUI3_x()) {
            w6.a aVar = this.f10674m;
            aVar.K = z10;
            aVar.J = z10;
        }
        return this;
    }

    public d J2(String str) {
        return M2(Color.parseColor(str));
    }

    public d K1(boolean z10) {
        this.f10674m.J = z10;
        return this;
    }

    public d K2(String str, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return N2(Color.parseColor(str), f10);
    }

    public Fragment L0() {
        return this.f10664c;
    }

    public void L1(Configuration configuration) {
        n3();
        if (!OSUtils.isEMUI3_x()) {
            Y();
        } else if (this.f10682u && !this.f10671j && this.f10674m.J) {
            a1();
        } else {
            Y();
        }
    }

    public d L2(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return O2(Color.parseColor(str), Color.parseColor(str2), f10);
    }

    public d M0(String str) {
        if (g1(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        w6.a aVar = this.f10680s.get(str);
        if (aVar != null) {
            this.f10674m = aVar.clone();
        }
        return this;
    }

    public void M1() {
        d dVar;
        F();
        if (this.f10673l && (dVar = this.f10670i) != null) {
            w6.a aVar = dVar.f10674m;
            aVar.G = dVar.f10684w;
            if (aVar.f31610k != BarHide.FLAG_SHOW_BAR) {
                dVar.S1();
            }
        }
        this.f10682u = false;
    }

    public d M2(@ColorInt int i10) {
        this.f10674m.f31601b = i10;
        return this;
    }

    public Window N0() {
        return this.f10667f;
    }

    public void N1() {
        n3();
        if (this.f10671j || !this.f10682u || this.f10674m == null) {
            return;
        }
        if (OSUtils.isEMUI3_x() && this.f10674m.K) {
            a1();
        } else if (this.f10674m.f31610k != BarHide.FLAG_SHOW_BAR) {
            S1();
        }
    }

    public d N2(@ColorInt int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31601b = i10;
        aVar.f31604e = f10;
        return this;
    }

    public final void O() {
        if (!this.f10671j) {
            if (this.f10674m.G) {
                if (this.f10679r == null) {
                    this.f10679r = new w6.e(this);
                }
                this.f10679r.c(this.f10674m.H);
                return;
            } else {
                w6.e eVar = this.f10679r;
                if (eVar != null) {
                    eVar.b();
                    return;
                }
                return;
            }
        }
        d dVar = this.f10670i;
        if (dVar != null) {
            if (dVar.f10674m.G) {
                if (dVar.f10679r == null) {
                    dVar.f10679r = new w6.e(dVar);
                }
                d dVar2 = this.f10670i;
                dVar2.f10679r.c(dVar2.f10674m.H);
                return;
            }
            w6.e eVar2 = dVar.f10679r;
            if (eVar2 != null) {
                eVar2.b();
            }
        }
    }

    public final void O1() {
        c0();
        if (this.f10671j || !OSUtils.isEMUI3_x()) {
            return;
        }
        b0();
    }

    public d O2(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31601b = i10;
        aVar.f31618s = i11;
        aVar.f31604e = f10;
        return this;
    }

    public final void P() {
        int k10 = this.f10674m.C ? this.f10675n.k() : 0;
        int i10 = this.f10681t;
        if (i10 == 1) {
            q2(this.f10663b, k10, this.f10674m.A);
        } else if (i10 == 2) {
            w2(this.f10663b, k10, this.f10674m.A);
        } else {
            if (i10 != 3) {
                return;
            }
            k2(this.f10663b, k10, this.f10674m.B);
        }
    }

    public d P1() {
        if (this.f10674m.f31620u.size() != 0) {
            this.f10674m.f31620u.clear();
        }
        return this;
    }

    public d P2(@ColorRes int i10) {
        return S2(ContextCompat.getColor(this.f10663b, i10));
    }

    public d Q(boolean z10) {
        this.f10674m.C = z10;
        return this;
    }

    public d Q1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map<Integer, Integer> map = this.f10674m.f31620u.get(view);
        if (map != null && map.size() != 0) {
            this.f10674m.f31620u.remove(view);
        }
        return this;
    }

    public d Q2(String str) {
        return S2(Color.parseColor(str));
    }

    public final void R() {
        if (Build.VERSION.SDK_INT < 28 || this.f10682u) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.f10667f.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.f10667f.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    public d R1() {
        this.f10674m = new w6.a();
        this.f10681t = 0;
        return this;
    }

    public d R2(boolean z10) {
        this.f10674m.f31617r = z10;
        return this;
    }

    public void S() {
        w6.e eVar;
        d dVar = this.f10670i;
        if (dVar == null || (eVar = dVar.f10679r) == null) {
            return;
        }
        eVar.b();
        this.f10670i.f10679r.d();
    }

    public void S1() {
        int i10 = 256;
        if (OSUtils.isEMUI3_x()) {
            c1();
        } else {
            R();
            i10 = b2(i2(b1(256)));
            T1();
        }
        this.f10668g.setSystemUiVisibility(Y0(i10));
        h2();
        X0();
        if (this.f10674m.N != null) {
            e.b().c(this.f10663b.getApplication());
        }
    }

    public d S2(@ColorInt int i10) {
        this.f10674m.f31618s = i10;
        return this;
    }

    public d T(boolean z10) {
        this.f10674m.f31625z = z10;
        if (!z10) {
            this.f10681t = 0;
        } else if (this.f10681t == 0) {
            this.f10681t = 4;
        }
        return this;
    }

    public final void T1() {
        if (Build.VERSION.SDK_INT >= 30) {
            j2();
            c2();
        }
    }

    public d T2(boolean z10) {
        return U2(z10, 0.2f);
    }

    public d U(boolean z10, @ColorRes int i10) {
        return W(z10, ContextCompat.getColor(this.f10663b, i10));
    }

    public d U2(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f10674m.f31611l = z10;
        if (!z10 || p1()) {
            w6.a aVar = this.f10674m;
            aVar.D = aVar.E;
            aVar.f31604e = aVar.f31605f;
        } else {
            this.f10674m.f31604e = f10;
        }
        return this;
    }

    public d V(boolean z10, @ColorRes int i10, @ColorRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return X(z10, ContextCompat.getColor(this.f10663b, i10), ContextCompat.getColor(this.f10663b, i11), f10);
    }

    public d V2(@IdRes int i10) {
        return X2(this.f10663b.findViewById(i10));
    }

    public d W(boolean z10, @ColorInt int i10) {
        return X(z10, i10, -16777216, 0.0f);
    }

    public d W0(BarHide barHide) {
        this.f10674m.f31610k = barHide;
        if (OSUtils.isEMUI3_x()) {
            w6.a aVar = this.f10674m;
            BarHide barHide2 = aVar.f31610k;
            aVar.f31609j = barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public d W2(@IdRes int i10, View view) {
        return X2(view.findViewById(i10));
    }

    public d X(boolean z10, @ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31625z = z10;
        aVar.f31622w = i10;
        aVar.f31623x = i11;
        aVar.f31624y = f10;
        if (!z10) {
            this.f10681t = 0;
        } else if (this.f10681t == 0) {
            this.f10681t = 4;
        }
        this.f10669h.setBackgroundColor(ColorUtils.blendARGB(i10, i11, f10));
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r4.f10669h.getWindowInsetsController();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X0() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L57
            android.view.ViewGroup r0 = r4.f10669h
            android.view.WindowInsetsController r0 = w6.i.a(r0)
            if (r0 == 0) goto L57
            int[] r1 = com.gyf.immersionbar.d.b.f10692a
            w6.a r2 = r4.f10674m
            com.gyf.immersionbar.BarHide r2 = r2.f31610k
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 2
            if (r1 == r2) goto L46
            if (r1 == r3) goto L3e
            r2 = 3
            if (r1 == r2) goto L36
            r2 = 4
            if (r1 == r2) goto L27
            goto L54
        L27:
            int r1 = b0.u1.a()
            b0.j2.a(r0, r1)
            int r1 = b0.v1.a()
            b0.j2.a(r0, r1)
            goto L54
        L36:
            int r1 = b0.v1.a()
            b0.d2.a(r0, r1)
            goto L54
        L3e:
            int r1 = b0.u1.a()
            b0.d2.a(r0, r1)
            goto L54
        L46:
            int r1 = b0.u1.a()
            b0.d2.a(r0, r1)
            int r1 = b0.v1.a()
            b0.d2.a(r0, r1)
        L54:
            b0.g2.a(r0, r3)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.d.X0():void");
    }

    public d X2(View view) {
        if (view == null) {
            return this;
        }
        this.f10674m.B = view;
        if (this.f10681t == 0) {
            this.f10681t = 3;
        }
        return this;
    }

    public final void Y() {
        if (OSUtils.isEMUI3_x()) {
            a0();
        } else {
            Z();
        }
        P();
    }

    public final int Y0(int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            return i10;
        }
        int i11 = b.f10692a[this.f10674m.f31610k.ordinal()];
        if (i11 == 1) {
            i10 |= 518;
        } else if (i11 == 2) {
            i10 |= DownloadErrorCode.ERROR_SAVE_PATH_EMPTY;
        } else if (i11 == 3) {
            i10 |= 514;
        }
        return i10 | 4096;
    }

    public d Y2(boolean z10) {
        this.f10674m.F = z10;
        return this;
    }

    public final void Z() {
        if (G(this.f10668g.findViewById(android.R.id.content))) {
            g2(0, 0, 0, 0);
            return;
        }
        int k10 = (this.f10674m.f31625z && this.f10681t == 4) ? this.f10675n.k() : 0;
        if (this.f10674m.F) {
            k10 = this.f10675n.k() + this.f10678q;
        }
        g2(0, k10, 0, 0);
    }

    public d Z2(@IdRes int i10) {
        return c3(i10, true);
    }

    @Override // w6.r
    public void a(boolean z10, NavigationBarType navigationBarType) {
        View findViewById = this.f10668g.findViewById(com.gyf.immersionbar.b.f10637b);
        if (findViewById != null) {
            this.f10675n = new com.gyf.immersionbar.a(this.f10663b);
            int paddingBottom = this.f10669h.getPaddingBottom();
            int paddingRight = this.f10669h.getPaddingRight();
            if (z10) {
                findViewById.setVisibility(0);
                if (!G(this.f10668g.findViewById(android.R.id.content))) {
                    if (this.f10676o == 0) {
                        this.f10676o = this.f10675n.d();
                    }
                    if (this.f10677p == 0) {
                        this.f10677p = this.f10675n.g();
                    }
                    if (!this.f10674m.f31609j) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.f10675n.n()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.f10676o;
                            layoutParams.height = paddingBottom;
                            if (this.f10674m.f31608i) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i10 = this.f10677p;
                            layoutParams.width = i10;
                            if (this.f10674m.f31608i) {
                                i10 = 0;
                            }
                            paddingRight = i10;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    g2(0, this.f10669h.getPaddingTop(), paddingRight, paddingBottom);
                }
            } else {
                findViewById.setVisibility(8);
            }
            paddingBottom = 0;
            paddingRight = 0;
            g2(0, this.f10669h.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public final void a0() {
        if (this.f10674m.F) {
            this.f10683v = true;
            this.f10669h.post(this);
        } else {
            this.f10683v = false;
            O1();
        }
    }

    public void a1() {
        if (this.f10674m.L) {
            o3();
            S1();
            Y();
            O();
            i3();
            this.f10682u = true;
        }
    }

    public d a3(@IdRes int i10, View view) {
        return e3(view.findViewById(i10), true);
    }

    public d b(String str) {
        if (g1(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.f10680s.put(str, this.f10674m.clone());
        return this;
    }

    public final void b0() {
        View findViewById = this.f10668g.findViewById(com.gyf.immersionbar.b.f10637b);
        w6.a aVar = this.f10674m;
        if (!aVar.I || !aVar.J) {
            w6.d.b().d(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            w6.d.b().a(this);
            w6.d.b().c(this.f10663b.getApplication());
        }
    }

    @RequiresApi(api = 21)
    public final int b1(int i10) {
        if (!this.f10682u) {
            this.f10674m.f31603d = this.f10667f.getNavigationBarColor();
        }
        int i11 = i10 | 1024;
        w6.a aVar = this.f10674m;
        if (aVar.f31608i && aVar.I) {
            i11 = i10 | 1536;
        }
        this.f10667f.clearFlags(67108864);
        if (this.f10675n.m()) {
            this.f10667f.clearFlags(134217728);
        }
        this.f10667f.addFlags(Integer.MIN_VALUE);
        w6.a aVar2 = this.f10674m;
        if (aVar2.f31617r) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f10667f.setStatusBarContrastEnforced(false);
            }
            Window window = this.f10667f;
            w6.a aVar3 = this.f10674m;
            window.setStatusBarColor(ColorUtils.blendARGB(aVar3.f31601b, aVar3.f31618s, aVar3.f31604e));
        } else {
            this.f10667f.setStatusBarColor(ColorUtils.blendARGB(aVar2.f31601b, 0, aVar2.f31604e));
        }
        w6.a aVar4 = this.f10674m;
        if (aVar4.I) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f10667f.setNavigationBarContrastEnforced(false);
            }
            Window window2 = this.f10667f;
            w6.a aVar5 = this.f10674m;
            window2.setNavigationBarColor(ColorUtils.blendARGB(aVar5.f31602c, aVar5.f31619t, aVar5.f31606g));
        } else {
            this.f10667f.setNavigationBarColor(aVar4.f31603d);
        }
        return i11;
    }

    public final int b2(int i10) {
        return (Build.VERSION.SDK_INT < 26 || !this.f10674m.f31612m) ? i10 : i10 | 16;
    }

    public d b3(@IdRes int i10, View view, boolean z10) {
        return e3(view.findViewById(i10), z10);
    }

    public d c(View view) {
        return h(view, this.f10674m.f31618s);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c0() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f10668g
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = G(r0)
            r1 = 0
            if (r0 == 0) goto L14
            r5.g2(r1, r1, r1, r1)
            return
        L14:
            w6.a r0 = r5.f10674m
            boolean r0 = r0.f31625z
            if (r0 == 0) goto L26
            int r0 = r5.f10681t
            r2 = 4
            if (r0 != r2) goto L26
            com.gyf.immersionbar.a r0 = r5.f10675n
            int r0 = r0.k()
            goto L27
        L26:
            r0 = 0
        L27:
            w6.a r2 = r5.f10674m
            boolean r2 = r2.F
            if (r2 == 0) goto L36
            com.gyf.immersionbar.a r0 = r5.f10675n
            int r0 = r0.k()
            int r2 = r5.f10678q
            int r0 = r0 + r2
        L36:
            com.gyf.immersionbar.a r2 = r5.f10675n
            boolean r2 = r2.m()
            if (r2 == 0) goto L88
            w6.a r2 = r5.f10674m
            boolean r3 = r2.I
            if (r3 == 0) goto L88
            boolean r3 = r2.J
            if (r3 == 0) goto L88
            boolean r2 = r2.f31608i
            if (r2 != 0) goto L65
            com.gyf.immersionbar.a r2 = r5.f10675n
            boolean r2 = r2.n()
            if (r2 == 0) goto L5d
            com.gyf.immersionbar.a r2 = r5.f10675n
            int r2 = r2.d()
            r3 = r2
            r2 = 0
            goto L67
        L5d:
            com.gyf.immersionbar.a r2 = r5.f10675n
            int r2 = r2.g()
        L63:
            r3 = 0
            goto L67
        L65:
            r2 = 0
            goto L63
        L67:
            w6.a r4 = r5.f10674m
            boolean r4 = r4.f31609j
            if (r4 == 0) goto L79
            com.gyf.immersionbar.a r4 = r5.f10675n
            boolean r4 = r4.n()
            if (r4 == 0) goto L77
        L75:
            r3 = 0
            goto L8a
        L77:
            r2 = 0
            goto L8a
        L79:
            com.gyf.immersionbar.a r4 = r5.f10675n
            boolean r4 = r4.n()
            if (r4 != 0) goto L8a
            com.gyf.immersionbar.a r2 = r5.f10675n
            int r2 = r2.g()
            goto L8a
        L88:
            r2 = 0
            goto L75
        L8a:
            r5.g2(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.d.c0():void");
    }

    public final void c1() {
        this.f10667f.addFlags(67108864);
        D2();
        if (this.f10675n.m() || OSUtils.isEMUI3_x()) {
            w6.a aVar = this.f10674m;
            if (aVar.I && aVar.J) {
                this.f10667f.addFlags(134217728);
            } else {
                this.f10667f.clearFlags(134217728);
            }
            if (this.f10676o == 0) {
                this.f10676o = this.f10675n.d();
            }
            if (this.f10677p == 0) {
                this.f10677p = this.f10675n.g();
            }
            C2();
        }
    }

    @RequiresApi(api = 30)
    public final void c2() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.f10669h.getWindowInsetsController();
        if (this.f10674m.f31612m) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    public d c3(@IdRes int i10, boolean z10) {
        Fragment fragment = this.f10664c;
        if (fragment != null && fragment.getView() != null) {
            return e3(this.f10664c.getView().findViewById(i10), z10);
        }
        android.app.Fragment fragment2 = this.f10665d;
        return (fragment2 == null || fragment2.getView() == null) ? e3(this.f10663b.findViewById(i10), z10) : e3(this.f10665d.getView().findViewById(i10), z10);
    }

    public d d(View view, @ColorRes int i10) {
        return h(view, ContextCompat.getColor(this.f10663b, i10));
    }

    public d d0(@ColorRes int i10) {
        this.f10674m.D = ContextCompat.getColor(this.f10663b, i10);
        w6.a aVar = this.f10674m;
        aVar.E = aVar.D;
        return this;
    }

    public final void d1(Window window) {
        this.f10667f = window;
        this.f10674m = new w6.a();
        ViewGroup viewGroup = (ViewGroup) this.f10667f.getDecorView();
        this.f10668g = viewGroup;
        this.f10669h = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    public d d2(p pVar) {
        if (pVar != null) {
            w6.a aVar = this.f10674m;
            if (aVar.O == null) {
                aVar.O = pVar;
            }
        } else {
            w6.a aVar2 = this.f10674m;
            if (aVar2.O != null) {
                aVar2.O = null;
            }
        }
        return this;
    }

    public d d3(View view) {
        return view == null ? this : e3(view, true);
    }

    public d e(View view, @ColorRes int i10, @ColorRes int i11) {
        return i(view, ContextCompat.getColor(this.f10663b, i10), ContextCompat.getColor(this.f10663b, i11));
    }

    public d e0(String str) {
        this.f10674m.D = Color.parseColor(str);
        w6.a aVar = this.f10674m;
        aVar.E = aVar.D;
        return this;
    }

    public boolean e1() {
        return this.f10682u;
    }

    public d e2(@Nullable q qVar) {
        w6.a aVar = this.f10674m;
        if (aVar.M == null) {
            aVar.M = qVar;
        }
        return this;
    }

    public d e3(View view, boolean z10) {
        if (view == null) {
            return this;
        }
        if (this.f10681t == 0) {
            this.f10681t = 1;
        }
        w6.a aVar = this.f10674m;
        aVar.A = view;
        aVar.f31617r = z10;
        return this;
    }

    public d f(View view, String str) {
        return h(view, Color.parseColor(str));
    }

    public d f0(@ColorInt int i10) {
        w6.a aVar = this.f10674m;
        aVar.D = i10;
        aVar.E = i10;
        return this;
    }

    public boolean f1() {
        return this.f10672k;
    }

    public d f2(r rVar) {
        if (rVar != null) {
            w6.a aVar = this.f10674m;
            if (aVar.N == null) {
                aVar.N = rVar;
                e.b().a(this.f10674m.N);
            }
        } else if (this.f10674m.N != null) {
            e.b().d(this.f10674m.N);
            this.f10674m.N = null;
        }
        return this;
    }

    public d f3(@IdRes int i10) {
        Fragment fragment = this.f10664c;
        if (fragment != null && fragment.getView() != null) {
            return h3(this.f10664c.getView().findViewById(i10));
        }
        android.app.Fragment fragment2 = this.f10665d;
        return (fragment2 == null || fragment2.getView() == null) ? h3(this.f10663b.findViewById(i10)) : h3(this.f10665d.getView().findViewById(i10));
    }

    public d g(View view, String str, String str2) {
        return i(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public d g0(boolean z10) {
        this.f10674m.f31608i = z10;
        return this;
    }

    public final void g2(int i10, int i11, int i12, int i13) {
        ViewGroup viewGroup = this.f10669h;
        if (viewGroup != null) {
            viewGroup.setPadding(i10, i11, i12, i13);
        }
        this.f10685x = i10;
        this.f10686y = i11;
        this.f10687z = i12;
        this.A = i13;
    }

    public d g3(@IdRes int i10, View view) {
        return h3(view.findViewById(i10));
    }

    public Activity getActivity() {
        return this.f10663b;
    }

    public d h(View view, @ColorInt int i10) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.f10674m.f31601b), Integer.valueOf(i10));
        this.f10674m.f31620u.put(view, hashMap);
        return this;
    }

    public int h0() {
        return this.f10678q;
    }

    public boolean h1() {
        return this.f10671j;
    }

    public final void h2() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.f10667f, com.gyf.immersionbar.b.f10652q, this.f10674m.f31611l);
            w6.a aVar = this.f10674m;
            if (aVar.I) {
                SpecialBarFontUtils.setMIUIBarDark(this.f10667f, com.gyf.immersionbar.b.f10653r, aVar.f31612m);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            w6.a aVar2 = this.f10674m;
            int i10 = aVar2.D;
            if (i10 != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f10663b, i10);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f10663b, aVar2.f31611l);
            }
        }
    }

    public d h3(View view) {
        if (view == null) {
            return this;
        }
        if (this.f10681t == 0) {
            this.f10681t = 2;
        }
        this.f10674m.A = view;
        return this;
    }

    public d i(View view, @ColorInt int i10, @ColorInt int i11) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i10), Integer.valueOf(i11));
        this.f10674m.f31620u.put(view, hashMap);
        return this;
    }

    public final int i2(int i10) {
        return (Build.VERSION.SDK_INT < 23 || !this.f10674m.f31611l) ? i10 : i10 | 8192;
    }

    public final void i3() {
        if (this.f10674m.f31620u.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.f10674m.f31620u.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.f10674m.f31601b);
                Integer valueOf2 = Integer.valueOf(this.f10674m.f31618s);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.f10674m.f31621v - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f10674m.f31604e));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f10674m.f31621v));
                    }
                }
            }
        }
    }

    public final void j() {
        w6.a aVar = this.f10674m;
        int blendARGB = ColorUtils.blendARGB(aVar.f31601b, aVar.f31618s, aVar.f31604e);
        w6.a aVar2 = this.f10674m;
        if (aVar2.f31613n && blendARGB != 0) {
            U2(blendARGB > -4539718, aVar2.f31615p);
        }
        w6.a aVar3 = this.f10674m;
        int blendARGB2 = ColorUtils.blendARGB(aVar3.f31602c, aVar3.f31619t, aVar3.f31606g);
        w6.a aVar4 = this.f10674m;
        if (!aVar4.f31614o || blendARGB2 == 0) {
            return;
        }
        H1(blendARGB2 > -4539718, aVar4.f31616q);
    }

    @RequiresApi(api = 30)
    public final void j2() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.f10669h.getWindowInsetsController();
        if (!this.f10674m.f31611l) {
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (this.f10667f != null) {
            m3(8192);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    public d j3() {
        w6.a aVar = this.f10674m;
        aVar.f31601b = 0;
        aVar.f31602c = 0;
        aVar.f31608i = true;
        return this;
    }

    public d k(boolean z10) {
        this.f10674m.C = !z10;
        V1(this.f10663b, z10);
        return this;
    }

    public d k3() {
        w6.a aVar = this.f10674m;
        aVar.f31602c = 0;
        aVar.f31608i = true;
        return this;
    }

    public d l(boolean z10) {
        return m(z10, 0.2f);
    }

    public com.gyf.immersionbar.a l0() {
        if (this.f10675n == null) {
            this.f10675n = new com.gyf.immersionbar.a(this.f10663b);
        }
        return this.f10675n;
    }

    public d l3() {
        this.f10674m.f31601b = 0;
        return this;
    }

    public d m(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31613n = z10;
        aVar.f31615p = f10;
        aVar.f31614o = z10;
        aVar.f31616q = f10;
        return this;
    }

    public w6.a m0() {
        return this.f10674m;
    }

    public void m3(int i10) {
        View decorView = this.f10667f.getDecorView();
        decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
    }

    public d n(boolean z10) {
        return o(z10, 0.2f);
    }

    public android.app.Fragment n0() {
        return this.f10665d;
    }

    public final void n3() {
        com.gyf.immersionbar.a aVar = new com.gyf.immersionbar.a(this.f10663b);
        this.f10675n = aVar;
        if (!this.f10682u || this.f10683v) {
            this.f10678q = aVar.a();
        }
    }

    public d o(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31614o = z10;
        aVar.f31616q = f10;
        return this;
    }

    public final void o3() {
        j();
        if (!this.f10682u || this.f10671j) {
            n3();
        }
        d dVar = this.f10670i;
        if (dVar != null) {
            if (this.f10671j) {
                dVar.f10674m = this.f10674m;
            }
            if (this.f10673l && dVar.f10684w) {
                dVar.f10674m.G = false;
            }
        }
    }

    public d p(boolean z10) {
        return q(z10, 0.2f);
    }

    public d p3(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f10674m.f31621v = f10;
        return this;
    }

    public d q(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31613n = z10;
        aVar.f31615p = f10;
        return this;
    }

    public d q1(boolean z10) {
        return r1(z10, this.f10674m.H);
    }

    public d r(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31604e = f10;
        aVar.f31605f = f10;
        aVar.f31606g = f10;
        aVar.f31607h = f10;
        return this;
    }

    public d r1(boolean z10, int i10) {
        w6.a aVar = this.f10674m;
        aVar.G = z10;
        aVar.H = i10;
        this.f10684w = z10;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        O1();
    }

    public d s(@ColorRes int i10) {
        return y(ContextCompat.getColor(this.f10663b, i10));
    }

    public d s1(int i10) {
        this.f10674m.H = i10;
        return this;
    }

    public d t(@ColorRes int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return z(ContextCompat.getColor(this.f10663b, i10), i10);
    }

    public d t1(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31606g = f10;
        aVar.f31607h = f10;
        return this;
    }

    public d u(@ColorRes int i10, @ColorRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return A(ContextCompat.getColor(this.f10663b, i10), ContextCompat.getColor(this.f10663b, i11), f10);
    }

    public d u1(@ColorRes int i10) {
        return A1(ContextCompat.getColor(this.f10663b, i10));
    }

    public d v(String str) {
        return y(Color.parseColor(str));
    }

    public d v1(@ColorRes int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return B1(ContextCompat.getColor(this.f10663b, i10), f10);
    }

    public d w(String str, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return z(Color.parseColor(str), f10);
    }

    public d w1(@ColorRes int i10, @ColorRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return C1(ContextCompat.getColor(this.f10663b, i10), ContextCompat.getColor(this.f10663b, i11), f10);
    }

    public d x(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return A(Color.parseColor(str), Color.parseColor(str2), f10);
    }

    public d x1(String str) {
        return A1(Color.parseColor(str));
    }

    public d y(@ColorInt int i10) {
        w6.a aVar = this.f10674m;
        aVar.f31601b = i10;
        aVar.f31602c = i10;
        return this;
    }

    public d y1(String str, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return B1(Color.parseColor(str), f10);
    }

    public d z(@ColorInt int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        w6.a aVar = this.f10674m;
        aVar.f31601b = i10;
        aVar.f31602c = i10;
        aVar.f31604e = f10;
        aVar.f31606g = f10;
        return this;
    }

    public d z1(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return C1(Color.parseColor(str), Color.parseColor(str2), f10);
    }

    public d(Fragment fragment) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10671j = true;
        FragmentActivity activity = fragment.getActivity();
        this.f10663b = activity;
        this.f10664c = fragment;
        H();
        d1(activity.getWindow());
    }

    public d(android.app.Fragment fragment) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10671j = true;
        Activity activity = fragment.getActivity();
        this.f10663b = activity;
        this.f10665d = fragment;
        H();
        d1(activity.getWindow());
    }

    public d(androidx.fragment.app.DialogFragment dialogFragment) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10673l = true;
        this.f10672k = true;
        this.f10663b = dialogFragment.getActivity();
        this.f10664c = dialogFragment;
        this.f10666e = dialogFragment.getDialog();
        H();
        d1(this.f10666e.getWindow());
    }

    public d(DialogFragment dialogFragment) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10673l = true;
        this.f10672k = true;
        this.f10663b = dialogFragment.getActivity();
        this.f10665d = dialogFragment;
        this.f10666e = dialogFragment.getDialog();
        H();
        d1(this.f10666e.getWindow());
    }

    public d(Activity activity, Dialog dialog) {
        this.f10671j = false;
        this.f10672k = false;
        this.f10673l = false;
        this.f10676o = 0;
        this.f10677p = 0;
        this.f10678q = 0;
        this.f10679r = null;
        this.f10680s = new HashMap();
        this.f10681t = 0;
        this.f10682u = false;
        this.f10683v = false;
        this.f10684w = false;
        this.f10685x = 0;
        this.f10686y = 0;
        this.f10687z = 0;
        this.A = 0;
        this.f10673l = true;
        this.f10663b = activity;
        this.f10666e = dialog;
        H();
        d1(this.f10666e.getWindow());
    }
}
