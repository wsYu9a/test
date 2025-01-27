package com.martian.mibook.activity.account;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.b0;
import com.martian.mibook.lib.account.d.q.g0;
import com.martian.mibook.lib.account.request.auth.RequestUnBlackParams;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TXSRequestRemoveBlackListActivity extends com.martian.mibook.lib.model.b.a {
    private b0 F;

    class a extends g0 {
        a(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            TXSRequestRemoveBlackListActivity.this.F.f11726b.setVisibility(8);
            TXSRequestRemoveBlackListActivity.this.k1(errorResult.d());
            TXSRequestRemoveBlackListActivity.this.finish();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean aBoolean) {
            TXSRequestRemoveBlackListActivity.this.F.f11726b.setVisibility(8);
            if (aBoolean == null || !aBoolean.booleanValue()) {
                return;
            }
            TXSRequestRemoveBlackListActivity.this.setResult(-1);
            TXSRequestRemoveBlackListActivity.this.k1("解封申请已提交！");
            TXSRequestRemoveBlackListActivity.this.finish();
        }
    }

    public void s2() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static void v2(j1 activity) {
        activity.startActivityForResult(TXSRequestRemoveBlackListActivity.class, 20004);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txs_request_remove_blacklist);
        b0 a2 = b0.a(g2());
        this.F = a2;
        a2.f11727c.postDelayed(new Runnable() { // from class: com.martian.mibook.activity.account.o
            @Override // java.lang.Runnable
            public final void run() {
                TXSRequestRemoveBlackListActivity.this.s2();
            }
        }, 100L);
    }

    public void onRemoveBlackListClick(View view) {
        String obj = this.F.f11727c.getText().toString();
        if (com.martian.libsupport.k.p(obj)) {
            k1("理由不能为空");
        } else if (obj.length() < 10) {
            k1("理由字数不足");
        } else {
            u2(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u2(String reason) {
        if (!MiConfigSingleton.V3().x5()) {
            com.martian.mibook.lib.account.e.d.a(this);
            return;
        }
        this.F.f11726b.setVisibility(0);
        a aVar = new a(this);
        if (!com.martian.libsupport.k.p(reason)) {
            ((RequestUnBlackParams) aVar.k()).setReason(reason);
        }
        aVar.j();
    }
}
