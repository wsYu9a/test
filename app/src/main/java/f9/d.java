package f9;

import android.text.TextUtils;
import com.martian.libmars.common.ConfigSingleton;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public abstract class d extends u8.c {
    @Override // u8.c
    public String getRequestUrl(u8.b bVar, String str) {
        StringBuilder sb2 = new StringBuilder(getBaseUrl());
        sb2.append(bVar.getRequestMethod());
        String d10 = ba.d.d(u8.a.e(bVar, str, false), ConfigSingleton.D().l().f26179b);
        try {
            d10 = URLEncoder.encode(d10, str);
        } catch (UnsupportedEncodingException unused) {
        }
        sb2.append("?");
        String d11 = u8.a.d(bVar, str);
        sb2.append(d11);
        if (!TextUtils.isEmpty(d11)) {
            sb2.append("&");
        }
        sb2.append("sign=");
        sb2.append(d10);
        return sb2.toString();
    }
}
