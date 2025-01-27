package com.martian.mibook.activity.account;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.account.TXSRemoveBlackListActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityTxsRemoveBlacklistBinding;
import com.martian.mibook.databinding.DialogEdittextBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.auth.ResetParams;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import kb.z;
import lb.d;
import x8.c;

/* loaded from: classes3.dex */
public class TXSRemoveBlackListActivity extends MiBackableActivity {
    public ActivityTxsRemoveBlacklistBinding A;

    public class a extends z {
        public a(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(c cVar) {
            TXSRemoveBlackListActivity.this.A.removeBlackLoading.setVisibility(8);
            TXSRemoveBlackListActivity.this.P1(cVar.d());
            TXSRemoveBlackListActivity.this.finish();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(Boolean bool) {
            TXSRemoveBlackListActivity.this.A.removeBlackLoading.setVisibility(8);
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            TXSRemoveBlackListActivity.this.setResult(-1);
            TXSRemoveBlackListActivity.this.P1("解封成功！");
            TXSRemoveBlackListActivity.this.finish();
        }
    }

    public static /* synthetic */ void O2(DialogInterface dialogInterface, int i10) {
    }

    public static void T2(Activity activity) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) TXSRemoveBlackListActivity.class), MiUserManager.f13852h);
    }

    public final /* synthetic */ void P2(DialogEdittextBinding dialogEdittextBinding, DialogInterface dialogInterface, int i10) {
        String obj = dialogEdittextBinding.etDialogContent.getText().toString();
        if (l.q(obj)) {
            P1("理由不能为空");
        } else if (obj.length() < 8) {
            P1("理由长度不足，请多写点吧");
        } else {
            S2(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q2(String str) {
        if (!MiConfigSingleton.b2().F2()) {
            d.a(this);
            return;
        }
        this.A.removeBlackLoading.setVisibility(0);
        a aVar = new a(this);
        if (!l.q(str)) {
            ((ResetParams) aVar.k()).setReason(str);
        }
        aVar.j();
    }

    public void R2() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_edittext, (ViewGroup) null);
        new AlertDialog.Builder(this).setTitle("请如实填写解封理由（8字以上）").setView(inflate).setNegativeButton(com.martian.libmars.R.string.cancel, new DialogInterface.OnClickListener() { // from class: ra.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TXSRemoveBlackListActivity.O2(dialogInterface, i10);
            }
        }).setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: ra.m

            /* renamed from: c */
            public final /* synthetic */ DialogEdittextBinding f30383c;

            public /* synthetic */ m(DialogEdittextBinding dialogEdittextBinding) {
                bind = dialogEdittextBinding;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TXSRemoveBlackListActivity.this.P2(bind, dialogInterface, i10);
            }
        }).show();
    }

    public void S2(String str) {
        Q2(str);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_txs_remove_blacklist);
        this.A = ActivityTxsRemoveBlacklistBinding.bind(D2());
    }

    public void onRemoveBlackListClick(View view) {
        if (this.A.ruleConfirm.isChecked()) {
            R2();
        } else {
            P1("请先认真阅读规则并确认");
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void p2(boolean z10) {
        super.p2(z10);
        this.A.ruleConfirm.setTextColor(ConfigSingleton.D().h0());
    }
}
