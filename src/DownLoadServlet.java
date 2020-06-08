import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "DownLoadServlet", value = "/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        response.addHeader("content-Type", "application/octet-stream");
        String agent = request.getHeader("User-Agent");
        if (agent.toLowerCase().indexOf("chrome") > 0) {
            response.addHeader("content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO8859-1"));
        } else {
            response.addHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        }
        InputStream in = getServletContext().getResourceAsStream("/DOWNLOAD-SOURCE/" + filename);
        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        out.close();
        in.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}