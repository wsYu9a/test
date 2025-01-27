package com.martian.libsupport.permission;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.martian.libsupport.R;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class PermissionActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final int f10628a = 64;

    /* renamed from: b */
    public static final int f10629b = 104;

    /* renamed from: c */
    public static final int f10630c = 205;

    /* renamed from: d */
    private static final String f10631d = "permission";

    /* renamed from: e */
    private static final String f10632e = "key";

    /* renamed from: f */
    private static final String f10633f = "showTip";

    /* renamed from: g */
    private static final String f10634g = "cancelable";

    /* renamed from: h */
    private static final String f10635h = "tip";

    /* renamed from: i */
    private static final String f10636i = "permission_type";
    private String[] k;
    private String l;
    private boolean n;
    private boolean o;
    private TipInfo p;

    /* renamed from: j */
    private boolean f10637j = true;
    private int m = -1;
    private final String q = "权限申请";
    private final String r = "当前应用缺少必要权限。\n \n 请点击 \"设置\"-\"权限\"-打开所需权限。";

    /* renamed from: B */
    public /* synthetic */ void C(DialogInterface dialog, int which) {
        t0("权限未开启");
        finish();
    }

    private void p0() {
        f a2 = g.a(this.l);
        if (a2 != null) {
            a2.permissionDenied();
        }
        finish();
    }

    private void q0() {
        f a2 = g.a(this.l);
        if (a2 != null) {
            a2.permissionGranted();
        }
        finish();
    }

    private void r0(@NonNull String[] permissions, final boolean goSetting) {
        e b2;
        String ensure;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TipInfo tipInfo = this.p;
        String str = "权限申请";
        if (tipInfo != null && !k.p(tipInfo.getTitle())) {
            str = this.p.getTitle();
        }
        builder.setTitle(str);
        TipInfo tipInfo2 = this.p;
        if (tipInfo2 == null || k.p(tipInfo2.getContent())) {
            String str2 = getResources().getString(R.string.app_name) + "需要以下权限才能正常使用";
            for (String str3 : permissions) {
                if (!g.d(this, str3) && (b2 = g.b(str3)) != null) {
                    str2 = str2.concat("\n \n" + b2.c() + "\n" + b2.a());
                }
            }
            if (goSetting) {
                str2 = str2 + "\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。";
            }
            builder.setMessage(str2);
        } else {
            builder.setMessage(this.p.getContent());
        }
        if (goSetting) {
            ensure = "前往开启";
        } else {
            TipInfo tipInfo3 = this.p;
            ensure = (tipInfo3 == null || k.p(tipInfo3.getEnsure())) ? "重新授权" : this.p.getEnsure();
        }
        builder.setPositiveButton(ensure, new DialogInterface.OnClickListener() { // from class: com.martian.libsupport.permission.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PermissionActivity.this.w(goSetting, dialogInterface, i2);
            }
        });
        if (this.o) {
            TipInfo tipInfo4 = this.p;
            builder.setNegativeButton((tipInfo4 == null || k.p(tipInfo4.getCancel())) ? "取消" : this.p.getCancel(), new DialogInterface.OnClickListener() { // from class: com.martian.libsupport.permission.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PermissionActivity.this.y(dialogInterface, i2);
                }
            });
        }
        builder.setCancelable(false);
        builder.show();
    }

    private void requestPermissions(String[] permission) {
        try {
            ActivityCompat.requestPermissions(this, permission, 64);
        } catch (ActivityNotFoundException unused) {
            finish();
        }
    }

    private void s0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TipInfo tipInfo = this.p;
        String str = "权限申请";
        if (tipInfo != null && !k.p(tipInfo.getTitle())) {
            str = this.p.getTitle();
        }
        builder.setTitle(str);
        TipInfo tipInfo2 = this.p;
        if (tipInfo2 == null || k.p(tipInfo2.getContent())) {
            builder.setMessage("需要允许权限才能正常使用\n \n 请点击 \"前往开启\"-打开所需权限。");
        } else {
            builder.setMessage(this.p.getContent());
        }
        TipInfo tipInfo3 = this.p;
        String str2 = "前往开启";
        if (tipInfo3 != null && !k.p(tipInfo3.getEnsure())) {
            str2 = this.p.getEnsure();
        }
        TipInfo tipInfo4 = this.p;
        String str3 = "取消";
        if (tipInfo4 != null && !k.p(tipInfo4.getCancel())) {
            str3 = this.p.getCancel();
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.martian.libsupport.permission.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PermissionActivity.this.A(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.martian.libsupport.permission.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PermissionActivity.this.C(dialogInterface, i2);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void t0(String message) {
        Toast.makeText(this, message, 0).show();
    }

    public static void u0(@NonNull Context context, int permissionType, @Nullable TipInfo tip) {
        Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
        intent.putExtra(f10636i, permissionType);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        if (tip != null) {
            intent.putExtra(f10635h, tip);
        }
        context.startActivity(intent);
    }

    /* renamed from: v */
    public /* synthetic */ void w(final boolean goSetting, DialogInterface dialog, int which) {
        if (this.o || goSetting) {
            g.c(this);
        } else {
            p0();
        }
    }

    public static void v0(@NonNull Context context, @NonNull String[] permission, boolean showTip, @Nullable TipInfo tip, String key, boolean cancelable) {
        Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
        intent.putExtra(f10631d, permission);
        intent.putExtra(f10632e, key);
        intent.putExtra(f10633f, showTip);
        intent.putExtra(f10634g, cancelable);
        intent.putExtra(f10635h, tip);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    /* renamed from: x */
    public /* synthetic */ void y(DialogInterface dialog, int which) {
        p0();
    }

    /* renamed from: z */
    public /* synthetic */ void A(DialogInterface dialog, int which) {
        int i2 = this.m;
        if (i2 != 104) {
            if (i2 == 205) {
                startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 205);
                return;
            }
            return;
        }
        if (l.t()) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 104);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 104) {
            if (l.t()) {
                if (Settings.System.canWrite(getApplicationContext())) {
                    t0("授权成功");
                } else {
                    t0("修改设置权限被拒绝");
                }
            }
            finish();
            return;
        }
        if (requestCode == 205) {
            if (l.A()) {
                if (getPackageManager().canRequestPackageInstalls()) {
                    t0("授权成功");
                    q0();
                } else {
                    t0("权限未开启");
                    p0();
                }
            }
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Serializable serializableExtra;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.k = savedInstanceState.getStringArray(f10631d);
            this.l = savedInstanceState.getString(f10632e);
            this.m = savedInstanceState.getInt(f10636i);
            this.n = savedInstanceState.getBoolean(f10633f, true);
            this.o = savedInstanceState.getBoolean(f10634g, false);
            serializableExtra = savedInstanceState.getSerializable(f10635h);
        } else {
            this.k = getIntent().getStringArrayExtra(f10631d);
            this.l = getIntent().getStringExtra(f10632e);
            this.m = getIntent().getIntExtra(f10636i, -1);
            this.n = getIntent().getBooleanExtra(f10633f, true);
            this.o = getIntent().getBooleanExtra(f10634g, false);
            serializableExtra = getIntent().getSerializableExtra(f10635h);
        }
        if (serializableExtra != null) {
            this.p = (TipInfo) serializableExtra;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (!k.p(this.l)) {
            g.a(this.l);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 64 && g.e(grantResults) && g.d(this, permissions)) {
            q0();
            return;
        }
        if (!this.n) {
            p0();
            return;
        }
        for (int i2 = 0; i2 < grantResults.length; i2++) {
            if (grantResults[i2] == -1 && !ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i2])) {
                r0(permissions, true);
                return;
            }
        }
        r0(permissions, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        int i2 = this.m;
        if (i2 == 104) {
            if (!l.t() || Settings.System.canWrite(this)) {
                return;
            }
            s0();
            return;
        }
        if (i2 == 205) {
            if (!l.A() || getPackageManager().canRequestPackageInstalls()) {
                return;
            }
            s0();
            return;
        }
        if (!this.f10637j) {
            this.f10637j = true;
        } else if (g.d(this, this.k)) {
            q0();
        } else {
            requestPermissions(this.k);
            this.f10637j = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArray(f10631d, this.k);
        outState.putString(f10632e, this.l);
        outState.putBoolean(f10633f, this.n);
        outState.putBoolean(f10634g, this.o);
        outState.putSerializable(f10635h, this.p);
        outState.putInt(f10636i, this.m);
    }
}
