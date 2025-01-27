package com.martian.mibook.activity.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import ba.l;
import com.martian.mibook.R;
import com.martian.mibook.activity.account.TXSRequestRemoveBlackListActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTxsRequestRemoveBlacklistBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.RequestUnBlackParams;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import kb.y;
import lb.d;
import x8.c;

/* loaded from: classes3.dex */
public class TXSRequestRemoveBlackListActivity extends MiBackableActivity {
    public ActivityTxsRequestRemoveBlacklistBinding A;

    public class a extends y {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            TXSRequestRemoveBlackListActivity.this.A.removeBlackLoading.setVisibility(8);
            TXSRequestRemoveBlackListActivity.this.P1(cVar.d());
            TXSRequestRemoveBlackListActivity.this.finish();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            TXSRequestRemoveBlackListActivity.this.A.removeBlackLoading.setVisibility(8);
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            TXSRequestRemoveBlackListActivity.this.setResult(-1);
            TXSRequestRemoveBlackListActivity.this.P1("解封申请已提交！");
            TXSRequestRemoveBlackListActivity.this.finish();
        }
    }

    public static void P2(Activity activity) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) TXSRequestRemoveBlackListActivity.class), MiUserManager.f13852h);
    }

    public final void N2() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O2(String str) {
        if (!MiConfigSingleton.b2().F2()) {
            d.a(this);
            return;
        }
        this.A.removeBlackLoading.setVisibility(0);
        a aVar = new a(this);
        if (!l.q(str)) {
            ((RequestUnBlackParams) aVar.k()).setReason(str);
        }
        aVar.j();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_txs_request_remove_blacklist);
        ActivityTxsRequestRemoveBlacklistBinding bind = ActivityTxsRequestRemoveBlacklistBinding.bind(D2());
        this.A = bind;
        bind.removeReason.postDelayed(new Runnable() { // from class: ra.n
            public /* synthetic */ n() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                TXSRequestRemoveBlackListActivity.this.N2();
            }
        }, 100L);
    }

    public void onRemoveBlackListClick(View view) {
        String obj = this.A.removeReason.getText().toString();
        if (l.q(obj)) {
            P1("理由不能为空");
        } else if (obj.length() < 10) {
            P1("理由字数不足");
        } else {
            O2(obj);
        }
    }
}
