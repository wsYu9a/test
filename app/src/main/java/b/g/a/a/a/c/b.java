package b.g.a.a.a.c;

import android.graphics.Bitmap;
import b.g.a.b.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends a {
    private final long l;
    private final Map<File, Long> m;

    public b(File file, long j2) {
        this(file, null, com.nostra13.universalimageloader.core.a.d(), j2);
    }

    private void f(String str) {
        File b2 = b(str);
        long currentTimeMillis = System.currentTimeMillis();
        b2.setLastModified(currentTimeMillis);
        this.m.put(b2, Long.valueOf(currentTimeMillis));
    }

    @Override // b.g.a.a.a.c.a, b.g.a.a.a.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean a2 = super.a(str, inputStream, aVar);
        f(str);
        return a2;
    }

    @Override // b.g.a.a.a.c.a, b.g.a.a.a.a
    public void clear() {
        super.clear();
        this.m.clear();
    }

    @Override // b.g.a.a.a.c.a, b.g.a.a.a.a
    public File get(String str) {
        boolean z;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l = this.m.get(file);
            if (l == null) {
                l = Long.valueOf(file.lastModified());
                z = false;
            } else {
                z = true;
            }
            if (System.currentTimeMillis() - l.longValue() > this.l) {
                file.delete();
                this.m.remove(file);
            } else if (!z) {
                this.m.put(file, l);
            }
        }
        return file;
    }

    @Override // b.g.a.a.a.c.a, b.g.a.a.a.a
    public boolean remove(String str) {
        this.m.remove(b(str));
        return super.remove(str);
    }

    @Override // b.g.a.a.a.c.a, b.g.a.a.a.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        boolean save = super.save(str, bitmap);
        f(str);
        return save;
    }

    public b(File file, File file2, long j2) {
        this(file, file2, com.nostra13.universalimageloader.core.a.d(), j2);
    }

    public b(File file, File file2, b.g.a.a.a.d.a aVar, long j2) {
        super(file, file2, aVar);
        this.m = Collections.synchronizedMap(new HashMap());
        this.l = j2 * 1000;
    }
}
