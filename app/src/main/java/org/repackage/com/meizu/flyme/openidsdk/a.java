package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;

/* loaded from: classes4.dex */
final class a extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        if (r0 == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        r1 = true;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L86
            if (r6 != 0) goto L6
            goto L86
        L6:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = "shouldUpdateId, notifyFlag : "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r2.concat(r3)
            org.repackage.com.meizu.flyme.openidsdk.b.a(r2)
            r2 = 1
            if (r0 != r2) goto L2f
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L46
        L2d:
            r1 = 1
            goto L46
        L2f:
            r3 = 2
            if (r0 != r3) goto L43
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L46
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L46
        L43:
            if (r0 != 0) goto L46
            goto L2d
        L46:
            if (r1 != 0) goto L49
            return
        L49:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            org.repackage.com.meizu.flyme.openidsdk.b r6 = org.repackage.com.meizu.flyme.openidsdk.b.a()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L5e
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f29381b
            goto L80
        L5e:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L69
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f29383d
            goto L80
        L69:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L74
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f29382c
            goto L80
        L74:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7f
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f29380a
            goto L80
        L7f:
            r5 = 0
        L80:
            if (r5 != 0) goto L83
            return
        L83:
            r5.b()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
