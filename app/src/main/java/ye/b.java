package ye;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class b implements xe.c {

    /* renamed from: a */
    public final xe.c f33490a;

    /* renamed from: b */
    public final Comparator<String> f33491b;

    public b(xe.c cVar, Comparator<String> comparator) {
        this.f33490a = cVar;
        this.f33491b = comparator;
    }

    @Override // xe.d
    /* renamed from: a */
    public Bitmap get(String str) {
        return this.f33490a.get(str);
    }

    @Override // xe.d
    /* renamed from: b */
    public boolean put(String str, Bitmap bitmap) {
        String str2;
        synchronized (this.f33490a) {
            try {
                Iterator<String> it = this.f33490a.keys().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    str2 = it.next();
                    if (this.f33491b.compare(str, str2) == 0) {
                        break;
                    }
                }
                if (str2 != null) {
                    this.f33490a.remove(str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f33490a.put(str, bitmap);
    }

    @Override // xe.d
    /* renamed from: c */
    public Bitmap remove(String str) {
        return this.f33490a.remove(str);
    }

    @Override // xe.d
    public void clear() {
        this.f33490a.clear();
    }

    @Override // xe.d
    public Collection<String> keys() {
        return this.f33490a.keys();
    }
}
