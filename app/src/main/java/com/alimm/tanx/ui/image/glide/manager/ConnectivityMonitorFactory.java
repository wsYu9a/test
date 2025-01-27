package com.alimm.tanx.ui.image.glide.manager;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes.dex */
public class ConnectivityMonitorFactory {
    public ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        return context.checkCallingOrSelfPermission(g.f11101b) == 0 ? new DefaultConnectivityMonitor(context, connectivityListener) : new NullConnectivityMonitor();
    }
}
