package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.ss.android.download.api.constant.BaseConstants;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* loaded from: classes4.dex */
final class h extends i {

    /* renamed from: a */
    private static final int f18052a = u.f("Opus");

    /* renamed from: b */
    private static final byte[] f18053b = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: c */
    private boolean f18054c;

    h() {
    }

    private long a(byte[] bArr) {
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (i3 != 1 && i3 != 2) {
            i4 = bArr[1] & Utf8.REPLACEMENT_BYTE;
        }
        int i5 = i2 >> 3;
        return (i5 >= 16 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << r1 : i5 >= 12 ? 10000 << (r1 & 1) : (i5 & 3) == 3 ? BaseConstants.Time.MINUTE : 10000 << r1) * i4;
    }

    private void a(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * C.NANOS_PER_SECOND) / 48000).array());
    }

    public static boolean a(m mVar) {
        int b2 = mVar.b();
        byte[] bArr = f18053b;
        if (b2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        mVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.f18054c = false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j2, i.a aVar) {
        if (this.f18054c) {
            r3 = mVar.o() == f18052a;
            mVar.c(0);
        } else {
            byte[] copyOf = Arrays.copyOf(mVar.f19048a, mVar.c());
            byte b2 = copyOf[9];
            byte b3 = copyOf[11];
            byte b4 = copyOf[10];
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, ((b3 & 255) << 8) | (b4 & 255));
            a(arrayList, 3840);
            aVar.f18065a = Format.a(null, "audio/opus", null, -1, -1, b2 & 255, 48000, arrayList, null, 0, null);
            this.f18054c = true;
        }
        return r3;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        return b(a(mVar.f19048a));
    }
}
