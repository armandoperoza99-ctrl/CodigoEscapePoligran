package main;

public class Quiz {
	public String question;
    public String[] options;
    public int correctIndex;

    public Quiz(String question, String[] options, int correctIndex) {
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
    }
}
