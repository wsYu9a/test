package m1;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/arouter/service/autowired")
/* loaded from: classes.dex */
public class b implements AutowiredService {

    /* renamed from: a */
    public LruCache<String, ISyringe> f28251a;

    /* renamed from: b */
    public List<String> f28252b;

    public final void a(Object obj, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        ISyringe b10 = b(cls);
        if (b10 != null) {
            b10.inject(obj);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass.getName().startsWith("android")) {
            return;
        }
        a(obj, superclass);
    }

    @Override // com.alibaba.android.arouter.facade.service.AutowiredService
    public void autowire(Object obj) {
        a(obj, null);
    }

    public final ISyringe b(Class<?> cls) {
        String name = cls.getName();
        try {
            if (!this.f28252b.contains(name)) {
                ISyringe iSyringe = this.f28251a.get(name);
                if (iSyringe == null) {
                    iSyringe = (ISyringe) Class.forName(cls.getName() + p1.b.f29696g).getConstructor(null).newInstance(null);
                }
                this.f28251a.put(name, iSyringe);
                return iSyringe;
            }
        } catch (Exception unused) {
            this.f28252b.add(name);
        }
        return null;
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        this.f28251a = new LruCache<>(50);
        this.f28252b = new ArrayList();
    }
}
