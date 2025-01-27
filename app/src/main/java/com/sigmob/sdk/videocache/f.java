package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: d */
    public static final Pattern f20587d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e */
    public static final Pattern f20588e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f20589a;

    /* renamed from: b */
    public final long f20590b;

    /* renamed from: c */
    public final boolean f20591c;

    public f(String str) {
        o.a(str);
        long a10 = a(str);
        this.f20590b = Math.max(0L, a10);
        this.f20591c = a10 >= 0;
        this.f20589a = b(str);
    }

    public final long a(String str) {
        Matcher matcher = f20587d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public final String b(String str) {
        Matcher matcher = f20588e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f20590b + ", partial=" + this.f20591c + ", uri='" + this.f20589a + "'}";
    }

    public static f a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new f(sb2.toString());
            }
            sb2.append(readLine);
            sb2.append('\n');
        }
    }
}
