package com.tencent.open.b;

import android.os.SystemClock;
import com.tencent.open.utils.i;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    protected static d f25451a;

    protected d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f25451a == null) {
                f25451a = new d();
            }
            dVar = f25451a;
        }
        return dVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g.a().a(i.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        g.a().a(i.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void a(int i2, String str, String str2, String str3, String str4, Long l, int i3, int i4, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i2);
        stringBuffer.append("&code=");
        stringBuffer.append(i3);
        stringBuffer.append("&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i4);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        g.a().a(stringBuffer.toString(), "GET", i.a(String.valueOf(i2), String.valueOf(i3), String.valueOf(elapsedRealtime), String.valueOf(i4), str, str2, str3, str4, str5), true);
    }
}
