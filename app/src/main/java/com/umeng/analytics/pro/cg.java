package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class cg extends ci {

    /* renamed from: a */
    protected InputStream f25818a;

    /* renamed from: b */
    protected OutputStream f25819b;

    protected cg() {
        this.f25818a = null;
        this.f25819b = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i2, int i3) throws cj {
        InputStream inputStream = this.f25818a;
        if (inputStream == null) {
            throw new cj(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i2, i3);
            if (read >= 0) {
                return read;
            }
            throw new cj(4);
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i2, int i3) throws cj {
        OutputStream outputStream = this.f25819b;
        if (outputStream == null) {
            throw new cj(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
        InputStream inputStream = this.f25818a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f25818a = null;
        }
        OutputStream outputStream = this.f25819b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f25819b = null;
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void d() throws cj {
        OutputStream outputStream = this.f25819b;
        if (outputStream == null) {
            throw new cj(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new cj(0, e2);
        }
    }

    public cg(InputStream inputStream) {
        this.f25818a = null;
        this.f25819b = null;
        this.f25818a = inputStream;
    }

    public cg(OutputStream outputStream) {
        this.f25818a = null;
        this.f25819b = null;
        this.f25819b = outputStream;
    }

    public cg(InputStream inputStream, OutputStream outputStream) {
        this.f25818a = null;
        this.f25819b = null;
        this.f25818a = inputStream;
        this.f25819b = outputStream;
    }
}
