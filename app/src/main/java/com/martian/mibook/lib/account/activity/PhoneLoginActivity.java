package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import com.maritan.libweixin.c;
import com.martian.dialog.g;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.h0;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.q0;
import com.martian.libqq.QQAPIInstance;
import com.martian.libqq.QQAuth;
import com.martian.libqq.QQUserInfo;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.d.q.d0;
import com.martian.mibook.lib.account.request.MiUserRegisterParams;
import com.martian.mibook.lib.account.request.PhoneLoginParams;
import com.martian.mibook.lib.account.request.RequestPhoneCodeCaptchaParams;
import com.martian.mibook.lib.account.request.RequestPhoneCodeParams;
import com.martian.mibook.lib.account.request.WXRegisterParams;
import com.martian.mibook.lib.account.request.auth.BindPhoneParams;
import com.martian.mibook.lib.account.request.auth.BindWeixinParams;
import com.martian.mibook.lib.account.request.auth.GetUserInfoParams;
import com.martian.mibook.lib.account.request.auth.TryWeixinBindParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.PhoneCodeCaptchaResponse;
import com.martian.mibook.lib.account.response.PhoneCodeResponse;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.account.response.UserDetail;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class PhoneLoginActivity extends com.martian.mibook.lib.model.b.a {
    private static final String F = "PHONE_TYPE";
    private static final String G = "PHONE_VERFIYHINT";
    private int H;
    private String I;
    private com.martian.mibook.lib.account.b.b J;
    private boolean K = false;
    private final k L = new k();
    private int M = 60;
    private int N = 0;
    private ImageView O;

    class a extends d0<TryWeixinBindParams, UserDetail> {
        a(Class aClass, Class dataType, Activity activity) {
            super(aClass, dataType, activity);
        }

        /* renamed from: t */
        public /* synthetic */ void u(final MiUser miUser) {
            MiWebViewBaseActivity.h4(PhoneLoginActivity.this, com.martian.libmars.d.h.F().l(), miUser.getUid().toString(), miUser.getToken(), com.martian.libmars.d.h.F().f().f9879a, PopupLoginActivity.f13754a);
        }

        /* renamed from: v */
        public /* synthetic */ void w() {
            PhoneLoginActivity.this.k1("登录取消");
            PhoneLoginActivity.this.finish();
        }

        @Override // com.martian.mibook.lib.account.d.q.d0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            q0.f("zzz", "同步失败");
            PhoneLoginActivity.this.d3("登录失败，请重试" + errorResult.toString(), true);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<UserDetail> userDetails) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            if (userDetails == null || userDetails.isEmpty()) {
                PhoneLoginActivity.this.k1("登录失败");
                PhoneLoginActivity.this.finish();
                return;
            }
            q0.f("zzz", "同步成功");
            UserDetail userDetail = userDetails.get(0);
            final MiUser userInfo = userDetail.getUserInfo();
            MiTaskAccount taskAccount = userDetail.getTaskAccount();
            MartianRPAccount account = userDetail.getAccount();
            if (userInfo == null) {
                PhoneLoginActivity.this.finish();
                return;
            }
            if (userInfo.getLoggingOff().booleanValue()) {
                PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
                k0.Q(phoneLoginActivity, "确认信息", "该账号正在注销审核中，继续登录将会放弃注销", phoneLoginActivity.getString(R.string.cancel), PhoneLoginActivity.this.getString(R.string.cancel_logout), true, new k0.l() { // from class: com.martian.mibook.lib.account.activity.c
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        PhoneLoginActivity.a.this.u(userInfo);
                    }
                }, new k0.j() { // from class: com.martian.mibook.lib.account.activity.b
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        PhoneLoginActivity.a.this.w();
                    }
                });
                return;
            }
            if (!userInfo.getUid().equals(MiUserManager.s().e().getUid())) {
                com.martian.mibook.lib.account.e.d.e(PhoneLoginActivity.this, userInfo, taskAccount, account);
                return;
            }
            PhoneLoginActivity.this.a3(userInfo);
            if (taskAccount != null) {
                MiUserManager.s().l(taskAccount);
            }
            if (account != null && MartianRPUserManager.u() != null) {
                MartianRPUserManager.u().k(account);
            }
            PhoneLoginActivity.this.setResult(-1);
            PhoneLoginActivity.this.k1("登录成功");
            PhoneLoginActivity.this.finish();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PhoneLoginActivity.this.J.f13824d.setVisibility(0);
            }
        }
    }

    class b extends com.martian.mibook.lib.account.d.l {
        b() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            if (errorResult.c() == 2006) {
                PhoneLoginActivity.this.G2(false);
            } else {
                PhoneLoginActivity.this.k1(errorResult.toString());
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: p */
        public void onDataReceived(PhoneCodeResponse phoneCodeResponse) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            if (phoneCodeResponse != null && phoneCodeResponse.getRequestIntervalSeconds() > 0) {
                PhoneLoginActivity.this.M = phoneCodeResponse.getRequestIntervalSeconds();
            }
            PhoneLoginActivity.this.k1("获取验证码成功！");
            PhoneLoginActivity.this.i3();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PhoneLoginActivity.this.e3("验证码发送中...");
            }
        }
    }

    class c extends com.martian.mibook.lib.account.d.q.d {
        c(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            PhoneLoginActivity.this.d3(errorResult.d(), false);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PhoneLoginActivity.this.e3("验证中...");
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYBonus tyBonus) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            PhoneLoginActivity.this.setResult(-1);
            PhoneLoginActivity.this.m3();
            PhoneLoginActivity.this.f3("恭喜您", "手机号验证成功", "知道了");
        }
    }

    class d extends com.martian.mibook.lib.account.d.q.d {
        d(j1 activity) {
            super(activity);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (errorResult.c() == 20015) {
                PopupLoginActivity.x0(PhoneLoginActivity.this, 202, true);
            }
            PhoneLoginActivity.this.d3(errorResult.d(), false);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PhoneLoginActivity.this.e3("绑定中...");
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(TYBonus tyBonus) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            PhoneLoginActivity.this.setResult(-1);
            PhoneLoginActivity.this.k1("绑定成功");
            PhoneLoginActivity.this.m3();
            if (tyBonus == null) {
                PhoneLoginActivity.this.finish();
                return;
            }
            PhoneLoginActivity.this.f3("恭喜您", "获得奖励" + tyBonus.getCoins() + "金币", "知道了");
        }
    }

    class e extends com.martian.mibook.lib.account.d.i {
        e() {
        }

        /* renamed from: p */
        public /* synthetic */ void q(final MiUser miUser) {
            MiWebViewBaseActivity.h4(PhoneLoginActivity.this, com.martian.libmars.d.h.F().l(), miUser.getUid().toString(), miUser.getToken(), com.martian.libmars.d.h.F().f().f9879a, PopupLoginActivity.f13754a);
        }

        /* renamed from: r */
        public /* synthetic */ void s() {
            PhoneLoginActivity.this.k1("登录取消");
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            if (errorResult.c() == 2008 || errorResult.c() == 20008 || errorResult.c() == 20015) {
                PhoneLoginActivity.this.b3(null);
            } else {
                PhoneLoginActivity.this.k1(errorResult.toString());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PhoneLoginActivity.this.e3("登录中...");
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(final MiUser miUser) {
            PhoneLoginActivity.this.J.f13824d.setVisibility(8);
            if (miUser == null) {
                return;
            }
            if (miUser.getLoggingOff().booleanValue()) {
                PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
                k0.Q(phoneLoginActivity, "确认信息", "账号正在注销审核中，继续登录将会放弃注销", phoneLoginActivity.getString(R.string.cancel), PhoneLoginActivity.this.getString(R.string.cancel_logout), true, new k0.l() { // from class: com.martian.mibook.lib.account.activity.f
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        PhoneLoginActivity.e.this.q(miUser);
                    }
                }, new k0.j() { // from class: com.martian.mibook.lib.account.activity.g
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        PhoneLoginActivity.e.this.s();
                    }
                });
            } else {
                if (!miUser.getWeixinBound()) {
                    PhoneLoginActivity.this.b3(miUser);
                    return;
                }
                PhoneLoginActivity.this.a3(miUser);
                PhoneLoginActivity.this.setResult(-1);
                PhoneLoginActivity.this.k1("登录成功");
                PhoneLoginActivity.this.finish();
            }
        }
    }

    class f implements QQAPIInstance.OnLoginListener {

        class a implements QQAPIInstance.QQUserInfoReceiver {

            /* renamed from: a */
            final /* synthetic */ QQAuth f13737a;

            /* renamed from: com.martian.mibook.lib.account.activity.PhoneLoginActivity$f$a$a */
            class C0267a extends com.martian.mibook.lib.account.d.j {
                C0267a() {
                }

                @Override // b.d.c.c.b
                public void onResultError(b.d.c.b.c errorResult) {
                    PhoneLoginActivity.this.d3("登录失败，请重试" + errorResult.toString(), true);
                }

                @Override // b.d.c.c.b
                /* renamed from: p */
                public void onDataReceived(MiUser miUser) {
                    PhoneLoginActivity.this.a3(miUser);
                    PhoneLoginActivity.this.J.f13824d.setVisibility(8);
                    PhoneLoginActivity.this.k1("登录成功");
                    PhoneLoginActivity.this.setResult(-1);
                    PhoneLoginActivity.this.finish();
                }

                @Override // b.d.c.c.g
                protected void showLoading(boolean show) {
                    if (show) {
                        return;
                    }
                    PhoneLoginActivity.this.J.f13824d.setVisibility(0);
                }
            }

            a(final QQAuth val$auth) {
                this.f13737a = val$auth;
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onCancelled() {
                PhoneLoginActivity.this.d3("登录取消", false);
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onErrorReceived(int errcode, String errStr) {
                PhoneLoginActivity.this.d3("登录失败，请重试" + errStr, true);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onUserInfoReceived(QQUserInfo user) {
                C0267a c0267a = new C0267a();
                ((MiUserRegisterParams) c0267a.k()).setCity(user.getCity());
                ((MiUserRegisterParams) c0267a.k()).setCountry(user.getCountry());
                ((MiUserRegisterParams) c0267a.k()).setQQGender(user.getGender());
                ((MiUserRegisterParams) c0267a.k()).setHeader(user.getHeaderUrl());
                ((MiUserRegisterParams) c0267a.k()).setNickname(user.getNickname());
                ((MiUserRegisterParams) c0267a.k()).setProvince(user.getProvince());
                ((MiUserRegisterParams) c0267a.k()).setQq_openid(this.f13737a.openid);
                ((MiUserRegisterParams) c0267a.k()).setQq_access_token(this.f13737a.access_token);
                ((MiUserRegisterParams) c0267a.k()).setQq_pf(this.f13737a.pf);
                ((MiUserRegisterParams) c0267a.k()).setQq_appid(com.martian.libmars.d.h.F().e0().f9892a);
                c0267a.j();
            }
        }

        f() {
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginCancelled() {
            PhoneLoginActivity.this.d3("登录取消", false);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginError(int errcode, String errStr) {
            PhoneLoginActivity.this.d3("登录失败，请重试" + errStr, true);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginSuccess(final QQAuth auth) {
            QQAPIInstance.getInstance().getUserInfo(PhoneLoginActivity.this, new a(auth));
        }
    }

    class g implements c.InterfaceC0253c {

        /* renamed from: a */
        final /* synthetic */ String f13740a;

        class a extends com.martian.mibook.lib.account.d.p {
            a() {
            }

            @Override // b.d.c.c.b
            public void onResultError(b.d.c.b.c errorResult) {
                PhoneLoginActivity.this.d3("登录失败：" + errorResult.toString(), false);
            }

            @Override // b.d.c.c.b
            /* renamed from: p */
            public void onDataReceived(MiUser miUser) {
                PhoneLoginActivity.this.J.f13824d.setVisibility(8);
                PhoneLoginActivity.this.a3(miUser);
                PhoneLoginActivity.this.k1("登录成功");
                PhoneLoginActivity.this.setResult(-1);
                PhoneLoginActivity.this.finish();
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }
        }

        g(final String val$phone) {
            this.f13740a = val$phone;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void a(String authorizationCode) {
            if (MiUserManager.s().f()) {
                PhoneLoginActivity.this.l3(authorizationCode);
                return;
            }
            a aVar = new a();
            aVar.n();
            ((WXRegisterParams) aVar.k()).setWx_appid(com.martian.libmars.d.h.F().y0().f9577a);
            ((WXRegisterParams) aVar.k()).setWx_code(authorizationCode);
            if (!com.martian.libsupport.k.p(this.f13740a)) {
                ((WXRegisterParams) aVar.k()).setPhone(this.f13740a);
            }
            aVar.j();
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void b(String errStr) {
            PhoneLoginActivity.this.d3("登录失败：" + errStr, false);
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void onLoginCancelled() {
            PhoneLoginActivity.this.d3("登录取消", false);
        }
    }

    class h implements c.InterfaceC0253c {

        /* renamed from: a */
        final /* synthetic */ MiUser f13743a;

        class a extends com.martian.mibook.lib.account.d.q.e {
            a(j1 activity) {
                super(activity);
            }

            @Override // com.martian.mibook.lib.account.d.n
            protected void r(b.d.c.b.c errorResult) {
                PhoneLoginActivity.this.k1("登录失败：" + errorResult.d());
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }

            @Override // b.d.c.c.b
            /* renamed from: u */
            public void onDataReceived(Boolean success) {
                if (success == null || !success.booleanValue()) {
                    PhoneLoginActivity.this.k1("登录失败");
                    return;
                }
                h hVar = h.this;
                PhoneLoginActivity.this.I2(hVar.f13743a);
                PhoneLoginActivity.this.setResult(-1);
                PhoneLoginActivity.this.k1("登录成功");
                PhoneLoginActivity.this.finish();
            }
        }

        h(final MiUser val$miUser) {
            this.f13743a = val$miUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void a(String authorizationCode) {
            a aVar = new a(PhoneLoginActivity.this);
            ((BindWeixinParams) aVar.k()).setWx_code(authorizationCode);
            ((BindWeixinParams) aVar.k()).setWx_appid(com.martian.libmars.d.h.F().y0().f9577a);
            ((BindWeixinParams) aVar.k()).setUid(this.f13743a.getUid());
            ((BindWeixinParams) aVar.k()).setToken(this.f13743a.getToken());
            aVar.j();
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void b(String errStr) {
            PhoneLoginActivity.this.k1("绑定失败：" + errStr);
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void onLoginCancelled() {
            PhoneLoginActivity.this.k1("绑定取消");
        }
    }

    class i extends com.martian.mibook.lib.account.d.q.t {

        /* renamed from: j */
        final /* synthetic */ MiUser f13746j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(j1 activity, final MiUser val$user) {
            super(activity);
            this.f13746j = val$user;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(MiUser miUser) {
            if (miUser != null) {
                PhoneLoginActivity.this.a3(miUser);
                return;
            }
            MiUser miUser2 = this.f13746j;
            if (miUser2 != null) {
                PhoneLoginActivity.this.a3(miUser2);
            }
        }
    }

    class j extends com.martian.mibook.lib.account.d.k {

        /* renamed from: h */
        final /* synthetic */ boolean f13747h;

        j(final boolean val$refresh) {
            this.f13747h = val$refresh;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            PhoneLoginActivity.this.k1(errorResult.toString());
        }

        @Override // b.d.c.c.b
        /* renamed from: p */
        public void onDataReceived(PhoneCodeCaptchaResponse phoneCodeCaptchaResponse) {
            if (phoneCodeCaptchaResponse == null || com.martian.libsupport.k.p(phoneCodeCaptchaResponse.getToken())) {
                return;
            }
            PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
            phoneLoginActivity.c3(phoneLoginActivity.F2(phoneCodeCaptchaResponse.getToken()), this.f13747h);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class k implements Runnable {

        /* renamed from: a */
        public int f13749a = 0;

        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f13749a;
            if (i2 > 0) {
                PhoneLoginActivity.this.n3(i2 - 1);
            }
        }
    }

    public interface l {

        /* renamed from: a */
        public static final int f13751a = 0;

        /* renamed from: b */
        public static final int f13752b = 1;

        /* renamed from: c */
        public static final int f13753c = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B2() {
        d dVar = new d(this);
        ((BindPhoneParams) dVar.k()).setPhone(this.J.f13826f.getText().toString());
        ((BindPhoneParams) dVar.k()).setCode(this.J.f13825e.getText().toString());
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C2() {
        e eVar = new e();
        ((PhoneLoginParams) eVar.k()).setPhone(this.J.f13826f.getText().toString());
        ((PhoneLoginParams) eVar.k()).setCode(this.J.f13825e.getText().toString());
        eVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D2() {
        c cVar = new c(this);
        ((BindPhoneParams) cVar.k()).setPhone(this.J.f13826f.getText().toString());
        ((BindPhoneParams) cVar.k()).setCode(this.J.f13825e.getText().toString());
        cVar.j();
    }

    private boolean E2() {
        if (com.martian.libsupport.k.p(this.J.f13826f.getText().toString())) {
            k1("手机号码不能为空");
            return true;
        }
        if (com.martian.rpauth.d.g.a(this.J.f13826f.getText().toString())) {
            return false;
        }
        k1("错误的手机号格式");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void I2(final MiUser user) {
        i iVar = new i(this, user);
        ((GetUserInfoParams) iVar.k()).setUid(user.getUid());
        ((GetUserInfoParams) iVar.k()).setToken(user.getToken());
        iVar.j();
    }

    private void J2() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.J.f13826f.getWindowToken(), 0);
    }

    /* renamed from: K2 */
    public /* synthetic */ void L2(final MiUser miUser, final DialogFragment fragment, final com.martian.mibook.lib.account.b.d binding, View v) {
        if (!this.K) {
            k1("请先同意用户隐私协议");
            h0.e(binding.f13838e);
            return;
        }
        k1("跳转微信中...");
        if (miUser == null) {
            h3(this.J.f13826f.getText().toString());
        } else {
            g3(miUser);
        }
        if (fragment != null) {
            fragment.dismiss();
        }
    }

    /* renamed from: M2 */
    public /* synthetic */ void N2(final com.martian.mibook.lib.account.b.d binding, View v) {
        boolean z = !this.K;
        this.K = z;
        binding.f13839f.setImageResource(z ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
    }

    /* renamed from: O2 */
    public /* synthetic */ void P2(final DialogFragment fragment, View v) {
        if (fragment != null) {
            this.K = false;
            fragment.dismiss();
        }
    }

    /* renamed from: Q2 */
    public /* synthetic */ void R2(View v) {
        com.martian.mibook.lib.account.e.c.i(this);
    }

    /* renamed from: S2 */
    public /* synthetic */ void T2(View v) {
        com.martian.mibook.lib.account.e.c.f(this);
    }

    /* renamed from: U2 */
    public /* synthetic */ void V2(String text, AlertDialog alertDialog) {
        if (com.martian.libsupport.k.p(text)) {
            k1("验证码不能为空");
            return;
        }
        H2(text);
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: W2 */
    public /* synthetic */ void X2(View v) {
        G2(true);
    }

    /* renamed from: Y2 */
    public /* synthetic */ void Z2() {
        n3(this.M);
    }

    public void a3(final MiUser miUser) {
        if (miUser != null) {
            miUser.setGuest(Boolean.FALSE);
        }
        MartianIUserManager.b().m(miUser);
        m3();
    }

    public void d3(String errorStr, boolean isFinish) {
        this.J.f13824d.setVisibility(8);
        k1(errorStr);
        if (isFinish) {
            finish();
        }
    }

    public void e3(String hintStr) {
        this.J.f13824d.setVisibility(0);
        this.J.f13823c.setText(hintStr);
    }

    public void f3(String title, String desc, String postive) {
        k0.W(this, title, desc, postive, new k0.j() { // from class: com.martian.mibook.lib.account.activity.s
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                PhoneLoginActivity.this.finish();
            }
        }, new k0.l() { // from class: com.martian.mibook.lib.account.activity.a
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                PhoneLoginActivity.this.finish();
            }
        });
    }

    private void g3(final MiUser miUser) {
        if (miUser == null || miUser.getUid() == null) {
            return;
        }
        com.maritan.libweixin.c.g().B(new h(miUser));
    }

    public void i3() {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.lib.account.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                PhoneLoginActivity.this.Z2();
            }
        });
    }

    public static void j3(Activity activity, int phoneType, String verfiyHint, int requestCode) {
        Intent intent = new Intent(activity, (Class<?>) PhoneLoginActivity.class);
        intent.putExtra(F, phoneType);
        intent.putExtra(G, verfiyHint);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l3(String authorizationCode) {
        a aVar = new a(TryWeixinBindParams.class, UserDetail.class, this);
        ((TryWeixinBindParams) aVar.k()).setWx_code(authorizationCode);
        ((TryWeixinBindParams) aVar.k()).setWx_appid(com.martian.libmars.d.h.F().y0().f9577a);
        aVar.j();
    }

    public void n3(final int seconds) {
        this.L.f13749a = seconds;
        this.N = seconds;
        if (seconds <= 0) {
            this.J.f13830j.setText(getString(R.string.get_code));
            return;
        }
        this.J.f13830j.setText("重新发送(" + String.format(Locale.getDefault(), "%02d", Integer.valueOf(seconds)) + "S)");
        this.J.f13830j.removeCallbacks(this.L);
        this.J.f13830j.postDelayed(this.L, 1000L);
    }

    public String F2(String token) {
        StringBuilder sb;
        String str;
        if (com.martian.libmars.d.h.F().Q0()) {
            sb = new StringBuilder();
            str = "http://testcaptcha.qianhongkeji.cn/get_captcha.do?token=";
        } else {
            sb = new StringBuilder();
            str = "http://captcha.qianhongkeji.cn/get_captcha.do?token=";
        }
        sb.append(str);
        sb.append(token);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G2(final boolean refresh) {
        j jVar = new j(refresh);
        ((RequestPhoneCodeCaptchaParams) jVar.k()).setPhone(this.J.f13826f.getText().toString());
        jVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H2(String captcha) {
        b bVar = new b();
        ((RequestPhoneCodeParams) bVar.k()).setPhone(this.J.f13826f.getText().toString());
        if (!com.martian.libsupport.k.p(captcha)) {
            ((RequestPhoneCodeParams) bVar.k()).setCaptcha(captcha);
        }
        bVar.j();
    }

    public void OnLoginClick(View view) {
        if (E2()) {
            return;
        }
        if (com.martian.libsupport.k.p(this.J.f13825e.getText().toString())) {
            k1("验证码不能为空");
            return;
        }
        int i2 = this.H;
        if (i2 == 0) {
            C2();
        } else if (i2 == 1) {
            B2();
        } else if (i2 == 2) {
            D2();
        }
    }

    public void OnPhoneCodeClick(View view) {
        if (E2()) {
            return;
        }
        if (this.N <= 0) {
            H2("");
            return;
        }
        k1(this.N + "秒后重新获取");
    }

    public void OnWxLgoinClick(View view) {
        k0.Q(this, getString(R.string.loading_qq_title), getString(R.string.loading_qq_message), getString(R.string.cancel), getString(R.string.confirm), true, new k0.l() { // from class: com.martian.mibook.lib.account.activity.t
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                PhoneLoginActivity.this.k3();
            }
        }, null);
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b3(final MiUser miUser) {
        View inflate = getLayoutInflater().inflate(R.layout.bind_weixin_dialog, (ViewGroup) null);
        final com.martian.mibook.lib.account.b.d a2 = com.martian.mibook.lib.account.b.d.a(inflate);
        a2.f13836c.setText(getString(R.string.phone_login_bind_wx_hint));
        final com.martian.dialog.e k2 = ((g.a) ((g.a) com.martian.dialog.g.i(this).R(inflate).f(false)).j(true)).k();
        a2.f13835b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginActivity.this.L2(miUser, k2, a2, view);
            }
        });
        a2.f13838e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginActivity.this.N2(a2, view);
            }
        });
        a2.f13837d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginActivity.this.P2(k2, view);
            }
        });
        a2.f13841h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginActivity.this.R2(view);
            }
        });
        a2.f13840g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginActivity.this.T2(view);
            }
        });
    }

    public void c3(String url, boolean refresh) {
        ImageView imageView;
        if (isFinishing() || com.martian.libsupport.k.p(url)) {
            return;
        }
        if (refresh && (imageView = this.O) != null) {
            n0.l(this, url, imageView, R.drawable.image_loading_default_horizontal);
            return;
        }
        ImageView M = k0.M(this, "请输入图形验证码", url, new k0.h() { // from class: com.martian.mibook.lib.account.activity.e
            @Override // com.martian.libmars.utils.k0.h
            public final void a(String str, AlertDialog alertDialog) {
                PhoneLoginActivity.this.V2(str, alertDialog);
            }
        });
        this.O = M;
        if (M != null) {
            M.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhoneLoginActivity.this.X2(view);
                }
            });
        }
    }

    public void h3(final String phone) {
        this.J.f13824d.setVisibility(0);
        com.maritan.libweixin.c.g().B(new g(phone));
    }

    public void k3() {
        this.J.f13824d.setVisibility(0);
        QQAPIInstance.getInstance().startLogin(this, new f());
    }

    public void m3() {
        com.martian.mibook.lib.account.e.c.l(this, null);
        if (this.H == 0) {
            com.martian.mibook.lib.account.e.c.k(this, null);
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MiUserManager.j(requestCode, resultCode, data);
        if (requestCode == PopupLoginActivity.f13754a && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.Z(this, "放弃注销账号");
            k1("请重新登录");
        }
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        p2(false);
        com.martian.mibook.lib.account.b.b c2 = com.martian.mibook.lib.account.b.b.c(getLayoutInflater());
        this.J = c2;
        setContentView(c2.getRoot());
        if (savedInstanceState != null) {
            this.H = savedInstanceState.getInt(F, 0);
            this.I = savedInstanceState.getString(G, "");
        } else {
            this.H = getIntent().getIntExtra(F, 0);
            this.I = getIntent().getStringExtra(G);
        }
        this.J.f13827g.setPadding(0, F0(), 0, 0);
        int i2 = this.H;
        if (i2 == 0) {
            this.J.f13828h.setText(getString(R.string.phone_login_hint));
        } else if (i2 == 1) {
            this.J.f13828h.setText(getString(R.string.phone_bind));
        } else if (i2 == 2) {
            this.J.f13828h.setText(getString(R.string.phone_verify));
        }
        if (this.H != 2 || com.martian.libsupport.k.p(this.I)) {
            this.J.f13822b.setVisibility(8);
        } else {
            this.J.f13822b.setVisibility(0);
            this.J.f13822b.setText(this.I);
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        J2();
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(F, this.H);
        outState.putString(G, this.I);
    }
}
