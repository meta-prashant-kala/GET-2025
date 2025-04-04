import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FolderTest {
    private Folder rootFolder;

    @Before
    public void setUp() {
        rootFolder = new Folder("\\", null);
    }

    @Test
    public void folderCreation() {
        assertEquals("\\", rootFolder.getFolderName());
        assertEquals(null, rootFolder.getParentFolderPath());
        assertNotNull(rootFolder.getTimeStamp());
        assertTrue(rootFolder.getChildFolderList().isEmpty());
    }

    @Test
    public void mkdirCommand() {
        boolean result = rootFolder.mkdirCommand("child1", "\\");
        assertTrue(result);
        assertEquals(1, rootFolder.getChildFolderList().size());
        assertEquals("child1", rootFolder.getChildFolderList().get(0).getFolderName());
    }

    @Test
    public void mkdirCommandDuplicate() {
        rootFolder.mkdirCommand("child1", "\\");
        boolean result = rootFolder.mkdirCommand("child1", "\\");
        assertFalse(result);
        assertEquals(1, rootFolder.getChildFolderList().size());
    }

    @Test
    public void cdCommand() {
        rootFolder.mkdirCommand("child1", "\\");
        Folder childFolder1 = rootFolder.cdCommand("child1");
        Folder childFolder2 = rootFolder.cdCommand("child2");
        assertNotNull(childFolder1);
        assertEquals("child1", childFolder1.getFolderName());
        assertNull(childFolder2);
    }


    @Test
    public void findCommand() {
        rootFolder.mkdirCommand("child1", "\\");
        rootFolder.mkdirCommand("child2", "\\");
        Folder childFolder1 = rootFolder.cdCommand("child1");
        childFolder1.mkdirCommand("innerChild", "\\child1\\");
        rootFolder.findCommand(rootFolder, "innerChild");
    }

    @Test
    public void treeCommand() {
        rootFolder.mkdirCommand("child1", "\\");
        rootFolder.mkdirCommand("child2", "\\");
        Folder childFolder1 = rootFolder.cdCommand("child1");
        childFolder1.mkdirCommand("innerchild", "\\child1\\");
        rootFolder.treeCommand(0, rootFolder);
    }
}