package com.jd.ad.sdk.jad_lo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public final class jad_jt extends Thread {
    public boolean jad_an;
    public InputStream jad_bo;
    public StringBuilder jad_cp = new StringBuilder();
    public volatile boolean jad_dq;

    public jad_jt(InputStream inputStream, boolean z10) {
        this.jad_an = false;
        this.jad_dq = false;
        this.jad_bo = inputStream;
        this.jad_dq = false;
        this.jad_an = z10;
    }

    public final String jad_an() {
        if (!this.jad_dq) {
            synchronized (this) {
                try {
                    if (!this.jad_dq) {
                        wait();
                    }
                } finally {
                }
            }
        }
        return this.jad_cp.toString();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.jad_bo));
        } catch (IOException unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String property = this.jad_an ? System.getProperty("line.separator") : "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    this.jad_cp.append(readLine + property);
                } else {
                    try {
                        break;
                    } catch (Exception unused2) {
                    }
                }
            }
            bufferedReader.close();
            try {
                this.jad_bo.close();
            } catch (Exception unused3) {
            }
            this.jad_dq = true;
            synchronized (this) {
                notify();
            }
        } catch (IOException unused4) {
            bufferedReader2 = bufferedReader;
            try {
                bufferedReader2.close();
            } catch (Exception unused5) {
            }
            try {
                this.jad_bo.close();
            } catch (Exception unused6) {
            }
            this.jad_dq = true;
            synchronized (this) {
                notify();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                bufferedReader2.close();
            } catch (Exception unused7) {
            }
            try {
                this.jad_bo.close();
            } catch (Exception unused8) {
            }
            this.jad_dq = true;
            synchronized (this) {
                notify();
            }
            throw th;
        }
    }
}
