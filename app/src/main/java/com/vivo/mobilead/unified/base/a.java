package com.vivo.mobilead.unified.base;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.vivo.ad.model.t;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.f;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.util.f1.b implements com.vivo.mobilead.g.b {

    /* renamed from: c */
    private int[] f29701c;

    /* renamed from: d */
    private AtomicInteger f29702d;

    /* renamed from: g */
    private c f29705g;

    /* renamed from: i */
    private HashMap<Integer, t> f29707i;

    /* renamed from: j */
    private f f29708j;

    /* renamed from: a */
    private volatile boolean f29699a = true;

    /* renamed from: b */
    private List<l0> f29700b = new ArrayList(3);

    /* renamed from: e */
    private String f29703e = "聚合广告请求超时";

    /* renamed from: f */
    private int f29704f = 402115;

    /* renamed from: h */
    private SparseArray<String> f29706h = new SparseArray<>();

    /* renamed from: com.vivo.mobilead.unified.base.a$a */
    class C0609a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ int f29709a;

        C0609a(int i2) {
            this.f29709a = i2;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a.this.f29705g.a(Integer.valueOf(this.f29709a));
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {
        b() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a.this.f29705g.a(a.this.f29704f, a.this.f29703e);
        }
    }

    public interface c {
        void a(int i2, String str);

        void a(f fVar);

        void a(Integer num);
    }

    public a(@NonNull HashMap<Integer, t> hashMap, String str, String str2) {
        this.f29707i = hashMap;
        this.f29702d = new AtomicInteger(hashMap.size());
        this.f29708j = a(str, str2);
        a(hashMap);
    }

    @Override // com.vivo.mobilead.util.f1.b
    public void safelyRun() {
        if (this.f29699a) {
            this.f29699a = false;
            b();
            int a2 = a();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.f29706h.size(); i2++) {
                sb.append(",");
                sb.append(this.f29706h.valueAt(i2));
            }
            this.f29708j.f29591b = sb.toString().replaceFirst(",", "");
            if (a2 == -1) {
                c cVar = this.f29705g;
                if (cVar != null) {
                    cVar.a(this.f29708j);
                    this.f29705g.a(this.f29704f, this.f29703e);
                    return;
                }
                return;
            }
            this.f29708j.f29590a = a2 + "";
            if (this.f29705g != null) {
                for (l0 l0Var : this.f29700b) {
                    if (l0Var.e().intValue() == a2) {
                        if (l0Var.i()) {
                            this.f29705g.a(this.f29708j);
                            z.b().a(new C0609a(a2));
                            return;
                        } else {
                            f fVar = this.f29708j;
                            fVar.f29594e = -1;
                            this.f29705g.a(fVar);
                            z.b().a(new b());
                            return;
                        }
                    }
                }
            }
        }
    }

    private void b() {
        Iterator<Map.Entry<Integer, t>> it = this.f29707i.entrySet().iterator();
        int i2 = 10000000;
        while (it.hasNext()) {
            int i3 = it.next().getValue().f26930b;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, t>> it2 = this.f29707i.entrySet().iterator();
        float f2 = 0.0f;
        while (it2.hasNext()) {
            t value = it2.next().getValue();
            if (value.f26930b == i2) {
                f2 += value.f26933e;
                arrayList.add(value);
            }
        }
        int i4 = -1;
        int i5 = 0;
        if (arrayList.size() == 1) {
            i4 = ((t) arrayList.get(0)).f26929a;
        } else if (f2 > 0.0f) {
            int nextInt = new Random().nextInt((int) (f2 * 100.0f));
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                t tVar = (t) it3.next();
                i5 = (int) (i5 + (tVar.f26933e * 100.0f));
                if (nextInt <= i5) {
                    i4 = tVar.f26929a;
                    break;
                }
            }
        }
        this.f29708j.f29593d = i4;
    }

    public void a(int i2) {
        this.f29702d = new AtomicInteger(i2);
    }

    private f a(String str, String str2) {
        f fVar = new f();
        fVar.f29598i = str;
        fVar.f29597h = str2;
        return fVar;
    }

    private void a(HashMap<Integer, t> hashMap) {
        for (Map.Entry<Integer, t> entry : hashMap.entrySet()) {
            this.f29706h.put(entry.getKey().intValue(), entry.getKey() + ":" + c.b.f28917b + ":" + this.f29703e);
        }
    }

    private int a(List<l0> list) {
        if (list != null && list.size() > 0) {
            int i2 = Integer.MAX_VALUE;
            ArrayList<t> arrayList = new ArrayList();
            for (l0 l0Var : list) {
                t tVar = this.f29707i.get(l0Var.e());
                if (l0Var.i() && tVar != null) {
                    arrayList.add(tVar);
                    int i3 = tVar.f26930b;
                    if (i2 > i3) {
                        i2 = i3;
                    }
                }
            }
            if (arrayList.size() > 0) {
                float f2 = 0.0f;
                ArrayList<t> arrayList2 = new ArrayList();
                for (t tVar2 : arrayList) {
                    if (tVar2.f26930b == i2) {
                        f2 += tVar2.f26933e;
                        arrayList2.add(tVar2);
                    }
                }
                int i4 = 0;
                if (arrayList2.size() == 1) {
                    return ((t) arrayList2.get(0)).f26929a;
                }
                int nextInt = new Random().nextInt((int) (f2 * 100.0f));
                for (t tVar3 : arrayList2) {
                    i4 = (int) (i4 + (tVar3.f26933e * 100.0f));
                    if (nextInt <= i4) {
                        return tVar3.f26929a;
                    }
                }
            }
        }
        return -1;
    }

    private int a() {
        int i2;
        if (this.f29700b.size() > 0) {
            int[] iArr = this.f29701c;
            if (iArr == null || iArr.length <= 0) {
                i2 = -1;
            } else {
                i2 = -1;
                for (int i3 : iArr) {
                    Iterator<l0> it = this.f29700b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        l0 next = it.next();
                        if (next.i() && next.e().intValue() == i3) {
                            i2 = next.e().intValue();
                            break;
                        }
                    }
                    if (i2 != -1) {
                        break;
                    }
                }
            }
            if (i2 != -1) {
                this.f29708j.f29594e = i2;
            } else {
                this.f29708j.f29594e = a(this.f29700b);
                f fVar = this.f29708j;
                if (fVar.f29594e == -1) {
                    fVar.f29594e = this.f29700b.get(0).e().intValue();
                }
            }
        }
        return this.f29708j.f29594e;
    }

    @Override // com.vivo.mobilead.g.b
    public void a(l0 l0Var) {
        String str;
        if (this.f29699a) {
            if (l0Var.e().intValue() == c.a.f28912a.intValue()) {
                this.f29701c = l0Var.g();
                if (!TextUtils.isEmpty(l0Var.h())) {
                    this.f29708j.f29596g = l0Var.h();
                }
                this.f29708j.f29595f = l0Var.d();
            }
            if (l0Var.i()) {
                str = l0Var.e() + ":" + c.b.f28916a + ": ";
            } else {
                this.f29703e = l0Var.c();
                this.f29704f = l0Var.b();
                str = l0Var.e() + ":" + c.b.f28917b + ":" + l0Var.c();
            }
            if (TextUtils.isEmpty(this.f29708j.f29592c)) {
                this.f29708j.f29592c = l0Var.b() + "";
            } else {
                StringBuilder sb = new StringBuilder();
                f fVar = this.f29708j;
                sb.append(fVar.f29592c);
                sb.append(":");
                sb.append(l0Var.b());
                fVar.f29592c = sb.toString();
            }
            this.f29706h.put(l0Var.e().intValue(), str);
            this.f29700b.add(l0Var);
            if (this.f29702d.decrementAndGet() == 0) {
                a1.a(this);
                run();
            }
        }
    }

    public void a(c cVar) {
        this.f29705g = cVar;
    }
}
