package com.opos.cmn.func.dl.base.a.a;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a */
    static final String f17246a = e.class.getSimpleName();

    /* renamed from: b */
    public volatile boolean f17247b;

    /* renamed from: c */
    public Map<Integer, RandomAccessFile> f17248c = new ConcurrentHashMap();

    /* renamed from: d */
    BlockingQueue<a> f17249d = new ArrayBlockingQueue(1000);

    /* renamed from: e */
    private d f17250e;

    public e(d dVar) {
        this.f17250e = dVar;
    }

    private void a(RandomAccessFile randomAccessFile) {
        com.opos.cmn.an.f.a.b(f17246a, "close buffer stream!downloadId:");
        if (randomAccessFile == null) {
            return;
        }
        Iterator<Map.Entry<Integer, RandomAccessFile>> it = this.f17248c.entrySet().iterator();
        while (it.hasNext()) {
            if (randomAccessFile.equals(it.next().getValue())) {
                it.remove();
                com.opos.cmn.func.dl.base.h.a.a(randomAccessFile);
                return;
            }
        }
    }

    public final int a() {
        return this.f17249d.size();
    }

    public final void a(a aVar) {
        int i2 = aVar.f17226b;
        if (this.f17248c.get(Integer.valueOf(i2)) == null) {
            com.opos.cmn.func.dl.base.a.c a2 = this.f17250e.a(i2);
            if (a2 == null || a2.f17266b.a() != 3) {
                return;
            }
            try {
                File file = a2.f17265a.f17260j;
                if (!com.opos.cmn.an.d.b.a.a(file)) {
                    com.opos.cmn.func.dl.base.h.a.a(file);
                }
                this.f17248c.put(Integer.valueOf(i2), new RandomAccessFile(file, "rw"));
            } catch (Exception e2) {
                boolean a3 = com.opos.cmn.func.dl.base.h.a.a(this.f17250e.f17245c);
                com.opos.cmn.an.f.a.d(f17246a, "create tempFile failed!hasStorage=".concat(String.valueOf(a3)), e2);
                throw new DlException(a3 ? 1000 : 1008, e2);
            }
        }
        try {
            this.f17249d.put(aVar);
        } catch (InterruptedException e3) {
            com.opos.cmn.an.f.a.c(f17246a, "addBuffer interrupt!", e3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Exception e2;
        RandomAccessFile randomAccessFile;
        f fVar;
        IOException e3;
        RandomAccessFile randomAccessFile2;
        DlException e4;
        RandomAccessFile randomAccessFile3;
        f fVar2;
        a aVar;
        Throwable th;
        DlException dlException;
        RandomAccessFile randomAccessFile4;
        RandomAccessFile randomAccessFile5;
        RandomAccessFile randomAccessFile6;
        RandomAccessFile randomAccessFile7;
        com.opos.cmn.an.f.a.b(f17246a, "Write thread start!");
        while (!this.f17247b) {
            a aVar2 = null;
            try {
                try {
                    aVar = this.f17249d.take();
                } catch (DlException e5) {
                    e4 = e5;
                    randomAccessFile3 = null;
                    fVar2 = null;
                } catch (IOException e6) {
                    e3 = e6;
                    randomAccessFile2 = null;
                    fVar = null;
                } catch (InterruptedException unused) {
                } catch (Exception e7) {
                    e2 = e7;
                    randomAccessFile = null;
                    fVar = null;
                }
                try {
                    try {
                        com.opos.cmn.func.dl.base.a.c a2 = this.f17250e.a(aVar.f17226b);
                        if (a2 != null && (randomAccessFile4 = this.f17248c.get(Integer.valueOf(aVar.f17226b))) != null) {
                            try {
                                if (a2.f17266b.a() == 3) {
                                    f fVar3 = a2.f17267c;
                                    com.opos.cmn.func.dl.base.a.b bVar = a2.f17265a;
                                    if (!bVar.f17260j.exists()) {
                                        throw new DlException(1009);
                                    }
                                    boolean z = false;
                                    if (aVar.f17227c != -1) {
                                        if (a2.f17266b.a() == 3) {
                                            randomAccessFile4.seek(aVar.f17228d);
                                            randomAccessFile4.write(aVar.f17229e, 0, aVar.f17227c);
                                            bVar.s.addAndGet(aVar.f17227c);
                                            fVar3.b(aVar);
                                        }
                                    }
                                    long j2 = bVar.s.get();
                                    long j3 = bVar.k;
                                    boolean z2 = j2 >= j3 && j3 != -1;
                                    if (j3 == -1 && aVar.f17227c == -1) {
                                        z = true;
                                    }
                                    if (z2 || z) {
                                        com.opos.cmn.an.f.a.a(f17246a, "Write finish by isOverLen :" + z2 + ",isEndBuffer:" + z);
                                        RandomAccessFile remove = this.f17248c.remove(Integer.valueOf(aVar.f17226b));
                                        if (remove != null) {
                                            try {
                                                remove.close();
                                            } catch (DlException e8) {
                                                e4 = e8;
                                                fVar2 = fVar3;
                                                randomAccessFile7 = remove;
                                                randomAccessFile3 = randomAccessFile7;
                                                aVar2 = aVar;
                                                com.opos.cmn.an.f.a.c(f17246a, "write block error! ", e4);
                                                a(randomAccessFile3);
                                                if (fVar2 != null) {
                                                    fVar2.a(e4);
                                                }
                                                this.f17250e.f17243a.f17337e.a(aVar2);
                                            } catch (IOException e9) {
                                                e3 = e9;
                                                fVar = fVar3;
                                                randomAccessFile6 = remove;
                                                randomAccessFile2 = randomAccessFile6;
                                                aVar2 = aVar;
                                                com.opos.cmn.an.f.a.c(f17246a, "write block io error! ", e3);
                                                a(randomAccessFile2);
                                                if (fVar != null) {
                                                    dlException = new DlException(1004);
                                                    fVar.a(dlException);
                                                }
                                                this.f17250e.f17243a.f17337e.a(aVar2);
                                            } catch (Exception e10) {
                                                e2 = e10;
                                                fVar = fVar3;
                                                randomAccessFile5 = remove;
                                                randomAccessFile = randomAccessFile5;
                                                aVar2 = aVar;
                                                com.opos.cmn.an.f.a.c(f17246a, "onError error! ", e2);
                                                a(randomAccessFile);
                                                if (fVar != null) {
                                                    dlException = new DlException(1000, e2);
                                                    fVar.a(dlException);
                                                }
                                                this.f17250e.f17243a.f17337e.a(aVar2);
                                            }
                                        }
                                        fVar3.a();
                                    }
                                }
                            } catch (DlException e11) {
                                fVar2 = null;
                                randomAccessFile7 = randomAccessFile4;
                                e4 = e11;
                            } catch (IOException e12) {
                                fVar = null;
                                randomAccessFile6 = randomAccessFile4;
                                e3 = e12;
                            } catch (Exception e13) {
                                fVar = null;
                                randomAccessFile5 = randomAccessFile4;
                                e2 = e13;
                            }
                        }
                        this.f17250e.f17243a.f17337e.a(aVar);
                    } catch (DlException e14) {
                        e4 = e14;
                        fVar2 = null;
                        aVar2 = aVar;
                        randomAccessFile3 = null;
                    } catch (IOException e15) {
                        e3 = e15;
                        fVar = null;
                        aVar2 = aVar;
                        randomAccessFile2 = null;
                    } catch (Exception e16) {
                        e2 = e16;
                        fVar = null;
                        aVar2 = aVar;
                        randomAccessFile = null;
                    }
                } catch (InterruptedException unused2) {
                    aVar2 = aVar;
                    try {
                        com.opos.cmn.an.f.a.c(f17246a, "write block inerrupted! ");
                        this.f17250e.f17243a.f17337e.a(aVar2);
                    } catch (Throwable th2) {
                        aVar = aVar2;
                        th = th2;
                        a aVar3 = aVar;
                        th = th;
                        aVar2 = aVar3;
                        this.f17250e.f17243a.f17337e.a(aVar2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a aVar32 = aVar;
                    th = th;
                    aVar2 = aVar32;
                    this.f17250e.f17243a.f17337e.a(aVar2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                this.f17250e.f17243a.f17337e.a(aVar2);
                throw th;
            }
        }
    }
}
