package com.opos.mobad.cmn.service.pkginstall;

import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public class SystemBR extends BroadcastReceiver {
    private static final long SEND_PACKAGE_ADDED_OR_REMOVED_MSG_DELAY_TIME = 500;
    private static final Handler SYSTEM_BR_HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.SystemBR.1
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i2 = message.what;
                    if (i2 == 0 || 1 == i2 || 2 == i2) {
                        c.a().a(message.what, (String) message.obj);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a(SystemBR.TAG, "", (Throwable) e2);
                }
            }
        }
    };
    private static final String TAG = "SystemBR";

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.SystemBR$1 */
    static final class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i2 = message.what;
                    if (i2 == 0 || 1 == i2 || 2 == i2) {
                        c.a().a(message.what, (String) message.obj);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a(SystemBR.TAG, "", (Throwable) e2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #1 {Exception -> 0x00f2, blocks: (B:4:0x0008, B:7:0x003e, B:9:0x0044, B:13:0x004a, B:27:0x0095, B:28:0x00ab, B:30:0x00af, B:32:0x00cb, B:33:0x00ce, B:35:0x00d4, B:36:0x00d7, B:38:0x00db, B:39:0x0073, B:42:0x007b, B:45:0x0083), top: B:3:0x0008 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r13, android.content.Intent r14) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.SystemBR.onReceive(android.content.Context, android.content.Intent):void");
    }
}
