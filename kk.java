public class kk {
    public static void main(String[] args) {
        // Resources available
        int food = 1200;
        int wood = 800;
        int gold = 600;

        // Costs and power
        int[] foodCost = {60, 80, 140};
        int[] woodCost = {20, 10, 0};
        int[] goldCost = {0, 40, 100};
        int[] power = {70, 95, 230};

        // Max possible units
        int maxX = food / foodCost[0]; // 20
        int maxY = Math.min(wood / woodCost[1], gold / goldCost[1]); // min(80, 15) = 15? Wait, but constrained by others
        // Actually, better to loop within bounds
        maxX = 20;
        int maxZ = gold / goldCost[2]; // 6
        maxY = 80; // but will check constraints

        int bestX = 0, bestY = 0, bestZ = 0;
        int maxPower = 0;

        for (int z = 0; z <= maxZ; z++) {
            for (int y = 0; y <= maxY; y++) {
                for (int x = 0; x <= maxX; x++) {
                    int usedFood = x * foodCost[0] + y * foodCost[1] + z * foodCost[2];
                    int usedWood = x * woodCost[0] + y * woodCost[1] + z * woodCost[2];
                    int usedGold = x * goldCost[0] + y * goldCost[1] + z * goldCost[2];
                    if (usedFood <= food && usedWood <= wood && usedGold <= gold) {
                        int currentPower = x * power[0] + y * power[1] + z * power[2];
                        if (currentPower > maxPower) {
                            maxPower = currentPower;
                            bestX = x;
                            bestY = y;
                            bestZ = z;
                        }
                    }
                }
            }
        }

        System.out.println("Optimal solution:");
        System.out.println("Swordsmen: " + bestX);
        System.out.println("Bowmen: " + bestY);
        System.out.println("Horsemen: " + bestZ);
        System.out.println("Maximum Power: " + maxPower);
    }
}