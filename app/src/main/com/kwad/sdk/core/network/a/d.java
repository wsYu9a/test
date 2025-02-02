package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: classes3.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String gb2 = com.kwad.sdk.ip.direct.a.gb(str);
        if (TextUtils.isEmpty(gb2)) {
            com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
            return SYSTEM.lookup(str);
        }
        List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(gb2));
        if (asList == null || asList.isEmpty()) {
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
        return asList;
    }
}
