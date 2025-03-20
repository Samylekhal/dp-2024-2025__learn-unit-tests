package fr.anthonyquere.teashop;

public class TeaCup {
    private int currentTemperatureCelsius;
    private Tea tea;
    private boolean isEmpty = true;
    private int steepingStartTime; // in seconds

    // ajoute de l'eau à la tasse et définit la température
    public void addWater(int temperatureCelsius) {
        this.currentTemperatureCelsius = temperatureCelsius;
        this.isEmpty = false;
    }

    // ajoute du thé à la tasse si elle n'est pas vide
    public void addTea(Tea tea) {
        if (isEmpty) {
            throw new IllegalStateException("Cannot add tea to an empty cup!");
        }
        this.tea = tea;
        this.steepingStartTime = getCurrentTimeInSeconds();
    }

    // vérifie si la tasse est prête à être bue (thé infusé et température idéale)
    public boolean isReadyToDrink() {
        if (tea == null || isEmpty) return false;

        int steepingTime = getCurrentTimeInSeconds() - steepingStartTime;
        return steepingTime >= tea.getSteepingTimeSeconds() &&
                isTemperatureIdeal();
    }

    // si la température actuelle est proche de la température idéale (marge de 5°C) du thé alors c'est bon
    private boolean isTemperatureIdeal() {
        return Math.abs(currentTemperatureCelsius - tea.getIdealTemperatureCelsius()) <= 5;
    }

    // Donne le temps actuel en secondes
    private int getCurrentTimeInSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
