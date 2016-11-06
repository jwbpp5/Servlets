import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Answers")
public class ShowAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnswerGateway answerGateway = new AnswerGateway();
	private String questionID;
	
    public ShowAnswers() {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		questionID = request.getParameter("id");
		System.out.println(questionID);

		out.println("<html>");
		out.println("<body>");
		
		Answers answers = answerGateway.getAnswers(Integer.parseInt(questionID)-1);
		
		for (int i = 0; i < answers.numAnswers(); ++i) {
			out.println("<p> " + (i + 1) + ". " + answers.getAnswer(i) + " </p>");
		}

		out.println("<form method=\"POST\" action=\"Answers\">");
        out.println("<p><input type=\"text\" name=\"theAnswer\" size=\"50\"> <input type=\"submit\" value=\"Add Answer\"></p>");
        out.println("</form>");
        out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String theAnswer = request.getParameter("theAnswer");
        answerGateway.addAnswer(Integer.parseInt(questionID), theAnswer);
        response.sendRedirect("Answers");
		
	}
}
