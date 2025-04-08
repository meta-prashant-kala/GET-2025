import java.util.Scanner;

class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {
        OrganicChemistry organicChemistryObj = new OrganicChemistry();
        while (true) {
            System.out.println("Enter the Molecular compound to check");
            String inpuString = scanInput.nextLine();
            boolean isValidOrganicCompound = organicChemistryObj.isValidOrganicCompound(inpuString);
            if (isValidOrganicCompound) {
                try {
                    int molecularWeight = organicChemistryObj.calculateMolecularWeight(0, inpuString.length() - 1,
                            inpuString);
                    System.out.println("Molecular Weight of " + inpuString + " = " + molecularWeight);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            } else {
                System.out.println("Plese enter a valid compound");
                continue;
            }
        }
    }

}