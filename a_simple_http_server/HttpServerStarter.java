package bg.httpserver;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerStarter {
    public static void main(String[] args) throws IOException {
        //创建一个HttpServer实例，并绑定到指定的IP地址和端口号
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        //创建一个HttpContext，表示将指定的url路径绑定到指定的HttpHandler处理器对象上，服务器接收到的所有路径请求都将通过调用给定的处理程序对象来处理。
        httpServer.createContext("/myserver", new MyHttpHandler());

        //设置服务器的线程池对象，不设置或者设为null则表示使用start方法创建的线程
        httpServer.setExecutor(Executors.newFixedThreadPool(10));

        //启动服务器
        httpServer.start();
    }
}
