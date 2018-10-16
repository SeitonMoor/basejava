package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected int prepareInsert(Resume resume) {
        return list.indexOf(resume);
    }

    @Override
    protected int prepareInsert(String uuid) {
        return list.indexOf(uuid);
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void insertObject(int index, Resume resume) {
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

    @Override
    protected void storageLimitCheck(Resume resume) {

    }
}
