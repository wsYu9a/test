package com.vivo.mobilead.manager;

import android.app.Application;
import androidx.annotation.NonNull;
import com.vivo.mobilead.model.VAdConfig;

/* loaded from: classes.dex */
public class VivoAdManager {

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a */
        private static final VivoAdManager f29500a = new VivoAdManager();
    }

    /* synthetic */ VivoAdManager(a aVar) {
        this();
    }

    public static VivoAdManager getInstance() {
        return b.f29500a;
    }

    public void init(@NonNull Application application, @NonNull String str) {
        f.j().a(application, str);
    }

    public void useTestServer(String str) {
        com.vivo.mobilead.model.a.a(str);
    }

    private VivoAdManager() {
    }

    public void init(@NonNull Application application, @NonNull String str, VInitCallback vInitCallback) {
        f.j().a(application, str, vInitCallback);
    }

    public void init(@NonNull Application application, @NonNull VAdConfig vAdConfig, VInitCallback vInitCallback) {
        f.j().a(application, vAdConfig, vInitCallback);
    }
}
