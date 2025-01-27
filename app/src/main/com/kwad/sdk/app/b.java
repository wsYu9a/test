package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.components.o;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class b {
    private static final Map<String, String> aqJ = new HashMap();
    private final AtomicBoolean aqK;
    private final AtomicBoolean aqL;
    private final AtomicBoolean aqM;
    private final AtomicBoolean aqN;
    private final List<String> aqO;
    private final List<String> aqP;
    private final d aqQ;
    private final BroadcastReceiver aqR;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    /* renamed from: com.kwad.sdk.app.b$1 */
    public class AnonymousClass1 extends d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            try {
                b.this.BN();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.app.b$2 */
    public class AnonymousClass2 extends d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            try {
                b.this.BO();
            } catch (Throwable th2) {
                c.printStackTraceOnly(th2);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            try {
                b.this.BN();
                b.this.BP();
            } catch (Throwable th2) {
                c.printStackTraceOnly(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.app.b$3 */
    public class AnonymousClass3 extends BroadcastReceiver {
        Intent aqT;

        public AnonymousClass3() {
        }

        private boolean d(Intent intent) {
            boolean z10 = TextUtils.equals(this.aqT.getAction(), intent.getAction()) && TextUtils.equals(this.aqT.getPackage(), intent.getPackage()) && this.aqT.getFlags() == intent.getFlags() && TextUtils.equals(this.aqT.getDataString(), intent.getDataString());
            this.aqT = intent;
            return z10;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Uri data;
            try {
                c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                if (this.aqT == null) {
                    this.aqT = intent;
                } else if (d(intent)) {
                    return;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                    return;
                }
                String schemeSpecificPart = data.getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                b.this.mContext = context;
                if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                    b.this.z(context, schemeSpecificPart);
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                    b.this.cr(schemeSpecificPart);
                }
            } catch (Throwable th2) {
                c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.app.b$4 */
    public class AnonymousClass4 extends d {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            if (b.this.aqO.size() > 0) {
                for (int i10 = 0; i10 < b.this.aqO.size(); i10++) {
                    b.B(b.this.mContext, (String) b.this.aqO.get(i10));
                }
                b.this.aqO.clear();
            }
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
        }
    }

    /* renamed from: com.kwad.sdk.app.b$5 */
    public class AnonymousClass5 extends d {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            if (b.this.aqP.size() > 0) {
                for (int i10 = 0; i10 < b.this.aqP.size(); i10++) {
                    b.ct((String) b.this.aqP.get(i10));
                }
                b.this.aqP.clear();
            }
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
        }
    }

    public static class a {
        private static final b aqU = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    private void A(Context context, String str) {
        com.kwad.sdk.core.c.b.Fi();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            B(context, str);
            return;
        }
        this.aqO.add(str);
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aqO.size() > 0) {
                    for (int i10 = 0; i10 < b.this.aqO.size(); i10++) {
                        b.B(b.this.mContext, (String) b.this.aqO.get(i10));
                    }
                    b.this.aqO.clear();
                }
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public static void B(Context context, @NonNull String str) {
        try {
            o oVar = (o) com.kwad.sdk.components.d.f(o.class);
            if (oVar == null || !q.MZ()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(oVar.e(context, str), 1);
        } catch (Throwable th2) {
            c.printStackTrace(th2);
        }
    }

    public static b BJ() {
        return a.aqU;
    }

    private void BK() {
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.BO();
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.BN();
                    b.this.BP();
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        });
    }

    private void BL() {
        if (this.aqN.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(this.aqQ);
        this.aqN.set(true);
    }

    private void BM() {
        if (this.aqN.get()) {
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.aqQ);
            this.aqN.set(false);
        }
    }

    public void BN() {
        Context MA = ServiceProvider.MA();
        aY(MA);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).zH().iterator();
        while (it.hasNext()) {
            AdInfo eb2 = e.eb(it.next());
            int bA = com.kwad.sdk.core.response.b.a.bA(eb2);
            String ay = com.kwad.sdk.core.response.b.a.ay(eb2);
            if (bA != 12) {
                if (ap.ao(MA, ay)) {
                    z(MA, ay);
                }
            } else if (!ap.ao(MA, ay)) {
                cr(ay);
            }
        }
    }

    public void BO() {
        if (this.aqM.get()) {
            ServiceProvider.MA().unregisterReceiver(this.aqR);
            this.aqM.set(false);
        }
    }

    public void BP() {
        if (this.aqM.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.MA().registerReceiver(this.aqR, intentFilter);
        this.aqM.set(true);
    }

    private static void C(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aqJ.put("com.tencent.mm", l.N(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                aqJ.put("com.kuaishou.nebula", l.N(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                aqJ.put("com.smile.gifmaker", l.N(context, "com.smile.gifmaker"));
                break;
        }
    }

    private synchronized void aX(Context context) {
        if (this.aqK.get()) {
            return;
        }
        C(context, "com.smile.gifmaker");
        C(context, "com.kuaishou.nebula");
        C(context, "com.tencent.mm");
        this.aqK.set(true);
    }

    private void aY(Context context) {
        if (this.aqK.get()) {
            for (String str : aqJ.keySet()) {
                String str2 = aqJ.get(str);
                String N = l.N(context, str);
                if (!TextUtils.isEmpty(N) && !TextUtils.equals(str2, N)) {
                    z(context, str);
                } else if (TextUtils.isEmpty(N) && !TextUtils.isEmpty(str2)) {
                    cr(str);
                }
            }
        }
    }

    public void cr(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cw(str);
        cv(str);
        cs(str);
    }

    private void cs(String str) {
        com.kwad.sdk.core.c.b.Fi();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            ct(str);
            return;
        }
        this.aqP.add(str);
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aqP.size() > 0) {
                    for (int i10 = 0; i10 < b.this.aqP.size(); i10++) {
                        b.ct((String) b.this.aqP.get(i10));
                    }
                    b.this.aqP.clear();
                }
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public static void ct(@NonNull String str) {
        try {
            o oVar = (o) com.kwad.sdk.components.d.f(o.class);
            if (oVar == null || !q.MZ()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(oVar.y(str), 2);
        } catch (Throwable th2) {
            c.printStackTrace(th2);
        }
    }

    private void cu(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().Q(str);
            } catch (Throwable th2) {
                c.printStackTrace(th2);
            }
        }
    }

    private void cv(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().R(str);
            } catch (Throwable th2) {
                c.printStackTrace(th2);
            }
        }
    }

    private static void cw(String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aqJ.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                aqJ.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                aqJ.put("com.smile.gifmaker", "");
                break;
        }
    }

    public void z(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        C(context, str);
        cu(str);
        A(context, str);
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        aX(context);
        return aqJ.get(str);
    }

    public final synchronized void init() {
        try {
            if (this.aqL.get()) {
                return;
            }
            BM();
            if (((h) ServiceProvider.get(h.class)).Aj()) {
                com.kwad.sdk.core.c.b.Fi();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    BP();
                }
                BK();
            } else {
                BP();
            }
            this.aqL.set(true);
        } catch (Throwable th2) {
            c.printStackTraceOnly(th2);
        }
    }

    private b() {
        this.aqK = new AtomicBoolean();
        this.aqL = new AtomicBoolean();
        this.aqM = new AtomicBoolean();
        this.aqN = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.aqO = new CopyOnWriteArrayList();
        this.aqP = new CopyOnWriteArrayList();
        this.aqQ = new d() { // from class: com.kwad.sdk.app.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.BN();
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        };
        this.aqR = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent aqT;

            public AnonymousClass3() {
            }

            private boolean d(Intent intent) {
                boolean z10 = TextUtils.equals(this.aqT.getAction(), intent.getAction()) && TextUtils.equals(this.aqT.getPackage(), intent.getPackage()) && this.aqT.getFlags() == intent.getFlags() && TextUtils.equals(this.aqT.getDataString(), intent.getDataString());
                this.aqT = intent;
                return z10;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                try {
                    c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    if (this.aqT == null) {
                        this.aqT = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.z(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.cr(schemeSpecificPart);
                    }
                } catch (Throwable th2) {
                    c.printStackTrace(th2);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        BL();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        BL();
        this.mListeners.add(aVar);
    }
}
