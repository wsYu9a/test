package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import com.vivo.google.android.exoplayer3.util.Util;

@TargetApi(16)
/* loaded from: classes4.dex */
public final class b3 {

    /* renamed from: a */
    public final String f27211a;

    /* renamed from: b */
    public final boolean f27212b;

    /* renamed from: c */
    public final boolean f27213c;

    /* renamed from: d */
    public final String f27214d;

    /* renamed from: e */
    public final MediaCodecInfo.CodecCapabilities f27215e;

    public b3(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z) {
        this.f27211a = (String) g1.a(str);
        this.f27214d = str2;
        this.f27215e = codecCapabilities;
        this.f27212b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.f27213c = codecCapabilities != null && b(codecCapabilities);
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        return (d2 == -1.0d || d2 <= 0.0d) ? videoCapabilities.isSizeSupported(i2, i3) : videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public final void a(String str) {
        String str2 = "NoSupport [" + str + "] [" + this.f27211a + ", " + this.f27214d + "] [" + Util.DEVICE_DEBUG_INFO + "]";
    }

    @TargetApi(21)
    public boolean a(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f27215e;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i2, i3, d2)) {
            return true;
        }
        if (i2 >= i3 || !a(videoCapabilities, i3, i2, d2)) {
            a("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
            return false;
        }
        String str = "AssumedSupport [" + ("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2) + "] [" + this.f27211a + ", " + this.f27214d + "] [" + Util.DEVICE_DEBUG_INFO + "]";
        return true;
    }
}
