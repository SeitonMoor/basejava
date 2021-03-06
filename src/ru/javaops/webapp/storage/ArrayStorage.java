package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertObject(int index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(int index, Resume resume) {

    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
