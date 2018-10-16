package ru.javaops.webapp.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorageTest {
    private Storage arrayList = (Storage) new ArrayList<Resume>();
    private static final String UUID_1 = "0";
    private static final String UUID_2 = "1";
    private static final String UUID_3 = "2";
    private static final String UUID_4 = "3";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    protected AbstractStorageTest(List<Resume> arrayList) {
        this.arrayList = (Storage) arrayList;
    }
    @Before
    public void setUp() {
        arrayList.clear();
        arrayList.save(RESUME_1);
        arrayList.save(RESUME_2);
        arrayList.save(RESUME_3);
    }

    @Test
    public void clear() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }
}
