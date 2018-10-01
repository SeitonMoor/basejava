package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    public static final Resume KEY = new Resume();

    @Override
    protected void doSave(Resume resume, int index) {
        if (storage[index].compareTo(resume) > 0) {
            System.arraycopy(storage, index, storage, index + 1, size + 1 - index);
            storage[index] = resume;
        }
    }

    @Override
    protected void doDelete(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
