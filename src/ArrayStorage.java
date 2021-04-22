
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {

        for (int i = 0; i < size; i++) {
            storage[i] = null;

        }
        size = 0;

    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    /**
     * @return element with uuid, contains only Resumes in storage (without null)
     */
    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            resume = storage[i];
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        boolean isFindResult = false;
        while ((i < size) && (!isFindResult)) {
            if (storage[i].uuid.equals(uuid)) {
                isFindResult = true;
            } else {
                i++;
            }
        }
        if (isFindResult) {
            while (i < size - 1) {
                storage[i] = storage[i + 1];
                i++;
            }
            storage[i] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeInStorage = new Resume[size];
        System.arraycopy(storage, 0, resumeInStorage, 0, size);
        return resumeInStorage;
    }

    int size() {
        return size;
    }
}