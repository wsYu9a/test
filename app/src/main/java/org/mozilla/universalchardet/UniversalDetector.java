package org.mozilla.universalchardet;

import java.io.FileInputStream;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.e;
import org.mozilla.universalchardet.prober.h;
import org.mozilla.universalchardet.prober.i;
import org.mozilla.universalchardet.prober.j;

/* loaded from: classes5.dex */
public class UniversalDetector {

    /* renamed from: a */
    public static final float f35396a = 0.95f;

    /* renamed from: b */
    public static final float f35397b = 0.2f;

    /* renamed from: c */
    private InputState f35398c;

    /* renamed from: d */
    private boolean f35399d;

    /* renamed from: e */
    private boolean f35400e;

    /* renamed from: f */
    private boolean f35401f;

    /* renamed from: g */
    private byte f35402g;

    /* renamed from: h */
    private String f35403h;
    private org.mozilla.universalchardet.a k;

    /* renamed from: j */
    private CharsetProber f35405j = null;

    /* renamed from: i */
    private CharsetProber[] f35404i = new CharsetProber[3];

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    static class a implements org.mozilla.universalchardet.a {
        a() {
        }

        @Override // org.mozilla.universalchardet.a
        public void a(String str) {
            System.out.println("charset = " + str);
        }
    }

    public UniversalDetector(org.mozilla.universalchardet.a aVar) {
        this.k = aVar;
        int i2 = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.f35404i;
            if (i2 >= charsetProberArr.length) {
                g();
                return;
            } else {
                charsetProberArr[i2] = null;
                i2++;
            }
        }
    }

    public static void f(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            System.out.println("USAGE: java UniversalDetector filename");
            return;
        }
        UniversalDetector universalDetector = new UniversalDetector(new a());
        byte[] bArr = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0 || universalDetector.e()) {
                break;
            } else {
                universalDetector.d(bArr, 0, read);
            }
        }
        universalDetector.a();
    }

    public void a() {
        CharsetProber[] charsetProberArr;
        if (this.f35401f) {
            String str = this.f35403h;
            if (str != null) {
                this.f35399d = true;
                org.mozilla.universalchardet.a aVar = this.k;
                if (aVar != null) {
                    aVar.a(str);
                    return;
                }
                return;
            }
            if (this.f35398c != InputState.HIGHBYTE) {
                InputState inputState = InputState.ESC_ASCII;
                return;
            }
            float f2 = 0.0f;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                charsetProberArr = this.f35404i;
                if (i2 >= charsetProberArr.length) {
                    break;
                }
                float d2 = charsetProberArr[i2].d();
                if (d2 > f2) {
                    i3 = i2;
                    f2 = d2;
                }
                i2++;
            }
            if (f2 > 0.2f) {
                String c2 = charsetProberArr[i3].c();
                this.f35403h = c2;
                org.mozilla.universalchardet.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.a(c2);
                }
            }
        }
    }

    public String b() {
        return this.f35403h;
    }

    public org.mozilla.universalchardet.a c() {
        return this.k;
    }

    public void d(byte[] bArr, int i2, int i3) {
        if (this.f35399d) {
            return;
        }
        if (i3 > 0) {
            this.f35401f = true;
        }
        int i4 = 0;
        if (this.f35400e) {
            this.f35400e = false;
            if (i3 > 3) {
                int i5 = bArr[i2] & 255;
                int i6 = bArr[i2 + 1] & 255;
                int i7 = bArr[i2 + 2] & 255;
                int i8 = bArr[i2 + 3] & 255;
                if (i5 != 0) {
                    if (i5 != 239) {
                        if (i5 != 254) {
                            if (i5 == 255) {
                                if (i6 == 254 && i7 == 0 && i8 == 0) {
                                    this.f35403h = b.y;
                                } else if (i6 == 254) {
                                    this.f35403h = b.w;
                                }
                            }
                        } else if (i6 == 255 && i7 == 0 && i8 == 0) {
                            this.f35403h = b.A;
                        } else if (i6 == 255) {
                            this.f35403h = b.v;
                        }
                    } else if (i6 == 187 && i7 == 191) {
                        this.f35403h = b.u;
                    }
                } else if (i6 == 0 && i7 == 254 && i8 == 255) {
                    this.f35403h = b.x;
                } else if (i6 == 0 && i7 == 255 && i8 == 254) {
                    this.f35403h = b.B;
                }
                if (this.f35403h != null) {
                    this.f35399d = true;
                    return;
                }
            }
        }
        int i9 = i2 + i3;
        for (int i10 = i2; i10 < i9; i10++) {
            int i11 = bArr[i10] & 255;
            if ((i11 & 128) == 0 || i11 == 160) {
                if (this.f35398c == InputState.PURE_ASCII && (i11 == 27 || (i11 == 123 && this.f35402g == 126))) {
                    this.f35398c = InputState.ESC_ASCII;
                }
                this.f35402g = bArr[i10];
            } else {
                InputState inputState = this.f35398c;
                InputState inputState2 = InputState.HIGHBYTE;
                if (inputState != inputState2) {
                    this.f35398c = inputState2;
                    if (this.f35405j != null) {
                        this.f35405j = null;
                    }
                    CharsetProber[] charsetProberArr = this.f35404i;
                    if (charsetProberArr[0] == null) {
                        charsetProberArr[0] = new i();
                    }
                    CharsetProber[] charsetProberArr2 = this.f35404i;
                    if (charsetProberArr2[1] == null) {
                        charsetProberArr2[1] = new j();
                    }
                    CharsetProber[] charsetProberArr3 = this.f35404i;
                    if (charsetProberArr3[2] == null) {
                        charsetProberArr3[2] = new h();
                    }
                }
            }
        }
        InputState inputState3 = this.f35398c;
        if (inputState3 == InputState.ESC_ASCII) {
            if (this.f35405j == null) {
                this.f35405j = new e();
            }
            if (this.f35405j.f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                this.f35399d = true;
                this.f35403h = this.f35405j.c();
                return;
            }
            return;
        }
        if (inputState3 != InputState.HIGHBYTE) {
            return;
        }
        while (true) {
            CharsetProber[] charsetProberArr4 = this.f35404i;
            if (i4 >= charsetProberArr4.length) {
                return;
            }
            if (charsetProberArr4[i4].f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                this.f35399d = true;
                this.f35403h = this.f35404i[i4].c();
                return;
            }
            i4++;
        }
    }

    public boolean e() {
        return this.f35399d;
    }

    public void g() {
        int i2 = 0;
        this.f35399d = false;
        this.f35400e = true;
        this.f35403h = null;
        this.f35401f = false;
        this.f35398c = InputState.PURE_ASCII;
        this.f35402g = (byte) 0;
        CharsetProber charsetProber = this.f35405j;
        if (charsetProber != null) {
            charsetProber.i();
        }
        while (true) {
            CharsetProber[] charsetProberArr = this.f35404i;
            if (i2 >= charsetProberArr.length) {
                return;
            }
            if (charsetProberArr[i2] != null) {
                charsetProberArr[i2].i();
            }
            i2++;
        }
    }

    public void h(org.mozilla.universalchardet.a aVar) {
        this.k = aVar;
    }
}
