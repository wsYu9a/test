package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.X;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class TraceFileHelper {

    public static class a {

        /* renamed from: a */
        public long f22402a;

        /* renamed from: b */
        public String f22403b;

        /* renamed from: c */
        public long f22404c;

        /* renamed from: d */
        public Map<String, String[]> f22405d;
    }

    public interface b {
        boolean a(long j10);

        boolean a(long j10, long j11, String str);

        boolean a(String str, int i10, String str2, String str3, boolean z10);

        boolean a(String str, long j10, long j11);
    }

    public static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null) {
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                }
            }
        }
        return null;
    }

    public static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 3; i10++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, boolean z10) {
        if (str == null) {
            X.b("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new j(aVar, z10));
        if (aVar.f22402a > 0 && aVar.f22404c > 0 && aVar.f22403b != null) {
            return aVar;
        }
        X.b("first dump error %s", aVar.f22402a + " " + aVar.f22404c + " " + aVar.f22403b);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z10) {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new i(aVar, str, z10));
            if (aVar.f22402a > 0 && aVar.f22404c > 0 && aVar.f22403b != null) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x014a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0150, code lost:
    
        if (com.tencent.bugly.proguard.X.b(r0) == false) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0152, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0155, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r19) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
