import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GASTestServlet")
public class GASTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストの文字エンコーディングを設定
        request.setCharacterEncoding("UTF-8");

        // リクエストパラメータを取得
        String title = request.getParameter("title");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String money = request.getParameter("money");
        String memo = request.getParameter("memo");

        // セッションを取得（なければ新規作成）
        HttpSession session = request.getSession(true);

        // セッションからデータリストを取得（なければ新規作成）
        List<String> dataList = null;
        if (session.getAttribute("dataList") instanceof List) {
            dataList = (List<String>) session.getAttribute("dataList");
        }
        if (dataList == null) {
            dataList = new ArrayList<>();
        }

        // データリストに新しいデータを追加
        dataList.add("Title: " + title + ", Start Date: " + startDate + ", End Date: " + endDate + ", Money: " + money + ", Memo: " + memo);

        // データリストをセッションに保存
        session.setAttribute("dataList", dataList);

        // データリストを表示
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<html><body>");
        for (String data : dataList) {
            response.getWriter().println("<p>" + data + "</p>");
        }
        response.getWriter().println("</body></html>");
    }
}
