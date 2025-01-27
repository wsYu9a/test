package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.activity.SettingActivity;
import com.martian.mibook.activity.account.AccountDetailActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityAccountDetailBinding;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import l9.i0;
import l9.m0;
import lb.c;
import me.b;

/* loaded from: classes3.dex */
public class AccountDetailActivity extends MiBackableActivity {
    public ActivityAccountDetailBinding A;

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ra.d.<init>(com.martian.mibook.activity.account.AccountDetailActivity, android.widget.PopupWindow):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private void b3() {
        /*
            r4 = this;
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r1 = 0
            r2 = 0
            com.martian.mibook.databinding.PopupwindowAccountLogoutBinding r0 = com.martian.mibook.databinding.PopupwindowAccountLogoutBinding.inflate(r0, r1, r2)
            com.martian.libmars.ui.theme.ThemeLinearLayout r1 = r0.getRoot()
            r2 = 1
            r3 = 80
            android.widget.PopupWindow r1 = l9.i0.J(r4, r1, r2, r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r2 = r0.acpLogoutLayout
            ra.d r3 = new ra.d
            r3.<init>()
            r2.setOnClickListener(r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r0 = r0.acpCancelLayout
            ra.e r2 = new ra.e
            r2.<init>()
            r0.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.activity.account.AccountDetailActivity.b3():void");
    }

    public final /* synthetic */ boolean T2(View view) {
        if (ConfigSingleton.D().J0() && MiConfigSingleton.b2().F2()) {
            b s10 = MiConfigSingleton.b2().u2().s();
            s10.setUid(Long.valueOf(MartianRPUserManager.a()));
            MiConfigSingleton.b2().u2().M(s10);
            MiConfigSingleton.b2().G1().C(this, true, new a());
        }
        return true;
    }

    public final /* synthetic */ void U2(PopupWindow popupWindow, View view) {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        ac.a.Q(this, "注销账号");
        MiWebViewActivity.K5(this, ConfigSingleton.D().H(), false, SettingActivity.E);
    }

    public final /* synthetic */ void W2(PopupWindow popupWindow, View view) {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        i0.z0(this, getString(R.string.logout), getString(R.string.logout_hint), new i0.l() { // from class: ra.a
            public /* synthetic */ a() {
            }

            @Override // l9.i0.l
            public final void a() {
                AccountDetailActivity.this.c3();
            }
        });
    }

    public final /* synthetic */ void Y2(MiUser miUser) {
        finish();
    }

    @SuppressLint({"SetTextI18n"})
    public final void Z2() {
        Resources resources;
        int i10;
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        if (p10 == null) {
            return;
        }
        m0.l(this, p10.getHeader(), this.A.accountHead, R.drawable.icon_header);
        if (!TextUtils.isEmpty(p10.getNickname())) {
            this.A.nicknameAccount.setText(p10.getNickname());
        }
        if (p10.getGender() != null) {
            TextView textView = this.A.sexAccount;
            if (p10.getGender().equals('M')) {
                resources = getResources();
                i10 = R.string.man;
            } else if (p10.getGender().equals('F')) {
                resources = getResources();
                i10 = R.string.woman;
            } else {
                resources = getResources();
                i10 = R.string.others_recommend;
            }
            textView.setText(resources.getString(i10));
        }
        if (l.q(p10.getUid().toString())) {
            return;
        }
        this.A.uid.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + p10.getUid().toString());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ra.b.<init>(com.martian.mibook.activity.account.AccountDetailActivity, android.widget.PopupWindow):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void a3() {
        /*
            r4 = this;
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r1 = 0
            r2 = 0
            com.martian.mibook.databinding.PopupwindowAccountLogoutBinding r0 = com.martian.mibook.databinding.PopupwindowAccountLogoutBinding.inflate(r0, r1, r2)
            com.martian.libmars.ui.theme.ThemeLinearLayout r1 = r0.getRoot()
            r2 = 1
            r3 = 80
            android.widget.PopupWindow r1 = l9.i0.J(r4, r1, r2, r3)
            com.martian.libmars.ui.theme.ThemeTextView r2 = r0.acpLogoutTitle
            int r3 = com.martian.mibook.R.string.account_security_logout
            java.lang.String r3 = r4.getString(r3)
            r2.setText(r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r2 = r0.acpLogoutLayout
            ra.b r3 = new ra.b
            r3.<init>()
            r2.setOnClickListener(r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r0 = r0.acpCancelLayout
            ra.c r2 = new ra.c
            r2.<init>()
            r0.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.activity.account.AccountDetailActivity.a3():void");
    }

    public final void c3() {
        P1("退出登录成功");
        ac.a.Q(this, "退出登录");
        setResult(-1);
        MiConfigSingleton.b2().P2(this, new MiCompoundUserManager.g() { // from class: ra.f
            public /* synthetic */ f() {
            }

            @Override // com.martian.mibook.account.MiCompoundUserManager.g
            public final void a(MiUser miUser) {
                AccountDetailActivity.this.Y2(miUser);
            }
        });
    }

    public void onAccountLogOffClick(View view) {
        a3();
    }

    public void onAccountSecurityClick(View view) {
        b3();
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        MiTaskAccount p22;
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_detail);
        ActivityAccountDetailBinding bind = ActivityAccountDetailBinding.bind(D2());
        this.A = bind;
        bind.accountHead.setOnLongClickListener(new View.OnLongClickListener() { // from class: ra.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean T2;
                T2 = AccountDetailActivity.this.T2(view);
                return T2;
            }
        });
        if (MiConfigSingleton.b2().F2() && (p22 = MiConfigSingleton.b2().p2()) != null && p22.getTotalReadingCoins().intValue() > 0) {
            this.A.totalReadDuration.setVisibility(0);
            this.A.totalReadDuration.setText(getString(R.string.read_total_duration) + p22.getTotalReadingCoins() + "金币");
        }
        Z2();
    }

    public class a implements c.i {
        public a() {
        }

        @Override // lb.c.i
        public void b(MartianRPAccount martianRPAccount) {
            AccountDetailActivity.this.Z2();
        }

        @Override // lb.c.i
        public void a(x8.c cVar) {
        }
    }
}
