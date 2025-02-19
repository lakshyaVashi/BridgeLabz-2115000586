class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int maxHistory;
    private int historySize;

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.historySize = 0;
        this.current = new TextState("");
    }

    public void addState(String content) {
        TextState newState = new TextState(content);
        newState.prev = current;
        current.next = newState;
        current = newState;
        historySize++;
        limitHistory();
    }

    private void limitHistory() {
        while (historySize > maxHistory) {
            if (current.prev != null) {
                current.prev = current.prev.prev;
                if (current.prev != null) {
                    current.prev.next = current;
                }
                historySize--;
            }
        }
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        System.out.println("Current State: " + current.content);
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
