package i5;

import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@Immutable
@h
/* loaded from: classes2.dex */
public final class s extends c {

    /* renamed from: b */
    public final Mac f26908b;

    /* renamed from: e */
    public final Key f26909e;

    /* renamed from: f */
    public final String f26910f;

    /* renamed from: g */
    public final int f26911g;

    /* renamed from: h */
    public final boolean f26912h;

    public static final class b extends i5.a {

        /* renamed from: b */
        public final Mac f26913b;

        /* renamed from: c */
        public boolean f26914c;

        public /* synthetic */ b(Mac mac, a aVar) {
            this(mac);
        }

        @Override // i5.m
        public HashCode i() {
            j();
            this.f26914c = true;
            return HashCode.fromBytesNoCopy(this.f26913b.doFinal());
        }

        public final void j() {
            b5.u.h0(!this.f26914c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // i5.a
        public void update(byte b10) {
            j();
            this.f26913b.update(b10);
        }

        public b(Mac mac) {
            this.f26913b = mac;
        }

        @Override // i5.a
        public void update(byte[] bArr) {
            j();
            this.f26913b.update(bArr);
        }

        @Override // i5.a
        public void update(byte[] bArr, int i10, int i11) {
            j();
            this.f26913b.update(bArr, i10, i11);
        }

        @Override // i5.a
        public void update(ByteBuffer byteBuffer) {
            j();
            b5.u.E(byteBuffer);
            this.f26913b.update(byteBuffer);
        }
    }

    public s(String str, Key key, String str2) {
        Mac a10 = a(str, key);
        this.f26908b = a10;
        this.f26909e = (Key) b5.u.E(key);
        this.f26910f = (String) b5.u.E(str2);
        this.f26911g = a10.getMacLength() * 8;
        this.f26912h = b(a10);
    }

    public static Mac a(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static boolean b(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // i5.k
    public int bits() {
        return this.f26911g;
    }

    @Override // i5.k
    public m newHasher() {
        if (this.f26912h) {
            try {
                return new b((Mac) this.f26908b.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.f26908b.getAlgorithm(), this.f26909e));
    }

    public String toString() {
        return this.f26910f;
    }
}
