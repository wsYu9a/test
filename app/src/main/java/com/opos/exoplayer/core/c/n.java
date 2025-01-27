package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* loaded from: classes4.dex */
public interface n {

    public static final class a {

        /* renamed from: a */
        public final int f18331a;

        /* renamed from: b */
        public final byte[] f18332b;

        /* renamed from: c */
        public final int f18333c;

        /* renamed from: d */
        public final int f18334d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.f18331a = i2;
            this.f18332b = bArr;
            this.f18333c = i3;
            this.f18334d = i4;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f18331a != aVar.f18331a || this.f18333c != aVar.f18333c || this.f18334d != aVar.f18334d || !Arrays.equals(this.f18332b, aVar.f18332b)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return (((((this.f18331a * 31) + Arrays.hashCode(this.f18332b)) * 31) + this.f18333c) * 31) + this.f18334d;
        }
    }

    int a(f fVar, int i2, boolean z);

    void a(long j2, int i2, int i3, int i4, a aVar);

    void a(Format format);

    void a(com.opos.exoplayer.core.i.m mVar, int i2);
}
