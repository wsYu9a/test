package ue;

import android.graphics.Bitmap;
import hf.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: l */
    public final long f31052l;

    /* renamed from: m */
    public final Map<File, Long> f31053m;

    public b(File file, long j10) {
        this(file, null, ze.a.d(), j10);
    }

    @Override // ue.a, te.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean a10 = super.a(str, inputStream, aVar);
        f(str);
        return a10;
    }

    @Override // ue.a, te.a
    public void clear() {
        super.clear();
        this.f31053m.clear();
    }

    public final void f(String str) {
        File b10 = b(str);
        long currentTimeMillis = System.currentTimeMillis();
        b10.setLastModified(currentTimeMillis);
        this.f31053m.put(b10, Long.valueOf(currentTimeMillis));
    }

    @Override // ue.a, te.a
    public File get(String str) {
        boolean z10;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l10 = this.f31053m.get(file);
            if (l10 == null) {
                l10 = Long.valueOf(file.lastModified());
                z10 = false;
            } else {
                z10 = true;
            }
            if (System.currentTimeMillis() - l10.longValue() > this.f31052l) {
                file.delete();
                this.f31053m.remove(file);
            } else if (!z10) {
                this.f31053m.put(file, l10);
            }
        }
        return file;
    }

    @Override // ue.a, te.a
    public boolean remove(String str) {
        this.f31053m.remove(b(str));
        return super.remove(str);
    }

    @Override // ue.a, te.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        boolean save = super.save(str, bitmap);
        f(str);
        return save;
    }

    public b(File file, File file2, long j10) {
        this(file, file2, ze.a.d(), j10);
    }

    public b(File file, File file2, we.a aVar, long j10) {
        super(file, file2, aVar);
        this.f31053m = Collections.synchronizedMap(new HashMap());
        this.f31052l = j10 * 1000;
    }
}
