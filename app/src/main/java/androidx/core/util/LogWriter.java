package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f1979a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f1980b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f1979a = str;
    }

    private void a() {
        if (this.f1980b.length() > 0) {
            Log.d(this.f1979a, this.f1980b.toString());
            StringBuilder sb = this.f1980b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f1980b.append(c2);
            }
        }
    }
}
