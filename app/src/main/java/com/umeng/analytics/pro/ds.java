package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class ds extends du {

    /* renamed from: a */
    protected InputStream f23869a;

    /* renamed from: b */
    protected OutputStream f23870b;

    public ds() {
        this.f23869a = null;
        this.f23870b = null;
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() throws dv {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
        InputStream inputStream = this.f23869a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.f23869a = null;
        }
        OutputStream outputStream = this.f23870b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            this.f23870b = null;
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void d() throws dv {
        OutputStream outputStream = this.f23870b;
        if (outputStream == null) {
            throw new dv(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i10, int i11) throws dv {
        InputStream inputStream = this.f23869a;
        if (inputStream == null) {
            throw new dv(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i10, i11);
            if (read >= 0) {
                return read;
            }
            throw new dv(4);
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i10, int i11) throws dv {
        OutputStream outputStream = this.f23870b;
        if (outputStream == null) {
            throw new dv(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i10, i11);
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    public ds(InputStream inputStream) {
        this.f23870b = null;
        this.f23869a = inputStream;
    }

    public ds(OutputStream outputStream) {
        this.f23869a = null;
        this.f23870b = outputStream;
    }

    public ds(InputStream inputStream, OutputStream outputStream) {
        this.f23869a = inputStream;
        this.f23870b = outputStream;
    }
}
