package com.bytedance.pangle.f;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;

/* loaded from: classes2.dex */
public final class c extends ZeusPluginStateListener {

    /* renamed from: a */
    final int f7619a;

    /* renamed from: b */
    private final d f7620b;

    public c(d dVar, int i10) {
        this.f7620b = dVar;
        this.f7619a = i10;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(String str, int i10, Object... objArr) {
        if (i10 == 5 || i10 == 7 || i10 == 6) {
            String str2 = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.f7620b.a(str, i10, str2);
        }
    }
}
