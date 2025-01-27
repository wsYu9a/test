package com.opos.cmn.func.dl.base.e;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements a {

    /* renamed from: a */
    private static final String f17327a = "d";

    /* renamed from: b */
    private File f17328b;

    /* renamed from: c */
    private File f17329c;

    public d(File file, File file2) {
        this.f17328b = file;
        this.f17329c = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // com.opos.cmn.func.dl.base.e.a
    public final List<c> a() {
        ArrayList arrayList;
        ?? r6;
        ArrayList arrayList2;
        ?? r7;
        synchronized (this) {
            arrayList = null;
            if (com.opos.cmn.an.d.b.a.a(this.f17328b) && com.opos.cmn.an.d.b.a.a(this.f17329c)) {
                String str = f17327a;
                com.opos.cmn.an.f.a.b(str, "tmpFile and posFile all exists.");
                try {
                    r6 = new FileInputStream(this.f17328b);
                    try {
                        r7 = new DataInputStream(r6);
                        try {
                            try {
                                int readInt = r7.readInt();
                                com.opos.cmn.an.f.a.b(str, "blockNum=".concat(String.valueOf(readInt)));
                                arrayList2 = new ArrayList(readInt);
                                for (int i2 = 0; i2 < readInt; i2++) {
                                    try {
                                        arrayList2.add(new c(i2, r7.readLong(), r7.readLong(), r7.readLong()));
                                    } catch (Exception unused) {
                                        arrayList = r6;
                                        r7 = r7;
                                        try {
                                            com.opos.cmn.an.f.a.c(f17327a, "read pos file error,delete pos file!");
                                            com.opos.cmn.an.d.b.a.e(this.f17329c);
                                            com.opos.cmn.func.dl.base.h.a.a((Closeable[]) new Closeable[]{r7, arrayList});
                                            arrayList = arrayList2;
                                            com.opos.cmn.an.f.a.b(f17327a, "getFileSavedInfos, path:" + this.f17328b.getName());
                                            return arrayList;
                                        } catch (Throwable th) {
                                            th = th;
                                            r6 = arrayList;
                                            arrayList = r7;
                                            com.opos.cmn.func.dl.base.h.a.a((Closeable[]) new Closeable[]{arrayList, r6});
                                            throw th;
                                        }
                                    }
                                }
                                com.opos.cmn.func.dl.base.h.a.a((Closeable[]) new Closeable[]{r7, r6});
                            } catch (Throwable th2) {
                                th = th2;
                                arrayList = r7;
                                com.opos.cmn.func.dl.base.h.a.a((Closeable[]) new Closeable[]{arrayList, r6});
                                throw th;
                            }
                        } catch (Exception unused2) {
                            arrayList2 = null;
                        }
                    } catch (Exception unused3) {
                        arrayList2 = null;
                        r7 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        com.opos.cmn.func.dl.base.h.a.a((Closeable[]) new Closeable[]{arrayList, r6});
                        throw th;
                    }
                } catch (Exception unused4) {
                    arrayList2 = null;
                    r7 = 0;
                } catch (Throwable th4) {
                    th = th4;
                    r6 = 0;
                }
                arrayList = arrayList2;
            }
            com.opos.cmn.an.f.a.b(f17327a, "getFileSavedInfos, path:" + this.f17328b.getName());
        }
        return arrayList;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final void a(List<c> list) {
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        synchronized (this) {
            if (list != null) {
                if (list.size() > 0) {
                    DataOutputStream dataOutputStream2 = null;
                    try {
                        int size = list.size();
                        com.opos.cmn.func.dl.base.h.a.a(this.f17328b);
                        fileOutputStream = new FileOutputStream(this.f17328b);
                        try {
                            dataOutputStream = new DataOutputStream(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                        } catch (Throwable th) {
                            th = th;
                            com.opos.cmn.func.dl.base.h.a.a(dataOutputStream2, fileOutputStream);
                            throw th;
                        }
                        try {
                            dataOutputStream.writeInt(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                c cVar = list.get(i2);
                                dataOutputStream.writeLong(cVar.f17324b);
                                dataOutputStream.writeLong(cVar.f17326d);
                                dataOutputStream.writeLong(cVar.f17325c);
                            }
                            com.opos.cmn.func.dl.base.h.a.a(dataOutputStream, fileOutputStream);
                        } catch (Exception e3) {
                            e = e3;
                            dataOutputStream2 = dataOutputStream;
                            try {
                                com.opos.cmn.an.f.a.c(f17327a, "saveThreadInfos ", e);
                                throw new DlException(1004, e);
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream = dataOutputStream2;
                                fileOutputStream = fileOutputStream;
                                dataOutputStream2 = dataOutputStream;
                                com.opos.cmn.func.dl.base.h.a.a(dataOutputStream2, fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream;
                            dataOutputStream2 = dataOutputStream;
                            com.opos.cmn.func.dl.base.h.a.a(dataOutputStream2, fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                }
            }
        }
    }
}
