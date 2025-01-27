package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import ba.l;
import com.martian.mibook.R;
import com.martian.mibook.activity.WeixinGroupFollowActivity;
import com.martian.mibook.activity.account.BindInviterActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityBindInviterBinding;
import com.martian.mibook.lib.account.request.auth.BindInviterParams;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import je.i;
import kb.c;
import kb.q;
import lb.d;

/* loaded from: classes3.dex */
public class BindInviterActivity extends MiBackableActivity {
    public ActivityBindInviterBinding A;

    public class a extends c {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            BindInviterActivity.this.P1(cVar.toString());
            BindInviterActivity.this.N2();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ExchangeMoney exchangeMoney) {
            if (exchangeMoney == null) {
                BindInviterActivity.this.P1("拜师失败");
                return;
            }
            BindInviterActivity.this.P2();
            BindInviterActivity.this.R2(true);
            MiConfigSingleton.b2().u2().S(BindInviterActivity.this, "拜师", exchangeMoney.getMoney(), exchangeMoney.getCoins().intValue());
            MiConfigSingleton.b2().d3(true);
        }
    }

    public class b extends q {
        public b(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            BindInviterActivity.this.R2(false);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            if (bool == null) {
                BindInviterActivity.this.R2(false);
                return;
            }
            BindInviterActivity.this.R2(bool.booleanValue());
            MiConfigSingleton.b2().d3(bool.booleanValue());
            BindInviterActivity.this.setResult(-1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M2() {
        i.n(this, this.A.inviteCode);
        if (!MiConfigSingleton.b2().F2()) {
            d.a(this);
            P1("请先登录");
        } else {
            if (l.q(this.A.inviteCode.getText().toString())) {
                P1("邀请码不能为空");
                return;
            }
            a aVar = new a(this);
            ((BindInviterParams) aVar.k()).setInviteCode(this.A.inviteCode.getText().toString());
            aVar.j();
        }
    }

    public void N2() {
        if (MiConfigSingleton.b2().F2()) {
            new b(this).j();
        }
    }

    public final /* synthetic */ void O2(boolean z10) {
        if (z10) {
            this.A.bindInviterView.setVisibility(8);
            this.A.bindedInviterView.setVisibility(0);
        } else {
            this.A.bindInviterView.setVisibility(0);
            this.A.bindedInviterView.setVisibility(8);
        }
    }

    public void OnBindInviterClick(View view) {
        M2();
    }

    public void OnGetInviterClick(View view) {
        startActivity(WeixinGroupFollowActivity.class);
    }

    public void P2() {
        lb.c.x(this, null);
    }

    @SuppressLint({"SetTextI18n"})
    public void Q2() {
        if (!MiConfigSingleton.b2().F2()) {
            this.A.myInviteCode.setVisibility(8);
            return;
        }
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        if (p10 == null || p10.getUid() == null) {
            return;
        }
        this.A.myInviteCode.setText(getString(R.string.invite_code) + p10.getUid().toString());
    }

    public void R2(boolean z10) {
        runOnUiThread(new Runnable() { // from class: ra.h

            /* renamed from: c */
            public final /* synthetic */ boolean f30378c;

            public /* synthetic */ h(boolean z102) {
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BindInviterActivity.this.O2(z10);
            }
        });
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bind_inviter);
        this.A = ActivityBindInviterBinding.bind(D2());
        Q2();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        i.n(this, this.A.inviteCode);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        N2();
    }
}
