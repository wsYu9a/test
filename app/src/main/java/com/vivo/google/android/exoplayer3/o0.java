package com.vivo.google.android.exoplayer3;

import android.util.Pair;
import com.vivo.google.android.exoplayer3.r0;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class o0 extends r0 {

    /* renamed from: e */
    public static final int[] f27880e = {5512, 11025, 22050, 44100};

    /* renamed from: b */
    public boolean f27881b;

    /* renamed from: c */
    public boolean f27882c;

    /* renamed from: d */
    public int f27883d;

    public o0(n0 n0Var) {
        super(n0Var);
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public boolean a(n6 n6Var) {
        Format createAudioSampleFormat;
        if (this.f27881b) {
            n6Var.e(1);
        } else {
            int l = n6Var.l();
            int i2 = (l >> 4) & 15;
            this.f27883d = i2;
            if (i2 == 2) {
                createAudioSampleFormat = Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, f27880e[(l >> 2) & 3], null, null, 0, null);
            } else if (i2 == 7 || i2 == 8) {
                createAudioSampleFormat = Format.createAudioSampleFormat(null, i2 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", null, -1, -1, 1, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, (l & 1) == 1 ? 2 : 3, null, null, 0, null);
            } else {
                if (i2 != 10) {
                    throw new r0.a("Audio format not supported: " + this.f27883d);
                }
                this.f27881b = true;
            }
            this.f27986a.a(createAudioSampleFormat);
            this.f27882c = true;
            this.f27881b = true;
        }
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public void b(n6 n6Var, long j2) {
        if (this.f27883d != 2) {
            int l = n6Var.l();
            if (l == 0 && !this.f27882c) {
                int a2 = n6Var.a();
                byte[] bArr = new byte[a2];
                System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, a2);
                n6Var.f27875b += a2;
                Pair<Integer, Integer> a3 = f6.a(bArr);
                this.f27986a.a(Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), Collections.singletonList(bArr), null, 0, null));
                this.f27882c = true;
                return;
            }
            if (this.f27883d == 10 && l != 1) {
                return;
            }
        }
        int a4 = n6Var.a();
        this.f27986a.a(n6Var, a4);
        this.f27986a.a(j2, 1, a4, 0, null);
    }
}
