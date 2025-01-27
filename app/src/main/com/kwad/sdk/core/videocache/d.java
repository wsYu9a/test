package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.au;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class d {
    private static final Pattern aGg = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aGh = Pattern.compile("GET /(.*) HTTP");
    public final long aGi;
    public final boolean aGj;
    public final String uri;

    private d(String str) {
        au.gV(str);
        long eK = eK(str);
        this.aGi = Math.max(0L, eK);
        this.aGj = eK >= 0;
        this.uri = eL(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb2.toString());
            }
            sb2.append(readLine);
            sb2.append('\n');
        }
    }

    private static long eK(String str) {
        Matcher matcher = aGg.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eL(String str) {
        Matcher matcher = aGh.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aGi + ", partial=" + this.aGj + ", uri='" + this.uri + "'}";
    }
}
