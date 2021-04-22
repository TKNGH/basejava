
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        int i = 0;
        while ((i < storage.length) && (storage[i] != null)) {
            storage[i] = null;
            i++;
            size--;
        }

    }

    void save(Resume r) {
        int i = 0;
        while ((i < storage.length) && (storage[i] != null)) {
            i++;
        }
        storage[i] = r;
        size++;
    }

    /**
     * @return element with uuid, contains only Resumes in storage (without null)
     */
    Resume get(String uuid) {
        int i = 0;
        Resume resume = null;
        boolean isFindResult = false;
        while ((i < storage.length) && (storage[i] != null) && (!isFindResult)) {
            resume = storage[i];
            if (resume.uuid.equals(uuid)) isFindResult = true;
            else {
                i++;
            }
        }
        if (isFindResult) {
            return resume;
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int i = 0;
        boolean isFindResult = false;
        while ((i < storage.length) && (storage[i] != null) && (!isFindResult)) {
            if (storage[i].uuid.equals(uuid)) {
                isFindResult = true;
                storage[i] = null;
                size--;
            } else {
                i++;
            }
        }
        if (isFindResult) {
            while ((i < storage.length - 1) && (storage[i + 1] != null)) {
                storage[i] = storage[i + 1];
                i++;
            }
            storage[i] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int i = 0;
        while ((i < storage.length) && (storage[i] != null)) {
            i++;
        }
        Resume[] resumeInStorage = new Resume[i];
        System.arraycopy(storage, 0, resumeInStorage, 0, i);
        return resumeInStorage;
    }

    int size() {
        return size;
    }
}