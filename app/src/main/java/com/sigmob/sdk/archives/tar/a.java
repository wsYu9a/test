package com.sigmob.sdk.archives.tar;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class a implements e, com.sigmob.sdk.archives.a {

    /* renamed from: q0 */
    public static final int f17518q0 = 31;

    /* renamed from: r0 */
    public static final int f17519r0 = 16877;

    /* renamed from: s0 */
    public static final int f17520s0 = 33188;

    /* renamed from: t0 */
    public static final int f17521t0 = 1000;
    public String Z;

    /* renamed from: a0 */
    public int f17522a0;

    /* renamed from: b0 */
    public int f17523b0;

    /* renamed from: c0 */
    public int f17524c0;

    /* renamed from: d0 */
    public long f17525d0;

    /* renamed from: e0 */
    public long f17526e0;

    /* renamed from: f0 */
    public byte f17527f0;

    /* renamed from: g0 */
    public String f17528g0;

    /* renamed from: h0 */
    public String f17529h0;

    /* renamed from: i0 */
    public String f17530i0;

    /* renamed from: j0 */
    public String f17531j0;

    /* renamed from: k0 */
    public String f17532k0;

    /* renamed from: l0 */
    public int f17533l0;

    /* renamed from: m0 */
    public int f17534m0;

    /* renamed from: n0 */
    public boolean f17535n0;

    /* renamed from: o0 */
    public long f17536o0;

    /* renamed from: p0 */
    public File f17537p0;

    public a() {
        this.f17529h0 = "ustar\u0000";
        this.f17530i0 = e.S;
        this.Z = "";
        this.f17528g0 = "";
        String property = System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.f17523b0 = 0;
        this.f17524c0 = 0;
        this.f17531j0 = property;
        this.f17532k0 = "";
        this.f17537p0 = null;
    }

    public boolean a(a aVar) {
        return d().equals(aVar.d());
    }

    @Override // com.sigmob.sdk.archives.a
    public Date b() {
        return j();
    }

    @Override // com.sigmob.sdk.archives.a
    public long c() {
        return this.f17525d0;
    }

    @Override // com.sigmob.sdk.archives.a
    public String d() {
        return this.Z.toString();
    }

    public a[] e() {
        File file = this.f17537p0;
        if (file == null || !file.isDirectory()) {
            return new a[0];
        }
        String[] list = this.f17537p0.list();
        a[] aVarArr = new a[list.length];
        for (int i10 = 0; i10 < list.length; i10++) {
            aVarArr[i10] = new a(new File(this.f17537p0, list[i10]));
        }
        return aVarArr;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public File f() {
        return this.f17537p0;
    }

    public int g() {
        return this.f17524c0;
    }

    public String h() {
        return this.f17532k0.toString();
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String i() {
        return this.f17528g0.toString();
    }

    public Date j() {
        return new Date(this.f17526e0 * 1000);
    }

    public int k() {
        return this.f17522a0;
    }

    public long l() {
        return this.f17536o0;
    }

    public int m() {
        return this.f17523b0;
    }

    public String n() {
        return this.f17531j0.toString();
    }

    public boolean o() {
        return this.f17527f0 == 52;
    }

    public boolean p() {
        return this.f17527f0 == 51;
    }

    public boolean q() {
        return this.f17535n0;
    }

    public boolean r() {
        return this.f17527f0 == 54;
    }

    public boolean s() {
        File file = this.f17537p0;
        if (file != null) {
            return file.isFile();
        }
        byte b10 = this.f17527f0;
        if (b10 == 0 || b10 == 48) {
            return true;
        }
        return !d().endsWith("/");
    }

    public boolean t() {
        return this.f17527f0 == 76 && this.Z.toString().equals(e.Y);
    }

    public boolean u() {
        return this.f17527f0 == 83;
    }

    public boolean v() {
        return this.f17527f0 == 103;
    }

    public boolean w() {
        return this.f17527f0 == 49;
    }

    public boolean x() {
        byte b10 = this.f17527f0;
        return b10 == 120 || b10 == 88;
    }

    public boolean y() {
        return this.f17527f0 == 50;
    }

    public a(File file) {
        this(file, a(file.getPath(), false));
    }

    public final int a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 257, 6);
        if (wrap.compareTo(ByteBuffer.wrap(e.T.getBytes())) == 0) {
            return 2;
        }
        return wrap.compareTo(ByteBuffer.wrap("ustar\u0000".getBytes())) == 0 ? 3 : 0;
    }

    public boolean b(a aVar) {
        return aVar.d().startsWith(d());
    }

    public void c(String str) {
        this.Z = a(str, false);
    }

    public void d(String str) {
        this.f17531j0 = str;
    }

    public a(File file, String str) {
        this();
        this.f17537p0 = file;
        this.f17528g0 = "";
        if (file.isDirectory()) {
            this.f17522a0 = f17519r0;
            this.f17527f0 = e.J;
            int length = str.length();
            if (length == 0 || str.charAt(length - 1) != '/') {
                str = str + "/";
            }
            this.Z = str;
            this.f17525d0 = 0L;
        } else {
            this.f17522a0 = f17520s0;
            this.f17527f0 = e.E;
            this.f17525d0 = file.length();
            this.Z = str;
        }
        this.f17526e0 = file.lastModified() / 1000;
        this.f17533l0 = 0;
        this.f17534m0 = 0;
    }

    @Override // com.sigmob.sdk.archives.a
    public boolean a() {
        File file = this.f17537p0;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.f17527f0 == 53) {
            return true;
        }
        return d().endsWith("/");
    }

    public void b(byte[] bArr) {
        this.Z = f.a(bArr, 0, 100);
        this.f17522a0 = (int) f.b(bArr, 100, 8);
        this.f17523b0 = (int) f.b(bArr, 108, 8);
        this.f17524c0 = (int) f.b(bArr, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, 8);
        this.f17525d0 = f.b(bArr, 124, 12);
        this.f17526e0 = f.b(bArr, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 12);
        this.f17527f0 = bArr[156];
        this.f17528g0 = f.a(bArr, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 100);
        this.f17529h0 = f.a(bArr, 257, 6);
        this.f17530i0 = f.a(bArr, e.f17568m, 2);
        this.f17531j0 = f.a(bArr, 265, 32);
        this.f17532k0 = f.a(bArr, 297, 32);
        this.f17533l0 = (int) f.b(bArr, 329, 8);
        this.f17534m0 = (int) f.b(bArr, 337, 8);
        if (a(bArr) == 2) {
            this.f17535n0 = f.a(bArr, 482);
            this.f17536o0 = f.b(bArr, 483, 12);
            return;
        }
        String a10 = f.a(bArr, 345, 155);
        if (a() && !this.Z.endsWith("/")) {
            this.Z += "/";
        }
        if (a10.length() > 0) {
            this.Z = a10 + "/" + this.Z;
        }
    }

    public void c(int i10) {
        this.f17523b0 = i10;
    }

    public a(String str) {
        this(str, false);
    }

    public static String a(String str, boolean z10) {
        int indexOf;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.indexOf("netware") > -1 && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z10 && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    public void b(String str) {
        this.f17528g0 = str;
    }

    public void c(byte[] bArr) {
        int b10 = f.b(this.f17526e0, bArr, f.b(this.f17525d0, bArr, f.c(this.f17524c0, bArr, f.c(this.f17523b0, bArr, f.c(this.f17522a0, bArr, f.a(this.Z, bArr, 0, 100), 8), 8), 8), 12), 12);
        int i10 = b10;
        int i11 = 0;
        while (i11 < 8) {
            bArr[i10] = 32;
            i11++;
            i10++;
        }
        bArr[i10] = this.f17527f0;
        for (int c10 = f.c(this.f17534m0, bArr, f.c(this.f17533l0, bArr, f.a(this.f17532k0, bArr, f.a(this.f17531j0, bArr, f.a(this.f17530i0, bArr, f.a(this.f17529h0, bArr, f.a(this.f17528g0, bArr, i10 + 1, 100), 6), 2), 32), 32), 8), 8); c10 < bArr.length; c10++) {
            bArr[c10] = 0;
        }
        f.a(f.a(bArr), bArr, b10, 8);
    }

    public a(String str, byte b10) {
        this(str);
        this.f17527f0 = b10;
        if (b10 == 76) {
            this.f17529h0 = e.T;
            this.f17530i0 = e.U;
        }
    }

    public void a(int i10) {
        this.f17524c0 = i10;
    }

    public void b(int i10) {
        this.f17522a0 = i10;
    }

    public a(String str, boolean z10) {
        this();
        String a10 = a(str, z10);
        boolean endsWith = a10.endsWith("/");
        this.f17533l0 = 0;
        this.f17534m0 = 0;
        this.Z = a10;
        this.f17522a0 = endsWith ? f17519r0 : f17520s0;
        this.f17527f0 = endsWith ? e.J : e.E;
        this.f17523b0 = 0;
        this.f17524c0 = 0;
        this.f17525d0 = 0L;
        this.f17526e0 = new Date().getTime() / 1000;
        this.f17528g0 = "";
        this.f17531j0 = "";
        this.f17532k0 = "";
        this.f17533l0 = 0;
        this.f17534m0 = 0;
    }

    public void a(String str) {
        this.f17532k0 = str;
    }

    public void b(long j10) {
        if (j10 <= e.f17565j && j10 >= 0) {
            this.f17525d0 = j10;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j10);
    }

    public a(byte[] bArr) {
        this();
        b(bArr);
    }

    public void a(int i10, int i11) {
        c(i10);
        a(i11);
    }

    public void a(long j10) {
        this.f17526e0 = j10 / 1000;
    }

    public void a(Date date) {
        this.f17526e0 = date.getTime() / 1000;
    }

    public void a(String str, String str2) {
        d(str);
        a(str2);
    }
}
