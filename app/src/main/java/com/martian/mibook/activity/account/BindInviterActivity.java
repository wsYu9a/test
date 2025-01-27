package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.martian.libmars.activity.j1;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.WeixinGroupFollowActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.request.auth.BindInviterParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class BindInviterActivity extends com.martian.mibook.lib.model.b.a {
    private com.martian.mibook.e.f F;

    class a extends com.martian.mibook.lib.account.d.q.c {
        a(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            BindInviterActivity.this.k1(errorResult.toString());
            BindInviterActivity.this.s2();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ExchangeMoney exchangeMoney) {
            if (exchangeMoney == null) {
                BindInviterActivity.this.k1("拜师失败");
                return;
            }
            BindInviterActivity.this.v2();
            BindInviterActivity.this.x2(true);
            BonusDetailActivity.E3(BindInviterActivity.this, "拜师", exchangeMoney.getMoney(), exchangeMoney.getCoins().intValue(), 0, exchangeMoney.getExtraId().longValue(), exchangeMoney.getExtraCoins().intValue());
            MiConfigSingleton.V3().x7(true);
        }
    }

    class b extends com.martian.mibook.lib.account.d.q.w {
        b(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            BindInviterActivity.this.x2(false);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean hasInviter) {
            if (hasInviter == null) {
                BindInviterActivity.this.x2(false);
                return;
            }
            BindInviterActivity.this.x2(hasInviter.booleanValue());
            MiConfigSingleton.V3().x7(hasInviter.booleanValue());
            BindInviterActivity.this.setResult(-1);
        }
    }

    /* renamed from: t2 */
    public /* synthetic */ void u2(final boolean hasInviter) {
        if (hasInviter) {
            this.F.f11925b.setVisibility(8);
            this.F.f11926c.setVisibility(0);
        } else {
            this.F.f11925b.setVisibility(0);
            this.F.f11926c.setVisibility(8);
        }
    }

    public void OnBindInviterClick(View view) {
        r2();
    }

    public void OnGetInviterClick(View view) {
        startActivity(WeixinGroupFollowActivity.class);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_inviter);
        this.F = com.martian.mibook.e.f.a(g2());
        w2();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        s2.n(this, this.F.f11928e);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        s2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r2() {
        s2.n(this, this.F.f11928e);
        if (!MiConfigSingleton.V3().x5()) {
            com.martian.mibook.lib.account.e.d.a(this);
            k1("请先登录");
        } else {
            if (com.martian.libsupport.k.p(this.F.f11928e.getText().toString())) {
                k1("邀请码不能为空");
                return;
            }
            a aVar = new a(this);
            ((BindInviterParams) aVar.k()).setInviteCode(this.F.f11928e.getText().toString());
            aVar.j();
        }
    }

    public void s2() {
        if (MiConfigSingleton.V3().x5()) {
            new b(this).j();
        }
    }

    public void v2() {
        com.martian.mibook.lib.account.e.c.l(this, null);
    }

    @SuppressLint({"SetTextI18n"})
    public void w2() {
        if (!MiConfigSingleton.V3().x5()) {
            this.F.f11929f.setVisibility(8);
            return;
        }
        MiUser C4 = MiConfigSingleton.V3().C4();
        if (C4 == null || C4.getUid() == null) {
            return;
        }
        this.F.f11929f.setText(getString(R.string.invite_code) + C4.getUid().toString());
    }

    public void x2(final boolean hasInviter) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.account.g
            @Override // java.lang.Runnable
            public final void run() {
                BindInviterActivity.this.u2(hasInviter);
            }
        });
    }
}
