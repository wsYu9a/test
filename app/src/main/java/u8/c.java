package u8;

import ba.l;

/* loaded from: classes3.dex */
public abstract class c {
    public abstract String getBaseUrl();

    public String getRequestUrl(b bVar, String str) {
        StringBuilder sb2 = new StringBuilder(getBaseUrl());
        sb2.append(bVar.getRequestMethod());
        String d10 = a.d(bVar, str);
        if (!l.q(d10)) {
            sb2.append("?");
            sb2.append(d10);
        }
        return sb2.toString();
    }
}
