package com.martian.mibook.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.maritan.libweixin.c;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.dialog.g;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.h0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.WxBindResultParams;
import com.martian.libsupport.k;
import com.martian.mibook.activity.account.TXSRemoveBlackListActivity;
import com.martian.mibook.activity.account.TXSRequestRemoveBlackListActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.MiGuestUserLoginParams;
import com.martian.mibook.lib.account.request.auth.BindWeixinParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.response.IAccount;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes.dex */
public class MiCompoundUserManager {

    /* renamed from: a */
    private static final String f10761a = "PREF_SECRETE_CATEGORY_PWD";

    /* renamed from: b */
    public final MiUserManager f10762b;

    /* renamed from: c */
    private final Context f10763c;

    /* renamed from: d */
    private boolean f10764d = false;

    /* loaded from: classes3.dex */
    class a extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f10765a;

        /* renamed from: b */
        final /* synthetic */ String f10766b;

        /* renamed from: c */
        final /* synthetic */ int f10767c;

        /* renamed from: d */
        final /* synthetic */ int f10768d;

        a(final j1 val$totalCoins, final String val$money, final int val$title, final int val$activity) {
            this.f10765a = val$totalCoins;
            this.f10766b = val$money;
            this.f10767c = val$title;
            this.f10768d = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
                MiCompoundUserManager.this.E(this.f10765a, this.f10766b, this.f10767c, this.f10768d, null);
            } else {
                MiCompoundUserManager.this.E(this.f10765a, this.f10766b, this.f10767c, this.f10768d, appTaskList.getApps().get(0));
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            MiCompoundUserManager.this.E(this.f10765a, this.f10766b, this.f10767c, this.f10768d, null);
        }
    }

    /* loaded from: classes3.dex */
    class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f10770a;

        /* renamed from: b */
        final /* synthetic */ TextView f10771b;

        b(final RelativeLayout val$bonus_ads_desc, final TextView val$fr_bonus_view) {
            this.f10770a = val$bonus_ads_desc;
            this.f10771b = val$fr_bonus_view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10770a.getLayoutParams();
            if (this.f10771b.getLineCount() <= 1) {
                layoutParams.height = com.martian.libmars.d.h.b(416.0f);
            } else {
                layoutParams.height = com.martian.libmars.d.h.b(436.0f);
            }
            this.f10771b.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class c implements c.InterfaceC0253c {

        /* renamed from: a */
        final /* synthetic */ j1 f10773a;

        /* renamed from: b */
        final /* synthetic */ MTWebView f10774b;

        /* renamed from: c */
        final /* synthetic */ String f10775c;

        class a extends com.martian.mibook.lib.account.d.q.e {
            a(j1 x0) {
                super(x0);
            }

            @Override // com.martian.mibook.lib.account.d.n
            protected void r(b.d.c.b.c errorResult) {
                c.this.f10773a.k1("绑定失败：" + errorResult.toString());
                c cVar = c.this;
                MiCompoundUserManager.this.B(cVar.f10774b, 1);
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }

            @Override // b.d.c.c.b
            /* renamed from: u */
            public void onDataReceived(Boolean success) {
                if (success == null || !success.booleanValue()) {
                    c.this.f10773a.k1("绑定失败");
                    c cVar = c.this;
                    MiCompoundUserManager.this.B(cVar.f10774b, 1);
                } else {
                    c.this.f10773a.k1("绑定成功");
                    c cVar2 = c.this;
                    MiCompoundUserManager.this.B(cVar2.f10774b, 0);
                }
            }
        }

        c(final j1 val$wxAppid, final MTWebView val$webView, final String val$activity) {
            this.f10773a = val$wxAppid;
            this.f10774b = val$webView;
            this.f10775c = val$activity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void a(String authorizationCode) {
            a aVar = new a(this.f10773a);
            ((BindWeixinParams) aVar.k()).setWx_code(authorizationCode);
            ((BindWeixinParams) aVar.k()).setWx_appid(this.f10775c);
            aVar.j();
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void b(String errStr) {
            this.f10773a.k1("绑定失败：" + errStr);
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void onLoginCancelled() {
            this.f10773a.k1("绑定取消");
        }
    }

    /* loaded from: classes3.dex */
    class d extends com.martian.mibook.lib.account.d.g<MiGuestUserLoginParams, MiUser> {

        /* renamed from: g */
        final /* synthetic */ Activity f10778g;

        /* renamed from: h */
        final /* synthetic */ e f10779h;

        class a implements c.d {
            a() {
            }

            @Override // com.martian.mibook.lib.account.e.c.d
            public void a(b.d.c.b.c errorResult) {
                e eVar = d.this.f10779h;
                if (eVar != null) {
                    eVar.a();
                }
            }

            @Override // com.martian.mibook.lib.account.e.c.d
            public void b(MiTaskAccount miTaskAccount) {
                e eVar = d.this.f10779h;
                if (eVar != null) {
                    eVar.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Class x0, Class x1, Context x2, final Activity val$listener, final e val$activity) {
            super(x0, x1, x2);
            this.f10778g = val$listener;
            this.f10779h = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            com.martian.mibook.lib.model.g.b.H(this.f10778g, "生成游客账号-失败");
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<MiUser> miUserList) {
            if (miUserList == null || miUserList.isEmpty()) {
                com.martian.mibook.lib.model.g.b.H(this.f10778g, "生成游客账号-失败-空");
                return;
            }
            MiConfigSingleton.V3().R6();
            com.martian.mibook.lib.model.g.b.H(this.f10778g, "生成游客账号-成功");
            MiCompoundUserManager.this.C(miUserList.get(0));
            com.martian.mibook.lib.account.e.c.l(this.f10778g, new a());
            com.martian.mibook.lib.account.e.c.k(this.f10778g, null);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public interface e {
        void a();
    }

    public MiCompoundUserManager(Context context) {
        MiUserManager.y(context);
        MiUserManager s = MiUserManager.s();
        this.f10762b = s;
        if (MiConfigSingleton.V3().W3() != null) {
            s.C = MiConfigSingleton.V3().W3().getEnableInviteLink().booleanValue();
        }
        this.f10763c = context;
    }

    public void B(MTWebView webView, int code) {
        if (webView != null) {
            webView.loadUrl(webView.c(new WxBindResultParams().setErrcode(code)));
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void H(final j1 activity, String title, int money, int totalCoins) {
        if (n0.C(activity)) {
            final View findViewById = activity.findViewById(R.id.bonus_dialog_vip_view);
            if (findViewById == null) {
                findViewById = LayoutInflater.from(activity).inflate(R.layout.dialog_vip_bonus, (ViewGroup) null);
                ((ImageView) findViewById.findViewById(R.id.fr_close)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        findViewById.setVisibility(8);
                    }
                });
                ((TextView) findViewById.findViewById(R.id.fr_bonus_operate)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        findViewById.setVisibility(8);
                    }
                });
                activity.getWindow().addContentView(findViewById, new ViewGroup.LayoutParams(-1, -1));
            }
            TextView textView = (TextView) activity.findViewById(R.id.fr_bonus_title);
            TextView textView2 = (TextView) activity.findViewById(R.id.fr_bonus_hint);
            TextView textView3 = (TextView) activity.findViewById(R.id.fr_bonus_unit);
            textView.setText(title);
            if (money > 0) {
                textView3.setText("元");
                textView2.setText(com.martian.rpauth.d.i.m(Integer.valueOf(money)));
            } else {
                textView3.setText("金币");
                textView2.setText("" + totalCoins);
            }
            findViewById.setVisibility(0);
        }
    }

    private void I(j1 activity, String wxAppid, MTWebView webView) {
        com.maritan.libweixin.c.g().b(wxAppid, new c(activity, webView, wxAppid));
    }

    private void b(final j1 activity, RelativeLayout fr_bonus_view, LinearLayout bonus_ads_container, final AppTask appTask, final com.martian.mibook.b.b adsFetcher) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.bonus_dialog_ads_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bonus_ads_image);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.tv_ads_logo);
        TextView textView = (TextView) inflate.findViewById(R.id.bonus_ads_desc);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bonus_ads_title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fr_option_button);
        h0.d(textView3);
        textView2.setText(appTask.getTitle());
        textView.setText(appTask.getDesc());
        textView.getViewTreeObserver().addOnPreDrawListener(new b(fr_bonus_view, textView));
        imageView2.setImageResource(appTask.adsIconRes());
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.iv_ads_video);
        if (frameLayout == null) {
            n0.z(activity, appTask.getPosterUrl(), imageView, 4, R.drawable.image_loading_default_horizontal);
        } else if (!appTask.isVideoAd || appTask.videoView == null) {
            frameLayout.setVisibility(8);
            n0.z(activity, appTask.getPosterUrl(), imageView, 4, R.drawable.image_loading_default_horizontal);
        } else {
            frameLayout.setVisibility(0);
            appTask.videoView.init();
            if (appTask.videoView.getView().getParent() == null) {
                frameLayout.removeAllViews();
                frameLayout.addView(appTask.videoView.getView());
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiCompoundUserManager.m(com.martian.mibook.b.b.this, appTask, view);
            }
        });
        bonus_ads_container.addView(inflate);
        if (adsFetcher != null) {
            adsFetcher.g(activity, appTask, bonus_ads_container, inflate, null, textView3, false);
        }
    }

    static /* synthetic */ void m(final com.martian.mibook.b.b adsFetcher, final AppTask appTask, View v) {
        if (adsFetcher != null) {
            adsFetcher.d(appTask);
        }
    }

    /* renamed from: p */
    public /* synthetic */ void q(final j1 activity, final String wxAppid, final MTWebView webView, final DialogFragment fragment, final com.martian.mibook.lib.account.b.d dialogBinding, View v) {
        if (!this.f10764d && MiConfigSingleton.V3().j5()) {
            activity.k1("请先同意用户隐私协议");
            h0.e(dialogBinding.f13838e);
            return;
        }
        activity.k1("跳转微信中...");
        I(activity, wxAppid, webView);
        if (fragment != null) {
            this.f10764d = false;
            fragment.dismiss();
        }
    }

    /* renamed from: r */
    public /* synthetic */ void s(final com.martian.mibook.lib.account.b.d dialogBinding, View v) {
        boolean z = !this.f10764d;
        this.f10764d = z;
        dialogBinding.f13839f.setImageResource(z ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
    }

    /* renamed from: t */
    public /* synthetic */ void u(final DialogFragment fragment, View v) {
        if (fragment != null) {
            this.f10764d = false;
            fragment.dismiss();
        }
    }

    private void z(final j1 activity, String title, final int money, final int totalCoins) {
        MiConfigSingleton.V3().N4.x(activity, false, new a(activity, title, money, totalCoins));
    }

    public void A() {
        if (this.f10762b.e() instanceof MiUser) {
            MiUser miUser = (MiUser) this.f10762b.e();
            Boolean bool = Boolean.FALSE;
            miUser.setWeixinBound(bool);
            miUser.setGuest(bool);
        }
        this.f10762b.i();
    }

    public void C(com.martian.rpauth.b user) {
        this.f10762b.m(user);
    }

    public void D(String secreteCategoryPwd) {
        com.martian.libsupport.h.o(this.f10763c, f10761a, secreteCategoryPwd);
    }

    @SuppressLint({"SetTextI18n"})
    public void E(final j1 activity, String title, int money, int totalCoins, AppTask appTask) {
        if (n0.C(activity)) {
            final View findViewById = activity.findViewById(R.id.bonus_dialog_view);
            if (findViewById == null) {
                findViewById = LayoutInflater.from(activity).inflate(R.layout.dialog_reading_bonus, (ViewGroup) null);
                ((ImageView) findViewById.findViewById(R.id.fr_close)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        findViewById.setVisibility(8);
                    }
                });
                ((TextView) findViewById.findViewById(R.id.fr_bonus_operate)).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        findViewById.setVisibility(8);
                    }
                });
                activity.getWindow().addContentView(findViewById, new ViewGroup.LayoutParams(-1, -1));
            }
            RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.fr_bonus_view);
            TextView textView = (TextView) activity.findViewById(R.id.fr_bonus_title);
            TextView textView2 = (TextView) activity.findViewById(R.id.fr_bonus_hint);
            TextView textView3 = (TextView) activity.findViewById(R.id.fr_bonus_unit);
            TextView textView4 = (TextView) activity.findViewById(R.id.fr_bonus_operate);
            textView.setText(title);
            if (money > 0) {
                textView3.setText("元");
                textView2.setText(com.martian.rpauth.d.i.m(Integer.valueOf(money)));
            } else {
                textView3.setText("金币");
                textView2.setText("" + totalCoins);
            }
            LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.bonus_ads_container);
            linearLayout.removeAllViews();
            if (appTask == null) {
                appTask = MiConfigSingleton.V3().x3(com.martian.mibook.b.b.C);
            }
            AppTask appTask2 = appTask;
            com.martian.mibook.b.b bVar = new com.martian.mibook.b.b(activity, com.martian.mibook.b.b.C, b.d.a.j.b.o);
            if (appTask2.customView == null) {
                textView4.setVisibility(8);
                b(activity, relativeLayout, linearLayout, appTask2, bVar);
            } else {
                linearLayout.setPadding(com.martian.libmars.d.h.b(8.0f), 0, com.martian.libmars.d.h.b(8.0f), 0);
                bVar.f(activity, appTask2, linearLayout, linearLayout);
            }
            findViewById.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void F(final j1 activity, final String wxAppid, final MTWebView webView) {
        final com.martian.mibook.lib.account.b.d d2 = com.martian.mibook.lib.account.b.d.d(activity.getLayoutInflater(), null, false);
        final com.martian.dialog.e k = ((g.a) ((g.a) com.martian.dialog.g.i(activity).R(d2.getRoot()).f(false)).j(true)).k();
        d2.f13835b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiCompoundUserManager.this.q(activity, wxAppid, webView, k, d2, view);
            }
        });
        if (!MiConfigSingleton.V3().j5()) {
            d2.f13839f.setImageResource(R.drawable.icon_checked);
        }
        d2.f13838e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiCompoundUserManager.this.s(d2, view);
            }
        });
        d2.f13837d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiCompoundUserManager.this.u(k, view);
            }
        });
        d2.f13841h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.martian.mibook.lib.account.e.c.i(j1.this);
            }
        });
        d2.f13840g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.account.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.martian.mibook.lib.account.e.c.f(j1.this);
            }
        });
    }

    public void G(final j1 activity, String title, final int money, final int totalCoins) {
        if (MiConfigSingleton.V3().u5()) {
            return;
        }
        if (MiConfigSingleton.V3().h6()) {
            H(activity, title, money, totalCoins);
        } else {
            z(activity, title, money, totalCoins);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(Activity activity, e listener) {
        com.martian.mibook.lib.model.g.b.H(activity, "生成游客账号");
        d dVar = new d(MiGuestUserLoginParams.class, MiUser.class, activity, activity, listener);
        ((MiGuestUserLoginParams) dVar.k()).setOaid(com.martian.libmars.d.h.F().V());
        ((MiGuestUserLoginParams) dVar.k()).setImei(com.martian.libmars.d.h.F().z());
        dVar.j();
    }

    public long d() {
        return this.f10762b.t();
    }

    public IAccount e() {
        return this.f10762b.c();
    }

    public String f() {
        String j2 = com.martian.libsupport.h.j(this.f10763c, f10761a);
        return k.p(j2) ? "" : j2;
    }

    public IAccount g() {
        return this.f10762b.d();
    }

    public com.martian.rpauth.b h() {
        return this.f10762b.e();
    }

    public void i(j1 activity, b.d.c.b.c errorResult, String path) {
        if (errorResult == null || !n0.C(activity)) {
            return;
        }
        if (errorResult.c() == 20008) {
            F(activity, MiConfigSingleton.V3().W3().getWithdrawWxAppid(), null);
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-绑定微信");
            return;
        }
        if (errorResult.c() == 20009) {
            activity.k1(errorResult.d());
            PhoneLoginActivity.j3(activity, 1, "", 20003);
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-绑定手机");
            return;
        }
        if (errorResult.c() == 20010) {
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-清零解封");
            TXSRemoveBlackListActivity.y2(activity);
            return;
        }
        if (errorResult.c() == 20011) {
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-申请解封");
            TXSRequestRemoveBlackListActivity.v2(activity);
            return;
        }
        if (errorResult.c() == 20012) {
            activity.k1(errorResult.d());
            PhoneLoginActivity.j3(activity, 2, MiConfigSingleton.V3().Y8(), 20003);
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-验证手机");
            return;
        }
        if (errorResult.c() == 20015) {
            activity.k1(errorResult.d());
            MiConfigSingleton.V3().n2(activity);
            com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-微信登录");
            return;
        }
        activity.k1(errorResult.d());
        com.martian.mibook.lib.model.g.b.N(activity, path + "-失败-" + errorResult.d());
    }

    public boolean j() {
        return !k.p(f());
    }

    public boolean k() {
        return this.f10762b.f();
    }

    public boolean l(String pwd) {
        return k.n(pwd, f());
    }
}
