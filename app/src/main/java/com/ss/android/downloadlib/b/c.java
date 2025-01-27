package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: com.ss.android.downloadlib.b.c$1 */
    public static class AnonymousClass1 implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21539b;

        public AnonymousClass1(com.ss.android.downloadlib.guide.install.a aVar) {
            aVar = aVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            if (m.b(com.ss.android.downloadad.api.a.b.this)) {
                return;
            }
            com.ss.android.downloadad.api.a.b.this.m(true);
            com.ss.android.downloadlib.d.a.a().a("install_delay_invoke", com.ss.android.downloadad.api.a.b.this);
            aVar.a();
        }
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            m.c();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && isAppForeground2 && bVar != null) {
            bVar.l(true);
        }
        aVar.a();
        Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + isAppForeground2);
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.b.c.1

            /* renamed from: b */
            final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21539b;

            public AnonymousClass1(com.ss.android.downloadlib.guide.install.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                if (m.b(com.ss.android.downloadad.api.a.b.this)) {
                    return;
                }
                com.ss.android.downloadad.api.a.b.this.m(true);
                com.ss.android.downloadlib.d.a.a().a("install_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                aVar.a();
            }
        });
    }
}
