package org.adminServlet;

import entity.Commodity;
import entity.CommodityImage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/admin/CommdFileServlet")
public class CommdFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath()+"/";
        PrintWriter out=response.getWriter();
        boolean ism= ServletFileUpload.isMultipartContent(request);
        if(ism){
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            try {
                List<FileItem> items =upload.parseRequest(request);
                Iterator<FileItem> iter=items.iterator();
                while(iter.hasNext()){
                    FileItem item= iter.next();
                    if(item.isFormField()){

                    }else{
                        String FileName=item.getName();
                        if(FileName!=null && !FileName.equals("")){
                            String uploadFilePath=request.getSession().getServletContext().getRealPath("upload/Commod/");

                            File fullName=null;
                            do{
                                fullName=new File(uploadFilePath,((int)(Math.random()*1000000000))+".png");
                                System.out.println(uploadFilePath+"/"+fullName.getName());
                            }while (fullName.isFile());//判断文件是否存在，如果存在不保存
                            //写出文件
                            System.out.println(fullName.getName());
                            item.write(fullName);
                            out.print("{\"uploaded\":1,\"url\": \"../../upload/Commod/"+fullName.getName()+"\" }");

                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
