package com.kwad.sdk.utils.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.kwai.a;
import com.vivo.google.android.exoplayer3.C;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aBP = {0, 1, 4, 4, 8, 8};
    private static final byte[] aBQ = new byte[0];
    private static final int aBR;
    private static final int aBS;
    private static final int aBT;
    private final String RZ;
    private final Map<String, b> aBU;
    private FileChannel aBW;
    private FileChannel aBX;
    private RandomAccessFile aBY;
    private RandomAccessFile aBZ;
    private MappedByteBuffer aCa;
    private MappedByteBuffer aCb;
    private com.kwad.sdk.utils.kwai.b aCc;
    private int aCd;
    private long aCe;
    private int aCh;
    private int aCi;
    private int aCj;
    private boolean aCk;
    private String aCl;
    private int aCm;
    private int aCo;
    private final String name;
    private final d aBV = com.kwad.sdk.utils.kwai.d.aCz;
    private final Map<String, a.b> aCf = new HashMap();
    private boolean aCg = false;
    private final ArrayList<e> aCn = new ArrayList<>();
    private boolean aCp = true;
    private final Executor aCq = new f();

    /* renamed from: com.kwad.sdk.utils.kwai.c$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.Fd();
        }
    }

    /* renamed from: com.kwad.sdk.utils.kwai.c$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.Fk();
        }
    }

    public static class a {
        static int aCs = 11;
        static final C0234c aCt = new C0234c(11);
        private final String RZ;
        private int aCo = 0;
        private b[] aCu;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.RZ = str;
            this.name = str2;
        }

        public final c Fv() {
            String str = this.RZ + this.name;
            c fd = C0234c.fd(str);
            if (fd == null) {
                synchronized (a.class) {
                    fd = C0234c.fd(str);
                    if (fd == null) {
                        fd = new c(this.RZ, this.name, this.aCu, this.aCo);
                        C0234c.b(str, fd);
                    }
                }
            }
            Integer num = C0234c.aCy.get(str);
            if (num != null) {
                C0234c.aCy.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0234c.aCy.put(str, 1);
            }
            return fd;
        }
    }

    public interface b<T> {
        String Fw();

        T g(byte[] bArr, int i2, int i3);

        byte[] j(T t);
    }

    /* renamed from: com.kwad.sdk.utils.kwai.c$c */
    static class C0234c {
        private static Map<String, c> aCv;
        private static List<String> aCw;
        private static int aCx;
        public static Map<String, Integer> aCy;

        public C0234c(int i2) {
            int size = getSize(i2);
            aCv = new ConcurrentHashMap(size);
            aCy = new HashMap(size);
            aCw = new CopyOnWriteArrayList();
            aCx = i2;
        }

        public static void b(String str, c cVar) {
            if (aCv == null) {
                aCv = new ConcurrentHashMap(getSize(aCx));
            }
            if (aCw == null) {
                aCw = new CopyOnWriteArrayList();
            }
            if (aCv.containsKey(str)) {
                aCw.remove(str);
            }
            aCw.add(str);
            aCv.put(str, cVar);
            if (aCv.size() > aCx) {
                Integer num = aCy.get(aCw.get(0));
                if (num != null && num.intValue() != 2) {
                    ct(aCx + 1);
                    return;
                }
                c cVar2 = aCv.get(aCw.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aCv.remove(aCw.get(0));
                aCw.remove(0);
            }
        }

        private static void ct(int i2) {
            com.kwad.sdk.utils.kwai.d.aCz.i("Ks_UnionKv", "reSize:" + i2);
            aCx = i2;
        }

        public static c fd(String str) {
            if (aCv == null) {
                aCv = new ConcurrentHashMap(getSize(aCx));
            }
            if (aCw == null) {
                aCw = new CopyOnWriteArrayList();
            }
            c cVar = aCv.get(str);
            if (cVar == null) {
                return null;
            }
            aCw.remove(str);
            aCw.add(str);
            return cVar;
        }

        private static int getSize(int i2) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }

        public static void remove(String str) {
            List<String> list = aCw;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aCv;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    static class e implements Comparable<e> {
        int end;
        int start;

        e(int i2, int i3) {
            this.start = i2;
            this.end = i3;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int Fz = h.Fz();
        PAGE_SIZE = Fz;
        aBR = Fz - 192;
        int max = Math.max(Fz << 1, 16384);
        aBS = max;
        aBT = max << 1;
    }

    c(String str, String str2, b[] bVarArr, int i2) {
        this.RZ = str;
        this.name = str2;
        this.aCo = i2;
        HashMap hashMap = new HashMap();
        g gVar = g.aCH;
        hashMap.put(gVar.Fw(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String Fw = bVar.Fw();
                if (hashMap.containsKey(Fw)) {
                    fc("duplicate encoder tag:" + Fw);
                } else {
                    hashMap.put(Fw, bVar);
                }
            }
        }
        this.aBU = hashMap;
        synchronized (this.aCf) {
            com.kwad.sdk.utils.kwai.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Fd();
                }
            });
            while (!this.aCg) {
                try {
                    this.aCf.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public synchronized void Fd() {
        synchronized (this.aCf) {
            this.aCg = true;
            this.aCf.notify();
        }
        long nanoTime = System.nanoTime();
        if (!Fg() && this.aCo == 0) {
            Fe();
        }
        if (this.aCc == null) {
            this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        }
        if (this.aBV != null) {
            info("loading finish, data len:" + this.aCd + ", get keys:" + this.aCf.size() + ", use time:" + ((System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a4 A[Catch: all -> 0x01c6, TryCatch #0 {all -> 0x01c6, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:10:0x0070, B:13:0x0081, B:16:0x009e, B:17:0x00a9, B:21:0x00c0, B:24:0x00c4, B:26:0x00e1, B:28:0x00e8, B:30:0x010a, B:32:0x0110, B:36:0x011d, B:39:0x0123, B:42:0x013a, B:44:0x0142, B:46:0x015b, B:47:0x0168, B:49:0x0184, B:51:0x018a, B:53:0x01a4, B:60:0x0099, B:61:0x007e, B:63:0x01ae, B:65:0x01b8), top: B:2:0x0038, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Fe() {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fe():void");
    }

    private boolean Ff() {
        com.kwad.sdk.utils.kwai.b bVar = new com.kwad.sdk.utils.kwai.b(this.aCd);
        MappedByteBuffer mappedByteBuffer = this.aCb;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aCb.get(bVar.aBO, 0, this.aCd);
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.aBO;
        byte[] bArr2 = bVar.aBO;
        for (int i2 = 0; i2 < this.aCd; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean Fg() {
        File file = new File(this.RZ, this.name + ".kvc");
        File file2 = new File(this.RZ, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!X(file)) {
                    Fo();
                    Fl();
                } else if (this.aCo == 0) {
                    if (a(this.aCc)) {
                        info("recover from c file");
                        try {
                            Fl();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            m(e);
                            return z;
                        }
                    }
                    this.aCo = 1;
                }
            } else if (this.aCo != 0) {
                File file3 = new File(this.RZ, this.name + ".kva");
                File file4 = new File(this.RZ, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    f(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Fh() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.kwai.c.Fh():int");
    }

    private void Fi() {
        if (this.aCo == 0 || !this.aCp) {
            return;
        }
        Fj();
    }

    private boolean Fj() {
        int i2 = this.aCo;
        if (i2 == 1) {
            Executor executor = this.aCq;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.2
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Fk();
                    }
                });
            }
        } else if (i2 == 2) {
            return Fk();
        }
        return true;
    }

    public synchronized boolean Fk() {
        try {
            File file = new File(this.RZ, this.name + ".tmp");
            if (h.Y(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.aCd);
                randomAccessFile.write(this.aCc.aBO, 0, this.aCd);
                randomAccessFile.close();
                File file2 = new File(this.RZ, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    a(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            m(e2);
        }
        return false;
    }

    private void Fl() {
        try {
            h.c(new File(this.RZ, this.name + ".kvc"));
            h.c(new File(this.RZ, this.name + ".tmp"));
        } catch (Exception e2) {
            m(e2);
        }
    }

    private void Fm() {
        this.aCo = 1;
        h.closeQuietly(this.aBW);
        h.closeQuietly(this.aBX);
        this.aBW = null;
        this.aBX = null;
        this.aCa = null;
        this.aCb = null;
    }

    private void Fn() {
        if (this.aCo == 0) {
            try {
                a(this.aCa);
                a(this.aCb);
            } catch (Throwable unused) {
                Fm();
            }
        }
        Fo();
        h.c(new File(this.RZ + this.name));
    }

    private void Fo() {
        this.aCd = 12;
        this.aCe = 0L;
        Fu();
        this.aCf.clear();
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null || bVar.aBO.length != PAGE_SIZE) {
            this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        } else {
            bVar.v(0, 0);
            this.aCc.d(4, 0L);
        }
    }

    private void Fp() {
        com.kwad.sdk.utils.kwai.b bVar;
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            this.aCe ^= bVar2.x(this.aCh, this.aCi);
        }
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aCa);
                this.aCa.putInt(0, this.aCd - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aCk && (bVar = this.aCc) != null) {
                bVar.v(0, this.aCd - 12);
            }
            com.kwad.sdk.utils.kwai.b bVar3 = this.aCc;
            if (bVar3 != null) {
                bVar3.d(4, this.aCe);
            }
        }
        this.aCk = false;
        this.aCj = 0;
        this.aCi = 0;
    }

    private int Fq() {
        int i2 = this.aCd;
        if (i2 <= 16384) {
            return 4096;
        }
        return i2 <= 65536 ? 8192 : 16384;
    }

    private void Fr() {
        cq(this.aCi);
        int i2 = this.aCd;
        this.aCh = i2;
        this.aCd = this.aCi + i2;
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            bVar.position = i2;
        }
        this.aCk = true;
    }

    private void Fs() {
        if (this.aCm < (Fq() << 1)) {
            if (this.aCn.size() < (this.aCd < 16384 ? 80 : 160)) {
                return;
            }
        }
        cr(0);
    }

    private void Ft() {
        ArrayList<e> arrayList = this.aCn;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aCn.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.aCn.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aCn.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void Fu() {
        this.aCm = 0;
        ArrayList<e> arrayList = this.aCn;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private boolean X(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i2 = (int) length;
            int y = y(PAGE_SIZE, i2);
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar == null || bVar.aBO.length != y) {
                bVar = new com.kwad.sdk.utils.kwai.b(new byte[y]);
                this.aCc = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.aBO, i2);
            int i3 = bVar.getInt();
            long j2 = bVar.getLong();
            this.aCd = i3 + 12;
            if (i3 >= 0 && i3 <= i2 - 12 && j2 == bVar.x(12, i3) && Fh() == 0) {
                this.aCe = j2;
                return true;
            }
        }
        return false;
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.aCl = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String Fy = h.Fy();
        if (!h.a(new File(this.RZ + this.name, Fy), bArr)) {
            fc("save large value failed");
            return 0;
        }
        this.aCl = Fy;
        byte[] bArr2 = new byte[32];
        Fy.getBytes(0, 32, bArr2, 0);
        return b(str, bArr2, (byte) (b2 | 64));
    }

    private Object a(a.h hVar) {
        Exception exc;
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, (String) hVar.value));
            if (Z != null) {
                int i2 = Z[0] & 255;
                String str = new String(Z, 1, i2, com.kwad.sdk.utils.kwai.b.UTF_8);
                b bVar = this.aBU.get(str);
                if (bVar != null) {
                    int i3 = i2 + 1;
                    return bVar.g(Z, i3, Z.length - i3);
                }
                exc = new Exception("No encoder for tag:" + str);
            } else {
                exc = new Exception("Read object data failed");
            }
            a(exc);
            return null;
        } catch (Exception e2) {
            m(e2);
            return null;
        }
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, (String) iVar.value));
            String str = new String(Z);
            return (Z == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.kwai.b.j(Z, com.kwad.sdk.utils.kwai.b.eY(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.kwai.b.UTF_8);
        } catch (Exception e2) {
            m(e2);
        }
        return "";
    }

    private void a(byte b2, int i2) {
        long d2 = this.aCe ^ d(1L, i2);
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.put(i2, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.put(i2, b2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.aBO[i2] = b2;
        }
    }

    private void a(byte b2, int i2, int i3) {
        byte[] bArr;
        z(i2, i3);
        byte b3 = (byte) (b2 | ByteCompanionObject.MIN_VALUE);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null && (bArr = bVar.aBO) != null) {
            this.aCe = (((bArr[i2] ^ b3) & 255) << ((i2 & 7) << 3)) ^ this.aCe;
            bArr[i2] = b3;
        }
        this.aCj = i2;
    }

    private void a(int i2, long j2, int i3) {
        long d2 = d(j2, i3) ^ this.aCe;
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.putInt(i3, i2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.putInt(i3, i2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.v(i3, i2);
        }
    }

    private void a(int i2, int[] iArr) {
        Map<String, a.b> map = this.aCf;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i3 = bVar.offset;
            if (i3 > i2) {
                int i4 = iArr[(h.binarySearch(iArr, i3) << 1) + 1];
                bVar.offset -= i4;
                if (bVar.Fb() >= 6) {
                    ((a.j) bVar).start -= i4;
                }
            }
        }
    }

    private void a(Exception exc) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, aBP[b2]);
    }

    private void a(String str, byte b2, int i2) {
        int eY = com.kwad.sdk.utils.kwai.b.eY(str);
        cp(eY);
        this.aCi = eY + 2 + i2;
        Fr();
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            bVar.b(b2);
        }
        p(str, eY);
    }

    private static void a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5;
        if (i3 <= str.length() && i3 >= 0) {
            int i6 = 0;
            while (i6 < i3) {
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (charAt < 128) {
                    i5 = i4 + 1;
                    bArr[i4] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i5 = i4 + 1;
                    bArr[i4] = (byte) charAt;
                }
                i6 = i7;
                i4 = i5;
            }
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        fb(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalArgumentException;
            }
            m(illegalArgumentException);
            return;
        }
        String Fw = bVar.Fw();
        if (!Fw.isEmpty() && Fw.length() <= 50) {
            if (!this.aBU.containsKey(Fw)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (com.kwad.a.a.bI.booleanValue()) {
                    throw illegalArgumentException2;
                }
                m(illegalArgumentException2);
                return;
            }
            if (t == null) {
                remove(str);
                return;
            }
            byte[] bArr = null;
            try {
                bArr = bVar.j(t);
            } catch (Exception e2) {
                m(e2);
            }
            if (bArr == null) {
                remove(str);
                return;
            }
            int eY = com.kwad.sdk.utils.kwai.b.eY(Fw);
            com.kwad.sdk.utils.kwai.b bVar2 = new com.kwad.sdk.utils.kwai.b(eY + 1 + bArr.length);
            bVar2.b((byte) eY);
            bVar2.eX(Fw);
            bVar2.n(bArr);
            a(str, t, bVar2.aBO, (a.h) this.aCf.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + Fw);
        if (com.kwad.a.a.bI.booleanValue()) {
            throw illegalArgumentException3;
        }
        m(illegalArgumentException3);
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        int a2 = a(str, bArr, b2);
        if (a2 != 0) {
            String str2 = this.aCl;
            boolean z = str2 != null;
            if (z) {
                this.aCl = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            this.aCf.put(str, b2 == 6 ? new a.i(this.aCh, a2, (String) obj2, length, z) : b2 == 7 ? new a.C0233a(this.aCh, a2, obj2, length, z) : new a.h(this.aCh, a2, obj2, length, z));
            Fp();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a2 = a(str, bArr, jVar.Fb());
        if (a2 != 0) {
            String str2 = jVar.aBM ? (String) jVar.value : null;
            a(jVar.Fb(), jVar.start, jVar.offset + jVar.aBL);
            String str3 = this.aCl;
            boolean z = str3 != null;
            jVar.start = this.aCh;
            jVar.offset = a2;
            jVar.aBM = z;
            if (z) {
                jVar.value = str3;
                jVar.aBL = 32;
                this.aCl = null;
            } else {
                jVar.value = obj;
                jVar.aBL = bArr.length;
            }
            Fp();
            Fs();
            if (str2 != null) {
                h.c(new File(this.RZ + this.name, str2));
            }
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.aBM || jVar.aBL != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        Fi();
    }

    private void a(String str, String str2, a.i iVar) {
        int eY = com.kwad.sdk.utils.kwai.b.eY(str2);
        if (iVar == null) {
            int eY2 = com.kwad.sdk.utils.kwai.b.eY(str);
            cp(eY2);
            int i2 = eY2 + 4;
            this.aCi = i2 + eY;
            Fr();
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.b((byte) 6);
            }
            p(str, eY2);
            q(str2, eY);
            Map<String, a.b> map = this.aCf;
            int i3 = this.aCh;
            map.put(str, new a.i(i3, i3 + i2, str2, eY, false));
            Fp();
        } else {
            int i4 = iVar.offset;
            int i5 = i4 - iVar.start;
            int i6 = iVar.aBL;
            boolean z = true;
            if (i6 == eY) {
                this.aCe = this.aCc.x(i4, i6) ^ this.aCe;
                if (eY == str2.length()) {
                    a(str2, 0, eY, this.aCc.aBO, iVar.offset);
                } else {
                    com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.eX(str2);
                    }
                }
                this.aCh = iVar.offset;
                this.aCi = eY;
                z = false;
            } else {
                this.aCi = i5 + eY;
                Fr();
                com.kwad.sdk.utils.kwai.b bVar3 = this.aCc;
                if (bVar3 != null) {
                    bVar3.b((byte) 6);
                }
                int i7 = i5 - 3;
                com.kwad.sdk.utils.kwai.b bVar4 = this.aCc;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aBO;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i7);
                }
                com.kwad.sdk.utils.kwai.b bVar5 = this.aCc;
                if (bVar5 != null) {
                    bVar5.position += i7;
                }
                q(str2, eY);
                a((byte) 6, iVar.start, iVar.offset + iVar.aBL);
                r10 = iVar.aBM ? (String) iVar.value : null;
                iVar.aBM = false;
                int i8 = this.aCh;
                iVar.start = i8;
                iVar.offset = i8 + i5;
                iVar.aBL = eY;
            }
            iVar.value = str2;
            Fp();
            if (z) {
                Fs();
            }
            if (r10 != null) {
                h.c(new File(this.RZ + this.name, r10));
            }
        }
        Fi();
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i2 = PAGE_SIZE;
        if (capacity != i2) {
            FileChannel fileChannel = mappedByteBuffer == this.aCa ? this.aBW : this.aBX;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i2);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i2);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aCa) {
                this.aCa = map;
            } else {
                this.aCb = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i2) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aCb ? this.aBX : this.aBW).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aCb) {
                    this.aCb = map;
                } else {
                    this.aCa = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                m(e2);
                Fm();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i2);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    a(new Exception("missing encoders"));
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.utils.kwai.b bVar) {
        int length = bVar.aBO.length;
        File file = new File(this.RZ, this.name + ".kva");
        File file2 = new File(this.RZ, this.name + ".kvb");
        try {
            if (!h.Y(file) || !h.Y(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j2 = length;
            randomAccessFile.setLength(j2);
            randomAccessFile2.setLength(j2);
            this.aBW = randomAccessFile.getChannel();
            this.aBX = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
            this.aCa = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
            this.aCb = map2;
            map2.order(byteOrder);
            this.aCa.put(bVar.aBO, 0, this.aCd);
            this.aCb.put(bVar.aBO, 0, this.aCd);
            return true;
        } catch (Exception e2) {
            m(e2);
            return false;
        }
    }

    private byte[] a(a.C0233a c0233a) {
        try {
            byte[] Z = h.Z(new File(this.RZ + this.name, (String) c0233a.value));
            return Z != null ? Z : aBQ;
        } catch (Exception e2) {
            m(e2);
            return aBQ;
        }
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        int i2 = bVar2.position;
        bVar2.n(bArr);
        return i2;
    }

    private void b(long j2, long j3, int i2) {
        long d2 = d(j3, i2) ^ this.aCe;
        this.aCe = d2;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, d2);
                this.aCa.putLong(i2, j2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aCe);
                this.aCb.putLong(i2, j2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.aCc;
            if (bVar != null) {
                bVar.d(4, d2);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        if (bVar2 != null) {
            bVar2.d(i2, j2);
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        fb(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0233a) this.aCf.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aCk && mappedByteBuffer != this.aCa) {
            mappedByteBuffer.putInt(0, this.aCd - 12);
        }
        mappedByteBuffer.putLong(4, this.aCe);
        int i2 = this.aCj;
        if (i2 != 0) {
            mappedByteBuffer.put(i2, this.aCc.aBO[i2]);
        }
        if (this.aCi != 0) {
            mappedByteBuffer.position(this.aCh);
            mappedByteBuffer.put(this.aCc.aBO, this.aCh, this.aCi);
        }
    }

    private static void cp(int i2) {
        if (i2 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void cq(int i2) {
        if (this.aCc == null) {
            this.aCc = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        }
        int length = this.aCc.aBO.length;
        int i3 = this.aCd + i2;
        if (i3 >= length) {
            int i4 = this.aCm;
            if (i4 > i2 && i4 > Fq()) {
                cr(i2);
                return;
            }
            int y = y(length, i3);
            byte[] bArr = new byte[y];
            System.arraycopy(this.aCc.aBO, 0, bArr, 0, this.aCd);
            this.aCc.aBO = bArr;
            if (this.aCo == 0) {
                try {
                    long j2 = y;
                    MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                    this.aCa = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                    this.aCb = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    m(new Exception("map failed", th));
                    this.aCc.v(0, this.aCd - 12);
                    this.aCc.d(4, this.aCe);
                    Fm();
                }
            }
        }
    }

    private void cr(int i2) {
        int i3;
        ArrayList<e> arrayList = this.aCn;
        if (arrayList == null || this.aCc == null) {
            return;
        }
        Collections.sort(arrayList);
        Ft();
        e eVar = this.aCn.get(0);
        int i4 = eVar.start;
        int i5 = this.aCd;
        int i6 = i5 - this.aCm;
        int i7 = i6 - 12;
        int i8 = i6 - i4;
        int i9 = i5 - i4;
        boolean z = i7 < i9 + i8;
        if (!z) {
            this.aCe ^= this.aCc.x(i4, i9);
        }
        int size = this.aCn.size();
        int i10 = size - 1;
        int i11 = this.aCd - this.aCn.get(i10).end;
        int[] iArr = new int[(i11 > 0 ? size : i10) << 1];
        int i12 = eVar.start;
        int i13 = eVar.end;
        for (int i14 = 1; i14 < size; i14++) {
            e eVar2 = this.aCn.get(i14);
            int i15 = eVar2.start - i13;
            byte[] bArr = this.aCc.aBO;
            System.arraycopy(bArr, i13, bArr, i12, i15);
            int i16 = (i14 - 1) << 1;
            iArr[i16] = i13;
            iArr[i16 + 1] = i13 - i12;
            i12 += i15;
            i13 = eVar2.end;
        }
        if (i11 > 0) {
            byte[] bArr2 = this.aCc.aBO;
            System.arraycopy(bArr2, i13, bArr2, i12, i11);
            int i17 = i10 << 1;
            iArr[i17] = i13;
            iArr[i17 + 1] = i13 - i12;
        }
        Fu();
        this.aCe = z ? this.aCc.x(12, i7) : this.aCe ^ this.aCc.x(i4, i8);
        this.aCd = i6;
        if (this.aCo == 0) {
            MappedByteBuffer mappedByteBuffer = this.aCa;
            if (mappedByteBuffer != null) {
                i3 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aCa.putLong(4, this.aCe);
                this.aCa.position(i4);
                this.aCa.put(this.aCc.aBO, i4, i8);
                this.aCa.putInt(0, i7);
            } else {
                i3 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aCb;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i3, i7);
                this.aCb.putLong(4, this.aCe);
                this.aCb.position(i4);
                this.aCb.put(this.aCc.aBO, i4, i8);
            }
        } else {
            this.aCc.v(0, i7);
            this.aCc.d(4, this.aCe);
        }
        a(i4, iArr);
        int i18 = i6 + i2;
        if (this.aCc.aBO.length - i18 > aBT) {
            cs(i18);
        }
        info("gc finish");
    }

    private void cs(int i2) {
        int i3 = PAGE_SIZE;
        int y = y(i3, i2 + i3);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            byte[] bArr = bVar.aBO;
            if (y >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[y];
            System.arraycopy(bArr, 0, bArr2, 0, this.aCd);
            this.aCc.aBO = bArr2;
        }
        if (this.aCo == 0) {
            try {
                long j2 = y;
                this.aBW.truncate(j2);
                MappedByteBuffer map = this.aBW.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                this.aCa = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aBX.truncate(j2);
                MappedByteBuffer map2 = this.aBX.map(FileChannel.MapMode.READ_WRITE, 0L, j2);
                this.aCb = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                m(new Exception("map failed", th));
                Fm();
            }
        }
        info("truncate finish");
    }

    private static long d(long j2, int i2) {
        int i3 = (i2 & 7) << 3;
        return (j2 >>> (64 - i3)) | (j2 << i3);
    }

    private static void d(int i2, boolean z) {
        if (z) {
            if (i2 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i2 < 0 || i2 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void f(File file, File file2) {
        try {
            if (X(file)) {
                return;
            }
        } catch (IOException e2) {
            a(e2);
        }
        Fo();
        try {
            if (X(file2)) {
                return;
            }
        } catch (Exception e3) {
            a(e3);
        }
        Fo();
    }

    private static void fb(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void fc(String str) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void m(Throwable th) {
        d dVar = this.aBV;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void p(String str, int i2) {
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null) {
            return;
        }
        bVar.b((byte) i2);
        if (i2 != str.length()) {
            this.aCc.eX(str);
            return;
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
        a(str, 0, i2, bVar2.aBO, bVar2.position);
        this.aCc.position += i2;
    }

    private synchronized void putDouble(String str, double d2) {
        fb(str);
        a.d dVar = (a.d) this.aCf.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits;
                dVar.value = d2;
                b(doubleToRawLongBits, doubleToRawLongBits2, dVar.offset);
                Fi();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            int i2 = bVar.position;
            bVar.ai(Double.doubleToRawLongBits(d2));
            Fp();
            Map<String, a.b> map = this.aCf;
            if (map != null) {
                map.put(str, new a.d(i2, d2));
            }
        }
        Fi();
    }

    private synchronized void putFloat(String str, float f2) {
        fb(str);
        a.e eVar = (a.e) this.aCf.get(str);
        if (eVar != null) {
            if (eVar.value != f2) {
                eVar.value = f2;
                a(Float.floatToRawIntBits(f2), (Float.floatToRawIntBits(eVar.value) ^ r6) & 4294967295L, eVar.offset);
                Fi();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            int i2 = bVar.position;
            bVar.ci(Float.floatToRawIntBits(f2));
            Fp();
            Map<String, a.b> map = this.aCf;
            if (map != null) {
                map.put(str, new a.e(i2, f2));
            }
        }
        Fi();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aCH);
        }
    }

    private void q(String str, int i2) {
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i2);
        if (i2 != str.length()) {
            this.aCc.eX(str);
        } else {
            com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
            a(str, 0, i2, bVar2.aBO, bVar2.position);
        }
    }

    private void updateBytes(int i2, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            this.aCe ^= bVar.x(i2, length);
            com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
            bVar2.position = i2;
            bVar2.n(bArr);
            this.aCe ^= this.aCc.x(i2, length);
        }
        if (this.aCo != 0) {
            com.kwad.sdk.utils.kwai.b bVar3 = this.aCc;
            if (bVar3 != null) {
                bVar3.d(4, this.aCe);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.aCa;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.aCa.putLong(4, this.aCe);
            this.aCa.position(i2);
            this.aCa.put(bArr);
            this.aCa.putInt(0, this.aCd - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.aCb;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.aCe);
            this.aCb.position(i2);
            this.aCb.put(bArr);
        }
    }

    private int y(int i2, int i3) {
        if (i3 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.a.a.bI.booleanValue()) {
                throw illegalStateException;
            }
            m(illegalStateException);
        }
        int i4 = PAGE_SIZE;
        if (i3 <= i4) {
            return i4;
        }
        while (i2 < i3) {
            int i5 = aBS;
            i2 = i2 <= i5 ? i2 << 1 : i2 + i5;
        }
        return i2;
    }

    private void z(int i2, int i3) {
        this.aCm += i3 - i2;
        ArrayList<e> arrayList = this.aCn;
        if (arrayList != null) {
            arrayList.add(new e(i2, i3));
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aCf.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        a.j jVar;
        int size = this.aCf.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.aCf.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            Object obj = null;
            switch (value.Fb()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    obj = valueOf;
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    obj = valueOf;
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    obj = valueOf;
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    obj = valueOf;
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    obj = valueOf;
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    boolean z = iVar.aBM;
                    jVar = iVar;
                    if (z) {
                        valueOf = a(iVar);
                        obj = valueOf;
                        break;
                    }
                    valueOf = jVar.value;
                    obj = valueOf;
                case 7:
                    a.C0233a c0233a = (a.C0233a) value;
                    boolean z2 = c0233a.aBM;
                    jVar = c0233a;
                    if (z2) {
                        valueOf = a(c0233a);
                        obj = valueOf;
                        break;
                    }
                    valueOf = jVar.value;
                    obj = valueOf;
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aBM) {
                        valueOf = a(hVar);
                        obj = valueOf;
                        break;
                    } else {
                        jVar = (a.h) value;
                        valueOf = jVar.value;
                        obj = valueOf;
                    }
            }
            hashMap.put(key, obj);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.aCf.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i2) {
        a.f fVar = (a.f) this.aCf.get(str);
        if (fVar == null) {
            return i2;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j2) {
        a.g gVar = (a.g) this.aCf.get(str);
        if (gVar == null) {
            return j2;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aCf.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.aBM) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        fb(str);
        a.c cVar = (a.c) this.aCf.get(str);
        if (cVar != null) {
            if (cVar.value != z) {
                cVar.value = z;
                a((byte) (z ? 1 : 0), cVar.offset);
                Fi();
            }
            return;
        }
        a(str, (byte) 1);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            int i2 = bVar.position;
            bVar.b((byte) (z ? 1 : 0));
            Fp();
            Map<String, a.b> map = this.aCf;
            if (map != null) {
                map.put(str, new a.c(i2, z));
            }
        }
        Fi();
    }

    public final synchronized void putInt(String str, int i2) {
        fb(str);
        a.f fVar = (a.f) this.aCf.get(str);
        if (fVar != null) {
            if (fVar.value != i2) {
                fVar.value = i2;
                a(i2, (r6 ^ i2) & 4294967295L, fVar.offset);
                Fi();
            }
            return;
        }
        a(str, (byte) 2);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            int i3 = bVar.position;
            bVar.ci(i2);
            Fp();
            Map<String, a.b> map = this.aCf;
            if (map != null) {
                map.put(str, new a.f(i3, i2));
            }
        }
        Fi();
    }

    public final synchronized void putLong(String str, long j2) {
        fb(str);
        a.g gVar = (a.g) this.aCf.get(str);
        if (gVar != null) {
            long j3 = gVar.value;
            if (j3 != j2) {
                gVar.value = j2;
                b(j2, j2 ^ j3, gVar.offset);
                Fi();
            }
            return;
        }
        a(str, (byte) 4);
        com.kwad.sdk.utils.kwai.b bVar = this.aCc;
        if (bVar != null) {
            int i2 = bVar.position;
            bVar.ai(j2);
            Fp();
            Map<String, a.b> map = this.aCf;
            if (map != null) {
                map.put(str, new a.g(i2, j2));
            }
        }
        Fi();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArr;
        byte[] fa;
        byte[] bArr2;
        fb(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aCf.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            fa = aBQ;
        } else if (iVar != null || str2.length() >= 2048) {
            if (iVar != null && !iVar.aBM) {
                int eY = com.kwad.sdk.utils.kwai.b.eY(str2);
                bArr = new byte[eY];
                if (eY == str2.length()) {
                    a(str2, 0, eY, bArr, 0);
                    bArr2 = bArr;
                    a(str, str2, bArr2, iVar, (byte) 6);
                }
            }
            fa = com.kwad.sdk.utils.kwai.b.fa(str2);
        } else {
            int eY2 = com.kwad.sdk.utils.kwai.b.eY(str2);
            bArr = new byte[eY2];
            if (eY2 == str2.length()) {
                a(str2, 0, eY2, bArr, 0);
                bArr2 = bArr;
                a(str, str2, bArr2, iVar, (byte) 6);
            }
            fa = com.kwad.sdk.utils.kwai.b.fa(str2);
        }
        bArr2 = fa;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aBY);
        h.closeQuietly(this.aBZ);
        h.closeQuietly(this.aBW);
        h.closeQuietly(this.aBX);
        this.aBW = null;
        this.aBX = null;
        this.aCa = null;
        this.aCb = null;
        String str = this.RZ + this.name;
        C0234c c0234c = a.aCt;
        C0234c.remove(str);
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.aCf.get(str);
        if (bVar != null) {
            this.aCf.remove(str);
            byte Fb = bVar.Fb();
            String str2 = null;
            if (Fb <= 5) {
                int eY = com.kwad.sdk.utils.kwai.b.eY(str);
                int i2 = bVar.offset;
                a(Fb, i2 - (eY + 2), i2 + aBP[Fb]);
            } else {
                a.j jVar = (a.j) bVar;
                a(Fb, jVar.start, jVar.offset + jVar.aBL);
                if (jVar.aBM) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (Fb | ByteCompanionObject.MIN_VALUE);
            if (this.aCo == 0) {
                MappedByteBuffer mappedByteBuffer = this.aCa;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.aCe);
                    this.aCa.put(this.aCj, b2);
                }
                MappedByteBuffer mappedByteBuffer2 = this.aCb;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.aCe);
                    this.aCb.put(this.aCj, b2);
                }
            } else {
                com.kwad.sdk.utils.kwai.b bVar2 = this.aCc;
                if (bVar2 != null) {
                    bVar2.d(4, this.aCe);
                }
            }
            this.aCj = 0;
            if (str2 != null) {
                h.c(new File(this.RZ + this.name, str2));
            }
            Fs();
            Fi();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.RZ + " name:" + this.name;
    }
}
