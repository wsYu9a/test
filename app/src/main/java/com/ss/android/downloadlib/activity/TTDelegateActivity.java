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
import com.alipay.sdk.authjs.a;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.zx;
import com.ss.android.downloadad.api.j.zx;
import com.ss.android.downloadlib.addownload.j.g;
import com.ss.android.downloadlib.addownload.nt;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.downloadlib.guide.install.j;
import com.ss.android.downloadlib.y;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: g */
    private static j f24098g;

    /* renamed from: i */
    private zx f24099i;

    /* renamed from: j */
    protected Intent f24100j = null;
    private boolean zx;

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$2 */
    class AnonymousClass2 implements zx.InterfaceC0493zx {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24103j;

        AnonymousClass2(com.ss.android.downloadad.api.j.zx zxVar) {
            g2 = zxVar;
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void i(DialogInterface dialogInterface) {
            i.j((Activity) TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void j(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.zx.j.zx(g2);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            i.j((Activity) TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
        public void zx(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.g.j.j().zx("market_openapp_cancel", g2);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            i.j((Activity) TTDelegateActivity.this);
        }
    }

    private void g(long j2) {
        new com.ss.android.downloadlib.addownload.compliance.j(this, j2).show();
    }

    private static Intent i(@NonNull com.ss.android.downloadad.api.j.j jVar) {
        return new Intent(pa.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void j(String str, String[] strArr) {
        Intent intent = new Intent(pa.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (pa.getContext() != null) {
            pa.getContext().startActivity(intent);
        }
    }

    public static void zx(String str, com.ss.android.downloadad.api.j.j jVar) {
        Intent i2 = i(jVar);
        i2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        i2.putExtra("type", 11);
        i2.putExtra("package_name", str);
        if (pa.getContext() != null) {
            pa.getContext().startActivity(i2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zx();
        this.f24100j = getIntent();
        pa.zx(this);
        j();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f24100j = intent;
        pa.zx(this);
        j();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        pa.q().j(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        DownloadInfo zx;
        super.onStop();
        if (!this.zx || this.f24099i == null || (zx = y.j((Context) null).zx(this.f24099i.j())) == null || zx.getCurBytes() < zx.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity$1 */
    class AnonymousClass1 implements gm {

        /* renamed from: i */
        private WeakReference<Activity> f24101i;

        /* renamed from: j */
        final /* synthetic */ String f24102j;

        AnonymousClass1(String str) {
            str = str;
            this.f24101i = new WeakReference<>(TTDelegateActivity.this);
        }

        @Override // com.ss.android.download.api.config.gm
        public void j() {
            com.ss.android.downloadlib.lg.pa.j(str);
            i.j(this.f24101i.get());
        }

        @Override // com.ss.android.download.api.config.gm
        public void j(String str) {
            com.ss.android.downloadlib.lg.pa.j(str, str);
            i.j(this.f24101i.get());
        }
    }

    private void i() {
        String str;
        long longExtra = this.f24100j.getLongExtra("model_id", 0L);
        String stringExtra = this.f24100j.getStringExtra("message_text");
        String stringExtra2 = this.f24100j.getStringExtra("positive_button_text");
        String stringExtra3 = this.f24100j.getStringExtra("negative_button_text");
        int intExtra = this.f24100j.getIntExtra("type", 0);
        com.ss.android.downloadad.api.j.zx g2 = gv.j().g(longExtra);
        g.j i2 = new g.j(this).j(false).j(stringExtra).zx(stringExtra2).i(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.g.zx.j() == null) {
                return;
            }
            i2.j(com.ss.android.downloadlib.addownload.g.zx.j());
            i2.j().show();
            str = "download_percent";
        } else if (intExtra != 8) {
            str = "";
        } else {
            if (com.ss.android.downloadlib.addownload.g.j.j() == null) {
                return;
            }
            i2.j(com.ss.android.downloadlib.addownload.g.j.j());
            i2.j().show();
            str = "apk_size";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zx = true;
        this.f24099i = g2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, g2);
    }

    public static void zx(@NonNull com.ss.android.downloadad.api.j.j jVar) {
        j(jVar, 5, "", "", "");
    }

    public static void j(String str, com.ss.android.downloadad.api.j.j jVar) {
        Intent i2 = i(jVar);
        i2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        i2.putExtra("type", 2);
        i2.putExtra("open_url", str);
        if (pa.getContext() != null) {
            pa.getContext().startActivity(i2);
        }
    }

    public static void zx(@NonNull com.ss.android.downloadad.api.j.j jVar, String str, String str2, String str3) {
        j(jVar, 7, str, str2, str3);
    }

    private void zx() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void zx(long j2) {
        if (nt.j() == null) {
            return;
        }
        com.ss.android.downloadad.api.j.zx g2 = gv.j().g(j2);
        if (g2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(g2.v());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - g2.az()));
                jSONObject.putOpt("click_download_size", Long.valueOf(g2.vy()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_dialog_show", jSONObject, g2);
        }
        new g.j(this).j(false).j(nt.j()).j().show();
        this.zx = true;
        this.f24099i = g2;
    }

    public static void j(com.ss.android.downloadad.api.j.j jVar) {
        Intent i2 = i(jVar);
        i2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        i2.putExtra("type", 4);
        i2.putExtra("model_id", jVar.zx());
        if (pa.getContext() != null) {
            pa.getContext().startActivity(i2);
        }
    }

    public static void j(com.ss.android.downloadad.api.j.j jVar, j jVar2) {
        Intent i2 = i(jVar);
        i2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        i2.putExtra("type", 9);
        f24098g = jVar2;
        if (pa.getContext() != null) {
            pa.getContext().startActivity(i2);
        }
    }

    public static void j(long j2) {
        Intent intent = new Intent(pa.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j2);
        if (pa.getContext() != null) {
            pa.getContext().startActivity(intent);
        }
    }

    private void i(long j2) {
        com.ss.android.downloadad.api.j.zx g2 = gv.j().g(j2);
        if (g2 == null) {
            com.ss.android.downloadlib.q.i.j().j("showOpenAppDialogInner nativeModel null");
            i.j((Activity) this);
            return;
        }
        com.ss.android.download.api.config.nt i2 = pa.i();
        zx.j j3 = new zx.j(this).j("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(g2.um()) ? "刚刚下载的应用" : g2.um();
        i2.zx(j3.zx(String.format("%1$s已安装完成，是否立即打开？", objArr)).i("打开").g("取消").j(false).j(com.ss.android.downloadlib.lg.nt.i(this, g2.q())).j(new zx.InterfaceC0493zx() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2

            /* renamed from: j */
            final /* synthetic */ com.ss.android.downloadad.api.j.zx f24103j;

            AnonymousClass2(com.ss.android.downloadad.api.j.zx g22) {
                g2 = g22;
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void i(DialogInterface dialogInterface) {
                i.j((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void j(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.zx.j.zx(g2);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                i.j((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void zx(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.j.j().zx("market_openapp_cancel", g2);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                i.j((Activity) TTDelegateActivity.this);
            }
        }).j(2).j());
        com.ss.android.downloadlib.g.j.j().zx("market_openapp_window_show", g22);
    }

    private void zx(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            AnonymousClass1 anonymousClass1 = new gm() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* renamed from: i */
                private WeakReference<Activity> f24101i;

                /* renamed from: j */
                final /* synthetic */ String f24102j;

                AnonymousClass1(String str2) {
                    str = str2;
                    this.f24101i = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.gm
                public void j() {
                    com.ss.android.downloadlib.lg.pa.j(str);
                    i.j(this.f24101i.get());
                }

                @Override // com.ss.android.download.api.config.gm
                public void j(String str2) {
                    com.ss.android.downloadlib.lg.pa.j(str, str2);
                    i.j(this.f24101i.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    pa.q().j(this, strArr, anonymousClass1);
                    return;
                } catch (Exception e2) {
                    pa.v().j(e2, "requestPermission");
                    anonymousClass1.j();
                    return;
                }
            }
            anonymousClass1.j();
            return;
        }
        i.j((Activity) this);
    }

    public static void j(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(pa.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j2);
        intent.putExtra(a.f5379f, str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (pa.getContext() != null) {
            pa.getContext().startActivity(intent);
        }
    }

    private void zx(String str) {
        Intent gv = com.ss.android.downloadlib.lg.nt.gv(this, str);
        if (gv == null) {
            return;
        }
        try {
            try {
                gv.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                gv.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(gv);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            i.j((Activity) this);
        }
    }

    public static void j(@NonNull com.ss.android.downloadad.api.j.j jVar, String str, String str2, String str3) {
        j(jVar, 8, str, str2, str3);
    }

    private static void j(@NonNull com.ss.android.downloadad.api.j.j jVar, int i2, String str, String str2, String str3) {
        Intent i3 = i(jVar);
        i3.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        i3.putExtra("type", i2);
        if (!TextUtils.isEmpty(str2)) {
            i3.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            i3.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            i3.putExtra("message_text", str);
        }
        i3.putExtra("model_id", jVar.zx());
        if (pa.getContext() != null) {
            pa.getContext().startActivity(i3);
        }
    }

    protected void j() {
        Intent intent = this.f24100j;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                zx(this.f24100j.getStringExtra("permission_id_key"), this.f24100j.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                j(this.f24100j.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                i.j((Activity) this);
                break;
            case 4:
                i(this.f24100j.getLongExtra("model_id", 0L));
                break;
            case 5:
                zx(this.f24100j.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                i();
                break;
            case 9:
                j jVar = f24098g;
                if (jVar != null) {
                    jVar.j();
                }
                i.j((Activity) this);
                break;
            case 10:
                g(this.f24100j.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                zx(this.f24100j.getStringExtra("package_name"));
                break;
            case 12:
                com.ss.android.downloadlib.lg.y.j(this, this.f24100j.getStringExtra("package_name"), this.f24100j.getLongExtra("model_id", 0L), this.f24100j.getStringExtra(a.f5379f), this.f24100j.getStringExtra("ext_json"));
                i.j((Activity) this);
                break;
        }
        this.f24100j = null;
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra("open_url", str);
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            i.j((Activity) this);
        }
    }
}
