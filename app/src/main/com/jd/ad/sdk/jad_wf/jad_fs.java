package com.jd.ad.sdk.jad_wf;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jd.ad.sdk.jad_hk.jad_ob;
import com.jd.ad.sdk.jad_lu.jad_zm;
import com.jd.ad.sdk.jad_wf.jad_cp;
import java.io.EOFException;

/* loaded from: classes2.dex */
public final class jad_fs extends jad_cp {
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ly = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("'\\");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_mz = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("\"\\");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_na = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("{}[]:, \n\t\r\f/\\;#=");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ob = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("\n\r");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_pc = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("*/");
    public final com.jd.ad.sdk.jad_hk.jad_bo jad_fs;
    public int jad_hu = 0;
    public long jad_iv;
    public final com.jd.ad.sdk.jad_hk.jad_an jad_jt;
    public int jad_jw;

    @Nullable
    public String jad_kx;

    public jad_fs(com.jd.ad.sdk.jad_hk.jad_bo jad_boVar) {
        if (jad_boVar == null) {
            throw new NullPointerException("source == null");
        }
        this.jad_fs = jad_boVar;
        this.jad_jt = jad_boVar.jad_an();
        jad_an(6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_hu = 0;
        this.jad_bo[0] = 8;
        this.jad_an = 1;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
            this.jad_fs.close();
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_an(jad_cp.jad_an jad_anVar) {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return jad_an(this.jad_kx, jad_anVar);
        }
        int jad_an = this.jad_fs.jad_an(jad_anVar.jad_bo);
        if (jad_an != -1) {
            this.jad_hu = 0;
            this.jad_cp[this.jad_an - 1] = jad_anVar.jad_an[jad_an];
            return jad_an;
        }
        String str = this.jad_cp[this.jad_an - 1];
        String jad_kx = jad_kx();
        int jad_an2 = jad_an(jad_kx, jad_anVar);
        if (jad_an2 == -1) {
            this.jad_hu = 15;
            this.jad_kx = jad_kx;
            this.jad_cp[this.jad_an - 1] = str;
        }
        return jad_an2;
    }

    public final boolean jad_bo(int i10) {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (i10 != 47 && i10 != 61) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case TTDownloadField.CALL_DOWNLOAD_MODEL_IS_SHOW_TOAST /* 91 */:
                        case TTDownloadField.CALL_DOWNLOAD_MODEL_IS_NEED_WIFI /* 93 */:
                            return false;
                        case TTDownloadField.CALL_DOWNLOAD_MODEL_IS_SHOW_NOTIFICATION /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        jad_pc();
        throw null;
    }

    public final void jad_cp(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        while (true) {
            long jad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jad_an) != 92) {
                this.jad_jt.jad_dq(jad_an + 1);
                return;
            } else {
                this.jad_jt.jad_dq(jad_an + 1);
                jad_sf();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_dq() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 != 4) {
            StringBuilder jad_an = jad_zm.jad_an("Expected END_ARRAY but was ");
            jad_an.append(jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an));
        }
        int i11 = this.jad_an;
        this.jad_an = i11 - 1;
        int[] iArr = this.jad_dq;
        int i12 = i11 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_er() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 != 2) {
            StringBuilder jad_an = jad_zm.jad_an("Expected END_OBJECT but was ");
            jad_an.append(jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an));
        }
        int i11 = this.jad_an;
        int i12 = i11 - 1;
        this.jad_an = i12;
        this.jad_cp[i12] = null;
        int[] iArr = this.jad_dq;
        int i13 = i11 - 2;
        iArr[i13] = iArr[i13] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_hu() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 5) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i11 = this.jad_an - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 != 6) {
            StringBuilder jad_an = jad_zm.jad_an("Expected a boolean but was ");
            jad_an.append(jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an));
        }
        this.jad_hu = 0;
        int[] iArr2 = this.jad_dq;
        int i12 = this.jad_an - 1;
        iArr2[i12] = iArr2[i12] + 1;
        return false;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public double jad_iv() {
        String jad_re;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        double parseDouble;
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 16) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i11 = this.jad_an - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.jad_iv;
        }
        try {
            if (i10 == 17) {
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j10 = this.jad_jw;
                jad_anVar.getClass();
                jad_re = jad_anVar.jad_an(j10, jad_ob.jad_an);
            } else {
                if (i10 == 9) {
                    jad_cpVar = jad_mz;
                } else if (i10 == 8) {
                    jad_cpVar = jad_ly;
                } else {
                    if (i10 != 10) {
                        if (i10 != 11) {
                            StringBuilder jad_an = jad_zm.jad_an("Expected a double but was ");
                            jad_an.append(jad_dq.jad_an(jad_mz()));
                            jad_an.append(" at path ");
                            throw new jad_an(jad_er.jad_an(this, jad_an));
                        }
                        this.jad_hu = 11;
                        parseDouble = Double.parseDouble(this.jad_kx);
                        if (!Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("JSON forbids NaN and infinities: ");
                            sb2.append(parseDouble);
                            sb2.append(" at path ");
                            throw new jad_bo(jad_er.jad_an(this, sb2));
                        }
                        this.jad_kx = null;
                        this.jad_hu = 0;
                        int[] iArr2 = this.jad_dq;
                        int i12 = this.jad_an - 1;
                        iArr2[i12] = iArr2[i12] + 1;
                        return parseDouble;
                    }
                    jad_re = jad_re();
                }
                jad_re = jad_bo(jad_cpVar);
            }
            parseDouble = Double.parseDouble(this.jad_kx);
            if (Double.isNaN(parseDouble)) {
            }
            StringBuilder sb22 = new StringBuilder();
            sb22.append("JSON forbids NaN and infinities: ");
            sb22.append(parseDouble);
            sb22.append(" at path ");
            throw new jad_bo(jad_er.jad_an(this, sb22));
        } catch (NumberFormatException unused) {
            StringBuilder jad_an2 = jad_zm.jad_an("Expected a double but was ");
            jad_an2.append(this.jad_kx);
            jad_an2.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an2));
        }
        this.jad_kx = jad_re;
        this.jad_hu = 11;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_jt() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        return (i10 == 2 || i10 == 4 || i10 == 18) ? false : true;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_jw() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 16) {
            long j10 = this.jad_iv;
            int i11 = (int) j10;
            if (j10 != i11) {
                StringBuilder jad_an = jad_zm.jad_an("Expected an int but was ");
                jad_an.append(this.jad_iv);
                jad_an.append(" at path ");
                throw new jad_an(jad_er.jad_an(this, jad_an));
            }
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i12 = this.jad_an - 1;
            iArr[i12] = iArr[i12] + 1;
            return i11;
        }
        if (i10 == 17) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            long j11 = this.jad_jw;
            jad_anVar.getClass();
            this.jad_kx = jad_anVar.jad_an(j11, jad_ob.jad_an);
        } else if (i10 == 9 || i10 == 8) {
            String jad_bo = jad_bo(i10 == 9 ? jad_mz : jad_ly);
            this.jad_kx = jad_bo;
            try {
                int parseInt = Integer.parseInt(jad_bo);
                this.jad_hu = 0;
                int[] iArr2 = this.jad_dq;
                int i13 = this.jad_an - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            StringBuilder jad_an2 = jad_zm.jad_an("Expected an int but was ");
            jad_an2.append(jad_dq.jad_an(jad_mz()));
            jad_an2.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an2));
        }
        this.jad_hu = 11;
        try {
            double parseDouble = Double.parseDouble(this.jad_kx);
            int i14 = (int) parseDouble;
            if (i14 != parseDouble) {
                StringBuilder jad_an3 = jad_zm.jad_an("Expected an int but was ");
                jad_an3.append(this.jad_kx);
                jad_an3.append(" at path ");
                throw new jad_an(jad_er.jad_an(this, jad_an3));
            }
            this.jad_kx = null;
            this.jad_hu = 0;
            int[] iArr3 = this.jad_dq;
            int i15 = this.jad_an - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        } catch (NumberFormatException unused2) {
            StringBuilder jad_an4 = jad_zm.jad_an("Expected an int but was ");
            jad_an4.append(this.jad_kx);
            jad_an4.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an4));
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public String jad_kx() {
        String str;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 14) {
            str = jad_re();
        } else {
            if (i10 == 13) {
                jad_cpVar = jad_mz;
            } else if (i10 == 12) {
                jad_cpVar = jad_ly;
            } else {
                if (i10 != 15) {
                    StringBuilder jad_an = jad_zm.jad_an("Expected a name but was ");
                    jad_an.append(jad_dq.jad_an(jad_mz()));
                    jad_an.append(" at path ");
                    throw new jad_an(jad_er.jad_an(this, jad_an));
                }
                str = this.jad_kx;
            }
            str = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = str;
        return str;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public String jad_ly() {
        String jad_an;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 10) {
            jad_an = jad_re();
        } else {
            if (i10 == 9) {
                jad_cpVar = jad_mz;
            } else if (i10 == 8) {
                jad_cpVar = jad_ly;
            } else if (i10 == 11) {
                jad_an = this.jad_kx;
                this.jad_kx = null;
            } else if (i10 == 16) {
                jad_an = Long.toString(this.jad_iv);
            } else {
                if (i10 != 17) {
                    StringBuilder jad_an2 = jad_zm.jad_an("Expected a string but was ");
                    jad_an2.append(jad_dq.jad_an(jad_mz()));
                    jad_an2.append(" at path ");
                    throw new jad_an(jad_er.jad_an(this, jad_an2));
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j10 = this.jad_jw;
                jad_anVar.getClass();
                jad_an = jad_anVar.jad_an(j10, jad_ob.jad_an);
            }
            jad_an = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        int[] iArr = this.jad_dq;
        int i11 = this.jad_an - 1;
        iArr[i11] = iArr[i11] + 1;
        return jad_an;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_mz() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        switch (i10) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
            case 15:
                return 5;
            case 16:
            case 17:
                return 7;
            case 18:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_na() {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 14) {
            jad_tg();
        } else {
            if (i10 == 13) {
                jad_cpVar = jad_mz;
            } else if (i10 == 12) {
                jad_cpVar = jad_ly;
            } else if (i10 != 15) {
                StringBuilder jad_an = jad_zm.jad_an("Expected a name but was ");
                jad_an.append(jad_dq.jad_an(jad_mz()));
                jad_an.append(" at path ");
                throw new jad_an(jad_er.jad_an(this, jad_an));
            }
            jad_cp(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = "null";
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_ob() {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i10 = 0;
        do {
            int i11 = this.jad_hu;
            if (i11 == 0) {
                i11 = jad_qd();
            }
            if (i11 == 3) {
                jad_an(1);
            } else if (i11 == 1) {
                jad_an(3);
            } else {
                if (i11 == 4) {
                    i10--;
                    if (i10 < 0) {
                        StringBuilder jad_an = jad_zm.jad_an("Expected a value but was ");
                        jad_an.append(jad_dq.jad_an(jad_mz()));
                        jad_an.append(" at path ");
                        throw new jad_an(jad_er.jad_an(this, jad_an));
                    }
                } else if (i11 == 2) {
                    i10--;
                    if (i10 < 0) {
                        StringBuilder jad_an2 = jad_zm.jad_an("Expected a value but was ");
                        jad_an2.append(jad_dq.jad_an(jad_mz()));
                        jad_an2.append(" at path ");
                        throw new jad_an(jad_er.jad_an(this, jad_an2));
                    }
                } else {
                    if (i11 == 14 || i11 == 10) {
                        jad_tg();
                    } else {
                        if (i11 == 9 || i11 == 13) {
                            jad_cpVar = jad_mz;
                        } else if (i11 == 8 || i11 == 12) {
                            jad_cpVar = jad_ly;
                        } else if (i11 == 17) {
                            this.jad_jt.jad_dq(this.jad_jw);
                        } else if (i11 == 18) {
                            StringBuilder jad_an3 = jad_zm.jad_an("Expected a value but was ");
                            jad_an3.append(jad_dq.jad_an(jad_mz()));
                            jad_an3.append(" at path ");
                            throw new jad_an(jad_er.jad_an(this, jad_an3));
                        }
                        jad_cp(jad_cpVar);
                    }
                    this.jad_hu = 0;
                }
                this.jad_an--;
                this.jad_hu = 0;
            }
            i10++;
            this.jad_hu = 0;
        } while (i10 != 0);
        int[] iArr = this.jad_dq;
        int i12 = this.jad_an - 1;
        iArr[i12] = iArr[i12] + 1;
        this.jad_cp[i12] = "null";
    }

    public final void jad_pc() {
        jad_an("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c3, code lost:
    
        if (r1 == 4) goto L637;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01c6, code lost:
    
        if (r1 != 7) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c8, code lost:
    
        r18.jad_jw = r2;
        r13 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0199, code lost:
    
        if (jad_bo(r10) != false) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019b, code lost:
    
        if (r1 != 2) goto L632;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019d, code lost:
    
        if (r17 == false) goto L632;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a3, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L624;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a5, code lost:
    
        if (r4 == false) goto L632;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ab, code lost:
    
        if (r8 != 0) goto L627;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ad, code lost:
    
        if (r4 != false) goto L632;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01af, code lost:
    
        if (r4 == false) goto L629;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b2, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b3, code lost:
    
        r18.jad_iv = r8;
        r18.jad_jt.jad_dq(r2);
        r13 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bd, code lost:
    
        r18.jad_hu = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c0, code lost:
    
        if (r1 == 2) goto L637;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int jad_qd() {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_wf.jad_fs.jad_qd():int");
    }

    public final String jad_re() {
        long jad_an = this.jad_fs.jad_an(jad_na);
        if (jad_an != -1) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            jad_anVar.getClass();
            return jad_anVar.jad_an(jad_an, jad_ob.jad_an);
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
        jad_anVar2.getClass();
        try {
            return jad_anVar2.jad_an(jad_anVar2.jad_bo, jad_ob.jad_an);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public final char jad_sf() {
        int i10;
        if (!this.jad_fs.jad_an(1L)) {
            jad_an("Unterminated escape sequence");
            throw null;
        }
        byte jad_bo = this.jad_jt.jad_bo();
        if (jad_bo == 10 || jad_bo == 34 || jad_bo == 39 || jad_bo == 47 || jad_bo == 92) {
            return (char) jad_bo;
        }
        if (jad_bo == 98) {
            return '\b';
        }
        if (jad_bo == 102) {
            return '\f';
        }
        if (jad_bo == 110) {
            return '\n';
        }
        if (jad_bo == 114) {
            return '\r';
        }
        if (jad_bo == 116) {
            return '\t';
        }
        if (jad_bo != 117) {
            StringBuilder jad_an = jad_zm.jad_an("Invalid escape sequence: \\");
            jad_an.append((char) jad_bo);
            jad_an(jad_an.toString());
            throw null;
        }
        if (!this.jad_fs.jad_an(4L)) {
            throw new EOFException(jad_er.jad_an(this, jad_zm.jad_an("Unterminated escape sequence at path ")));
        }
        char c10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            byte jad_bo2 = this.jad_jt.jad_bo(i11);
            char c11 = (char) (c10 << 4);
            if (jad_bo2 >= 48 && jad_bo2 <= 57) {
                i10 = jad_bo2 - 48;
            } else if (jad_bo2 >= 97 && jad_bo2 <= 102) {
                i10 = jad_bo2 - 87;
            } else {
                if (jad_bo2 < 65 || jad_bo2 > 70) {
                    StringBuilder jad_an2 = jad_zm.jad_an("\\u");
                    com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                    jad_anVar.getClass();
                    jad_an2.append(jad_anVar.jad_an(4L, jad_ob.jad_an));
                    jad_an(jad_an2.toString());
                    throw null;
                }
                i10 = jad_bo2 - 55;
            }
            c10 = (char) (i10 + c11);
        }
        this.jad_jt.jad_dq(4L);
        return c10;
    }

    public final void jad_tg() {
        long jad_an = this.jad_fs.jad_an(jad_na);
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        if (jad_an == -1) {
            jad_an = jad_anVar.jad_bo;
        }
        jad_anVar.jad_dq(jad_an);
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("JsonReader(");
        jad_an.append(this.jad_fs);
        jad_an.append(")");
        return jad_an.toString();
    }

    public final int jad_an(String str, jad_cp.jad_an jad_anVar) {
        int length = jad_anVar.jad_an.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(jad_anVar.jad_an[i10])) {
                this.jad_hu = 0;
                this.jad_cp[this.jad_an - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_bo() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 3) {
            jad_an(1);
            this.jad_dq[this.jad_an - 1] = 0;
            this.jad_hu = 0;
        } else {
            StringBuilder jad_an = jad_zm.jad_an("Expected BEGIN_ARRAY but was ");
            jad_an.append(jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an));
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_cp() {
        int i10 = this.jad_hu;
        if (i10 == 0) {
            i10 = jad_qd();
        }
        if (i10 == 1) {
            jad_an(3);
            this.jad_hu = 0;
        } else {
            StringBuilder jad_an = jad_zm.jad_an("Expected BEGIN_OBJECT but was ");
            jad_an.append(jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new jad_an(jad_er.jad_an(this, jad_an));
        }
    }

    public final int jad_an(boolean z10) {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!this.jad_fs.jad_an(i11)) {
                if (z10) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            byte jad_bo = this.jad_jt.jad_bo(i10);
            if (jad_bo != 10 && jad_bo != 32 && jad_bo != 13 && jad_bo != 9) {
                this.jad_jt.jad_dq(i10);
                if (jad_bo == 47) {
                    if (!this.jad_fs.jad_an(2L)) {
                        return jad_bo;
                    }
                    jad_pc();
                    throw null;
                }
                if (jad_bo != 35) {
                    return jad_bo;
                }
                jad_pc();
                throw null;
            }
            i10 = i11;
        }
    }

    public final String jad_bo(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        StringBuilder sb2 = null;
        while (true) {
            long jad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jad_an) != 92) {
                if (sb2 == null) {
                    com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                    jad_anVar.getClass();
                    String jad_an2 = jad_anVar.jad_an(jad_an, jad_ob.jad_an);
                    this.jad_jt.jad_bo();
                    return jad_an2;
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
                jad_anVar2.getClass();
                sb2.append(jad_anVar2.jad_an(jad_an, jad_ob.jad_an));
                this.jad_jt.jad_bo();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar3 = this.jad_jt;
            jad_anVar3.getClass();
            sb2.append(jad_anVar3.jad_an(jad_an, jad_ob.jad_an));
            this.jad_jt.jad_bo();
            sb2.append(jad_sf());
        }
    }
}
