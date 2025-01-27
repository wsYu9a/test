package com.opos.exoplayer.core.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: d */
    private static final SparseIntArray f18359d;

    /* renamed from: e */
    private static final SparseIntArray f18360e;

    /* renamed from: f */
    private static final Map<String, Integer> f18361f;

    /* renamed from: a */
    private static final com.opos.exoplayer.core.d.a f18356a = com.opos.exoplayer.core.d.a.a("OMX.google.raw.decoder");

    /* renamed from: b */
    private static final Pattern f18357b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c */
    private static final HashMap<b, List<com.opos.exoplayer.core.d.a>> f18358c = new HashMap<>();

    /* renamed from: g */
    private static int f18362g = -1;

    public static class a extends Exception {
        private a(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }

        /* synthetic */ a(Throwable th, AnonymousClass1 anonymousClass1) {
            this(th);
        }
    }

    private static final class b {

        /* renamed from: a */
        public final String f18363a;

        /* renamed from: b */
        public final boolean f18364b;

        public b(String str, boolean z) {
            this.f18363a = str;
            this.f18364b = z;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || obj.getClass() != b.class) {
                    return false;
                }
                b bVar = (b) obj;
                if (!TextUtils.equals(this.f18363a, bVar.f18363a) || this.f18364b != bVar.f18364b) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            String str = this.f18363a;
            return (this.f18364b ? 1231 : 1237) + (((str == null ? 0 : str.hashCode()) + 31) * 31);
        }
    }

    private interface c {
        int a();

        MediaCodecInfo a(int i2);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* renamed from: com.opos.exoplayer.core.d.d$d */
    private static final class C0405d implements c {
        private C0405d() {
        }

        /* synthetic */ C0405d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean b() {
            return false;
        }
    }

    @TargetApi(21)
    private static final class e implements c {

        /* renamed from: a */
        private final int f18365a;

        /* renamed from: b */
        private MediaCodecInfo[] f18366b;

        public e(boolean z) {
            this.f18365a = z ? 1 : 0;
        }

        private void c() {
            if (this.f18366b == null) {
                this.f18366b = new MediaCodecList(this.f18365a).getCodecInfos();
            }
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public int a() {
            c();
            return this.f18366b.length;
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public MediaCodecInfo a(int i2) {
            c();
            return this.f18366b[i2];
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.opos.exoplayer.core.d.d.c
        public boolean b() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f18359d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f18360e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f18361f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    private static int a(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r2.equals("hev1") != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r7) {
        /*
            if (r7 != 0) goto L3
            goto L47
        L3:
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r7.split(r0)
            r1 = 0
            r2 = r0[r1]
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case 3006243: goto L34;
                case 3006244: goto L2a;
                case 3199032: goto L21;
                case 3214780: goto L17;
                default: goto L16;
            }
        L16:
            goto L3e
        L17:
            java.lang.String r1 = "hvc1"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L3e
            r1 = 1
            goto L3f
        L21:
            java.lang.String r3 = "hev1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L3e
            goto L3f
        L2a:
            java.lang.String r1 = "avc2"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L3e
            r1 = 3
            goto L3f
        L34:
            java.lang.String r1 = "avc1"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L3e
            r1 = 2
            goto L3f
        L3e:
            r1 = -1
        L3f:
            if (r1 == 0) goto L4e
            if (r1 == r6) goto L4e
            if (r1 == r5) goto L49
            if (r1 == r4) goto L49
        L47:
            r7 = 0
            goto L52
        L49:
            android.util.Pair r7 = b(r7, r0)
            goto L52
        L4e:
            android.util.Pair r7 = a(r7, r0)
        L52:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.d.a(java.lang.String):android.util.Pair");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        StringBuilder sb;
        int i2;
        String str2;
        if (strArr.length < 4) {
            sb = new StringBuilder();
        } else {
            Matcher matcher = f18357b.matcher(strArr[1]);
            if (matcher.matches()) {
                str = matcher.group(1);
                if ("1".equals(str)) {
                    i2 = 1;
                } else {
                    if (!"2".equals(str)) {
                        sb = new StringBuilder();
                        sb.append("Unknown HEVC profile string: ");
                        sb.append(str);
                        str2 = sb.toString();
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                        return null;
                    }
                    i2 = 2;
                }
                Integer num = f18361f.get(strArr[3]);
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i2), num);
                }
                str2 = "Unknown HEVC level string: " + matcher.group(1);
                com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append("Ignoring malformed HEVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
        return null;
    }

    public static com.opos.exoplayer.core.d.a a() {
        return f18356a;
    }

    @Nullable
    public static com.opos.exoplayer.core.d.a a(String str, boolean z) {
        List<com.opos.exoplayer.core.d.a> b2 = b(str, z);
        if (b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    private static ArrayList<com.opos.exoplayer.core.d.a> a(b bVar, c cVar, String str) {
        int i2;
        c cVar2 = cVar;
        try {
            ArrayList<com.opos.exoplayer.core.d.a> arrayList = new ArrayList<>();
            String str2 = bVar.f18363a;
            int a2 = cVar.a();
            boolean b2 = cVar.b();
            int i3 = 0;
            loop0: while (i3 < a2) {
                MediaCodecInfo a3 = cVar2.a(i3);
                String name = a3.getName();
                if (a(a3, name, b2, str)) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i4 = 0;
                    while (i4 < length) {
                        String str3 = supportedTypes[i4];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str3);
                                boolean a4 = cVar2.a(str2, capabilitiesForType);
                                boolean b3 = b(name);
                                if (b2) {
                                    i2 = a2;
                                    try {
                                        if (bVar.f18364b != a4) {
                                        }
                                        arrayList.add(com.opos.exoplayer.core.d.a.a(name, str2, capabilitiesForType, b3, false));
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (u.f19078a > 23 || arrayList.isEmpty()) {
                                            com.opos.cmn.an.f.a.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e;
                                        }
                                        com.opos.cmn.an.f.a.d("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                        i4++;
                                        cVar2 = cVar;
                                        a2 = i2;
                                    }
                                } else {
                                    i2 = a2;
                                }
                                if (!b2 && !bVar.f18364b) {
                                    arrayList.add(com.opos.exoplayer.core.d.a.a(name, str2, capabilitiesForType, b3, false));
                                } else if (!b2 && a4) {
                                    arrayList.add(com.opos.exoplayer.core.d.a.a(name + ".secure", str2, capabilitiesForType, b3, true));
                                    break loop0;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                i2 = a2;
                            }
                        } else {
                            i2 = a2;
                        }
                        i4++;
                        cVar2 = cVar;
                        a2 = i2;
                    }
                }
                i3++;
                cVar2 = cVar;
                a2 = a2;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new a(e4);
        }
    }

    private static void a(List<com.opos.exoplayer.core.d.a> list) {
        if (u.f19078a < 26) {
            if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f18335a)) {
                return;
            }
            for (int i2 = 1; i2 < list.size(); i2++) {
                com.opos.exoplayer.core.d.a aVar = list.get(i2);
                if ("OMX.google.raw.decoder".equals(aVar.f18335a)) {
                    list.remove(i2);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b0, code lost:
    
        if (r0.startsWith("t0") == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        if (r5.startsWith("HM") == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e6, code lost:
    
        if ("SO-02E".equals(r0) == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0112, code lost:
    
        if ("C1605".equals(r5) == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0172, code lost:
    
        if (r5.equals("SCV31") == false) goto L225;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.media.MediaCodecInfo r3, java.lang.String r4, boolean r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.d.a(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):boolean");
    }

    public static int b() {
        if (f18362g == -1) {
            int i2 = 0;
            com.opos.exoplayer.core.d.a a2 = a("video/avc", false);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a3 = a2.a();
                int length = a3.length;
                int i3 = 0;
                while (i2 < length) {
                    i3 = Math.max(a(a3[i2].level), i3);
                    i2++;
                }
                i2 = Math.max(i3, u.f19078a >= 21 ? 345600 : 172800);
            }
            f18362g = i2;
        }
        return f18362g;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        StringBuilder sb;
        Integer valueOf;
        Integer num;
        Integer valueOf2;
        String str2;
        if (strArr.length >= 2) {
            try {
                if (strArr[1].length() == 6) {
                    num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                } else {
                    if (strArr.length < 3) {
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                        return null;
                    }
                    Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                    num = valueOf3;
                }
                valueOf2 = Integer.valueOf(f18359d.get(num.intValue()));
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
            if (valueOf2 == null) {
                str2 = "Unknown AVC profile: " + num;
                com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(f18360e.get(valueOf.intValue()));
            if (valueOf4 != null) {
                return new Pair<>(valueOf2, valueOf4);
            }
            sb = new StringBuilder();
            sb.append("Unknown AVC level: ");
            sb.append(valueOf);
            str2 = sb.toString();
            com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
            return null;
        }
        sb = new StringBuilder();
        sb.append("Ignoring malformed AVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        com.opos.cmn.an.f.a.c("MediaCodecUtil", str2);
        return null;
    }

    public static List<com.opos.exoplayer.core.d.a> b(String str, boolean z) {
        List<com.opos.exoplayer.core.d.a> list;
        synchronized (d.class) {
            b bVar = new b(str, z);
            HashMap<b, List<com.opos.exoplayer.core.d.a>> hashMap = f18358c;
            list = hashMap.get(bVar);
            if (list == null) {
                int i2 = u.f19078a;
                c eVar = i2 >= 21 ? new e(z) : new C0405d();
                ArrayList<com.opos.exoplayer.core.d.a> a2 = a(bVar, eVar, str);
                if (z && a2.isEmpty() && 21 <= i2 && i2 <= 23) {
                    eVar = new C0405d();
                    a2 = a(bVar, eVar, str);
                    if (!a2.isEmpty()) {
                        com.opos.cmn.an.f.a.c("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a2.get(0).f18335a);
                    }
                }
                if ("audio/eac3-joc".equals(str)) {
                    a2.addAll(a(new b("audio/eac3", bVar.f18364b), eVar, str));
                }
                a(a2);
                list = Collections.unmodifiableList(a2);
                hashMap.put(bVar, list);
            }
        }
        return list;
    }

    private static boolean b(String str) {
        if (u.f19078a <= 22) {
            String str2 = u.f19081d;
            if ((str2.equals("ODROID-XU3") || str2.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }
}
