package com.martian.libmars.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import ba.l;
import ba.m;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.R;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libsupport.permission.TipInfo;
import ea.a;
import ea.b;
import ea.c;
import java.io.Serializable;
import l9.i0;
import l9.t0;

@Route(path = "/libraries/libmars/PermissionActivity")
/* loaded from: classes3.dex */
public class PermissionActivity extends AppCompatActivity {

    /* renamed from: k */
    public static final int f12041k = 64;

    /* renamed from: l */
    public static final int f12042l = 104;

    /* renamed from: m */
    public static final int f12043m = 205;

    /* renamed from: n */
    public static final int f12044n = 210;

    /* renamed from: o */
    public static final String f12045o = "permission";

    /* renamed from: p */
    public static final String f12046p = "key";

    /* renamed from: q */
    public static final String f12047q = "showTip";

    /* renamed from: r */
    public static final String f12048r = "cancelable";

    /* renamed from: s */
    public static final String f12049s = "tip";

    /* renamed from: t */
    public static final String f12050t = "permission_type";

    /* renamed from: c */
    public String[] f12052c;

    /* renamed from: d */
    public String f12053d;

    /* renamed from: f */
    public boolean f12055f;

    /* renamed from: g */
    public boolean f12056g;

    /* renamed from: h */
    public TipInfo f12057h;

    /* renamed from: j */
    public AlertDialog f12059j;

    /* renamed from: b */
    public boolean f12051b = true;

    /* renamed from: e */
    public int f12054e = -1;

    /* renamed from: i */
    public final String f12058i = "权限申请";

    private void requestPermissions(String[] strArr) {
        try {
            ActivityCompat.requestPermissions(this, strArr, 64);
        } catch (ActivityNotFoundException unused) {
            finish();
        }
    }

    public final /* synthetic */ void e1(boolean z10, View view) {
        this.f12059j.dismiss();
        if (this.f12056g || z10) {
            c.c(this);
        } else {
            j1();
        }
    }

    public final /* synthetic */ void f1(View view) {
        this.f12059j.dismiss();
        j1();
    }

    public final /* synthetic */ void g1(View view) {
        this.f12059j.dismiss();
        int i10 = this.f12054e;
        if (i10 == 104) {
            if (m.n()) {
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 104);
                return;
            }
            return;
        }
        if (i10 == 205) {
            startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 205);
            return;
        }
        if (i10 == 210) {
            Intent intent2 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent2.setData(Uri.parse(String.format("package:%s", getPackageName())));
            startActivityForResult(intent2, 210);
        }
    }

    public final /* synthetic */ void h1(View view) {
        this.f12059j.dismiss();
        requestPermissions(this.f12052c);
    }

    public final /* synthetic */ void i1(View view) {
        this.f12059j.dismiss();
        j1();
    }

    public final void j1() {
        b a10 = c.a(this.f12053d);
        if (a10 != null) {
            a10.permissionDenied();
        }
        finish();
    }

    public final void k1() {
        b a10 = c.a(this.f12053d);
        if (a10 != null) {
            a10.permissionGranted();
        }
        finish();
    }

    public final void l1(@NonNull String[] strArr, boolean z10) {
        a b10;
        String ensure;
        View inflate = LayoutInflater.from(this).inflate(R.layout.libmars_popupwindow_permission, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.privacy_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_desc);
        TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_known);
        TextView textView4 = (TextView) inflate.findViewById(R.id.privacy_agree);
        TipInfo tipInfo = this.f12057h;
        String str = "权限申请";
        if (tipInfo != null && !l.q(tipInfo.getTitle())) {
            str = this.f12057h.getTitle();
        }
        textView.setText(str);
        TipInfo tipInfo2 = this.f12057h;
        if (tipInfo2 == null || l.q(tipInfo2.getContent())) {
            String str2 = getResources().getString(com.martian.libsupport.R.string.app_name) + "需要以下权限才能正常使用";
            for (String str3 : strArr) {
                if (!c.d(this, str3) && (b10 = c.b(str3)) != null) {
                    str2 = str2.concat("\n \n" + b10.c() + "\n" + b10.a());
                }
            }
            if (z10) {
                str2 = str2 + "\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。";
            }
            textView2.setText(str2);
        } else {
            textView2.setText(this.f12057h.getContent());
        }
        if (z10) {
            ensure = "前往开启";
        } else {
            TipInfo tipInfo3 = this.f12057h;
            ensure = (tipInfo3 == null || l.q(tipInfo3.getEnsure())) ? "重新授权" : this.f12057h.getEnsure();
        }
        TipInfo tipInfo4 = this.f12057h;
        String cancel = (tipInfo4 == null || l.q(tipInfo4.getCancel())) ? "取消" : this.f12057h.getCancel();
        textView4.setText(ensure);
        textView3.setText(cancel);
        if (this.f12056g) {
            textView3.setVisibility(0);
        } else {
            textView3.setVisibility(8);
        }
        AlertDialog G = i0.G(this, inflate, false);
        this.f12059j = G;
        if (G == null) {
            return;
        }
        G.setCancelable(false);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: d9.h

            /* renamed from: c */
            public final /* synthetic */ boolean f25332c;

            public /* synthetic */ h(boolean z102) {
                z10 = z102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.this.e1(z10, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: d9.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.this.f1(view);
            }
        });
    }

    public final void m1() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.libmars_popupwindow_permission, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.privacy_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_desc);
        ((TextView) inflate.findViewById(R.id.privacy_known)).setVisibility(8);
        TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
        TipInfo tipInfo = this.f12057h;
        String str = "权限申请";
        if (tipInfo != null && !l.q(tipInfo.getTitle())) {
            str = this.f12057h.getTitle();
        }
        textView.setText(str);
        TipInfo tipInfo2 = this.f12057h;
        if (tipInfo2 == null || l.q(tipInfo2.getContent())) {
            textView2.setText(ConfigSingleton.D().s("需要允许权限才能正常使用"));
        } else {
            textView2.setText(ConfigSingleton.D().s(this.f12057h.getContent()));
        }
        textView3.setText(ConfigSingleton.D().s("知道了"));
        AlertDialog G = i0.G(this, inflate, false);
        this.f12059j = G;
        if (G == null) {
            return;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: d9.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.this.g1(view);
            }
        });
    }

    public final void n1() {
        a b10;
        View inflate = LayoutInflater.from(this).inflate(R.layout.libmars_popupwindow_permission, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.privacy_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_desc);
        TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_known);
        TextView textView4 = (TextView) inflate.findViewById(R.id.privacy_agree);
        TipInfo tipInfo = this.f12057h;
        String str = "权限申请";
        if (tipInfo != null && !l.q(tipInfo.getTitle())) {
            str = this.f12057h.getTitle();
        }
        textView.setText(str);
        TipInfo tipInfo2 = this.f12057h;
        if (tipInfo2 == null || l.q(tipInfo2.getContent())) {
            String str2 = getResources().getString(com.martian.libsupport.R.string.app_name) + "需要以下权限才能正常使用";
            for (String str3 : this.f12052c) {
                if (!c.d(this, str3) && (b10 = c.b(str3)) != null) {
                    str2 = str2.concat("\n \n" + b10.c() + "\n" + b10.a());
                }
            }
            textView2.setText(str2);
        } else {
            textView2.setText(this.f12057h.getContent().split("\n")[0]);
        }
        textView3.setText("取消");
        textView4.setText("授权");
        AlertDialog G = i0.G(this, inflate, false);
        this.f12059j = G;
        if (G == null) {
            return;
        }
        G.setCancelable(false);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: d9.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.this.h1(view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: d9.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.this.i1(view);
            }
        });
    }

    public final void o1(String str) {
        t0.b(this, str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        boolean isExternalStorageManager;
        boolean canRequestPackageInstalls;
        boolean canWrite;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 104) {
            if (m.n()) {
                canWrite = Settings.System.canWrite(getApplicationContext());
                if (canWrite) {
                    o1("授权成功");
                } else {
                    o1("修改设置权限被拒绝");
                }
            }
            finish();
            return;
        }
        if (i10 == 205) {
            if (m.u()) {
                canRequestPackageInstalls = getPackageManager().canRequestPackageInstalls();
                if (canRequestPackageInstalls) {
                    o1("授权成功");
                    k1();
                } else {
                    o1("权限未开启");
                    j1();
                }
            }
            finish();
            return;
        }
        if (i10 == 210) {
            if (m.y()) {
                isExternalStorageManager = Environment.isExternalStorageManager();
                if (isExternalStorageManager) {
                    o1("授权成功");
                    k1();
                } else {
                    o1("权限未开启");
                    j1();
                }
            }
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Serializable serializableExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f12052c = bundle.getStringArray("permission");
            this.f12053d = bundle.getString(f12046p);
            this.f12054e = bundle.getInt(f12050t);
            this.f12055f = bundle.getBoolean(f12047q, true);
            this.f12056g = bundle.getBoolean(f12048r, false);
            serializableExtra = bundle.getSerializable(f12049s);
        } else {
            this.f12052c = getIntent().getStringArrayExtra("permission");
            this.f12053d = getIntent().getStringExtra(f12046p);
            this.f12054e = getIntent().getIntExtra(f12050t, -1);
            this.f12055f = getIntent().getBooleanExtra(f12047q, true);
            this.f12056g = getIntent().getBooleanExtra(f12048r, false);
            serializableExtra = getIntent().getSerializableExtra(f12049s);
        }
        if (serializableExtra != null) {
            this.f12057h = (TipInfo) serializableExtra;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (!l.q(this.f12053d)) {
            c.a(this.f12053d);
        }
        AlertDialog alertDialog = this.f12059j;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12059j = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 64 && c.g(iArr) && c.d(this, strArr)) {
            k1();
            return;
        }
        if (!this.f12055f) {
            j1();
            return;
        }
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] == -1 && !ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[i11])) {
                l1(strArr, true);
                return;
            }
        }
        l1(strArr, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean isExternalStorageManager;
        boolean canRequestPackageInstalls;
        boolean canWrite;
        super.onResume();
        int i10 = this.f12054e;
        if (i10 == 104) {
            if (m.n()) {
                canWrite = Settings.System.canWrite(this);
                if (canWrite) {
                    return;
                }
                m1();
                return;
            }
            return;
        }
        if (i10 == 205) {
            if (m.u()) {
                canRequestPackageInstalls = getPackageManager().canRequestPackageInstalls();
                if (canRequestPackageInstalls) {
                    return;
                }
                m1();
                return;
            }
            return;
        }
        if (i10 == 210) {
            if (m.y()) {
                isExternalStorageManager = Environment.isExternalStorageManager();
                if (isExternalStorageManager) {
                    return;
                }
                m1();
                return;
            }
            return;
        }
        if (!this.f12051b) {
            this.f12051b = true;
        } else if (c.d(this, this.f12052c)) {
            k1();
        } else {
            n1();
            this.f12051b = false;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArray("permission", this.f12052c);
        bundle.putString(f12046p, this.f12053d);
        bundle.putBoolean(f12047q, this.f12055f);
        bundle.putBoolean(f12048r, this.f12056g);
        bundle.putSerializable(f12049s, this.f12057h);
        bundle.putInt(f12050t, this.f12054e);
    }
}
