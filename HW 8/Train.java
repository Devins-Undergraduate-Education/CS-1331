import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a train that represents a list with the start being the engine.
 * This makes no since unless you think abstractly. This hurts my brain. This was not fun
 * until I understood how to think abstractly.
 *
 * @param <T> which is a generic type that represents cargo
 *
 * @author Me, Myself, and I.... AKA Devin Fromond
 * @since 11/30/2022
 * @version 1.0.0
 */
public class Train<T> implements List<T> {

    private TrainCar<T> engine;
    private int size;

    /**
     * This constructor constructs an empty train... which isn't really a train because
     * it's nothing.... think abstractly.
     */
    public Train() {
        engine = null;
        size = 0;
    }

    /**
     * This constructor is used to check if the cargo is null.
     * This should be used when making an array from train... I think.
     * @param cargoArray which is an array of type T elements, or type cargo
     */
    public Train(T[] cargoArray) {
        if (cargoArray == null) {
            throw new IllegalArgumentException("cargoArray cannot be null");
        }
        for (T cargo : cargoArray) {
            if (cargo == null) {
                throw new IllegalArgumentException("cargo cannot be null");
            }
            add(cargo); // keep adding to end
        }
    }

    /**
     * This is a getter to get the engine of a train.
     * @return TrainCar which is the engine of the train that is of type TrainCar
     */
    public TrainCar<T> getEngine() {
        return engine;
    }

    /**
     * This method converts a train to an array containing all cargo from train.
     * @return T[] which is an array containing all cargo from the train.
     */
    public T[] toArray() {
        T[] cargoArray = (T[]) new Object[size];
        if (size == 0) {
            return cargoArray;
        }
        Iterator<T> iterated = this.iterator();
        int i = 0;
        while (iterated.hasNext()) {
            cargoArray[i] = iterated.next();
            i++;
        }
        return cargoArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== TRAIN %d =====\nisEmpty: %s\nsize: %d\nengine: %s\nCHOO CHOO: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (engine == null ? "null" : engine.getCargo())));

        T[] cargo = toArray();
        if (cargo == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < cargo.length - 1; ++i) {
                sb.append(String.format("%s, ", cargo[i])); // append all but last value
            }
            if (cargo.length > 0) {
                sb.append(String.format("%s", cargo[cargo.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element passed in is null.");
        }

        if (size == 0) {
            this.engine = new TrainCar<T>(element);
            size++;
            return;
        }
        TrainCar<T> point = this.getEngine();
        TrainCar<T> addedTrainCar = new TrainCar<T>(element);
        for (int i = 0; i < size - 1; i++) {
            point = point.getNextCar();
        }
        point.setNextCar(addedTrainCar);
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index > size) {
            throw new IndexOutOfBoundsException("passed in index is greater than the size of the train by >1.");
        } else if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        }

        if (index == size) {
            add(element);
            return;
        } else if (index == 0) {
            TrainCar<T> holdingCurrentEngine = this.getEngine();
            TrainCar<T> nextEngine = new TrainCar<T>(element);
            this.engine = nextEngine;
            nextEngine.setNextCar(holdingCurrentEngine);
            size++;
            return;
        }
        TrainCar<T> addedTrainCar = new TrainCar<T>(element);
        TrainCar<T> point = this.getEngine();
        TrainCar<T> temp;
        for (int i = 0; i < index - 1; i++) {
            point = point.getNextCar();
        }
        temp = point.getNextCar();
        point.setNextCar(addedTrainCar);
        addedTrainCar.setNextCar(temp);
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.engine == null) {
            throw new NoSuchElementException("The train is empty. There is no train. CRISIS MODE!!");
        }

        if (this.getEngine().getNextCar() == null) {
            T cargoReturned = this.getEngine().getCargo();
            this.engine = null;
            size--;
            return cargoReturned;
        }
        T cargoReturned = this.getEngine().getNextCar().getCargo();
        this.engine = this.getEngine().getNextCar();
        size--;
        return cargoReturned;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (this.engine == null) {
            throw new NoSuchElementException("The train is empty. There is no train. CRISIS MODE!!");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("You're out of your bounds, partner...");
        }

        if (index == 0) {
            return remove();
        }
        TrainCar<T> point = this.getEngine();
        for (int i = 0; i < index - 1; i++) {
            point = point.getNextCar();
        }
        TrainCar<T> previousCar = point;
        TrainCar<T> toBeRemoved = point.getNextCar();
        T toBeRemovedCargo = toBeRemoved.getCargo();
        if (index == size - 1) {
            previousCar.setNextCar(null);
            size--;
            return toBeRemovedCargo;
        }
        TrainCar<T> nextCar = point.getNextCar().getNextCar();
        previousCar.setNextCar(nextCar);
        size--;
        return toBeRemovedCargo;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        }

        TrainCar<T> point = this.getEngine();
        for (int i = 0; i < size; i++) {
            if (point.getCargo().equals(element)) {
                return remove(i);
            } else if (i != size - 1) {
                point = point.getNextCar();
            }
        }
        throw new IllegalArgumentException("element was not found in the train");
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("You're out of your bounds, partner");
        } else if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        }

        TrainCar<T> point = this.getEngine();
        for (int i = 0; i < index; i++) {
            point = point.getNextCar();
        }
        T replacedCargo = point.getCargo();
        point.setCargo(element);
        return replacedCargo;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("You're out of your bounds, partner");
        }

        Iterator<T> iterated = this.iterator();
        for (int i = 0; i < index; i++) {
            iterated.next();
        }
        return iterated.next();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element passed in is null");
        }

        Iterator<T> iterated = this.iterator();
        while (iterated.hasNext()) {
            if (iterated.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        engine = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        //Funky one liner to manually determine the size below
        //size=0;Iterator<T>test1=this.iterator();while(test1.hasNext()){size++;test1.next();}
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new TrainIterator<T>(this);
    }
}