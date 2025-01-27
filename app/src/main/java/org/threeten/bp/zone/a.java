package org.threeten.bp.zone;

import hj.d;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public final class a extends jj.b {

    /* renamed from: c */
    public List<String> f29637c;

    /* renamed from: d */
    public final ConcurrentNavigableMap<String, C0761a> f29638d = new ConcurrentSkipListMap();

    /* renamed from: e */
    public Set<String> f29639e = new CopyOnWriteArraySet();

    /* renamed from: org.threeten.bp.zone.a$a */
    public static class C0761a {

        /* renamed from: a */
        public final String f29640a;

        /* renamed from: b */
        public final String[] f29641b;

        /* renamed from: c */
        public final short[] f29642c;

        /* renamed from: d */
        public final AtomicReferenceArray<Object> f29643d;

        public C0761a(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.f29643d = atomicReferenceArray;
            this.f29640a = str;
            this.f29641b = strArr;
            this.f29642c = sArr;
        }

        public ZoneRules b(short s10) throws Exception {
            Object obj = this.f29643d.get(s10);
            if (obj instanceof byte[]) {
                obj = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                this.f29643d.set(s10, obj);
            }
            return (ZoneRules) obj;
        }

        public ZoneRules c(String str) {
            int binarySearch = Arrays.binarySearch(this.f29641b, str);
            if (binarySearch < 0) {
                return null;
            }
            try {
                return b(this.f29642c[binarySearch]);
            } catch (Exception e10) {
                throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + str + ", version: " + this.f29640a, e10);
            }
        }

        public String toString() {
            return this.f29640a;
        }
    }

    public a() {
        if (!m(jj.b.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    @Override // jj.b
    public ZoneRules f(String str, boolean z10) {
        d.j(str, "zoneId");
        ZoneRules c10 = this.f29638d.lastEntry().getValue().c(str);
        if (c10 != null) {
            return c10;
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    @Override // jj.b
    public NavigableMap<String, ZoneRules> g(String str) {
        TreeMap treeMap = new TreeMap();
        for (C0761a c0761a : this.f29638d.values()) {
            ZoneRules c10 = c0761a.c(str);
            if (c10 != null) {
                treeMap.put(c0761a.f29640a, c10);
            }
        }
        return treeMap;
    }

    @Override // jj.b
    public Set<String> h() {
        return new HashSet(this.f29637c);
    }

    public final boolean l(InputStream inputStream) throws IOException, StreamCorruptedException {
        boolean z10 = false;
        for (C0761a c0761a : o(inputStream)) {
            C0761a putIfAbsent = this.f29638d.putIfAbsent(c0761a.f29640a, c0761a);
            if (putIfAbsent != null && !putIfAbsent.f29640a.equals(c0761a.f29640a)) {
                throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + c0761a.f29640a);
            }
            z10 = true;
        }
        return z10;
    }

    public final boolean m(ClassLoader classLoader) {
        URL url = null;
        try {
            Enumeration<URL> resources = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean z10 = false;
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                try {
                    z10 |= n(nextElement);
                    url = nextElement;
                } catch (Exception e10) {
                    e = e10;
                    url = nextElement;
                    throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e);
                }
            }
            return z10;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final boolean n(URL url) throws ClassNotFoundException, IOException, ZoneRulesException {
        InputStream inputStream;
        if (!this.f29639e.add(url.toExternalForm())) {
            return false;
        }
        try {
            inputStream = url.openStream();
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            boolean l10 = l(inputStream);
            if (inputStream == null) {
                return l10;
            }
            inputStream.close();
            return l10;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public final Iterable<C0761a> o(InputStream inputStream) throws IOException, StreamCorruptedException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if (!"TZDB".equals(dataInputStream.readUTF())) {
            throw new StreamCorruptedException("File format not recognised");
        }
        int readShort = dataInputStream.readShort();
        String[] strArr = new String[readShort];
        for (int i10 = 0; i10 < readShort; i10++) {
            strArr[i10] = dataInputStream.readUTF();
        }
        int readShort2 = dataInputStream.readShort();
        String[] strArr2 = new String[readShort2];
        for (int i11 = 0; i11 < readShort2; i11++) {
            strArr2[i11] = dataInputStream.readUTF();
        }
        this.f29637c = Arrays.asList(strArr2);
        int readShort3 = dataInputStream.readShort();
        Object[] objArr = new Object[readShort3];
        for (int i12 = 0; i12 < readShort3; i12++) {
            byte[] bArr = new byte[dataInputStream.readShort()];
            dataInputStream.readFully(bArr);
            objArr[i12] = bArr;
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
        HashSet hashSet = new HashSet(readShort);
        for (int i13 = 0; i13 < readShort; i13++) {
            int readShort4 = dataInputStream.readShort();
            String[] strArr3 = new String[readShort4];
            short[] sArr = new short[readShort4];
            for (int i14 = 0; i14 < readShort4; i14++) {
                strArr3[i14] = strArr2[dataInputStream.readShort()];
                sArr[i14] = dataInputStream.readShort();
            }
            hashSet.add(new C0761a(strArr[i13], strArr3, sArr, atomicReferenceArray));
        }
        return hashSet;
    }

    public String toString() {
        return "TZDB";
    }

    public a(URL url) {
        try {
            if (n(url)) {
                return;
            }
            throw new ZoneRulesException("No time-zone rules found: " + url);
        } catch (Exception e10) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e10);
        }
    }

    public a(InputStream inputStream) {
        try {
            l(inputStream);
        } catch (Exception e10) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e10);
        }
    }
}
