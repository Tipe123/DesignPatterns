public interface OwnerStrategy {
    boolean isForeign();
    int fee();

    String toString();
}
