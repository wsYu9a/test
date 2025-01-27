package com.martian.mibook.lib.local.c.b;

import b.d.c.b.k;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.local.c.b.b;
import com.martian.mibook.lib.local.txt.data.TXTBlock;
import com.martian.mibook.lib.local.txt.data.TXTBook;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.local.txt.data.TXTChapterContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.mozilla.universalchardet.UniversalDetector;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public static final String f13934a = ".ttb";

    /* renamed from: b */
    public static final String f13935b = ".txt";

    /* renamed from: c */
    public static final String f13936c = "_txt";

    /* renamed from: d */
    public static final String f13937d = "GBK";

    /* renamed from: e */
    private static final int f13938e = 30;

    /* renamed from: f */
    public static final int f13939f = 10000;

    /* renamed from: g */
    private final Pattern f13940g = Pattern.compile(".*第.*[零一二三四五六七八九十0123456789]+.*章.*");

    class a extends b.d.c.c.c<TXTBlock, List<TXTChapter>> {

        /* renamed from: a */
        final /* synthetic */ c f13941a;

        /* renamed from: b */
        final /* synthetic */ TXTBlock f13942b;

        a(final c val$block, final TXTBlock val$receiver) {
            this.f13941a = val$block;
            this.f13942b = val$receiver;
        }

        @Override // b.d.c.c.c
        /* renamed from: f */
        public k doInBackground(TXTBlock txtBlock) {
            List<TXTChapter> g2 = b.this.g(txtBlock, new InterfaceC0273b() { // from class: com.martian.mibook.lib.local.c.b.a
                @Override // com.martian.mibook.lib.local.c.b.b.InterfaceC0273b
                public final void a(int i2) {
                    b.a.this.publishProgress(Integer.valueOf(i2));
                }
            });
            return (g2 == null || g2.isEmpty()) ? new b.d.c.b.c(-1, "Empty chapters.") : new b.d.c.b.b(g2);
        }

        @Override // b.d.c.c.b
        /* renamed from: h */
        public void onDataReceived(List<TXTChapter> txtChapters) {
            this.f13941a.b(this.f13942b, txtChapters);
        }

        @Override // b.d.c.c.g
        protected void onProgressUpdate(Integer... values) {
            this.f13941a.a(values[0].intValue());
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f13941a.onResultError(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f13941a.onLoading(show);
        }
    }

    /* renamed from: com.martian.mibook.lib.local.c.b.b$b */
    public interface InterfaceC0273b {
        void a(int n);
    }

    public interface c {
        void a(int n);

        void b(TXTBlock block, List<TXTChapter> chapters);

        void onLoading(boolean loading);

        void onResultError(b.d.c.b.c errorResult);
    }

    public void a(final TXTBlock block, final c receiver) {
        new a(receiver, block).executeParallel(block);
    }

    public long b(String filepath, long position) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(filepath), t.k);
                long j2 = position - 255;
                try {
                    randomAccessFile2.seek(j2);
                    byte[] bArr = new byte[511];
                    int read = randomAccessFile2.read(bArr) / 2;
                    for (int i2 = 0; i2 < read; i2++) {
                        if (bArr[read + i2] == 10) {
                            long j3 = j2 + read + i2;
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return j3;
                        }
                        if (bArr[read - i2] == 10) {
                            long j4 = (j2 + read) - i2;
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return j4;
                        }
                    }
                    randomAccessFile2.close();
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile == null) {
                        return -1L;
                    }
                    randomAccessFile.close();
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            return -1L;
        } catch (IOException e5) {
            e5.printStackTrace();
            return -1L;
        }
    }

    public boolean c(String line) {
        if (line.length() < 30) {
            return this.f13940g.matcher(line).matches();
        }
        return false;
    }

    public List<TXTBlock> d(LocalBook book) {
        ArrayList arrayList = new ArrayList();
        long longValue = book.getFileSize().longValue();
        int i2 = 0;
        long j2 = 0;
        if (longValue < 1048576) {
            TXTBlock tXTBlock = new TXTBlock();
            tXTBlock.setIndex(0);
            tXTBlock.setStartOffset(0L);
            tXTBlock.setEndOffset(longValue);
            tXTBlock.setFilepath(book.getFilePath());
            tXTBlock.setCharset(book.getCharset());
            arrayList.add(tXTBlock);
            return arrayList;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        long j3 = longValue / availableProcessors;
        for (int i3 = 1; i3 < availableProcessors; i3++) {
            long b2 = b(book.getFilePath(), i3 * j3);
            if (b2 != -1) {
                TXTBlock tXTBlock2 = new TXTBlock();
                tXTBlock2.setIndex(i2);
                tXTBlock2.setFilepath(book.getFilePath());
                tXTBlock2.setStartOffset(j2);
                long j4 = b2 + 1;
                tXTBlock2.setEndOffset(j4);
                tXTBlock2.setCharset(book.getCharset());
                arrayList.add(tXTBlock2);
                j2 = j4;
                i2++;
            }
        }
        TXTBlock tXTBlock3 = new TXTBlock();
        tXTBlock3.setIndex(i2);
        tXTBlock3.setFilepath(book.getFilePath());
        tXTBlock3.setStartOffset(j2);
        tXTBlock3.setEndOffset(longValue);
        tXTBlock3.setCharset(book.getCharset());
        arrayList.add(tXTBlock3);
        return arrayList;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00bf -> B:34:0x00c2). Please report as a decompilation issue!!! */
    public TXTBook e(String str) {
        String substring;
        InputStream inputStream = null;
        FileInputStream fileInputStream = null;
        inputStream = null;
        if (com.martian.libsupport.k.p(str)) {
            return null;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                str = file.getCanonicalPath();
            } catch (IOException unused) {
            }
            TXTBook tXTBook = new TXTBook();
            tXTBook.setFilePath(str);
            String name = file.getName();
            if (name.endsWith(f13935b)) {
                substring = name.substring(0, name.length() - 4);
            } else if (name.endsWith(f13934a)) {
                int lastIndexOf = name.lastIndexOf(f13936c);
                substring = lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name.substring(0, name.length() - 4);
            }
            if (com.martian.libsupport.k.p(substring)) {
                tXTBook.setBookName(name);
            } else {
                tXTBook.setBookName(substring);
            }
            tXTBook.setFileSize(Long.valueOf(file.length()));
            tXTBook.setCharset(f13937d);
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
                inputStream = inputStream;
            }
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        UniversalDetector universalDetector = new UniversalDetector(null);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0 || universalDetector.e()) {
                                break;
                            }
                            universalDetector.d(bArr, 0, read);
                        }
                        universalDetector.a();
                        String b2 = universalDetector.b();
                        if (b2 != null) {
                            tXTBook.setCharset(b2);
                        }
                        fileInputStream2.close();
                        inputStream = bArr;
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        inputStream = fileInputStream;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            inputStream = fileInputStream;
                        }
                        return tXTBook;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = fileInputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
                return tXTBook;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public TXTChapterContent f(Chapter chapter) {
        if (!(chapter instanceof TXTChapter)) {
            return null;
        }
        TXTChapter tXTChapter = (TXTChapter) chapter;
        long longValue = tXTChapter.getStartOffset().longValue();
        long longValue2 = tXTChapter.getEndOffset().longValue();
        TXTChapterContent tXTChapterContent = new TXTChapterContent();
        tXTChapterContent.setFilepath(tXTChapter.getFilepath());
        tXTChapterContent.setTitle(chapter.getTitle());
        tXTChapterContent.setStartOffset(Long.valueOf(longValue));
        tXTChapterContent.setEndOffset(Long.valueOf(longValue2));
        String a2 = com.martian.mibook.lib.local.c.a.a(tXTChapter.getFilepath(), tXTChapter.getCharset(), longValue, longValue2);
        if (a2 == null) {
            return null;
        }
        tXTChapterContent.setContent(com.martian.libsupport.k.m(a2));
        return tXTChapterContent;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0188: MOVE (r7 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:112:0x0187 */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.martian.mibook.lib.local.txt.data.TXTChapter> g(com.martian.mibook.lib.local.txt.data.TXTBlock r28, com.martian.mibook.lib.local.c.b.b.InterfaceC0273b r29) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.lib.local.c.b.b.g(com.martian.mibook.lib.local.txt.data.TXTBlock, com.martian.mibook.lib.local.c.b.b$b):java.util.List");
    }
}
