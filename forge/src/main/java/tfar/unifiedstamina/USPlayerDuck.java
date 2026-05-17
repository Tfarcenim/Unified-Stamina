package tfar.unifiedstamina;

public interface USPlayerDuck {
    void markAsRolling();
    boolean isRolling();
    void update();
    boolean isSuperParrying();

    boolean superParrySuccessful();

    void markSuperParrySuccessful(boolean superParrySuccessful);


    void markSuperParrying();
}
