import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements Iterator to be able to iterate over TrainCars.
 *
 * @param <T> which is a generic type representing cargo
 *
 * @author Me, Myself, and I... AKA Devin Fromond
 * @since 11/30/2022
 * @version 1.0.0
 */
public class TrainIterator<T> implements Iterator<T> {

    private TrainCar<T> nextCar;

    /**
     * This constructor takes in a train to iterate through.
     * @param train which is a train that may contain TrainCars or be empty
     */
    public TrainIterator(Train<T> train) {
        if (train == null) {
            throw new IllegalArgumentException("The train is null.");
        }
        nextCar = train.getEngine();
    }

    @Override
    public boolean hasNext() {
        return nextCar != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no further elements in the set.");
        }

        T cargoReturned = nextCar.getCargo();
        nextCar = nextCar.getNextCar();
        return cargoReturned;
    }
}