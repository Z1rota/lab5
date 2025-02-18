package org.example.utility;

import com.thoughtworks.xstream.converters.*;
import com.thoughtworks.xstream.io.*;
import org.example.mainClasses.MusicBand;

import java.util.Stack;

public class StackConverter implements Converter {
    @Override
    public boolean canConvert(Class type) {
        return Stack.class.isAssignableFrom(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Stack<MusicBand> stack = (Stack<MusicBand>) source;
        for (Object item : stack) {
            writer.startNode("item");
            context.convertAnother(item);
            writer.endNode();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Stack<Object> stack = new Stack<>();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            stack.push(context.convertAnother(stack, Object.class));
            reader.moveUp();
        }
        return stack;
    }
}
