package com.czhj.volley.toolbox;

import android.text.TextUtils;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import m5.c;
import m5.h;

/* loaded from: classes2.dex */
public class HttpHeaderParser {

    /* renamed from: a */
    public static final String f8777a = "Content-Type";

    /* renamed from: b */
    public static final String f8778b = "ISO-8859-1";

    /* renamed from: c */
    public static final String f8779c = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static String a(long j10) {
        return a().format(new Date(j10));
    }

    public static String getHeader(Map<String, String> map, String str) {
        return map.get(str);
    }

    public static boolean isGzipContent(Map<String, String> map) {
        return TextUtils.equals(getHeader(map, c.f28293b0), "gzip");
    }

    public static boolean isSupportRange(Map<String, String> map) {
        if (TextUtils.equals(getHeader(map, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String header = getHeader(map, "Content-Range");
        return header != null && header.startsWith("bytes");
    }

    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        boolean z10;
        long j10;
        long j11;
        long j12;
        long j13;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = map.get(c.f28298d);
        long parseDateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z10 = false;
            j10 = 0;
            j11 = 0;
            while (i10 < split.length) {
                String trim = split[i10].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j10 = Long.parseLong(trim.substring(8));
                    } catch (Throwable unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j11 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i10++;
            }
            i10 = 1;
        } else {
            z10 = false;
            j10 = 0;
            j11 = 0;
        }
        String str3 = map.get(c.f28338q0);
        long parseDateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long parseDateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0L;
        String str5 = map.get(c.f28335p0);
        if (i10 != 0) {
            j13 = currentTimeMillis + (j10 * 1000);
            if (!z10) {
                Long.signum(j11);
                j12 = j13;
                j13 += j11 * 1000;
                Cache.Entry entry = new Cache.Entry();
                entry.data = networkResponse.data;
                entry.etag = str5;
                entry.softTtl = j12;
                entry.ttl = j13;
                entry.serverDate = parseDateAsEpoch;
                entry.lastModified = parseDateAsEpoch3;
                entry.responseHeaders = map;
                entry.allResponseHeaders = networkResponse.allHeaders;
                return entry;
            }
            j12 = j13;
            Cache.Entry entry2 = new Cache.Entry();
            entry2.data = networkResponse.data;
            entry2.etag = str5;
            entry2.softTtl = j12;
            entry2.ttl = j13;
            entry2.serverDate = parseDateAsEpoch;
            entry2.lastModified = parseDateAsEpoch3;
            entry2.responseHeaders = map;
            entry2.allResponseHeaders = networkResponse.allHeaders;
            return entry2;
        }
        j12 = 0;
        if (parseDateAsEpoch <= 0 || parseDateAsEpoch2 < parseDateAsEpoch) {
            j13 = 0;
            Cache.Entry entry22 = new Cache.Entry();
            entry22.data = networkResponse.data;
            entry22.etag = str5;
            entry22.softTtl = j12;
            entry22.ttl = j13;
            entry22.serverDate = parseDateAsEpoch;
            entry22.lastModified = parseDateAsEpoch3;
            entry22.responseHeaders = map;
            entry22.allResponseHeaders = networkResponse.allHeaders;
            return entry22;
        }
        j13 = currentTimeMillis + (parseDateAsEpoch2 - parseDateAsEpoch);
        j12 = j13;
        Cache.Entry entry222 = new Cache.Entry();
        entry222.data = networkResponse.data;
        entry222.etag = str5;
        entry222.softTtl = j12;
        entry222.ttl = j13;
        entry222.serverDate = parseDateAsEpoch;
        entry222.lastModified = parseDateAsEpoch3;
        entry222.responseHeaders = map;
        entry222.allResponseHeaders = networkResponse.allHeaders;
        return entry222;
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, "ISO-8859-1");
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e10) {
            VolleyLog.e(e10, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f8779c, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i10 = 1; i10 < split.length; i10++) {
                String[] split2 = split[i10].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals(h.f28414g)) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static List<Header> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }
}
