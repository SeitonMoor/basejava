package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected int size = 0;

    @Override
    public void save(Resume resume) {
        int index = prepareInsert(resume);
        storageExistCheck(resume, index);
        storageLimitCheck(resume);
        insertObject(index, resume);
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = prepareInsert(uuid);
        storageNotExistCheck(uuid, index);
        fillDeletedElement(index, uuid);
        size--;
    }

    @Override
    public void update(Resume resume) {
        int index = prepareInsert(resume);
        storageNotExistCheck(resume.getUuid(), index);
        doUpdate(index, resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = prepareInsert(uuid);
        storageNotExistCheck(uuid, index);
        return doGet(index, uuid);
    }

    public int size() {
        return size;
    }

    void storageExistCheck(Resume resume, int index) {
        if (index != -1) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    void storageNotExistCheck(String uuid, int index) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected int prepareInsert(Resume resume) {
        return getIndex(resume.getUuid());
    }

    protected int prepareInsert(String uuid) {
        return getIndex(uuid);
    }

    public abstract void clear();

    protected abstract void doUpdate(int index, Resume resume);

    protected abstract Resume doGet(int index, String uuid);

    protected abstract void storageLimitCheck(Resume resume);

    protected abstract int getIndex(String uuid);

    protected abstract void insertObject(int index, Resume resume);

    protected abstract void fillDeletedElement(int index, String uuid);
}
