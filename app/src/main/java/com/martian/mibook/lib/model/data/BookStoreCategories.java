package com.martian.mibook.lib.model.data;

import android.text.TextUtils;
import com.martian.libsupport.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class BookStoreCategories {
    public static String ALL_BOOK_CATEGORY = "全部书籍";
    public static String BOOK_UNCATEGORIED = "未分类";
    public static String SECRETE_CATEGORY = "私密分类";
    private int allBookSize = 0;
    private int categoriedBookSize = 0;
    private final List<String> bookCategories = new ArrayList();
    private final Map<String, Integer> bookCategoryCounter = new Hashtable();

    private void addBookCategoriesInner(String category) {
        if (TextUtils.isEmpty(category)) {
            category = BOOK_UNCATEGORIED;
        }
        Integer num = this.bookCategoryCounter.get(category);
        if (num != null) {
            this.bookCategoryCounter.put(category, Integer.valueOf(num.intValue() + 1));
        } else {
            this.bookCategoryCounter.put(category, 1);
            if (!this.bookCategories.contains(category)) {
                this.bookCategories.add(category);
            }
        }
        this.categoriedBookSize++;
    }

    /* renamed from: lambda$sortCategories$0 */
    public /* synthetic */ int a(String lhs, String rhs) {
        Integer num = this.bookCategoryCounter.get(lhs);
        Integer num2 = this.bookCategoryCounter.get(rhs);
        if (num == null || num2 == null) {
            return 0;
        }
        return num2.intValue() - num.intValue();
    }

    private void reduceCategoryBookSizeInner(String category) {
        if (TextUtils.isEmpty(category)) {
            category = BOOK_UNCATEGORIED;
        }
        Integer num = this.bookCategoryCounter.get(category);
        if (num == null || num.intValue() <= 0) {
            throw new IllegalStateException("Category book size is zero.");
        }
        if (num.intValue() == 1) {
            this.bookCategoryCounter.remove(category);
            this.bookCategories.remove(category);
        } else {
            this.bookCategoryCounter.put(category, Integer.valueOf(num.intValue() - 1));
        }
        this.categoriedBookSize--;
    }

    public void addBookCategories(String category) {
        this.allBookSize++;
        addBookCategoriesInner(category);
    }

    public void addSecretCategory() {
        if (this.bookCategories.contains(SECRETE_CATEGORY)) {
            return;
        }
        this.bookCategories.add(SECRETE_CATEGORY);
    }

    public void addUnCategory() {
        Integer num;
        if (this.bookCategories.contains(BOOK_UNCATEGORIED) || (num = this.bookCategoryCounter.get(BOOK_UNCATEGORIED)) == null || num.intValue() <= 0) {
            return;
        }
        this.bookCategories.add(BOOK_UNCATEGORIED);
    }

    public void clear() {
        this.bookCategories.clear();
        this.bookCategoryCounter.clear();
        this.allBookSize = 0;
        this.categoriedBookSize = 0;
    }

    public int getAllBookSize() {
        return this.allBookSize;
    }

    public int getAllCategoryBookSize(int position, String category) {
        Integer num;
        if (position == 0) {
            return this.allBookSize;
        }
        if (k.p(category) || (num = this.bookCategoryCounter.get(category)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getAllCategorySize() {
        return getRealCategorySize() + 1;
    }

    public int getCategoriedBookSize() {
        return this.categoriedBookSize;
    }

    public int getCategoryBookSizeWithUncategoried(String category) {
        Integer num = this.bookCategoryCounter.get(category);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getCategoryItem(int position) {
        if (position == 0) {
            return ALL_BOOK_CATEGORY;
        }
        int i2 = position - 1;
        return i2 >= this.bookCategories.size() ? "异常分类" : this.bookCategories.get(i2);
    }

    public String getCategoryItemWithUncategoried(int position) {
        return position >= this.bookCategories.size() ? "异常分类" : this.bookCategories.get(position);
    }

    public int getCategorySizeWithUncategoried() {
        return getRealCategorySize();
    }

    public int getRealCategorySize() {
        return this.bookCategories.size();
    }

    public void removeCategoryBook(String category) {
        this.allBookSize--;
        reduceCategoryBookSizeInner(category);
    }

    public void removeSecretCategory() {
        Integer num = this.bookCategoryCounter.get(SECRETE_CATEGORY);
        if (num == null || num.intValue() <= 0) {
            this.bookCategories.remove(SECRETE_CATEGORY);
        }
    }

    public void removeUnCategory() {
        this.bookCategories.remove(BOOK_UNCATEGORIED);
    }

    public void setAllBookSize(int allBookSize) {
        this.allBookSize = allBookSize;
    }

    public void setCategoriedBookSize(int categoriedBookSize) {
        this.categoriedBookSize = categoriedBookSize;
    }

    public void sortCategories() {
        Collections.sort(this.bookCategories, new Comparator() { // from class: com.martian.mibook.lib.model.data.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BookStoreCategories.this.a((String) obj, (String) obj2);
            }
        });
    }

    public void updateBookCategory(MiBookStoreItem item, String category) {
        if (TextUtils.isEmpty(category)) {
            category = BOOK_UNCATEGORIED;
        }
        reduceCategoryBookSizeInner(item.getDirName());
        addBookCategoriesInner(category);
    }
}
