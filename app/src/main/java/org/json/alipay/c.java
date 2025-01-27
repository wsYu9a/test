package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public int f29230a;

    /* renamed from: b */
    public Reader f29231b;

    /* renamed from: c */
    public char f29232c;

    /* renamed from: d */
    public boolean f29233d;

    public c(Reader reader) {
        this.f29231b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f29233d = false;
        this.f29230a = 0;
    }

    private String a(int i10) {
        if (i10 == 0) {
            return "";
        }
        char[] cArr = new char[i10];
        int i11 = 0;
        if (this.f29233d) {
            this.f29233d = false;
            cArr[0] = this.f29232c;
            i11 = 1;
        }
        while (i11 < i10) {
            try {
                int read = this.f29231b.read(cArr, i11, i10 - i11);
                if (read == -1) {
                    break;
                }
                i11 += read;
            } catch (IOException e10) {
                throw new JSONException(e10);
            }
        }
        this.f29230a += i11;
        if (i11 < i10) {
            throw a("Substring bounds error");
        }
        this.f29232c = cArr[i10 - 1];
        return new String(cArr);
    }

    public final char b() {
        if (this.f29233d) {
            this.f29233d = false;
            char c10 = this.f29232c;
            if (c10 != 0) {
                this.f29230a++;
            }
            return c10;
        }
        try {
            int read = this.f29231b.read();
            if (read <= 0) {
                this.f29232c = (char) 0;
                return (char) 0;
            }
            this.f29230a++;
            char c11 = (char) read;
            this.f29232c = c11;
            return c11;
        } catch (IOException e10) {
            throw new JSONException(e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final char c() {
        /*
            r5 = this;
        L0:
            char r0 = r5.b()
            r1 = 13
            r2 = 10
            r3 = 47
            if (r0 != r3) goto L3e
            char r0 = r5.b()
            r4 = 42
            if (r0 == r4) goto L25
            if (r0 == r3) goto L1a
            r5.a()
            return r3
        L1a:
            char r0 = r5.b()
            if (r0 == r2) goto L0
            if (r0 == r1) goto L0
            if (r0 != 0) goto L1a
            goto L0
        L25:
            char r0 = r5.b()
            if (r0 == 0) goto L37
            if (r0 != r4) goto L25
            char r0 = r5.b()
            if (r0 == r3) goto L0
            r5.a()
            goto L25
        L37:
            java.lang.String r0 = "Unclosed comment"
            org.json.alipay.JSONException r0 = r5.a(r0)
            throw r0
        L3e:
            r3 = 35
            if (r0 != r3) goto L4d
        L42:
            char r0 = r5.b()
            if (r0 == r2) goto L0
            if (r0 == r1) goto L0
            if (r0 != 0) goto L42
            goto L0
        L4d:
            if (r0 == 0) goto L53
            r1 = 32
            if (r0 <= r1) goto L0
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.c():char");
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0146, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.d():java.lang.Object");
    }

    public final String toString() {
        return " at character " + this.f29230a;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i10;
        if (this.f29233d || (i10 = this.f29230a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f29230a = i10 - 1;
        this.f29233d = true;
    }
}
