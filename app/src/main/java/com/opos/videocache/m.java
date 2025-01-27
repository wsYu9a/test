package com.opos.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
class m {

    /* renamed from: d */
    private static final Pattern f23824d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e */
    private static final Pattern f23825e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f23826a;

    /* renamed from: b */
    public final long f23827b;

    /* renamed from: c */
    public final boolean f23828c;

    public m(String str) {
        f.a(str);
        long a2 = a(str);
        this.f23827b = Math.max(0L, a2);
        this.f23828c = a2 >= 0;
        this.f23826a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f23824d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static m a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new m(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = f23825e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f23827b + ", partial=" + this.f23828c + ", uri='" + this.f23826a + "'}";
    }
}
