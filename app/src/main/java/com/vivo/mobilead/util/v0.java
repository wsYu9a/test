package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.vivo.mobilead.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class v0<T> extends com.vivo.mobilead.util.f1.b implements com.vivo.mobilead.g.b {

    /* renamed from: b */
    private HashMap<Integer, com.vivo.ad.model.t> f30780b;

    /* renamed from: c */
    private HashMap<Integer, T> f30781c;

    /* renamed from: e */
    private int[] f30783e;

    /* renamed from: f */
    private AtomicInteger f30784f;

    /* renamed from: i */
    private a f30787i;
    private com.vivo.mobilead.model.f k;

    /* renamed from: a */
    private volatile boolean f30779a = true;

    /* renamed from: d */
    private List<l0> f30782d = new ArrayList(2);

    /* renamed from: g */
    private String f30785g = "请求耗费时间太长，请检查网络状态是否良好";

    /* renamed from: h */
    private int f30786h = 40213;

    /* renamed from: j */
    private HashMap<Integer, String> f30788j = new HashMap<>();

    public interface a {
        void a(int i2, String str);

        void a(com.vivo.mobilead.model.f fVar);

        void a(Integer num);
    }

    public v0(HashMap<Integer, com.vivo.ad.model.t> hashMap, HashMap<Integer, T> hashMap2, String str, String str2) {
        this.f30780b = hashMap;
        this.f30781c = hashMap2;
        this.f30784f = new AtomicInteger(this.f30781c.size());
        this.k = a(str, str2);
        a(hashMap2);
    }

    private void b() {
        Iterator<Map.Entry<Integer, com.vivo.ad.model.t>> it = this.f30780b.entrySet().iterator();
        int i2 = 10000000;
        while (it.hasNext()) {
            int i3 = it.next().getValue().f26930b;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, com.vivo.ad.model.t>> it2 = this.f30780b.entrySet().iterator();
        float f2 = 0.0f;
        while (it2.hasNext()) {
            com.vivo.ad.model.t value = it2.next().getValue();
            if (value.f26930b == i2) {
                f2 += value.f26933e;
                arrayList.add(value);
            }
        }
        int i4 = -1;
        int i5 = 0;
        if (arrayList.size() == 1) {
            i4 = ((com.vivo.ad.model.t) arrayList.get(0)).f26929a;
        } else if (f2 > 0.0f) {
            int nextInt = new Random().nextInt((int) (f2 * 100.0f));
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                com.vivo.ad.model.t tVar = (com.vivo.ad.model.t) it3.next();
                i5 = (int) (i5 + (tVar.f26933e * 100.0f));
                if (nextInt <= i5) {
                    i4 = tVar.f26929a;
                    break;
                }
            }
        }
        this.k.f29593d = i4;
    }

    public void a(int i2) {
        this.f30784f = new AtomicInteger(i2);
    }

    @Override // com.vivo.mobilead.util.f1.b
    public void safelyRun() {
        if (this.f30779a) {
            this.f30779a = false;
            b();
            int a2 = a();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : this.f30788j.entrySet()) {
                sb.append(",");
                sb.append(entry.getValue());
            }
            this.k.f29591b = sb.toString().replaceFirst(",", "");
            if (a2 == -1) {
                a aVar = this.f30787i;
                if (aVar != null) {
                    aVar.a(this.k);
                    this.f30787i.a(this.f30786h, this.f30785g);
                    return;
                }
                return;
            }
            this.k.f29590a = a2 + "";
            if (this.f30787i != null) {
                for (l0 l0Var : this.f30782d) {
                    if (l0Var.e().intValue() == a2) {
                        if (l0Var.i()) {
                            this.k.f29599j = l0Var.a();
                            this.f30787i.a(this.k);
                            this.f30787i.a(Integer.valueOf(a2));
                            return;
                        }
                        com.vivo.mobilead.model.f fVar = this.k;
                        fVar.f29594e = -1;
                        this.f30787i.a(fVar);
                        this.f30787i.a(this.f30786h, this.f30785g);
                        return;
                    }
                }
            }
        }
    }

    private com.vivo.mobilead.model.f a(String str, String str2) {
        com.vivo.mobilead.model.f fVar = new com.vivo.mobilead.model.f();
        fVar.f29598i = str;
        fVar.f29597h = str2;
        return fVar;
    }

    private void a(HashMap<Integer, T> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<Integer, T> entry : hashMap.entrySet()) {
                this.f30788j.put(entry.getKey(), entry.getKey() + ":" + c.b.f28917b + ":" + this.f30785g);
            }
        }
    }

    private int a(List<l0> list) {
        if (list != null && list.size() > 0) {
            int i2 = Integer.MAX_VALUE;
            ArrayList<com.vivo.ad.model.t> arrayList = new ArrayList();
            for (l0 l0Var : list) {
                com.vivo.ad.model.t tVar = this.f30780b.get(l0Var.e());
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
                ArrayList<com.vivo.ad.model.t> arrayList2 = new ArrayList();
                for (com.vivo.ad.model.t tVar2 : arrayList) {
                    if (tVar2.f26930b == i2) {
                        f2 += tVar2.f26933e;
                        arrayList2.add(tVar2);
                    }
                }
                int i4 = 0;
                if (arrayList2.size() == 1) {
                    return ((com.vivo.ad.model.t) arrayList2.get(0)).f26929a;
                }
                int nextInt = new Random().nextInt((int) (f2 * 100.0f));
                for (com.vivo.ad.model.t tVar3 : arrayList2) {
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
        if (this.f30782d.size() > 0) {
            int[] iArr = this.f30783e;
            if (iArr == null || iArr.length <= 0) {
                i2 = -1;
            } else {
                i2 = -1;
                for (int i3 : iArr) {
                    Iterator<l0> it = this.f30782d.iterator();
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
                this.k.f29594e = i2;
            } else {
                this.k.f29594e = a(this.f30782d);
                com.vivo.mobilead.model.f fVar = this.k;
                if (fVar.f29594e == -1) {
                    fVar.f29594e = this.f30782d.get(0).e().intValue();
                }
            }
        }
        return this.k.f29594e;
    }

    @Override // com.vivo.mobilead.g.b
    public void a(l0 l0Var) {
        String str;
        if (this.f30779a) {
            if (l0Var.e().intValue() == c.a.f28912a.intValue()) {
                this.f30783e = l0Var.g();
                if (!TextUtils.isEmpty(l0Var.h())) {
                    this.k.f29596g = l0Var.h();
                }
                this.k.f29595f = l0Var.d();
                if (!TextUtils.isEmpty(l0Var.f())) {
                    this.k.f29598i = l0Var.f();
                }
            }
            if (l0Var.i()) {
                str = l0Var.e() + ":" + c.b.f28916a + ": ";
            } else {
                this.f30785g = l0Var.c();
                this.f30786h = l0Var.b();
                str = l0Var.e() + ":" + c.b.f28917b + ":" + l0Var.c();
            }
            if (TextUtils.isEmpty(this.k.f29592c)) {
                this.k.f29592c = l0Var.b() + "";
            } else {
                StringBuilder sb = new StringBuilder();
                com.vivo.mobilead.model.f fVar = this.k;
                sb.append(fVar.f29592c);
                sb.append(":");
                sb.append(l0Var.b());
                fVar.f29592c = sb.toString();
            }
            this.f30788j.put(l0Var.e(), str);
            this.f30782d.add(l0Var);
            if (this.f30784f.decrementAndGet() == 0) {
                z.b().a().removeCallbacks(this);
                run();
            }
        }
    }

    public void a(a aVar) {
        this.f30787i = aVar;
    }
}
