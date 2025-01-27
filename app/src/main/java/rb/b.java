package rb;

import androidx.core.app.FrameMetricsAggregator;
import ba.l;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.local.txt.data.TXTBlock;
import com.martian.mibook.lib.local.txt.data.TXTBook;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.local.txt.data.TXTChapterContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import l9.p0;
import org.mozilla.universalchardet.UniversalDetector;
import rb.b;
import x8.k;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b */
    public static final String f30386b = ".ttb";

    /* renamed from: c */
    public static final String f30387c = ".txt";

    /* renamed from: d */
    public static final String f30388d = "_txt";

    /* renamed from: e */
    public static final String f30389e = "GBK";

    /* renamed from: f */
    public static final int f30390f = 30;

    /* renamed from: g */
    public static final int f30391g = 10000;

    /* renamed from: a */
    public final Pattern f30392a = Pattern.compile(".*第.*[零一二三四五六七八九十0123456789]+.*章.*");

    public class a extends y8.b<TXTBlock, List<TXTChapter>> {

        /* renamed from: a */
        public final /* synthetic */ c f30393a;

        /* renamed from: b */
        public final /* synthetic */ TXTBlock f30394b;

        public a(c cVar, TXTBlock tXTBlock) {
            this.f30393a = cVar;
            this.f30394b = tXTBlock;
        }

        public static /* synthetic */ void h(a aVar, Integer num) {
            aVar.publishProgress(num);
        }

        @Override // y8.b
        /* renamed from: g */
        public k doInBackground(TXTBlock tXTBlock) {
            List<TXTChapter> g10 = b.this.g(tXTBlock, new InterfaceC0784b() { // from class: rb.a
                public /* synthetic */ a() {
                }

                @Override // rb.b.InterfaceC0784b
                public final void a(int i10) {
                    b.a.h(b.a.this, Integer.valueOf(i10));
                }
            });
            return (g10 == null || g10.isEmpty()) ? new x8.c(-1, "Empty chapters.") : new x8.b(g10);
        }

        @Override // y8.a
        /* renamed from: i */
        public void onDataReceived(List<TXTChapter> list) {
            this.f30393a.b(this.f30394b, list);
        }

        @Override // y8.f
        public void onProgressUpdate(Integer... numArr) {
            this.f30393a.a(numArr[0].intValue());
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f30393a.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f30393a.onLoading(z10);
        }
    }

    /* renamed from: rb.b$b */
    public interface InterfaceC0784b {
        void a(int i10);
    }

    public interface c {
        void a(int i10);

        void b(TXTBlock tXTBlock, List<TXTChapter> list);

        void onLoading(boolean z10);

        void onResultError(x8.c cVar);
    }

    public void a(TXTBlock tXTBlock, c cVar) {
        new a(cVar, tXTBlock).executeParallel(tXTBlock);
    }

    public long b(String str, long j10) {
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(new File(str), t.f11211k);
                    long j11 = j10 - 255;
                    try {
                        randomAccessFile3.seek(j11);
                        byte[] bArr = new byte[FrameMetricsAggregator.EVERY_DURATION];
                        int read = randomAccessFile3.read(bArr) / 2;
                        for (int i10 = 0; i10 < read; i10++) {
                            if (bArr[read + i10] == 10) {
                                long j12 = j11 + read + i10;
                                try {
                                    randomAccessFile3.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                                return j12;
                            }
                            if (bArr[read - i10] == 10) {
                                long j13 = (j11 + read) - i10;
                                try {
                                    randomAccessFile3.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                                return j13;
                            }
                        }
                        randomAccessFile3.close();
                        randomAccessFile = read;
                    } catch (IOException e12) {
                        e = e12;
                        randomAccessFile2 = randomAccessFile3;
                        e.printStackTrace();
                        if (randomAccessFile2 == null) {
                            return -1L;
                        }
                        randomAccessFile2.close();
                        randomAccessFile = randomAccessFile2;
                        return -1L;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile3;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                }
                return -1L;
            } catch (IOException e15) {
                e15.printStackTrace();
                return -1L;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean c(String str) {
        if (str.length() < 30) {
            return this.f30392a.matcher(str).matches();
        }
        return false;
    }

    public List<TXTBlock> d(LocalBook localBook) {
        ArrayList arrayList = new ArrayList();
        long longValue = localBook.getFileSize().longValue();
        long j10 = 0;
        int i10 = 0;
        if (longValue < 1048576) {
            TXTBlock tXTBlock = new TXTBlock();
            tXTBlock.setIndex(0);
            tXTBlock.setStartOffset(0L);
            tXTBlock.setEndOffset(longValue);
            tXTBlock.setFilepath(localBook.getFilePath());
            tXTBlock.setCharset(localBook.getCharset());
            arrayList.add(tXTBlock);
            return arrayList;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        long j11 = longValue / availableProcessors;
        for (int i11 = 1; i11 < availableProcessors; i11++) {
            long b10 = b(localBook.getFilePath(), i11 * j11);
            if (b10 != -1) {
                TXTBlock tXTBlock2 = new TXTBlock();
                tXTBlock2.setIndex(i10);
                tXTBlock2.setFilepath(localBook.getFilePath());
                tXTBlock2.setStartOffset(j10);
                long j12 = b10 + 1;
                tXTBlock2.setEndOffset(j12);
                tXTBlock2.setCharset(localBook.getCharset());
                arrayList.add(tXTBlock2);
                j10 = j12;
                i10++;
            }
        }
        TXTBlock tXTBlock3 = new TXTBlock();
        tXTBlock3.setIndex(i10);
        tXTBlock3.setFilepath(localBook.getFilePath());
        tXTBlock3.setStartOffset(j10);
        tXTBlock3.setEndOffset(longValue);
        tXTBlock3.setCharset(localBook.getCharset());
        arrayList.add(tXTBlock3);
        return arrayList;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ca -> B:33:0x00d9). Please report as a decompilation issue!!! */
    public TXTBook e(String str) {
        String substring;
        FileInputStream fileInputStream = null;
        if (l.q(str)) {
            return null;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                str = file.getCanonicalPath();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            TXTBook tXTBook = new TXTBook();
            tXTBook.setFilePath(str);
            String name = file.getName();
            if (name.endsWith(f30387c)) {
                substring = name.substring(0, name.length() - 4);
            } else if (name.endsWith(f30386b)) {
                int lastIndexOf = name.lastIndexOf(f30388d);
                substring = lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name.substring(0, name.length() - 4);
            }
            if (l.q(substring)) {
                tXTBook.setBookName(name);
            } else {
                tXTBook.setBookName(substring);
            }
            tXTBook.setFileSize(Long.valueOf(file.length()));
            tXTBook.setCharset(f30389e);
            try {
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            UniversalDetector universalDetector = new UniversalDetector(null);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read <= 0 || universalDetector.k()) {
                                    break;
                                }
                                universalDetector.j(bArr, 0, read);
                            }
                            universalDetector.a();
                            String g10 = universalDetector.g();
                            p0.b("文件编码：" + g10);
                            if (g10 != null) {
                                tXTBook.setCharset(g10);
                            }
                            fileInputStream2.close();
                        } catch (IOException e11) {
                            e = e11;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return tXTBook;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            return tXTBook;
        }
        return null;
    }

    public TXTChapterContent f(Chapter chapter) {
        if (!(chapter instanceof TXTChapter)) {
            return null;
        }
        TXTChapter tXTChapter = (TXTChapter) chapter;
        Long startOffset = tXTChapter.getStartOffset();
        long longValue = startOffset.longValue();
        Long endOffset = tXTChapter.getEndOffset();
        long longValue2 = endOffset.longValue();
        TXTChapterContent tXTChapterContent = new TXTChapterContent();
        tXTChapterContent.setFilepath(tXTChapter.getFilepath());
        tXTChapterContent.setTitle(chapter.getTitle());
        tXTChapterContent.setStartOffset(startOffset);
        tXTChapterContent.setEndOffset(endOffset);
        String a10 = qb.a.a(tXTChapter.getFilepath(), tXTChapter.getCharset(), longValue, longValue2);
        if (a10 == null) {
            return null;
        }
        tXTChapterContent.setContent(l.n(a10));
        return tXTChapterContent;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.martian.mibook.lib.local.txt.data.TXTChapter> g(com.martian.mibook.lib.local.txt.data.TXTBlock r32, rb.b.InterfaceC0784b r33) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.b.g(com.martian.mibook.lib.local.txt.data.TXTBlock, rb.b$b):java.util.List");
    }
}
