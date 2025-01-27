package xe;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class b extends a {

    /* renamed from: e */
    public static final int f32002e = 16;

    /* renamed from: f */
    public static final int f32003f = 16777216;

    /* renamed from: b */
    public final int f32004b;

    /* renamed from: d */
    public final List<Bitmap> f32006d = Collections.synchronizedList(new LinkedList());

    /* renamed from: c */
    public final AtomicInteger f32005c = new AtomicInteger();

    public b(int i10) {
        this.f32004b = i10;
        if (i10 > 16777216) {
            hf.d.i("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // xe.a, xe.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        boolean z10;
        int e10 = e(bitmap);
        int f10 = f();
        int i10 = this.f32005c.get();
        if (e10 < f10) {
            while (i10 + e10 > f10) {
                Bitmap g10 = g();
                if (this.f32006d.remove(g10)) {
                    i10 = this.f32005c.addAndGet(-e(g10));
                }
            }
            this.f32006d.add(bitmap);
            this.f32005c.addAndGet(e10);
            z10 = true;
        } else {
            z10 = false;
        }
        super.put(str, bitmap);
        return z10;
    }

    @Override // xe.a, xe.d
    public void clear() {
        this.f32006d.clear();
        this.f32005c.set(0);
        super.clear();
    }

    @Override // xe.a, xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.f32006d.remove(bitmap)) {
            this.f32005c.addAndGet(-e(bitmap));
        }
        return super.remove(str);
    }

    public abstract int e(Bitmap bitmap);

    public int f() {
        return this.f32004b;
    }

    public abstract Bitmap g();
}
