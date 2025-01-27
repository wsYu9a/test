package za;

import android.os.AsyncTask;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.data.FileInfoLayer;
import com.martian.mibook.data.TypefaceItem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import je.z0;
import ya.d0;

/* loaded from: classes3.dex */
public class b extends AsyncTask<String, FileInfo, String> {

    /* renamed from: a */
    public c f33721a;

    /* renamed from: b */
    public final String[] f33722b;

    /* renamed from: c */
    public final int f33723c;

    /* renamed from: d */
    public final d0.a f33724d;

    /* renamed from: e */
    public final ArrayList<FileInfo> f33725e;

    public b(ArrayList<FileInfo> arrayList, String[] strArr, int i10, d0.a aVar) {
        this.f33722b = strArr;
        this.f33723c = i10;
        this.f33724d = aVar;
        this.f33725e = arrayList;
    }

    public final void a(File file, LinkedList<FileInfoLayer> linkedList, int i10) {
        String str;
        Path path;
        Path path2;
        boolean isSameFile;
        int i11 = i10 + 1;
        try {
            String n10 = ba.b.n();
            path = Paths.get(file.getAbsolutePath(), new String[0]);
            path2 = Paths.get(n10, new String[0]);
            isSameFile = Files.isSameFile(path, path2);
            if (isSameFile) {
                return;
            }
        } catch (IOException unused) {
        }
        if (this.f33721a == null) {
            this.f33721a = new c(this.f33722b);
        }
        File[] listFiles = file.listFiles(this.f33721a);
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                FileInfoLayer fileInfoLayer = new FileInfoLayer();
                fileInfoLayer.setFile(file2);
                fileInfoLayer.setFileLayer(i11);
                linkedList.add(fileInfoLayer);
            } else {
                try {
                    str = file2.getCanonicalPath();
                } catch (IOException e10) {
                    String absolutePath = file2.getAbsolutePath();
                    e10.printStackTrace();
                    str = absolutePath;
                }
                long h10 = z0.h(file2);
                if (h10 > 5120) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file2.getName();
                    fileInfo.filePath = str;
                    fileInfo.fileSize = z0.b(h10);
                    fileInfo.fileDate = z0.e(file);
                    fileInfo.isChecked = false;
                    publishProgress(fileInfo);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public String doInBackground(String... strArr) {
        e(new File(strArr[0]), this.f33723c);
        return "";
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(String str) {
        this.f33724d.a();
    }

    @Override // android.os.AsyncTask
    /* renamed from: d */
    public void onProgressUpdate(FileInfo... fileInfoArr) {
        super.onProgressUpdate(fileInfoArr);
        if (TypefaceItem.isDefaultTypeface(fileInfoArr[0].filePath)) {
            return;
        }
        this.f33725e.add(fileInfoArr[0]);
        this.f33724d.b();
    }

    public final void e(File file, int i10) {
        String str;
        LinkedList<FileInfoLayer> linkedList = new LinkedList<>();
        a(file, linkedList, 0);
        while (!linkedList.isEmpty() && !isCancelled()) {
            FileInfoLayer removeFirst = linkedList.removeFirst();
            File file2 = removeFirst.getFile();
            int fileLayer = removeFirst.getFileLayer();
            if (fileLayer > i10) {
                return;
            }
            if (file2.isDirectory()) {
                a(file2, linkedList, fileLayer);
            } else {
                try {
                    str = file2.getCanonicalPath();
                } catch (IOException e10) {
                    String absolutePath = file2.getAbsolutePath();
                    e10.printStackTrace();
                    str = absolutePath;
                }
                long h10 = z0.h(file2);
                if (h10 > 5120) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file2.getName();
                    fileInfo.filePath = str;
                    fileInfo.fileSize = z0.b(h10);
                    fileInfo.fileDate = z0.e(file);
                    fileInfo.isChecked = false;
                    publishProgress(fileInfo);
                }
            }
        }
    }
}
