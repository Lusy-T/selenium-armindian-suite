import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DragAndDropTest {
    @Test
    public void Check()
    {
        DragAndDropPage dragAndDrop = new DragAndDropPage();

        assertEquals("A", dragAndDrop.getAElementText(), "Text is not correct");
        assertEquals("B", dragAndDrop.getBElementText(), "");

        dragAndDrop.dropAndDrag();
        //assertEquals()
    }
}
