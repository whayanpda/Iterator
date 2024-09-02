import org.example.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIterator {

    @Test
    public void testVideoIterator() {

        VideoItem[] videoItens = new VideoItem[4];
        videoItens[0] = new VideoItem("Homem-Aranha De Volta Ao Lar", 2.5);
        videoItens[1] = new VideoItem("Casa Do Lago", 1.5);
        videoItens[2] = new VideoItem("Agente 007", 1.5);
        videoItens[3] = new VideoItem("Anjos da Lei", 2.0);


        Iterator videoIterator = new VideoIterator(videoItens);


        assertTrue(videoIterator.hasNext());
        VideoItem item1 = (VideoItem) videoIterator.next();
        assertEquals("Homem-Aranha De Volta Ao Lar", item1.nome);
        assertEquals(2.5, item1.preco);

        assertTrue(videoIterator.hasNext());
        VideoItem item2 = (VideoItem) videoIterator.next();
        assertEquals("Casa Do Lago", item2.nome);
        assertEquals(1.5, item2.preco);

        assertTrue(videoIterator.hasNext());
        VideoItem item3 = (VideoItem) videoIterator.next();
        assertEquals("Agente 007", item3.nome);
        assertEquals(1.5, item3.preco);

        assertTrue(videoIterator.hasNext());
        VideoItem item4 = (VideoItem) videoIterator.next();
        assertEquals("Anjos da Lei", item4.nome);
        assertEquals(2.0, item4.preco);


        assertFalse(videoIterator.hasNext());
    }

    @Test
    public void testIteratorWithEmptyArray() {
        VideoItem[] videoItens = new VideoItem[0];
        Iterator videoIterator = new VideoIterator(videoItens);

        assertFalse(videoIterator.hasNext(), "O iterador não deve ter itens para iterar em um array vazio.");
    }



    @Test
    public void testRepeatedNextCalls() {
        VideoItem[] videoItens = new VideoItem[2];
        videoItens[0] = new VideoItem("Homem-Aranha De Volta Ao Lar", 2.5);
        videoItens[1] = new VideoItem("Casa Do Lago", 1.5);

        Iterator videoIterator = new VideoIterator(videoItens);


        assertTrue(videoIterator.hasNext());
        videoIterator.next();

        assertTrue(videoIterator.hasNext());
        videoIterator.next();


        assertFalse(videoIterator.hasNext());


        assertThrows(ArrayIndexOutOfBoundsException.class, videoIterator::next);
    }

    @Test
    public void testIteratorWithPartiallyFilledArray() {
        VideoItem[] videoItens = new VideoItem[4];
        videoItens[0] = new VideoItem("Homem-Aranha De Volta Ao Lar", 2.5);
        videoItens[1] = new VideoItem("Casa Do Lago", 1.5);

        Iterator videoIterator = new VideoIterator(videoItens);


        assertTrue(videoIterator.hasNext());
        VideoItem item1 = (VideoItem) videoIterator.next();
        assertEquals("Homem-Aranha De Volta Ao Lar", item1.nome);

        assertTrue(videoIterator.hasNext());
        VideoItem item2 = (VideoItem) videoIterator.next();
        assertEquals("Casa Do Lago", item2.nome);


        assertFalse(videoIterator.hasNext());
    }

    @Test
    public void testModificationDuringIteration() {
        VideoItem[] videoItens = new VideoItem[3];
        videoItens[0] = new VideoItem("Homem-Aranha De Volta Ao Lar", 2.5);
        videoItens[1] = new VideoItem("Casa Do Lago", 1.5);
        videoItens[2] = new VideoItem("Agente 007", 1.5);

        Iterator videoIterator = new VideoIterator(videoItens);


        assertTrue(videoIterator.hasNext());
        videoIterator.next();

        assertTrue(videoIterator.hasNext());
        VideoItem item2 = (VideoItem) videoIterator.next();
        assertEquals("Casa Do Lago", item2.nome);


        videoItens[1] = new VideoItem("Anjos da Lei", 2.0);


        assertTrue(videoIterator.hasNext());
        VideoItem item3 = (VideoItem) videoIterator.next();
        assertEquals("Agente 007", item3.nome);
    }
}
