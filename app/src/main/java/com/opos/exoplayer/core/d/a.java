package com.opos.exoplayer.core.d;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.opos.exoplayer.core.i.j;
import com.opos.exoplayer.core.i.u;

@TargetApi(16)
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public final String f18335a;

    /* renamed from: b */
    public final boolean f18336b;

    /* renamed from: c */
    public final boolean f18337c;

    /* renamed from: d */
    public final boolean f18338d;

    /* renamed from: e */
    private final String f18339e;

    /* renamed from: f */
    private final MediaCodecInfo.CodecCapabilities f18340f;

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        this.f18335a = (String) com.opos.exoplayer.core.i.a.a(str);
        this.f18339e = str2;
        this.f18340f = codecCapabilities;
        boolean z3 = true;
        this.f18336b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.f18337c = codecCapabilities != null && c(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !e(codecCapabilities))) {
            z3 = false;
        }
        this.f18338d = z3;
    }

    private static int a(String str, String str2, int i2) {
        if (i2 > 1) {
            return i2;
        }
        if ((u.f19078a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2)) {
            return i2;
        }
        int i3 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        com.opos.cmn.an.f.a.c("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]");
        return i3;
    }

    public static a a(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f19078a >= 19 && b(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        return (d2 == -1.0d || d2 <= 0.0d) ? videoCapabilities.isSizeSupported(i2, i3) : videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private void c(String str) {
        com.opos.cmn.an.f.a.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f18335a + ", " + this.f18339e + "] [" + u.f19082e + "]");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f19078a >= 21 && d(codecCapabilities);
    }

    private void d(String str) {
        com.opos.cmn.an.f.a.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f18335a + ", " + this.f18339e + "] [" + u.f19082e + "]");
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.f19078a >= 21 && f(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    public Point a(int i2, int i3) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f18340f;
        if (codecCapabilities == null) {
            str = "align.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                return new Point(widthAlignment * u.a(i2, widthAlignment), heightAlignment * u.a(i3, heightAlignment));
            }
            str = "align.vCaps";
        }
        c(str);
        return null;
    }

    @TargetApi(21)
    public boolean a(int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f18340f;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else {
                if (audioCapabilities.isSampleRateSupported(i2)) {
                    return true;
                }
                str = "sampleRate.support, " + i2;
            }
        }
        c(str);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i2, int i3, double d2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f18340f;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                if (!a(videoCapabilities, i2, i3, d2)) {
                    if (i2 >= i3 || !a(videoCapabilities, i3, i2, d2)) {
                        str = "sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2;
                    } else {
                        d("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2);
                    }
                }
                return true;
            }
            str = "sizeAndRate.vCaps";
        }
        c(str);
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f18340f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public boolean b(int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f18340f;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else {
                if (a(this.f18335a, this.f18339e, audioCapabilities.getMaxInputChannelCount()) >= i2) {
                    return true;
                }
                str = "channelCount.support, " + i2;
            }
        }
        c(str);
        return false;
    }

    public boolean b(String str) {
        String d2;
        StringBuilder sb;
        String str2;
        if (str != null && this.f18339e != null && (d2 = j.d(str)) != null) {
            if (this.f18339e.equals(d2)) {
                Pair<Integer, Integer> a2 = d.a(str);
                if (a2 != null) {
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                        if (codecProfileLevel.profile != ((Integer) a2.first).intValue() || codecProfileLevel.level < ((Integer) a2.second).intValue()) {
                        }
                    }
                    sb = new StringBuilder();
                    str2 = "codec.profileLevel, ";
                }
            } else {
                sb = new StringBuilder();
                str2 = "codec.mime ";
            }
            sb.append(str2);
            sb.append(str);
            sb.append(", ");
            sb.append(d2);
            c(sb.toString());
            return false;
        }
        return true;
    }
}
