
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private Resume resume;


    void clear() {
        int i = 0;
        int arrayLength = storage.length;
        while ((i < arrayLength) && (storage[i] != null)) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int i = 0;
        int arrayLength = storage.length;
        while ((i < arrayLength) && (storage[i] != null)) {
            i++;
        }
        // storage.fill(Resume,i,i r) ;
        storage[i] = r;

    }

    /**
     * @return element with uuid, contains only Resumes in storage (without null)
     */
    Resume get(String uuid) {
        int arrayLength = storage.length;
        int i = 0;
        boolean isFindResult = false;
        while ((i < arrayLength) && (storage[i] != null) && (!isFindResult)) {
            resume = storage[i];
            if (resume.uuid.equals(uuid)) {
                isFindResult = true;
            } else {
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
        int arrayLength = storage.length;
        int i = 0;
        boolean isFindResult = false;
        while ((i < arrayLength) && (storage[i] != null) && (!isFindResult)) {
            if (storage[i].uuid.equals(uuid)) {
                isFindResult = true;
                storage[i] = null;
            } else {
                i++;
            }
        }
        if (isFindResult) {
            while ((i < arrayLength - 1) && (storage[i + 1] != null)) {
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
        int arrayLength = storage.length;
        while ((i < arrayLength) && (storage[i] != null)) {
            i++;
        }
        Resume[] resumeInStorage = new Resume[i];
        System.arraycopy(storage, 0, resumeInStorage, 0, i);
        return resumeInStorage;
    }

    int size() {
        int i = 0;
        int arrayLength = storage.length;
        while ((i < arrayLength) && (storage[i] != null)) {
            i++;
        }

        return i;
    }
}