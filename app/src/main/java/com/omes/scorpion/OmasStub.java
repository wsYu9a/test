package com.omes.scorpion;

import android.util.Log;
import com.heytap.nearx.cloudconfig.stat.TrackApi_20246;
import com.heytap.nearx.track.NearxTrackHelper;
import com.heytap.nearx.track.TrackContext;

/* loaded from: classes4.dex */
public class OmasStub {

    /* renamed from: a */
    public static boolean f16050a = false;

    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(5000L);
                OmasStub.b();
                boolean z = OmasStub.f16050a;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    static {
        System.loadLibrary("scorpion");
        a();
    }

    public static void a() {
        new Thread(new a()).start();
    }

    public static void b() {
        try {
            Class.forName("com.heytap.nearx.track.NearxTrackHelper");
            if (!NearxTrackHelper.hasInit) {
                Log.d("SCORPION", "NearxTrackHelper has not init");
                return;
            }
            TrackApi_20246.NearxTrack obtain = TrackApi_20246.NearxTrack.obtain("8888", "1234");
            obtain.add("scorpion", "1");
            obtain.commit(TrackContext.get(103900L));
            f16050a = true;
        } catch (ClassNotFoundException unused) {
            f16050a = true;
            Log.d("SCORPION", "NearxTrackHelper not found");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        r4.read(r0, r1, r5 - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] c(java.lang.String r4, java.lang.String r5) {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.io.IOException -> L42
            java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> L42
            r1.<init>(r4)     // Catch: java.io.IOException -> L42
            r0.<init>(r1)     // Catch: java.io.IOException -> L42
            java.util.Enumeration r4 = r0.entries()     // Catch: java.io.IOException -> L42
        Le:
            boolean r1 = r4.hasMoreElements()     // Catch: java.io.IOException -> L42
            if (r1 == 0) goto L46
            java.lang.Object r1 = r4.nextElement()     // Catch: java.io.IOException -> L42
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.io.IOException -> L42
            java.lang.String r2 = r1.getName()     // Catch: java.io.IOException -> L42
            boolean r2 = r2.contains(r5)     // Catch: java.io.IOException -> L42
            if (r2 == 0) goto Le
            java.io.InputStream r4 = r0.getInputStream(r1)     // Catch: java.io.IOException -> L42
            int r5 = r4.available()     // Catch: java.io.IOException -> L42
            byte[] r0 = new byte[r5]     // Catch: java.io.IOException -> L42
            r1 = 0
        L2f:
            r2 = 10240(0x2800, float:1.4349E-41)
            int r2 = r4.read(r0, r1, r2)     // Catch: java.io.IOException -> L42
            r3 = -1
            if (r2 == r3) goto L41
            int r1 = r1 + r2
            int r2 = r1 + 10240
            if (r2 <= r5) goto L2f
            int r5 = r5 - r1
            r4.read(r0, r1, r5)     // Catch: java.io.IOException -> L42
        L41:
            return r0
        L42:
            r4 = move-exception
            r4.printStackTrace()
        L46:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omes.scorpion.OmasStub.c(java.lang.String, java.lang.String):byte[]");
    }

    public static native boolean omasBoolean(int i2, Object[] objArr);

    public static native byte omasByte(int i2, Object[] objArr);

    public static native char omasChar(int i2, Object[] objArr);

    public static native double omasDouble(int i2, Object[] objArr);

    public static native float omasFloat(int i2, Object[] objArr);

    public static native int omasInt(int i2, Object[] objArr);

    public static native long omasLong(int i2, Object[] objArr);

    public static native Object omasObject(int i2, Object[] objArr);

    public static native short omasShort(int i2, Object[] objArr);

    public static native void omasVoid(int i2, Object[] objArr);
}
