package com.czhj.sdk.common.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
class InetAddressUtils {
    public static InetAddress getInetAddressByName(String str) throws UnknownHostException {
        return InetAddress.getByName(str);
    }
}
