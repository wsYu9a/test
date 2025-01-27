package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.i.i;
import com.ss.android.socialbase.appdownloader.i.nt;
import com.ss.android.socialbase.appdownloader.i.t;
import com.ss.android.socialbase.appdownloader.k;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: classes4.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: j */
    private t f24494j;
    private Intent zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$1 */
    class AnonymousClass1 implements DialogInterface.OnCancelListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$2 */
    class AnonymousClass2 implements DialogInterface.OnClickListener {

        /* renamed from: i */
        final /* synthetic */ int f24497i;

        /* renamed from: j */
        final /* synthetic */ boolean f24498j;
        final /* synthetic */ DownloadInfo zx;

        AnonymousClass2(boolean z, DownloadInfo downloadInfo, int i2) {
            z = z;
            downloadInfo = downloadInfo;
            intExtra = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (z) {
                DownloadTaskDeleteActivity.this.j(downloadInfo, intExtra);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3 */
    class AnonymousClass3 implements DialogInterface.OnClickListener {

        /* renamed from: i */
        final /* synthetic */ int f24500i;

        /* renamed from: j */
        final /* synthetic */ boolean f24501j;
        final /* synthetic */ DownloadInfo zx;

        /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
            }
        }

        AnonymousClass3(boolean z, DownloadInfo downloadInfo, int i2) {
            z = z;
            downloadInfo = downloadInfo;
            intExtra = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (z) {
                downloadInfo.setOnlyWifi(true);
                Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                    }
                }, 100L);
            } else {
                DownloadTaskDeleteActivity.this.j(downloadInfo, intExtra);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    private void zx() {
        Intent intent;
        if (this.f24494j != null || (intent = this.zx) == null) {
            return;
        }
        try {
            boolean z = false;
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                Log.w("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(k.j(this, "tt_appdownloader_notification_download_delete")), title);
            i j2 = g.pa().j();
            nt j3 = j2 != null ? j2.j(this) : null;
            if (j3 == null) {
                j3 = new com.ss.android.socialbase.appdownloader.g.j(this);
            }
            int j4 = k.j(this, "tt_appdownloader_tip");
            int j5 = k.j(this, "tt_appdownloader_label_ok");
            int j6 = k.j(this, "tt_appdownloader_label_cancel");
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) == 1 && DownloadUtils.isNoWifiAndInNet() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                j5 = k.j(this, "tt_appdownloader_label_reserve_wifi");
                j6 = k.j(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(k.j(this, "tt_appdownloader_resume_in_wifi"));
            }
            j3.j(j4).j(format).j(j5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3

                /* renamed from: i */
                final /* synthetic */ int f24500i;

                /* renamed from: j */
                final /* synthetic */ boolean f24501j;
                final /* synthetic */ DownloadInfo zx;

                /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                    }
                }

                AnonymousClass3(boolean z2, DownloadInfo downloadInfo2, int intExtra2) {
                    z = z2;
                    downloadInfo = downloadInfo2;
                    intExtra = intExtra2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.j(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).zx(j6, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2

                /* renamed from: i */
                final /* synthetic */ int f24497i;

                /* renamed from: j */
                final /* synthetic */ boolean f24498j;
                final /* synthetic */ DownloadInfo zx;

                AnonymousClass2(boolean z2, DownloadInfo downloadInfo2, int intExtra2) {
                    z = z2;
                    downloadInfo = downloadInfo2;
                    intExtra = intExtra2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.j(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).j(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.f24494j = j3.j();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        j();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.zx = getIntent();
        zx();
        t tVar = this.f24494j;
        if (tVar != null && !tVar.zx()) {
            this.f24494j.j();
        } else if (this.f24494j == null) {
            finish();
        }
    }

    private void j() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public void j(DownloadInfo downloadInfo, int i2) {
        com.ss.android.socialbase.appdownloader.i.g zx = g.pa().zx();
        if (zx != null) {
            zx.j(downloadInfo);
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i2);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (DownloadComponentManager.getAppContext() != null) {
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i2);
        }
    }
}
