package com.martian.mibook.application;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.martian.mibook.activity.KeepLiveActivity;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a */
    private static final l0 f11487a = new l0();

    /* renamed from: b */
    private WeakReference<KeepLiveActivity> f11488b;

    /* renamed from: c */
    private com.martian.mibook.h.c f11489c;

    private l0() {
    }

    public static l0 b() {
        return f11487a;
    }

    public void a() {
        WeakReference<KeepLiveActivity> weakReference = this.f11488b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f11488b.get().finish();
    }

    public void c(Context context) {
        this.f11489c = new com.martian.mibook.h.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(this.f11489c, intentFilter);
    }

    public void d(KeepLiveActivity activity) {
        this.f11488b = new WeakReference<>(activity);
    }

    public void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) KeepLiveActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public void f(Context context) {
        com.martian.mibook.h.c cVar = this.f11489c;
        if (cVar != null) {
            try {
                context.unregisterReceiver(cVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
