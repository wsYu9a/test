package com.tencent.open.b;

import android.os.SystemClock;
import com.tencent.open.utils.i;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    protected static d f23184a;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f23184a == null) {
                    f23184a = new d();
                }
                dVar = f23184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g.a().a(i.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        g.a().a(i.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void a(int i10, String str, String str2, String str3, String str4, Long l10, int i11, int i12, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l10.longValue();
        if (l10.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i10);
        stringBuffer.append("&code=");
        stringBuffer.append(i11);
        stringBuffer.append("&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i12);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        g.a().a(stringBuffer.toString(), "GET", i.a(String.valueOf(i10), String.valueOf(i11), String.valueOf(elapsedRealtime), String.valueOf(i12), str, str2, str3, str4, str5), true);
    }
}
