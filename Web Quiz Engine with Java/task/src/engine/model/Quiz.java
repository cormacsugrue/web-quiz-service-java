package engine.model;

public class Quiz {
    private final int id;
    private final String title;
    private final String text;
    private final String[] options;
    private final int answer;

    public Quiz(int id, String title, String text, String[] options, int answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }
}

