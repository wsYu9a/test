package com.jd.ad.sdk.jad_mx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class jad_cn {
    public boolean jad_an;
    public final Handler jad_bo = new Handler(Looper.getMainLooper(), new jad_an());

    public static final class jad_an implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((jad_xk) message.obj).jad_dq();
            return true;
        }
    }

    public synchronized void jad_an(jad_xk<?> jad_xkVar, boolean z10) {
        try {
            if (!this.jad_an && !z10) {
                this.jad_an = true;
                jad_xkVar.jad_dq();
                this.jad_an = false;
            }
            this.jad_bo.obtainMessage(1, jad_xkVar).sendToTarget();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
