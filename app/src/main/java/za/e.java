package za;

import android.os.AsyncTask;
import com.martian.mibook.data.FileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import je.z0;
import ya.d0;

/* loaded from: classes3.dex */
public class e extends AsyncTask<String, FileInfo, String> {

    /* renamed from: a */
    public c f33727a;

    /* renamed from: b */
    public final String[] f33728b;

    /* renamed from: c */
    public final d0.b f33729c;

    /* renamed from: d */
    public final ArrayList<FileInfo> f33730d = new ArrayList<>();

    public static class a implements Comparator<FileInfo> {
        public /* synthetic */ a(d dVar) {
            this();
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

        public a() {
        }
    }

    public e(String[] strArr, d0.b bVar) {
        this.f33728b = strArr;
        this.f33729c = bVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        b(strArr[0]);
        return "";
    }

    public final void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (this.f33727a == null) {
                this.f33727a = new c(this.f33728b);
            }
            File[] listFiles = file.listFiles(this.f33727a);
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (isCancelled()) {
                    return;
                }
                if (file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles(this.f33727a);
                    if (listFiles2 != null && listFiles2.length > 0) {
                        FileInfo fileInfo = new FileInfo();
                        fileInfo.fileName = file2.getName();
                        fileInfo.filePath = file2.getAbsolutePath();
                        fileInfo.fileSize = listFiles2.length + " 项";
                        fileInfo.fileDate = "MIBOOK_DIRECTORY";
                        fileInfo.isChecked = false;
                        this.f33730d.add(fileInfo);
                    }
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    long h10 = z0.h(file2);
                    FileInfo fileInfo2 = new FileInfo();
                    fileInfo2.fileName = file2.getName();
                    fileInfo2.filePath = absolutePath;
                    fileInfo2.fileSize = z0.b(h10);
                    fileInfo2.fileDate = z0.e(file);
                    fileInfo2.isChecked = false;
                    this.f33730d.add(fileInfo2);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(String str) {
        Collections.sort(this.f33730d, new a());
        this.f33729c.a(this.f33730d);
    }
}
