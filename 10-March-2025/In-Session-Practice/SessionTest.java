import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SessionTest {
    

    @Test
    public void add(){
        Session s=new Session();
        assertEquals(10,s.addTest(10,0));
    }
}
