package b.g.a.a.b;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public abstract class b extends a {

    /* renamed from: b */
    private static final int f4891b = 16;

    /* renamed from: c */
    private static final int f4892c = 16777216;

    /* renamed from: d */
    private final int f4893d;

    /* renamed from: f */
    private final List<Bitmap> f4895f = Collections.synchronizedList(new LinkedList());

    /* renamed from: e */
    private final AtomicInteger f4894e = new AtomicInteger();

    public b(int i2) {
        this.f4893d = i2;
        if (i2 > 16777216) {
            b.g.a.b.d.i("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        boolean z;
        int e2 = e(bitmap);
        int f2 = f();
        int i2 = this.f4894e.get();
        if (e2 < f2) {
            while (i2 + e2 > f2) {
                Bitmap g2 = g();
                if (this.f4895f.remove(g2)) {
                    i2 = this.f4894e.addAndGet(-e(g2));
                }
            }
            this.f4895f.add(bitmap);
            this.f4894e.addAndGet(e2);
            z = true;
        } else {
            z = false;
        }
        super.put(str, bitmap);
        return z;
    }

    @Override // b.g.a.a.b.a, b.g.a.a.b.d
    public void clear() {
        this.f4895f.clear();
        this.f4894e.set(0);
        super.clear();
    }

    @Override // b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.f4895f.remove(bitmap)) {
            this.f4894e.addAndGet(-e(bitmap));
        }
        return super.remove(str);
    }

    protected abstract int e(Bitmap bitmap);

    protected int f() {
        return this.f4893d;
    }

    protected abstract Bitmap g();
}
