import java.util.ArrayList;

public class AnswerGateway {
	private ArrayList<Answers> answers = new ArrayList<Answers>();
	AnswerGateway() {
		for (int i = 1; i < 4; ++i) {
			Answers a = new Answers(i);
			answers.add(a);
		}
	}
	public Answers getAnswers(int i) {
		return answers.get(i);
	}
	public void addAnswer(int i, String answerText) {
		answers.get(i).addAnswer(answerText);
	}
}
