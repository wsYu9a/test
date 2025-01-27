package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f24582a = "10.0.0.172";

    /* renamed from: b */
    private int f24583b = 80;

    /* renamed from: c */
    private Context f24584c;

    public c(Context context) {
        this.f24584c = context;
    }

    public void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f24584c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f24566h = DataHelper.assembleStatelessURL(imprintProperty);
    }

    public void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f24584c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24584c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f24565g = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f24568j = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f24566h = a.f24568j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f24592b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f24592b.startsWith("460") || com.umeng.commonsdk.statistics.b.f24592b.startsWith("461")) {
            a.f24566h = a.f24565g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) {
        String str4 = str2 + "/" + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, str4, str3);
        }
        if (by.a().b()) {
            String replace = str4.replace("ulogs", "cnlogs");
            String c10 = cc.b().c();
            if (!TextUtils.isEmpty(c10)) {
                replace = by.a(c10, str);
            }
            boolean a10 = a(bArr, replace, str3);
            if (!a10) {
                String a11 = by.a().a(str);
                if (!TextUtils.isEmpty(a11) && !replace.equalsIgnoreCase(a11)) {
                    return a(bArr, a11, str3);
                }
            }
            return a10;
        }
        return a(bArr, str4, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(byte[] r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
