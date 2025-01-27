package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.media3.common.C;
import com.google.common.primitives.SignedBytes;
import com.kwad.sdk.utils.a.a;
import com.sigmob.sdk.videocache.h;
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

/* loaded from: classes3.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aVZ = {0, 1, 4, 4, 8, 8};
    private static final byte[] aWa = new byte[0];
    private static final int aWb;
    private static final int aWc;
    private static final int aWd;
    private final String Yx;
    private final Map<String, b> aWe;
    private FileChannel aWg;
    private FileChannel aWh;
    private RandomAccessFile aWi;
    private RandomAccessFile aWj;
    private MappedByteBuffer aWk;
    private MappedByteBuffer aWl;
    private com.kwad.sdk.utils.a.b aWm;
    private int aWn;
    private long aWo;
    private int aWr;
    private int aWs;
    private int aWt;
    private boolean aWu;
    private String aWv;
    private int aWw;
    private int aWy;
    private final String name;
    private final d aWf = com.kwad.sdk.utils.a.d.aWJ;
    private final Map<String, a.b> aWp = new HashMap();
    private boolean aWq = false;
    private final ArrayList<e> aWx = new ArrayList<>();
    private boolean aWz = true;
    private final Executor aWA = new f();

    /* renamed from: com.kwad.sdk.utils.a.c$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.Pt();
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.c$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.PA();
        }
    }

    public static class a {
        static int aWC = 11;
        static final C0516c aWD = new C0516c(11);
        private final String Yx;
        private b[] aWE;
        private int aWy = 0;
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
            this.Yx = str;
            this.name = str2;
        }

        public final c PL() {
            String str = this.Yx + this.name;
            c hw = C0516c.hw(str);
            if (hw == null) {
                synchronized (a.class) {
                    try {
                        hw = C0516c.hw(str);
                        if (hw == null) {
                            hw = new c(this.Yx, this.name, this.aWE, this.aWy);
                            C0516c.b(str, hw);
                        }
                    } finally {
                    }
                }
            }
            Integer num = C0516c.aWI.get(str);
            if (num != null) {
                C0516c.aWI.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0516c.aWI.put(str, 1);
            }
            return hw;
        }
    }

    public interface b<T> {
        String PM();

        T g(byte[] bArr, int i10, int i11);

        byte[] m(T t10);
    }

    /* renamed from: com.kwad.sdk.utils.a.c$c */
    public static class C0516c {
        private static Map<String, c> aWF;
        private static List<String> aWG;
        private static int aWH;
        public static Map<String, Integer> aWI;

        public C0516c(int i10) {
            int size = getSize(i10);
            aWF = new ConcurrentHashMap(size);
            aWI = new HashMap(size);
            aWG = new CopyOnWriteArrayList();
            aWH = i10;
        }

        public static void b(String str, c cVar) {
            if (aWF == null) {
                aWF = new ConcurrentHashMap(getSize(aWH));
            }
            if (aWG == null) {
                aWG = new CopyOnWriteArrayList();
            }
            if (aWF.containsKey(str)) {
                aWG.remove(str);
                aWG.add(str);
            } else {
                aWG.add(str);
            }
            aWF.put(str, cVar);
            if (aWF.size() > aWH) {
                Integer num = aWI.get(aWG.get(0));
                if (num != null && num.intValue() != 2) {
                    ex(aWH + 1);
                    return;
                }
                c cVar2 = aWF.get(aWG.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aWF.remove(aWG.get(0));
                aWG.remove(0);
            }
        }

        private static void ex(int i10) {
            com.kwad.sdk.utils.a.d.aWJ.i("Ks_UnionKv", "reSize:" + i10);
            aWH = i10;
        }

        private static int getSize(int i10) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }

        public static c hw(String str) {
            if (aWF == null) {
                aWF = new ConcurrentHashMap(getSize(aWH));
            }
            if (aWG == null) {
                aWG = new CopyOnWriteArrayList();
            }
            c cVar = aWF.get(str);
            if (cVar == null) {
                return null;
            }
            aWG.remove(str);
            aWG.add(str);
            return cVar;
        }

        public static void remove(String str) {
            List<String> list = aWG;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aWF;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th2);

        void i(String str, String str2);
    }

    public static class e implements Comparable<e> {
        int end;
        int start;

        public e(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int PP = h.PP();
        PAGE_SIZE = PP;
        aWb = PP - 192;
        int max = Math.max(PP << 1, 16384);
        aWc = max;
        aWd = max << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i10) {
        this.Yx = str;
        this.name = str2;
        this.aWy = i10;
        HashMap hashMap = new HashMap();
        g gVar = g.aWQ;
        hashMap.put(gVar.PM(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String PM = bVar.PM();
                if (hashMap.containsKey(PM)) {
                    hv("duplicate encoder tag:" + PM);
                } else {
                    hashMap.put(PM, bVar);
                }
            }
        }
        this.aWe = hashMap;
        synchronized (this.aWp) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Pt();
                }
            });
            while (!this.aWq) {
                try {
                    this.aWp.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private int E(int i10, int i11) {
        if (i11 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.ns.booleanValue()) {
                throw illegalStateException;
            }
            u(illegalStateException);
        }
        int i12 = PAGE_SIZE;
        if (i11 <= i12) {
            return i12;
        }
        while (i10 < i11) {
            int i13 = aWc;
            i10 = i10 <= i13 ? i10 << 1 : i10 + i13;
        }
        return i10;
    }

    private void F(int i10, int i11) {
        this.aWw += i11 - i10;
        ArrayList<e> arrayList = this.aWx;
        if (arrayList != null) {
            arrayList.add(new e(i10, i11));
        }
    }

    public synchronized boolean PA() {
        try {
            try {
                File file = new File(this.Yx, this.name + ".tmp");
                if (h.af(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.aWn);
                    randomAccessFile.write(this.aWm.aVY, 0, this.aWn);
                    randomAccessFile.close();
                    File file2 = new File(this.Yx, this.name + ".kvc");
                    if (file2.exists()) {
                        if (file2.delete()) {
                        }
                    }
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            } catch (Exception e10) {
                u(e10);
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void PB() {
        try {
            h.h(new File(this.Yx, this.name + ".kvc"));
            h.h(new File(this.Yx, this.name + ".tmp"));
        } catch (Exception e10) {
            u(e10);
        }
    }

    private void PC() {
        this.aWy = 1;
        h.closeQuietly(this.aWg);
        h.closeQuietly(this.aWh);
        this.aWg = null;
        this.aWh = null;
        this.aWk = null;
        this.aWl = null;
    }

    private void PD() {
        if (this.aWy == 0) {
            try {
                a(this.aWk);
                a(this.aWl);
            } catch (Throwable unused) {
                PC();
            }
        }
        PE();
        h.h(new File(this.Yx + this.name));
    }

    private void PE() {
        this.aWn = 12;
        this.aWo = 0L;
        PK();
        this.aWp.clear();
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar == null || bVar.aVY.length != PAGE_SIZE) {
            this.aWm = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            bVar.B(0, 0);
            this.aWm.f(4, 0L);
        }
    }

    private void PF() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        if (bVar2 != null) {
            this.aWo ^= bVar2.D(this.aWr, this.aWs);
        }
        if (this.aWy == 0) {
            MappedByteBuffer mappedByteBuffer = this.aWk;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aWk);
                this.aWk.putInt(0, this.aWn - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aWl;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aWu && (bVar = this.aWm) != null) {
                bVar.B(0, this.aWn - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.aWm;
            if (bVar3 != null) {
                bVar3.f(4, this.aWo);
            }
        }
        this.aWu = false;
        this.aWt = 0;
        this.aWs = 0;
    }

    private int PG() {
        int i10 = this.aWn;
        if (i10 <= 16384) {
            return 4096;
        }
        return i10 <= 65536 ? 8192 : 16384;
    }

    private void PH() {
        eu(this.aWs);
        int i10 = this.aWn;
        this.aWr = i10;
        this.aWn = this.aWs + i10;
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar != null) {
            bVar.position = i10;
        }
        this.aWu = true;
    }

    private void PI() {
        if (this.aWw < (PG() << 1)) {
            if (this.aWx.size() < (this.aWn < 16384 ? 80 : 160)) {
                return;
            }
        }
        ev(0);
    }

    private void PJ() {
        ArrayList<e> arrayList = this.aWx;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aWx.get(size);
        while (size > 0) {
            int i10 = size - 1;
            e eVar2 = this.aWx.get(i10);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aWx.remove(size);
            }
            eVar = eVar2;
            size = i10;
        }
    }

    private void PK() {
        this.aWw = 0;
        ArrayList<e> arrayList = this.aWx;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public synchronized void Pt() {
        try {
            synchronized (this.aWp) {
                this.aWq = true;
                this.aWp.notify();
            }
            long nanoTime = System.nanoTime();
            if (!Pw() && this.aWy == 0) {
                Pu();
            }
            if (this.aWm == null) {
                this.aWm = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
            }
            if (this.aWf != null) {
                info("loading finish, data len:" + this.aWn + ", get keys:" + this.aWp.size() + ", use time:" + ((System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND) + " ms");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void Pu() {
        c cVar = this;
        File file = new File(cVar.Yx, cVar.name + ".kva");
        File file2 = new File(cVar.Yx, cVar.name + ".kvb");
        try {
            if (h.af(file) && h.af(file2)) {
                cVar.aWi = new RandomAccessFile(file, "rw");
                cVar.aWj = new RandomAccessFile(file2, "rw");
                long length = cVar.aWi.length();
                long length2 = cVar.aWj.length();
                cVar.aWg = cVar.aWi.getChannel();
                cVar.aWh = cVar.aWj.getChannel();
                try {
                    FileChannel fileChannel = cVar.aWg;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : PAGE_SIZE);
                    cVar.aWk = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = cVar.aWh.map(mapMode, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    cVar.aWl = map2;
                    map2.order(byteOrder);
                    cVar.aWm = new com.kwad.sdk.utils.a.b(cVar.aWk.capacity());
                    if (length == 0 && length2 == 0) {
                        cVar.aWn = 12;
                        return;
                    }
                    int i10 = cVar.aWk.getInt();
                    long j10 = cVar.aWk.getLong();
                    int i11 = cVar.aWl.getInt();
                    long j11 = cVar.aWl.getLong();
                    if (i10 >= 0) {
                        if (i10 <= length - 12) {
                            cVar = this;
                            cVar.aWn = i10 + 12;
                            cVar.aWk.rewind();
                            cVar.aWk.get(cVar.aWm.aVY, 0, cVar.aWn);
                            if (j10 == cVar.aWm.D(12, i10) && Px() == 0) {
                                cVar.aWo = j10;
                                if (length == length2 && Pv()) {
                                    return;
                                }
                                cVar.g(new Exception("B file error"));
                                cVar.a(cVar.aWk, cVar.aWl, cVar.aWn);
                                return;
                            }
                        } else {
                            cVar = this;
                        }
                    }
                    if (i11 >= 0 && i11 <= length2 - 12) {
                        cVar.aWp.clear();
                        PK();
                        cVar.aWn = i11 + 12;
                        if (cVar.aWm.aVY.length != cVar.aWl.capacity()) {
                            cVar.aWm = new com.kwad.sdk.utils.a.b(cVar.aWl.capacity());
                        }
                        cVar.aWl.rewind();
                        cVar.aWl.get(cVar.aWm.aVY, 0, cVar.aWn);
                        if (j11 == cVar.aWm.D(12, i11) && Px() == 0) {
                            cVar.g(new Exception("A file error"));
                            cVar.a(cVar.aWl, cVar.aWk, cVar.aWn);
                            cVar.aWo = j11;
                            return;
                        }
                    }
                    cVar.hv("both files error");
                    PD();
                    return;
                } catch (IOException e10) {
                    cVar.u(e10);
                    PC();
                    cVar.h(file, file2);
                    return;
                }
            }
            cVar.u(new Exception("open file failed"));
            PC();
        } catch (Throwable th2) {
            cVar.u(th2);
            PE();
            PC();
        }
    }

    private boolean Pv() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.aWn);
        MappedByteBuffer mappedByteBuffer = this.aWl;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aWl.get(bVar.aVY, 0, this.aWn);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.aVY;
        byte[] bArr2 = bVar.aVY;
        for (int i10 = 0; i10 < this.aWn; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean Pw() {
        File file = new File(this.Yx, this.name + ".kvc");
        File file2 = new File(this.Yx, this.name + ".tmp");
        boolean z10 = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!ae(file)) {
                    PE();
                    PB();
                    return false;
                }
                if (this.aWy != 0) {
                    return false;
                }
                if (!a(this.aWm)) {
                    this.aWy = 1;
                    return false;
                }
                info("recover from c file");
                try {
                    PB();
                    return true;
                } catch (Exception e10) {
                    e = e10;
                    z10 = true;
                    u(e);
                    return z10;
                }
            }
            if (this.aWy == 0) {
                return false;
            }
            File file3 = new File(this.Yx, this.name + ".kva");
            File file4 = new File(this.Yx, this.name + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            h(file3, file4);
            return false;
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0175, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Px() {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Px():int");
    }

    private void Py() {
        if (this.aWy == 0 || !this.aWz) {
            return;
        }
        Pz();
    }

    private boolean Pz() {
        int i10 = this.aWy;
        if (i10 == 1) {
            Executor executor = this.aWA;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.PA();
                    }
                });
            }
        } else if (i10 == 2) {
            return PA();
        }
        return true;
    }

    private boolean ae(File file) {
        long length = file.length();
        if (length != 0 && length <= h.b.f20616f) {
            int i10 = (int) length;
            int E = E(PAGE_SIZE, i10);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar == null || bVar.aVY.length != E) {
                bVar = new com.kwad.sdk.utils.a.b(new byte[E]);
                this.aWm = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.aVY, i10);
            int i11 = bVar.getInt();
            long j10 = bVar.getLong();
            this.aWn = i11 + 12;
            if (i11 >= 0 && i11 <= i10 - 12 && j10 == bVar.D(12, i11) && Px() == 0) {
                this.aWo = j10;
                return true;
            }
        }
        return false;
    }

    private static long e(long j10, int i10) {
        int i11 = (i10 & 7) << 3;
        return (j10 >>> (64 - i11)) | (j10 << i11);
    }

    private static void et(int i10) {
        if (i10 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void eu(int i10) {
        if (this.aWm == null) {
            this.aWm = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.aWm.aVY.length;
        int i11 = this.aWn + i10;
        if (i11 >= length) {
            int i12 = this.aWw;
            if (i12 > i10 && i12 > PG()) {
                ev(i10);
                return;
            }
            int E = E(length, i11);
            byte[] bArr = new byte[E];
            System.arraycopy(this.aWm.aVY, 0, bArr, 0, this.aWn);
            this.aWm.aVY = bArr;
            if (this.aWy == 0) {
                try {
                    FileChannel fileChannel = this.aWg;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j10 = E;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
                    this.aWk = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aWh.map(mapMode, 0L, j10);
                    this.aWl = map2;
                    map2.order(byteOrder);
                } catch (Throwable th2) {
                    u(new Exception("map failed", th2));
                    this.aWm.B(0, this.aWn - 12);
                    this.aWm.f(4, this.aWo);
                    PC();
                }
            }
        }
    }

    private void ev(int i10) {
        int i11;
        ArrayList<e> arrayList = this.aWx;
        if (arrayList == null || this.aWm == null) {
            return;
        }
        Collections.sort(arrayList);
        PJ();
        e eVar = this.aWx.get(0);
        int i12 = eVar.start;
        int i13 = this.aWn;
        int i14 = i13 - this.aWw;
        int i15 = i14 - 12;
        int i16 = i14 - i12;
        int i17 = i13 - i12;
        boolean z10 = i15 < i17 + i16;
        if (!z10) {
            this.aWo ^= this.aWm.D(i12, i17);
        }
        int size = this.aWx.size();
        int i18 = size - 1;
        int i19 = this.aWn - this.aWx.get(i18).end;
        int[] iArr = new int[(i19 > 0 ? size : i18) << 1];
        int i20 = eVar.start;
        int i21 = eVar.end;
        for (int i22 = 1; i22 < size; i22++) {
            e eVar2 = this.aWx.get(i22);
            int i23 = eVar2.start - i21;
            byte[] bArr = this.aWm.aVY;
            System.arraycopy(bArr, i21, bArr, i20, i23);
            int i24 = (i22 - 1) << 1;
            iArr[i24] = i21;
            iArr[i24 + 1] = i21 - i20;
            i20 += i23;
            i21 = eVar2.end;
        }
        if (i19 > 0) {
            byte[] bArr2 = this.aWm.aVY;
            System.arraycopy(bArr2, i21, bArr2, i20, i19);
            int i25 = i18 << 1;
            iArr[i25] = i21;
            iArr[i25 + 1] = i21 - i20;
        }
        PK();
        if (z10) {
            this.aWo = this.aWm.D(12, i15);
        } else {
            this.aWo ^= this.aWm.D(i12, i16);
        }
        this.aWn = i14;
        if (this.aWy == 0) {
            MappedByteBuffer mappedByteBuffer = this.aWk;
            if (mappedByteBuffer != null) {
                i11 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aWk.putLong(4, this.aWo);
                this.aWk.position(i12);
                this.aWk.put(this.aWm.aVY, i12, i16);
                this.aWk.putInt(0, i15);
            } else {
                i11 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aWl;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i11, i15);
                this.aWl.putLong(4, this.aWo);
                this.aWl.position(i12);
                this.aWl.put(this.aWm.aVY, i12, i16);
            }
        } else {
            this.aWm.B(0, i15);
            this.aWm.f(4, this.aWo);
        }
        a(i12, iArr);
        int i26 = i14 + i10;
        if (this.aWm.aVY.length - i26 > aWd) {
            ew(i26);
        }
        info("gc finish");
    }

    private void ew(int i10) {
        int i11 = PAGE_SIZE;
        int E = E(i11, i10 + i11);
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar != null) {
            byte[] bArr = bVar.aVY;
            if (E >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[E];
            System.arraycopy(bArr, 0, bArr2, 0, this.aWn);
            this.aWm.aVY = bArr2;
        }
        if (this.aWy == 0) {
            try {
                long j10 = E;
                this.aWg.truncate(j10);
                FileChannel fileChannel = this.aWg;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
                this.aWk = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aWh.truncate(j10);
                MappedByteBuffer map2 = this.aWh.map(mapMode, 0L, j10);
                this.aWl = map2;
                map2.order(byteOrder);
            } catch (Throwable th2) {
                u(new Exception("map failed", th2));
                PC();
            }
        }
        info("truncate finish");
    }

    private void g(Exception exc) {
        d dVar = this.aWf;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void h(File file, File file2) {
        try {
            if (ae(file)) {
                return;
            }
        } catch (IOException e10) {
            g(e10);
        }
        PE();
        try {
            if (ae(file2)) {
                return;
            }
        } catch (Exception e11) {
            g(e11);
        }
        PE();
    }

    private static void hu(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hv(String str) {
        d dVar = this.aWf;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aWf;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d10) {
        try {
            hu(str);
            a.d dVar = (a.d) this.aWp.get(str);
            if (dVar != null) {
                if (dVar.value != d10) {
                    long doubleToRawLongBits = Double.doubleToRawLongBits(d10);
                    long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits;
                    dVar.value = d10;
                    b(doubleToRawLongBits, doubleToRawLongBits2, dVar.offset);
                    Py();
                }
                return;
            }
            a(str, (byte) 5);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.aQ(Double.doubleToRawLongBits(d10));
                PF();
                Map<String, a.b> map = this.aWp;
                if (map != null) {
                    map.put(str, new a.d(i10, d10));
                }
            }
            Py();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void putFloat(String str, float f10) {
        try {
            hu(str);
            a.e eVar = (a.e) this.aWp.get(str);
            if (eVar != null) {
                if (eVar.value != f10) {
                    eVar.value = f10;
                    a(Float.floatToRawIntBits(f10), (Float.floatToRawIntBits(eVar.value) ^ r6) & 4294967295L, eVar.offset);
                    Py();
                }
                return;
            }
            a(str, (byte) 3);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.em(Float.floatToRawIntBits(f10));
                PF();
                Map<String, a.b> map = this.aWp;
                if (map != null) {
                    map.put(str, new a.e(i10, f10));
                }
            }
            Py();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aWQ);
        }
    }

    private void t(String str, int i10) {
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i10);
        if (i10 != str.length()) {
            this.aWm.hq(str);
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        a(str, 0, i10, bVar2.aVY, bVar2.position);
        this.aWm.position += i10;
    }

    private void u(String str, int i10) {
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i10);
        if (i10 != str.length()) {
            this.aWm.hq(str);
        } else {
            com.kwad.sdk.utils.a.b bVar2 = this.aWm;
            a(str, 0, i10, bVar2.aVY, bVar2.position);
        }
    }

    private void updateBytes(int i10, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar != null) {
            this.aWo ^= bVar.D(i10, length);
            com.kwad.sdk.utils.a.b bVar2 = this.aWm;
            bVar2.position = i10;
            bVar2.n(bArr);
            this.aWo ^= this.aWm.D(i10, length);
        }
        if (this.aWy != 0) {
            com.kwad.sdk.utils.a.b bVar3 = this.aWm;
            if (bVar3 != null) {
                bVar3.f(4, this.aWo);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.aWk;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.aWk.putLong(4, this.aWo);
            this.aWk.position(i10);
            this.aWk.put(bArr);
            this.aWk.putInt(0, this.aWn - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.aWl;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.aWo);
            this.aWl.position(i10);
            this.aWl.put(bArr);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aWp.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.aWp.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.aWp.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            switch (value.Pr()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.aVW) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0515a c0515a = (a.C0515a) value;
                    if (c0515a.aVW) {
                        valueOf = a(c0515a);
                        break;
                    } else {
                        valueOf = c0515a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aVW) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z10) {
        a.c cVar = (a.c) this.aWp.get(str);
        if (cVar == null) {
            return z10;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i10) {
        a.f fVar = (a.f) this.aWp.get(str);
        if (fVar == null) {
            return i10;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j10) {
        a.g gVar = (a.g) this.aWp.get(str);
        if (gVar == null) {
            return j10;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aWp.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.aVW) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z10) {
        try {
            hu(str);
            a.c cVar = (a.c) this.aWp.get(str);
            if (cVar != null) {
                if (cVar.value != z10) {
                    cVar.value = z10;
                    a(z10 ? (byte) 1 : (byte) 0, cVar.offset);
                    Py();
                }
                return;
            }
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.e(z10 ? (byte) 1 : (byte) 0);
                PF();
                Map<String, a.b> map = this.aWp;
                if (map != null) {
                    map.put(str, new a.c(i10, z10));
                }
            }
            Py();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void putInt(String str, int i10) {
        try {
            hu(str);
            a.f fVar = (a.f) this.aWp.get(str);
            if (fVar != null) {
                if (fVar.value != i10) {
                    fVar.value = i10;
                    a(i10, (r6 ^ i10) & 4294967295L, fVar.offset);
                    Py();
                }
                return;
            }
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                int i11 = bVar.position;
                bVar.em(i10);
                PF();
                Map<String, a.b> map = this.aWp;
                if (map != null) {
                    map.put(str, new a.f(i11, i10));
                }
            }
            Py();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void putLong(String str, long j10) {
        try {
            hu(str);
            a.g gVar = (a.g) this.aWp.get(str);
            if (gVar != null) {
                long j11 = gVar.value;
                if (j11 != j10) {
                    gVar.value = j10;
                    b(j10, j10 ^ j11, gVar.offset);
                    Py();
                }
                return;
            }
            a(str, (byte) 4);
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                int i10 = bVar.position;
                bVar.aQ(j10);
                PF();
                Map<String, a.b> map = this.aWp;
                if (map != null) {
                    map.put(str, new a.g(i10, j10));
                }
            }
            Py();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] ht;
        byte[] bArr;
        byte[] bArr2;
        hu(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aWp.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (!str2.isEmpty()) {
            if (iVar == null && str2.length() < 2048) {
                int hr = com.kwad.sdk.utils.a.b.hr(str2);
                bArr = new byte[hr];
                if (hr == str2.length()) {
                    a(str2, 0, hr, bArr, 0);
                    bArr2 = bArr;
                } else {
                    ht = com.kwad.sdk.utils.a.b.ht(str2);
                }
            } else if (iVar == null || iVar.aVW) {
                ht = com.kwad.sdk.utils.a.b.ht(str2);
            } else {
                int hr2 = com.kwad.sdk.utils.a.b.hr(str2);
                bArr = new byte[hr2];
                if (hr2 == str2.length()) {
                    a(str2, 0, hr2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    ht = com.kwad.sdk.utils.a.b.ht(str2);
                }
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        ht = aWa;
        bArr2 = ht;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aWi);
        h.closeQuietly(this.aWj);
        h.closeQuietly(this.aWg);
        h.closeQuietly(this.aWh);
        this.aWg = null;
        this.aWh = null;
        this.aWk = null;
        this.aWl = null;
        String str = this.Yx + this.name;
        C0516c c0516c = a.aWD;
        C0516c.remove(str);
    }

    public final synchronized void remove(String str) {
        try {
            a.b bVar = this.aWp.get(str);
            if (bVar != null) {
                this.aWp.remove(str);
                byte Pr = bVar.Pr();
                String str2 = null;
                if (Pr <= 5) {
                    int hr = com.kwad.sdk.utils.a.b.hr(str);
                    int i10 = bVar.offset;
                    a(Pr, i10 - (hr + 2), i10 + aVZ[Pr]);
                } else {
                    a.j jVar = (a.j) bVar;
                    a(Pr, jVar.start, jVar.offset + jVar.aVV);
                    if (jVar.aVW) {
                        str2 = (String) jVar.value;
                    }
                }
                byte b10 = (byte) (Pr | Byte.MIN_VALUE);
                if (this.aWy == 0) {
                    MappedByteBuffer mappedByteBuffer = this.aWk;
                    if (mappedByteBuffer != null) {
                        mappedByteBuffer.putLong(4, this.aWo);
                        this.aWk.put(this.aWt, b10);
                    }
                    MappedByteBuffer mappedByteBuffer2 = this.aWl;
                    if (mappedByteBuffer2 != null) {
                        mappedByteBuffer2.putLong(4, this.aWo);
                        this.aWl.put(this.aWt, b10);
                    }
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aWm;
                    if (bVar2 != null) {
                        bVar2.f(4, this.aWo);
                    }
                }
                this.aWt = 0;
                if (str2 != null) {
                    h.h(new File(this.Yx + this.name, str2));
                }
                PI();
                Py();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.Yx + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.aVY.length;
        File file = new File(this.Yx, this.name + ".kva");
        File file2 = new File(this.Yx, this.name + ".kvb");
        try {
            if (!h.af(file) || !h.af(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j10 = length;
            randomAccessFile.setLength(j10);
            randomAccessFile2.setLength(j10);
            this.aWg = randomAccessFile.getChannel();
            this.aWh = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.aWg;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j10);
            this.aWk = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.aWh.map(mapMode, 0L, j10);
            this.aWl = map2;
            map2.order(byteOrder);
            this.aWk.put(bVar.aVY, 0, this.aWn);
            this.aWl.put(bVar.aVY, 0, this.aWn);
            return true;
        } catch (Exception e10) {
            u(e10);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        hu(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0515a) this.aWp.get(str), (byte) 7);
        }
    }

    private static void e(int i10, boolean z10) {
        if (z10) {
            if (i10 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i10 < 0 || i10 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void u(Throwable th2) {
        d dVar = this.aWf;
        if (dVar != null) {
            dVar.e(this.name, th2);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aWu && mappedByteBuffer != this.aWk) {
            mappedByteBuffer.putInt(0, this.aWn - 12);
        }
        mappedByteBuffer.putLong(4, this.aWo);
        int i10 = this.aWt;
        if (i10 != 0) {
            mappedByteBuffer.put(i10, this.aWm.aVY[i10]);
        }
        if (this.aWs != 0) {
            mappedByteBuffer.position(this.aWr);
            mappedByteBuffer.put(this.aWm.aVY, this.aWr, this.aWs);
        }
    }

    private void b(long j10, long j11, int i10) {
        long e10 = e(j11, i10) ^ this.aWo;
        this.aWo = e10;
        if (this.aWy == 0) {
            MappedByteBuffer mappedByteBuffer = this.aWk;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e10);
                this.aWk.putLong(i10, j10);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aWl;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aWo);
                this.aWl.putLong(i10, j10);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                bVar.f(4, e10);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        if (bVar2 != null) {
            bVar2.f(i10, j10);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i10) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aWl ? this.aWh : this.aWg).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aWl) {
                    this.aWl = map;
                } else {
                    this.aWk = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e10) {
                u(e10);
                PC();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i10);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b10) {
        a(str, b10, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        int i10 = bVar2.position;
        bVar2.n(bArr);
        return i10;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] ag2 = h.ag(new File(this.Yx + this.name, (String) iVar.value));
            String str = new String(ag2);
            return (ag2 == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(ag2, com.kwad.sdk.utils.a.b.hr(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e10) {
            u(e10);
        }
        return "";
    }

    private byte[] a(a.C0515a c0515a) {
        try {
            byte[] ag2 = h.ag(new File(this.Yx + this.name, (String) c0515a.value));
            return ag2 != null ? ag2 : aWa;
        } catch (Exception e10) {
            u(e10);
            return aWa;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] ag2 = h.ag(new File(this.Yx + this.name, (String) hVar.value));
            if (ag2 != null) {
                int i10 = ag2[0] & 255;
                String str = new String(ag2, 1, i10, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.aWe.get(str);
                if (bVar != null) {
                    int i11 = i10 + 1;
                    return bVar.g(ag2, i11, ag2.length - i11);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e10) {
            u(e10);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t10, b<T> bVar) {
        byte[] bArr;
        hu(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.ns.booleanValue()) {
                u(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String PM = bVar.PM();
        if (!PM.isEmpty() && PM.length() <= 50) {
            if (!this.aWe.containsKey(PM)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.ns.booleanValue()) {
                    u(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            }
            if (t10 == null) {
                remove(str);
                return;
            }
            try {
                bArr = bVar.m(t10);
            } catch (Exception e10) {
                u(e10);
                bArr = null;
            }
            if (bArr == null) {
                remove(str);
                return;
            }
            int hr = com.kwad.sdk.utils.a.b.hr(PM);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(hr + 1 + bArr.length);
            bVar2.e((byte) hr);
            bVar2.hq(PM);
            bVar2.n(bArr);
            a(str, t10, bVar2.aVY, (a.h) this.aWp.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + PM);
        if (!com.kwad.library.a.a.ns.booleanValue()) {
            u(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        try {
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
                        g(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i10 = PAGE_SIZE;
        if (capacity != i10) {
            FileChannel fileChannel = mappedByteBuffer == this.aWk ? this.aWg : this.aWh;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i10);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i10);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aWk) {
                this.aWk = map;
            } else {
                this.aWl = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b10) {
        a(str, b10, aVZ[b10]);
    }

    private void a(String str, byte b10, int i10) {
        int hr = com.kwad.sdk.utils.a.b.hr(str);
        et(hr);
        this.aWs = hr + 2 + i10;
        PH();
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar != null) {
            bVar.e(b10);
        }
        t(str, hr);
    }

    private void a(byte b10, int i10) {
        long e10 = this.aWo ^ e(1L, i10);
        this.aWo = e10;
        if (this.aWy == 0) {
            MappedByteBuffer mappedByteBuffer = this.aWk;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e10);
                this.aWk.put(i10, b10);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aWl;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aWo);
                this.aWl.put(i10, b10);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                bVar.f(4, e10);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        if (bVar2 != null) {
            bVar2.aVY[i10] = b10;
        }
    }

    private void a(int i10, long j10, int i11) {
        long e10 = e(j10, i11) ^ this.aWo;
        this.aWo = e10;
        if (this.aWy == 0) {
            MappedByteBuffer mappedByteBuffer = this.aWk;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e10);
                this.aWk.putInt(i11, i10);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aWl;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aWo);
                this.aWl.putInt(i11, i10);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                bVar.f(4, e10);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aWm;
        if (bVar2 != null) {
            bVar2.B(i11, i10);
        }
    }

    private static void a(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13;
        if (i11 <= str.length() && i11 >= 0) {
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 + 1;
                char charAt = str.charAt(i14);
                if (charAt < 128) {
                    i13 = i12 + 1;
                    bArr[i12] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i13 = i12 + 1;
                    bArr[i12] = (byte) charAt;
                }
                i14 = i15;
                i12 = i13;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int hr = com.kwad.sdk.utils.a.b.hr(str2);
        if (iVar == null) {
            int hr2 = com.kwad.sdk.utils.a.b.hr(str);
            et(hr2);
            int i10 = hr2 + 4;
            this.aWs = i10 + hr;
            PH();
            com.kwad.sdk.utils.a.b bVar = this.aWm;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            t(str, hr2);
            u(str2, hr);
            Map<String, a.b> map = this.aWp;
            int i11 = this.aWr;
            map.put(str, new a.i(i11, i11 + i10, str2, hr, false));
            PF();
        } else {
            int i12 = iVar.offset;
            int i13 = i12 - iVar.start;
            int i14 = iVar.aVV;
            boolean z10 = false;
            if (i14 == hr) {
                this.aWo ^= this.aWm.D(i12, i14);
                if (hr == str2.length()) {
                    a(str2, 0, hr, this.aWm.aVY, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aWm;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hq(str2);
                    }
                }
                this.aWr = iVar.offset;
                this.aWs = hr;
            } else {
                this.aWs = i13 + hr;
                PH();
                com.kwad.sdk.utils.a.b bVar3 = this.aWm;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i15 = i13 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.aWm;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aVY;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i15);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.aWm;
                if (bVar5 != null) {
                    bVar5.position += i15;
                }
                u(str2, hr);
                a((byte) 6, iVar.start, iVar.offset + iVar.aVV);
                r5 = iVar.aVW ? (String) iVar.value : null;
                iVar.aVW = false;
                int i16 = this.aWr;
                iVar.start = i16;
                iVar.offset = i16 + i13;
                iVar.aVV = hr;
                z10 = true;
            }
            iVar.value = str2;
            PF();
            if (z10) {
                PI();
            }
            if (r5 != null) {
                h.h(new File(this.Yx + this.name, r5));
            }
        }
        Py();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b10) {
        if (jVar == null) {
            a(str, obj, bArr, b10);
        } else if (!jVar.aVW && jVar.aVV == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Py();
    }

    private void a(String str, Object obj, byte[] bArr, byte b10) {
        Object obj2;
        int length;
        a.b hVar;
        int a10 = a(str, bArr, b10);
        if (a10 != 0) {
            String str2 = this.aWv;
            boolean z10 = str2 != null;
            if (z10) {
                this.aWv = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b10 == 6) {
                hVar = new a.i(this.aWr, a10, (String) obj2, length, z10);
            } else if (b10 == 7) {
                hVar = new a.C0515a(this.aWr, a10, obj2, length, z10);
            } else {
                hVar = new a.h(this.aWr, a10, obj2, length, z10);
            }
            this.aWp.put(str, hVar);
            PF();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a10 = a(str, bArr, jVar.Pr());
        if (a10 != 0) {
            String str2 = jVar.aVW ? (String) jVar.value : null;
            a(jVar.Pr(), jVar.start, jVar.offset + jVar.aVV);
            String str3 = this.aWv;
            boolean z10 = str3 != null;
            jVar.start = this.aWr;
            jVar.offset = a10;
            jVar.aVW = z10;
            if (z10) {
                jVar.value = str3;
                jVar.aVV = 32;
                this.aWv = null;
            } else {
                jVar.value = obj;
                jVar.aVV = bArr.length;
            }
            PF();
            PI();
            if (str2 != null) {
                h.h(new File(this.Yx + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b10) {
        this.aWv = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b10);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String PO = h.PO();
        if (h.a(new File(this.Yx + this.name, PO), bArr)) {
            this.aWv = PO;
            byte[] bArr2 = new byte[32];
            PO.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b10 | SignedBytes.f10194a));
        }
        hv("save large value failed");
        return 0;
    }

    private void a(byte b10, int i10, int i11) {
        byte[] bArr;
        F(i10, i11);
        byte b11 = (byte) (b10 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.aWm;
        if (bVar != null && (bArr = bVar.aVY) != null) {
            this.aWo = (((bArr[i10] ^ b11) & 255) << ((i10 & 7) << 3)) ^ this.aWo;
            bArr[i10] = b11;
        }
        this.aWt = i10;
    }

    private void a(int i10, int[] iArr) {
        Map<String, a.b> map = this.aWp;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i11 = bVar.offset;
            if (i11 > i10) {
                int i12 = iArr[(h.binarySearch(iArr, i11) << 1) + 1];
                bVar.offset -= i12;
                if (bVar.Pr() >= 6) {
                    ((a.j) bVar).start -= i12;
                }
            }
        }
    }
}
