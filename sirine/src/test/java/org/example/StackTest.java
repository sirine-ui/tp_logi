package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;
    @BeforeEach
    void setup() {
        stack =new Stack();
    }

    @Test//pile n'est pas pleine
    void pushShouldAddElementToTheTopOfTheStack() {
        stack.push(4);
        assertEquals(1,stack.size());
        assertEquals(4,stack.peek());
    }

    @Test
    void pushShouldNotExceedCapacity() {
        for (int i = 0; i < 10; i++) {
            stack.push(4);
        }
        assertEquals(10, stack.size());
        assertThrows(IllegalStateException.class, () -> stack.push(10));
      //  assertEquals(10, stack.size());
        //assertEquals(4, stack.peek());
    }


    @Test//remplissage de la pile : for 0->9
    void popShouldExpandArrayIfStackIsFull() {
        stack.push(10);
        stack.pop();
        assertEquals(10, stack.size());
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void IsEmptyShouldBeTrueIfEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void IsEmptyShouldBeFalseIfNotEmpty() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeekOnNotEmptyStack() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.peek();
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeekOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

}