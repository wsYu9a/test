package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@p
@a5.c
/* loaded from: classes2.dex */
public abstract class t {

    /* renamed from: a */
    public StringBuilder f27687a = new StringBuilder();

    /* renamed from: b */
    public boolean f27688b;

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.f27688b
            r1 = 0
            r2 = 10
            r3 = 1
            if (r0 == 0) goto L1a
            if (r9 <= 0) goto L1a
            char r0 = r7[r8]
            if (r0 != r2) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            boolean r0 = r6.c(r0)
            if (r0 == 0) goto L1a
            int r0 = r8 + 1
            goto L1b
        L1a:
            r0 = r8
        L1b:
            int r8 = r8 + r9
            r9 = r0
        L1d:
            if (r0 >= r8) goto L53
            char r4 = r7[r0]
            if (r4 == r2) goto L46
            r5 = 13
            if (r4 == r5) goto L28
            goto L51
        L28:
            java.lang.StringBuilder r4 = r6.f27687a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.f27688b = r3
            int r9 = r0 + 1
            if (r9 >= r8) goto L43
            char r4 = r7[r9]
            if (r4 != r2) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = 0
        L3c:
            boolean r4 = r6.c(r4)
            if (r4 == 0) goto L43
            r0 = r9
        L43:
            int r9 = r0 + 1
            goto L51
        L46:
            java.lang.StringBuilder r4 = r6.f27687a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.c(r3)
            goto L43
        L51:
            int r0 = r0 + r3
            goto L1d
        L53:
            java.lang.StringBuilder r0 = r6.f27687a
            int r8 = r8 - r9
            r0.append(r7, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.t.a(char[], int, int):void");
    }

    public void b() throws IOException {
        if (this.f27688b || this.f27687a.length() > 0) {
            c(false);
        }
    }

    @CanIgnoreReturnValue
    public final boolean c(boolean z10) throws IOException {
        d(this.f27687a.toString(), this.f27688b ? z10 ? "\r\n" : "\r" : z10 ? "\n" : "");
        this.f27687a = new StringBuilder();
        this.f27688b = false;
        return z10;
    }

    public abstract void d(String str, String str2) throws IOException;
}
