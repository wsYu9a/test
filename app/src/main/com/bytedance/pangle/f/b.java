package com.bytedance.pangle.f;

import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.d;

/* loaded from: classes2.dex */
public final class b extends d.a {

    /* renamed from: a */
    private final ZeusPluginInstallListener f7618a;

    public b(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f7618a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public final void a(String str, int i10, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f7618a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i10, str2);
        }
    }
}
