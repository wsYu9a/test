package com.martian.mibook.account;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import ba.j;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.WxBindResultParams;
import com.martian.mibook.activity.account.TXSRemoveBlackListActivity;
import com.martian.mibook.activity.account.TXSRequestRemoveBlackListActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding;
import com.martian.mibook.lib.account.request.MiGuestUserLoginParams;
import com.martian.mibook.lib.account.request.auth.BindWeixinParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.IAccount;
import java.lang.ref.WeakReference;
import java.util.List;
import l9.m0;
import l9.t0;
import lb.c;
import ya.e0;
import z7.b;

/* loaded from: classes3.dex */
public class MiCompoundUserManager {

    /* renamed from: f */
    public static final String f13076f = "PREF_ACCOUNT_CREATE_ON";

    /* renamed from: g */
    public static final String f13077g = "PREF_USER_ACTIVATE_TIME";

    /* renamed from: a */
    public final MiUserManager f13078a;

    /* renamed from: c */
    public Boolean f13080c;

    /* renamed from: d */
    public Long f13081d;

    /* renamed from: b */
    public boolean f13079b = false;

    /* renamed from: e */
    public boolean f13082e = false;

    public class a extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ FragmentActivity f13083a;

        /* renamed from: b */
        public final /* synthetic */ String f13084b;

        /* renamed from: c */
        public final /* synthetic */ int f13085c;

        /* renamed from: d */
        public final /* synthetic */ int f13086d;

        public a(FragmentActivity fragmentActivity, String str, int i10, int i11) {
            this.f13083a = fragmentActivity;
            this.f13084b = str;
            this.f13085c = i10;
            this.f13086d = i11;
        }

        @Override // d8.b, d8.a
        public void a() {
            super.a();
            MiCompoundUserManager.this.Q(this.f13083a, this.f13084b, this.f13085c, this.f13086d, null);
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            MiCompoundUserManager.this.Q(this.f13083a, this.f13084b, this.f13085c, this.f13086d, null);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
                MiCompoundUserManager.this.Q(this.f13083a, this.f13084b, this.f13085c, this.f13086d, null);
            } else {
                MiCompoundUserManager.this.Q(this.f13083a, this.f13084b, this.f13085c, this.f13086d, appTaskList.getApps().get(0));
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public final /* synthetic */ RelativeLayout f13088b;

        /* renamed from: c */
        public final /* synthetic */ GroMoreAd.AdViewHolder f13089c;

        public b(RelativeLayout relativeLayout, GroMoreAd.AdViewHolder adViewHolder) {
            this.f13088b = relativeLayout;
            this.f13089c = adViewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13088b.getLayoutParams();
            if (this.f13089c.mDescription.getLineCount() <= 1) {
                layoutParams.height = ConfigSingleton.i(416.0f);
            } else {
                layoutParams.height = ConfigSingleton.i(436.0f);
            }
            this.f13089c.mDescription.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    public class c extends d8.b {
        public c() {
        }
    }

    public class d implements b.a {

        /* renamed from: a */
        public final /* synthetic */ Activity f13092a;

        /* renamed from: b */
        public final /* synthetic */ MTWebView f13093b;

        /* renamed from: c */
        public final /* synthetic */ String f13094c;

        public class a extends kb.e {
            public a(Activity activity) {
                super(activity);
            }

            @Override // jb.k
            public void s(x8.c cVar) {
                t0.b(d.this.f13092a, "绑定失败：" + cVar.toString());
                d dVar = d.this;
                MiCompoundUserManager.this.L(dVar.f13093b, 1);
            }

            @Override // y8.f
            public void showLoading(boolean z10) {
            }

            @Override // y8.a
            /* renamed from: v */
            public void onDataReceived(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    t0.b(d.this.f13092a, "绑定失败");
                    d dVar = d.this;
                    MiCompoundUserManager.this.L(dVar.f13093b, 1);
                } else {
                    t0.b(d.this.f13092a, "绑定成功");
                    d dVar2 = d.this;
                    MiCompoundUserManager.this.L(dVar2.f13093b, 0);
                }
            }
        }

        public d(Activity activity, MTWebView mTWebView, String str) {
            this.f13092a = activity;
            this.f13093b = mTWebView;
            this.f13094c = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z7.b.a
        public void a(String str) {
            a aVar = new a(this.f13092a);
            ((BindWeixinParams) aVar.k()).setWx_code(str);
            ((BindWeixinParams) aVar.k()).setWx_appid(this.f13094c);
            aVar.j();
        }

        @Override // z7.b.a
        public void b(String str) {
            t0.b(this.f13092a, "绑定失败：" + str);
        }

        @Override // z7.b.a
        public void onLoginCancelled() {
            t0.b(this.f13092a, "绑定取消");
        }
    }

    public class f extends kb.a {

        /* renamed from: i */
        public final /* synthetic */ WeakReference f13101i;

        public class a implements ConfigSingleton.a {
            public a() {
            }

            @Override // com.martian.libmars.common.ConfigSingleton.a
            public void a() {
                f.this.f27313h.i();
            }

            @Override // com.martian.libmars.common.ConfigSingleton.a
            public void b() {
                f.this.f27313h.i();
                lb.d.b((Activity) f.this.f13101i.get(), 200, true);
            }
        }

        public f(WeakReference weakReference) {
            this.f13101i = weakReference;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f13101i.get() != null && cVar.c() == 205) {
                ConfigSingleton.D().n1((Activity) this.f13101i.get(), new a());
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(Boolean bool) {
            MiCompoundUserManager.this.P(true);
        }
    }

    public interface g {
        void a(MiUser miUser);
    }

    public MiCompoundUserManager(Context context) {
        MiUserManager.t(context);
        this.f13078a = MiUserManager.q();
    }

    public static /* synthetic */ void A(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public static /* synthetic */ void G(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public static /* synthetic */ void H(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public static /* synthetic */ void I(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public static /* synthetic */ void y(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public static /* synthetic */ void z(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public final /* synthetic */ void C(FragmentActivity fragmentActivity, String str, MTWebView mTWebView, DialogFragment dialogFragment, BindWeixinDialogBinding bindWeixinDialogBinding, View view) {
        if (!this.f13079b && MiConfigSingleton.b2().C2()) {
            t0.b(fragmentActivity, "请先同意用户隐私协议");
            l9.a.f(bindWeixinDialogBinding.f13935e);
            return;
        }
        t0.b(fragmentActivity, "跳转微信中...");
        U(fragmentActivity, str, mTWebView);
        if (dialogFragment != null) {
            this.f13079b = false;
            dialogFragment.dismiss();
        }
    }

    public final /* synthetic */ void D(BindWeixinDialogBinding bindWeixinDialogBinding, View view) {
        boolean z10 = !this.f13079b;
        this.f13079b = z10;
        bindWeixinDialogBinding.f13936f.setImageResource(z10 ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
    }

    public final /* synthetic */ void E(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            this.f13079b = false;
            dialogFragment.dismiss();
        }
    }

    public void J(FragmentActivity fragmentActivity, String str, int i10, int i11) {
        MiConfigSingleton.b2().H1().T(fragmentActivity, e0.S, new a(fragmentActivity, str, i10, i11));
    }

    public void K() {
        if (this.f13078a.e() instanceof MiUser) {
            MiUser miUser = (MiUser) this.f13078a.e();
            Boolean bool = Boolean.FALSE;
            miUser.setWeixinBound(bool);
            miUser.setGuest(bool);
        }
        this.f13078a.i();
    }

    public final void L(MTWebView mTWebView, int i10) {
        if (mTWebView != null) {
            mTWebView.loadUrl(mTWebView.d(new WxBindResultParams().setErrcode(i10)));
        }
    }

    public void M(me.b bVar) {
        this.f13078a.l(bVar);
    }

    public void N(Context context) {
        j.n(context, f13076f, MartianRPUserManager.a());
    }

    public final void O(Activity activity) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f13081d = valueOf;
        j.n(activity, f13077g, valueOf.longValue());
    }

    public void P(boolean z10) {
        this.f13082e = z10;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: oa.k.<init>(androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public void Q(androidx.fragment.app.FragmentActivity r8, java.lang.String r9, int r10, int r11, com.martian.apptask.data.AppTask r12) {
        /*
            r7 = this;
            boolean r0 = l9.m0.C(r8)
            if (r0 != 0) goto L7
            return
        L7:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r8)
            int r1 = com.martian.mibook.R.layout.dialog_reading_bonus
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = com.martian.mibook.R.id.fr_bonus_view
            android.view.View r1 = r0.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            int r2 = com.martian.mibook.R.id.bonus_ads_container
            android.view.View r2 = r0.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            int r3 = com.martian.mibook.R.id.fr_bonus_title
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.martian.mibook.R.id.fr_bonus_hint
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.martian.mibook.R.id.fr_bonus_unit
            android.view.View r5 = r0.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.martian.mibook.R.id.fr_bonus_operate
            android.view.View r6 = r0.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r3.setText(r9)
            if (r10 <= 0) goto L58
            java.lang.String r9 = "元"
            r5.setText(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            java.lang.String r9 = oe.f.n(r9)
            r4.setText(r9)
            goto L71
        L58:
            java.lang.String r9 = "金币"
            r5.setText(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = ""
            r9.append(r10)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r4.setText(r9)
        L71:
            if (r12 != 0) goto L81
            com.martian.mibook.application.MiConfigSingleton r9 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.a r9 = r9.H1()
            java.lang.String r10 = "normal_flow"
            com.martian.apptask.data.AppTask r12 = r9.S(r10)
        L81:
            r9 = 8
            r6.setVisibility(r9)
            r7.n(r8, r1, r2, r12)
            com.martian.libmars.widget.dialog.b r9 = com.martian.libmars.widget.dialog.MartianDialogFragment.j()
            com.martian.libmars.widget.dialog.b r9 = r9.Q(r0)
            r10 = 0
            com.martian.libmars.widget.dialog.b r9 = r9.I(r10)
            com.martian.libmars.widget.dialog.b r9 = r9.J(r10)
            int r10 = com.martian.libmars.R.style.MartianDialogFragmentFullScreenStyle
            com.martian.libmars.widget.dialog.b r9 = r9.P(r10)
            oa.j r10 = new oa.j
            r10.<init>()
            com.martian.libmars.widget.dialog.b r9 = r9.M(r10)
            com.martian.libmars.widget.dialog.MartianDialogFragment r8 = r9.E(r8)
            int r9 = com.martian.mibook.R.id.fr_close
            android.view.View r9 = r0.findViewById(r9)
            oa.k r10 = new oa.k
            r10.<init>()
            r9.setOnClickListener(r10)
            int r9 = com.martian.mibook.R.id.fr_bonus_operate
            android.view.View r9 = r0.findViewById(r9)
            oa.b r10 = new oa.b
            r10.<init>()
            r9.setOnClickListener(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.account.MiCompoundUserManager.Q(androidx.fragment.app.FragmentActivity, java.lang.String, int, int, com.martian.apptask.data.AppTask):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: oa.e.<init>(com.martian.mibook.account.MiCompoundUserManager, androidx.fragment.app.FragmentActivity, java.lang.String, com.martian.libmars.widget.MTWebView, androidx.fragment.app.DialogFragment, com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public void R(androidx.fragment.app.FragmentActivity r12, java.lang.String r13, com.martian.libmars.widget.MTWebView r14) {
        /*
            r11 = this;
            android.view.LayoutInflater r0 = r12.getLayoutInflater()
            r1 = 0
            r2 = 0
            com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding r0 = com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding.d(r0, r1, r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment$a r1 = com.martian.libmars.widget.dialog.MartianDialogFragment.INSTANCE
            com.martian.libmars.widget.dialog.b r1 = r1.a()
            android.widget.RelativeLayout r3 = r0.getRoot()
            com.martian.libmars.widget.dialog.b r1 = r1.Q(r3)
            com.martian.libmars.widget.dialog.b r1 = r1.J(r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment r1 = r1.E(r12)
            android.widget.LinearLayout r2 = r0.f13932b
            oa.e r10 = new oa.e
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r1
            r9 = r0
            r3.<init>()
            r2.setOnClickListener(r10)
            com.martian.mibook.application.MiConfigSingleton r13 = com.martian.mibook.application.MiConfigSingleton.b2()
            boolean r13 = r13.C2()
            if (r13 != 0) goto L42
            android.widget.ImageView r13 = r0.f13936f
            int r14 = com.martian.libmars.R.drawable.icon_checked
            r13.setImageResource(r14)
        L42:
            android.widget.LinearLayout r13 = r0.f13935e
            oa.f r14 = new oa.f
            r14.<init>()
            r13.setOnClickListener(r14)
            android.widget.ImageView r13 = r0.f13934d
            oa.g r14 = new oa.g
            r14.<init>()
            r13.setOnClickListener(r14)
            android.widget.TextView r13 = r0.f13938h
            oa.h r14 = new oa.h
            r14.<init>()
            r13.setOnClickListener(r14)
            android.widget.TextView r13 = r0.f13937g
            oa.i r14 = new oa.i
            r14.<init>()
            r13.setOnClickListener(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.account.MiCompoundUserManager.R(androidx.fragment.app.FragmentActivity, java.lang.String, com.martian.libmars.widget.MTWebView):void");
    }

    public void S(FragmentActivity fragmentActivity, String str, int i10, int i11) {
        if (MiConfigSingleton.b2().K2() || MiConfigSingleton.b2().C2()) {
            T(fragmentActivity, str, i10, i11);
        } else {
            J(fragmentActivity, str, i10, i11);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: oa.c.<init>(androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public void T(androidx.fragment.app.FragmentActivity r7, java.lang.String r8, int r9, int r10) {
        /*
            r6 = this;
            boolean r0 = l9.m0.C(r7)
            if (r0 != 0) goto L7
            return
        L7:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r7)
            int r1 = com.martian.mibook.R.layout.dialog_vip_bonus
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = com.martian.mibook.R.id.tv_show_ad
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = com.martian.mibook.R.id.tv_vip_dialog_title
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.martian.mibook.R.id.tv_vip_dialog_bonus
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.martian.mibook.R.id.tv_vip_dialog_unit
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.martian.mibook.R.string.known
            java.lang.String r5 = r7.getString(r5)
            r1.setText(r5)
            r2.setText(r8)
            if (r9 <= 0) goto L51
            java.lang.String r8 = "元"
            r4.setText(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            java.lang.String r8 = oe.f.n(r8)
            r3.setText(r8)
            goto L5d
        L51:
            java.lang.String r8 = "金币"
            r4.setText(r8)
            java.lang.String r8 = java.lang.String.valueOf(r10)
            r3.setText(r8)
        L5d:
            com.martian.libmars.widget.dialog.b r8 = com.martian.libmars.widget.dialog.MartianDialogFragment.j()
            com.martian.libmars.widget.dialog.b r8 = r8.Q(r0)
            r9 = 0
            com.martian.libmars.widget.dialog.b r8 = r8.I(r9)
            com.martian.libmars.widget.dialog.b r8 = r8.J(r9)
            int r9 = com.martian.libmars.R.style.MartianDialogFragmentFullScreenStyle
            com.martian.libmars.widget.dialog.b r8 = r8.P(r9)
            oa.a r9 = new oa.a
            r9.<init>()
            com.martian.libmars.widget.dialog.b r8 = r8.M(r9)
            com.martian.libmars.widget.dialog.MartianDialogFragment r7 = r8.E(r7)
            int r8 = com.martian.mibook.R.id.iv_close
            android.view.View r8 = r0.findViewById(r8)
            oa.c r9 = new oa.c
            r9.<init>()
            r8.setOnClickListener(r9)
            oa.d r8 = new oa.d
            r8.<init>()
            r1.setOnClickListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.account.MiCompoundUserManager.T(androidx.fragment.app.FragmentActivity, java.lang.String, int, int):void");
    }

    public final void U(Activity activity, String str, MTWebView mTWebView) {
        z7.b.d().a(activity, str, new d(activity, mTWebView, str));
    }

    public void m(Activity activity) {
        f fVar = new f(new WeakReference(activity));
        fVar.o();
        fVar.j();
    }

    public final void n(Activity activity, RelativeLayout relativeLayout, LinearLayout linearLayout, AppTask appTask) {
        View inflate = activity.getLayoutInflater().inflate(com.martian.mibook.R.layout.bonus_dialog_ads_item, (ViewGroup) null);
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) inflate.findViewById(com.martian.mibook.R.id.bonus_ads_title);
        adViewHolder.mDescription = (TextView) inflate.findViewById(com.martian.mibook.R.id.bonus_ads_desc);
        adViewHolder.mPoster = (ImageView) inflate.findViewById(com.martian.mibook.R.id.bonus_ads_image);
        adViewHolder.videoView = (FrameLayout) inflate.findViewById(com.martian.mibook.R.id.iv_ads_video);
        adViewHolder.mCreativeButton = (Button) inflate.findViewById(com.martian.mibook.R.id.fr_option_button);
        adViewHolder.mAdLogo = (ImageView) inflate.findViewById(com.martian.mibook.R.id.tv_ads_logo);
        adViewHolder.mAdLogoDesc = (TextView) inflate.findViewById(com.martian.mibook.R.id.tv_ads_logo_desc);
        l9.a.d(adViewHolder.mCreativeButton);
        adViewHolder.mTitle.setText(appTask.getTitle());
        adViewHolder.mDescription.setText(appTask.getDesc());
        adViewHolder.mDescription.getViewTreeObserver().addOnPreDrawListener(new b(relativeLayout, adViewHolder));
        adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
        MiConfigSingleton.b2().H1().Q0(activity, adViewHolder.mPoster, null, appTask);
        linearLayout.addView(inflate);
        MiConfigSingleton.b2().H1().A(activity, appTask, linearLayout, inflate.findViewById(com.martian.mibook.R.id.bonus_ads_view), adViewHolder, new c());
    }

    public void o(Activity activity, g gVar) {
        p(activity, gVar, "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p(Activity activity, g gVar, String str, String str2) {
        WeakReference weakReference = new WeakReference(activity);
        e eVar = new e(MiGuestUserLoginParams.class, MiUser.class, (Context) weakReference.get(), gVar, weakReference);
        ((MiGuestUserLoginParams) eVar.k()).setOaid(ConfigSingleton.D().M());
        ((MiGuestUserLoginParams) eVar.k()).setAndroid_id(ConfigSingleton.D().j());
        ((MiGuestUserLoginParams) eVar.k()).setImei(ConfigSingleton.D().A());
        ((MiGuestUserLoginParams) eVar.k()).setSourceName(str);
        ((MiGuestUserLoginParams) eVar.k()).setSourceId(str2);
        eVar.j();
    }

    public IAccount q() {
        return this.f13078a.c();
    }

    public IAccount r() {
        return this.f13078a.d();
    }

    public me.b s() {
        return this.f13078a.e();
    }

    public void t(FragmentActivity fragmentActivity, int i10, String str, String str2) {
        if (m0.C(fragmentActivity)) {
            if (i10 == 20008) {
                R(fragmentActivity, MiConfigSingleton.b2().c2().getWithdrawWxAppid(), null);
                ac.a.G(fragmentActivity, str2 + "-失败-绑定微信");
                return;
            }
            if (i10 == 20009) {
                t0.b(fragmentActivity, str);
                PhoneLoginActivity.y3(fragmentActivity, 1, "", 20003);
                ac.a.G(fragmentActivity, str2 + "-失败-绑定手机");
                return;
            }
            if (i10 == 20010) {
                ac.a.G(fragmentActivity, str2 + "-失败-清零解封");
                TXSRemoveBlackListActivity.T2(fragmentActivity);
                return;
            }
            if (i10 == 20011) {
                ac.a.G(fragmentActivity, str2 + "-失败-申请解封");
                TXSRequestRemoveBlackListActivity.P2(fragmentActivity);
                return;
            }
            if (i10 == 20012) {
                t0.b(fragmentActivity, str);
                PhoneLoginActivity.y3(fragmentActivity, 2, MiConfigSingleton.b2().r3(), 20003);
                ac.a.G(fragmentActivity, str2 + "-失败-验证手机");
                return;
            }
            if (i10 == 20015) {
                t0.b(fragmentActivity, str);
                MiConfigSingleton.b2().G1().i(fragmentActivity);
                ac.a.G(fragmentActivity, str2 + "-失败-微信登录");
                return;
            }
            t0.b(fragmentActivity, str);
            ac.a.G(fragmentActivity, str2 + "-失败-" + str);
        }
    }

    public boolean u(Activity activity, boolean z10) {
        if (this.f13081d == null) {
            this.f13081d = Long.valueOf(j.h(activity, f13077g, z10 ? -1L : System.currentTimeMillis()));
        }
        if (this.f13081d.longValue() < 0) {
            O(activity);
            return true;
        }
        int freshUserHourInterval = MiConfigSingleton.b2().c2().getFreshUserHourInterval();
        if (freshUserHourInterval <= 0) {
            O(activity);
            return false;
        }
        boolean z11 = System.currentTimeMillis() - this.f13081d.longValue() > ((long) (freshUserHourInterval * SdkConfigData.DEFAULT_REQUEST_INTERVAL)) * 1000;
        O(activity);
        return z11;
    }

    public boolean v() {
        return this.f13078a.f();
    }

    public boolean w(Context context) {
        Boolean bool = this.f13080c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(MartianRPUserManager.a() - j.h(context, f13076f, -1L) <= 86400000);
        this.f13080c = valueOf;
        return valueOf.booleanValue();
    }

    public boolean x() {
        return this.f13082e;
    }

    public class e extends jb.e<MiGuestUserLoginParams, MiUser> {

        /* renamed from: h */
        public final /* synthetic */ g f13097h;

        /* renamed from: i */
        public final /* synthetic */ WeakReference f13098i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Class cls, Class cls2, Context context, g gVar, WeakReference weakReference) {
            super(cls, cls2, context);
            this.f13097h = gVar;
            this.f13098i = weakReference;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            g gVar = this.f13097h;
            if (gVar != null) {
                gVar.a(null);
            }
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<MiUser> list) {
            if (list == null || list.isEmpty() || list.get(0) == null) {
                g gVar = this.f13097h;
                if (gVar != null) {
                    gVar.a(null);
                    return;
                }
                return;
            }
            MiUser miUser = list.get(0);
            MiCompoundUserManager.this.M(miUser);
            Activity activity = (Activity) this.f13098i.get();
            if (activity == null) {
                g gVar2 = this.f13097h;
                if (gVar2 != null) {
                    gVar2.a(miUser);
                    return;
                }
                return;
            }
            MiCompoundUserManager.this.N(activity);
            g gVar3 = this.f13097h;
            if (gVar3 != null) {
                gVar3.a(miUser);
            }
            lb.c.x(activity, new a());
            MiConfigSingleton.b2().G1().C(activity, true, null);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        public class a implements c.g {
            public a() {
            }

            @Override // lb.c.g
            public void b(MiTaskAccount miTaskAccount) {
            }

            @Override // lb.c.g
            public void a(x8.c cVar) {
            }
        }
    }
}
