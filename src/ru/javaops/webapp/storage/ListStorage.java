package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void storageLimitCheck(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        return list.indexOf(resume);
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void fillDeletedElement(int index, String uuid) {
        list.remove(index);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        list.set(index, resume);
    }

    @Override
    protected Resume doGet(int index, String uuid) {
        return list.get(index);
    }
}
