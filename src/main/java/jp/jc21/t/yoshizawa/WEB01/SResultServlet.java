package jp.jc21.t.yoshizawa.WEB01;



import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/SResult")
public class SResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = "生姜焼定食";
		try {
			SLanguage result = Sentiment.getLanguage(string);
			ConfidenceScores message = result.documents[0].confidenceScores;
			double negative = message.negative;
			request.setAttribute("negative", negative);
			double neutral = message.neutral;
			request.setAttribute("neutral", neutral);
			double positive = message.positive;
			request.setAttribute("positive", positive);			
			//request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/Sresult.jsp")
				.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request
			.setCharacterEncoding("UTF-8");
		String string = 
			request.getParameter("string");
		try {
			SLanguage result = Sentiment.getLanguage(string);
			ConfidenceScores message = result.documents[0].confidenceScores;
			double negative = message.negative;
			request.setAttribute("negative", negative);
			double neutral = message.neutral;
			request.setAttribute("neutral", neutral);
			double positive = message.positive;
			request.setAttribute("positive", positive);		
			request.setAttribute("string", string);
			request.getRequestDispatcher("/WEB-INF/jsp/Sresult.jsp")
				.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
