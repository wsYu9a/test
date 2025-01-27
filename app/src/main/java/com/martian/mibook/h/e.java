package com.martian.mibook.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.g.h;
import com.martian.libmars.utils.q0;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class e extends com.martian.apptask.e.b {
    static /* synthetic */ void c(final Context context, final AppTask appTask, final String packageName) {
        com.martian.apptask.g.g.u(context, appTask.dplink, packageName, appTask.name, true);
        MiConfigSingleton.V3().F6(packageName);
    }

    static /* synthetic */ void d(final Context context, final String packageName, final AppTask appTask) {
        if (com.martian.apptask.g.g.s(context, packageName)) {
            h.b(appTask.openAppReportUrls);
        }
    }

    @Override // com.martian.apptask.e.b
    protected void a(final Context context, final String packageName) {
        super.a(context, packageName);
        com.martian.mibook.lib.model.g.b.t(context, packageName);
        final AppTask s3 = MiConfigSingleton.V3().s3(packageName);
        if (s3 != null) {
            q0.i("INSTALLReceiver", "install finished");
            h.b(s3.installFinishedReportUrls);
            if (!TextUtils.isEmpty(s3.dplink) && com.martian.apptask.g.g.b(context, s3.dplink)) {
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.h.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.c(context, s3, packageName);
                    }
                }, 5000L);
                return;
            }
            MiConfigSingleton.V3().F6(packageName);
            try {
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.h.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.d(context, packageName, s3);
                    }
                }, 5000L);
            } catch (Exception unused) {
            }
        }
    }
}
