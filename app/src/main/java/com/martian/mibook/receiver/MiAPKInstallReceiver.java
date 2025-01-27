package com.martian.mibook.receiver;

import ac.a;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.receiver.APKInstallReceiver;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.receiver.MiAPKInstallReceiver;
import i8.g;
import i8.h;

/* loaded from: classes3.dex */
public class MiAPKInstallReceiver extends APKInstallReceiver {
    public static /* synthetic */ void e(Context context, AppTask appTask, String str) {
        g.A(context, appTask.dplink, str, appTask.name, true);
        MiConfigSingleton.b2().e2().s0(str);
    }

    public static /* synthetic */ void f(Context context, String str, AppTask appTask) {
        if (g.y(context, str)) {
            h.b(appTask.openAppReportUrls);
        }
    }

    @Override // com.martian.apptask.receiver.APKInstallReceiver
    public void a(Context context, String str) {
        super.a(context, str);
        a.q(context, str);
        AppTask v10 = MiConfigSingleton.b2().e2().v(str);
        if (v10 != null) {
            h.b(v10.installFinishedReportUrls);
            if (!TextUtils.isEmpty(v10.dplink) && g.h(context, v10.dplink)) {
                new Handler().postDelayed(new Runnable() { // from class: yd.a

                    /* renamed from: b */
                    public final /* synthetic */ Context f33483b;

                    /* renamed from: c */
                    public final /* synthetic */ AppTask f33484c;

                    /* renamed from: d */
                    public final /* synthetic */ String f33485d;

                    public /* synthetic */ a(Context context2, AppTask v102, String str2) {
                        context = context2;
                        v10 = v102;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MiAPKInstallReceiver.e(context, v10, str);
                    }
                }, 5000L);
                return;
            }
            MiConfigSingleton.b2().e2().s0(str2);
            try {
                new Handler().postDelayed(new Runnable() { // from class: yd.b

                    /* renamed from: b */
                    public final /* synthetic */ Context f33486b;

                    /* renamed from: c */
                    public final /* synthetic */ String f33487c;

                    /* renamed from: d */
                    public final /* synthetic */ AppTask f33488d;

                    public /* synthetic */ b(Context context2, String str2, AppTask v102) {
                        context = context2;
                        str = str2;
                        v10 = v102;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MiAPKInstallReceiver.f(context, str, v10);
                    }
                }, 5000L);
            } catch (Exception unused) {
            }
        }
    }
}
