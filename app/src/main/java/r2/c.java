package r2;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: f */
    public final String f30225f;

    public c(String str) {
        this.f30225f = str;
    }

    @Override // r2.b
    public void a() throws Exception {
        this.f30222a = (byte) 1;
        byte[] bytes = this.f30225f.getBytes("UTF-8");
        this.f30224c = bytes;
        this.f30223b = (byte) bytes.length;
    }
}
