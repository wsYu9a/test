package com.vivo.google.android.exoplayer3;

import com.ss.android.download.api.constant.BaseConstants;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.w1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class v1 extends w1 {
    public static final int o = Util.getIntegerCodeForString("Opus");
    public static final byte[] p = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    public static boolean b(n6 n6Var) {
        int a2 = n6Var.a();
        byte[] bArr = p;
        if (a2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr2, 0, length);
        n6Var.f27875b += length;
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public long a(n6 n6Var) {
        byte[] bArr = n6Var.f27874a;
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (i3 != 1 && i3 != 2) {
            i4 = bArr[1] & Utf8.REPLACEMENT_BYTE;
        }
        int i5 = i2 >> 3;
        return a(i4 * (i5 >= 16 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << r1 : i5 >= 12 ? 10000 << (r1 & 1) : (i5 & 3) == 3 ? BaseConstants.Time.MINUTE : 10000 << r1));
    }

    public final void a(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * C.NANOS_PER_SECOND) / 48000).array());
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public boolean a(n6 n6Var, long j2, w1.a aVar) {
        if (this.n) {
            boolean z = n6Var.c() == o;
            n6Var.d(0);
            return z;
        }
        byte[] copyOf = Arrays.copyOf(n6Var.f27874a, n6Var.f27876c);
        int i2 = copyOf[9] & 255;
        int i3 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        a(arrayList, i3);
        a(arrayList, 3840);
        aVar.f28226a = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i2, 48000, arrayList, null, 0, null);
        this.n = true;
        return true;
    }
}
