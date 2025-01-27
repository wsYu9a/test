package com.vivo.push.sdk.service;

import android.app.Activity;
import com.vivo.push.util.p;

/* loaded from: classes4.dex */
public class LinkProxyActivity extends Activity {
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9 A[Catch: Exception -> 0x00c4, TryCatch #2 {Exception -> 0x00c4, blocks: (B:27:0x008c, B:29:0x0092, B:31:0x009e, B:33:0x00a4, B:35:0x00ac, B:38:0x00b3, B:40:0x00bb, B:42:0x00bf, B:46:0x00c9, B:47:0x00cd), top: B:26:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[Catch: Exception -> 0x00c4, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c4, blocks: (B:27:0x008c, B:29:0x0092, B:31:0x009e, B:33:0x00a4, B:35:0x00ac, B:38:0x00b3, B:40:0x00bb, B:42:0x00bf, B:46:0x00c9, B:47:0x00cd), top: B:26:0x008c }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "LinkProxyActivity"
            if (r7 != 0) goto L14
            java.lang.String r7 = "enter RequestPermissionsActivity onCreate, intent is null, finish"
            com.vivo.push.util.p.d(r0, r7)
            r6.finish()
            return
        L14:
            r1 = 1
            r2 = 0
            android.view.Window r3 = r6.getWindow()     // Catch: java.lang.Throwable -> L30
            r4 = 8388659(0x800033, float:1.1755015E-38)
            r3.setGravity(r4)     // Catch: java.lang.Throwable -> L30
            android.view.WindowManager$LayoutParams r4 = r3.getAttributes()     // Catch: java.lang.Throwable -> L30
            r4.x = r2     // Catch: java.lang.Throwable -> L30
            r4.y = r2     // Catch: java.lang.Throwable -> L30
            r4.height = r1     // Catch: java.lang.Throwable -> L30
            r4.width = r1     // Catch: java.lang.Throwable -> L30
            r3.setAttributes(r4)     // Catch: java.lang.Throwable -> L30
            goto L36
        L30:
            r3 = move-exception
            java.lang.String r4 = "enter onCreate error "
            com.vivo.push.util.p.b(r0, r4, r3)
        L36:
            java.lang.String r3 = r6.getPackageName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r6.hashCode()
            r4.append(r5)
            java.lang.String r5 = " enter onCreate "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.vivo.push.util.p.d(r0, r4)
            java.lang.String r4 = "com.vivo.abe"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "previous_intent"
            if (r3 == 0) goto L8c
            android.os.Bundle r1 = r7.getExtras()     // Catch: java.lang.Exception -> L6c
            if (r1 != 0) goto L6e
            java.lang.String r7 = "adapterToService getExtras() is null"
            com.vivo.push.util.p.d(r0, r7)     // Catch: java.lang.Exception -> L6c
            goto Le2
        L6c:
            r7 = move-exception
            goto L84
        L6e:
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> L6c
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> L6c
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> L6c
            if (r7 != 0) goto L80
            java.lang.String r7 = "adapterToService proxyIntent is null"
            com.vivo.push.util.p.d(r0, r7)     // Catch: java.lang.Exception -> L6c
            goto Le2
        L80:
            com.vivo.push.util.z.a(r6, r7)     // Catch: java.lang.Exception -> L6c
            goto Le2
        L84:
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.p.a(r0, r1, r7)
            goto Le2
        L8c:
            android.os.Bundle r3 = r7.getExtras()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Le2
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> Lc4
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> Lc4
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> Lc4
            if (r7 == 0) goto Lc6
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            r4 = 576(0x240, float:8.07E-43)
            java.util.List r3 = r3.queryIntentServices(r7, r4)     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> Lc4
            if (r4 == 0) goto Lb3
            goto Lc6
        Lb3:
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> Lc4
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            android.content.pm.ServiceInfo r3 = r3.serviceInfo     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            boolean r3 = r3.exported     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            goto Lc7
        Lc4:
            r7 = move-exception
            goto Ldb
        Lc6:
            r1 = 0
        Lc7:
            if (r1 == 0) goto Lcd
            r6.startService(r7)     // Catch: java.lang.Exception -> Lc4
            goto Le2
        Lcd:
            java.lang.String r7 = "service's exported is "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r7 = r7.concat(r1)     // Catch: java.lang.Exception -> Lc4
            com.vivo.push.util.p.b(r0, r7)     // Catch: java.lang.Exception -> Lc4
            goto Le2
        Ldb:
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.p.a(r0, r1, r7)
        Le2:
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.sdk.service.LinkProxyActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
