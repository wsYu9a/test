package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.databinding.ActivityWechatLoginBinding;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.rpauth.MartianIUserManager;
import e9.d;
import l9.i0;
import lb.c;

/* loaded from: classes3.dex */
public class WechatLoginActivity extends MiBackableActivity {
    public static int E = 10001;
    public ActivityWechatLoginBinding A;
    public PopupWindow B;
    public boolean C = false;
    public int D = 0;

    public class a implements i0.m {
        public a() {
        }

        @Override // l9.i0.m
        public void a() {
            c.n(WechatLoginActivity.this);
        }

        @Override // l9.i0.m
        public void b() {
            c.q(WechatLoginActivity.this);
        }

        @Override // l9.i0.m
        public void c() {
        }

        @Override // l9.i0.m
        public void d() {
            WechatLoginActivity.this.A.f13923c.setImageResource(R.drawable.icon_checked);
            WechatLoginActivity.this.V2();
        }

        @Override // l9.i0.m
        public void e() {
        }
    }

    public class b implements c.h {
        public b() {
        }

        @Override // lb.c.h
        public void a(MiUser miUser) {
            WechatLoginActivity.this.Q2(miUser);
            WechatLoginActivity.this.P2();
        }

        @Override // lb.c.h
        public void b(boolean z10) {
            if (WechatLoginActivity.this.isFinishing() || WechatLoginActivity.this.isDestroyed()) {
                return;
            }
            WechatLoginActivity wechatLoginActivity = WechatLoginActivity.this;
            wechatLoginActivity.y(z10, wechatLoginActivity.getResources().getString(com.martian.mibook.lib.account.R.string.wechat_login_loading));
        }

        @Override // lb.c.h
        public void onResultError(x8.c cVar) {
            WechatLoginActivity.this.R2(cVar.d());
        }
    }

    public void R2(String str) {
        P1(str);
        finish();
    }

    public static void T2(Activity activity) {
        U2(activity, 10001, false);
    }

    public static void U2(Activity activity, int i10, boolean z10) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) WechatLoginActivity.class);
        intent.putExtra(MiUserManager.f13854j, i10);
        intent.putExtra(MiUserManager.f13855k, z10);
        activity.startActivityForResult(intent, i10);
    }

    public final void P2() {
        e9.c.e(d.f25790b, null);
        P1("登录成功");
        setResult(-1);
        ConfigSingleton.D().g1(c.f28067a, true);
        finish();
    }

    public final void Q2(me.b bVar) {
        if (bVar instanceof MiUser) {
            ((MiUser) bVar).setGuest(Boolean.FALSE);
        }
        if (MartianIUserManager.b() != null) {
            MartianIUserManager.b().l(bVar);
        }
        c.w(this, null);
        c.x(this, null);
    }

    public final void S2() {
        i0.E0(this, getString(com.martian.mibook.lib.account.R.string.app_name), new a());
    }

    public void V2() {
        c.k(this, "", new b());
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        MiUserManager.x(i10, i11, intent);
        super.onActivityResult(i10, i11, intent);
        if (i10 == E) {
            ac.a.P(this, "放弃注销账号");
            P1("请重新登录");
            finish();
        }
    }

    public void onCloseClick(View view) {
        finish();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_pop_in, R.anim.activity_fade_out);
        J2(false);
        ActivityWechatLoginBinding c10 = ActivityWechatLoginBinding.c(getLayoutInflater());
        this.A = c10;
        setContentView(c10.getRoot());
        if (bundle != null) {
            this.D = bundle.getInt(MiUserManager.f13854j);
            this.C = bundle.getBoolean(MiUserManager.f13855k, false);
        } else {
            this.D = getIntent().getIntExtra(MiUserManager.f13854j, 0);
            this.C = getIntent().getBooleanExtra(MiUserManager.f13855k, false);
        }
        this.A.f13930j.setPadding(0, p1(), 0, 0);
        int i10 = this.D;
        if (i10 == 202) {
            this.C = true;
            this.A.f13923c.setImageResource(R.drawable.icon_checked);
            this.A.f13928h.setVisibility(8);
        } else if (i10 != 200) {
            this.A.f13923c.setImageResource(this.C ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        } else {
            this.A.f13923c.setImageResource(R.drawable.icon_checked);
            V2();
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.B;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.B = null;
        }
    }

    public void onIntimateClick(View view) {
        boolean z10 = !this.C;
        this.C = z10;
        this.A.f13923c.setImageResource(z10 ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
        if (this.C) {
            this.A.f13923c.clearAnimation();
        }
    }

    public void onPhoneLoginClick(View view) {
        PhoneLoginActivity.y3(this, 0, "", 20003);
        setResult(-1);
        finish();
    }

    public void onPrivacyClick(View view) {
        c.n(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MiUserManager.f13854j, this.D);
        bundle.putBoolean(MiUserManager.f13855k, this.C);
    }

    public void onUserAgreementClick(View view) {
        c.q(this);
    }

    public void onWechatLoginClick(View view) {
        if (this.C) {
            V2();
        } else {
            S2();
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }
}
