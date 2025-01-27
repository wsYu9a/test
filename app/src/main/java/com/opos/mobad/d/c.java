package com.opos.mobad.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.opos.cmn.i.c;
import com.opos.mobad.c.a;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes4.dex */
public class c implements com.opos.mobad.c.a {

    /* renamed from: a */
    private f f20456a;

    /* renamed from: b */
    private LruCache<String, Buffer> f20457b;

    /* renamed from: c */
    private LruCache<String, WeakReference<Buffer>> f20458c;

    /* renamed from: com.opos.mobad.d.c$1 */
    class AnonymousClass1 implements c.a<String, Buffer> {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.c.a
        public void a(String str, Buffer buffer) {
            c.this.f20458c.put(str, new WeakReference(buffer));
        }
    }

    /* renamed from: com.opos.mobad.d.c$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f20460a;

        /* renamed from: b */
        final /* synthetic */ Buffer f20461b;

        AnonymousClass2(File file, Buffer buffer) {
            file = file;
            buffer = buffer;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedSink bufferedSink = null;
            try {
                try {
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        File b2 = c.this.b(file);
                        if (b2.exists()) {
                            b2.delete();
                        }
                        bufferedSink = Okio.buffer(Okio.sink(b2));
                        bufferedSink.writeAll(buffer);
                        b2.renameTo(file);
                        bufferedSink.flush();
                        bufferedSink.close();
                        buffer.close();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("fCache", "write fail", e2);
                        if (bufferedSink != null) {
                            bufferedSink.flush();
                            bufferedSink.close();
                        }
                        buffer.close();
                    }
                } catch (Throwable th) {
                    if (bufferedSink != null) {
                        try {
                            bufferedSink.flush();
                            bufferedSink.close();
                        } catch (Exception e3) {
                            com.opos.cmn.an.f.a.b("fCache", "", e3);
                            throw th;
                        }
                    }
                    buffer.close();
                    throw th;
                }
            } catch (Exception e4) {
                com.opos.cmn.an.f.a.b("fCache", "", e4);
            }
        }
    }

    /* renamed from: com.opos.mobad.d.c$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f20463a;

        /* renamed from: b */
        final /* synthetic */ String f20464b;

        /* renamed from: c */
        final /* synthetic */ int f20465c;

        /* renamed from: d */
        final /* synthetic */ int f20466d;

        /* renamed from: e */
        final /* synthetic */ a.InterfaceC0426a f20467e;

        AnonymousClass3(File file, String str, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
            file = file;
            str = str;
            i2 = i2;
            i3 = i3;
            interfaceC0426a = interfaceC0426a;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference weakReference;
            try {
                Buffer buffer = (Buffer) c.this.f20457b.remove(file.getAbsolutePath());
                if (buffer == null && (weakReference = (WeakReference) c.this.f20458c.get(file.getAbsolutePath())) != null) {
                    buffer = (Buffer) weakReference.get();
                }
                Buffer buffer2 = buffer;
                if (buffer2 != null) {
                    com.opos.cmn.an.f.a.b("fCache", "decode cache");
                    if (c.this.a(buffer2, str, i2, i3, interfaceC0426a)) {
                        return;
                    } else {
                        com.opos.cmn.an.f.a.c("fCache", "decode cache fail");
                    }
                }
                com.opos.cmn.an.f.a.b("fCache", "decode file");
                if (c.this.b(file, str, i2, i3, interfaceC0426a)) {
                    return;
                }
            } catch (Throwable th) {
                Log.d("fCache", "decode fail", th);
            }
            a.InterfaceC0426a interfaceC0426a = interfaceC0426a;
            if (interfaceC0426a != null) {
                interfaceC0426a.a(2, null);
            }
        }
    }

    c(Context context) {
        this(new g(context));
    }

    c(f fVar) {
        this.f20456a = fVar;
        this.f20458c = new LruCache<>(50);
        this.f20457b = new com.opos.cmn.i.c(20, new c.a<String, Buffer>() { // from class: com.opos.mobad.d.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.cmn.i.c.a
            public void a(String str, Buffer buffer) {
                c.this.f20458c.put(str, new WeakReference(buffer));
            }
        });
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = 1;
        if (options != null) {
            try {
                int i5 = options.outHeight;
                int i6 = options.outWidth;
                com.opos.cmn.an.f.a.b("fCache", "options.outHeight=" + i5 + ",options.outWidth=" + i6);
                if (i5 > i3 || i6 > i2) {
                    int i7 = i5 / 2;
                    int i8 = i6 / 2;
                    while (i7 / i4 > i3 && i8 / i4 > i2) {
                        i4 *= 2;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("fCache", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "calculateInSampleSize reqWidth=" + i2 + ",reqHeight=" + i3 + ",inSampleSize=" + i4);
        return i4;
    }

    public static Bitmap a(InputStream inputStream) {
        Bitmap bitmap = null;
        if (inputStream != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("fCache", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "decodeSampledBitmapFromStream res=" + inputStream + ",dst:" + bitmap);
        return bitmap;
    }

    public static Bitmap a(Buffer buffer, int i2, int i3) {
        Bitmap bitmap = null;
        if (buffer != null) {
            try {
                Buffer clone = buffer.clone();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(buffer.inputStream(), null, options);
                options.inSampleSize = a(options, i2, i3);
                options.inJustDecodeBounds = false;
                bitmap = com.opos.cmn.an.d.c.a.a(BitmapFactory.decodeStream(clone.inputStream(), null, options), i2, i3, options.inSampleSize);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeSampledBitmapFromStream res=");
        Object obj = buffer;
        if (buffer == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(",reqWidth=");
        sb.append(i2);
        sb.append(",reqHeight=");
        sb.append(i3);
        sb.append(",dst=");
        sb.append(bitmap != null ? bitmap : "null");
        com.opos.cmn.an.f.a.b("BitmapTool", sb.toString());
        return bitmap;
    }

    private final File a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? this.f20456a.a(str) : this.f20456a.a(str, str2);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("fCache", "close", e2);
            }
        }
    }

    private void a(File file, String str, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.c.3

            /* renamed from: a */
            final /* synthetic */ File f20463a;

            /* renamed from: b */
            final /* synthetic */ String f20464b;

            /* renamed from: c */
            final /* synthetic */ int f20465c;

            /* renamed from: d */
            final /* synthetic */ int f20466d;

            /* renamed from: e */
            final /* synthetic */ a.InterfaceC0426a f20467e;

            AnonymousClass3(File file2, String str2, int i22, int i32, a.InterfaceC0426a interfaceC0426a2) {
                file = file2;
                str = str2;
                i2 = i22;
                i3 = i32;
                interfaceC0426a = interfaceC0426a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WeakReference weakReference;
                try {
                    Buffer buffer = (Buffer) c.this.f20457b.remove(file.getAbsolutePath());
                    if (buffer == null && (weakReference = (WeakReference) c.this.f20458c.get(file.getAbsolutePath())) != null) {
                        buffer = (Buffer) weakReference.get();
                    }
                    Buffer buffer2 = buffer;
                    if (buffer2 != null) {
                        com.opos.cmn.an.f.a.b("fCache", "decode cache");
                        if (c.this.a(buffer2, str, i2, i3, interfaceC0426a)) {
                            return;
                        } else {
                            com.opos.cmn.an.f.a.c("fCache", "decode cache fail");
                        }
                    }
                    com.opos.cmn.an.f.a.b("fCache", "decode file");
                    if (c.this.b(file, str, i2, i3, interfaceC0426a)) {
                        return;
                    }
                } catch (Throwable th) {
                    Log.d("fCache", "decode fail", th);
                }
                a.InterfaceC0426a interfaceC0426a2 = interfaceC0426a;
                if (interfaceC0426a2 != null) {
                    interfaceC0426a2.a(2, null);
                }
            }
        });
    }

    private void a(Buffer buffer, File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.c.2

            /* renamed from: a */
            final /* synthetic */ File f20460a;

            /* renamed from: b */
            final /* synthetic */ Buffer f20461b;

            AnonymousClass2(File file2, Buffer buffer2) {
                file = file2;
                buffer = buffer2;
            }

            @Override // java.lang.Runnable
            public void run() {
                BufferedSink bufferedSink = null;
                try {
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            File b2 = c.this.b(file);
                            if (b2.exists()) {
                                b2.delete();
                            }
                            bufferedSink = Okio.buffer(Okio.sink(b2));
                            bufferedSink.writeAll(buffer);
                            b2.renameTo(file);
                            bufferedSink.flush();
                            bufferedSink.close();
                            buffer.close();
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("fCache", "write fail", e2);
                            if (bufferedSink != null) {
                                bufferedSink.flush();
                                bufferedSink.close();
                            }
                            buffer.close();
                        }
                    } catch (Throwable th) {
                        if (bufferedSink != null) {
                            try {
                                bufferedSink.flush();
                                bufferedSink.close();
                            } catch (Exception e3) {
                                com.opos.cmn.an.f.a.b("fCache", "", e3);
                                throw th;
                            }
                        }
                        buffer.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.b("fCache", "", e4);
                }
            }
        });
    }

    private boolean a(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Buffer buffer = null;
        try {
            try {
                buffer = a(file);
                boolean a2 = a(buffer, str);
                if (a2) {
                    this.f20457b.put(file.getAbsolutePath(), buffer);
                }
                if (buffer != null) {
                    buffer.close();
                }
                return a2;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("fCache", "check fail", e2);
                if (buffer == null) {
                    return false;
                }
                buffer.close();
                return false;
            }
        } catch (Throwable th) {
            if (buffer != null) {
                buffer.close();
            }
            throw th;
        }
    }

    private boolean a(Buffer buffer, String str) {
        return buffer.md5().hex().equals(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        return false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(okio.Buffer r5, java.lang.String r6, int r7, int r8, com.opos.mobad.c.a.InterfaceC0426a r9) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto L1a
            okio.Buffer r1 = r5.clone()     // Catch: java.lang.Throwable -> L42
            okio.ByteString r3 = r1.md5()     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = r3.hex()     // Catch: java.lang.Throwable -> L42
            boolean r6 = r3.equals(r6)     // Catch: java.lang.Throwable -> L42
            goto L1b
        L1a:
            r6 = 1
        L1b:
            if (r7 <= 0) goto L25
            if (r8 > 0) goto L20
            goto L25
        L20:
            android.graphics.Bitmap r7 = a(r5, r7, r8)     // Catch: java.lang.Throwable -> L42
            goto L2d
        L25:
            java.io.InputStream r7 = r5.inputStream()     // Catch: java.lang.Throwable -> L42
            android.graphics.Bitmap r7 = a(r7)     // Catch: java.lang.Throwable -> L42
        L2d:
            if (r7 == 0) goto L3f
            if (r9 == 0) goto L35
            r6 = r6 ^ r2
            r9.a(r6, r7)     // Catch: java.lang.Throwable -> L42
        L35:
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            r5.close()
            r0 = 1
            goto L52
        L3f:
            if (r1 == 0) goto L4f
            goto L4c
        L42:
            r6 = move-exception
            java.lang.String r7 = "fCache"
            java.lang.String r8 = "decode cache fail"
            com.opos.cmn.an.f.a.b(r7, r8, r6)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L4f
        L4c:
            r1.close()
        L4f:
            r5.close()
        L52:
            return r0
        L53:
            r6 = move-exception
            if (r1 == 0) goto L59
            r1.close()
        L59:
            r5.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.a(okio.Buffer, java.lang.String, int, int, com.opos.mobad.c.a$a):boolean");
    }

    public File b(File file) {
        return new File(file.getParent(), file.getName() + ".tmp");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100 A[Catch: Exception -> 0x00e6, TRY_ENTER, TryCatch #11 {Exception -> 0x00e6, blocks: (B:84:0x0100, B:86:0x0105, B:105:0x00e2, B:107:0x00ea), top: B:59:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105 A[Catch: Exception -> 0x00e6, TRY_LEAVE, TryCatch #11 {Exception -> 0x00e6, blocks: (B:84:0x0100, B:86:0x0105, B:105:0x00e2, B:107:0x00ea), top: B:59:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.io.File r12, java.lang.String r13, int r14, int r15, com.opos.mobad.c.a.InterfaceC0426a r16) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.b(java.io.File, java.lang.String, int, int, com.opos.mobad.c.a$a):boolean");
    }

    public int a(String str, BufferedSource bufferedSource, String str2, String str3) {
        return a(str, bufferedSource, new Buffer(), str2, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        com.opos.cmn.an.f.a.b("fCache", "close", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.opos.mobad.d.c] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String r9, okio.BufferedSource r10, okio.Buffer r11, java.lang.String r12, java.lang.String r13) {
        /*
            r8 = this;
            java.lang.String r0 = "close"
            java.lang.String r1 = "fCache"
            java.io.File r9 = r8.a(r9, r13)
            if (r9 != 0) goto Lc
            goto L99
        Lc:
            boolean r13 = r9.exists()
            if (r13 == 0) goto L15
            r9.delete()
        L15:
            r13 = 0
            java.io.File r2 = r8.b(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            if (r3 == 0) goto L23
            r2.delete()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
        L23:
            okio.Sink r3 = okio.Okio.sink(r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            okio.BufferedSink r13 = okio.Okio.buffer(r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
        L2b:
            r3 = 8192(0x2000, double:4.0474E-320)
            long r3 = r10.read(r11, r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L3a
            r13.write(r11, r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
        L3a:
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2b
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            if (r3 != 0) goto L6b
            java.lang.String r3 = com.opos.cmn.an.a.c.a(r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            boolean r12 = r12.equals(r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            if (r12 != 0) goto L6b
            java.lang.String r9 = "write but md5 fail"
            com.opos.cmn.an.f.a.b(r1, r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r2.delete()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r9 = 1
            r8.a(r10)
            r8.a(r11)
            if (r13 == 0) goto L9a
            r13.flush()     // Catch: java.lang.Exception -> L66
            r13.close()     // Catch: java.lang.Exception -> L66
            goto L9a
        L66:
            r10 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r10)
            goto L9a
        L6b:
            r2.renameTo(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r9 = 0
            r8.a(r10)
            r8.a(r11)
            if (r13 == 0) goto L9a
            r13.flush()     // Catch: java.lang.Exception -> L66
            r13.close()     // Catch: java.lang.Exception -> L66
            goto L9a
        L7e:
            r9 = move-exception
            goto L9b
        L80:
            r9 = move-exception
            java.lang.String r12 = "is"
            com.opos.cmn.an.f.a.b(r1, r12, r9)     // Catch: java.lang.Throwable -> L7e
            r8.a(r10)
            r8.a(r11)
            if (r13 == 0) goto L99
            r13.flush()     // Catch: java.lang.Exception -> L95
            r13.close()     // Catch: java.lang.Exception -> L95
            goto L99
        L95:
            r9 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r9)
        L99:
            r9 = 2
        L9a:
            return r9
        L9b:
            r8.a(r10)
            r8.a(r11)
            if (r13 == 0) goto Lae
            r13.flush()     // Catch: java.lang.Exception -> Laa
            r13.close()     // Catch: java.lang.Exception -> Laa
            goto Lae
        Laa:
            r10 = move-exception
            com.opos.cmn.an.f.a.b(r1, r0, r10)
        Lae:
            goto Lb0
        Laf:
            throw r9
        Lb0:
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.a(java.lang.String, okio.BufferedSource, okio.Buffer, java.lang.String, java.lang.String):int");
    }

    public Buffer a(File file) throws Exception {
        Buffer buffer = new Buffer();
        Okio.buffer(Okio.source(file)).readAll(buffer);
        return buffer;
    }

    @Override // com.opos.mobad.c.a
    public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
        a(new File(str), str2, i2, i3, interfaceC0426a);
    }

    public void a(String str, Buffer buffer, String str2) throws Exception {
        File a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        this.f20457b.put(a2.getAbsolutePath(), buffer.clone());
        a(buffer, a2);
    }

    public boolean a(String str, String str2, String str3) {
        return a(a(str, str3), str2);
    }
}
