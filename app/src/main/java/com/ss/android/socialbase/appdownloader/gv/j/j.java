package com.ss.android.socialbase.appdownloader.gv.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
class j implements k {

    /* renamed from: g */
    private gv f24451g;
    private int k;
    private boolean lg;
    private int[] nt;
    private int p;
    private int pa;
    private int[] q;
    private int r;
    private int t;
    private int w;
    private int y;
    private g zx;

    /* renamed from: i */
    private boolean f24452i = false;
    private C0509j gv = new C0509j();

    public j() {
        lg();
    }

    private final void lg() {
        this.y = -1;
        this.k = -1;
        this.pa = -1;
        this.t = -1;
        this.nt = null;
        this.p = -1;
        this.r = -1;
        this.w = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x018e, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.gv.j.j.y():void");
    }

    @Override // com.ss.android.socialbase.appdownloader.gv.j.lg
    public String g() {
        return "XML line #" + i();
    }

    @Override // com.ss.android.socialbase.appdownloader.gv.j.lg
    public int gv() {
        return -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.gv.j.lg
    public int i() {
        return this.k;
    }

    public void j(InputStream inputStream) {
        j();
        if (inputStream != null) {
            this.zx = new g(inputStream, false);
        }
    }

    public int q() {
        if (this.y != 2) {
            return -1;
        }
        return this.nt.length / 5;
    }

    public int zx() throws y, IOException {
        if (this.zx == null) {
            throw new y("Parser is not opened.", this, null);
        }
        try {
            y();
            return this.y;
        } catch (IOException e2) {
            j();
            throw e2;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.gv.j.j$j */
    private static final class C0509j {

        /* renamed from: i */
        private int f24453i;

        /* renamed from: j */
        private int[] f24454j = new int[32];
        private int zx;

        public final int g() {
            return this.f24453i;
        }

        public final void gv() {
            int i2 = this.zx;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.f24454j[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.zx = i2 - (i4 + 2);
                    this.f24453i--;
                }
            }
        }

        public final boolean i() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.zx;
            if (i4 == 0 || (i3 = (iArr = this.f24454j)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.zx = i4 - 2;
            return true;
        }

        public final void j() {
            this.zx = 0;
            this.f24453i = 0;
        }

        public final void q() {
            j(2);
            int i2 = this.zx;
            int[] iArr = this.f24454j;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.zx = i2 + 2;
            this.f24453i++;
        }

        public final int zx() {
            int i2 = this.zx;
            if (i2 == 0) {
                return 0;
            }
            return this.f24454j[i2 - 1];
        }

        public final void j(int i2, int i3) {
            if (this.f24453i == 0) {
                q();
            }
            j(2);
            int i4 = this.zx;
            int i5 = i4 - 1;
            int[] iArr = this.f24454j;
            int i6 = iArr[i5];
            int i7 = (i5 - 1) - (i6 * 2);
            int i8 = i6 + 1;
            iArr[i7] = i8;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i8;
            this.zx = i4 + 2;
        }

        private void j(int i2) {
            int[] iArr = this.f24454j;
            int length = iArr.length;
            int i3 = this.zx;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.f24454j = iArr2;
            }
        }
    }

    private final int q(int i2) {
        if (this.y != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.nt.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public String g(int i2) {
        int q = q(i2);
        int[] iArr = this.nt;
        if (iArr[q + 3] == 3) {
            return this.f24451g.j(iArr[q + 2]);
        }
        int i3 = iArr[q + 4];
        return "";
    }

    public int i(int i2) {
        return this.nt[q(i2) + 4];
    }

    public void j() {
        if (this.f24452i) {
            this.f24452i = false;
            this.zx.j();
            this.zx = null;
            this.f24451g = null;
            this.q = null;
            this.gv.j();
            lg();
        }
    }

    public int zx(int i2) {
        return this.nt[q(i2) + 3];
    }

    public String j(int i2) {
        int i3 = this.nt[q(i2) + 1];
        return i3 == -1 ? "" : this.f24451g.j(i3);
    }
}
