package org.mozilla.universalchardet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.e;
import org.mozilla.universalchardet.prober.h;
import org.mozilla.universalchardet.prober.i;
import org.mozilla.universalchardet.prober.j;
import yi.a;
import yi.b;

/* loaded from: classes4.dex */
public class UniversalDetector {

    /* renamed from: k */
    public static final float f29234k = 0.95f;

    /* renamed from: l */
    public static final float f29235l = 0.2f;

    /* renamed from: a */
    public InputState f29236a;

    /* renamed from: b */
    public boolean f29237b;

    /* renamed from: c */
    public boolean f29238c;

    /* renamed from: d */
    public boolean f29239d;

    /* renamed from: e */
    public boolean f29240e;

    /* renamed from: f */
    public byte f29241f;

    /* renamed from: g */
    public String f29242g;

    /* renamed from: h */
    public CharsetProber[] f29243h;

    /* renamed from: i */
    public CharsetProber f29244i;

    /* renamed from: j */
    public a f29245j;

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector() {
        this(null);
    }

    public static String b(File file) throws IOException {
        Path path;
        path = file.toPath();
        return d(path);
    }

    public static String c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        UniversalDetector universalDetector = new UniversalDetector(null);
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0 || universalDetector.k()) {
                break;
            }
            universalDetector.j(bArr, 0, read);
        }
        universalDetector.a();
        String g10 = universalDetector.g();
        universalDetector.l();
        return g10;
    }

    public static String d(Path path) throws IOException {
        InputStream newInputStream;
        newInputStream = Files.newInputStream(path, new OpenOption[0]);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(newInputStream);
        try {
            String c10 = c(bufferedInputStream);
            bufferedInputStream.close();
            return c10;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public static String e(byte[] bArr) {
        return f(bArr, 0);
    }

    public static String f(byte[] bArr, int i10) {
        int i11 = i10 + 3;
        if (bArr.length <= i11) {
            return null;
        }
        int i12 = bArr[i10] & 255;
        int i13 = bArr[i10 + 1] & 255;
        int i14 = bArr[i10 + 2] & 255;
        int i15 = bArr[i11] & 255;
        if (i12 == 0) {
            if (i13 == 0 && i14 == 254 && i15 == 255) {
                return b.f33527x;
            }
            if (i13 == 0 && i14 == 255 && i15 == 254) {
                return b.D;
            }
            return null;
        }
        if (i12 == 239) {
            if (i13 == 187 && i14 == 191) {
                return b.f33524u;
            }
            return null;
        }
        if (i12 == 254) {
            if (i13 == 255 && i14 == 0 && i15 == 0) {
                return b.C;
            }
            if (i13 == 255) {
                return b.f33525v;
            }
            return null;
        }
        if (i12 != 255) {
            return null;
        }
        if (i13 == 254 && i14 == 0 && i15 == 0) {
            return b.f33528y;
        }
        if (i13 == 254) {
            return b.f33526w;
        }
        return null;
    }

    public void a() {
        CharsetProber[] charsetProberArr;
        if (this.f29239d) {
            String str = this.f29242g;
            if (str != null) {
                this.f29237b = true;
                a aVar = this.f29245j;
                if (aVar != null) {
                    aVar.a(str);
                    return;
                }
                return;
            }
            InputState inputState = this.f29236a;
            if (inputState != InputState.HIGHBYTE) {
                if (inputState != InputState.ESC_ASCII && inputState == InputState.PURE_ASCII && this.f29240e) {
                    this.f29242g = b.A;
                    return;
                }
                return;
            }
            int i10 = 0;
            int i11 = 0;
            float f10 = 0.0f;
            while (true) {
                charsetProberArr = this.f29243h;
                if (i10 >= charsetProberArr.length) {
                    break;
                }
                float d10 = charsetProberArr[i10].d();
                if (d10 > f10) {
                    i11 = i10;
                    f10 = d10;
                }
                i10++;
            }
            if (f10 > 0.2f) {
                String c10 = charsetProberArr[i11].c();
                this.f29242g = c10;
                a aVar2 = this.f29245j;
                if (aVar2 != null) {
                    aVar2.a(c10);
                }
            }
        }
    }

    public String g() {
        return this.f29242g;
    }

    public a h() {
        return this.f29245j;
    }

    public void i(byte[] bArr) {
        j(bArr, 0, bArr.length);
    }

    public void j(byte[] bArr, int i10, int i11) {
        String f10;
        if (this.f29237b) {
            return;
        }
        if (i11 > 0) {
            this.f29239d = true;
        }
        int i12 = 0;
        if (this.f29238c) {
            this.f29238c = false;
            if (i11 > 3 && (f10 = f(bArr, i10)) != null) {
                this.f29242g = f10;
                this.f29237b = true;
                return;
            }
        }
        int i13 = i10 + i11;
        for (int i14 = i10; i14 < i13; i14++) {
            byte b10 = bArr[i14];
            int i15 = b10 & 255;
            if ((b10 & 128) == 0 || i15 == 160) {
                InputState inputState = this.f29236a;
                InputState inputState2 = InputState.PURE_ASCII;
                if (inputState == inputState2 && (i15 == 27 || (i15 == 123 && this.f29241f == 126))) {
                    this.f29236a = InputState.ESC_ASCII;
                }
                if (this.f29236a == inputState2 && this.f29240e) {
                    this.f29240e = (i15 >= 32 && i15 <= 126) || i15 == 10 || i15 == 13 || i15 == 9;
                }
                this.f29241f = b10;
            } else {
                InputState inputState3 = this.f29236a;
                InputState inputState4 = InputState.HIGHBYTE;
                if (inputState3 != inputState4) {
                    this.f29236a = inputState4;
                    if (this.f29244i != null) {
                        this.f29244i = null;
                    }
                    CharsetProber[] charsetProberArr = this.f29243h;
                    if (charsetProberArr[0] == null) {
                        charsetProberArr[0] = new i();
                    }
                    CharsetProber[] charsetProberArr2 = this.f29243h;
                    if (charsetProberArr2[1] == null) {
                        charsetProberArr2[1] = new j();
                    }
                    CharsetProber[] charsetProberArr3 = this.f29243h;
                    if (charsetProberArr3[2] == null) {
                        charsetProberArr3[2] = new h();
                    }
                }
            }
        }
        InputState inputState5 = this.f29236a;
        if (inputState5 == InputState.ESC_ASCII) {
            if (this.f29244i == null) {
                this.f29244i = new e();
            }
            if (this.f29244i.f(bArr, i10, i11) == CharsetProber.ProbingState.FOUND_IT) {
                this.f29237b = true;
                this.f29242g = this.f29244i.c();
                return;
            }
            return;
        }
        if (inputState5 != InputState.HIGHBYTE) {
            return;
        }
        while (true) {
            CharsetProber[] charsetProberArr4 = this.f29243h;
            if (i12 >= charsetProberArr4.length) {
                return;
            }
            if (charsetProberArr4[i12].f(bArr, i10, i11) == CharsetProber.ProbingState.FOUND_IT) {
                this.f29237b = true;
                this.f29242g = this.f29243h[i12].c();
                return;
            }
            i12++;
        }
    }

    public boolean k() {
        return this.f29237b;
    }

    public final void l() {
        int i10 = 0;
        this.f29237b = false;
        this.f29238c = true;
        this.f29242g = null;
        this.f29239d = false;
        this.f29236a = InputState.PURE_ASCII;
        this.f29241f = (byte) 0;
        CharsetProber charsetProber = this.f29244i;
        if (charsetProber != null) {
            charsetProber.j();
        }
        while (true) {
            CharsetProber[] charsetProberArr = this.f29243h;
            if (i10 >= charsetProberArr.length) {
                return;
            }
            CharsetProber charsetProber2 = charsetProberArr[i10];
            if (charsetProber2 != null) {
                charsetProber2.j();
            }
            i10++;
        }
    }

    public void m(a aVar) {
        this.f29245j = aVar;
    }

    public UniversalDetector(a aVar) {
        this.f29240e = true;
        this.f29245j = aVar;
        this.f29244i = null;
        this.f29243h = new CharsetProber[3];
        l();
    }
}
