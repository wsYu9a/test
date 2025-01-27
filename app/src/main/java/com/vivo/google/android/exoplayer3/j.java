package com.vivo.google.android.exoplayer3;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes4.dex */
public final class j {

    /* renamed from: c */
    public static final j f27517c = new j(new int[]{2}, 2);

    /* renamed from: a */
    public final int[] f27518a;

    /* renamed from: b */
    public final int f27519b;

    public j(int[] iArr, int i2) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f27518a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f27518a = new int[0];
        }
        this.f27519b = i2;
    }

    public static j a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        return (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f27517c : new j(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Arrays.equals(this.f27518a, jVar.f27518a) && this.f27519b == jVar.f27519b;
    }

    public int hashCode() {
        return this.f27519b + (Arrays.hashCode(this.f27518a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f27519b + ", supportedEncodings=" + Arrays.toString(this.f27518a) + "]";
    }
}
