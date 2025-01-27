package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: classes2.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    private static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private static final String TAG = "DynamicInstallReceiver";

    /* renamed from: com.kwad.sdk.api.loader.DynamicInstallReceiver$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ File ZD;
        final /* synthetic */ String ZE;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, File file, String str) {
            context = context;
            file = file;
            stringExtra2 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (b.a(context, getClass().getClassLoader(), file.getPath(), stringExtra2)) {
                    Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk success");
                    g.i(context, stringExtra2);
                    h.c(file);
                }
            } catch (Exception e2) {
                Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk error:" + e2);
                e2.printStackTrace();
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
            context.getApplicationContext().registerReceiver(new DynamicInstallReceiver(), new IntentFilter(str));
            atomicBoolean.set(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive success");
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        String stringExtra2 = intent.getStringExtra("sdkVersion");
        File file = new File(stringExtra);
        if (file.exists()) {
            Log.i(TAG, "downloadFile is exists, apkPath :" + stringExtra + " sdkVersion:" + stringExtra2);
            AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
                final /* synthetic */ File ZD;
                final /* synthetic */ String ZE;
                final /* synthetic */ Context jN;

                AnonymousClass1(Context context2, File file2, String stringExtra22) {
                    context = context2;
                    file = file2;
                    stringExtra2 = stringExtra22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (b.a(context, getClass().getClassLoader(), file.getPath(), stringExtra2)) {
                            Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk success");
                            g.i(context, stringExtra2);
                            h.c(file);
                        }
                    } catch (Exception e2) {
                        Log.i(DynamicInstallReceiver.TAG, "onReceive ApkInstaller installApk error:" + e2);
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
