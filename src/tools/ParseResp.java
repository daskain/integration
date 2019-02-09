package tools;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParseResp
 */
@WebServlet("/ParseResp")
public class ParseResp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParseResp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resp = request.getParameter ("Resp");
		HashMap<String, String> map = new HashMap<String, String>();
	    resp = resp.replaceAll("<response>", "");
	    resp = resp.replaceAll("</response>", "");
	    resp = resp.replaceAll("\\</.*?\\>", " ");
	    resp = resp.replaceAll("<", "").replaceAll(">", ":");
	    String[] respArr = resp.split(" ");

	        for (int i = 0; i < respArr.length; i++){
	            String[] buf = respArr[i].split(":");
	            map.put(buf[0], buf[1]);

	    }
	    String[] respStr = {
	    		("OrderId=" + map.get("OrderId") + "_2&"),
	    		("Reqtype=Refund&"),
	    		("TerminalId=" + map.get("TerminalId") + "&"),
	    		("Currency=" + map.get("Currency") + "&"),
	    		("Amount=" + map.get("Amount") + "&"),
	    		("Version=GP20&"),
	    		("RecId=" + map.get("PayId") + "&"),
	    		("ServiceId=" + map.get("ServiceId"))
	            
	    };
	    String str = String.join("", respStr);
	    response.getWriter().println(str);	
		
		
	}

}
