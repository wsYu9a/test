package com.tencent.open.a;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    public static final h f23170a = new h();

    public final String a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? i10 != 16 ? i10 != 32 ? "-" : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D" : ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }

    public String a(int i10, Thread thread, long j10, String str, String str2, Throwable th2) {
        long j11 = j10 % 1000;
        Time time = new Time();
        time.set(j10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a(i10));
        sb2.append('/');
        sb2.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb2.append('.');
        if (j11 < 10) {
            sb2.append(com.sigmob.sdk.archives.tar.e.S);
        } else if (j11 < 100) {
            sb2.append('0');
        }
        sb2.append(j11);
        sb2.append(b5.a.O);
        sb2.append('[');
        if (thread == null) {
            sb2.append("N/A");
        } else {
            sb2.append(thread.getName());
        }
        sb2.append(']');
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        sb2.append(b5.a.O);
        sb2.append(str2);
        sb2.append('\n');
        if (th2 != null) {
            sb2.append("* Exception : \n");
            sb2.append(Log.getStackTraceString(th2));
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
