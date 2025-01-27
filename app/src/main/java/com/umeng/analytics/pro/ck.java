package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class ck {

    /* renamed from: a */
    private final dg f23747a;

    /* renamed from: b */
    private final dt f23748b;

    public ck() {
        this(new da.a());
    }

    private db j(byte[] bArr, co coVar, co... coVarArr) throws cn {
        this.f23748b.a(bArr);
        int length = coVarArr.length + 1;
        co[] coVarArr2 = new co[length];
        int i10 = 0;
        coVarArr2[0] = coVar;
        int i11 = 0;
        while (i11 < coVarArr.length) {
            int i12 = i11 + 1;
            coVarArr2[i12] = coVarArr[i11];
            i11 = i12;
        }
        this.f23747a.j();
        db dbVar = null;
        while (i10 < length) {
            dbVar = this.f23747a.l();
            if (dbVar.f23828b == 0 || dbVar.f23829c > coVarArr2[i10].a()) {
                return null;
            }
            if (dbVar.f23829c != coVarArr2[i10].a()) {
                dj.a(this.f23747a, dbVar.f23828b);
                this.f23747a.m();
            } else {
                i10++;
                if (i10 < length) {
                    this.f23747a.j();
                }
            }
        }
        return dbVar;
    }

    public void a(ch chVar, byte[] bArr) throws cn {
        try {
            this.f23748b.a(bArr);
            chVar.read(this.f23747a);
        } finally {
            this.f23748b.e();
            this.f23747a.B();
        }
    }

    public Byte b(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Byte) a((byte) 3, bArr, coVar, coVarArr);
    }

    public Double c(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Double) a((byte) 4, bArr, coVar, coVarArr);
    }

    public Short d(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Short) a((byte) 6, bArr, coVar, coVarArr);
    }

    public Integer e(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Integer) a((byte) 8, bArr, coVar, coVarArr);
    }

    public Long f(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Long) a((byte) 10, bArr, coVar, coVarArr);
    }

    public String g(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (String) a((byte) 11, bArr, coVar, coVarArr);
    }

    public ByteBuffer h(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (ByteBuffer) a((byte) 100, bArr, coVar, coVarArr);
    }

    public Short i(byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    this.f23747a.j();
                    return Short.valueOf(this.f23747a.l().f23829c);
                }
                this.f23748b.e();
                this.f23747a.B();
                return null;
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f23748b.e();
            this.f23747a.B();
        }
    }

    public ck(di diVar) {
        dt dtVar = new dt();
        this.f23748b = dtVar;
        this.f23747a = diVar.a(dtVar);
    }

    public void a(ch chVar, String str, String str2) throws cn {
        try {
            try {
                a(chVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f23747a.B();
        }
    }

    public void a(ch chVar, byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    chVar.read(this.f23747a);
                }
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f23748b.e();
            this.f23747a.B();
        }
    }

    public Boolean a(byte[] bArr, co coVar, co... coVarArr) throws cn {
        return (Boolean) a((byte) 2, bArr, coVar, coVarArr);
    }

    private Object a(byte b10, byte[] bArr, co coVar, co... coVarArr) throws cn {
        try {
            try {
                db j10 = j(bArr, coVar, coVarArr);
                if (j10 != null) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 != 6) {
                                    if (b10 != 8) {
                                        if (b10 != 100) {
                                            if (b10 != 10) {
                                                if (b10 == 11 && j10.f23828b == 11) {
                                                    return this.f23747a.z();
                                                }
                                            } else if (j10.f23828b == 10) {
                                                return Long.valueOf(this.f23747a.x());
                                            }
                                        } else if (j10.f23828b == 11) {
                                            return this.f23747a.A();
                                        }
                                    } else if (j10.f23828b == 8) {
                                        return Integer.valueOf(this.f23747a.w());
                                    }
                                } else if (j10.f23828b == 6) {
                                    return Short.valueOf(this.f23747a.v());
                                }
                            } else if (j10.f23828b == 4) {
                                return Double.valueOf(this.f23747a.y());
                            }
                        } else if (j10.f23828b == 3) {
                            return Byte.valueOf(this.f23747a.u());
                        }
                    } else if (j10.f23828b == 2) {
                        return Boolean.valueOf(this.f23747a.t());
                    }
                }
                this.f23748b.e();
                this.f23747a.B();
                return null;
            } catch (Exception e10) {
                throw new cn(e10);
            }
        } finally {
            this.f23748b.e();
            this.f23747a.B();
        }
    }

    public void a(ch chVar, String str) throws cn {
        a(chVar, str.getBytes());
    }
}
