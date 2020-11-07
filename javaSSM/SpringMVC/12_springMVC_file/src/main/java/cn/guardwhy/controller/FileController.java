package cn.guardwhy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {
    /***
     * 上传文件(方式1)
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {

        //1.获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();
        //2.如果文件名为空，直接回到首页
        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : " + uploadFileName);
        //3. 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        //4. 如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
        //5. 文件输入流
        InputStream is = file.getInputStream();
        //6. 文件输出流
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));
        //7. 读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        // 8.关闭资源
        os.close();
        is.close();
        // 9.重定向到index页面
        return "redirect:/index.jsp";
    }

    /***
     * 采用file.Transto 来保存上传的文件
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file,
                              HttpServletRequest request) throws IOException {
        //1.上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        //2. 上传文件地址
        System.out.println("上传文件保存地址：" + realPath);
        //3. 通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        // 4.重定向到index页面
        return "redirect:/index.jsp";
    }

    /***
     * 下载资源
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/download")
    public String downloads(HttpServletResponse response,
                            HttpServletRequest request) throws Exception {
        //1. 要下载的图片地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "timg.jpg";
        //2.设置response 响应头
        response.reset();
        //3.字符编码
        response.setCharacterEncoding("UTF-8");
        //4.二进制传输数据
        response.setContentType("multipart/form-data");
        //5.设置响应头
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path, fileName);
        //6.读取文件--输入流
        InputStream input = new FileInputStream(file);
        //7. 写出文件--输出流
        OutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index = 0;
        //8. 执行 写出操作
        while ((index = input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        // 9.关闭资源
        out.close();
        input.close();
        return "ok";
    }
}
