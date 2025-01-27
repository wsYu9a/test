package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: classes3.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    private static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private static final String TAG = "KSAd_DYI";

    /* renamed from: com.kwad.sdk.api.loader.DynamicInstallReceiver$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ File aqb;
        final /* synthetic */ String aqc;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, File file, String str) {
            context = context;
            file = file;
            stringExtra2 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (d.a(context, AnonymousClass1.class.getClassLoader(), file.getPath(), stringExtra2)) {
                    Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk success");
                    i.p(context, stringExtra2);
                    j.h(file);
                }
            } catch (Exception e10) {
                Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk error:" + e10);
                e10.printStackTrace();
            }
        }
    }

    @Keep
    public static void registerToApp(Context context) {
        if (context != null) {
            AtomicBoolean atomicBoolean = HAS_REGISTER;
            if (atomicBoolean.get() || context.getApplicationContext() == null) {
                return;
            }
            String str = context.getPackageName() + ".loader.install.DynamicApk";
            Log.i(TAG, "registerToApp action:" + str);
            IntentFilter intentFilter = new IntentFilter(str);
            Context applicationContext = context.getApplicationContext();
            if (Build.VERSION.SDK_INT >= 33) {
                applicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter, 2);
            } else {
                applicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter);
            }
            atomicBoolean.set(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive success");
        if (intent == null) {
            Log.i(TAG, "intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        String stringExtra2 = intent.getStringExtra(b7.b.f1305b0);
        File file = new File(stringExtra);
        if (!file.exists()) {
            Log.i(TAG, "downloadFile not exists: " + file);
        } else {
            Log.i(TAG, "downloadFile is exists, apkPath :" + stringExtra + " sdkVersion:" + stringExtra2);
            AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
                final /* synthetic */ File aqb;
                final /* synthetic */ String aqc;
                final /* synthetic */ Context hB;

                public AnonymousClass1(Context context2, File file2, String stringExtra22) {
                    context = context2;
                    file = file2;
                    stringExtra2 = stringExtra22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (d.a(context, AnonymousClass1.class.getClassLoader(), file.getPath(), stringExtra2)) {
                            Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk success");
                            i.p(context, stringExtra2);
                            j.h(file);
                        }
                    } catch (Exception e10) {
                        Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk error:" + e10);
                        e10.printStackTrace();
                    }
                }
            });
        }
    }
}
