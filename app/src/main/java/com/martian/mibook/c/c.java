package com.martian.mibook.c;

import android.os.AsyncTask;
import com.martian.mibook.application.j0;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.j.w2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class c extends AsyncTask<String, FileInfo, String> {

    /* renamed from: a */
    private com.martian.mibook.c.b f11633a;

    /* renamed from: b */
    private final String[] f11634b;

    /* renamed from: c */
    private final j0.b f11635c;

    /* renamed from: d */
    private final ArrayList<FileInfo> f11636d = new ArrayList<>();

    private static class b implements Comparator<FileInfo> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            File file = new File(fileInfo.getFilePath());
            File file2 = new File(fileInfo2.getFilePath());
            if (file.isDirectory() && file2.isDirectory()) {
                return file.getName().compareToIgnoreCase(file2.getName());
            }
            if (file.isDirectory() && !file2.isDirectory()) {
                return -1;
            }
            if (!file2.isDirectory() || file.isDirectory()) {
                return file.getName().compareToIgnoreCase(file2.getName());
            }
            return 1;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public c(String[] scanTypes, j0.b fileScanListener) {
        this.f11634b = scanTypes;
        this.f11635c = fileScanListener;
    }

    private void b(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (this.f11633a == null) {
                this.f11633a = new com.martian.mibook.c.b(this.f11634b);
            }
            File[] listFiles = file.listFiles(this.f11633a);
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (isCancelled()) {
                    return;
                }
                if (file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles(this.f11633a);
                    if (listFiles2 != null && listFiles2.length > 0) {
                        FileInfo fileInfo = new FileInfo();
                        fileInfo.fileName = file2.getName();
                        fileInfo.filePath = file2.getAbsolutePath();
                        fileInfo.fileSize = listFiles2.length + " 项";
                        fileInfo.fileDate = "MIBOOK_DIRECTORY";
                        fileInfo.isChecked = false;
                        this.f11636d.add(fileInfo);
                    }
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    long h2 = w2.h(file2);
                    FileInfo fileInfo2 = new FileInfo();
                    fileInfo2.fileName = file2.getName();
                    fileInfo2.filePath = absolutePath;
                    fileInfo2.fileSize = w2.b(h2);
                    fileInfo2.fileDate = w2.e(file);
                    fileInfo2.isChecked = false;
                    this.f11636d.add(fileInfo2);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... params) {
        b(params[0]);
        return "";
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(String result) {
        Collections.sort(this.f11636d, new b());
        this.f11635c.a(this.f11636d);
    }
}
