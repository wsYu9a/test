package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.a.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.downloadlib.i;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: d */
    private static a f21129d;

    /* renamed from: a */
    protected Intent f21130a = null;

    /* renamed from: b */
    private boolean f21131b;

    /* renamed from: c */
    private b f21132c;

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$2 */
    public class AnonymousClass2 implements b.InterfaceC0631b {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21136a;

        public AnonymousClass2(com.ss.android.downloadad.api.a.b bVar) {
            d10 = bVar;
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void a(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.b.a.b(d10);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            c.a((Activity) TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void b(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", d10);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            c.a((Activity) TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.b.InterfaceC0631b
        public void c(DialogInterface dialogInterface) {
            c.a((Activity) TTDelegateActivity.this);
        }
    }

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c10 = c(aVar);
        c10.addFlags(268435456);
        c10.putExtra("type", 11);
        c10.putExtra("package_name", str);
        if (k.a() != null) {
            k.a().startActivity(c10);
        }
    }

    private static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.f21130a = getIntent();
        k.b(this);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f21130a = intent;
        k.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        k.f().a(this, i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        com.ss.android.downloadad.api.a.b bVar;
        super.onStop();
        if (!this.f21131b || (bVar = this.f21132c) == null) {
            return;
        }
        DownloadInfo a10 = !TextUtils.isEmpty(bVar.af()) ? i.a(k.a()).a(this.f21132c.af(), null, true) : i.a(k.a()).b(this.f21132c.a());
        if (a10 == null || a10.getCurBytes() < a10.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$1 */
    public class AnonymousClass1 implements t {

        /* renamed from: a */
        final /* synthetic */ String f21133a;

        /* renamed from: c */
        private WeakReference<Activity> f21135c;

        public AnonymousClass1(String str) {
            str = str;
            this.f21135c = new WeakReference<>(TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.config.t
        public void a() {
            j.a(str);
            c.a(this.f21135c.get());
        }

        @Override // com.ss.android.download.api.config.t
        public void a(String str) {
            j.a(str, str);
            c.a(this.f21135c.get());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.c():void");
    }

    public static void b(String str, long j10, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("market_app_id", str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c10 = c(aVar);
        c10.addFlags(268435456);
        c10.putExtra("type", 2);
        c10.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (k.a() != null) {
            k.a().startActivity(c10);
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Intent c10 = c(aVar);
        c10.addFlags(268435456);
        c10.putExtra("type", 4);
        c10.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c10);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        a(aVar, 5, "", "", "", "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3, "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 20, str, str2, str3, str4);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Intent c10 = c(aVar);
        c10.addFlags(268435456);
        c10.putExtra("type", 9);
        f21129d = aVar2;
        if (k.a() != null) {
            k.a().startActivity(c10);
        }
    }

    private void b(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            AnonymousClass1 anonymousClass1 = new t() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* renamed from: a */
                final /* synthetic */ String f21133a;

                /* renamed from: c */
                private WeakReference<Activity> f21135c;

                public AnonymousClass1(String str2) {
                    str = str2;
                    this.f21135c = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.t
                public void a() {
                    j.a(str);
                    c.a(this.f21135c.get());
                }

                @Override // com.ss.android.download.api.config.t
                public void a(String str2) {
                    j.a(str, str2);
                    c.a(this.f21135c.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    k.f().a(this, strArr, anonymousClass1);
                    return;
                } catch (Exception e10) {
                    k.u().a(e10, "requestPermission");
                    anonymousClass1.a();
                    return;
                }
            }
            anonymousClass1.a();
            return;
        }
        c.a((Activity) this);
    }

    public static void a(long j10) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j10);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(String str) {
        Intent g10 = m.g(this, str);
        if (g10 == null) {
            return;
        }
        try {
            try {
                g10.addFlags(268435456);
                g10.putExtra("start_only_for_android", true);
                startActivity(g10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } finally {
            c.a((Activity) this);
        }
    }

    public static void a(String str, long j10, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(long j10) {
        com.ss.android.downloadad.api.a.b d10 = f.a().d(j10);
        if (d10 == null) {
            com.ss.android.downloadlib.e.c.a().a("showOpenAppDialogInner nativeModel null");
            c.a((Activity) this);
        } else {
            k.d().b(new b.a(this).a("已安装完成").b(String.format("%1$s已安装完成，是否立即打开？", TextUtils.isEmpty(d10.N()) ? "刚刚下载的应用" : d10.N())).c("打开").d("取消").a(false).a(m.d(this, d10.e())).a(new b.InterfaceC0631b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2

                /* renamed from: a */
                final /* synthetic */ com.ss.android.downloadad.api.a.b f21136a;

                public AnonymousClass2(com.ss.android.downloadad.api.a.b d102) {
                    d10 = d102;
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void a(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.b.a.b(d10);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    c.a((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", d10);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    c.a((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void c(DialogInterface dialogInterface) {
                    c.a((Activity) TTDelegateActivity.this);
                }
            }).a(2).a());
            com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", d102);
        }
    }

    public static void a(String str, long j10, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        intent.putExtra("need_comment", str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, long j10) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void c(long j10) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j10).show();
    }

    public static void a(Context context, String str, long j10) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 16);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j10);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str) {
        a(aVar, 19, "", "", "", str);
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3, "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 21, str, str2, str3, str4);
    }

    private static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i10, String str, String str2, String str3, String str4) {
        Intent c10 = c(aVar);
        c10.addFlags(268435456);
        c10.putExtra("type", i10);
        if (!TextUtils.isEmpty(str2)) {
            c10.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            c10.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            c10.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            c10.putExtra("message_text", str);
        }
        c10.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c10);
        }
    }

    public void a() {
        Intent intent = this.f21130a;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.f21130a.getStringExtra("permission_id_key"), this.f21130a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.f21130a.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                break;
            case 3:
            case 6:
            case 17:
            case 18:
            default:
                c.a((Activity) this);
                break;
            case 4:
                b(this.f21130a.getLongExtra("model_id", 0L));
                break;
            case 5:
                a(this.f21130a.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                c();
                break;
            case 9:
                a aVar = f21129d;
                if (aVar != null) {
                    aVar.a();
                }
                c.a((Activity) this);
                break;
            case 10:
                c(this.f21130a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.f21130a.getStringExtra("package_name"));
                break;
            case 12:
                h.a(this, this.f21130a.getStringExtra("package_name"), this.f21130a.getLongExtra("model_id", 0L), this.f21130a.getStringExtra("param"), this.f21130a.getStringExtra("ext_json"));
                c.a((Activity) this);
                break;
            case 13:
                h.a(this, this.f21130a.getStringExtra("package_name"), this.f21130a.getLongExtra("model_id", 0L), this.f21130a.getStringExtra("need_comment"));
                c.a((Activity) this);
                break;
            case 14:
                h.b(this, this.f21130a.getStringExtra("package_name"), this.f21130a.getLongExtra("model_id", 0L), this.f21130a.getStringExtra("market_app_id"));
                c.a((Activity) this);
                break;
            case 15:
                h.a(this, this.f21130a.getStringExtra("package_name"), this.f21130a.getLongExtra("model_id", 0L));
                c.a((Activity) this);
                break;
            case 16:
                h.b(this, this.f21130a.getStringExtra("package_name"), this.f21130a.getLongExtra("model_id", 0L));
                c.a((Activity) this);
                break;
            case 19:
                a(this.f21130a.getLongExtra("model_id", 0L), this.f21130a.getStringExtra("delete_button_text"));
                break;
        }
        this.f21130a = null;
    }

    private void a(long j10, String str) {
        if (n.a() == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b d10 = f.a().d(j10);
        if (d10 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(d10.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d10.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(d10.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_dialog_show", jSONObject, d10);
            } else {
                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, d10);
            }
        }
        e.a a10 = new e.a(this).a(false).a(n.a());
        if (!TextUtils.isEmpty(str)) {
            a10.d(str).a(n.b());
        }
        a10.a().show();
        this.f21131b = true;
        this.f21132c = d10;
    }

    private void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                c.a((Activity) this);
                return;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
                intent.addFlags(268435456);
                if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            c.a((Activity) this);
        } catch (Throwable th2) {
            c.a((Activity) this);
            throw th2;
        }
    }
}
