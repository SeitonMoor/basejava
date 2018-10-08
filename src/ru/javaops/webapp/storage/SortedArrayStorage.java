package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int doIndex = index * (-1) - 1;
        System.arraycopy(storage, index, storage, doIndex + 1, size - doIndex);
        storage[doIndex] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int doIndex = size - index - 1;
        if (doIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, doIndex);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
