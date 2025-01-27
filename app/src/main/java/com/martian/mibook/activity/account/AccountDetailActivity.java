package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.activity.SettingActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.p4;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class AccountDetailActivity extends com.martian.mibook.lib.model.b.a {
    private com.martian.mibook.e.b F;

    class a implements c.e {
        a() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            AccountDetailActivity.this.B2();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void B2() {
        Resources resources;
        int i2;
        MiUser C4 = MiConfigSingleton.V3().C4();
        if (C4 == null) {
            return;
        }
        n0.l(this, C4.getHeader(), this.F.f11718c, R.drawable.icon_header);
        if (!TextUtils.isEmpty(C4.getNickname())) {
            this.F.f11719d.setText(C4.getNickname());
        }
        if (C4.getGender() != null) {
            TextView textView = this.F.f11721f;
            if (C4.getGender().equals('M')) {
                resources = getResources();
                i2 = R.string.man;
            } else if (C4.getGender().equals('F')) {
                resources = getResources();
                i2 = R.string.woman;
            } else {
                resources = getResources();
                i2 = R.string.others_recommend;
            }
            textView.setText(resources.getString(i2));
        }
        if (com.martian.libsupport.k.p(C4.getUid().toString())) {
            return;
        }
        this.F.f11724i.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + C4.getUid().toString());
    }

    private void C2() {
        p4 d2 = p4.d((LayoutInflater) getSystemService("layout_inflater"), null, false);
        final PopupWindow e2 = k0.e(this, d2.getRoot(), true, 80);
        d2.f12526d.setText(getString(R.string.account_security_logout));
        d2.f12525c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountDetailActivity.this.w2(e2, view);
            }
        });
        d2.f12524b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e2.dismiss();
            }
        });
    }

    private void D2() {
        p4 d2 = p4.d((LayoutInflater) getSystemService("layout_inflater"), null, false);
        final PopupWindow e2 = k0.e(this, d2.getRoot(), true, 80);
        d2.f12525c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountDetailActivity.this.z2(e2, view);
            }
        });
        d2.f12524b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e2.dismiss();
            }
        });
    }

    public void E2() {
        k1("退出登录成功");
        com.martian.mibook.lib.model.g.b.a0(this, "退出登录");
        setResult(-1);
        MiConfigSingleton.V3().t6(this, new MiCompoundUserManager.e() { // from class: com.martian.mibook.activity.account.w
            @Override // com.martian.mibook.account.MiCompoundUserManager.e
            public final void a() {
                AccountDetailActivity.this.finish();
            }
        });
    }

    /* renamed from: t2 */
    public /* synthetic */ boolean u2(View v) {
        if (!com.martian.libmars.d.h.F().Q0() || !MiConfigSingleton.V3().x5()) {
            return true;
        }
        com.martian.rpauth.b h2 = MiConfigSingleton.V3().M4.h();
        h2.setUid(Long.valueOf(MartianRPUserManager.t()));
        MiConfigSingleton.V3().M4.C(h2);
        com.martian.mibook.lib.account.e.c.k(this, new a());
        return true;
    }

    /* renamed from: v2 */
    public /* synthetic */ void w2(final PopupWindow window, View v) {
        if (window != null) {
            window.dismiss();
        }
        com.martian.mibook.lib.model.g.b.a0(this, "注销账号");
        MiWebViewActivity.d4(this, com.martian.libmars.d.h.F().N(), false, SettingActivity.F);
    }

    /* renamed from: y2 */
    public /* synthetic */ void z2(final PopupWindow window, View v) {
        if (window != null) {
            window.dismiss();
        }
        k0.P(this, getString(R.string.logout), getString(R.string.logout_hint), new k0.l() { // from class: com.martian.mibook.activity.account.e
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                AccountDetailActivity.this.E2();
            }
        });
    }

    public void onAccountLogOffClick(View view) {
        C2();
    }

    public void onAccountSecurityClick(View view) {
        D2();
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        MiTaskAccount x4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        com.martian.mibook.e.b a2 = com.martian.mibook.e.b.a(g2());
        this.F = a2;
        a2.f11718c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.account.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AccountDetailActivity.this.u2(view);
            }
        });
        if (MiConfigSingleton.V3().x5() && (x4 = MiConfigSingleton.V3().x4()) != null && x4.getTotalReadingCoins().intValue() > 0) {
            this.F.f11723h.setVisibility(0);
            this.F.f11723h.setText(getString(R.string.read_total_duration) + x4.getTotalReadingCoins() + "金币");
        }
        B2();
    }
}
