package assignment2;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;


public class IDLListTest {


    @Test
    void add(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(123);
        test.add(44);
        test.add(22);


        assertEquals("[22, 44, 123]",test.toString());
    }

    @Test
    void addMethod2(){
        IDLList<Integer> test = new IDLList<Integer>();

        test.add(0,1);
        test.add(1,2);
        test.add(2,3);
        test.add(3,4);
        test.add(4,5);


        assertEquals("[1, 2, 3, 4, 5]", test.toString());
    }

    @Test
    void appendMethodTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.append(1);
        test.append(2);
        test.append(3);
        test.append(4);
        test.append(5);

        assertEquals("[1, 2, 3, 4, 5]", test.toString());
    }

    @Test
    void getterTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);

        assertEquals(4, test.get(2));

    }

    @Test
    void headGetterTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(4, test.getHead());

    }

    @Test
    void lastGetterTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(1, test.getLast());
    }

    @Test
    void sizeTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(4, test.size());

    }

    @Test
    void removeHeadTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(4, test.remove());
        assertEquals("[3, 2, 1]", test.toString());
    }

    @Test
    void removeHeadExceptionTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            test.remove();
        });
    }


    @Test
    void removeLastTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(1, test.removeLast());
        assertEquals("[4, 3, 2]", test.toString());

    }

    @Test
    void removeLastExceptionTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(null);
        test.add(2);
        test.add(3);
        test.add(4);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            test.removeLast();
        });
    }


    @Test
    void removeAtTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(3, test.removeAt(1));
        assertEquals("[4, 2, 1]", test.toString());


    }

    @Test
    void removeAtExceptionTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(null);
        test.add(3);
        test.add(4);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            test.removeAt(2);
        });
    }

    @Test
    void removeMethod2test(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(true, test.remove(2));
        assertEquals("[4, 3, 1]", test.toString());
    }

    @Test
    void toStringTest(){
        IDLList<Integer> test = new IDLList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals("[4, 3, 2, 1]", test.toString());
    }













}
