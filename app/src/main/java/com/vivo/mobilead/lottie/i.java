package com.vivo.mobilead.lottie;

import android.util.ArraySet;
import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a */
    private boolean f29487a = false;

    /* renamed from: b */
    private final Set<a> f29488b = new ArraySet();

    /* renamed from: c */
    private final Map<String, com.vivo.mobilead.lottie.f.f> f29489c = new HashMap();

    /* renamed from: d */
    private final Comparator<Pair<String, Float>> f29490d = new Comparator<Pair<String, Float>>() { // from class: com.vivo.mobilead.lottie.i.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* renamed from: com.vivo.mobilead.lottie.i$1 */
    class AnonymousClass1 implements Comparator<Pair<String, Float>> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    public interface a {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.f29487a) {
            com.vivo.mobilead.lottie.f.f fVar = this.f29489c.get(str);
            if (fVar == null) {
                fVar = new com.vivo.mobilead.lottie.f.f();
                this.f29489c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                Iterator<a> it = this.f29488b.iterator();
                while (it.hasNext()) {
                    it.next().a(f2);
                }
            }
        }
    }

    void a(boolean z) {
        this.f29487a = z;
    }
}
