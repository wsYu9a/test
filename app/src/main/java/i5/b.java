package i5;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
@h
/* loaded from: classes2.dex */
public abstract class b extends c {

    /* renamed from: e */
    public static final long f26878e = 0;

    /* renamed from: b */
    public final k[] f26879b;

    public class a implements m {

        /* renamed from: a */
        public final /* synthetic */ m[] f26880a;

        public a(m[] mVarArr) {
            this.f26880a = mVarArr;
        }

        @Override // i5.m
        public <T> m h(@t T t10, Funnel<? super T> funnel) {
            for (m mVar : this.f26880a) {
                mVar.h(t10, funnel);
            }
            return this;
        }

        @Override // i5.m
        public HashCode i() {
            return b.this.b(this.f26880a);
        }

        @Override // i5.m, i5.u
        public m a(byte[] bArr) {
            for (m mVar : this.f26880a) {
                mVar.a(bArr);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m b(char c10) {
            for (m mVar : this.f26880a) {
                mVar.b(c10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m c(byte b10) {
            for (m mVar : this.f26880a) {
                mVar.c(b10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m d(CharSequence charSequence) {
            for (m mVar : this.f26880a) {
                mVar.d(charSequence);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m e(byte[] bArr, int i10, int i11) {
            for (m mVar : this.f26880a) {
                mVar.e(bArr, i10, i11);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m f(ByteBuffer byteBuffer) {
            int position = byteBuffer.position();
            for (m mVar : this.f26880a) {
                q.d(byteBuffer, position);
                mVar.f(byteBuffer);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m g(CharSequence charSequence, Charset charset) {
            for (m mVar : this.f26880a) {
                mVar.g(charSequence, charset);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putBoolean(boolean z10) {
            for (m mVar : this.f26880a) {
                mVar.putBoolean(z10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putDouble(double d10) {
            for (m mVar : this.f26880a) {
                mVar.putDouble(d10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putFloat(float f10) {
            for (m mVar : this.f26880a) {
                mVar.putFloat(f10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putInt(int i10) {
            for (m mVar : this.f26880a) {
                mVar.putInt(i10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putLong(long j10) {
            for (m mVar : this.f26880a) {
                mVar.putLong(j10);
            }
            return this;
        }

        @Override // i5.m, i5.u
        public m putShort(short s10) {
            for (m mVar : this.f26880a) {
                mVar.putShort(s10);
            }
            return this;
        }
    }

    public b(k... kVarArr) {
        for (k kVar : kVarArr) {
            b5.u.E(kVar);
        }
        this.f26879b = kVarArr;
    }

    public final m a(m[] mVarArr) {
        return new a(mVarArr);
    }

    public abstract HashCode b(m[] mVarArr);

    @Override // i5.k
    public m newHasher() {
        int length = this.f26879b.length;
        m[] mVarArr = new m[length];
        for (int i10 = 0; i10 < length; i10++) {
            mVarArr[i10] = this.f26879b[i10].newHasher();
        }
        return a(mVarArr);
    }

    @Override // i5.c, i5.k
    public m newHasher(int i10) {
        b5.u.d(i10 >= 0);
        int length = this.f26879b.length;
        m[] mVarArr = new m[length];
        for (int i11 = 0; i11 < length; i11++) {
            mVarArr[i11] = this.f26879b[i11].newHasher(i10);
        }
        return a(mVarArr);
    }
}
