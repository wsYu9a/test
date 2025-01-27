package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libqq.QQAPIInstance;
import com.martian.libqq.QQAuth;
import com.martian.libqq.QQUserInfo;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.databinding.ActivityLoginWindowBinding;
import com.martian.mibook.lib.account.request.MiGuestUserLoginParams;
import com.martian.mibook.lib.account.request.MiUserRegisterParams;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianIUserManager;
import java.util.List;
import jb.e;
import jb.h;
import l9.i0;
import lb.c;

@Route(path = kc.a.f27746b)
/* loaded from: classes3.dex */
public class PopupLoginActivity extends FragmentActivity {

    /* renamed from: f */
    public static int f13884f = 10001;

    /* renamed from: b */
    public ActivityLoginWindowBinding f13885b;

    /* renamed from: c */
    public PopupWindow f13886c;

    /* renamed from: d */
    public boolean f13887d = false;

    /* renamed from: e */
    public int f13888e = 0;

    public class a implements i0.m {
        public a() {
        }

        @Override // l9.i0.m
        public void a() {
            lb.c.n(PopupLoginActivity.this);
        }

        @Override // l9.i0.m
        public void b() {
            lb.c.q(PopupLoginActivity.this);
        }

        @Override // l9.i0.m
        public void c() {
        }

        @Override // l9.i0.m
        public void d() {
            PopupLoginActivity.this.f13887d = true;
            PopupLoginActivity.this.f13885b.f13906e.setImageResource(R.drawable.icon_checked);
            PopupLoginActivity.this.f13885b.f13905d.performClick();
        }

        @Override // l9.i0.m
        public void e() {
        }
    }

    public class b implements QQAPIInstance.OnLoginListener {

        public class a implements QQAPIInstance.QQUserInfoReceiver {

            /* renamed from: a */
            public final /* synthetic */ QQAuth f13891a;

            /* renamed from: com.martian.mibook.lib.account.activity.PopupLoginActivity$b$a$a */
            public class C0530a extends h {
                public C0530a() {
                }

                @Override // y8.a
                public void onResultError(x8.c cVar) {
                    PopupLoginActivity.this.m1("登录失败，请重试" + cVar.toString(), true);
                }

                @Override // y8.a
                /* renamed from: q */
                public void onDataReceived(MiUser miUser) {
                    if (PopupLoginActivity.this.isFinishing() || PopupLoginActivity.this.isDestroyed()) {
                        return;
                    }
                    PopupLoginActivity.this.l1(miUser);
                    PopupLoginActivity.this.f13885b.f13908g.setVisibility(8);
                    PopupLoginActivity.this.k1();
                }

                @Override // y8.f
                public void showLoading(boolean z10) {
                    if (PopupLoginActivity.this.isFinishing() || PopupLoginActivity.this.isDestroyed() || z10) {
                        return;
                    }
                    PopupLoginActivity.this.f13885b.f13908g.setVisibility(0);
                }
            }

            public a(QQAuth qQAuth) {
                this.f13891a = qQAuth;
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onCancelled() {
                PopupLoginActivity.this.m1("登录取消", false);
            }

            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onErrorReceived(int i10, String str) {
                PopupLoginActivity.this.m1("登录失败，请重试" + str, true);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.martian.libqq.QQAPIInstance.QQUserInfoReceiver
            public void onUserInfoReceived(QQUserInfo qQUserInfo) {
                C0530a c0530a = new C0530a();
                ((MiUserRegisterParams) c0530a.k()).setCity(qQUserInfo.getCity());
                ((MiUserRegisterParams) c0530a.k()).setCountry(qQUserInfo.getCountry());
                ((MiUserRegisterParams) c0530a.k()).setQQGender(qQUserInfo.getGender());
                ((MiUserRegisterParams) c0530a.k()).setHeader(qQUserInfo.getHeaderUrl());
                ((MiUserRegisterParams) c0530a.k()).setNickname(qQUserInfo.getNickname());
                ((MiUserRegisterParams) c0530a.k()).setProvince(qQUserInfo.getProvince());
                ((MiUserRegisterParams) c0530a.k()).setQq_openid(this.f13891a.openid);
                ((MiUserRegisterParams) c0530a.k()).setQq_access_token(this.f13891a.access_token);
                ((MiUserRegisterParams) c0530a.k()).setQq_pf(this.f13891a.f12908pf);
                c0530a.j();
            }
        }

        public b() {
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginCancelled() {
            PopupLoginActivity.this.m1("登录取消", false);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginError(int i10, String str) {
            PopupLoginActivity.this.m1("登录失败，请重试" + str, true);
        }

        @Override // com.martian.libqq.QQAPIInstance.OnLoginListener
        public void onLoginSuccess(QQAuth qQAuth) {
            QQAPIInstance.getInstance().getUserInfo(PopupLoginActivity.this, new a(qQAuth));
        }
    }

    public class c implements c.h {
        public c() {
        }

        @Override // lb.c.h
        public void a(MiUser miUser) {
            PopupLoginActivity.this.l1(miUser);
            PopupLoginActivity.this.k1();
        }

        @Override // lb.c.h
        public void b(boolean z10) {
            if (PopupLoginActivity.this.isFinishing() || PopupLoginActivity.this.isDestroyed()) {
                return;
            }
            PopupLoginActivity.this.f13885b.f13908g.setVisibility(z10 ? 0 : 8);
        }

        @Override // lb.c.h
        public void onResultError(x8.c cVar) {
            PopupLoginActivity.this.m1(cVar.d(), true);
        }
    }

    public /* synthetic */ void h1(View view) {
        if (this.f13887d) {
            s1();
        } else {
            n1();
        }
    }

    public /* synthetic */ void i1(View view) {
        if (!this.f13887d) {
            o1("请先同意用户隐私协议");
            l9.a.f(this.f13885b.f13903b);
        } else {
            PhoneLoginActivity.y3(this, 0, "", 20003);
            setResult(-1);
            finish();
        }
    }

    public void k1() {
        e9.c.e(e9.d.f25790b, null);
        o1("登录成功");
        setResult(-1);
        ConfigSingleton.D().g1(lb.c.f28067a, true);
        finish();
    }

    public void m1(String str, boolean z10) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.f13885b.f13908g.setVisibility(8);
        o1(ConfigSingleton.D().s(str));
        if (z10) {
            finish();
        }
    }

    public static void p1(Activity activity) {
        q1(activity, 10001, false);
    }

    public static void q1(Activity activity, int i10, boolean z10) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(ConfigSingleton.D(), (Class<?>) PopupLoginActivity.class);
        intent.putExtra(MiUserManager.f13854j, i10);
        intent.putExtra(MiUserManager.f13855k, z10);
        activity.startActivityForResult(intent, i10);
    }

    public final /* synthetic */ void j1(View view) {
        boolean z10 = !this.f13887d;
        this.f13887d = z10;
        this.f13885b.f13906e.setImageResource(z10 ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        if (this.f13887d) {
            this.f13885b.f13906e.clearAnimation();
        }
    }

    public final void l1(me.b bVar) {
        if (bVar instanceof MiUser) {
            ((MiUser) bVar).setGuest(Boolean.FALSE);
        }
        if (MartianIUserManager.b() != null) {
            MartianIUserManager.b().l(bVar);
        }
        lb.c.w(this, null);
        lb.c.x(this, null);
    }

    public final void n1() {
        i0.E0(this, getString(com.martian.mibook.lib.account.R.string.app_name), new a());
    }

    public void o1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.unknown_error);
        }
        Toast.makeText(this, str, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        MiUserManager.x(i10, i11, intent);
        super.onActivityResult(i10, i11, intent);
        if (i10 == f13884f) {
            ac.a.P(this, "放弃注销账号");
            o1("请重新登录");
            finish();
        }
        t1();
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityLoginWindowBinding c10 = ActivityLoginWindowBinding.c(getLayoutInflater());
        this.f13885b = c10;
        setContentView(c10.getRoot());
        getWindow().setLayout(-1, -1);
        com.gyf.immersionbar.d.q3(this).W0(BarHide.FLAG_HIDE_BAR).a1();
        if (bundle != null) {
            this.f13888e = bundle.getInt(MiUserManager.f13854j);
            this.f13887d = bundle.getBoolean(MiUserManager.f13855k, false);
        } else {
            this.f13888e = getIntent().getIntExtra(MiUserManager.f13854j, 0);
            this.f13887d = getIntent().getBooleanExtra(MiUserManager.f13855k, false);
        }
        this.f13885b.f13905d.setOnClickListener(new View.OnClickListener() { // from class: ib.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.h1(view);
            }
        });
        this.f13885b.f13904c.setOnClickListener(new View.OnClickListener() { // from class: ib.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.i1(view);
            }
        });
        this.f13885b.f13903b.setOnClickListener(new View.OnClickListener() { // from class: ib.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupLoginActivity.this.j1(view);
            }
        });
        int i10 = this.f13888e;
        if (i10 == 202) {
            this.f13887d = true;
            this.f13885b.f13906e.setImageResource(R.drawable.icon_checked);
            this.f13885b.f13904c.setVisibility(8);
        } else if (i10 == 200) {
            this.f13885b.f13906e.setImageResource(R.drawable.icon_checked);
            s1();
        } else if (i10 == 201) {
            r1();
        } else {
            this.f13885b.f13906e.setImageResource(this.f13887d ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.f13886c;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f13886c = null;
        }
    }

    public void onPrivacyClick(View view) {
        lb.c.n(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MiUserManager.f13854j, this.f13888e);
        bundle.putBoolean(MiUserManager.f13855k, this.f13887d);
    }

    public void onUserAgreementClick(View view) {
        lb.c.q(this);
    }

    public void r1() {
        this.f13885b.f13908g.setVisibility(0);
        QQAPIInstance.getInstance().startLogin(this, new b());
    }

    public void s1() {
        lb.c.k(this, "", new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t1() {
        if (MartianIUserManager.b() == null || MartianIUserManager.b().f()) {
            return;
        }
        d dVar = new d(MiGuestUserLoginParams.class, MiUser.class, this);
        ((MiGuestUserLoginParams) dVar.k()).setOaid(ConfigSingleton.D().M());
        ((MiGuestUserLoginParams) dVar.k()).setAndroid_id(ConfigSingleton.D().j());
        ((MiGuestUserLoginParams) dVar.k()).setImei(ConfigSingleton.D().A());
        dVar.j();
    }

    public class d extends e<MiGuestUserLoginParams, MiUser> {
        public d(Class cls, Class cls2, Context context) {
            super(cls, cls2, context);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<MiUser> list) {
            if (list == null || list.isEmpty() || list.get(0) == null) {
                return;
            }
            PopupLoginActivity.this.l1(list.get(0));
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }
    }
}
