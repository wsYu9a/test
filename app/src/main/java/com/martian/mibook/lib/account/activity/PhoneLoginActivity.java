package com.martian.mibook.lib.account.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.databinding.ActivityPhoneLoginBinding;
import com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding;
import com.martian.mibook.lib.account.request.PhoneLoginParams;
import com.martian.mibook.lib.account.request.RequestPhoneCodeCaptchaParams;
import com.martian.mibook.lib.account.request.RequestPhoneCodeParams;
import com.martian.mibook.lib.account.request.auth.BindPhoneParams;
import com.martian.mibook.lib.account.request.auth.BindWeixinParams;
import com.martian.mibook.lib.account.request.auth.GetUserInfoParams;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.PhoneCodeCaptchaResponse;
import com.martian.mibook.lib.account.response.PhoneCodeResponse;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import com.martian.rpauth.MartianIUserManager;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kb.o;
import l9.i0;
import l9.m0;
import lb.c;
import z7.b;

/* loaded from: classes3.dex */
public class PhoneLoginActivity extends MiBackableActivity {
    public static final String J = "PHONE_TYPE";
    public static final String K = "PHONE_VERFIYHINT";
    public int A;
    public String B;
    public ActivityPhoneLoginBinding C;
    public PopupWindow D;
    public boolean E = false;
    public final j F = new j();
    public int G = 60;
    public int H = 0;
    public ImageView I;

    public class a extends jb.j {

        /* renamed from: i */
        public final /* synthetic */ WeakReference f13863i;

        /* renamed from: j */
        public final /* synthetic */ WeakReference f13864j;

        /* renamed from: k */
        public final /* synthetic */ WeakReference f13865k;

        public a(WeakReference weakReference, WeakReference weakReference2, WeakReference weakReference3) {
            this.f13863i = weakReference;
            this.f13864j = weakReference2;
            this.f13865k = weakReference3;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            if (cVar.c() == 2006) {
                PhoneLoginActivity.this.e3(false);
                return;
            }
            String d10 = cVar.d();
            if (TextUtils.isEmpty(d10)) {
                return;
            }
            EditText editText = (EditText) this.f13864j.get();
            TextView textView = (TextView) this.f13865k.get();
            if (textView == null || editText == null) {
                PhoneLoginActivity.this.P1(d10);
                return;
            }
            editText.getText().clear();
            textView.setText(d10);
            textView.setVisibility(0);
        }

        @Override // y8.a
        /* renamed from: q */
        public void onDataReceived(PhoneCodeResponse phoneCodeResponse) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            if (phoneCodeResponse != null && phoneCodeResponse.getRequestIntervalSeconds() > 0) {
                PhoneLoginActivity.this.G = phoneCodeResponse.getRequestIntervalSeconds();
            }
            AlertDialog alertDialog = (AlertDialog) this.f13863i.get();
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
            phoneLoginActivity.P1(phoneLoginActivity.getString(R.string.send_verification_code_success));
            PhoneLoginActivity.this.x3();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                PhoneLoginActivity.this.t3("验证码发送中...");
            }
        }
    }

    public class b extends kb.d {
        public b(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            PhoneLoginActivity.this.s3(cVar.d(), false);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                PhoneLoginActivity.this.t3("验证中...");
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(TYBonus tYBonus) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            PhoneLoginActivity.this.setResult(-1);
            PhoneLoginActivity.this.z3();
            PhoneLoginActivity.this.u3("手机号验证成功");
        }
    }

    public class c extends kb.d {
        public c(Activity activity) {
            super(activity);
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (cVar.c() == 20015) {
                PopupLoginActivity.q1(PhoneLoginActivity.this, 202, true);
            }
            PhoneLoginActivity.this.s3(cVar.d(), false);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                PhoneLoginActivity.this.t3("绑定中...");
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(TYBonus tYBonus) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            PhoneLoginActivity.this.setResult(-1);
            PhoneLoginActivity.this.P1("绑定成功");
            PhoneLoginActivity.this.z3();
            if (tYBonus == null) {
                PhoneLoginActivity.this.finish();
                return;
            }
            PhoneLoginActivity.this.u3("获得奖励" + tYBonus.getCoins() + "金币");
        }
    }

    public class d extends jb.g {
        public d() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            if (cVar.c() == 2008 || cVar.c() == 20008 || cVar.c() == 20015) {
                PhoneLoginActivity.this.q3(null);
            } else {
                PhoneLoginActivity.this.P1(cVar.d());
            }
        }

        public final /* synthetic */ void s(MiUser miUser) {
            MiWebViewBaseActivity.E4(PhoneLoginActivity.this, ConfigSingleton.D().q(), miUser.getUid().toString(), miUser.getToken(), ConfigSingleton.D().l().f26178a, PopupLoginActivity.f13884f);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                PhoneLoginActivity.this.t3("登录中...");
            }
        }

        public final /* synthetic */ void t() {
            PhoneLoginActivity.this.P1("登录取消");
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(MiUser miUser) {
            PhoneLoginActivity.this.C.f13914d.setVisibility(8);
            if (miUser == null) {
                return;
            }
            if (miUser.getLoggingOff().booleanValue()) {
                PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
                i0.x0(phoneLoginActivity, "确认信息", "账号正在注销审核中，继续登录将会放弃注销", phoneLoginActivity.getString(com.martian.mibook.lib.account.R.string.cancel), PhoneLoginActivity.this.getString(com.martian.mibook.lib.account.R.string.cancel_logout), true, new i0.l() { // from class: ib.i

                    /* renamed from: b */
                    public final /* synthetic */ MiUser f26956b;

                    public /* synthetic */ i(MiUser miUser2) {
                        miUser = miUser2;
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        PhoneLoginActivity.d.this.s(miUser);
                    }
                }, new i0.k() { // from class: ib.j
                    public /* synthetic */ j() {
                    }

                    @Override // l9.i0.k
                    public final void a() {
                        PhoneLoginActivity.d.this.t();
                    }
                });
                return;
            }
            PhoneLoginActivity.this.p3(miUser2);
            e9.c.e(e9.d.f25790b, null);
            PhoneLoginActivity.this.setResult(-1);
            ConfigSingleton.D().g1(lb.c.f28067a, true);
            PhoneLoginActivity.this.P1("登录成功");
            PhoneLoginActivity.this.finish();
        }
    }

    public class e implements c.h {
        public e() {
        }

        @Override // lb.c.h
        public void a(MiUser miUser) {
            PhoneLoginActivity.this.p3(miUser);
            e9.c.e(e9.d.f25790b, null);
            PhoneLoginActivity.this.P1("登录成功");
            PhoneLoginActivity.this.setResult(-1);
            ConfigSingleton.D().g1(lb.c.f28067a, true);
            PhoneLoginActivity.this.finish();
        }

        @Override // lb.c.h
        public void b(boolean z10) {
            if (PhoneLoginActivity.this.isFinishing() || PhoneLoginActivity.this.isDestroyed()) {
                return;
            }
            PhoneLoginActivity.this.C.f13914d.setVisibility(z10 ? 0 : 8);
        }

        @Override // lb.c.h
        public void onResultError(x8.c cVar) {
            PhoneLoginActivity.this.s3(cVar.d(), true);
        }
    }

    public class f implements b.a {

        /* renamed from: a */
        public final /* synthetic */ MiUser f13871a;

        public class a extends kb.e {
            public a(Activity activity) {
                super(activity);
            }

            @Override // jb.k
            public void s(x8.c cVar) {
                PhoneLoginActivity.this.P1("登录失败：" + cVar.d());
            }

            @Override // y8.f
            public void showLoading(boolean z10) {
            }

            @Override // y8.a
            /* renamed from: v */
            public void onDataReceived(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    PhoneLoginActivity.this.P1("登录失败");
                    return;
                }
                f fVar = f.this;
                PhoneLoginActivity.this.h3(fVar.f13871a);
                e9.c.e(e9.d.f25790b, null);
                PhoneLoginActivity.this.setResult(-1);
                ConfigSingleton.D().g1(lb.c.f28067a, true);
                PhoneLoginActivity.this.P1("登录成功");
                PhoneLoginActivity.this.finish();
            }
        }

        public f(MiUser miUser) {
            this.f13871a = miUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z7.b.a
        public void a(String str) {
            a aVar = new a(PhoneLoginActivity.this);
            ((BindWeixinParams) aVar.k()).setWx_code(str);
            ((BindWeixinParams) aVar.k()).setWx_appid(ConfigSingleton.D().q0().f33705a);
            ((BindWeixinParams) aVar.k()).setUid(this.f13871a.getUid());
            ((BindWeixinParams) aVar.k()).setToken(this.f13871a.getToken());
            aVar.j();
        }

        @Override // z7.b.a
        public void b(String str) {
            PhoneLoginActivity.this.P1("绑定失败：" + str);
        }

        @Override // z7.b.a
        public void onLoginCancelled() {
            PhoneLoginActivity.this.P1("绑定取消");
        }
    }

    public class h extends jb.i {

        /* renamed from: i */
        public final /* synthetic */ boolean f13876i;

        public h(boolean z10) {
            this.f13876i = z10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            String cVar2 = cVar.toString();
            if (TextUtils.isEmpty(cVar2)) {
                return;
            }
            PhoneLoginActivity.this.P1(cVar2);
        }

        @Override // y8.a
        /* renamed from: q */
        public void onDataReceived(PhoneCodeCaptchaResponse phoneCodeCaptchaResponse) {
            if (phoneCodeCaptchaResponse == null || TextUtils.isEmpty(phoneCodeCaptchaResponse.getToken())) {
                return;
            }
            PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
            phoneLoginActivity.r3(phoneLoginActivity.f3(phoneCodeCaptchaResponse.getToken()), this.f13876i);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class i implements i0.p {
        public i() {
        }

        @Override // l9.i0.p
        public void a(AlertDialog alertDialog, EditText editText, TextView textView) {
            String obj = editText.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                PhoneLoginActivity phoneLoginActivity = PhoneLoginActivity.this;
                phoneLoginActivity.P1(phoneLoginActivity.getString(R.string.verification_code_empty_tips));
            } else {
                PhoneLoginActivity.this.g3(obj, new WeakReference<>(alertDialog), new WeakReference<>(editText), new WeakReference<>(textView));
            }
        }

        @Override // l9.i0.p
        public void b(EditText editText, TextView textView) {
            editText.getText().clear();
            textView.setVisibility(4);
            PhoneLoginActivity.this.e3(true);
        }
    }

    public class j implements Runnable {

        /* renamed from: b */
        public int f13879b = 0;

        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f13879b;
            if (i10 > 0) {
                PhoneLoginActivity.this.A3(i10 - 1);
            }
        }
    }

    public interface k {

        /* renamed from: a */
        public static final int f13881a = 0;

        /* renamed from: b */
        public static final int f13882b = 1;

        /* renamed from: c */
        public static final int f13883c = 2;
    }

    private void i3() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.C.f13916f.getWindowToken(), 0);
    }

    public void t3(String str) {
        this.C.f13914d.setVisibility(0);
        this.C.f13913c.setText(str);
    }

    public static void y3(Activity activity, int i10, String str, int i11) {
        Intent intent = new Intent(activity, (Class<?>) PhoneLoginActivity.class);
        intent.putExtra(J, i10);
        intent.putExtra(K, str);
        activity.startActivityForResult(intent, i11);
    }

    public final void A3(int i10) {
        this.F.f13879b = i10;
        this.H = i10;
        if (i10 <= 0) {
            this.C.f13920j.setText(getString(com.martian.mibook.lib.account.R.string.get_code));
            return;
        }
        this.C.f13920j.setText(ConfigSingleton.D().s("重新发送(" + String.format(Locale.getDefault(), "%02d", Integer.valueOf(i10)) + "S)"));
        this.C.f13920j.removeCallbacks(this.F);
        this.C.f13920j.postDelayed(this.F, 1000L);
    }

    public void OnLoginClick(View view) {
        if (d3()) {
            return;
        }
        if (l.q(this.C.f13915e.getText().toString())) {
            P1("验证码不能为空");
            return;
        }
        int i10 = this.A;
        if (i10 == 0) {
            b3();
        } else if (i10 == 1) {
            a3();
        } else if (i10 == 2) {
            c3();
        }
    }

    public void OnPhoneCodeClick(View view) {
        if (d3()) {
            return;
        }
        if (this.H <= 0) {
            g3("", null, null, null);
            return;
        }
        P1(this.H + "秒后重新获取");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a3() {
        c cVar = new c(this);
        ((BindPhoneParams) cVar.k()).setPhone(this.C.f13916f.getText().toString());
        ((BindPhoneParams) cVar.k()).setCode(this.C.f13915e.getText().toString());
        cVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b3() {
        d dVar = new d();
        ((PhoneLoginParams) dVar.k()).setPhone(this.C.f13916f.getText().toString());
        ((PhoneLoginParams) dVar.k()).setCode(this.C.f13915e.getText().toString());
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c3() {
        b bVar = new b(this);
        ((BindPhoneParams) bVar.k()).setPhone(this.C.f13916f.getText().toString());
        ((BindPhoneParams) bVar.k()).setCode(this.C.f13915e.getText().toString());
        bVar.j();
    }

    public final boolean d3() {
        if (l.q(this.C.f13916f.getText().toString())) {
            P1("手机号码不能为空");
            return true;
        }
        if (oe.a.a(this.C.f13916f.getText().toString())) {
            return false;
        }
        P1("错误的手机号格式");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e3(boolean z10) {
        h hVar = new h(z10);
        ((RequestPhoneCodeCaptchaParams) hVar.k()).setPhone(this.C.f13916f.getText().toString());
        hVar.j();
    }

    public String f3(String str) {
        StringBuilder sb2;
        String str2;
        if (ConfigSingleton.D().J0()) {
            sb2 = new StringBuilder();
            str2 = "http://testcaptcha.qianhongkeji.cn/get_captcha.do?token=";
        } else {
            sb2 = new StringBuilder();
            str2 = "http://captcha.qianhongkeji.cn/get_captcha.do?token=";
        }
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g3(String str, WeakReference<AlertDialog> weakReference, WeakReference<EditText> weakReference2, WeakReference<TextView> weakReference3) {
        a aVar = new a(weakReference, weakReference2, weakReference3);
        ((RequestPhoneCodeParams) aVar.k()).setPhone(this.C.f13916f.getText().toString());
        if (!l.q(str)) {
            ((RequestPhoneCodeParams) aVar.k()).setCaptcha(str);
        }
        aVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h3(MiUser miUser) {
        g gVar = new g(this, miUser);
        ((GetUserInfoParams) gVar.k()).setUid(miUser.getUid());
        ((GetUserInfoParams) gVar.k()).setToken(miUser.getToken());
        gVar.j();
    }

    public final /* synthetic */ void j3(MiUser miUser, DialogFragment dialogFragment, BindWeixinDialogBinding bindWeixinDialogBinding, View view) {
        if (!this.E) {
            P1("请先同意用户隐私协议");
            l9.a.f(bindWeixinDialogBinding.f13935e);
            return;
        }
        P1("跳转微信中...");
        if (miUser == null) {
            w3(this.C.f13916f.getText().toString());
        } else {
            v3(miUser);
        }
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public final /* synthetic */ void k3(BindWeixinDialogBinding bindWeixinDialogBinding, View view) {
        boolean z10 = !this.E;
        this.E = z10;
        bindWeixinDialogBinding.f13936f.setImageResource(z10 ? R.drawable.icon_checked : R.drawable.icon_checkin_unselected);
    }

    public final /* synthetic */ void l3(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            this.E = false;
            dialogFragment.dismiss();
        }
    }

    public final /* synthetic */ void m3(View view) {
        lb.c.q(this);
    }

    public final /* synthetic */ void n3(View view) {
        lb.c.n(this);
    }

    public final /* synthetic */ void o3() {
        A3(this.G);
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        MiUserManager.x(i10, i11, intent);
        if (i10 == PopupLoginActivity.f13884f && i11 == -1) {
            ac.a.P(this, "放弃注销账号");
            P1("请重新登录");
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
        ActivityPhoneLoginBinding c10 = ActivityPhoneLoginBinding.c(getLayoutInflater());
        this.C = c10;
        setContentView(c10.getRoot());
        if (bundle != null) {
            this.A = bundle.getInt(J, 0);
            this.B = bundle.getString(K, "");
        } else {
            this.A = getIntent().getIntExtra(J, 0);
            this.B = getIntent().getStringExtra(K);
        }
        this.C.f13917g.setPadding(0, p1(), 0, 0);
        int i10 = this.A;
        if (i10 == 0) {
            this.C.f13918h.setText(getString(com.martian.mibook.lib.account.R.string.phone_login_hint));
        } else if (i10 == 1) {
            this.C.f13918h.setText(getString(com.martian.mibook.lib.account.R.string.phone_bind));
        } else if (i10 == 2) {
            this.C.f13918h.setText(getString(com.martian.mibook.lib.account.R.string.phone_verify));
        }
        if (this.A != 2 || l.q(this.B)) {
            this.C.f13912b.setVisibility(8);
        } else {
            this.C.f13912b.setVisibility(0);
            this.C.f13912b.setText(this.B);
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.D;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.D = null;
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        i3();
        super.onPause();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(J, this.A);
        bundle.putString(K, this.B);
    }

    public final void p3(MiUser miUser) {
        if (miUser != null) {
            miUser.setGuest(Boolean.FALSE);
        }
        MartianIUserManager.b().l(miUser);
        z3();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ib.d.<init>(com.martian.mibook.lib.account.activity.PhoneLoginActivity, com.martian.mibook.lib.account.response.MiUser, androidx.fragment.app.DialogFragment, com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding):void, class status: GENERATED_AND_UNLOADED
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
    public void q3(com.martian.mibook.lib.account.response.MiUser r5) {
        /*
            r4 = this;
            android.view.LayoutInflater r0 = r4.getLayoutInflater()
            int r1 = com.martian.mibook.lib.account.R.layout.bind_weixin_dialog
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding r1 = com.martian.mibook.lib.account.databinding.BindWeixinDialogBinding.a(r0)
            android.widget.TextView r2 = r1.f13933c
            int r3 = com.martian.mibook.lib.account.R.string.phone_login_bind_wx_hint
            java.lang.String r3 = r4.getString(r3)
            r2.setText(r3)
            com.martian.libmars.widget.dialog.MartianDialogFragment$a r2 = com.martian.libmars.widget.dialog.MartianDialogFragment.INSTANCE
            com.martian.libmars.widget.dialog.b r2 = r2.a()
            com.martian.libmars.widget.dialog.b r0 = r2.Q(r0)
            r2 = 0
            com.martian.libmars.widget.dialog.b r0 = r0.J(r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment r0 = r0.E(r4)
            android.widget.LinearLayout r2 = r1.f13932b
            ib.d r3 = new ib.d
            r3.<init>()
            r2.setOnClickListener(r3)
            android.widget.LinearLayout r5 = r1.f13935e
            ib.e r2 = new ib.e
            r2.<init>()
            r5.setOnClickListener(r2)
            android.widget.ImageView r5 = r1.f13934d
            ib.f r2 = new ib.f
            r2.<init>()
            r5.setOnClickListener(r2)
            android.widget.TextView r5 = r1.f13938h
            ib.g r0 = new ib.g
            r0.<init>()
            r5.setOnClickListener(r0)
            android.widget.TextView r5 = r1.f13937g
            ib.h r0 = new ib.h
            r0.<init>()
            r5.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.lib.account.activity.PhoneLoginActivity.q3(com.martian.mibook.lib.account.response.MiUser):void");
    }

    public void r3(String str, boolean z10) {
        ImageView imageView;
        if (isFinishing() || l.q(str)) {
            return;
        }
        if (!z10 || (imageView = this.I) == null) {
            this.I = i0.t0(this, getString(R.string.captcha_code), str, new i());
        } else {
            m0.k(this, str, imageView);
        }
    }

    public final void s3(String str, boolean z10) {
        this.C.f13914d.setVisibility(8);
        P1(str);
        if (z10) {
            finish();
        }
    }

    public final void u3(String str) {
        i0.F0(this, ConfigSingleton.D().s("恭喜您"), ConfigSingleton.D().s(str), ConfigSingleton.D().s("知道了"), new i0.k() { // from class: ib.b
            public /* synthetic */ b() {
            }

            @Override // l9.i0.k
            public final void a() {
                PhoneLoginActivity.this.finish();
            }
        }, new i0.l() { // from class: ib.c
            public /* synthetic */ c() {
            }

            @Override // l9.i0.l
            public final void a() {
                PhoneLoginActivity.this.finish();
            }
        });
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        overridePendingTransition(0, R.anim.activity_pop_out);
    }

    public final void v3(MiUser miUser) {
        if (miUser == null || miUser.getUid() == null) {
            return;
        }
        z7.b.d().w(new f(miUser));
    }

    public void w3(String str) {
        lb.c.k(this, str, new e());
    }

    public final void x3() {
        runOnUiThread(new Runnable() { // from class: ib.a
            public /* synthetic */ a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                PhoneLoginActivity.this.o3();
            }
        });
    }

    public void z3() {
        lb.c.x(this, null);
        if (this.A == 0) {
            lb.c.w(this, null);
        }
    }

    public class g extends o {

        /* renamed from: k */
        public final /* synthetic */ MiUser f13874k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Activity activity, MiUser miUser) {
            super(activity);
            this.f13874k = miUser;
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(MiUser miUser) {
            if (miUser != null) {
                PhoneLoginActivity.this.p3(miUser);
                return;
            }
            MiUser miUser2 = this.f13874k;
            if (miUser2 != null) {
                PhoneLoginActivity.this.p3(miUser2);
            }
        }

        @Override // jb.k
        public void s(x8.c cVar) {
        }
    }
}
