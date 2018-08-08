package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.FunctionInjector;
import function.MyFunction;

@WebServlet("/lambdaservlet")
public class LambdaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyFunction myFunction;

	public LambdaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
		String selection = request.getParameter("option");
		PrintWriter pw = response.getWriter();
		switch (selection) {
		case "camelcase":
			myFunction = FunctionInjector.get("Camel Case");
			break;
		case "uppercase":
			myFunction = FunctionInjector.get("Upper Case");
			break;
		case "countspace":
			myFunction = FunctionInjector.get("Count Spaces");
			break;
		case "palindrome":
			myFunction = FunctionInjector.get("Palindrome Check");
			break;
		case "primecheck":
			myFunction = FunctionInjector.get("Prime Check");
			break;
		case "lexicograph":
			myFunction = FunctionInjector.get("Lexicographical");
			break;
		case "randomstring":
			myFunction = FunctionInjector.get("Random String");
			break;
		case "upperbound":
			myFunction = FunctionInjector.get("Numbers Upper Bound");
			break;
		case "full_permutation":
			myFunction = FunctionInjector.get("Full Permutation");
			break;
		case "partial_permutation":
			myFunction = FunctionInjector.get("Partial Permutation");
			break;
		case "cartesian":
			myFunction = FunctionInjector.get("String Cartesian");
			break;
		}
		String result = myFunction.generate(input);
		pw.println(result);
	}

}
