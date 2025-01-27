package com.shu.priory.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class a implements h {

    /* renamed from: a */
    protected final f f16791a;

    /* renamed from: b */
    protected final File f16792b;

    /* renamed from: d */
    private OutputStream f16794d;

    /* renamed from: c */
    private final ExecutorService f16793c = Executors.newSingleThreadExecutor();

    /* renamed from: e */
    private final Runnable f16795e = new Runnable() { // from class: com.shu.priory.a.a.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.f16791a.a(aVar.f16794d);
            } catch (IOException | IllegalStateException e10) {
                e10.printStackTrace();
            }
        }
    };

    /* renamed from: com.shu.priory.a.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.f16791a.a(aVar.f16794d);
            } catch (IOException | IllegalStateException e10) {
                e10.printStackTrace();
            }
        }
    }

    public a(f fVar, File file) {
        this.f16791a = fVar;
        this.f16792b = file;
    }

    @Override // com.shu.priory.a.h
    public void b() throws IOException {
        this.f16791a.a();
        OutputStream outputStream = this.f16794d;
        if (outputStream != null) {
            outputStream.flush();
            this.f16794d.close();
        }
    }

    private OutputStream a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.shu.priory.a.h
    public void a() {
        OutputStream a10 = a(this.f16792b);
        this.f16794d = a10;
        if (a10 != null) {
            this.f16793c.submit(this.f16795e);
        }
    }
}
