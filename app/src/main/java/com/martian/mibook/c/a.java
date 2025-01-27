package com.martian.mibook.c;

import android.os.AsyncTask;
import com.martian.mibook.application.j0;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.data.FileInfoLayer;
import com.martian.mibook.data.TypefaceItem;
import com.martian.mibook.j.w2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class a extends AsyncTask<String, FileInfo, String> {

    /* renamed from: a */
    private b f11627a;

    /* renamed from: b */
    private final String[] f11628b;

    /* renamed from: c */
    private final int f11629c;

    /* renamed from: d */
    private final j0.a f11630d;

    /* renamed from: e */
    private final ArrayList<FileInfo> f11631e;

    public a(ArrayList<FileInfo> fileInfos, String[] scanTypes, int depth, j0.a fileScanListener) {
        this.f11628b = scanTypes;
        this.f11629c = depth;
        this.f11630d = fileScanListener;
        this.f11631e = fileInfos;
    }

    private void a(File file, LinkedList<FileInfoLayer> linkedList, int count) {
        String str;
        int i2 = count + 1;
        if (this.f11627a == null) {
            this.f11627a = new b(this.f11628b);
        }
        File[] listFiles = file.listFiles(this.f11627a);
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                FileInfoLayer fileInfoLayer = new FileInfoLayer();
                fileInfoLayer.setFile(file2);
                fileInfoLayer.setFileLayer(i2);
                linkedList.add(fileInfoLayer);
            } else {
                try {
                    str = file2.getCanonicalPath();
                } catch (IOException e2) {
                    String absolutePath = file2.getAbsolutePath();
                    e2.printStackTrace();
                    str = absolutePath;
                }
                long h2 = w2.h(file2);
                if (h2 > 10240) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file2.getName();
                    fileInfo.filePath = str;
                    fileInfo.fileSize = w2.b(h2);
                    fileInfo.fileDate = w2.e(file);
                    fileInfo.isChecked = false;
                    publishProgress(fileInfo);
                }
            }
        }
    }

    private void e(File file, int scanDepth) {
        String str;
        LinkedList<FileInfoLayer> linkedList = new LinkedList<>();
        a(file, linkedList, 0);
        while (!linkedList.isEmpty() && !isCancelled()) {
            FileInfoLayer removeFirst = linkedList.removeFirst();
            File file2 = removeFirst.getFile();
            int fileLayer = removeFirst.getFileLayer();
            if (fileLayer > scanDepth) {
                return;
            }
            if (file2.isDirectory()) {
                a(file2, linkedList, fileLayer);
            } else {
                try {
                    str = file2.getCanonicalPath();
                } catch (IOException e2) {
                    String absolutePath = file2.getAbsolutePath();
                    e2.printStackTrace();
                    str = absolutePath;
                }
                long h2 = w2.h(file2);
                if (h2 > 10240) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file2.getName();
                    fileInfo.filePath = str;
                    fileInfo.fileSize = w2.b(h2);
                    fileInfo.fileDate = w2.e(file);
                    fileInfo.isChecked = false;
                    publishProgress(fileInfo);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public String doInBackground(String... params) {
        e(new File(params[0]), this.f11629c);
        return "";
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(String result) {
        this.f11630d.a();
    }

    @Override // android.os.AsyncTask
    /* renamed from: d */
    public void onProgressUpdate(FileInfo... values) {
        super.onProgressUpdate(values);
        if (TypefaceItem.isDefaultTypeface(values[0].filePath)) {
            return;
        }
        this.f11631e.add(values[0]);
        this.f11630d.b();
    }
}
