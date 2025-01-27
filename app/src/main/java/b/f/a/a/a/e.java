package b.f.a.a.a;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public final class e extends com.google.zxing.e {

    /* renamed from: c */
    private final byte[] f4819c;

    /* renamed from: d */
    private final int f4820d;

    /* renamed from: e */
    private final int f4821e;

    /* renamed from: f */
    private final int f4822f;

    /* renamed from: g */
    private final int f4823g;

    public e(byte[] yuvData, int dataWidth, int dataHeight, int left, int top, int width, int height) {
        super(width, height);
        if (width + left > dataWidth || height + top > dataHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f4819c = yuvData;
        this.f4820d = dataWidth;
        this.f4821e = dataHeight;
        this.f4822f = left;
        this.f4823g = top;
    }

    @Override // com.google.zxing.e
    public byte[] c() {
        int e2 = e();
        int b2 = b();
        int i2 = this.f4820d;
        if (e2 == i2 && b2 == this.f4821e) {
            return this.f4819c;
        }
        int i3 = e2 * b2;
        byte[] bArr = new byte[i3];
        int i4 = (this.f4823g * i2) + this.f4822f;
        if (e2 == i2) {
            System.arraycopy(this.f4819c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < b2; i5++) {
            System.arraycopy(this.f4819c, i4, bArr, i5 * e2, e2);
            i4 += this.f4820d;
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] d(int y, byte[] row) {
        if (y < 0 || y >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + y);
        }
        int e2 = e();
        if (row == null || row.length < e2) {
            row = new byte[e2];
        }
        System.arraycopy(this.f4819c, ((y + this.f4823g) * this.f4820d) + this.f4822f, row, 0, e2);
        return row;
    }

    @Override // com.google.zxing.e
    public boolean g() {
        return true;
    }

    public int k() {
        return this.f4821e;
    }

    public int l() {
        return this.f4820d;
    }

    public Bitmap m() {
        int e2 = e();
        int b2 = b();
        int[] iArr = new int[e2 * b2];
        int i2 = (this.f4823g * this.f4820d) + this.f4822f;
        for (int i3 = 0; i3 < b2; i3++) {
            int i4 = i3 * e2;
            for (int i5 = 0; i5 < e2; i5++) {
                iArr[i4 + i5] = ((this.f4819c[i2 + i5] & 255) * 65793) | (-16777216);
            }
            i2 += this.f4820d;
        }
        Bitmap createBitmap = Bitmap.createBitmap(e2, b2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, e2, 0, 0, e2, b2);
        return createBitmap;
    }
}
