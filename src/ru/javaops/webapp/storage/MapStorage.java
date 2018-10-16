package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void storageLimitCheck(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        return 0;
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void fillDeletedElement(int index, String uuid) {
        map.remove(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        map.replace(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(int index, String uuid) {
        return map.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }
}
