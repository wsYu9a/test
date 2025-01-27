package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f26270a = "10.0.0.172";

    /* renamed from: b */
    private int f26271b = 80;

    /* renamed from: c */
    private Context f26272c;

    public c(Context context) {
        this.f26272c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f26272c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f26257i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f26272c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f26272c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f26256h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f26257i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f26280b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f26280b.startsWith("460") || com.umeng.commonsdk.statistics.b.f26280b.startsWith("461")) {
            a.f26257i = a.f26256h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x011d, code lost:
    
        if (r11 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010c, code lost:
    
        if (r11 == null) goto L122;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String, javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
