package com.vivo.google.android.exoplayer3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.vivo.google.android.exoplayer3.util.Util;
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
public final class e3 {

    /* renamed from: d */
    public static final SparseIntArray f27368d;

    /* renamed from: e */
    public static final SparseIntArray f27369e;

    /* renamed from: f */
    public static final Map<String, Integer> f27370f;

    /* renamed from: a */
    public static final b3 f27365a = new b3("OMX.google.raw.decoder", null, null, false);

    /* renamed from: b */
    public static final Pattern f27366b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c */
    public static final HashMap<a, List<b3>> f27367c = new HashMap<>();

    /* renamed from: g */
    public static int f27371g = -1;

    public static final class a {

        /* renamed from: a */
        public final String f27372a;

        /* renamed from: b */
        public final boolean f27373b;

        public a(String str, boolean z) {
            this.f27372a = str;
            this.f27373b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f27372a, aVar.f27372a) && this.f27373b == aVar.f27373b;
        }

        public int hashCode() {
            String str = this.f27372a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f27373b ? 1231 : 1237);
        }
    }

    public static class b extends Exception {
        public b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface c {
        int a();

        MediaCodecInfo a(int i2);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    public static final class d implements c {
        @Override // com.vivo.google.android.exoplayer3.e3.c
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public boolean b() {
            return false;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f27368d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f27369e = sparseIntArray2;
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
        f27370f = hashMap;
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

    public static Pair<Integer, Integer> a(String str) {
        String[] split;
        int i2;
        StringBuilder sb;
        Integer valueOf;
        int parseInt;
        Integer valueOf2;
        Integer valueOf3;
        StringBuilder sb2;
        if (str == null) {
            return null;
        }
        split = str.split("\\.");
        String str2 = split[0];
        str2.hashCode();
        i2 = 2;
        switch (str2) {
            case "avc1":
            case "avc2":
                if (split.length >= 2) {
                    try {
                        if (split[1].length() != 6) {
                            if (split.length < 3) {
                                String str3 = "Ignoring malformed AVC codec string: " + str;
                                break;
                            } else {
                                valueOf = Integer.valueOf(Integer.parseInt(split[1]));
                                parseInt = Integer.parseInt(split[2]);
                            }
                        } else {
                            valueOf = Integer.valueOf(Integer.parseInt(split[1].substring(0, 2), 16));
                            parseInt = Integer.parseInt(split[1].substring(4), 16);
                        }
                        valueOf2 = Integer.valueOf(parseInt);
                        valueOf3 = Integer.valueOf(f27368d.get(valueOf.intValue()));
                    } catch (NumberFormatException unused) {
                        sb = new StringBuilder();
                    }
                    if (valueOf3 != null) {
                        Integer valueOf4 = Integer.valueOf(f27369e.get(valueOf2.intValue()));
                        if (valueOf4 != null) {
                            break;
                        } else {
                            sb = new StringBuilder();
                            sb.append("Unknown AVC level: ");
                            sb.append(valueOf2);
                            sb.toString();
                            break;
                        }
                    } else {
                        String str4 = "Unknown AVC profile: " + valueOf;
                        break;
                    }
                } else {
                    sb = new StringBuilder();
                }
                sb.append("Ignoring malformed AVC codec string: ");
                sb.append(str);
                sb.toString();
            case "hev1":
            case "hvc1":
                if (split.length >= 4) {
                    Matcher matcher = f27366b.matcher(split[1]);
                    if (matcher.matches()) {
                        str = matcher.group(1);
                        if (!"1".equals(str)) {
                            if (!"2".equals(str)) {
                                sb2 = new StringBuilder();
                                sb2.append("Unknown HEVC profile string: ");
                                sb2.append(str);
                                sb2.toString();
                                break;
                            }
                        } else {
                            i2 = 1;
                        }
                        Integer num = f27370f.get(split[3]);
                        if (num != null) {
                            break;
                        } else {
                            String str5 = "Unknown HEVC level string: " + matcher.group(1);
                            break;
                        }
                    } else {
                        sb2 = new StringBuilder();
                    }
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append("Ignoring malformed HEVC codec string: ");
                sb2.append(str);
                sb2.toString();
        }
        return null;
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = Util.SDK_INT;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i2 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(Util.DEVICE)) {
            return false;
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str2 = Util.DEVICE;
            if ("dlxu".equals(str2) || "protou".equals(str2) || "ville".equals(str2) || "villeplus".equals(str2) || "villec2".equals(str2) || str2.startsWith("gee") || "C6602".equals(str2) || "C6603".equals(str2) || "C6606".equals(str2) || "C6616".equals(str2) || "L36h".equals(str2) || "SO-02E".equals(str2)) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str3 = Util.DEVICE;
            if ("C1504".equals(str3) || "C1505".equals(str3) || "C1604".equals(str3) || "C1605".equals(str3)) {
                return false;
            }
        }
        if (i2 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER)) {
            String str4 = Util.DEVICE;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        return (i2 <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
    }

    @TargetApi(21)
    public static final class e implements c {

        /* renamed from: a */
        public final int f27374a;

        /* renamed from: b */
        public MediaCodecInfo[] f27375b;

        public e(boolean z) {
            this.f27374a = z ? 1 : 0;
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public int a() {
            if (this.f27375b == null) {
                this.f27375b = new MediaCodecList(this.f27374a).getCodecInfos();
            }
            return this.f27375b.length;
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public boolean b() {
            return true;
        }

        @Override // com.vivo.google.android.exoplayer3.e3.c
        public MediaCodecInfo a(int i2) {
            if (this.f27375b == null) {
                this.f27375b = new MediaCodecList(this.f27374a).getCodecInfos();
            }
            return this.f27375b[i2];
        }
    }

    public static synchronized List<b3> a(String str, boolean z) {
        synchronized (e3.class) {
            a aVar = new a(str, z);
            List<b3> list = f27367c.get(aVar);
            if (list != null) {
                return list;
            }
            int i2 = Util.SDK_INT;
            List<b3> a2 = a(aVar, i2 >= 21 ? new e(z) : new d());
            if (z && ((ArrayList) a2).isEmpty() && 21 <= i2 && i2 <= 23) {
                a2 = a(aVar, new d());
                ArrayList arrayList = (ArrayList) a2;
                if (!arrayList.isEmpty()) {
                    String str2 = "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((b3) arrayList.get(0)).f27211a;
                }
            }
            if (i2 < 26) {
                int i3 = 1;
                if (a2.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(a2.get(0).f27211a)) {
                    while (true) {
                        if (i3 >= a2.size()) {
                            break;
                        }
                        b3 b3Var = a2.get(i3);
                        if ("OMX.google.raw.decoder".equals(b3Var.f27211a)) {
                            a2.remove(i3);
                            a2.add(0, b3Var);
                            break;
                        }
                        i3++;
                    }
                }
            }
            List<b3> unmodifiableList = Collections.unmodifiableList(a2);
            f27367c.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static List<b3> a(a aVar, c cVar) {
        boolean z;
        c cVar2 = cVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str = aVar.f27372a;
            int a2 = cVar.a();
            boolean b2 = cVar.b();
            int i2 = 0;
            while (i2 < a2) {
                MediaCodecInfo a3 = cVar2.a(i2);
                String name = a3.getName();
                if (a(a3, name, b2)) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str2 = supportedTypes[i3];
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str2);
                                boolean a4 = cVar2.a(str, capabilitiesForType);
                                if (Util.SDK_INT <= 22) {
                                    String str3 = Util.MODEL;
                                    if ((str3.equals("ODROID-XU3") || str3.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                        z = true;
                                        if ((!b2 && aVar.f27373b == a4) || (!b2 && !aVar.f27373b)) {
                                            arrayList.add(new b3(name, str, capabilitiesForType, z));
                                        } else if (!b2 && a4) {
                                            arrayList.add(new b3(name + ".secure", str, capabilitiesForType, z));
                                            return arrayList;
                                        }
                                    }
                                }
                                z = false;
                                if (!b2) {
                                }
                                if (!b2) {
                                    arrayList.add(new b3(name + ".secure", str, capabilitiesForType, z));
                                    return arrayList;
                                }
                                continue;
                            } catch (Exception e2) {
                                if (Util.SDK_INT > 23 || arrayList.isEmpty()) {
                                    String str4 = "Failed to query codec " + name + " (" + str2 + ")";
                                    throw e2;
                                }
                                String str5 = "Skipping codec " + name + " (failed to query capabilities)";
                            }
                        }
                        i3++;
                        cVar2 = cVar;
                    }
                }
                i2++;
                cVar2 = cVar;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    public static int a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i2;
        if (f27371g == -1) {
            int i3 = 0;
            List<b3> a2 = a("video/avc", false);
            b3 b3Var = a2.isEmpty() ? null : a2.get(0);
            if (b3Var != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = b3Var.f27215e;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = codecProfileLevelArr[i3].level;
                    if (i5 != 1 && i5 != 2) {
                        switch (i5) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case 256:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case 1024:
                                i2 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case 8192:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    i4 = Math.max(i2, i4);
                    i3++;
                }
                i3 = Math.max(i4, Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            f27371g = i3;
        }
        return f27371g;
    }
}
