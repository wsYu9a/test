package com.kwai.filedownloader.e;

/* loaded from: classes2.dex */
public class e {
    public final int aJr;
    public final long aJs;
    public final boolean aJt;
    public final boolean aJu;
    public final int aJv;
    public final boolean aJw;
    public final boolean aJx;

    public static class a {
        private static final e aJy = new e((byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007d A[Catch: all -> 0x01cb, TryCatch #7 {all -> 0x01cb, blocks: (B:55:0x0033, B:58:0x003a, B:61:0x003e, B:64:0x0042, B:67:0x0046, B:70:0x004a, B:74:0x0079, B:76:0x007d, B:78:0x0081, B:80:0x0089), top: B:54:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0089 A[Catch: all -> 0x01cb, TRY_LEAVE, TryCatch #7 {all -> 0x01cb, blocks: (B:55:0x0033, B:58:0x003a, B:61:0x003e, B:64:0x0042, B:67:0x0046, B:70:0x004a, B:74:0x0079, B:76:0x007d, B:78:0x0081, B:80:0x0089), top: B:54:0x0033 }] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.e.e.<init>():void");
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    public static e Jb() {
        return a.aJy;
    }

    public static int dj(int i2) {
        if (i2 > 12) {
            d.h(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
            return 12;
        }
        if (i2 > 0) {
            return i2;
        }
        d.h(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
        return 1;
    }
}
