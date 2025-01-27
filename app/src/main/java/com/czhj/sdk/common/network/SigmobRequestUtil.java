package com.czhj.sdk.common.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SigmobRequestUtil {

    public static class DNSResolver implements Runnable {

        /* renamed from: a */
        public String f8566a;

        /* renamed from: b */
        public InetAddress f8567b;

        public DNSResolver(String str) {
            this.f8566a = str;
        }

        public synchronized InetAddress get() {
            return this.f8567b;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                set(InetAddress.getByName(this.f8566a));
            } catch (Throwable unused) {
            }
        }

        public synchronized void set(InetAddress inetAddress) {
            this.f8567b = inetAddress;
        }
    }

    public static boolean a(String str) {
        try {
            HashSet sigmobServerURLS = Networking.getSigmobServerURLS();
            if (sigmobServerURLS != null) {
                return sigmobServerURLS.contains(str);
            }
            return false;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return false;
        }
    }

    public static Map<String, String> convertQueryToMap(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str);
        HashMap hashMap = new HashMap();
        Uri parse = Uri.parse(Networking.getUrlRewriter().rewriteUrl(str));
        for (String str2 : parse.getQueryParameterNames()) {
            hashMap.put(str2, TextUtils.join(",", parse.getQueryParameters(str2)));
        }
        return hashMap;
    }

    public static String generateBodyFromParams(Map<String, String> map, String str) {
        Preconditions.NoThrow.checkNotNull(str);
        if (map == null || map.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str2 : map.keySet()) {
            try {
                jSONObject.put(str2, map.get(str2));
            } catch (Throwable unused) {
                SigmobLog.d("Unable to add " + str2 + " to JSON body.");
            }
        }
        return jSONObject.toString();
    }

    public static boolean isConnection(String str) {
        return true;
    }

    public static String truncateQueryParamsIfPost(String str) {
        Preconditions.NoThrow.checkNotNull(str);
        int indexOf = str.indexOf(63);
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }
}
