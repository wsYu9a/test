package com.martian.mibook.activity.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.martian.libmars.activity.j1;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.a0;
import com.martian.mibook.e.l2;
import com.martian.mibook.lib.account.d.q.h0;
import com.martian.mibook.lib.account.request.auth.ResetParams;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class TXSRemoveBlackListActivity extends com.martian.mibook.lib.model.b.a {
    private a0 F;

    class a extends h0 {
        a(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            TXSRemoveBlackListActivity.this.F.f11663c.setVisibility(8);
            TXSRemoveBlackListActivity.this.k1(errorResult.d());
            TXSRemoveBlackListActivity.this.finish();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean aBoolean) {
            TXSRemoveBlackListActivity.this.F.f11663c.setVisibility(8);
            if (aBoolean == null || !aBoolean.booleanValue()) {
                return;
            }
            TXSRemoveBlackListActivity.this.setResult(-1);
            TXSRemoveBlackListActivity.this.k1("解封成功！");
            TXSRemoveBlackListActivity.this.finish();
        }
    }

    static /* synthetic */ void s2(DialogInterface dialog, int which) {
    }

    /* renamed from: t2 */
    public /* synthetic */ void u2(final l2 dBinding, DialogInterface dialog, int which) {
        String obj = dBinding.f12288b.getText().toString();
        if (com.martian.libsupport.k.p(obj)) {
            k1("理由不能为空");
        } else if (obj.length() < 8) {
            k1("理由长度不足，请多写点吧");
        } else {
            x2(obj);
        }
    }

    public static void y2(j1 activity) {
        activity.startActivityForResult(TXSRemoveBlackListActivity.class, 20004);
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        this.F.f11664d.setTextColor(com.martian.libmars.d.h.F().p0());
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txs_remove_blacklist);
        this.F = a0.a(g2());
    }

    public void onRemoveBlackListClick(View view) {
        if (this.F.f11664d.isChecked()) {
            w2();
        } else {
            k1("请先认真阅读规则并确认");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v2(String reason) {
        if (!MiConfigSingleton.V3().x5()) {
            com.martian.mibook.lib.account.e.d.a(this);
            return;
        }
        this.F.f11663c.setVisibility(0);
        a aVar = new a(this);
        if (!com.martian.libsupport.k.p(reason)) {
            ((ResetParams) aVar.k()).setReason(reason);
        }
        aVar.j();
    }

    public void w2() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_edittext, (ViewGroup) null);
        final l2 a2 = l2.a(inflate);
        new AlertDialog.Builder(this).setTitle("请如实填写解封理由（8字以上）").setView(inflate).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.activity.account.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                TXSRemoveBlackListActivity.s2(dialogInterface, i2);
            }
        }).setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.activity.account.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                TXSRemoveBlackListActivity.this.u2(a2, dialogInterface, i2);
            }
        }).show();
    }

    public void x2(final String reason) {
        v2(reason);
    }
}
