package m5;

import b5.u;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@m5.a
@a5.c
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    public static final int f28375a = 4;

    /* renamed from: b */
    public static final int f28376b = 8;

    /* renamed from: c */
    public static final char f28377c = '.';

    /* renamed from: e */
    public static final b5.b f28379e = b5.b.q('.');

    /* renamed from: d */
    public static final char f28378d = ':';

    /* renamed from: f */
    public static final b5.b f28380f = b5.b.q(f28378d);

    /* renamed from: g */
    public static final Inet4Address f28381g = (Inet4Address) g(com.sigmob.sdk.videocache.h.f20606j);

    /* renamed from: h */
    public static final Inet4Address f28382h = (Inet4Address) g("0.0.0.0");

    public static final class a {

        /* renamed from: a */
        public final Inet4Address f28383a;

        /* renamed from: b */
        public final Inet4Address f28384b;

        /* renamed from: c */
        public final int f28385c;

        /* renamed from: d */
        public final int f28386d;

        public a(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i10, int i11) {
            boolean z10 = false;
            u.k(i10 >= 0 && i10 <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i10);
            if (i11 >= 0 && i11 <= 65535) {
                z10 = true;
            }
            u.k(z10, "flags '%s' is out of range (0 <= flags <= 0xffff)", i11);
            this.f28383a = (Inet4Address) com.google.common.base.a.a(inet4Address, d.f28382h);
            this.f28384b = (Inet4Address) com.google.common.base.a.a(inet4Address2, d.f28382h);
            this.f28385c = i10;
            this.f28386d = i11;
        }

        public Inet4Address a() {
            return this.f28384b;
        }

        public int b() {
            return this.f28386d;
        }

        public int c() {
            return this.f28385c;
        }

        public Inet4Address d() {
            return this.f28383a;
        }
    }

    public static boolean A(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean B(Inet6Address inet6Address) {
        byte b10;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b10 = address[15]) == 0 || b10 == 1)) ? false : true;
    }

    public static boolean C(String str) {
        return z(str) != null;
    }

    public static boolean D(Inet6Address inet6Address) {
        if (G(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean E(String str) {
        byte[] z10 = z(str);
        if (z10 == null || z10.length != 16) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 10) {
                for (int i11 = 10; i11 < 12; i11++) {
                    if (z10[i11] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (z10[i10] != 0) {
                return false;
            }
            i10++;
        }
    }

    public static boolean F(InetAddress inetAddress) {
        for (byte b10 : inetAddress.getAddress()) {
            if (b10 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean H(String str) {
        return i(str) != null;
    }

    public static short I(String str, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 <= 0 || i12 > 4) {
            throw new NumberFormatException();
        }
        int i13 = 0;
        while (i10 < i11) {
            i13 = (i13 << 4) | Character.digit(str.charAt(i10), 16);
            i10++;
        }
        return (short) i13;
    }

    public static byte J(String str, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 <= 0 || i12 > 3) {
            throw new NumberFormatException();
        }
        if (i12 > 1 && str.charAt(i10) == '0') {
            throw new NumberFormatException();
        }
        int i13 = 0;
        while (i10 < i11) {
            int i14 = i13 * 10;
            int digit = Character.digit(str.charAt(i10), 10);
            if (digit < 0) {
                throw new NumberFormatException();
            }
            i13 = i14 + digit;
            i10++;
        }
        if (i13 <= 255) {
            return (byte) i13;
        }
        throw new NumberFormatException();
    }

    @CheckForNull
    public static byte[] K(String str) {
        if (f28379e.i(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int indexOf = str.indexOf(46, i10);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                bArr[i11] = J(str, i10, indexOf);
                i10 = indexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @CheckForNull
    public static byte[] L(String str) {
        int i10 = f28380f.i(str);
        if (i10 >= 2 && i10 <= 8) {
            int i11 = 1;
            int i12 = i10 + 1;
            int i13 = 8 - i12;
            boolean z10 = false;
            for (int i14 = 0; i14 < str.length() - 1; i14++) {
                if (str.charAt(i14) == ':' && str.charAt(i14 + 1) == ':') {
                    if (z10) {
                        return null;
                    }
                    int i15 = i13 + 1;
                    if (i14 == 0) {
                        i15 = i13 + 2;
                    }
                    if (i14 == str.length() - 2) {
                        i15++;
                    }
                    i13 = i15;
                    z10 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z10 && i13 <= 0) {
                return null;
            }
            if (!z10 && i12 != 8) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i11 = 0;
                }
                while (i11 < str.length()) {
                    int indexOf = str.indexOf(58, i11);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    if (str.charAt(i11) == ':') {
                        for (int i16 = 0; i16 < i13; i16++) {
                            allocate.putShort((short) 0);
                        }
                    } else {
                        allocate.putShort(I(str, i11, indexOf));
                    }
                    i11 = indexOf + 1;
                }
                return allocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String M(InetAddress inetAddress) {
        u.E(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        u.d(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = i10 * 2;
            iArr[i10] = Ints.k((byte) 0, (byte) 0, address[i11], address[i11 + 1]);
        }
        d(iArr);
        return x(iArr);
    }

    public static BigInteger N(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String O(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return M(inetAddress);
        }
        String M = M(inetAddress);
        StringBuilder sb2 = new StringBuilder(String.valueOf(M).length() + 2);
        sb2.append("[");
        sb2.append(M);
        sb2.append("]");
        return sb2.toString();
    }

    public static InetAddress b(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static int c(InetAddress inetAddress) {
        return k5.g.h(q(inetAddress).getAddress()).readInt();
    }

    public static void d(int[] iArr) {
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < iArr.length + 1; i13++) {
            if (i13 >= iArr.length || iArr[i13] != 0) {
                if (i12 >= 0) {
                    int i14 = i13 - i12;
                    if (i14 > i10) {
                        i11 = i12;
                        i10 = i14;
                    }
                    i12 = -1;
                }
            } else if (i12 < 0) {
                i12 = i13;
            }
        }
        if (i10 >= 2) {
            Arrays.fill(iArr, i11, i10 + i11, -1);
        }
    }

    @CheckForNull
    public static String e(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] K = K(str.substring(lastIndexOf));
        if (K == null) {
            return null;
        }
        String hexString = Integer.toHexString(((K[0] & 255) << 8) | (K[1] & 255));
        String hexString2 = Integer.toHexString((K[3] & 255) | ((K[2] & 255) << 8));
        StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 1 + String.valueOf(hexString).length() + String.valueOf(hexString2).length());
        sb2.append(substring);
        sb2.append(hexString);
        sb2.append(":");
        sb2.append(hexString2);
        return sb2.toString();
    }

    public static InetAddress f(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        u.u(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    @CanIgnoreReturnValue
    public static InetAddress g(String str) {
        byte[] z10 = z(str);
        if (z10 != null) {
            return b(z10);
        }
        throw j("'%s' is not an IP string literal.", str);
    }

    public static InetAddress h(String str) {
        InetAddress i10 = i(str);
        if (i10 != null) {
            return i10;
        }
        throw j("Not a valid URI IP literal: '%s'", str);
    }

    @CheckForNull
    public static InetAddress i(String str) {
        int i10;
        u.E(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i10 = 16;
        } else {
            i10 = 4;
        }
        byte[] z10 = z(str);
        if (z10 == null || z10.length != i10) {
            return null;
        }
        return b(z10);
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static InetAddress k(BigInteger bigInteger, boolean z10) {
        u.e(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i10 = z10 ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i10];
        int max = Math.max(0, byteArray.length - i10);
        int length = byteArray.length - max;
        int i11 = i10 - length;
        for (int i12 = 0; i12 < max; i12++) {
            if (byteArray[i12] != 0) {
                throw j("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i10), bigInteger);
            }
        }
        System.arraycopy(byteArray, max, bArr, i11, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e10) {
            throw new AssertionError(e10);
        }
    }

    public static Inet4Address l(BigInteger bigInteger) {
        return (Inet4Address) k(bigInteger, false);
    }

    public static Inet6Address m(BigInteger bigInteger) {
        return (Inet6Address) k(bigInteger, true);
    }

    public static Inet4Address n(int i10) {
        return t(Ints.C(i10));
    }

    public static InetAddress o(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = bArr[(bArr.length - i10) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address p(Inet6Address inet6Address) {
        u.u(A(inet6Address), "Address '%s' is not a 6to4 address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address q(InetAddress inetAddress) {
        boolean z10;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i10 = 0;
        while (true) {
            if (i10 >= 15) {
                z10 = true;
                break;
            }
            if (address[i10] != 0) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10 && address[15] == 1) {
            return f28381g;
        }
        if (z10 && address[15] == 0) {
            return f28382h;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int asInt = Hashing.B().hashLong(w(inet6Address) ? s(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (asInt == -1) {
            asInt = -2;
        }
        return t(Ints.C(asInt));
    }

    public static Inet4Address r(Inet6Address inet6Address) {
        u.u(B(inet6Address), "Address '%s' is not IPv4-compatible.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address s(Inet6Address inet6Address) {
        if (B(inet6Address)) {
            return r(inet6Address);
        }
        if (A(inet6Address)) {
            return p(inet6Address);
        }
        if (G(inet6Address)) {
            return v(inet6Address).a();
        }
        throw j("'%s' has no embedded IPv4 address.", M(inet6Address));
    }

    public static Inet4Address t(byte[] bArr) {
        u.k(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) b(bArr);
    }

    public static Inet4Address u(Inet6Address inet6Address) {
        u.u(D(inet6Address), "Address '%s' is not an ISATAP address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static a v(Inet6Address inet6Address) {
        u.u(G(inet6Address), "Address '%s' is not a Teredo address.", M(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address t10 = t(Arrays.copyOfRange(address, 4, 8));
        int readShort = k5.g.i(address, 8).readShort() & UShort.MAX_VALUE;
        int i10 = 65535 & (~k5.g.i(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i11 = 0; i11 < copyOfRange.length; i11++) {
            copyOfRange[i11] = (byte) (~copyOfRange[i11]);
        }
        return new a(t10, t(copyOfRange), i10, readShort);
    }

    public static boolean w(Inet6Address inet6Address) {
        return B(inet6Address) || A(inet6Address) || G(inet6Address);
    }

    public static String x(int[] iArr) {
        StringBuilder sb2 = new StringBuilder(39);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < iArr.length) {
            boolean z11 = iArr[i10] >= 0;
            if (z11) {
                if (z10) {
                    sb2.append(f28378d);
                }
                sb2.append(Integer.toHexString(iArr[i10]));
            } else if (i10 == 0 || z10) {
                sb2.append("::");
            }
            i10++;
            z10 = z11;
        }
        return sb2.toString();
    }

    public static InetAddress y(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        u.u(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return b(address);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0032, code lost:
    
        if (r3 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:
    
        if (r2 == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0036, code lost:
    
        r9 = e(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        if (r9 != null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003d, code lost:
    
        if (r1 == (-1)) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
    
        r9 = r9.substring(0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0047, code lost:
    
        return L(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        if (r2 == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
    
        if (r1 == (-1)) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0051, code lost:
    
        return K(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0052, code lost:
    
        return null;
     */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] z(java.lang.String r9) {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r9.length()
            r5 = 0
            r6 = -1
            if (r1 >= r4) goto L31
            char r4 = r9.charAt(r1)
            r7 = 46
            r8 = 1
            if (r4 != r7) goto L17
            r2 = 1
            goto L2e
        L17:
            r7 = 58
            if (r4 != r7) goto L20
            if (r2 == 0) goto L1e
            return r5
        L1e:
            r3 = 1
            goto L2e
        L20:
            r7 = 37
            if (r4 != r7) goto L25
            goto L32
        L25:
            r7 = 16
            int r4 = java.lang.Character.digit(r4, r7)
            if (r4 != r6) goto L2e
            return r5
        L2e:
            int r1 = r1 + 1
            goto L4
        L31:
            r1 = -1
        L32:
            if (r3 == 0) goto L48
            if (r2 == 0) goto L3d
            java.lang.String r9 = e(r9)
            if (r9 != 0) goto L3d
            return r5
        L3d:
            if (r1 == r6) goto L43
            java.lang.String r9 = r9.substring(r0, r1)
        L43:
            byte[] r9 = L(r9)
            return r9
        L48:
            if (r2 == 0) goto L52
            if (r1 == r6) goto L4d
            return r5
        L4d:
            byte[] r9 = K(r9)
            return r9
        L52:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.d.z(java.lang.String):byte[]");
    }
}
