package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.maritan.libweixin.c;
import com.martian.libmars.utils.h0;
import com.martian.libmars.utils.k0;
import com.martian.libqq.QQAPIInstance;
import com.martian.libqq.QQAuth;
import com.martian.libqq.QQUserInfo;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.d.q.d0;
import com.martian.mibook.lib.account.request.MiUserRegisterParams;
import com.martian.mibook.lib.account.request.WXRegisterParams;
import com.martian.mibook.lib.account.request.auth.TryWeixinBindParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.UserDetail;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;

/* loaded from: classes.dex */
public class PopupLoginActivity extends FragmentActivity {

    /* renamed from: a */
    public static int f13754a = 10001;

    /* renamed from: c */
    private MartianIUserManager f13756c;

    /* renamed from: d */
    private com.martian.mibook.lib.account.b.a f13757d;

    /* renamed from: b */
    private int f13755b = 0;

    /* renamed from: e */
    private boolean f13758e = false;

    /* loaded from: classes3.dex */
    class a implements QQAPIInstance.OnLoginListener {

        /* renamed from: com.martian.mibook.lib.account.activity.PopupLoginActivity$a$a */
        class C0268a implements QQAPIInstance.QQUserInfoReceiver {

            /* renamed from: a */
            final /* synthetic */ QQAuth f13760a;

            /* renamed from: com.martian.mibook.lib.account.activity.PopupLoginActivity$a$a$a */
            class C0269a extends com.martian.mibook.lib.account.d.j {
                C0269a() {
                }

                @Override // b.d.c.c.b
                public void onResultError(b.d.c.b.c errorResult) {
                    PopupLoginActivity.this.u0("登录失败，请重试" + errorResult.toString(), true);
                }

                @Override // b.d.c.c.b
                /* renamed from: p */
                public void onDataReceived(MiUser miUser) {
                    PopupLoginActivity.this.s0(miUser);
                    PopupLoginActivity.this.f13757d.f13818g.setVisibility(8);
                    PopupLoginActivity.this.r0();
                }

                @Override // b.d.c.c.g
                protected void showLoading(boolean show) {
                    if (show) {
                        return;
                    }
                    PopupLoginActivity.this.f13757d.f13818g.setVisibility(0);
                }
            }

            C0268a(final QQAuth val$auth) {
                this.f13760a = val$auth;
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onCancelled() {
                PopupLoginActivity.this.u0("登录取消", false);
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onErrorReceived(int errcode, String errStr) {
                PopupLoginActivity.this.u0("登录失败，请重试" + errStr, true);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onUserInfoReceived(QQUserInfo user) {
                C0269a c0269a = new C0269a();
                ((MiUserRegisterParams) c0269a.k()).setCity(user.getCity());
                ((MiUserRegisterParams) c0269a.k()).setCountry(user.getCountry());
                ((MiUserRegisterParams) c0269a.k()).setQQGender(user.getGender());
                ((MiUserRegisterParams) c0269a.k()).setHeader(user.getHeaderUrl());
                ((MiUserRegisterParams) c0269a.k()).setNickname(user.getNickname());
                ((MiUserRegisterParams) c0269a.k()).setProvince(user.getProvince());
                ((MiUserRegisterParams) c0269a.k()).setQq_openid(this.f13760a.openid);
                ((MiUserRegisterParams) c0269a.k()).setQq_access_token(this.f13760a.access_token);
                ((MiUserRegisterParams) c0269a.k()).setQq_pf(this.f13760a.pf);
                c0269a.j();
            }
        }

        a() {
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginCancelled() {
            PopupLoginActivity.this.u0("登录取消", false);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginError(int errcode, String errStr) {
            PopupLoginActivity.this.u0("登录失败，请重试" + errStr, true);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginSuccess(final QQAuth auth) {
            QQAPIInstance.getInstance().getUserInfo(PopupLoginActivity.this, new C0268a(auth));
        }
    }

    /* loaded from: classes3.dex */
    class b implements c.InterfaceC0253c {

        class a extends com.martian.mibook.lib.account.d.p {
            a() {
            }

            @Override // b.d.c.c.b
            public void onResultError(b.d.c.b.c errorResult) {
                PopupLoginActivity.this.u0("登录失败，请重试" + errorResult.toString(), true);
            }

            @Override // b.d.c.c.b
            /* renamed from: p */
            public void onDataReceived(MiUser miUser) {
                PopupLoginActivity.this.f13757d.f13818g.setVisibility(8);
                if (miUser.getLoggingOff().booleanValue()) {
                    PopupLoginActivity.this.t0(miUser);
                } else {
                    PopupLoginActivity.this.s0(miUser);
                    PopupLoginActivity.this.r0();
                }
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
                if (show) {
                    return;
                }
                PopupLoginActivity.this.f13757d.f13818g.setVisibility(0);
            }
        }

        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void a(String authorizationCode) {
            if (MiUserManager.s().f()) {
                PopupLoginActivity.this.z0(authorizationCode);
                return;
            }
            a aVar = new a();
            aVar.n();
            ((WXRegisterParams) aVar.k()).setWx_appid(com.martian.libmars.d.h.F().y0().f9577a);
            ((WXRegisterParams) aVar.k()).setWx_code(authorizationCode);
            aVar.j();
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void b(String errStr) {
            PopupLoginActivity.this.u0("登录失败，请重试" + errStr, true);
        }

        @Override // com.maritan.libweixin.c.InterfaceC0253c
        public void onLoginCancelled() {
            PopupLoginActivity.this.u0("登录取消", false);
        }
    }

    /* loaded from: classes3.dex */
    class c extends d0<TryWeixinBindParams, UserDetail> {
        c(Class aClass, Class dataType, Activity activity) {
            super(aClass, dataType, activity);
        }

        @Override // com.martian.mibook.lib.account.d.q.d0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            PopupLoginActivity.this.u0("登录失败，请重试" + errorResult.toString(), true);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<UserDetail> userDetails) {
            PopupLoginActivity.this.f13757d.f13818g.setVisibility(8);
            if (userDetails == null || userDetails.isEmpty()) {
                PopupLoginActivity.this.v0("登录失败");
                PopupLoginActivity.this.finish();
                return;
            }
            UserDetail userDetail = userDetails.get(0);
            MiUser userInfo = userDetail.getUserInfo();
            MiTaskAccount taskAccount = userDetail.getTaskAccount();
            MartianRPAccount account = userDetail.getAccount();
            if (userInfo == null) {
                PopupLoginActivity.this.finish();
                return;
            }
            if (userInfo.getLoggingOff().booleanValue()) {
                PopupLoginActivity.this.t0(userInfo);
                return;
            }
            if (!userInfo.getUid().equals(MiUserManager.s().e().getUid())) {
                PopupLoginActivity.this.f13757d.f13817f.setVisibility(4);
                com.martian.mibook.lib.account.e.d.e(PopupLoginActivity.this, userInfo, taskAccount, account);
                return;
            }
            PopupLoginActivity.this.s0(userInfo);
            if (taskAccount != null) {
                MiUserManager.s().l(taskAccount);
            }
            if (account != null && MartianIUserManager.b() != null) {
                MartianIUserManager.b().k(account);
            }
            PopupLoginActivity.this.r0();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                PopupLoginActivity.this.f13757d.f13818g.setVisibility(0);
            }
        }
    }

    /* renamed from: B */
    public /* synthetic */ void C(View v) {
        if (this.f13758e) {
            A0();
        } else {
            v0("请先同意用户隐私协议");
            h0.e(this.f13757d.f13813b);
        }
    }

    private void B0() {
        if (com.martian.libmars.d.h.F().M() <= 0) {
            com.martian.libmars.d.h.F().s1((int) (System.currentTimeMillis() % 12000));
        }
        if (this.f13758e) {
            this.f13757d.f13816e.setImageResource(R.drawable.icon_checked);
        }
    }

    /* renamed from: D */
    public /* synthetic */ void E(View v) {
        if (!this.f13758e) {
            v0("请先同意用户隐私协议");
            h0.e(this.f13757d.f13813b);
        } else {
            PhoneLoginActivity.j3(this, 0, "", 20003);
            setResult(-1);
            finish();
        }
    }

    /* renamed from: F */
    public /* synthetic */ void G(View v) {
        boolean z = !this.f13758e;
        this.f13758e = z;
        this.f13757d.f13816e.setImageResource(z ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        if (this.f13758e) {
            this.f13757d.f13816e.clearAnimation();
        }
    }

    /* renamed from: H */
    public /* synthetic */ void I(final MiUser miUser) {
        MiWebViewBaseActivity.h4(this, com.martian.libmars.d.h.F().l(), miUser.getUid().toString(), miUser.getToken(), com.martian.libmars.d.h.F().f().f9879a, f13754a);
    }

    /* renamed from: p0 */
    public /* synthetic */ void q0() {
        v0("登录取消");
        finish();
    }

    public void r0() {
        v0("登录成功");
        setResult(-1);
        finish();
    }

    public void s0(final com.martian.rpauth.b miUser) {
        if (miUser instanceof MiUser) {
            ((MiUser) miUser).setGuest(Boolean.FALSE);
        }
        MartianIUserManager martianIUserManager = this.f13756c;
        if (martianIUserManager != null) {
            martianIUserManager.m(miUser);
        }
        com.martian.mibook.lib.account.e.c.k(this, null);
        com.martian.mibook.lib.account.e.c.l(this, null);
    }

    public void t0(final MiUser miUser) {
        k0.Q(this, getString(R.string.confirm_message), "该账号正在注销审核中，继续登录将会放弃注销", getString(R.string.cancel), getString(R.string.cancel_logout), true, new k0.l() { // from class: com.martian.mibook.lib.account.activity.n
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                PopupLoginActivity.this.I(miUser);
            }
        }, new k0.j() { // from class: com.martian.mibook.lib.account.activity.p
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                PopupLoginActivity.this.q0();
            }
        });
    }

    public void u0(String errorStr, boolean isFinish) {
        this.f13757d.f13818g.setVisibility(8);
        v0(errorStr);
        if (isFinish) {
            finish();
        }
    }

    public static void w0(Activity activity) {
        x0(activity, 10001, false);
    }

    public static void x0(Activity activity, int loginType, boolean checked) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) PopupLoginActivity.class);
        intent.putExtra(MiUserManager.s, loginType);
        intent.putExtra(MiUserManager.t, checked);
        activity.startActivityForResult(intent, loginType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z0(String authorizationCode) {
        c cVar = new c(TryWeixinBindParams.class, UserDetail.class, this);
        ((TryWeixinBindParams) cVar.k()).setWx_code(authorizationCode);
        ((TryWeixinBindParams) cVar.k()).setWx_appid(com.martian.libmars.d.h.F().y0().f9577a);
        cVar.j();
    }

    public void A0() {
        if (com.martian.apptask.g.g.g(this, "com.tencent.mm")) {
            com.maritan.libweixin.c.g().B(new b());
        } else {
            v0("请先安装微信");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        MiUserManager.j(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == f13754a) {
            com.martian.mibook.lib.model.g.b.Z(this, "放弃注销账号");
            v0("请重新登录");
            finish();
        }
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.martian.mibook.lib.account.b.a c2 = com.martian.mibook.lib.account.b.a.c(getLayoutInflater());
        this.f13757d = c2;
        setContentView(c2.getRoot());
        getWindow().setLayout(-1, -1);
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
        if (savedInstanceState != null) {
            this.f13755b = savedInstanceState.getInt(MiUserManager.s);
            this.f13758e = savedInstanceState.getBoolean(MiUserManager.t, false);
        } else {
            this.f13755b = getIntent().getIntExtra(MiUserManager.s, 0);
            this.f13758e = getIntent().getBooleanExtra(MiUserManager.t, false);
        }
        this.f13757d.f13815d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.C(view);
            }
        });
        this.f13757d.f13814c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.E(view);
            }
        });
        this.f13757d.f13813b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.activity.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.G(view);
            }
        });
        this.f13756c = MartianIUserManager.b();
        int i2 = this.f13755b;
        if (i2 == 202) {
            this.f13758e = true;
            this.f13757d.f13816e.setImageResource(R.drawable.icon_checked);
            this.f13757d.f13814c.setVisibility(8);
        } else if (i2 == 200) {
            this.f13757d.f13816e.setImageResource(R.drawable.icon_checked);
            A0();
            return;
        } else if (i2 == 201) {
            y0();
            return;
        }
        B0();
    }

    public void onPrivacyClick(View view) {
        com.martian.mibook.lib.account.e.c.f(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MiUserManager.s, this.f13755b);
    }

    public void onUserAgreementClick(View view) {
        com.martian.mibook.lib.account.e.c.i(this);
    }

    public void v0(String msg) {
        if (TextUtils.isEmpty(msg)) {
            msg = getString(R.string.unknown_error);
        }
        Toast.makeText(this, msg, 0).show();
    }

    public void y0() {
        this.f13757d.f13818g.setVisibility(0);
        QQAPIInstance.getInstance().startLogin(this, new a());
    }
}
