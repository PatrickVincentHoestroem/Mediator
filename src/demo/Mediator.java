package demo;

import java.util.ArrayList;

public class Mediator {
    private final ArrayList<Command> content;

    public Mediator() {
        this.content = new ArrayList<>();
    }

    public void doNotify(Command sender) {
        System.out.println("Sending Data From: "+sender.getRegion());
        content.stream()
                .filter(n->!(n.getRegion().equals(sender.getRegion())))
                .forEach(n->n.appendData(sender.getData()));
    }

    public void add(Command sender) {
        content.add(sender);
    }

    public void remove(Command sender) {
        content.remove(sender);
    }

    public Command get(String region) {
        for (Command c: content) {
            if (c.getRegion().equals(region)) {
                return c;
            }
        }
        return null;
    }
}
