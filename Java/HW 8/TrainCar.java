/**
 * This class holds information regarding type TrainCar - specific cars on a train.
 *
 * @param <T> which is a generic type that represents cargo
 *
 * @author Me, Myself, and I... AKA Devin Fromond
 * @since 11/30/2022
 * @version 1.0.0
 */
public class TrainCar<T> {

    private T cargo;
    private TrainCar<T> nextCar;

    /**
     * Getter used to get cargo.
     * @return T which is a generic cargo
     */
    public T getCargo() {
        return cargo;
    }

    /**
     * Setter used to set cargo and check if cargo is null.
     * @param cargo which is a generic T representing the cargo on the train
     */
    public void setCargo(T cargo) {
        if (cargo == null) {
            throw new IllegalArgumentException("Variable cargo is null.");
        }
        this.cargo = cargo;
    }

    /**
     * Getter used to get the next car.
     * @return TrainCar which is an element in the train list
     */
    public TrainCar<T> getNextCar() {
        return nextCar;
    }

    /**
     * Setter used to set the next car.
     * @param nextCar which is of type trainCar
     */
    public void setNextCar(TrainCar<T> nextCar) {
        this.nextCar = nextCar;
    }

    /**
     * Constructor used to create a TrainCar element.
     * @param cargo which is of generic type T
     * @param nextCar which points to the next TrainCar
     */
    public TrainCar(T cargo, TrainCar<T> nextCar) {
        setCargo(cargo);
        setNextCar(nextCar);
    }

    /**
     * Constructor used to create a TrainCar element.
     * @param cargo which is of generic type T.
     */
    public TrainCar(T cargo) {
        this(cargo, null);
    }
}