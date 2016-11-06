import java.util.ArrayList;
import java.util.Iterator;

public class Answers implements Iterable<String>{
	private int questionID;
	private ArrayList <String> answers = new ArrayList<String>();
	public String getAnswer(int questionNum) {
		return answers.get(questionNum);
	}
	public Answers() {

	}
	public Answers(int questionID) {
		this.questionID = questionID;
		this.addAnswer("Sample answer to question " + Integer.toString(questionID));
		this.addAnswer("Sample answer 2 to question " + Integer.toString(questionID));
	}
	public void addAnswer(String answerText) {
		answers.add(answerText);
	}
	
	public int numAnswers() {
		return answers.size();
	}
	
	@Override
	public Iterator<String> iterator() {
		return answers.iterator();
	}
}
