import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrganicChemistryTest {

    private OrganicChemistry organicChemistry;

    @BeforeEach
    public void initialise() {
        organicChemistry = new OrganicChemistry();
    }

    @Test
    public void isNumber() {
        assertTrue(organicChemistry.isNumber('1'));
        assertTrue(organicChemistry.isNumber('5'));
        assertFalse(organicChemistry.isNumber('C'));
        assertFalse(organicChemistry.isNumber('('));
    }

    @Test
    public void getCompoundWeight() {
        assertEquals(12, organicChemistry.getCompoundWeight('C'));
        assertEquals(16, organicChemistry.getCompoundWeight('O'));
        assertEquals(1, organicChemistry.getCompoundWeight('H'));
    }

    @Test
    public void hasBracket() {
        assertTrue(organicChemistry.hasBracket(0, 5, "CH3(CO)2"));
        assertFalse(organicChemistry.hasBracket(0, 2, "CH3"));
    }

    @Test
    public void getMolecularWeight() {
        assertEquals(15, organicChemistry.getMolecularWeight(0, 2, "CH3"));
        assertEquals(44, organicChemistry.getMolecularWeight(0, 2, "COO"));
    }

    @Test
    public void calculateMolecularWeight() {
        assertEquals(29, organicChemistry.calculateMolecularWeight(0, 3, "C2H5"));
        assertEquals(29, organicChemistry.calculateMolecularWeight(0, 5, "(C2H5)"));
        assertEquals(58, organicChemistry.calculateMolecularWeight(0, 6, "(C2H5)2"));
        assertEquals(85, organicChemistry.calculateMolecularWeight(0, 8, "C2H5(CO)2"));
        assertEquals(46, organicChemistry.calculateMolecularWeight(0, 5, "C(OH)2"));
        assertEquals(255, organicChemistry.calculateMolecularWeight(0, 14, "CH3(CO2(H2O)2)3"));
        assertEquals(176, organicChemistry.calculateMolecularWeight(0, 2, "O11"));
    }
}