package com.sigmob.sdk.base.views.gif;

import com.czhj.sdk.logger.SigmobLog;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: e */
    public static final String f18644e = "GifHeaderParser";

    /* renamed from: f */
    public static final int f18645f = 2;

    /* renamed from: g */
    public static final int f18646g = 10;

    /* renamed from: h */
    public static final int f18647h = 256;

    /* renamed from: a */
    public final byte[] f18648a = new byte[256];

    /* renamed from: b */
    public int f18649b = 0;

    /* renamed from: c */
    public c f18650c;

    /* renamed from: d */
    public ByteBuffer f18651d;

    public void a() {
        this.f18651d = null;
        this.f18650c = null;
    }

    public final boolean b() {
        return this.f18650c.f18642l != 0;
    }

    public boolean c() {
        j();
        if (!b()) {
            b(2);
        }
        return this.f18650c.f18634d > 1;
    }

    public c d() {
        if (this.f18651d == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f18650c;
        }
        j();
        if (!b()) {
            h();
            c cVar = this.f18650c;
            if (cVar.f18634d < 0) {
                cVar.f18642l = 1;
            }
        }
        return this.f18650c;
    }

    public final int e() {
        try {
            return this.f18651d.get() & 255;
        } catch (Exception unused) {
            this.f18650c.f18642l = 1;
            return 0;
        }
    }

    public final void f() {
        this.f18650c.f18633c.f18624e = m();
        this.f18650c.f18633c.f18625f = m();
        this.f18650c.f18633c.f18626g = m();
        this.f18650c.f18633c.f18627h = m();
        int e10 = e();
        boolean z10 = (e10 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (e10 & 7) + 1);
        b bVar = this.f18650c.f18633c;
        bVar.f18623d = (e10 & 64) != 0;
        if (z10) {
            bVar.f18628i = a(pow);
        } else {
            bVar.f18628i = null;
        }
        this.f18650c.f18633c.f18620a = this.f18651d.position();
        p();
        if (b()) {
            return;
        }
        c cVar = this.f18650c;
        cVar.f18634d++;
        cVar.f18635e.add(cVar.f18633c);
    }

    public final int g() {
        int e10 = e();
        this.f18649b = e10;
        int i10 = 0;
        if (e10 > 0) {
            while (true) {
                try {
                    int i11 = this.f18649b;
                    if (i10 >= i11) {
                        break;
                    }
                    int i12 = i11 - i10;
                    this.f18651d.get(this.f18648a, i10, i12);
                    i10 += i12;
                } catch (Exception unused) {
                    this.f18650c.f18642l = 1;
                }
            }
        }
        return i10;
    }

    public final void h() {
        b(Integer.MAX_VALUE);
    }

    public final void i() {
        e();
        int e10 = e();
        b bVar = this.f18650c.f18633c;
        int i10 = (e10 & 28) >> 2;
        bVar.f18622c = i10;
        if (i10 == 0) {
            bVar.f18622c = 1;
        }
        bVar.f18630k = (e10 & 1) != 0;
        int m10 = m();
        if (m10 < 2) {
            m10 = 10;
        }
        b bVar2 = this.f18650c.f18633c;
        bVar2.f18621b = m10 * 10;
        bVar2.f18629j = e();
        e();
    }

    public final void j() {
        String str = "";
        for (int i10 = 0; i10 < 6; i10++) {
            str = str + ((char) e());
        }
        if (!str.startsWith("GIF")) {
            this.f18650c.f18642l = 1;
            return;
        }
        k();
        if (!this.f18650c.f18637g || b()) {
            return;
        }
        c cVar = this.f18650c;
        cVar.f18636f = a(cVar.f18638h);
        c cVar2 = this.f18650c;
        cVar2.f18631a = cVar2.f18636f[cVar2.f18632b];
    }

    public final void k() {
        this.f18650c.f18643m = m();
        this.f18650c.f18639i = m();
        int e10 = e();
        c cVar = this.f18650c;
        cVar.f18637g = (e10 & 128) != 0;
        cVar.f18638h = 2 << (e10 & 7);
        cVar.f18632b = e();
        this.f18650c.f18641k = e();
    }

    public final void l() {
        do {
            g();
            byte[] bArr = this.f18648a;
            if (bArr[0] == 1) {
                int i10 = bArr[1] & 255;
                int i11 = bArr[2] & 255;
                c cVar = this.f18650c;
                int i12 = (i11 << 8) | i10;
                cVar.f18640j = i12;
                if (i12 == 0) {
                    cVar.f18640j = -1;
                }
            }
            if (this.f18649b <= 0) {
                return;
            }
        } while (!b());
    }

    public final int m() {
        return this.f18651d.getShort();
    }

    public final void n() {
        this.f18651d = null;
        Arrays.fill(this.f18648a, (byte) 0);
        this.f18650c = new c();
        this.f18649b = 0;
    }

    public final void o() {
        int e10;
        do {
            try {
                e10 = e();
                ByteBuffer byteBuffer = this.f18651d;
                byteBuffer.position(byteBuffer.position() + e10);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (e10 > 0);
    }

    public final void p() {
        e();
        o();
    }

    public final int[] a(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f18651d.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & 255;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & 255;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & 255);
                i11 = i16;
            }
        } catch (BufferUnderflowException e10) {
            SigmobLog.d("Format Error Reading Color Table", e10);
            this.f18650c.f18642l = 1;
        }
        return iArr;
    }

    public final void b(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f18650c.f18634d <= i10) {
            int e10 = e();
            if (e10 == 33) {
                int e11 = e();
                if (e11 != 1) {
                    if (e11 == 249) {
                        this.f18650c.f18633c = new b();
                        i();
                    } else if (e11 != 254 && e11 == 255) {
                        g();
                        String str = "";
                        for (int i11 = 0; i11 < 11; i11++) {
                            str = str + ((char) this.f18648a[i11]);
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            l();
                        }
                    }
                }
                o();
            } else if (e10 == 44) {
                c cVar = this.f18650c;
                if (cVar.f18633c == null) {
                    cVar.f18633c = new b();
                }
                f();
            } else if (e10 != 59) {
                this.f18650c.f18642l = 1;
            } else {
                z10 = true;
            }
        }
    }

    public d a(ByteBuffer byteBuffer) {
        n();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f18651d = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f18651d.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d a(byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
        } else {
            this.f18651d = null;
            this.f18650c.f18642l = 2;
        }
        return this;
    }
}
