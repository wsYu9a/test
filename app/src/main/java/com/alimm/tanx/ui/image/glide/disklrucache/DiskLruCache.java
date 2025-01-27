package com.alimm.tanx.ui.image.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ok.a;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(null));
    private final Callable<Void> cleanupCallable = new Callable<Void>() { // from class: com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.1
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.journalWriter == null) {
                        return null;
                    }
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* renamed from: com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache$1 */
    public class AnonymousClass1 implements Callable<Void> {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.journalWriter == null) {
                        return null;
                    }
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ DiskLruCacheThreadFactory(AnonymousClass1 anonymousClass1) {
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private final boolean[] written;

        public /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry, AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        private InputStream newInputStream(int i10) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                try {
                    return new FileInputStream(this.entry.getCleanFile(i10));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        public void commit() throws IOException {
            DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }

        public File getFile(int i10) throws IOException {
            File dirtyFile;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.entry.currentEditor != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.entry.readable) {
                        this.written[i10] = true;
                    }
                    dirtyFile = this.entry.getDirtyFile(i10);
                    DiskLruCache.this.directory.mkdirs();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return dirtyFile;
        }

        public String getString(int i10) throws IOException {
            InputStream newInputStream = newInputStream(i10);
            if (newInputStream != null) {
                return DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public void set(int i10, String str) throws IOException {
            Throwable th2;
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(getFile(i10)), Util.UTF_8);
            } catch (Throwable th3) {
                th2 = th3;
                outputStreamWriter = null;
            }
            try {
                outputStreamWriter.write(str);
                Util.closeQuietly(outputStreamWriter);
            } catch (Throwable th4) {
                th2 = th4;
                Util.closeQuietly(outputStreamWriter);
                throw th2;
            }
        }

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }
    }

    public final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        public /* synthetic */ Entry(DiskLruCache diskLruCache, String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder a10 = a.a("unexpected journal line: ");
            a10.append(Arrays.toString(strArr));
            throw new IOException(a10.toString());
        }

        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                invalidLengths(strArr);
                throw null;
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.lengths[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    invalidLengths(strArr);
                    throw null;
                }
            }
        }

        public File getCleanFile(int i10) {
            return this.cleanFiles[i10];
        }

        public File getDirtyFile(int i10) {
            return this.dirtyFiles[i10];
        }

        public String getLengths() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.lengths) {
                sb2.append(b5.a.O);
                sb2.append(j10);
            }
            return sb2.toString();
        }

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < DiskLruCache.this.valueCount; i10++) {
                sb2.append(i10);
                this.cleanFiles[i10] = new File(DiskLruCache.this.directory, sb2.toString());
                sb2.append(".tmp");
                this.dirtyFiles[i10] = new File(DiskLruCache.this.directory, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        public /* synthetic */ Value(DiskLruCache diskLruCache, String str, long j10, File[] fileArr, long[] jArr, AnonymousClass1 anonymousClass1) {
            this(str, j10, fileArr, jArr);
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int i10) {
            return this.files[i10];
        }

        public long getLength(int i10) {
            return this.lengths[i10];
        }

        public String getString(int i10) throws IOException {
            return DiskLruCache.inputStreamToString(new FileInputStream(this.files[i10]));
        }

        private Value(String str, long j10, File[] fileArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j10;
            this.files = fileArr;
            this.lengths = jArr;
        }
    }

    private DiskLruCache(File file, int i10, int i11, long j10) {
        this.directory = file;
        this.appVersion = i10;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i11;
        this.maxSize = j10;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void closeWriter(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized void completeEdit(Editor editor, boolean z10) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }
        if (z10 && !entry.readable) {
            for (int i10 = 0; i10 < this.valueCount; i10++) {
                if (!editor.written[i10]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!entry.getDirtyFile(i10).exists()) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.valueCount; i11++) {
            File dirtyFile = entry.getDirtyFile(i11);
            if (!z10) {
                deleteIfExists(dirtyFile);
            } else if (dirtyFile.exists()) {
                File cleanFile = entry.getCleanFile(i11);
                dirtyFile.renameTo(cleanFile);
                long j10 = entry.lengths[i11];
                long length = cleanFile.length();
                entry.lengths[i11] = length;
                this.size = (this.size - j10) + length;
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable || z10) {
            entry.readable = true;
            this.journalWriter.append((CharSequence) "CLEAN");
            this.journalWriter.append(b5.a.O);
            this.journalWriter.append((CharSequence) entry.key);
            this.journalWriter.append((CharSequence) entry.getLengths());
            this.journalWriter.append('\n');
            if (z10) {
                long j11 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j11;
                entry.sequenceNumber = j11;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.append((CharSequence) "REMOVE");
            this.journalWriter.append(b5.a.O);
            this.journalWriter.append((CharSequence) entry.key);
            this.journalWriter.append('\n');
        }
        flushWriter(this.journalWriter);
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    private static void flushWriter(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    public boolean journalRebuildRequired() {
        int i10 = this.redundantOpCount;
        return i10 >= 2000 && i10 >= this.lruEntries.size();
    }

    public static DiskLruCache open(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                renameTo(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i10, i11, j10);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                return diskLruCache;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i10, i11, j10);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i10 = 0;
            if (next.currentEditor == null) {
                while (i10 < this.valueCount) {
                    this.size += next.lengths[i10];
                    i10++;
                }
            } else {
                next.currentEditor = null;
                while (i10 < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i10));
                    deleteIfExists(next.getDirtyFile(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), 8192, Util.US_ASCII);
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unexpected journal header: [");
                sb2.append(readLine);
                sb2.append(", ");
                sb2.append(readLine2);
                sb2.append(", ");
                sb2.append(readLine4);
                sb2.append(", ");
                sb2.append(readLine5);
                sb2.append("]");
                throw new IOException(sb2.toString());
            }
            int i10 = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i10++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i10 - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th2) {
            Util.closeQuietly(strictLineReader);
            throw th2;
        }
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i10);
        if (indexOf2 == -1) {
            substring = str.substring(i10);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry.currentEditor = new Editor(entry);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized void rebuildJournal() throws IOException {
        try {
            Writer writer = this.journalWriter;
            if (writer != null) {
                closeWriter(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DIRTY ");
                        sb2.append(entry.key);
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("CLEAN ");
                        sb3.append(entry.key);
                        sb3.append(entry.getLengths());
                        sb3.append('\n');
                        bufferedWriter.write(sb3.toString());
                    }
                }
                closeWriter(bufferedWriter);
                if (this.journalFile.exists()) {
                    renameTo(this.journalFile, this.journalFileBackup, true);
                }
                renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
            } catch (Throwable th2) {
                closeWriter(bufferedWriter);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private static void renameTo(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.journalWriter == null) {
                return;
            }
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            closeWriter(this.journalWriter);
            this.journalWriter = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        flushWriter(this.journalWriter);
    }

    public synchronized Value get(String str) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        for (File file : entry.cleanFiles) {
            if (!file.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((CharSequence) "READ");
        this.journalWriter.append(b5.a.O);
        this.journalWriter.append((CharSequence) str);
        this.journalWriter.append('\n');
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Value(str, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    public synchronized boolean remove(String str) throws IOException {
        try {
            checkNotClosed();
            Entry entry = this.lruEntries.get(str);
            if (entry != null && entry.currentEditor == null) {
                for (int i10 = 0; i10 < this.valueCount; i10++) {
                    File cleanFile = entry.getCleanFile(i10);
                    if (cleanFile.exists() && !cleanFile.delete()) {
                        throw new IOException("failed to delete " + cleanFile);
                    }
                    this.size -= entry.lengths[i10];
                    entry.lengths[i10] = 0;
                }
                this.redundantOpCount++;
                this.journalWriter.append((CharSequence) "REMOVE");
                this.journalWriter.append(b5.a.O);
                this.journalWriter.append((CharSequence) str);
                this.journalWriter.append('\n');
                this.lruEntries.remove(str);
                if (journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public synchronized void setMaxSize(long j10) {
        this.maxSize = j10;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }

    public synchronized Editor edit(String str, long j10) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (j10 != -1 && (entry == null || entry.sequenceNumber != j10)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.lruEntries.put(str, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        this.journalWriter.append((CharSequence) "DIRTY");
        this.journalWriter.append(b5.a.O);
        this.journalWriter.append((CharSequence) str);
        this.journalWriter.append('\n');
        flushWriter(this.journalWriter);
        return editor;
    }
}
