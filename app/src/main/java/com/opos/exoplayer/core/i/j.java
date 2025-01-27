package com.opos.exoplayer.core.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public final class j {
    @Nullable
    public static String a(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 != 64) {
            if (i2 != 107) {
                if (i2 == 96 || i2 == 97) {
                    return "video/mpeg2";
                }
                if (i2 == 165) {
                    return "audio/ac3";
                }
                if (i2 == 166) {
                    return "audio/eac3";
                }
                switch (i2) {
                    case 102:
                    case 103:
                    case 104:
                        break;
                    case 105:
                        break;
                    default:
                        switch (i2) {
                            case 169:
                            case 172:
                                return "audio/vnd.dts";
                            case 170:
                            case 171:
                                return "audio/vnd.dts.hd";
                            case 173:
                                return "audio/opus";
                            default:
                                return null;
                        }
                }
            }
            return "audio/mpeg";
        }
        return "audio/mp4a-latm";
    }

    public static boolean a(String str) {
        return "audio".equals(g(str));
    }

    public static boolean b(String str) {
        return "video".equals(g(str));
    }

    public static boolean c(String str) {
        return com.baidu.mobads.sdk.internal.a.f5473b.equals(g(str));
    }

    public static String d(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith("mp4a")) {
            if (trim.startsWith("mp4a.")) {
                String substring = trim.substring(5);
                if (substring.length() >= 2) {
                    try {
                        str2 = a(Integer.parseInt(u.e(substring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        }
        if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (trim.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (trim.startsWith("opus")) {
            return "audio/opus";
        }
        if (trim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        return null;
    }

    public static int e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (a(str)) {
                return 1;
            }
            if (b(str)) {
                return 2;
            }
            if (c(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                return 3;
            }
            if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
                return 4;
            }
        }
        return -1;
    }

    public static int f(String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    private static String g(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
