class Driver extends Car {

    private int carGasLevel = getGasLevel();
    
    public void drive() {
        System.out.println("=====================================");
        if (carGasLevel > 0) { 
        System.out.println("You drive the car.");
        carGasLevel--;
        } else {
            System.out.println("GAME OVER - You ran out of gas!");
        }
        System.out.println("Gas remaining: " + carGasLevel + "/10");
    }

    public void boosters() {
        System.out.println("=====================================");
        if (carGasLevel >= 3) {
        System.out.println("You boost the car.");
        carGasLevel -= 3;
        } else {
            System.out.println("You do not have enough gas to boost!");
        }
        System.out.println("Gas remaining: " + carGasLevel + "/10");
    }

    public void refuel() {
        System.out.println("=====================================");
        if (carGasLevel < 8) {
        System.out.println("You refuel the car.");
        carGasLevel += 2;
        } else {
            System.out.println("You have too much gas already!");
        }
        System.out.println("Gas remaining: " + carGasLevel + "/10");
    }


}