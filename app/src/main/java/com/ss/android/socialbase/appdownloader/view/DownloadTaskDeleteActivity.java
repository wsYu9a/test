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
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: classes4.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: a */
    private k f21950a;

    /* renamed from: b */
    private Intent f21951b;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$1 */
    public class AnonymousClass1 implements DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$2 */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f21953a;

        /* renamed from: b */
        final /* synthetic */ DownloadInfo f21954b;

        /* renamed from: c */
        final /* synthetic */ int f21955c;

        public AnonymousClass2(boolean z10, DownloadInfo downloadInfo, int i10) {
            z10 = z10;
            downloadInfo = downloadInfo;
            intExtra = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (z10) {
                DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3 */
    public class AnonymousClass3 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ boolean f21957a;

        /* renamed from: b */
        final /* synthetic */ DownloadInfo f21958b;

        /* renamed from: c */
        final /* synthetic */ int f21959c;

        /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
            }
        }

        public AnonymousClass3(boolean z10, DownloadInfo downloadInfo, int i10) {
            z10 = z10;
            downloadInfo = downloadInfo;
            intExtra = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (z10) {
                downloadInfo.setOnlyWifi(true);
                Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                    }
                }, 100L);
            } else {
                DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    private void b() {
        Intent intent;
        boolean z10 = true;
        if (this.f21950a != null || (intent = this.f21951b) == null) {
            return;
        }
        try {
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
            String format = String.format(getString(i.a(this, "tt_appdownloader_notification_download_delete")), title);
            c a10 = d.j().a();
            l a11 = a10 != null ? a10.a(this) : null;
            if (a11 == null) {
                a11 = new com.ss.android.socialbase.appdownloader.d.a(this);
            }
            int a12 = i.a(this, "tt_appdownloader_tip");
            int a13 = i.a(this, "tt_appdownloader_label_ok");
            int a14 = i.a(this, "tt_appdownloader_label_cancel");
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) != 1 || !DownloadUtils.isNoWifiAndInNet() || downloadInfo.getCurBytes() == downloadInfo.getTotalBytes()) {
                z10 = false;
            }
            if (z10) {
                a13 = i.a(this, "tt_appdownloader_label_reserve_wifi");
                a14 = i.a(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(i.a(this, "tt_appdownloader_resume_in_wifi"));
            }
            a11.a(a12).a(format).a(a13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3

                /* renamed from: a */
                final /* synthetic */ boolean f21957a;

                /* renamed from: b */
                final /* synthetic */ DownloadInfo f21958b;

                /* renamed from: c */
                final /* synthetic */ int f21959c;

                /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                    }
                }

                public AnonymousClass3(boolean z102, DownloadInfo downloadInfo2, int intExtra2) {
                    z10 = z102;
                    downloadInfo = downloadInfo2;
                    intExtra = intExtra2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (z10) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).b(a14, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2

                /* renamed from: a */
                final /* synthetic */ boolean f21953a;

                /* renamed from: b */
                final /* synthetic */ DownloadInfo f21954b;

                /* renamed from: c */
                final /* synthetic */ int f21955c;

                public AnonymousClass2(boolean z102, DownloadInfo downloadInfo2, int intExtra2) {
                    z10 = z102;
                    downloadInfo = downloadInfo2;
                    intExtra = intExtra2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (z10) {
                        DownloadTaskDeleteActivity.this.a(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                public AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.f21950a = a11.a();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f21951b = getIntent();
        b();
        k kVar = this.f21950a;
        if (kVar != null && !kVar.b()) {
            this.f21950a.a();
        } else if (this.f21950a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public void a(DownloadInfo downloadInfo, int i10) {
        com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
        if (b10 != null) {
            b10.a(downloadInfo);
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i10);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (DownloadComponentManager.getAppContext() != null) {
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i10);
        }
    }
}
