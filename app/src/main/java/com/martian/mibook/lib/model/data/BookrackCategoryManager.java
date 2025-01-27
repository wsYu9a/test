package com.martian.mibook.lib.model.data;

import ba.l;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class BookrackCategoryManager {
    public static String ALL_BOOK_CATEGORY = "全部";
    public static String SECRETE_CATEGORY = "私密分类";
    public static String UN_CATEGORY = "未分类";
    private List<String> bookCategories;
    private Map<String, Integer> categoryCounter;

    public /* synthetic */ int lambda$sortCategories$0(String str, String str2) {
        Integer num = getCategoryCounter().get(str);
        Integer num2 = getCategoryCounter().get(str2);
        if (SECRETE_CATEGORY.equalsIgnoreCase(str)) {
            num = -1;
        }
        if (SECRETE_CATEGORY.equalsIgnoreCase(str2)) {
            num2 = -1;
        }
        if (num == null || num2 == null) {
            return 0;
        }
        return num2.intValue() - num.intValue();
    }

    private void reduceCategoryBookSizeInner(String str) {
        Integer num;
        if (l.q(str) || (num = getCategoryCounter().get(str)) == null || num.intValue() <= 0) {
            return;
        }
        if (num.intValue() != 1) {
            getCategoryCounter().put(str, Integer.valueOf(num.intValue() - 1));
        } else {
            getCategoryCounter().remove(str);
            getBookCategories().remove(str);
        }
    }

    public void addBookCategory(String str) {
        Integer num = getCategoryCounter().get(str);
        if (num != null) {
            getCategoryCounter().put(str, Integer.valueOf(num.intValue() + 1));
            return;
        }
        getCategoryCounter().put(str, 1);
        if (getBookCategories().contains(str)) {
            return;
        }
        getBookCategories().add(str);
    }

    public List<String> getBookCategories() {
        if (this.bookCategories == null) {
            this.bookCategories = new ArrayList();
        }
        return this.bookCategories;
    }

    public Map<String, Integer> getCategoryCounter() {
        if (this.categoryCounter == null) {
            this.categoryCounter = new HashMap();
        }
        return this.categoryCounter;
    }

    public void removeCategoryBook(String str) {
        reduceCategoryBookSizeInner(str);
        sortCategories();
    }

    public void sortCategories() {
        if (getBookCategories().isEmpty() || getBookCategories().size() == 1) {
            return;
        }
        Collections.sort(getBookCategories(), new Comparator() { // from class: ub.a
            public /* synthetic */ a() {
            }

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$sortCategories$0;
                lambda$sortCategories$0 = BookrackCategoryManager.this.lambda$sortCategories$0((String) obj, (String) obj2);
                return lambda$sortCategories$0;
            }
        });
    }

    public void updateBookCategory(MiBookStoreItem miBookStoreItem, String str) {
        reduceCategoryBookSizeInner(miBookStoreItem.getDirName());
        addBookCategory(str);
    }
}
