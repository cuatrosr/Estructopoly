package model.binary_test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import model.data_structure.MeLinkedLists;
import javafx.scene.image.ImageView;
import model.objects.Token;

public class MeLinkedListTest {

    private MeLinkedLists<Token> list;
    private ArrayList<Token> array;
    private Token player;

    @Test
    public void test() {

        array = new ArrayList<>();
        list = new MeLinkedLists<>();

        for (int i = 0; i < 1000; i++) {
            player = new Token(new ImageView());

            list.add(player);
            array.add(player);

            assertEquals(player, list.get(i));
            assertEquals(i, list.indexOf(player));
            assertEquals(array.get(i), list.toArray().get(i));

        }

        int size = list.size();

        for (int i = 0; i < 1000; i++) {

            list.remove(0);
            size -= 1;

            assertEquals(size, list.size());

            if (i == 999) {
                assertEquals(null, list.getHead());

            } else {
                assertNotEquals(null, list.get(0));

            }

        }

    }

}
