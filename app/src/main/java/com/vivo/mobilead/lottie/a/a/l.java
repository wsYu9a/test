package com.vivo.mobilead.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.vivo.mobilead.lottie.c.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes4.dex */
public class l implements j, m {

    /* renamed from: d */
    private final String f29017d;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.c.b.h f29019f;

    /* renamed from: a */
    private final Path f29014a = new Path();

    /* renamed from: b */
    private final Path f29015b = new Path();

    /* renamed from: c */
    private final Path f29016c = new Path();

    /* renamed from: e */
    private final List<m> f29018e = new ArrayList();

    /* renamed from: com.vivo.mobilead.lottie.a.a.l$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29020a;

        static {
            int[] iArr = new int[h.a.values().length];
            f29020a = iArr;
            try {
                iArr[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29020a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29020a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29020a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29020a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(com.vivo.mobilead.lottie.c.b.h hVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f29017d = hVar.a();
        this.f29019f = hVar;
    }

    private void a() {
        for (int i2 = 0; i2 < this.f29018e.size(); i2++) {
            this.f29016c.addPath(this.f29018e.get(i2).e());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f29015b.reset();
        this.f29014a.reset();
        for (int size = this.f29018e.size() - 1; size >= 1; size--) {
            m mVar = this.f29018e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> c2 = dVar.c();
                for (int size2 = c2.size() - 1; size2 >= 0; size2--) {
                    Path e2 = c2.get(size2).e();
                    e2.transform(dVar.d());
                    this.f29015b.addPath(e2);
                }
            } else {
                this.f29015b.addPath(mVar.e());
            }
        }
        m mVar2 = this.f29018e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> c3 = dVar2.c();
            for (int i2 = 0; i2 < c3.size(); i2++) {
                Path e3 = c3.get(i2).e();
                e3.transform(dVar2.d());
                this.f29014a.addPath(e3);
            }
        } else {
            this.f29014a.set(mVar2.e());
        }
        this.f29016c.op(this.f29014a, this.f29015b, op);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f29018e.size(); i2++) {
            this.f29018e.get(i2).a(list, list2);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.j
    public void a(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f29018e.add((m) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29017d;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        Path.Op op;
        this.f29016c.reset();
        if (this.f29019f.c()) {
            return this.f29016c;
        }
        int i2 = AnonymousClass1.f29020a[this.f29019f.b().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                op = Path.Op.UNION;
            } else if (i2 == 3) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (i2 == 4) {
                op = Path.Op.INTERSECT;
            } else if (i2 == 5) {
                op = Path.Op.XOR;
            }
            a(op);
        } else {
            a();
        }
        return this.f29016c;
    }
}
