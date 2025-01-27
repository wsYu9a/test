package com.vivo.mobilead.util.d1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: f */
    static final InterfaceC0667c f30585f = new a();

    /* renamed from: a */
    private final List<e> f30586a;

    /* renamed from: b */
    private final List<com.vivo.mobilead.util.d1.d> f30587b;

    /* renamed from: d */
    private final SparseBooleanArray f30589d = new SparseBooleanArray();

    /* renamed from: c */
    private final Map<com.vivo.mobilead.util.d1.d, e> f30588c = new HashMap();

    /* renamed from: e */
    private final e f30590e = b();

    static class a implements InterfaceC0667c {
        a() {
        }

        private boolean b(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean c(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // com.vivo.mobilead.util.d1.c.InterfaceC0667c
        public boolean a(int i2, float[] fArr) {
            return (c(fArr) || a(fArr) || b(fArr)) ? false : true;
        }

        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }
    }

    public static final class b {

        /* renamed from: a */
        private final List<e> f30591a;

        /* renamed from: b */
        private final Bitmap f30592b;

        /* renamed from: c */
        private final List<com.vivo.mobilead.util.d1.d> f30593c;

        /* renamed from: d */
        private int f30594d;

        /* renamed from: e */
        private int f30595e;

        /* renamed from: f */
        private int f30596f;

        /* renamed from: g */
        private final List<InterfaceC0667c> f30597g;

        /* renamed from: h */
        private Rect f30598h;

        public b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f30593c = arrayList;
            this.f30594d = 16;
            this.f30595e = 12544;
            this.f30596f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f30597g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(c.f30585f);
            this.f30592b = bitmap;
            this.f30591a = null;
            arrayList.add(com.vivo.mobilead.util.d1.d.f30610e);
            arrayList.add(com.vivo.mobilead.util.d1.d.f30611f);
            arrayList.add(com.vivo.mobilead.util.d1.d.f30612g);
            arrayList.add(com.vivo.mobilead.util.d1.d.f30613h);
            arrayList.add(com.vivo.mobilead.util.d1.d.f30614i);
            arrayList.add(com.vivo.mobilead.util.d1.d.f30615j);
        }

        private Bitmap b(Bitmap bitmap) {
            int max;
            int i2;
            double d2;
            if (this.f30595e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.f30595e;
                if (width > i3) {
                    double d3 = i3;
                    double d4 = width;
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    d2 = Math.sqrt(d3 / d4);
                }
                d2 = -1.0d;
            } else {
                if (this.f30596f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.f30596f)) {
                    double d5 = i2;
                    double d6 = max;
                    Double.isNaN(d5);
                    Double.isNaN(d6);
                    d2 = d5 / d6;
                }
                d2 = -1.0d;
            }
            if (d2 <= 0.0d) {
                return bitmap;
            }
            double width2 = bitmap.getWidth();
            Double.isNaN(width2);
            int ceil = (int) Math.ceil(width2 * d2);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d2), false);
        }

        public c a() {
            List<e> list;
            InterfaceC0667c[] interfaceC0667cArr;
            Bitmap bitmap = this.f30592b;
            if (bitmap != null) {
                Bitmap b2 = b(bitmap);
                Rect rect = this.f30598h;
                if (b2 != this.f30592b && rect != null) {
                    double width = b2.getWidth();
                    double width2 = this.f30592b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d2 = width / width2;
                    double d3 = rect.left;
                    Double.isNaN(d3);
                    rect.left = (int) Math.floor(d3 * d2);
                    double d4 = rect.top;
                    Double.isNaN(d4);
                    rect.top = (int) Math.floor(d4 * d2);
                    double d5 = rect.right;
                    Double.isNaN(d5);
                    rect.right = Math.min((int) Math.ceil(d5 * d2), b2.getWidth());
                    double d6 = rect.bottom;
                    Double.isNaN(d6);
                    rect.bottom = Math.min((int) Math.ceil(d6 * d2), b2.getHeight());
                }
                int[] a2 = a(b2);
                int i2 = this.f30594d;
                if (this.f30597g.isEmpty()) {
                    interfaceC0667cArr = null;
                } else {
                    List<InterfaceC0667c> list2 = this.f30597g;
                    interfaceC0667cArr = (InterfaceC0667c[]) list2.toArray(new InterfaceC0667c[list2.size()]);
                }
                com.vivo.mobilead.util.d1.a aVar = new com.vivo.mobilead.util.d1.a(a2, i2, interfaceC0667cArr);
                if (b2 != this.f30592b) {
                    b2.recycle();
                }
                list = aVar.a();
            } else {
                list = this.f30591a;
            }
            c cVar = new c(list, this.f30593c);
            cVar.a();
            return cVar;
        }

        class a extends AsyncTask<Bitmap, Void, c> {

            /* renamed from: a */
            final /* synthetic */ d f30599a;

            a(d dVar) {
                this.f30599a = dVar;
            }

            @Override // android.os.AsyncTask
            /* renamed from: a */
            public c doInBackground(Bitmap... bitmapArr) {
                try {
                    return b.this.a();
                } catch (Exception e2) {
                    Log.e("Palette", "Exception thrown during async generate", e2);
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(c cVar) {
                this.f30599a.a(cVar);
            }
        }

        public AsyncTask<Bitmap, Void, c> a(d dVar) {
            if (dVar != null) {
                return new a(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f30592b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        private int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f30598h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f30598h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i2 = 0; i2 < height2; i2++) {
                Rect rect2 = this.f30598h;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }
    }

    /* renamed from: com.vivo.mobilead.util.d1.c$c */
    public interface InterfaceC0667c {
        boolean a(int i2, float[] fArr);
    }

    public interface d {
        void a(c cVar);
    }

    public static final class e {

        /* renamed from: a */
        private final int f30601a;

        /* renamed from: b */
        private final int f30602b;

        /* renamed from: c */
        private final int f30603c;

        /* renamed from: d */
        private final int f30604d;

        /* renamed from: e */
        private final int f30605e;

        /* renamed from: f */
        private boolean f30606f;

        /* renamed from: g */
        private int f30607g;

        /* renamed from: h */
        private int f30608h;

        /* renamed from: i */
        private float[] f30609i;

        public e(int i2, int i3) {
            this.f30601a = Color.red(i2);
            this.f30602b = Color.green(i2);
            this.f30603c = Color.blue(i2);
            this.f30604d = i2;
            this.f30605e = i3;
        }

        private void f() {
            if (this.f30606f) {
                return;
            }
            int a2 = com.vivo.mobilead.util.d1.b.a(-1, this.f30604d, 4.5f);
            int a3 = com.vivo.mobilead.util.d1.b.a(-1, this.f30604d, 3.0f);
            if (a2 != -1 && a3 != -1) {
                this.f30608h = com.vivo.mobilead.util.d1.b.d(-1, a2);
                this.f30607g = com.vivo.mobilead.util.d1.b.d(-1, a3);
                this.f30606f = true;
                return;
            }
            int a4 = com.vivo.mobilead.util.d1.b.a(-16777216, this.f30604d, 4.5f);
            int a5 = com.vivo.mobilead.util.d1.b.a(-16777216, this.f30604d, 3.0f);
            if (a4 == -1 || a5 == -1) {
                this.f30608h = a2 != -1 ? com.vivo.mobilead.util.d1.b.d(-1, a2) : com.vivo.mobilead.util.d1.b.d(-16777216, a4);
                this.f30607g = a3 != -1 ? com.vivo.mobilead.util.d1.b.d(-1, a3) : com.vivo.mobilead.util.d1.b.d(-16777216, a5);
                this.f30606f = true;
            } else {
                this.f30608h = com.vivo.mobilead.util.d1.b.d(-16777216, a4);
                this.f30607g = com.vivo.mobilead.util.d1.b.d(-16777216, a5);
                this.f30606f = true;
            }
        }

        public int a() {
            f();
            return this.f30608h;
        }

        public float[] b() {
            if (this.f30609i == null) {
                this.f30609i = new float[3];
            }
            com.vivo.mobilead.util.d1.b.a(this.f30601a, this.f30602b, this.f30603c, this.f30609i);
            return this.f30609i;
        }

        public int c() {
            return this.f30605e;
        }

        public int d() {
            return this.f30604d;
        }

        public int e() {
            f();
            return this.f30607g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f30605e == eVar.f30605e && this.f30604d == eVar.f30604d;
        }

        public int hashCode() {
            return (this.f30604d * 31) + this.f30605e;
        }

        public String toString() {
            return e.class.getSimpleName() + " [RGB: #" + Integer.toHexString(d()) + "] [HSL: " + Arrays.toString(b()) + "] [Population: " + this.f30605e + "] [Title Text: #" + Integer.toHexString(e()) + "] [Body Text: #" + Integer.toHexString(a()) + ']';
        }
    }

    c(List<e> list, List<com.vivo.mobilead.util.d1.d> list2) {
        this.f30586a = list;
        this.f30587b = list2;
    }

    private e b(com.vivo.mobilead.util.d1.d dVar) {
        int size = this.f30586a.size();
        float f2 = 0.0f;
        e eVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar2 = this.f30586a.get(i2);
            if (b(eVar2, dVar)) {
                float a2 = a(eVar2, dVar);
                if (eVar == null || a2 > f2) {
                    eVar = eVar2;
                    f2 = a2;
                }
            }
        }
        return eVar;
    }

    public int a(int i2) {
        e eVar = this.f30590e;
        return eVar != null ? eVar.d() : i2;
    }

    void a() {
        int size = this.f30587b.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.vivo.mobilead.util.d1.d dVar = this.f30587b.get(i2);
            dVar.k();
            this.f30588c.put(dVar, a(dVar));
        }
        this.f30589d.clear();
    }

    private boolean b(e eVar, com.vivo.mobilead.util.d1.d dVar) {
        float[] b2 = eVar.b();
        return b2[1] >= dVar.e() && b2[1] <= dVar.c() && b2[2] >= dVar.d() && b2[2] <= dVar.b() && !this.f30589d.get(eVar.d());
    }

    private e a(com.vivo.mobilead.util.d1.d dVar) {
        e b2 = b(dVar);
        if (b2 != null && dVar.j()) {
            this.f30589d.append(b2.d(), true);
        }
        return b2;
    }

    private e b() {
        int size = this.f30586a.size();
        int i2 = Integer.MIN_VALUE;
        e eVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar2 = this.f30586a.get(i3);
            if (eVar2.c() > i2) {
                i2 = eVar2.c();
                eVar = eVar2;
            }
        }
        return eVar;
    }

    private float a(e eVar, com.vivo.mobilead.util.d1.d dVar) {
        float[] b2 = eVar.b();
        e eVar2 = this.f30590e;
        return (dVar.g() > 0.0f ? dVar.g() * (1.0f - Math.abs(b2[1] - dVar.i())) : 0.0f) + (dVar.a() > 0.0f ? dVar.a() * (1.0f - Math.abs(b2[2] - dVar.h())) : 0.0f) + (dVar.f() > 0.0f ? dVar.f() * (eVar.c() / (eVar2 != null ? eVar2.c() : 1)) : 0.0f);
    }
}
