package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void fillDeletedElement(int index, String uuid) {
        fillDeletedElement(index);
        storage[size + 1] = null;
        size--;
    }

    @Override
    protected void insertObject(int index, Resume resume) {
        insertElement(index, resume);
        size++;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void doUpdate(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    public Resume doGet(int index, String uuid) {
        return storage[index];
    }

    @Override
    public void storageLimitCheck(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("База переполнена!", resume.getUuid());
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}