package com.opos.exoplayer.core.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public static final c f17529a = new c(new int[]{2}, 2);

    /* renamed from: b */
    private final int[] f17530b;

    /* renamed from: c */
    private final int f17531c;

    c(int[] iArr, int i2) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f17530b = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f17530b = new int[0];
        }
        this.f17531c = i2;
    }

    public static c a(Context context) {
        return a(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c a(Intent intent) {
        return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f17529a : new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean a(int i2) {
        return Arrays.binarySearch(this.f17530b, i2) >= 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!Arrays.equals(this.f17530b, cVar.f17530b) || this.f17531c != cVar.f17531c) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f17531c + (Arrays.hashCode(this.f17530b) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f17531c + ", supportedEncodings=" + Arrays.toString(this.f17530b) + "]";
    }
}
