package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class ay {

    /* renamed from: a */
    private final bu f25716a;

    /* renamed from: b */
    private final ch f25717b;

    public ay() {
        this(new bo.a());
    }

    private bp j(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        this.f25717b.a(bArr);
        int length = bcVarArr.length + 1;
        bc[] bcVarArr2 = new bc[length];
        int i2 = 0;
        bcVarArr2[0] = bcVar;
        int i3 = 0;
        while (i3 < bcVarArr.length) {
            int i4 = i3 + 1;
            bcVarArr2[i4] = bcVarArr[i3];
            i3 = i4;
        }
        this.f25716a.j();
        bp bpVar = null;
        while (i2 < length) {
            bpVar = this.f25716a.l();
            if (bpVar.f25780b == 0 || bpVar.f25781c > bcVarArr2[i2].a()) {
                return null;
            }
            if (bpVar.f25781c != bcVarArr2[i2].a()) {
                bx.a(this.f25716a, bpVar.f25780b);
                this.f25716a.m();
            } else {
                i2++;
                if (i2 < length) {
                    this.f25716a.j();
                }
            }
        }
        return bpVar;
    }

    public void a(av avVar, byte[] bArr) throws bb {
        try {
            this.f25717b.a(bArr);
            avVar.read(this.f25716a);
        } finally {
            this.f25717b.e();
            this.f25716a.B();
        }
    }

    public Byte b(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Byte) a((byte) 3, bArr, bcVar, bcVarArr);
    }

    public Double c(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Double) a((byte) 4, bArr, bcVar, bcVarArr);
    }

    public Short d(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Short) a((byte) 6, bArr, bcVar, bcVarArr);
    }

    public Integer e(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Integer) a((byte) 8, bArr, bcVar, bcVarArr);
    }

    public Long f(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Long) a((byte) 10, bArr, bcVar, bcVarArr);
    }

    public String g(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (String) a((byte) 11, bArr, bcVar, bcVarArr);
    }

    public ByteBuffer h(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (ByteBuffer) a((byte) 100, bArr, bcVar, bcVarArr);
    }

    public Short i(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        Short sh;
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    this.f25716a.j();
                    sh = Short.valueOf(this.f25716a.l().f25781c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.f25717b.e();
            this.f25716a.B();
        }
    }

    public ay(bw bwVar) {
        ch chVar = new ch();
        this.f25717b = chVar;
        this.f25716a = bwVar.a(chVar);
    }

    public void a(av avVar, String str, String str2) throws bb {
        try {
            try {
                a(avVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f25716a.B();
        }
    }

    public void a(av avVar, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    avVar.read(this.f25716a);
                }
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.f25717b.e();
            this.f25716a.B();
        }
    }

    public Boolean a(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Boolean) a((byte) 2, bArr, bcVar, bcVarArr);
    }

    private Object a(byte b2, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        Object obj;
        try {
            try {
                bp j2 = j(bArr, bcVar, bcVarArr);
                if (j2 != null) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 4) {
                                if (b2 != 6) {
                                    if (b2 != 8) {
                                        if (b2 != 100) {
                                            if (b2 != 10) {
                                                if (b2 == 11 && j2.f25780b == 11) {
                                                    obj = this.f25716a.z();
                                                }
                                            } else if (j2.f25780b == 10) {
                                                obj = Long.valueOf(this.f25716a.x());
                                            }
                                        } else if (j2.f25780b == 11) {
                                            obj = this.f25716a.A();
                                        }
                                    } else if (j2.f25780b == 8) {
                                        obj = Integer.valueOf(this.f25716a.w());
                                    }
                                } else if (j2.f25780b == 6) {
                                    obj = Short.valueOf(this.f25716a.v());
                                }
                            } else if (j2.f25780b == 4) {
                                obj = Double.valueOf(this.f25716a.y());
                            }
                        } else if (j2.f25780b == 3) {
                            obj = Byte.valueOf(this.f25716a.u());
                        }
                    } else if (j2.f25780b == 2) {
                        obj = Boolean.valueOf(this.f25716a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.f25717b.e();
            this.f25716a.B();
        }
    }

    public void a(av avVar, String str) throws bb {
        a(avVar, str.getBytes());
    }
}
