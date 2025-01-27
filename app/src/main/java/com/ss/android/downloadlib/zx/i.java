package com.ss.android.downloadlib.zx;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: com.ss.android.downloadlib.zx.i$1 */
    static class AnonymousClass1 implements AppStatusManager.AppStatusChangeListener {
        final /* synthetic */ com.ss.android.downloadlib.guide.install.j zx;

        AnonymousClass1(com.ss.android.downloadlib.guide.install.j jVar) {
            jVar = jVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            if (nt.zx(com.ss.android.downloadad.api.j.zx.this)) {
                return;
            }
            com.ss.android.downloadad.api.j.zx.this.p(true);
            com.ss.android.downloadlib.g.j.j().j("install_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
            jVar.j();
        }
    }

    public static void j(com.ss.android.downloadad.api.j.zx zxVar, @NonNull com.ss.android.downloadlib.guide.install.j jVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            nt.zx();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && isAppForeground2 && zxVar != null) {
            zxVar.nt(true);
        }
        jVar.j();
        Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + isAppForeground2);
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.zx.i.1
            final /* synthetic */ com.ss.android.downloadlib.guide.install.j zx;

            AnonymousClass1(com.ss.android.downloadlib.guide.install.j jVar2) {
                jVar = jVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                if (nt.zx(com.ss.android.downloadad.api.j.zx.this)) {
                    return;
                }
                com.ss.android.downloadad.api.j.zx.this.p(true);
                com.ss.android.downloadlib.g.j.j().j("install_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
                jVar.j();
            }
        });
    }
}
